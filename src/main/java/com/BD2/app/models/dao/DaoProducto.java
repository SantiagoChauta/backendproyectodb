package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Producto;
import com.BD2.app.models.entity.ProductoCarrito;


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
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			System.out.println(e.getMessage());
		}

		return productos;
	}

	public List<Producto> productosCategoria(int pais, int region, int id_categoria) {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<Producto> productos = new ArrayList<>();
		Producto producto;
		try {
			ps = con.prepareStatement("select * from catalogo where id_pais=? and id_region=? and id_categoria=?");
			ps.setInt(1,pais);
			ps.setInt(2, region);
			ps.setInt(3,id_categoria);
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
				producto.setId_supercategoria(rs.getInt("ID_SUPERCATEGORIA"));
				producto.setStock(rs.getInt("STOCK"));
				producto.setId_region(rs.getInt("ID_REGION"));
				producto.setRegion(rs.getString("REGION"));
				producto.setId_pais(rs.getInt("ID_PAIS"));
				producto.setPais(rs.getString("PAIS"));
				productos.add(producto);
			}

			con.commit();
			con.close();

		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			System.out.println(e.getMessage());
		}

		return productos;
	}

	@Override
	public List<ProductoCarrito> productosCarrito(String idcliente,String tipodocumento) {
		Conexion.getConexion();
		con = Conexion.conexion;
		List<ProductoCarrito> productos = new ArrayList<>();

		ProductoCarrito producto;

		try {
			ps = con.prepareStatement("select * from productosCarrito where idcliente=? and tipodocumento=?");
			ps.setString(1, idcliente);
			ps.setString(2, tipodocumento);
			rs = ps.executeQuery();

			while (rs.next()) {
				producto = new ProductoCarrito();
				producto.setIdCliente(rs.getString("IDCLIENTE"));
				producto.setTipodocumento(rs.getString("TIPODOCUMENTO"));
				producto.setId_producto(rs.getInt("IDPRODUCTO"));
				producto.setNombre_producto(rs.getString("NOMBRE_PRODUCTO"));
				producto.setFoto(rs.getString("FOTO"));
				producto.setCantidad(rs.getInt("CANTIDAD"));
				producto.setPrecio(rs.getDouble("PRECIO"));
				producto.setIva(rs.getDouble("IVA"));
				producto.setId_region(rs.getInt("REGION"));
				producto.setId_pais(rs.getInt("IDPAIS"));
				
				productos.add(producto);
			}

			con.commit();
			con.close();

		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			System.out.println(e.getMessage());
		}

		return productos;
	}
}
