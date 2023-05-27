package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Periodo;

@Repository
public class DaoPeriodo implements IPeriodo {

	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	
	@Override
	public List<Periodo> findAll() {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Periodo> periodos = new ArrayList<>();
		try {
			ps = con.prepareStatement("select * from periodo");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Periodo periodo = new Periodo();
				periodo.setF_inicial(rs.getDate("F_PERIODO_INICO"));
				periodo.setF_final(rs.getDate("F_PERIODO_FINAL"));
				periodos.add(periodo);
			}
			
			con.close();
			
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		return periodos;
	}

	@Override
	public Periodo findById(Date idPeriodo) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Periodo periodo = new Periodo();
		try {
			ps = con.prepareStatement("select * from periodo where f_periodo_inicio ="+ idPeriodo);
			rs = ps.executeQuery();
			while(rs.next()) {	
				periodo.setF_inicial(rs.getDate("F_PERIODO_INICO"));
				periodo.setF_final(rs.getDate("F_PERIODO_FINAL"));
			}
			
			con.close();
			
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		return periodo;
	}

	@Override
	public void insertar(Periodo periodo) {
		Conexion.getConexion();
		con = Conexion.conexion;
		try {
			ps = con.prepareStatement("insert into periodo values (?,?)");
			ps.setDate(1, periodo.getF_inicial());
			ps.setDate(2, periodo.getF_final());

			ps.executeUpdate();

			con.commit();
			con.close();
			
			
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		

	}

}
