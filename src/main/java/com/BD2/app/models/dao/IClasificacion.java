package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Clasificacion;
import java.util.List;

public interface IClasificacion {
	
	
	public List<Clasificacion> findAll();
	public Clasificacion findById(int idClasificacion);
	
	
	
}
