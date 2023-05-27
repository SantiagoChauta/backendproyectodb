package com.BD2.app.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Excepciones {
	
	public static String errorMessage;
	public static int hashCode;
	
	
	
	public static ResponseEntity<String> getResponse(int status) {
		ObjectMapper mapper = new ObjectMapper();
		String response="";
		
		if (status ==1) {
			try {
				response = mapper.writeValueAsString("Operacion Exitosa");
			} catch (Exception e) {
				
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else {
			try {
				response = mapper.writeValueAsString(errorMessage);
			} catch (Exception e) {
				
			}
			if(errorMessage.equals("00001")|| errorMessage.equals("00942")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
			if(errorMessage.equals("01031")) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
			}			
			System.out.println("El error es "+errorMessage);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}
	
}
