package com.BD2.app.models.dao;

import java.util.List;

import com.BD2.app.models.entity.Pedido;
import com.BD2.app.models.entity.Producto;

public interface IPedido{
    
    public Pedido findbyId (int id_pedido);
    public void insertarPedido (Pedido pedido);
    public void actualizarPedido (Pedido pedido);
    public Boolean pedidoEstado (Producto producto);
    public void nuevoPedido(Producto producto);
    public void insertarPPR (int pedido, Producto producto);
    public void pagar(int calificacion);
    public void factura(int pedido);
    public void eliminar(int producto);
}
