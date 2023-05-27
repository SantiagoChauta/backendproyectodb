package com.BD2.app.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.BD2.app.beans.Conexion;
import com.BD2.app.models.entity.Pedido;

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
			System.out.println(e.getMessage());
		}
		return pedido;
	}

	@Override
	public Pedido findbyEstado() {
		Conexion.getConexion();
		con = Conexion.conexion;
		Pedido pedido = new Pedido();
		try {
			ps = con.prepareStatement("select * from Pedido where k_estado = p");
			rs = ps.executeQuery();
			int filas = ps.getMaxRows();
			
			if(filas == 0) {
				//se debe crear un nuevo pedido
			}
			else {
				//se debe actualizar el pedido con el estado 'pendiente'
			}
			
		} catch (Exception e) {
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
			System.out.println(e.getMessage());
		}
	}

}
