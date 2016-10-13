package nsis.service;


import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

public class ConfigurationService {

private static Properties properties;

public final static String SQLHost = "SQLHost";

public final static String SQLUser = "SQLUser";

public final static String SQLPassword = "SQLPassword";

public final static String SQLDatabase = "SQLDatabase";



public ConfigurationService(String fileName) throws IOException {

  FileInputStream fis = new FileInputStream(fileName);



  properties = new Properties();



  properties.load(fis);

}



public static String getProperty(String property) {

 return properties.getProperty(property);

}

}