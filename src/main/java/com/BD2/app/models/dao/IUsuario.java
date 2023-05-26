package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Usuario;

import java.util.List;

public interface IUsuario {

	public List<Usuario> findAll();
	public Usuario findbyNombre();
}
