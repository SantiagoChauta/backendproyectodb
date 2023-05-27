package com.BD2.app.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.dao.ICliente;
import com.BD2.app.models.entity.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
public class ClienteApiRestController {
	
	@Autowired
	ICliente clienteDao;
	
	ObjectMapper mapper;
	
	String response ="";
	
	
	@PostMapping("/insertar")
	public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
		cliente.setIdRepresentante("12345");
		cliente.setTipoIdRepresentante("CC");
		mapper = new ObjectMapper();
		
		if(clienteDao.insertar(cliente)) {
			return Excepciones.getResponse(1);
		}
		return Excepciones.getResponse(0);
	}
	
	@GetMapping("/todos")
	public List<Cliente> buscarTodos(){
		return clienteDao.findAll();
	}
	
}
