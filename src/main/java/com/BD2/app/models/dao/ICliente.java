package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Cliente;

import java.util.List;

public interface ICliente {

	public List<Cliente> findAll();
	public Cliente findById(String id,String tipoDocumento);
	public boolean insertar(Cliente cl);
	public boolean actualizar(Cliente cl);
	
}
