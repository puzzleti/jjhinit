package dev.jdti.struts.action.utils;

import java.util.List;

import dev.jdti.struts.dao.PersonService;
import dev.jdti.struts.entities.Person;

public class DbUtil {

	public static void printAllPersonsFromDB() {
		PersonService personService = new PersonService();
		List<Person> resultList = personService.getAllPersons();
		resultList.forEach((x) -> System.out.printf("- %s - %s %s %n", x.getId(), x.getSurname(), x.getFamilyname()));
	}
	
}
