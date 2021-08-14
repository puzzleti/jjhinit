package dev.jdti.struts.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = -2588598900845750573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "surname")
	private String surname;

	@Column(name = "familyname")
	private String familyname;

	@Column(name = "email")
	private String email = " ";

	@Column(name = "age")
	private int age = 0;

	public Person() {
		super();
	}

	public Person(String surname, String familyname, int age) {
		this.surname = surname;
		this.familyname = familyname;
		this.age = age;
	}

	public Person(String surname, String familyname, int age, String email) {
		this.setId(id);
		this.surname = surname;
		this.familyname = familyname;
		this.age = age;
		this.email = email;
	}
	
	public Person(long id, String surname, String familyname, int age) {
		this.setId(id);
		this.surname = surname;
		this.familyname = familyname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFamilyname() {
		return familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", surname=" + surname + ", familyname=" + familyname + ", email=" + email
				+ ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, email, familyname, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(email, other.email) && Objects.equals(familyname, other.familyname)
				&& Objects.equals(surname, other.surname);
	}

}