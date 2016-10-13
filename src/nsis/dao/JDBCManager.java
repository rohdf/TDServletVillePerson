package nsis.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nsis.service.ConfigurationService;

public class JDBCManager {

static {
 try {
   Class.forName("com.mysql.jdbc.Driver");
 } catch (ClassNotFoundException e) {
   e.printStackTrace();
 }
}

public static Connection getConnection() throws SQLException {
 return DriverManager.getConnection(
   "jdbc:mysql://"
     + ConfigurationService
       .getProperty(ConfigurationService.SQLHost)
     + "/"
     + ConfigurationService
       .getProperty(ConfigurationService.SQLDatabase),
    ConfigurationService.getProperty(ConfigurationService.SQLUser),
    ConfigurationService
     .getProperty(ConfigurationService.SQLPassword));
}

public static void closeConnectionAndStatement(Connection connection,
   PreparedStatement statement) {
 try {
   statement.close();
   connection.close();
 } catch (Exception e) {
   e.printStackTrace();
 } finally {
  try {
    connection.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
 }
}
}