package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.dao.ICategoria;
import com.BD2.app.models.entity.Categoria;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/catalogo")
public class CatalogoApiRestController {
	
	@Autowired
	private ICategoria categoriaDao;

	@GetMapping("/supercategorias")
	public List<Categoria> supercategorias(){
		Conexion.connSystem();
		return categoriaDao.Categorias();
	}
	
	@GetMapping("/subcategorias")
	public List<Categoria> subCategorias(@RequestParam("id") int id){
		Conexion.connSystem();
		return categoriaDao.subcategorias(id);
	}
	
}
