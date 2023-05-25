package com.BD2.app.models.entity;

import java.sql.Date;

public class Pedido {
	 private int id_pedido;
	    private int total;
	    private float calificacion;
	    private String estado;
	    private Date fecha;
	    private String id_cliente;
	    private String tipo_idcli;

	    public int getId_pedido() {
	        return id_pedido;
	    }
	    public void setId_pedido(int id_pedido) {
	        this.id_pedido = id_pedido;
	    }
	    public int getTotal() {
	        return total;
	    }
	    public void setTotal(int total) {
	        this.total = total;
	    }
	    public float getCalificacion() {
	        return calificacion;
	    }
	    public void setCalificacion(float calificacion) {
	        this.calificacion = calificacion;
	    }
	    public String getEstado() {
	        return estado;
	    }
	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
	    public Date getFecha() {
	        return fecha;
	    }
	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }
	    public String getId_cliente() {
	        return id_cliente;
	    }
	    public void setId_cliente(String id_cliente) {
	        this.id_cliente = id_cliente;
	    }
	    public String getTipo_idcli() {
	        return tipo_idcli;
	    }
	    public void setTipo_idcli(String tipo_idcli) {
	        this.tipo_idcli = tipo_idcli;
	    }
}
