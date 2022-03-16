package com.beltWasla.setUp;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static DbPropFileReader dbPropFileReader;
	private static MvnPropFileReader mvnPropFileReader;
	
	private FileReaderManager() {
	}
	
	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }
	 
	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	 }
	 
	 public DbPropFileReader getDBPropReader() {
		 return (dbPropFileReader == null) ? dbPropFileReader = new DbPropFileReader() : dbPropFileReader;
	 }
	 
	 public MvnPropFileReader getMvnPropReader() {
		 return (mvnPropFileReader == null) ? mvnPropFileReader = new MvnPropFileReader() : mvnPropFileReader;
	 }
}
