package dev.jdti.struts.dao;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class BaseDAO<T extends Serializable> implements AutoCloseable {

	private Class<T> clazz = null;

	private EntityManagerFactory emf = null;

	private EntityManager em = null;

	private EntityTransaction transaction = null;

	@SuppressWarnings("unchecked")
	public BaseDAO(String persistenceUnitName) {
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
		em = emf.createEntityManager();

		//OK, reflection ist ein hack...!
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		this.clazz = (Class<T>) params[0];
	}

	public void create(T entity) {
		try {
			begin();
			em.persist(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}
	

	public List<T> findAll() {
		validateClazz();
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(clazz);
        Root<T> root = cq.from(clazz);
        return em.createQuery(cq.select(root)).getResultList();
    }

    public Long countAll() {
    	validateClazz();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(clazz)));
        return em.createQuery(cq).getSingleResult();
    }

	public T read(Long primaryKey) {
		validateClazz();
		return (T) em.find(clazz, primaryKey);
	}

	public void update(T entity) {
		try {
			begin();
			em.merge(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}

	public void delete(T entity) {
		try {
			begin();
			em.remove(entity);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			throw ex;
		}
	}

	private void begin() {
		validateClazz();
		transaction = em.getTransaction();
		transaction.begin();
	}

	private void validateClazz() {
		if (clazz == null)
			throw new IllegalArgumentException("no clazz given");
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void close() throws Exception {
		System.out.println("calling close()");
		if (em.isOpen() == true)
			em.close();
		if (emf.isOpen() == true)
			emf.close();
	}

	protected EntityManager getEM() {
		return this.em;
	}

	protected void setEm(EntityManager em) {
		this.em = em;
	}

	protected EntityTransaction getTransactionForMock() {
		return getEM().getTransaction();
	}
}
