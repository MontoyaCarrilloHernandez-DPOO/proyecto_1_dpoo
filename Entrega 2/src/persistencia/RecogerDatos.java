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
	
	public String getContraseniaEstudiante(String usuario) {
		ResultSet resultado;
		String contrasenia = null;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "SELECT contrasenia FROM ESTUDIANTES WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, usuario);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				contrasenia = resultado.getString("contrasenia");
				System.out.println(contrasenia);
			}
			resultado.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return contrasenia;
	}
	
	public String getContraseniaProfesor(String usuario) {
		ResultSet resultado;
		String contrasenia = null;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "SELECT contrasenia FROM PROFESORES WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, usuario);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				contrasenia = resultado.getString("contrasenia");
				System.out.println(contrasenia);
			}
			resultado.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return contrasenia;
	}

}
