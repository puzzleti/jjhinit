package dev.jdti.struts.dao;

import java.util.List;

import dev.jdti.struts.entities.Person;

public class PersonService {

	private PersonDao personDao = new PersonDao();

	public PersonService() {
		super();
	}

	public List<Person> getAllPersons() {
		return personDao.findAll();
	}
	
	public Person findPersonById(long id) {
		return personDao.read(id);
	}
	
	public void savePerson(Person person) {
		personDao.create(person);
	}
	
	public void deletePerson(Person person) {
		personDao.delete(person);
	}
	
	public void deletePersonById(long id) {
		personDao.deletePersonById(id);
	}
	
	public void updatePerson(Person person) {
		personDao.update(person);
	}
	
}
