package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Usuario;

@Repository
public class DaoUsuario implements IUsuario{

	private PreparedStatement ps;
	private ResultSet rs;	
	private Connection con;
	
	@Override
	public List<Usuario> findAll() {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario;
		try {
			ps = con.prepareStatement("select USERNAME from all_users");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setUsuario(rs.getString("USERNAME"));
				usuario.setPassword(rs.getString("USERNAME"));
				usuarios.add(usuario);
			}
			
			for(Usuario u:usuarios){
				System.out.println(u.getUsuario());
			}
			
			con.close();
		}catch(Exception e) {
			Excepciones.excepcion=e;
		}
		
		return usuarios;
	}

	@Override
	public Usuario findbyNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
