package com.BD2.app.models.dao;

import com.BD2.app.models.entity.Region;
import java.util.List;

public interface IRegion {
	
	public List<Region> findAll(int idPais);
	public Region findById(int idRegion,int idPais);
	
	
}
