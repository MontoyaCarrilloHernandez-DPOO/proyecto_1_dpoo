package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void mainPers(String[] args) {
		final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
		final String JDBC_URL =  "jdbc:derby:Proyecto1;create=true";
		try {
			Connection conn = DriverManager.getConnection(JDBC_URL);
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE estudiantes (login varchar(50) PRIMARY KEY, contrasenia varchar(50), nombre varchar(50), apellido varchar(50)");
		}catch(SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
}
