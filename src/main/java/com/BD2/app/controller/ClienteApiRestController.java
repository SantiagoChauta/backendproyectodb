package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.models.dao.ICliente;
import com.BD2.app.models.entity.Cliente;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
public class ClienteApiRestController {
	
	@Autowired
	ICliente clienteDao;
	
	@PostMapping("/insertar")
	public String registrarCliente(Cliente cli) {
		System.out.println("llega");
		cli.print();
		return "exito";
	}
	
	@GetMapping("/todos")
	public List<Cliente> buscarTodos(){
		return clienteDao.findAll();
	}
	
}
