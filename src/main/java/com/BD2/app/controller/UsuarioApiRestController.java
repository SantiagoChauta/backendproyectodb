package com.BD2.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BD2.app.models.dao.IUsuario;
import com.BD2.app.models.entity.Usuario;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/usuario")

public class UsuarioApiRestController {

	@Autowired
	IUsuario usuariodao;
	
	@GetMapping("/todos")
	public List<Usuario> buscarTodos(){
		return usuariodao.findAll();
	}
}
