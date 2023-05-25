package com.BD2.app.models.entity;

import java.io.Serializable;

public class Cliente {
	
	private String cedula;
	
	private String tipoDocumento;
	
	private String nombre;
	
	private String apellido;

	private String direccion;

	private String telefono;
	
	private String ciudad;
	
	private String email;

	private String idRepresentante;
	
	private String tipoIdRepresentante;
	
	private String idRecomendo;
	
	private String tipoIdRecomendo;
	
	public void print() {
		System.out.println("tipo documento: " +tipoDocumento);
		System.out.println("cedula: " +cedula);
		System.out.println("Nombre: " +nombre);
		System.out.println("apellido: " +apellido);
		System.out.println("direccion: " +direccion);
		System.out.println("telefono: " +telefono);
		System.out.println("ciudad: " +ciudad);
		System.out.println("email: " +email);
		System.out.println("id representante: " +idRepresentante);
		System.out.println("tipo id representante: " +tipoIdRepresentante);
		System.out.println("id recomendo: " +idRecomendo);
		System.out.println("tipo id recomendo: " +tipoIdRecomendo);
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoIdRepresentante() {
		return tipoIdRepresentante;
	}

	public void setTipoIdRepresentante(String tipoIdRepresentante) {
		this.tipoIdRepresentante = tipoIdRepresentante;
	}

	public String getTipoIdRecomendo() {
		return tipoIdRecomendo;
	}

	public void setTipoIdRecomendo(String tipoIdRecomendo) {
		this.tipoIdRecomendo = tipoIdRecomendo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(String idRepresentante) {
		this.idRepresentante = idRepresentante;
	}

	public String getIdRecomendo() {
		return idRecomendo;
	}

	public void setIdRecomendo(String idRecomendo) {
		this.idRecomendo = idRecomendo;
	}

	

}
