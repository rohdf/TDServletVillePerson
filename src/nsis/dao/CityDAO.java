//classe DAO contenant les méthode permettant de communiquer avec la base de donnée de city

package nsis.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

//imports relatifs aux restes du code d'origin en bas de page 
//import java.util.ArrayList;
//import java.util.List;

import nsis.bo.City;

public class CityDAO {
	//methode permettant de récupérer les informations relatives à une ville dans la base de donnée SQL
	public City getCity(int id_city)   throws SQLException {

		  Connection connection = null;

		  PreparedStatement statement = null;

		  String strSQL = "SELECT id_pays, name, mayor, inhabitants, postalCode FROM city WHERE id_city="+id_city;
		  
		  City city = new City();


		  try {

		   connection = JDBCManager.getConnection();

		   statement = connection.prepareStatement(strSQL);

		   ResultSet rs = statement.executeQuery();

		   while (rs.next()) {

		    
		    
		    city.setPays(rs.getInt(1));
		    
		    city.setName(rs.getString(2));
		    
		    city.setMayor(rs.getString(3));
		    
		    city.setInhab(rs.getInt(4));

		    city.setPostalCode(rs.getInt(5));


		   }

		  } finally {

		   JDBCManager.closeConnectionAndStatement(connection, statement);

		  }

		  return city;

		 }
	
	//Restes deu code d'origine
/* public List<City> selectByCountryId(int id_pays)
   throws SQLException {

  Connection connection = null;

  PreparedStatement statement = null;

  String strSQL = "SELECT name, postalCode " +

  "FROM city WHERE id_pays=?";

  List<City> list = new ArrayList<City>();

  try {

   connection = JDBCManager.getConnection();

   statement = connection.prepareStatement(strSQL);

   statement.setInt(1, id_pays);

   ResultSet rs = statement.executeQuery();

   while (rs.next()) {

    City city = new City();

    city.setName(rs.getString(1));

    city.setPostalCode(rs.getInt(2));

    list.add(city);

   }

  } finally {

   JDBCManager.closeConnectionAndStatement(connection, statement);

  }

  return list;

 }*/

}