package com.BD2.app.models.entity;

public class Categoria {
	private int id_categoria;
    private String nombre;
    private int supercategoria;
    
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSupercategoria() {
        return supercategoria;
    }
    public void setSupercategoria(int supercategoria) {
        this.supercategoria = supercategoria;
    }
}
