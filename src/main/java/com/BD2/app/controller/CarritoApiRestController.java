package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.dao.IPedido;
import com.BD2.app.models.dao.IProducto;
import com.BD2.app.models.entity.Producto;
import com.BD2.app.models.entity.ProductoCarrito;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/carrito")
public class CarritoApiRestController {

	@Autowired
	IPedido pedidoDao;
	
	@Autowired
	IProducto productoDao;
	
	@GetMapping("/listar")
	public List<ProductoCarrito>productosCarrito(){
		return productoDao.productosCarrito(Conexion.password,Conexion.usuario.substring(1,3));
	}
	
}
