package com.BD2.app.models.entity;

public class ProductoCarrito {
	private String idCliente;
	private String tipodocumento;
	private int id_producto;                            
	private String nombre_producto;      
	private String foto;                          
	private int cantidad;
	private double precio;             
	private double iva; //                      
	private int id_pais;                
	private int id_region;                                    
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipodocumento() {
		return tipodocumento;
	}
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public int getId_region() {
		return id_region;
	}
	public void setId_region(int id_region) {
		this.id_region = id_region;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	 
}
