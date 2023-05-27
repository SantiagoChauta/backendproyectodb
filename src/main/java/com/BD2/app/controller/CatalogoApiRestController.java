package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.BD2.app.models.dao.ICategoria;
import com.BD2.app.models.dao.IProducto;
import com.BD2.app.models.entity.Categoria;
import com.BD2.app.models.entity.Producto;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/catalogo")
public class CatalogoApiRestController {
	
	@Autowired
	private ICategoria categoriaDao;
	
	@Autowired
	private IProducto productodao;

	@GetMapping("/supercategorias")
	public List<Categoria> supercategorias(){
		return categoriaDao.Categorias();
	}
	
	@GetMapping("/subcategorias")
	public List<Categoria> subCategorias(@RequestParam("id") int id){
		return categoriaDao.subcategorias(id);
	}
	
	
	@GetMapping("/productos")
	public List<Producto> productosCategoria(@RequestParam("id_pais") int id_pais,@RequestParam("id_region") int id_region, @RequestParam("id_categoria") int id_categoria){
		return productodao.productosCategoria(id_pais,id_region,id_categoria);
	}
	
	
	
}
