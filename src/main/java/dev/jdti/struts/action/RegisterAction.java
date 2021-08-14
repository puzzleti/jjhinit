package dev.jdti.struts.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

import dev.jdti.struts.action.utils.DbUtil;
import dev.jdti.struts.dao.PersonService;
import dev.jdti.struts.entities.Person;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = -7901656822769074405L;

	private static final Logger LOG = LoggerFactory.getLogger(RegisterAction.class);

	private Person personBean;
	private PersonService personService;

	public String execute() throws Exception {
		
		LOG.info("Person initialisiert: {}", personBean.toString());
		savePersonToDb();
		DbUtil.printAllPersonsFromDB();
		
		return SUCCESS;
	}

	public Person getPersonBean() {
		return personBean;
	}

	public void setPersonBean(Person personBean) {
		this.personBean = personBean;
	}

	private void savePersonToDb() {
		personService = new PersonService();
		personService.savePerson(personBean);
	}

	public void validate() {
		if (personBean == null) {
			personBean = new Person("","",0,"");
		}
		
		if (personBean.getSurname().length() == 0) {
			addFieldError("personBean.surname", "First name is required.");
		}

		if (personBean.getFamilyname() .length() == 0) {
			addFieldError("personBean.familyname", "Last name is required.");
		}
		
		if (personBean.getEmail().length() == 0) {
			addFieldError("personBean.email", "Email is required.");
		}

		if (personBean.getAge() < 18) {
			addFieldError("personBean.age", "Age is required and must be 18 or older");
		}
	}

}
