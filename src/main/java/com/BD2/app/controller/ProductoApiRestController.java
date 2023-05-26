package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.dao.IProducto;
import com.BD2.app.models.entity.Producto;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/producto")
public class ProductoApiRestController {

	@Autowired
	private IProducto productodao;
	
	@GetMapping("/productos")
	public List<Producto> productosCategoria(@RequestParam("id_categoria") int id_categoria){
		Conexion.connSystem();
		return productodao.ProductosCategoria(1,1,id_categoria);
	}
}
