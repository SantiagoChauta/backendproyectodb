package com.BD2.app.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Excepciones {
	
	public static String errorMessage ="error";
	public static int hashCode;
	
	
	
	public static ResponseEntity<String> getResponse(int status) {
				
		if (status ==1) {
			return ResponseEntity.status(HttpStatus.OK).body(response("Operacion Exitosa"));
		}
		else {
			if(errorMessage.equals("00001")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response("Ya existe la llave primaria"));
			}
			if ( errorMessage.equals("02290")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response("Las fecha de contrato no puede ser menor a la de nacimiento"));
			}
			if(errorMessage.equals("01031") || errorMessage.equals("00942")) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response("No estas autorizado"));
			}			
			System.out.println("El error es "+errorMessage);
			return ResponseEntity.status(HttpStatus.OK).body("Operacion a");
		}
	}
	
	public static String response(String value) {
		ObjectMapper mapper = new ObjectMapper();
		String res = "";
		try {
			res = mapper.writeValueAsString(value);
		} catch (Exception e) {
		}
		return res;
	}
	
}
