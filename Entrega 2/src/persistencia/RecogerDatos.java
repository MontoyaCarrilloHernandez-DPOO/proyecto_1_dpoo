package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;


import java.sql.PreparedStatement;

public class RecogerDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public ArrayList<String> getContraseniaEstudiante(String usuario) {
		ResultSet resultado;
		ArrayList<String> resultados = new ArrayList<String>();
		String contrasenia = null;
		String login = null;
		String nombre = null;
		String apellido = null;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "SELECT * FROM ESTUDIANTES WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, usuario);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				contrasenia = resultado.getString("contrasenia");
				nombre = resultado.getString("nombre");
				apellido = resultado.getString("apellido");
				
				System.out.println(contrasenia);
				System.out.println(nombre);
				System.out.println(apellido);
			}
			
			resultado.close();
			
			resultados.add(contrasenia);
			resultados.add(nombre);
			resultados.add(apellido);
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return resultados;
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
