package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Categoria;

@Repository
public class DaoCategoria implements ICategoria {

	private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;

    @Override
    public List<Categoria> Categorias() {
        Conexion.getConexion();
        con = Conexion.conexion;
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria;
        try {
            ps = con.prepareStatement("Select * from Categoria where fk_supercategoria_id is null");

            rs = ps.executeQuery();

            while(rs.next()){
                categoria = new Categoria();
                categoria.setId_categoria(rs.getInt("K_IDCATEGORIA"));
                categoria.setNombre(rs.getString("N_NOMBRE"));
                categorias.add(categoria);
            }

            con.commit();
            con.close();

        } catch (SQLException e) {
        	Excepciones.errorMessage = e.getMessage().substring(4,9);;
			System.out.println(e.getMessage());
        }

        return categorias;
    }
    

	@Override
	public List<Categoria> subcategorias(int supercategoriaid) {
		 	Conexion.getConexion();
	        con = Conexion.conexion;
	        try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        List<Categoria> categorias = new ArrayList<>();
	        Categoria categoria;
	   
	        try {
	            ps = con.prepareStatement("select * from Categoria where fk_supercategoria_id =?");
	            ps.setInt(1, supercategoriaid);
	            rs = ps.executeQuery();

	            while(rs.next()){
	                categoria = new Categoria();
	                categoria.setId_categoria(rs.getInt("K_IDCATEGORIA"));
	                categoria.setNombre(rs.getString("N_NOMBRE"));
	                categoria.setSupercategoria(rs.getInt("FK_SUPERCATEGORIA_ID"));
	                categorias.add(categoria);
	            }

	            con.commit();
	            con.close();

	        } catch (Exception e) {
	        	Excepciones.errorMessage = e.getMessage().substring(4,9);;
				System.out.println(e.getMessage());
	        }

	        return categorias;
	}

    @Override
    public Categoria findbyId(int id_categoria) {
        Conexion.getConexion();
        con = Conexion.conexion;
        Categoria categoria = new Categoria();

        try {
            ps = con.prepareStatement("select * from Categoria where k_idcategoria =" + id_categoria);
            rs = ps.executeQuery();

            while (rs.next()) {
                categoria.setId_categoria(rs.getInt("K_IDCATEGORIA"));
                categoria.setNombre(rs.getString("N_NOMBRE"));
                categoria.setSupercategoria(rs.getInt("FK_SUPERCATEGORIA"));
            }
            con.commit();
            con.close();
        } catch (Exception e) {
        	Excepciones.errorMessage = e.getMessage().substring(4,9);;
			System.out.println(e.getMessage());
        }

        return categoria;
    }

}
