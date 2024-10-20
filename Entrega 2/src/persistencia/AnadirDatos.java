package persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class AnadirDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public void nuevoEstudiante(String nombre, String apellido, String login, String contrasenia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO ESTUDIANTES (login, contrasenia, nombre, apellido, historial_lp, lp_actual, actividad_actual) values (?,?,?,?,?,?,?)");
		ps.setString(1, login);
		ps.setString(2, contrasenia);
		ps.setString(3, nombre);
		ps.setString(4, apellido);
		ps.setString(5, "");
		ps.setString(6, "");
		ps.setInt(7, 0);
		ps.executeUpdate();
		System.out.println("Estudiante creado con éxito. Inicia sesión para poder unirte a un Learning Path.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevoProfesor(String nombre, String apellido, String login, String contrasenia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO PROFESORES (login, contrasenia, nombre, apellido, lista_lps) values (?,?,?,?,?)");
		ps.setString(1, login);
		ps.setString(2, contrasenia);
		ps.setString(3, nombre);
		ps.setString(4, apellido);
		ps.setString(5, "");
		ps.executeUpdate();
		System.out.println("Profesor creado con éxito. Inicia sesión para poder crear Learning Paths, actividades, etc.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//TODO: HACER CON LEARNING PATHS Y ACTIVIDADES

}