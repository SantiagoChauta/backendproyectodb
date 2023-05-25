package com.BD2.app.models.entity;

import java.sql.Date;

public class Representante {
	
	private String cedula;
	
	private String tipoDocumento;
	
	private String nombre;
	
	private String apellido;

	private String direccion;

	private String telefono;
	
	private String email;
	
	private String genero;
	
	private String estado;
	
	private Date f_nacimiento;
	
	private Date f_contrato;
	
	private int idRegion;
	
	private int idPais;

	private String idManager;
	
	private String tipoIdManager;
	
	public void print() {
		System.out.println("Cedula: "+ cedula);
		System.out.println("tipo Documento: "+ tipoDocumento);
		System.out.println("nombre: "+ nombre);
		System.out.println("apellido: "+ apellido);
		System.out.println("direccion: "+ direccion);
		System.out.println("telefono: "+ telefono);
		System.out.println("email: "+ email);
		System.out.println("genero: "+ genero);
		System.out.println("estado: "+ estado);
		System.out.println("f_nacimiento: "+ f_nacimiento);
		System.out.println("f_contrato: "+ f_contrato);
		System.out.println("id region: "+ idRegion);
		System.out.println("id Pais: "+ idPais);
		System.out.println("id Manager: "+ idManager);
		System.out.println("tipo id Manager: "+ tipoIdManager);
	
	}
	
	
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getF_nacimiento() {
		return f_nacimiento;
	}

	public void setF_nacimiento(Date f_nacimiento) {
		this.f_nacimiento = f_nacimiento;
	}

	public Date getF_contrato() {
		return f_contrato;
	}

	public void setF_contrato(Date f_contrato) {
		this.f_contrato = f_contrato;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getIdManager() {
		return idManager;
	}

	public void setIdManager(String idManager) {
		this.idManager = idManager;
	}

	public String getTipoIdManager() {
		return tipoIdManager;
	}

	public void setTipoIdManager(String tipoIdManager) {
		this.tipoIdManager = tipoIdManager;
	}

	
	
	
}
