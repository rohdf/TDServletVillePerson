//Classe Bean permettant d'envoyer les information d'une personne vers les pages HTML

package nsis.bean;

import java.util.Calendar;

import nsis.bo.Person;

public class PersonBean {    
	 private String firstName, lastName, phone, email;
	 private Calendar date;
	 private int id, id_city;

	 
	 //constructeur
	 public PersonBean(){      
		 this.id=0;
	 }    
	 
	 //constructeur prenant une personne en paramètre
	 public PersonBean(Person p){
		 this.id=0;
		 this.firstName=p.getFirstName();
		 this.lastName=p.getLastName();
		 this.email=p.getEmail();
		 this.phone=p.getPhone();
		 this.date=p.getdate();
		 this.id_city=p.getId_city();
	 }
	
	 //assesseur corespondant aux paramètre de la classe Person
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
	  this.lastName= lastName;   
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
	  this.email= email;   
	 }
	 
	 public Calendar getDate(){
		 return date;
	 }
	 
	 public void setDate(Calendar date){
		 this.date=date;
	 }
	 
	 public int getId(){
		 return id;
	 }
	 
	 public void setId(int id){
		 this.id=id;
	 }
	 
	 public int getId_city(){
		 return id_city;
	 }
	 
	 public void setId_city(int id_city){
		 this.id_city=id_city;
	 }
	 
	}