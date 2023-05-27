package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.entity.Producto;


@Repository
public class DaoProducto implements IProducto {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	@Override
	public Producto findbyId(int id_producto) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Producto producto = new Producto();

		try {
			ps = con.prepareStatement("select * from catalogo where id_producto=?");
			ps.setInt(1, id_producto);
			rs = ps.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt("ID_PRODUCTO"));
				producto.setNombre_producto(rs.getString("NOMBRE_PRODUCTO"));
				producto.setFoto(rs.getString("FOTO"));
				producto.setDescripcion(rs.getString("DESCRIPCION"));
				producto.setPrecio(rs.getDouble("Precio"));
				producto.setIva(rs.getDouble("IVA"));
				producto.setId_categoria(rs.getInt("ID_CATEGORIA"));
				producto.setCategoria(rs.getString("CATEGORIA"));
				producto.setStock(rs.getInt("STOCK"));
				producto.setId_region(rs.getInt("ID_REGION"));
				producto.setRegion(rs.getString("REGION"));
				producto.setId_pais(rs.getInt("ID_PAIS"));
				producto.setPais(rs.getString("PAIS"));
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return producto;
	}

	@Override
	public List<Producto> findAll(int pais, int region) {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Producto> productos = new ArrayList<>();

		Producto producto;

		try {
			ps = con.prepareStatement("select * from catalogo where id_pais=? and id_region=?");
			ps.setInt(0,pais);
			ps.setInt(1, region);
			rs = ps.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt("ID_PRODUCTO"));
				producto.setNombre_producto(rs.getString("NOMBRE_PRODUCTO"));
				producto.setFoto(rs.getString("FOTO"));
				producto.setDescripcion(rs.getString("DESCRIPCION"));
				producto.setPrecio(rs.getDouble("Precio"));
				producto.setIva(rs.getDouble("IVA"));
				producto.setId_categoria(rs.getInt("ID_CATEGORIA"));
				producto.setCategoria(rs.getString("CATEGORIA"));
				producto.setStock(rs.getInt("STOCK"));
				producto.setId_region(rs.getInt("ID_REGION"));
				producto.setRegion(rs.getString("REGION"));
				producto.setId_pais(rs.getInt("ID_PAIS"));
			}

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return productos;
	}

	public List<Producto> ProductosCategoria(int pais, int region, int id_categoria) {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Producto> productos = new ArrayList<>();

		Producto producto;
		System.out.println("Llega al llamado");
		try {
			ps = con.prepareStatement("select * from catalogo where id_pais=? and id_region=? and id_categoria=?");
			ps.setInt(1,pais);
			ps.setInt(2, region);
			ps.setInt(3,id_categoria);
			rs = ps.executeQuery();
			int iteracion=0;
			while (rs.next()) {
				producto = new Producto();
				producto.setId_producto(rs.getInt("ID_PRODUCTO"));
				producto.setNombre_producto(rs.getString("NOMBRE_PRODUCTO"));
				producto.setFoto(rs.getString("FOTO"));
				producto.setDescripcion(rs.getString("DESCRIPCION"));
				producto.setPrecio(rs.getDouble("Precio"));
				producto.setIva(rs.getDouble("IVA"));
				producto.setId_categoria(rs.getInt("ID_CATEGORIA"));
				producto.setCategoria(rs.getString("CATEGORIA"));
				producto.setId_supercategoria(rs.getInt("ID_SUPERCATEGORIA"));
				producto.setStock(rs.getInt("STOCK"));
				producto.setId_region(rs.getInt("ID_REGION"));
				producto.setRegion(rs.getString("REGION"));
				producto.setId_pais(rs.getInt("ID_PAIS"));
				producto.setPais(rs.getString("PAIS"));
				iteracion++;
				productos.add(producto);
			}
			System.out.println(iteracion);

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return productos;
	}
}
