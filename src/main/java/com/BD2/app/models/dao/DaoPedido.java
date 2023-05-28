package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.beans.Excepciones;
import com.BD2.app.models.entity.Cliente;
import com.BD2.app.models.entity.Pedido;
import com.BD2.app.models.entity.Producto;

@Repository
public class DaoPedido implements IPedido {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con;

	@Override
	public Pedido findbyId(int id_pedido) {
		Conexion.getConexion();
		con = Conexion.conexion;
		Pedido pedido = new Pedido();
		try {
			ps = con.prepareStatement("select * from Pedido where k_idpedido =" + id_pedido);
			rs = ps.executeQuery();
			while (rs.next()) {
				pedido.setTotal(rs.getInt("V_TOTAL"));
				pedido.setCalificacion(rs.getInt("Q_CALIFICACION"));
				pedido.setEstado(rs.getString("I_ESTADO"));
				pedido.setFecha(rs.getDate("F_FECHA"));
				pedido.setId_cliente(rs.getString("FK_IDCLIENTE"));
				pedido.setTipo_idcli(rs.getString("FK_TIPOIDCLIENTE"));
			}
			con.commit();
			con.close();
		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		return pedido;
	}

	@Override
	public void insertarPedido(Pedido pedido) {

		Conexion.getConexion();
		con = Conexion.conexion;

		try {
			ps = con.prepareStatement("insert into pedido values (?,?,?,?,?,?,?)");
			ps.setInt(1, pedido.getId_pedido());
			ps.setInt(2, pedido.getTotal());
			ps.setFloat(3, pedido.getCalificacion());
			ps.setString(4, pedido.getEstado());
			ps.setDate(5, pedido.getFecha());
			ps.setString(6, pedido.getId_cliente());
			ps.setString(7, pedido.getTipo_idcli());
			ps.executeUpdate();

			con.commit();
			con.close();

		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actualizarPedido(Pedido pedido) {
		Conexion.getConexion();
		con = Conexion.conexion;

		try {
			ps = con.prepareStatement(
					"update pedido set v_total=?, q_calificacion=?, i_estado=?, f_fecha=?, fk_idcliente=?, fk_tipoidcliente=? where k_idpedido = ?");
			ps.setInt(1, pedido.getTotal());
			ps.setFloat(2, pedido.getCalificacion());
			ps.setString(3, pedido.getEstado());
			ps.setDate(4, pedido.getFecha());
			ps.setString(5, pedido.getId_cliente());
			ps.setString(6, pedido.getTipo_idcli());
			ps.setInt(7, pedido.getId_pedido());
			ps.executeUpdate();
			con.commit();
			con.close();
		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public Boolean pedidoEstado(Producto producto) {
		
		Conexion.getConexion();
		con = Conexion.conexion;
		Boolean salida = true;
		
		try {
			ps = con.prepareStatement(
					"select p.i_estado estado,p.k_idpedido idpedido,p.v_total from pedido p, cliente c "
					+ "where p.fk_idcliente=c.k_idcedula and p.fk_tipoidcliente=c.k_tipodocumento and i_estado='p' "
					+ "and c.k_idcedula=? and c.k_tipodocumento=?"
					+ "");
			ps.setString(1, Conexion.password);
			ps.setString(2, Conexion.usuario.substring(1,3));
			
			rs = ps.executeQuery();
			
			if(rs.next() == false) {
				//crear un nuevo pedido
				System.out.println("No hay pedidos pendientes");
				this.nuevoPedido(producto);
			}
			else {
				//insertar en el pedido p
				System.out.println("Si hay pedidos pendientes");
				this.insertarPPR(rs.getInt("idpedido"), producto);
				
			}
			
			con.commit();
			con.close();
		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
		
		return salida;
	}

	@Override
	public void nuevoPedido(Producto producto) {

		Conexion.getConexion();
		con = Conexion.conexion;

		try {
			System.out.println("Creando nuevo pedido");
			ps = con.prepareStatement("insert into pedido (v_total,q_calificacion,i_estado,f_fecha,fk_idcliente,fk_tipoidcliente) values(0,0,'p',?,?,?)");
			ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			ps.setString(2, Conexion.password);
			ps.setString(3, Conexion.usuario.substring(1,3));
			ps.executeUpdate();

			con.commit();
			con.close();
			
			this.pedidoEstado(producto);

		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void insertarPPR(int pedido, Producto producto) {
		Conexion.getConexion();
		con = Conexion.conexion;

		try {
			System.out.println("Insertando producto en pedido");
			System.out.println("ID pedido: "+pedido);
			System.out.println("ID producto: "+producto.getId_producto());
			ps = con.prepareStatement("insert into pedido_producto_region values (?,?,1,1,1)");
			ps.setInt(1, pedido);
			ps.setInt(2, producto.getId_producto());
			ps.executeUpdate();

			con.commit();
			con.close();

		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void pagar(int calificacion) {
		System.out.println("entro a pagar");
		Conexion.getConexion();
		con = Conexion.conexion;

		try {
			ps = con.prepareStatement(
					"update pedido q_calificacion=?, i_estado=? where fk_idcliente = ? and i_estado='p'");
			ps.setInt(1, calificacion);
			ps.setString(2, "e");
			ps.setString(3, Conexion.password);
			ps.executeUpdate();
			con.commit();
			con.close();
			
		} catch (Exception e) {
			Excepciones.errorMessage = e.getMessage().substring(4,9);
			Excepciones.hashCode = e.hashCode();
			System.out.println(e.hashCode());
			System.out.println(e.getMessage());
		}
	}



}
