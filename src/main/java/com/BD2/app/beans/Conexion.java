package com.BD2.app.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public  class Conexion {

	 public static Connection conexion;
	 
	 public static String usuario;
	 public static String password;
	 public static String URL;
	 
	 
	 public static void getConexion(){
	        
	        try {
	        	String URL="jdbc:oracle:thin:"+usuario+"/"+password+"@localhost:1521:proyectodb";
	            //System.out.println(URL);
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	            conexion = (Connection) DriverManager.getConnection(URL);
	        } catch (Exception e) {
	            Excepciones.errorMessage=e.getMessage();
	            conexion=null;
	        }
	 
	 }
	 
	 public static boolean changeConnection(String user,String pass) {
		 usuario=user;
		 password=pass;
		 getConexion();
		 if (conexion!=null) {
			 try {
				 conexion.close();
			 }catch(SQLException e) {
				 System.out.print(e.getMessage());
			 }
			 return true;
		 }else {
			 return false;
		 }
	 }
	 
	
	 public static void connSystem(){
		 usuario="Admin";
		 password="1234";
		 getConexion();		 
	 }
	 
	 
	
}
