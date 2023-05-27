package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Region;

@Repository
public class DaoRegion implements IRegion {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	@Override
	public List<Region> findAll(int idPais) {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Region> regiones = new ArrayList<>();
		Region region;
		try {
			ps = con.prepareStatement("select * from region where fk_idpais ="+idPais);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				region = new Region();
				region.setIdPais(rs.getInt("FK_IDPAIS"));
				region.setIdRegion(rs.getInt("K_IDREGION"));
				region.setNombre(rs.getString("N_NOMBRE"));
				regiones.add(region);
			}
			con.close();
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			System.out.println(e.getMessage());
		}
		
		return regiones;
	}

	@Override
	public Region findById(int idRegion, int idPais) {
		Conexion.getConexion();
		con =Conexion.conexion;
		Region region = new Region();
		try {
			ps = con.prepareStatement("select * from region where k_idregion = "+idRegion+" and fk_idpais="+idPais);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				region.setIdPais(rs.getInt("FK_IDPAIS"));
				region.setIdRegion(rs.getInt("K_IDREGION"));
				region.setNombre(rs.getString("N_NOMBRE"));
			}
			
			con.close();
			
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			System.out.println(e.getMessage());
		}
		
		return region;
	}

}
