package persistencia;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;



public class AnadirDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public void nuevoEstudiante(String nombre, String apellido, String login, String contrasenia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO ESTUDIANTES (login, contrasenia, nombre, apellido, historial_lp, lp_actual, actividad_actual) values (?,?,?,?,?,?,?)");
		ps.setString(1, login);
		ps.setString(2, contrasenia);
		ps.setString(3, nombre);
		ps.setString(4, apellido);
		ps.setString(5, "");
		ps.setString(6, "");
		ps.setInt(7, 0);
		ps.executeUpdate();
		
		Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from ESTUDIANTES");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		
		
		System.out.println("\nEstudiante creado con éxito. Inicia sesión para poder unirte a un Learning Path.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevoProfesor(String nombre, String apellido, String login, String contrasenia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO PROFESORES (login, contrasenia, nombre, apellido, lista_lps) values (?,?,?,?,?)");
		ps.setString(1, login);
		ps.setString(2, contrasenia);
		ps.setString(3, nombre);
		ps.setString(4, apellido);
		ps.setString(5, "");
		ps.executeUpdate();
		
		Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from PROFESORES");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		System.out.println("\n Profesor creado con éxito. Inicia sesión para poder crear Learning Paths, actividades, etc.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void nuevoLearningPath(String titulo, String descripcion, String objetivos, String propietario, String metadatos, float dificultad, float duracion, float rating, String estudiantes, String actividades) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO LEARNING_PATH (titulo, descripcion, objetivos, propietario, metadatos, dificultad, duracion, rating, estudiantes, actividades) values (?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, titulo);
		ps.setString(2, descripcion);
		ps.setString(3, objetivos);
		ps.setString(4, propietario);
		ps.setString(5, metadatos);
		ps.setLong(6,  (long) dificultad);
		ps.setLong(7,  (long) duracion);
		ps.setLong(8,  (long) rating);
		ps.setString(9, "");
		ps.setString(10, "");
		ps.executeUpdate();
		
		Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from LEARNING_PATH");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		System.out.println("\n Learning Path creado con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevaEncuesta(  String objetivo, String titulo, String nivel, int prerequisistos, int sugeridos, String resenias,  float ratings, float tiempoLimite, float resultado,boolean completado, boolean enviado,String preguntas,String enunciado,String respuestaGuia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO ENCUESTAS (titulo, objetivo,  nivel,  prerequisistos,  sugeridos,  resenias,  ratings,  tiempoLimite,  resultado, completado,  enviado, preguntas, enunciado, respuestaGuia) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, titulo);
		ps.setString(2, objetivo);
		ps.setString(3, nivel);
		ps.setLong(4, prerequisistos);
		ps.setLong(5, sugeridos);
		ps.setString(6,  resenias);
		ps.setLong(7,  (long) ratings);
		ps.setLong(8,  (long) tiempoLimite);
		ps.setLong(9,  (long) resultado);
		ps.setBoolean(10,   completado);
		ps.setBoolean(11,   enviado);
		ps.setString(12,  preguntas);// no se si se deja asi o no, depronto solo se debe cambiar por un "" y ya.
		ps.setString(13,  enunciado);
		ps.setString(14, respuestaGuia);
		ps.executeUpdate();
		
		Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from ENCUESTAS");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		System.out.println("\n Encuesta creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevaExamen(  boolean exitoso, float notaObtenida, float notaMinima, String preguntas, String enunciado, String respuestaGuia, String objetivo, String titulo, String nivel, int prerequisistos, int sugeridos, String resenias, int rating, float tiempoLimite, boolean completado) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO EXAMENES (  titulo, objetivo,  nivel,  prerequisistos,  sugeridos,  resenias,  rating,  tiempoLimite,  notaMinima, notaObtenida,exitoso, completado, preguntas, enunciado, respuestaGuia) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, objetivo);
			ps.setString(3, nivel);
			ps.setLong(4, prerequisistos);
			ps.setLong(5, sugeridos);
			ps.setString(6,  resenias);
			ps.setLong(7,  (long) rating);
			ps.setLong(8,  (long) tiempoLimite);
			ps.setLong(9,  (long) notaMinima);
			ps.setLong(10,  (long) notaObtenida);
			ps.setBoolean(11,   exitoso);
			ps.setBoolean(12,   completado);
			ps.setString(13,  preguntas);
			ps.setString(14,  enunciado);
			ps.setString(15, respuestaGuia);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from EXAMENES");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Examen creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}