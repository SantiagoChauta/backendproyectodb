package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.dao.IUsuario;
import com.BD2.app.models.entity.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/usuario")

public class UsuarioApiRestController {

	@Autowired
	IUsuario usuariodao;
	

	@GetMapping("/todos")
	public List<Usuario> buscarTodos(){
		return usuariodao.findAll();
	}
	
	@GetMapping("/conectarse")
	public ResponseEntity<String> loginForm(@RequestParam("user") String usuario, @RequestParam("password") String password){
		ObjectMapper mapper = new ObjectMapper();
		String response ="";
		try {
			 response = mapper.writeValueAsString("true");
		} catch (JsonProcessingException e) {
		}
		if(Conexion.changeConnection(usuario, password)) {
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body( Excepciones.errorMessage);
		}
		
	}
	
}
