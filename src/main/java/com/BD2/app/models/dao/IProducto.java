package com.BD2.app.models.dao;

import java.util.List;

import com.BD2.app.models.entity.Producto;

import com.BD2.app.models.entity.ProductoCarrito;

public interface IProducto {

    public List<Producto> findAll(int id_pais, int id_region);
    
    public Producto findbyId (int id_producto);
    
    public List<Producto> productosCategoria(int pais, int region, int id_categoria);
    
    public List<ProductoCarrito> productosCarrito(String idcliente,String tipodocumento);
  
    
}
