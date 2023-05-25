package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Pais;
import java.util.List;

public interface IPais {
	
	public List<Pais> findAll();
	public Pais findById(int idPais);
	
}
