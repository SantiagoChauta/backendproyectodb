package com.BD2.app.beans;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public  class Conexion {

	 public static Connection conexion;
	 
	 public static String usuario = "admin";
	 public static String password = "1234"; 
	 public static String URL ="jdbc:oracle:thin:admin/1234@localhost:1521:proyectodb";
	 
	 
	 public static void getConexion(){
	        
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            conexion = (Connection) DriverManager.getConnection(URL);
	        } catch (Exception e) {
	            System.err.println("Error: "+e);
	            conexion=null;
	        }
	 
	 }
	 
	 public static boolean changeConnection(String user,String pass) {
		 usuario=user;
		 password=pass;
		 URL= "jdbc:oracle:thin:"+usuario+"/"+password+"@localhost:1521:proyectodb";
		 getConexion();
		 return (conexion!=null)? true:false; 
	 }
	
	 public static void connSystem(){
		 URL = "jdbc:oracle:thin:admin/1234@localhost:1521:proyectodb";
		 getConexion();		 
	 }

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Conexion.usuario = usuario;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Conexion.password = password;
	}

	public static String getURL() {
		return URL;
	}

	public static void setURL(String uRL) {
		URL = uRL;
	}

	public static void setConexion(Connection conexion) {
		Conexion.conexion = conexion;
	}
	 
	 
	
}
