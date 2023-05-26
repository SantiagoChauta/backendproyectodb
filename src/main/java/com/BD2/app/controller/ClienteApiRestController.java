package com.BD2.app.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.dao.ICliente;
import com.BD2.app.models.entity.Cliente;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
public class ClienteApiRestController {
	
	@Autowired
	ICliente clienteDao;
	
	@PostMapping("/insertar")
	public Cliente registrarCliente(@RequestBody Cliente cliente) {
		cliente.setIdRepresentante("12345");
		cliente.setTipoIdRepresentante("CC");
		if(clienteDao.insertar(cliente)) {
			return cliente;
		}
		return null;
	}
	
	@GetMapping("/todos")
	public List<Cliente> buscarTodos(){
		return clienteDao.findAll();
	}
	
}
