package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Cliente;
import com.BD2.app.models.entity.Representante;


@Repository
public class DaoRepresentante implements IRepresentanteVentas {
	
	private PreparedStatement ps;
	private ResultSet rs;	
	private Connection con;
	
	
	@Override
	public List<Representante> findAll() {
		Conexion.connSystem();
		con = Conexion.conexion;
		List<Representante> representantes = new ArrayList<>();
		Representante rep;
		try {
			ps = con.prepareStatement("select * from representante_ventas");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				rep = new Representante();
				rep.setCedula(rs.getString("K_IDCEDULA"));
				rep.setTipoDocumento(rs.getString("K_TIPODOCUMENTO"));
				rep.setNombre(rs.getString("N_NOMBRE"));
				rep.setApellido(rs.getString("N_APELLIDO"));
				rep.setDireccion(rs.getString("N_DIRECCION"));
				rep.setTelefono(rs.getString("N_TELEFONO"));
				rep.setEmail(rs.getString("N_EMAIL"));
				rep.setGenero(rs.getString("I_GENERO"));
				rep.setEstado(rs.getString("I_ESTADO"));
				rep.setF_nacimiento(rs.getDate("F_NACIMIENTO"));
				rep.setF_contrato(rs.getDate("F_CONTRATO"));
				rep.setIdRegion(rs.getInt("FK_IDREGION"));
				rep.setIdPais(rs.getInt("FK_IDPAIS"));
				rep.setIdManager(rs.getString("FK_IDMANAGER"));
				rep.setTipoIdManager(rs.getString("FK_TIPOIDMANAGER"));
				
				representantes.add(rep);
			}
			con.close();
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		return representantes;	}

	@Override
	public Representante findById(String numeroDocumento, String tipoDocumento) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Representante rep = new Representante();
		try {
			ps = con.prepareStatement("select * from representante_ventas where k_idcedula = ? and k_tipodocumento=? ");
			ps.setString(1, numeroDocumento);
			ps.setString(2, tipoDocumento);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				rep.setCedula(rs.getString("K_IDCEDULA"));
				rep.setTipoDocumento(rs.getString("K_TIPODOCUMENTO"));
				rep.setNombre(rs.getString("N_NOMBRE"));
				rep.setApellido(rs.getString("N_APELLIDO"));
				rep.setDireccion(rs.getString("N_DIRECCION"));
				rep.setTelefono(rs.getString("N_TELEFONO"));
				rep.setEmail(rs.getString("N_EMAIL"));
				rep.setGenero(rs.getString("I_GENERO"));
				rep.setEstado(rs.getString("I_ESTADO"));
				rep.setF_nacimiento(rs.getDate("F_NACIMIENTO"));
				rep.setF_contrato(rs.getDate("F_CONTRATO"));
				rep.setIdRegion(rs.getInt("FK_IDREGION"));
				rep.setIdPais(rs.getInt("FK_IDPAIS"));
				rep.setIdManager(rs.getString("FK_IDMANAGER"));
				rep.setTipoIdManager(rs.getString("FK_TIPOIDMANAGER"));
			}
			con.close();
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		return rep;
	}

	@Override
	public boolean insertarRepresentante(Representante rep) {
		Conexion.getConexion();
		con =Conexion.conexion;
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement("insert into representante_ventas values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, rep.getCedula());
			ps.setString(2, rep.getTipoDocumento());
			ps.setString(3, rep.getNombre());
			ps.setString(4, rep.getApellido());
			ps.setString(5, rep.getDireccion());
			ps.setString(6, rep.getTelefono());
			ps.setString(7, rep.getEmail());
			ps.setString(8, rep.getGenero());
			ps.setString(9, rep.getEstado());
			ps.setDate(10, rep.getF_nacimiento());
			ps.setDate(11, rep.getF_contrato());
			ps.setInt(12, rep.getIdRegion());
			ps.setInt(13, rep.getIdPais());
			ps.setString(14, rep.getIdManager());
			ps.setString(15, rep.getTipoIdManager());
			ps.executeUpdate();
			
			String usuario = "R"+rep.getTipoDocumento()+rep.getCedula();			
			String queryUser = "create user "+ usuario +" identified by "+rep.getCedula();
			queryUser+= " default tablespace userdef temporary tablespace usertmp quota 50m on userdef";
			ps = con.prepareStatement(queryUser);
			ps.execute();
			
			Conexion.connSystem();
			con = Conexion.conexion;
			
			String queryRole = "grant r_representante to "+usuario;
			
			System.out.println("Representante insertado con exito");
			ps = con.prepareStatement(queryRole);
			ps.execute();
			
			con.commit();
			con.close();
			
			return true;
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
			
		}
		
		return false;
	}

	@Override
	public boolean actualizarRepresentante(Representante rep) {
		Conexion.getConexion();
		con = Conexion.conexion;
		try {
			ps = con.prepareStatement("update representante_ventas set n_nombre = ?, n_apellido=?, n_direccion=?, n_telefono=?, n_email=?, i_genero=?"
					+ "  where k_idcedula =? and k_tipodocumento = ? ");
			ps.setString(1, rep.getNombre());
			ps.setString(2, rep.getApellido());
			ps.setString(3, rep.getDireccion());
			ps.setString(4, rep.getTelefono());
			ps.setString(5, rep.getEmail());
			ps.setString(6, rep.getGenero());
			ps.setString(7, rep.getCedula());
			ps.setString(8, rep.getTipoDocumento());
			ps.executeUpdate();			
			con.commit();
			con.close();
			return true;
		}catch(Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		return false;
	}
	


}
