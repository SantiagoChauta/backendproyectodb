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
			ps = con.prepareStatement("select * from Pedido where k_idpedido =?");
			ps.setInt(1, id_producto);
			rs = ps.executeQuery();

			while (rs.next()) {
				producto.setId_categoria(rs.getInt("FK_CATEGORIA"));
				producto.setNombre(rs.getString("N_NOMBRE"));
				producto.setFoto(rs.getString("N_FOTO"));
				producto.setDescripcion(rs.getString("N_DESCRIPCION"));
				producto.setIva(rs.getInt("T_IVA"));
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
			ps = con.prepareStatement(
					"Select * from producto p, producto_region pr,region r where p.k_idproducto = pr.fk_producto and r.k_idregion=pr.fk_region and r.fk_idpais=pr.fk_pais and r.k_idregion="
							+ region + " and r.fk_idpais=" + pais);

			rs = ps.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId_categoria(rs.getInt("K_IDPRODUCTO"));
				producto.setId_categoria(rs.getInt("FK_IDCATEGORIA"));
				producto.setNombre(rs.getString("N_NOMBRE"));
				producto.setDescripcion(rs.getString("N_DESCRIPCION"));
				producto.setIva(rs.getInt("T_IVA"));
				producto.setPrecio(rs.getDouble("V_PRECIO"));
				producto.setStock(rs.getInt("Q_STOCK"));
				productos.add(producto);
			}

			con.commit();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return productos;
	}

}
