package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.BD2.app.models.dao.IRepresentanteVentas;
import com.BD2.app.models.entity.Cliente;
import com.BD2.app.models.entity.Representante;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
public class ClienteApiRestController {
	
	@Autowired
	ICliente clienteDao;
	
	@Autowired
	IRepresentanteVentas representanteDao;
	
	
	
	@PostMapping("/insertar")
	public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
		
		Representante manager = representanteDao.findById(Conexion.password, Conexion.usuario.substring(1,3));
		
		cliente.setIdRepresentante(manager.getCedula());
		cliente.setTipoIdRepresentante(manager.getTipoDocumento());
		
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
