//Classe bean permettant de transferer les informations relative à une ville aux pages HTML

package nsis.bean;

import java.util.Calendar;
import java.util.List;

import nsis.bo.City;
import nsis.bo.Person;

public class CityBean {
	//variables locales de la classe
	 private int id;
	 private String name;
	 private String mayor;
	 private int postalCode;
	 private List<Person> listPerson;
	 
	 //constructeur de base
	 public CityBean(){
		 
	 }
	 
	 //constructeur entrant un objet de la classe City en paramètre
	 public CityBean(City c){
		 this.id=c.getId();
		 this.name=c.getName();
		 this.mayor=c.getMayor();
		 this.postalCode=c.getPostalCode();
		 
		 
	 }
	 
	 //Assesseur des paramètre propre à la classe City
	 public int getId(){
		 return id;
	 }
	 
	 public void setId(int id){
		 this.id=id;
	 }
	 
	 public String getName(){
		 return name;
	 }
	 
	 public void setName(String name){
		 this.name=name;
	 }
	 
	 public String getMayor(){
		 return mayor;
	 }
	 
	 public void setMayor(String mayor){
		 this.mayor=mayor;
	 }
	 
	 public int getPostalCode(){
		 return postalCode;
	 }
	 
	 public void setPostalCode(int postalCode){
		 this.postalCode=postalCode;
	 }
	 
	 //assesseur de la liste de person renvoyer par le méthode selectByCityId de PersonDAO
	 public void setList(List<Person> listPerson){
		 this.listPerson=listPerson;
	 }
	 
	 public List<Person> getList(){
		 return listPerson;
	 }
	 
	 //Assesseur des parametres de la liste de Person
	 public int getListSize(){
		 return listPerson.size();
	 }
	 
	 public String getPersonInfo(int i){
		 Person p= listPerson.get(i);
		 String info= p.getFirstName()+" "+p.getLastName()+", mail :"+p.getEmail()+", tel :"+p.getPhone()+", date de naissance :"+p.getdate().get(Calendar.DAY_OF_MONTH)+"/"+p.getdate().get(Calendar.MONTH)+"/"+p.getdate().get(Calendar.YEAR);
		return info;
	 }
	 
	 public String getPersonFirstName(int i){
		 Person p= listPerson.get(i);
		 String info= p.getFirstName();
		 return info;
		 
	 }
	 
	 public String getPersonLastName(int i){
		 Person p= listPerson.get(i);
		 String info= p.getLastName();
		 return info;
		 
	 }
	 
	 public String getPersonDate(int i){
		 Person p= listPerson.get(i);
		 String info= p.getdate().get(Calendar.DAY_OF_MONTH)+"/"+(p.getdate().get(Calendar.MONTH)+1)+"/"+p.getdate().get(Calendar.YEAR);
		 return info;
		 
	 }
	 
	 public String getPersonEmail(int i){
		 Person p= listPerson.get(i);
		 String info= p.getEmail();
		 return info;
		 
	 }
	 
	 public String getPersonPhone(int i){
		 Person p= listPerson.get(i);
		 String info= p.getPhone();
		 return info;
		 
	 }
	 
	 
	 public boolean PersonListEmpty(){
		 
		 return listPerson.isEmpty(); 
	 }
	 
}
