package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Pais;


@Repository
public class DaoPais implements IPais {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	
	@Override
	public List<Pais> findAll() {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Pais> paises= new ArrayList<>();
		Pais pais;
		try {
			ps = con.prepareStatement("select * from pais");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pais= new Pais();
				pais.setIdPais(rs.getInt("K_IDPAIS"));
				pais.setNombre(rs.getString("N_NOMBRE"));
				paises.add(pais);
			}
			con.close();
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		return paises;
	}

	@Override
	public Pais findById(int idPais) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Pais pais = new Pais();
		try {
			ps = con.prepareStatement("select * from pais where k_idpais="+idPais);
			rs = ps.executeQuery();
			while(rs.next()) {
				pais= new Pais();
				pais.setIdPais(rs.getInt("K_IDPAIS"));
				pais.setNombre(rs.getString("N_NOMBRE"));
			}
			con.close();
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		return pais;
	}

}
