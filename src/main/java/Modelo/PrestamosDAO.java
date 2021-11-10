package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Controlador.Conexion;

public class PrestamosDAO {

	Conexion cnn = new Conexion();
	Connection con = cnn.Conecta();
	PreparedStatement ps = null;
	ResultSet res = null;

	public boolean Inserta_prestamo(PrestamosDTO p) {

		boolean resul = false;
		try {
			String sql = "insert into prestamo(Estudiante,Libro,Fecha_Prestamo,Cantidad) values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getEstudiante());
			ps.setString(2, p.getLibro());
			ps.setString(3, p.getFecha_Prestamo());
			ps.setInt(4, p.getCant());
			resul = ps.executeUpdate() > 0;

			if (resul) {
				sql = "select Id_prestamo from prestamo order by Id_prestamo desc limit 1";
				ps = con.prepareStatement(sql);
				res = ps.executeQuery();
				int id = 0;
				while (res.next()) {
					id = res.getInt(1);
				}

				sql = "select Precio from libro where isbn=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, p.getLibro());
				res = ps.executeQuery();
				int precio = 0;
				while (res.next()) {
					precio = res.getInt(1);
				}

				sql = "update prestamo set Total=?*? where Id_prestamo=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, precio);
				ps.setInt(2, p.getCant());
				ps.setInt(3, id);
				resul = ps.executeUpdate() > 0;

				sql = "update libro set Acumulado=Acumulado+(?*?) where isbn=?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, precio);
				ps.setInt(2, p.getCant());
				ps.setString(3, p.getLibro());
				resul = ps.executeUpdate() > 0;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error al insertar prestamo" + ex);
		}

		return resul;
	}

}
