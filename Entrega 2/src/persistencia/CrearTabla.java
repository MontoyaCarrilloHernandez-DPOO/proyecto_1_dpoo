package persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
	
	private static final String JDBC_URL =  "jdbc:derby:Proyecto1";
	public static void nuevaTablaEstudiantes() throws SQLException
	{
		Connection con = DriverManager.getConnection(JDBC_URL);
		Statement st = con.createStatement();
		st.executeUpdate("create table Proyecto1.estudiantes (login varchar(50) primary key, contrasenia varchar(50), nombre varchar(50), apellido varchar(50)");
		st.close();
		con.close();
	}
	
	public static void nuevaTablaProfesores() throws SQLException
	{
		Connection con = DriverManager.getConnection(JDBC_URL);
		Statement st = con.createStatement();
		st.executeUpdate("create table Proyecto1.profesores (login varchar(50) primary key, contrasenia varchar(50), nombre varchar(50), apellido varchar(50)");
		st.close();
		con.close();
	}

	
	

}
