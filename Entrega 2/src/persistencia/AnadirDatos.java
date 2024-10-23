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
	public void nuevoLearningPath(String titulo, String descripcion, String objetivos, String propietario, String metadatos, float dificultad, float duracion, float rating, String actividades) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO LEARNING_PATHS (titulo, descripcion, objetivos, propietario, metadatos, dificultad, duracion, rating, estudiantes, actividades) values (?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, titulo);
		ps.setString(2, descripcion);
		ps.setString(3, objetivos);
		ps.setString(4, propietario);
		ps.setString(5, metadatos);
		ps.setLong(6,  (long) dificultad);
		ps.setLong(7,  (long) duracion);
		ps.setLong(8,  (long) rating);
		ps.setString(9, actividades);
		ps.setString(10, "");
		ps.executeUpdate();
		
		Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from LEARNING_PATHS");
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
	
	public void nuevaEncuesta(  String objetivo, String titulo, String nivel, int prerequisistos, int sugeridos, String resenias,  float rating, float tiempoLimite, boolean completado, boolean enviado,String preguntas,String enunciado,String respuestaGuia) throws SQLException
	{
		try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		PreparedStatement ps = con.prepareStatement("INSERT INTO ENCUESTAS (titulo, objetivo,  nivel,  prerequisistos,  sugeridos,  resenias,  rating,  tiempoLimite,   completado,  enviado, preguntas, enunciado, respuestaGuia) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, titulo);
		ps.setString(2, objetivo);
		ps.setString(3, nivel);
		ps.setLong(4, prerequisistos);
		ps.setLong(5, sugeridos);
		ps.setString(6,  resenias);
		ps.setLong(7,  (long) rating);
		ps.setLong(8,  (long) tiempoLimite);
		ps.setBoolean(9,   completado);
		ps.setBoolean(10,   enviado);
		ps.setString(11,  preguntas);// no se si se deja asi o no, depronto solo se debe cambiar por un "" y ya.
		ps.setString(12,  enunciado);
		ps.setString(13, respuestaGuia);
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
	
	public void nuevoExamen(  boolean exitoso, float notaObtenida, float notaMinima, String preguntas, String enunciado, String respuestaGuia, String objetivo, String titulo, String nivel, int prerequisistos, int sugeridos, String resenias, int rating, float tiempoLimite, boolean completado) throws SQLException
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
	
	public void nuevoQuiz(  String objetivo,String titulo,String nivel,int prerequisistos,int sugeridos,String resenias,int rating,float tiempoLimite,boolean completado,float notaMinima,float notaObtenida,boolean exitoso,String preguntas) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO QUIZES (   titulo, objetivo, nivel, prerequisistos, sugeridos, resenias, rating, tiempoLimite, completado, notaMinima, notaObtenida, exitoso, preguntas) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, objetivo);
			ps.setString(3, nivel);
			ps.setLong(4, prerequisistos);
			ps.setLong(5, sugeridos);
			ps.setString(6,  resenias);
			ps.setLong(7,  (long) rating);
			ps.setLong(8,  (long) tiempoLimite);
			ps.setBoolean(9,   completado);
			ps.setLong(10,  (long) notaMinima);
			ps.setLong(11,  (long) notaObtenida);
			ps.setBoolean(11,   exitoso);
			ps.setString(13,  preguntas);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from QUIZES");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Quiz creado con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void nuevoRecurso( String objetivo,String titulo,String nivel,int prerequisistos,int sugeridos,String resenias,float rating,float tiempoLimite,boolean completado,String tipo) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO RECURSOS (titulo, objetivo, nivel, prerequisistos, sugeridos, resenias, rating, tiempoLimite, completado, tipo) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, objetivo);
			ps.setString(3, nivel);
			ps.setLong(4, prerequisistos);
			ps.setLong(5, sugeridos);
			ps.setString(6,  resenias);
			ps.setLong(7,  (long) rating);
			ps.setLong(8,  (long) tiempoLimite);
			ps.setBoolean(9,   completado);
			ps.setString(10,  tipo);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from RECURSOS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n recurso creado con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void nuevaTarea( String objetivo,String titulo,String nivel,int prerequisistos,int sugeridos,String resenias,float rating,float tiempoLimite,boolean completado,String estado) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO TAREAS ( titulo, objetivo,  nivel, prerequisistos, sugeridos, resenias, rating, tiempoLimite, completado, estado) values (?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, objetivo);
			ps.setString(3, nivel);
			ps.setLong(4, prerequisistos);
			ps.setLong(5, sugeridos);
			ps.setString(6,  resenias);
			ps.setLong(7,  (long) rating);
			ps.setLong(8,  (long) tiempoLimite);
			ps.setBoolean(9,   completado);
			ps.setString(10,  estado);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from TAREAS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Tarea creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
	public void nuevaPreguntaAbierta( String respuestaGuia,String enunciado) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO PREGUNTAS_ABIERTAS (enunciado,respuestaGuia) values (?,?)");
			ps.setString(1, enunciado);
			ps.setString(2, respuestaGuia);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from PREGUNTAS_ABIERTAS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Pregunta abierta creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void nuevaPreguntaCerrada(  String respuestaCorrecta, String justificacion, String enunciado, String opcionA, String opcionB, String opcionC, String opcionD) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO PREGUNTAS_CERRADAS ( respuestaCorrecta, justificacion, enunciado, opcionA, opcionB, opcionC, opcionD) values (?,?,?,?,?,?,?)");
			ps.setString(1, respuestaCorrecta);
			ps.setString(2, justificacion);
			ps.setString(3, enunciado);
			ps.setString(4, opcionA);
			ps.setString(5, opcionB);
			ps.setString(6, opcionC);
			ps.setString(7, opcionD);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from PREGUNTAS_CERRADAS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Pregunta cerrada creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void nuevaActividad( String objetivo,String titulo,String nivel,String prerequisistos,String sugeridos,String resenias,float rating,float tiempoLimite,boolean completado) throws SQLException
	{
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			PreparedStatement ps = con.prepareStatement("INSERT INTO ACTIVIDADES (  titulo, objetivo, nivel, prerequisistos, sugeridos, resenias, rating, tiempoLimite, completado) values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, titulo);
			ps.setString(2, objetivo);
			ps.setString(3, nivel);
			ps.setString(4, prerequisistos);
			ps.setString(5, sugeridos);
			ps.setString(6,  resenias);
			ps.setLong(7,  (long) rating);
			ps.setLong(8,  (long) tiempoLimite);
			ps.setBoolean(9,   completado);
			ps.executeUpdate();
			
			Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from ACTIVIDADES");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			System.out.println("\n Actividad cerrada creada con éxito.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}