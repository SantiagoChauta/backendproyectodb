package com.BD2.app.models.dao;

import java.util.List;

import com.BD2.app.models.entity.Producto;

public interface IProducto {

    public List<Producto> findAll(int id_pais, int id_region);
    public Producto findbyId (int id_producto);
    
}
