package com.BD2.app.models.dao;


import java.util.List;


import com.BD2.app.models.entity.Cliente;


public interface ICliente {

	public List<Cliente> findAll();
	public Cliente findById(String id);
	public void insertar(Cliente cl);
	public void actualizar(Cliente cl);
	
}
