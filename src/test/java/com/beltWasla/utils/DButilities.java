package com.beltWasla.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.BufferedReader;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.jdbc.object.SqlCall;
import org.springframework.jdbc.object.StoredProcedure;

import com.beltWasla.setUp.FileReaderManager;

public class DButilities {

	public static Connection con;
	public static Statement stmt;
	public static StoredProcedure strPro;
	public static SqlCall sqlCall;
	public static ResultSet rs;
	public static ArrayList<String> list;
	public static String sqlString;

	public static void connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Retrieving the data from property file
			String URL = FileReaderManager.getInstance().getDBPropReader().getDbUrl();
			String id = FileReaderManager.getInstance().getDBPropReader().getDbId();
			String pwd = FileReaderManager.getInstance().getDBPropReader().getDbPwd();
			con = DriverManager.getConnection(URL, id, pwd);
			System.out.println("DB connected succefully");
		} catch (Exception e) {
			System.out.println("DB not connected due to wrong credentilas/DB down");
			e.printStackTrace();
		}
	}

	public static void callStoredProcedure(String filePath) {

		connect();
		ScriptRunner sr = new ScriptRunner(con);
		// Creating a reader object
		Reader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			sr.setDelimiter("/");
			sr.setFullLineDelimiter(true);
			sr.setSendFullScript(true);
			sr.runScript(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {
				System.out.println("Unable to close the DB connection");
				e.printStackTrace();
			}
		}
	}

	// This method return only count of row
	public static String getCount(String sql) {

		connect();
		String woid = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				woid = rs.getString(1);
			}
			if (woid == null) {
				woid = "0";
			}
			return woid;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {
				System.out.println("Unable to close the DB connection");
				e.printStackTrace();
			}
		}

	}

	// This method is to delete a row in db
	public static void deleteRowt(String sql1, String sql2, String sql3) {

		connect();
		try {
			stmt = con.createStatement();
			stmt.executeQuery(sql1);
			stmt.executeQuery(sql2);
			stmt.executeQuery(sql3);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {
				System.out.println("Unable to close the DB connection");
				e.printStackTrace();
			}
		}
	}

	// this method returns first column value
	public static String getColumnVal(String sql) {

		connect();
		String woid = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				woid = rs.getString(1);
			}
			if (woid == null) {
				woid = "0";
			}
			return woid;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {
				System.out.println("Unable to close the DB connection");
				e.printStackTrace();
			}
		}
	}

	// this the most generic and optimised query handling method
	// it returns all columns for a single row, returns column name and values
	public static LinkedHashMap<String, String> getAllColumns(String sql) {
		connect();

		LinkedHashMap<String, String> colNameWithValues = new LinkedHashMap<String, String>();
		String colName = null;
		String colValues = null;

		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int colCount = rsmd.getColumnCount();
				for (int i = 1; i <= colCount; i++) {
					colName = rsmd.getColumnName(i);
					colValues = rs.getString(i);
					colNameWithValues.put(colName, colValues);
				}
			}
			for (Map.Entry<String,String> M : colNameWithValues.entrySet()) {
				System.out.println(M.getKey() + ":" + M.getValue());
			}
			return colNameWithValues;
		} catch (SQLException e) {

			e.printStackTrace();
			return colNameWithValues;
		} finally {

			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

	//To run all queries in a file
	public static void executeAllQuery(String[] strDelArray, String[] strInsertArray) {
		connect();

		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			con.setAutoCommit(false);
			for (String delQuery : strDelArray) {
				stmt.addBatch(delQuery);
			}
			stmt.executeBatch();
			con.commit();
			con.setAutoCommit(false);
			for (String insertQuery : strInsertArray) {
				stmt.addBatch(insertQuery);
			}
			stmt.executeBatch();
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {

			e.printStackTrace();
			}
		}
	}

	public static void executeSQLFile(String filePath) {
		connect();
		// Initialise the script runner
		ScriptRunner sr = new ScriptRunner(con);
		// Creating a reader object
		Reader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			// Running the script
			sr.runScript(reader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();
				System.out.println("DB connection closed");
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}
}