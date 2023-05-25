package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Periodo;
import java.util.List;
import java.sql.Date;

public interface IPeriodo {

	public List<Periodo> findAll();
	public Periodo findById(Date idPeriodo);
	public void insertar(Periodo periodo);
}
