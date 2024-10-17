package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

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
		}catch(SQLException e) {
			System.out.println("Conexion fallida");
		}
	}
}
