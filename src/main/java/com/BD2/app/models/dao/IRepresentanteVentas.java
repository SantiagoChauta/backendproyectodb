package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Representante;
import java.util.List;

public interface IRepresentanteVentas {
	
	public List<Representante> findAll();
	public Representante findById(String numeroDocumento,String tipoDocumento);
	public boolean insertarRepresentante(Representante rep);
	public boolean actualizarRepresentante(Representante rep);
	
}
