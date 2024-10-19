package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void mainPers(String[] args) {
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String JDBC_URL =  "jdbc:derby:PROYECTO1;create=true";
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL);
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE SCHEMA PROYECTO1");
			Statement st1 = conn.createStatement();
			st1.executeUpdate("CREATE TABLE ESTUDIANTES (LOGIN varchar(50) PRIMARY KEY, CONTRASENIA varchar(50), NOMBRE varchar(50), APELLIDO varchar(50)");
			
		}catch(SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
}
