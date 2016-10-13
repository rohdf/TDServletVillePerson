//Classe metier City pendant Java de city dans la base de donnée SQL

package nsis.bo;


public class City {
	//variables locales de City
	 private int id;
	 private String name;
	 private String mayor;
	 private int postalCode;
	 private int id_pays;
	 private int inhab;
	 
	 
	 //assesseurs correspondants aux paramètre de la base de donnée
	 public int getInhab() {
	  return inhab;
	 }

	public void setInhab(int inhab) {
	  this.inhab = inhab;
	 }

	 public int getPays() {
	  return id_pays;
	 }

	 public void setPays(int id_pays) {
	  this.id_pays = id_pays;
	 }
 
	 public int getId() {
	  return id;
	 }

	 public void setId(int id) {
	  this.id = id;
	 }

	 public String getName() {
	  return name;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public String getMayor() {
	  return mayor;
	 }

	 public void setMayor(String mayor) {
	  this.mayor = mayor;
	 }

	 public int getPostalCode() {
	  return postalCode;
	 }

	 public void setPostalCode(int postalCode) {
	  this.postalCode = postalCode;
	 }

	}
