package com.BD2.app.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Connection;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.entity.Cliente;

@Repository
public class DaoCliente implements ICliente{

	private PreparedStatement ps;
	private ResultSet rs;	
	private Connection con;
	
	@Override
	public List<Cliente> findAll() {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente;
		try {
			ps = con.prepareStatement("select * from cliente");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cliente = new Cliente();
				cliente.setCedula(rs.getString("K_IDCEDULA"));
				cliente.setTipoDocumento(rs.getString("K_TIPODOCUMENTO"));
				cliente.setNombre(rs.getString("N_NOMBRE"));
				cliente.setApellido(rs.getString("N_APELLIDO"));
				cliente.setDireccion(rs.getString("N_DIRECCION"));
				cliente.setTelefono(rs.getString("N_TELEFONO"));
				cliente.setCiudad(rs.getString("N_CIUDAD"));
				cliente.setEmail(rs.getString("N_EMAIL"));
				cliente.setIdRepresentante("FK_IDREPRESENTANTE");
				cliente.setTipoIdRepresentante(rs.getString("FK_TIPOIDREPRESENTANTE"));
				cliente.setIdRecomendo("FK_IDRECOMENDO");
				cliente.setTipoIdRecomendo(rs.getString("FK_TIPOIDRECOMENDO"));
				clientes.add(cliente);
			}
			con.close();
		}catch(Exception e) {
			System.out.println("FFFFFFFFFFFFFFFFFFFFF");
		}
		
		return clientes;
	}

	
	
	@Override
	public Cliente findById(String cedula) {
		Conexion.getConexion();
		con =Conexion.conexion;
		Cliente cliente = new Cliente(); 
		try {
			ps = con.prepareStatement("select * from cliente where k_idcedula = "+cedula);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cliente.setCedula(rs.getString("K_IDCEDULA"));
				cliente.setTipoDocumento(rs.getString("K_TIPODOCUMENTO"));
				cliente.setNombre(rs.getString("N_NOMBRE"));
				cliente.setApellido(rs.getString("N_APELLIDO"));
				cliente.setDireccion(rs.getString("N_DIRECCION"));
				cliente.setTelefono(rs.getString("N_TELEFONO"));
				cliente.setCiudad(rs.getString("N_CIUDAD"));
				cliente.setEmail(rs.getString("N_EMAIL"));
				cliente.setIdRepresentante("FK_IDREPRESENTANTE");
				cliente.setTipoIdRepresentante(rs.getString("FK_TIPOIDREPRESENTANTE"));
				cliente.setIdRecomendo("FK_IDRECOMENDO");
				cliente.setTipoIdRecomendo(rs.getString("FK_TIPOIDRECOMENDO"));
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}



	@Override
	public void insertar(Cliente cl) {
		Conexion.getConexion();
		con =Conexion.conexion;
		
		try {
			
			//System.out.println("Impresion numero 2");
			
			//cl.print(); //                                         1 2 3 4 5 6 7 8 9 10 11 12
			ps = con.prepareStatement("insert into cliente values (?,?,?,?,?,?,?,?,?,?, ?, ?)");
			ps.setString(1, cl.getCedula());
			ps.setString(2, cl.getTipoDocumento());
			ps.setString(3, cl.getNombre());
			ps.setString(4, cl.getApellido());
			ps.setString(5, cl.getDireccion());
			ps.setString(6, cl.getTelefono());
			ps.setString(7, cl.getCiudad());
			ps.setString(8, cl.getEmail());
			ps.setString(9, cl.getIdRepresentante());
			ps.setString(10, cl.getTipoIdRepresentante());
			ps.setString(11, cl.getIdRecomendo());
			ps.setString(12, cl.getTipoIdRecomendo());
			
			System.out.println("Aqui si llega");
			
			int res = ps.executeUpdate();
			
			System.out.println("Se inserto con exito");
			
			String usuario = "U"+cl.getTipoDocumento()+cl.getCedula();			
			String queryUser = "create user "+ usuario +" identified by "+cl.getCedula();
			queryUser+= " default tablespace userdef temporary tablespace usertmp quota 50m on userdef";
			ps = con.prepareStatement(queryUser);
			ps.execute();
			
			Conexion.connSystem();
			con = Conexion.conexion;
			
			String queryRole = "grant r_cliente to "+usuario;
			
			ps = con.prepareStatement(queryRole);
			ps.execute();
			
			con.close();
			con.commit();
			con.close();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}



	@Override
	public void actualizar(Cliente cl) {
		Conexion.getConexion();
		con =Conexion.conexion;
		try {
			ps = con.prepareStatement("update cliente set n_nombre = ?, n_apellido=?, n_direccion=?, n_telefono=?, n_ciudad=?,n_email=?"
					+ "  where k_idcedula =?  and k_tipodocumento=?");
			ps.setString(1, cl.getNombre());
			ps.setString(2, cl.getApellido());
			ps.setString(3, cl.getDireccion());
			ps.setString(4, cl.getTelefono());
			ps.setString(5, cl.getCiudad());
			ps.setString(6, cl.getEmail());
			ps.setString(7, cl.getCedula());
			ps.setString(8, cl.getTipoDocumento());
			ps.executeUpdate();	
			
			con.commit();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
		
}
