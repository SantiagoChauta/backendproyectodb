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
import org.springframework.web.bind.annotation.RequestParam;

import com.BD2.app.models.entity.*;
import com.BD2.app.beans.Conexion;
import com.BD2.app.models.dao.ICategoria;
import com.BD2.app.models.dao.ICliente;
import com.BD2.app.models.dao.IProducto;
import com.BD2.app.models.dao.IRepresentanteVentas;

@Controller
public class Controlador {


	@Autowired
	ICliente clienteDao;
	
	@Autowired
	IRepresentanteVentas repDao;
	
	@Autowired
	ICategoria categoriaDao;
	
	@Autowired
	IProducto productoDao;
	
	@GetMapping({"","/"})
	public String login(Model model) {
		Usuario us = new Usuario();
		model.addAttribute("usuario",us);
		return "login";
	}
	
	@PostMapping("/login")
	public String loginForm(Usuario us){
		if(Conexion.changeConnection(us.getUsuario(), us.getPassword())) {
			System.out.println("Este ok");
			return "home";
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/registrar")
	public String datosCliente(Model model) {
		Cliente cli = new Cliente();
		model.addAttribute("cliente",cli);
		return "register_customer";
	}
	
	@PostMapping("/registrar")
	public String registrarCliente(Cliente cli) {
		cli.setIdRepresentante("12345");
		cli.setTipoIdRepresentante("CC");
		clienteDao.insertar(cli);
		return "home";
	}
	
	@GetMapping("/registrar_r")
	public String datosRepresentante(Model model) {
		Representante rep = new Representante();
		model.addAttribute("representante",rep);
		
		return "register_agent";
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
	
	@GetMapping("/comprar")
	public String comprarProductos(Model model) {
		List<Categoria> categorias = categoriaDao.Categorias();
		List<Categoria> subcategorias = categoriaDao.subcategorias(1);
		List<Producto> productos = productoDao.findAll(1, 1);
		model.addAttribute("categorias",categorias);
		model.addAttribute("subcategorias",subcategorias);
		model.addAttribute("productos",productos);
		return "buy";
	}
	
	@GetMapping("/comprarP") 
	public String selCategoria(@RequestParam("id_categoria") String categoriaId) {
		
		return "";
	}
	
	
	
	
}
