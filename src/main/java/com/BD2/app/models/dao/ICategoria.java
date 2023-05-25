package com.BD2.app.models.dao;

import java.util.List;
import com.BD2.app.models.entity.Categoria;

public interface ICategoria {
	
	public List<Categoria> Categorias();
	public List<Categoria> subcategorias(int supercategoriaid);
    public Categoria findbyId (int id_categoria);
}
