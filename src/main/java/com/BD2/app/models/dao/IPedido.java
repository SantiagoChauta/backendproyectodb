package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Pedido;

public interface IPedido {
    
    public Pedido findbyId (int id_pedido);
    public void insertarPedido (Pedido pedido);
    public void actualizarPedido (Pedido pedido);
}
