package com.BD2.app.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Excepciones {
	
	public static String errorMessage ="error";
	public static int hashCode;
	
	
	
	public static ResponseEntity<String> getResponse(int status) {
		Conexion.cerrarConexion();
		if (status ==1) {
			return ResponseEntity.status(HttpStatus.OK).body(response("Operacion Exitosa"));
		}
		else {
			//LLAVE PRIMARIA YA EXITE
			if(errorMessage.equals("00001")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response("Ya existe la llave primaria"));
			}
			//CONSTRAINT FECHA NACIMIENTO
			if ( errorMessage.equals("02290")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response("Las fecha de contrato no puede ser menor a la de nacimiento"));
			}
			//PRIVILEGIOS INSUFICIENTES Y TABLA O VISTA NO EXITE 
			if(errorMessage.equals("01031") || errorMessage.equals("00942")) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response("No estas autorizado"));
			}		
			//USUARIO O CONTRASEÑA INCORRECTA
			if(errorMessage.equals("01017")) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response("Usuario o contraseña incorrecta"));
			}
			
			System.out.println("El error es "+errorMessage);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
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
