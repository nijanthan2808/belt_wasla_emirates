package com.beltWasla.setUp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class DbPropFileReader {	
	private Properties DBprop;
	private final String propertyFilePath= "src//test//resources//properties//DB.properties";

	public DbPropFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			DBprop = new Properties();
			try { DBprop.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("DBprop file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}
	}
	
	public String getDbUrl(){
		String dbUrl = DBprop.getProperty("DBURL");
		if(dbUrl!= null) return dbUrl;
		else throw new RuntimeException("DB URL not specified in the DB.properties file for the Key:DBURL");		
	}
	
	public String getDbId(){
		String dbId = DBprop.getProperty("id");
		if(dbId!= null) return dbId;
		else throw new RuntimeException("DB id not specified in the DB.properties file for the Key:id");		
	}
	
	public String getDbPwd(){
		String dbPwd = DBprop.getProperty("pwd");
		if(dbPwd!= null) return dbPwd;
		else throw new RuntimeException("DB pwd not specified in the DB.properties file for the Key:pwd");		
	}
	
	
	
	
}
