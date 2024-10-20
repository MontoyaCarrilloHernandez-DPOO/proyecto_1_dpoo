package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;


import java.sql.PreparedStatement;

public class RecogerDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public String getContrasenia(String usuario) {
		ResultSet resultado;
		String contrasenia = null;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			Statement stmt = con.createStatement();
			String qu = "SELECT contrasenia FROM ESTUDIANTES WHERE login = " + usuario;
			resultado = stmt.executeQuery(qu);
			contrasenia = resultado.getString("contrasenia");
			
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return contrasenia;
	}

}
