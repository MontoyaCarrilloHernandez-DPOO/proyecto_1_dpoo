package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import learningPaths.LearningPath;
import learningPaths.Actividad;
import usuarios.Estudiante;


import java.sql.PreparedStatement;

public class RecogerDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public ArrayList<String> getContraseniaEstudiante(String usuario) {
		ResultSet resultado;
		ArrayList<String> resultados = new ArrayList<String>();
		String contrasenia = null;
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
	
	
	public ArrayList<String> getContraseniaProfesor(String usuario) {
		ResultSet resultado;
		ArrayList<String> resultados = new ArrayList<String>();
		String contrasenia = null;
		String nombre = null;
		String apellido = null;
		String lista_lps = null;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "SELECT * FROM PROFESORES WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, usuario);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				contrasenia = resultado.getString("contrasenia");
				nombre = resultado.getString("nombre");
				apellido = resultado.getString("apellido");
				lista_lps = resultado.getString("lista_lps");
			}
			
			resultado.close();
			
			resultados.add(contrasenia);
			resultados.add(nombre);
			resultados.add(apellido);
			resultados.add(lista_lps);
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return resultados;
	}
	
	public ArrayList<LearningPath> getLearningPathsDeString(String cadena){
		
		ArrayList<LearningPath> listaLP = new ArrayList<LearningPath>();
		ResultSet resultado;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			String[] lpArray = cadena.split(",");
			
			for ( String titulo : lpArray) {
				String qu = "SELECT * FROM LEARNING_PATH WHERE titulo = ?";
				float duracion = 0;
				String propietario = null;
				String descripcion = null;
				String objetivo = null;
				float dificultad = 0;
				float rating = 0;
				String metadatos = null;
				String actividades = null;
				String estudiantes = null;
				
				PreparedStatement pstmt = con.prepareStatement(qu);
			    pstmt.setString(1, titulo);
				resultado = pstmt.executeQuery();
				if (resultado.next()) {
					duracion = resultado.getFloat("duracion");
					propietario = resultado.getString("propietario");
					descripcion = resultado.getString("descripcion");
					objetivo = resultado.getString("objetivo");
					dificultad = resultado.getFloat("dificultad");
					rating = resultado.getFloat("rating");
					metadatos = resultado.getString("metadatos");
					actividades = resultado.getString("actividades");
					estudiantes = resultado.getString("estudiantes");
					
					ArrayList<Actividad> arrayActividades = getActividadesDeString(actividades); 
					ArrayList<Estudiante> arrayEstudiantes = getEstudiantesDeString(estudiantes); 
				}
				
				resultado.close();
				LearningPath esteLP = new LearningPath(propietario, titulo, duracion, dificultad, rating, descripcion, objetivo, metadatos, arrayActividades, arrayEstudiantes);
				listaLP.add(esteLP);
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return listaLP;
	}
	
public ArrayList<Actividad> getActividadesDeString(String cadena){
		
		ArrayList<Actividad> listaAct = new ArrayList<Actividad>();
		ResultSet resultado;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			String[] actArray = cadena.split(",");
			
			for ( String id : actArray) {
				String qu = "SELECT * FROM ACTIVIDADES WHERE id = ?";
				float duracion = 0;
				String propietario = null;
				String descripcion = null;
				String objetivo = null;
				float dificultad = 0;
				float rating = 0;
				String metadatos = null;
				String actividades = null;
				String estudiantes = null;
				
				PreparedStatement pstmt = con.prepareStatement(qu);
			    pstmt.setString(1, id);
				resultado = pstmt.executeQuery();
				if (resultado.next()) {
					duracion = resultado.getFloat("duracion");
					propietario = resultado.getString("propietario");
					descripcion = resultado.getString("descripcion");
					objetivo = resultado.getString("objetivo");
					dificultad = resultado.getFloat("dificultad");
					rating = resultado.getFloat("rating");
					metadatos = resultado.getString("metadatos");
					actividades = resultado.getString("actividades");
					estudiantes = resultado.getString("estudiantes");
					
					ArrayList<Actividad> arrayActividades = getActividadesDeString(actividades); 
					ArrayList<Estudiante> arrayEstudiantes = getEstudiantesDeString(estudiantes); 
				}
				
				resultado.close();
				Actividad estaAct = new Actividad(alo);
				listaAct.add(estaAct);
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		
		return listaAct;
	}

public ArrayList<Estudiante> getEstudiantesDeString(String cadena){
	
	ArrayList<Estudiante> listaEs = new ArrayList<Estudiante>();
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		String[] estArray = cadena.split(",");
		
		for ( String login : estArray) {
			String contrasenia = null;
			String nombre = null;
			String apellido = null;
			
			String qu = "SELECT * FROM ESTUDIANTES WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, login);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				contrasenia = resultado.getString("contrasenia");
				nombre = resultado.getString("nombre");
				apellido = resultado.getString("apellido");
			}
			
			resultado.close();
			Estudiante esteEstudiane = new Estudiante(contrasenia, nombre, apellido, login);
			listaEs.add(esteEstudiane);
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return listaEs;
}

}
