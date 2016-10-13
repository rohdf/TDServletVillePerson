//classe métier Person pendant java de person dans la base de donnée SQL

package nsis.bo;

import java.io.Serializable;
import java.util.Calendar;

public class Person implements Serializable {

	//variables locales de la classe
	private static final long serialVersionUID = -1L;
	private int id;
	private int id_city;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Calendar date;

	//assesseur correspondant aux paramètres de la base de donnée
	public void setCity(City city) {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_city() {
		return id_city;
	}

	public void setId_city(int id_city) {
		this.id_city = id_city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return firstName + " " + lastName + ":" + phone + "," + email + ":" + id_city;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public Calendar getdate() {
		return date;
	}

}