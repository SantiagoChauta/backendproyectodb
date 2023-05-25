package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.entity.Clasificacion;


@Repository
public class DaoClasificacion implements IClasificacion {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	
	@Override
	public List<Clasificacion> findAll() {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Clasificacion> clasificaciones = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from clasificacion");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Clasificacion clasif = new Clasificacion();
				clasif.setIdClasificacion(rs.getShort("K_IDCLASIFICACION"));
				clasif.setTipo(rs.getString("I_TIPO"));
				clasificaciones.add(clasif);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return clasificaciones;
	}

	@Override
	public Clasificacion findById(int idClasificacion) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Clasificacion clasif = new Clasificacion();
		try {
			ps = con.prepareStatement("select * from clasificacion where k_idclasificacion="+idClasificacion);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				clasif.setIdClasificacion(rs.getShort("K_IDCLASIFICACION"));
				clasif.setTipo(rs.getString("I_TIPO"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return clasif;
	}

}
