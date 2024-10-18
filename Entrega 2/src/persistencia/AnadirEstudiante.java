package persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class AnadirEstudiante {
	
	private static final String JDBC_URL =  "jdbc:derby:Proyecto1; create=true";
	public void nuevoEstudiante(String nombre, String apellido, String login, String contrasenia) throws SQLException
	{
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("insert into Proyecto1.estudiantes(login, contrasenia, nombre, apellido) values (?,?)");
		ps.setString(1, login);
		ps.setString(2, contrasenia);
		ps.setString(3, nombre);
		ps.setString(4, apellido);
		ps.executeUpdate();
	}

}
