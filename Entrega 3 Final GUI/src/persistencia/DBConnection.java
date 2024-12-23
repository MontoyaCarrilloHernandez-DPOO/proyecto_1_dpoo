package persistencia;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class DBConnection {
	@SuppressWarnings("unused")
	private static DBConnection handler;
	
	private static final String DB_URL = "jdbc:derby:proyecto1;create=true";
	private static Connection conn = null;
	private static Statement stmt = null;
	
	public DBConnection() {
		crearConexion();
		crearTablaEstudiantes();
		crearTablaProfesores();
		crearTablaLearningPaths();
		crearTablaActividades();
		crearTablaEncuestas();
		crearTablaExamenes();
		crearTablaQuizes();
		crearTablaRecurso();
		crearTablaTarea();
		crearTablaPreguntaAbierta();
		crearTablaPreguntaCerrada();
		crearTablaProceso();
		crearTablaPreguntaRespuesta();
		
	}
	
	@SuppressWarnings("deprecation")
	void crearConexion(){
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
			conn = DriverManager.getConnection(DB_URL);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	void crearTablaEstudiantes(){
		String NOMBRE_TABLA = "ESTUDIANTES";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "login varchar(50) primary key, \n"
						+ "contrasenia varchar(50), \n"
						+ "nombre varchar(50), \n"
						+ "apellido varchar(50), \n"
						+ "historial_lp varchar(1000), \n"
						+ "lp_actual varchar(50), \n"
						+ "actividad_actual varchar(50), \n"
						+ "progreso float, \n"
						+ "respuestas varchar(100) \n"
						+ ")");
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaProceso(){
		String NOMBRE_TABLA = "PROGRESOS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "login varchar(50) primary key, \n"
						+ "learningPath varchar(50), \n"
						+ "actividades_completadas varchar(1000), \n"
						+ "actividades_incompletas varchar(1000), \n"
						+ "porcentaje float \n"
						+ ")");
				
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaProfesores(){
		String NOMBRE_TABLA = "PROFESORES";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "login varchar(50) primary key, \n"
						+ "contrasenia varchar(50), \n"
						+ "nombre varchar(50), \n"
						+ "apellido varchar(50), \n"
						+ "lista_lps varchar(1000), \n"
						+ "lista_actividades varchar(1000), \n"
						+ "lista_estudiantes varchar(1000) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaLearningPaths(){
		String NOMBRE_TABLA = "LEARNING_PATHS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "duracion float, \n"
						+ "descripcion varchar(500), \n"
						+ "propietario varchar(500), \n"
						+ "objetivo varchar(500), \n"
						+ "dificultad float, \n"
						+ "rating float, \n"
						+ "metadatos varchar(50), \n"
						+ "Actividades varchar(1000), \n"
						+ "Estudiantes varchar(1000) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaActividades(){
		String NOMBRE_TABLA = "ACTIVIDADES";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "tiempoLimite float, \n"
						+ "rating float, \n"
						+ "lista_resenias varchar(1000), \n"
						+ "completado boolean, \n"
						+ "tipo varchar(50) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaEncuestas(){
		String NOMBRE_TABLA = "ENCUESTAS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "resenias varchar(1000), \n"
						+ "rating float, \n"
						+ "tiempoLimite float, \n"
						+ "completado boolean, \n"
						+ "enviado boolean, \n"
						+ "preguntas varchar(50) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaExamenes(){
		String NOMBRE_TABLA = "EXAMENES";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "resenias varchar(1000), \n"
						+ "rating float, \n"
						+ "tiempoLimite float, \n"
						+ "notaMinima float, \n"
						+ "notaObtenida float, \n"
						+ "exitoso boolean, \n"
						+ "completado boolean, \n"
						+ "preguntas varchar(50) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaQuizes(){
		String NOMBRE_TABLA = "QUIZES";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "resenias varchar(1000), \n"
						+ "rating float, \n"
						+ "tiempoLimite float, \n"
						+ "completado boolean, \n"
						+ "notaMinima float, \n"
						+ "notaObtenida float, \n"
						+ "exitoso boolean, \n"
						+ "preguntas varchar(50) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaRecurso(){
		String NOMBRE_TABLA = "RECURSOS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "resenias varchar(1000), \n"
						+ "rating float, \n"
						+ "tiempoLimite float, \n"
						+ "completado boolean, \n"
						+ "tipo varchar(50) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaTarea(){
		String NOMBRE_TABLA = "TAREAS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "titulo varchar(50) primary key, \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "prerequisito varchar(50), \n"
						+ "sugerido varchar(50), \n"
						+ "resenias varchar(1000), \n"
						+ "rating float, \n"
						+ "tiempoLimite float, \n"
						+ "completado boolean, \n"
						+ "estado boolean \n "
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaPreguntaAbierta(){
		String NOMBRE_TABLA = "PREGUNTAS_ABIERTAS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "id int primary key GENERATED ALWAYS AS IDENTITY(Start with 1, Increment by 1), \n"
						+ "enunciado varchar(500), \n"
						+ "respuestaGuia varchar(500) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	void crearTablaPreguntaCerrada(){
		String NOMBRE_TABLA = "PREGUNTAS_CERRADAS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "id int GENERATED ALWAYS AS IDENTITY primary key, \n"
						+ "respuestaCorrecta varchar(500), \n"
						+ "justificacion varchar(500), \n"
						+ "enunciado varchar(500), \n"
						+ "opcionA varchar(500), \n"
						+ "opcionB varchar(500), \n"
						+ "opcionC varchar(500), \n"
						+ "opcionD varchar(500) \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
	void crearTablaPreguntaRespuesta(){
		String NOMBRE_TABLA = "RESPUESTAS_PREGUNTAS";
		try {
			stmt = conn.createStatement();
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null,  null,  NOMBRE_TABLA.toUpperCase(), null);
			if (tables.next()) {
				System.out.println("La tabla " + NOMBRE_TABLA + " ya existe. Todo listo");
			} else {
				stmt.execute("CREATE TABLE " + NOMBRE_TABLA + " ("
						+ "id int GENERATED ALWAYS AS IDENTITY primary key, \n"
						+ "login varchar(500), \n"
						+ "actividad varchar(500), \n"
						+ "pregunta varchar(500), \n"
						+ "respuesta varchar(500), \n"
						+ "correcto boolean \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
}

	

