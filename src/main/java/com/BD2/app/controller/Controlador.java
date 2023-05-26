package com.BD2.app.controller;

import java.sql.Connection;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.BD2.app.models.entity.*;
import com.BD2.app.beans.Conexion;
import com.BD2.app.models.dao.ICategoria;
import com.BD2.app.models.dao.ICliente;
import com.BD2.app.models.dao.IProducto;
import com.BD2.app.models.dao.IRepresentanteVentas;

@Controller
@RequestMapping("")
public class Controlador {


	@Autowired
	ICliente clienteDao;
	
	@Autowired
	IRepresentanteVentas repDao;
		
	@GetMapping("/login")
	public Boolean loginForm(@RequestParam("user") String usuario, @RequestParam("password") String password){
		System.out.println("Llamo al metodo");
		System.out.println("El usuario es: "+usuario+"\nLa contraseña es: "+password);
		if(Conexion.changeConnection(usuario, password)) {
			System.out.println("Entra");
			return true;
		}
		return false;
	}
	
	
	@GetMapping("/registrar")
	public String datosCliente(Model model) {
		Cliente cli = new Cliente();
		model.addAttribute("cliente",cli);
		return "register_customer";
	}
	
	
	@PostMapping("/registrar_r")
	public String registrarRepresentante(Representante rep) {
		String tipoDocManager = Conexion.getUsuario().substring(1,3);
		String numDocManager = Conexion.getUsuario().substring(3);
		Representante manager = repDao.findById(numDocManager, tipoDocManager);
		rep.setEstado("a");
		rep.setIdRegion(manager.getIdRegion());
		rep.setIdPais(manager.getIdPais());
		rep.setIdManager(manager.getCedula());
		rep.setTipoIdManager(manager.getTipoDocumento());
		rep.print();
		
		repDao.insertarRepresentante(rep);
		return "home";
	}
	
	
	
	
	
	
	
	
}
