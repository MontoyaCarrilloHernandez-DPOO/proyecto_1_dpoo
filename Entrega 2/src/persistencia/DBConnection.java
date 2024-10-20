package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
						+ "actividad_actual int \n"
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
						+ "lista_lps varchar(1000) \n"
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
						+ "objetivo varchar(500), \n"
						+ "dificultad float, \n"
						+ "rating float, \n"
						+ "metadatos varchar(50) \n"
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
						+ "id int primary key, \n"
						+ "titulo varchar(50), \n"
						+ "objetivo varchar(500), \n"
						+ "nivel varchar(50), \n"
						+ "duracion float, \n"
						+ "learning_path varchar(50), \n"
						+ "id_prerequisito int, \n"
						+ "id_sugerido int, \n"
						+ "tiempoLimite float, \n"
						+ "resultado float, \n"
						+ "rating float, \n"
						+ "lista_ratings varchar(1000), \n"
						+ "lista_resenias varchar(1000), \n"
						+ "completado boolean \n"
						+ ")");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
		}
	}
	
}

	

