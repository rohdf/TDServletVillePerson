//Classe DAO permettant la communication et la manipulation des données de la base SQL person

package nsis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import nsis.bo.Person;
import nsis.exception.MineurException;

public class PersonDAO {
	

	//Méthode de création d'une personne dans la base de donnée SQL
	public void createPerson(Person p) throws SQLException, MineurException{
		 
	  Connection connection = null;

	  PreparedStatement statement = null;
	  
	  	//Création d'une instance de Calendar à la date du actuelle
	  	Calendar now = Calendar.getInstance();
	  	
	  	//on compare la date avec les valeur de la date de naissance de la personne à enregistrer
		int interval=(Year.now().getValue()-p.getdate().get(Calendar.YEAR));
		int interval2=now.get(Calendar.MONTH)-p.getdate().get(Calendar.MONTH);
		int interval3=now.get(Calendar.DAY_OF_MONTH)-p.getdate().get(Calendar.DAY_OF_MONTH);
		boolean condition1=interval<18;
		boolean condition2=interval==18 && interval2<0;
		boolean condition3=interval==18 && interval2==0 && interval3<0;
		
		//on renvoi une exception si la personne à moins de 18 ans
		 if (condition1==true || condition2==true || condition3==true){
			 throw new MineurException("Les personnes de moins de 18 ans ne sont pas autorisées!");
		 }
		 //mise en forme des données pour l'écriture de la requete SQL
		 Calendar date=p.getdate();
		 int an=date.get(Calendar.YEAR);
		 int mois=date.get(Calendar.MONTH)+1;
		 int jour=date.get(Calendar.DAY_OF_MONTH);
		 String stringidcity=Integer.toString(p.getId_city());
		 String lastname=p.getLastName();
		 String firstname=p.getFirstName();
		 String email=p.getEmail();
		 String phone=p.getPhone();

		 //écriture de la requete
		  String strSQL = "INSERT INTO person values ( 0,"+stringidcity+", '"+lastname+"', '"+firstname+"', '"+email+"', '"+phone+"', '"+an+"-"+mois+"-"+jour+"')";
		  //envoi de la requete à la base
		  try {

		   connection = JDBCManager.getConnection();

		   statement = connection.prepareStatement(strSQL);
		   
		   statement.executeUpdate(strSQL);

				   
		  }finally {
			  //fermeture de la connection
			   JDBCManager.closeConnectionAndStatement(connection, statement);

		 }
		  
		  
	}
	
	
	
 public static Person selectById(int person_id) throws SQLException {

  Connection connection = null;

  PreparedStatement statement = null;

  String strSQL = "SELECT firstname, lastname, emails, phone, id_city, date_naissance"

    + " FROM person WHERE id_person=?";



  Person p = new Person();

  try {

   connection = JDBCManager.getConnection();

   statement = connection.prepareStatement(strSQL);

   statement.setInt(1, person_id);



   ResultSet rs = statement.executeQuery();



   if (!rs.next())

    return null;

   int i = 1;

   p.setId(person_id);

   p.setFirstName(rs.getString(i++));

   p.setLastName(rs.getString(i++));

   p.setEmail(rs.getString(i++));

   p.setPhone(rs.getString(i++));

   p.setId_city(rs.getInt(i++));
   
   Calendar cal =Calendar.getInstance();
   cal.setTime(rs.getDate(i++));
   p.setDate(cal);



  } finally {

   JDBCManager.closeConnectionAndStatement(connection, statement);

  }

  return p;

 }



 public static List<Person> selectAllPersons() throws SQLException {

  Connection connection = null;

  PreparedStatement statement = null;

  String strSQL = "SELECT id_person, firstname, lastname, emails, phone, id_city, date_naissance"

    + " FROM person";



  List<Person> list = new ArrayList<Person>();

  try {

   connection = JDBCManager.getConnection();

   statement = connection.prepareStatement(strSQL);



   ResultSet rs = statement.executeQuery();



   while (rs.next()) {

    int i = 1;

    Person p = new Person();

    p.setId(rs.getInt(i++));

    p.setFirstName(rs.getString(i++));

    p.setLastName(rs.getString(i++));

    p.setEmail(rs.getString(i++));

    p.setPhone(rs.getString(i++));

    p.setId_city(rs.getInt(i++));
    
    Calendar cal =Calendar.getInstance();
    cal.setTime(rs.getDate(i++));
    p.setDate(cal);



    list.add(p);

   }

  } finally {

   JDBCManager.closeConnectionAndStatement(connection, statement);

  }

  return list;

 }



 public List<Person> selectByCityId(int id_city) throws SQLException {

  Connection connection = null;

  PreparedStatement statement = null;

  String strSQL = "SELECT id_person, firstname, lastname, emails, phone, id_city, date_naissance"

    + " FROM person WHERE id_city="+id_city;



  List<Person> list = new ArrayList<Person>();

  try {

   connection = JDBCManager.getConnection();

   statement = connection.prepareStatement(strSQL);




   ResultSet rs = statement.executeQuery();



   while (rs.next()) {

    int i = 1;

    Person p = new Person();

    p.setId(rs.getInt(i++));

    p.setFirstName(rs.getString(i++));

    p.setLastName(rs.getString(i++));

    p.setEmail(rs.getString(i++));

    p.setPhone(rs.getString(i++));

    p.setId_city(rs.getInt(i++));
    
    Calendar cal =Calendar.getInstance();
    cal.setTime(rs.getDate(i++));
    p.setDate(cal);



    list.add(p);

   }

  } finally {

   JDBCManager.closeConnectionAndStatement(connection, statement);

  }

  return list;

 }

}