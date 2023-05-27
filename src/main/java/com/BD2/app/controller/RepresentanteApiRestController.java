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
import com.BD2.app.models.dao.IRepresentanteVentas;
import com.BD2.app.models.entity.Representante;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/representante")
public class RepresentanteApiRestController {

	@Autowired
	IRepresentanteVentas representanteDao;
	
	@PostMapping("/insertar")
	public ResponseEntity<String> registrarCliente(@RequestBody Representante representante) {
		representante.setEstado("a");
		System.out.println("\n\n\n Antes\n ");
		representante.print();
		
		System.out.println("\n\n El manager es\n");
		Representante manager = representanteDao.findById("12345", "CC");
		manager.print();
		representante.setIdRegion(manager.getIdRegion());
		representante.setIdPais(manager.getIdPais());
		representante.setIdManager(manager.getCedula());
		representante.setTipoIdManager(manager.getTipoDocumento());
		System.out.print("\n\n\n Despues\n");
		representante.print();
		if(representanteDao.insertarRepresentante(representante)) {
			System.out.println("es true");
			return Excepciones.getResponse(1);
		}
		return Excepciones.getResponse(0);
	}
	
	@GetMapping("/todos")
	public List<Representante> buscarTodos(){
		return representanteDao.findAll();
	}
	
}
