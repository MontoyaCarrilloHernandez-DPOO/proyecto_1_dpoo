package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String JDBC_URL =  "jdbc:derby:Proyecto1;create=true";
	Connection conn;
	public DBConnection() {
		try {
			this.conn = DriverManager.getConnection(JDBC_URL);
			if(this.conn != null) {
				System.out.println("Conexion exitosa");
			}
			String sql1 = "Create Table estudiantes (login varchar(50) primary key, contrasenia varchar(50), nombre varchar(50), apellido varchar(50))";
			Statement st1 = conn.createStatement();
			st1.executeUpdate(sql1);
			System.out.println("Tabla estudiantes creada");
			
			/**
			String sql2 = "Create Table profesores (login varchar(50) primary key, contrasenia varchar(50), nombre varchar(50), apellido varchar(50))";
			Statement st2 = conn.createStatement();
			st2.executeUpdate(sql2);
			System.out.println("Tabla profesores creada");
			**/
			
		}catch(SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
}
