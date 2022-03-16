package com.beltWasla.setUp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MvnPropFileReader {
	
	private Properties Mvnprop;
	private final String propertyFilePath= "src//test//resources//properties//mvn.properties";

	public MvnPropFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			Mvnprop = new Properties();
			try { Mvnprop.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("DBprop file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}
	}
	
	public String getEnv(){
	//	String env = Mvnprop.getProperty("env");
		String env = System.getProperty("appln.env");
		if(env!= null) return env;
		else throw new RuntimeException("env not specified in the mvn.properties file for the Key:env");		
	}
	
	public String getUserId(){
		//	String env = Mvnprop.getProperty("env");
			String uid = System.getProperty("appln.uid");
			if(uid!= null) return uid;
			else throw new RuntimeException("User ID not specified in the mvn.properties file for the Key:uid");		
		}
	
	public String getPassword(){
		//	String env = Mvnprop.getProperty("env");
			String pwd = System.getProperty("appln.pwd");
			if(pwd!= null) return pwd;
			else throw new RuntimeException("Password not specified in the mvn.properties file for the Key:pwd");		
		}

}
