package persistencia;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import learningPaths.LearningPath;
import learningPaths.Progreso;
import learningPaths.Actividad;
import usuarios.Estudiante;
import java.sql.PreparedStatement;
import usuarios.Profesor;

public class RecogerDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public ArrayList<String> getContraseniaEstudiante(String usuario) {
		ResultSet resultado;
		ArrayList<String> resultados = new ArrayList<String>();
		
		String contrasenia = null;
		String nombre = null;
		String apellido = null;
		String historial_lp = null;
		String lp_actual = null;
		String actividad_actual = null;
		String progreso = null;
		
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
				historial_lp = resultado.getString("historial_lp");
				lp_actual = resultado.getString("lp_actual");
				actividad_actual = resultado.getString("actividad_actual");
				progreso = resultado.getString("progreso");
			
			}
			
			resultado.close();
			
			resultados.add(contrasenia);
			resultados.add(nombre);
			resultados.add(apellido);
			resultados.add(historial_lp);
			resultados.add(lp_actual);
			resultados.add(actividad_actual);
			
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
		String lista_act = null;
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
				lista_act = resultado.getString("lista_actividades");
			}
			
			resultado.close();
			
			resultados.add(contrasenia);
			resultados.add(nombre);
			resultados.add(apellido);
			resultados.add(lista_lps);
			resultados.add(lista_act);
			
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
				String qu = "SELECT * FROM LEARNING_PATHS WHERE titulo = ?";
				ArrayList<Actividad> arrayActividades = new ArrayList<Actividad>(); 
				ArrayList<Estudiante> arrayEstudiantes = new ArrayList<Estudiante>(); 
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
					
					arrayActividades = getActividadesDeString(actividades); 
					arrayEstudiantes = getEstudiantesDeString(estudiantes); 
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
			System.out.println(actArray);
			
			for ( String id : actArray) {
				String qu = "SELECT * FROM ACTIVIDADES WHERE titulo = ?";
				String titulo = null;
				String objetivo = null;
				String nivel = null;
				String prerequisito = null;
				String sugerido = null;
				float tiempoLimite = 0;
				float rating = 0;
				String lista_resenias = null;
				boolean completado = false;
				String tipo = null;
				
				Actividad elSugerido = null;
				Actividad elPrerequisito = null;
				
				PreparedStatement pstmt = con.prepareStatement(qu);
			    pstmt.setString(1, id);
				resultado = pstmt.executeQuery();
				if (resultado.next()) {
					titulo = resultado.getString("titulo");
					objetivo = resultado.getString("objetivo");
					nivel = resultado.getString("nivel");
					prerequisito = resultado.getString("prerequisito");
					sugerido = resultado.getString("sugerido");
					tiempoLimite = resultado.getFloat("tiempoLimite");
					rating = resultado.getFloat("rating");
					lista_resenias = resultado.getString("lista_resenias");
					completado = resultado.getBoolean("completado");
					tipo = resultado.getString("tipo");
					if (prerequisito != null || prerequisito != ".") {
						elPrerequisito = getActividadDeString(prerequisito);
					}
					if (sugerido != null || sugerido != ".") {
						elSugerido = getActividadDeString(sugerido);
					}
				}
				resultado.close();
				Actividad estaAct = new Actividad(objetivo, titulo, nivel, elPrerequisito , elSugerido, lista_resenias, tiempoLimite, rating, completado);
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

public Progreso getProgresoDeString(String cadena){
	Progreso miProgreso = null;
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		String learningPath = null;
		String actividades_completadas = null;
		String actividades_incompletas = null;
		float porcentaje = 0;
			
			String qu = "SELECT * FROM PROGRESOS WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, cadena);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				learningPath = resultado.getString("learningPath");
				actividades_completadas = resultado.getString("actividades_completadas");
				actividades_incompletas = resultado.getString("actividades_incompletas");
				porcentaje = resultado.getFloat("porcentaje");
			}
			
			resultado.close();
			miProgreso = new Progreso(getLearningPathDeString(learningPath),cadena);
			miProgreso.setActividadesCompletadas(getActividadesDeString(actividades_completadas));
			miProgreso.setActividadesIncompletas(getActividadesDeString(actividades_incompletas));
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return miProgreso;
}

public LearningPath getLearningPathDeString(String cadena){
	LearningPath miLP = null;
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
			String qu = "SELECT * FROM LEARNING_PATHS WHERE titulo = ?";
			ArrayList<Actividad> arrayActividades = new ArrayList<Actividad>(); 
			ArrayList<Estudiante> arrayEstudiantes = new ArrayList<Estudiante>(); 
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
		    pstmt.setString(1, cadena);
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
				
				arrayActividades = getActividadesDeString(actividades); 
				arrayEstudiantes = getEstudiantesDeString(estudiantes); 
			}
			
			resultado.close();
			miLP = new LearningPath(propietario, cadena, duracion, dificultad, rating, descripcion, objetivo, metadatos, arrayActividades, arrayEstudiantes);
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return miLP;
}

public Actividad getActividadDeString(String cadena){
	
	ResultSet resultado;
	Actividad miAct = null;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
			String qu = "SELECT * FROM ACTIVIDADES WHERE titulo = ?";
			String titulo = null;
			String objetivo = null;
			String nivel = null;
			String prerequisito = null;
			String sugerido = null;
			float tiempoLimite = 0;
			float rating = 0;
			String lista_resenias = null;
			boolean completado = false;
			String tipo = null;
			
			Actividad elSugerido = null;
			Actividad elPrerequisito = null;
			
			PreparedStatement pstmt = con.prepareStatement(qu);
		    pstmt.setString(1, cadena);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				titulo = resultado.getString("titulo");
				objetivo = resultado.getString("objetivo");
				nivel = resultado.getString("nivel");
				prerequisito = resultado.getString("prerequisito");
				sugerido = resultado.getString("sugerido");
				tiempoLimite = resultado.getFloat("tiempoLimite");
				rating = resultado.getFloat("rating");
				lista_resenias = resultado.getString("lista_resenias");
				completado = resultado.getBoolean("completado");
				tipo = resultado.getString("tipo");
				
				if (prerequisito != null || prerequisito != ".") {
					elPrerequisito = getActividadDeString(prerequisito);
				}
				if (sugerido != null || sugerido != ".") {
					elSugerido = getActividadDeString(sugerido);
				}
			}
			resultado.close();
			miAct = new Actividad(objetivo, titulo, nivel, elPrerequisito , elSugerido, lista_resenias, tiempoLimite, rating, completado);

		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return miAct;
}

// PARA SUBIR DATOS EN GENERAL

public ArrayList<LearningPath> getLearningPaths(){
	
	ArrayList<LearningPath> listaLP = new ArrayList<LearningPath>();
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
			String qu = "SELECT * FROM LEARNING_PATHS";
			String titulo = null;
			ArrayList<Actividad> arrayActividades = new ArrayList<Actividad>(); 
			ArrayList<Estudiante> arrayEstudiantes = new ArrayList<Estudiante>(); 
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
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				titulo = resultado.getString("titulo");
				duracion = resultado.getFloat("duracion");
				propietario = resultado.getString("propietario");
				descripcion = resultado.getString("descripcion");
				objetivo = resultado.getString("objetivo");
				dificultad = resultado.getFloat("dificultad");
				rating = resultado.getFloat("rating");
				metadatos = resultado.getString("metadatos");
				actividades = resultado.getString("actividades");
				estudiantes = resultado.getString("estudiantes");
				
				arrayActividades = getActividadesDeString(actividades); 
				arrayEstudiantes = getEstudiantesDeString(estudiantes); 
				
				LearningPath esteLP = new LearningPath(propietario, titulo, duracion, dificultad, rating, descripcion, objetivo, metadatos, arrayActividades, arrayEstudiantes);
				listaLP.add(esteLP);
			}
			
			resultado.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return listaLP;
}

public ArrayList<Actividad> getActividades(){
	
	ArrayList<Actividad> listaAct = new ArrayList<Actividad>();
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
			String qu = "SELECT * FROM ACTIVIDADES";
			String titulo = null;
			String objetivo = null;
			String nivel = null;
			String prerequisito = null;
			String sugerido = null;
			float tiempoLimite = 0;
			float rating = 0;
			String lista_resenias = null;
			boolean completado = false;
			String tipo = null;
			
			PreparedStatement pstmt = con.prepareStatement(qu);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				titulo = resultado.getString("titulo");
				objetivo = resultado.getString("objetivo");
				nivel = resultado.getString("nivel");
				prerequisito = resultado.getString("prerequisito");
				sugerido = resultado.getString("sugerido");
				tiempoLimite = resultado.getFloat("tiempoLimite");
				rating = resultado.getFloat("rating");
				lista_resenias = resultado.getString("lista_resenias");
				completado = resultado.getBoolean("completado");
				tipo = resultado.getString("tipo");
				
				Actividad elSugerido = null;
				Actividad elPrerequisito = null;
				if (prerequisito != null || prerequisito != ".") {
					elPrerequisito = getActividadDeString(prerequisito);
				}
				if (sugerido != null || sugerido != ".") {
					elSugerido = getActividadDeString(sugerido);
				}
				
				Actividad estaAct = new Actividad(objetivo, titulo, nivel, elPrerequisito , elSugerido, lista_resenias, tiempoLimite, rating, completado);
				listaAct.add(estaAct);
			}
			resultado.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	return listaAct;
}

public ArrayList<Estudiante> getEstudiantes(){

ArrayList<Estudiante> listaEs = new ArrayList<Estudiante>();
ResultSet resultado;
try {
	Connection con = DriverManager.getConnection(JDBC_URL);
		String login = null;
		String contrasenia = null;
		String nombre = null;
		String apellido = null;
		String historial_lp = null;
		String lp_actual = null;
		String actividad_actual = null;
		float progreso = 0;
		
		String qu = "SELECT * FROM ESTUDIANTES";
		PreparedStatement pstmt = con.prepareStatement(qu);
		resultado = pstmt.executeQuery();
		if (resultado.next()) {
			login = resultado.getString("login");
			contrasenia = resultado.getString("contrasenia");
			nombre = resultado.getString("nombre");
			apellido = resultado.getString("apellido");
			 historial_lp = resultado.getString("historial_lp");
			 lp_actual = resultado.getString("lp_actual");
			 actividad_actual = resultado.getString("actividad_actual");
			 progreso = resultado.getFloat("progreso");
			
			Estudiante esteEstudiante = new Estudiante(contrasenia, nombre, apellido, login);
			if (lp_actual != null || lp_actual != "") {
				esteEstudiante.actualLearningPath = getLearningPathDeString(lp_actual);
			}
			if (actividad_actual != null || actividad_actual != "") {
				esteEstudiante.actualActividad = getActividadDeString(actividad_actual);
			}
			if (historial_lp != null || historial_lp != "") {
				esteEstudiante.historialLearningPaths = getLearningPathsDeString(historial_lp);
			}
			//if (progreso != null || progreso != "") {esteEstudiante.progreso = getProgresoDeString(login);}
			
			
			
			
			listaEs.add(esteEstudiante);
		}
		
		resultado.close();
		
	
	} catch(SQLException e) {
		e.printStackTrace();
	}

return listaEs;
}

public ArrayList<Profesor> getProfesores(){

ArrayList<Profesor> listaProf = new ArrayList<Profesor>();
ResultSet resultado;
try {
	Connection con = DriverManager.getConnection(JDBC_URL);
		String login = null;
		String contrasenia = null;
		String nombre = null;
		String apellido = null;
		String lista_lps = null;
		String lista_actividades = null;

		
		String qu = "SELECT * FROM PROFESORES";
		PreparedStatement pstmt = con.prepareStatement(qu);
		resultado = pstmt.executeQuery();
		while (resultado.next()) {
			login = resultado.getString("login");
			contrasenia = resultado.getString("contrasenia");
			nombre = resultado.getString("nombre");
			apellido = resultado.getString("apellido");
			lista_lps = resultado.getString("lista_lps");
			lista_actividades = resultado.getString("lista_actividades");
			ArrayList<Actividad> arrayActs = getActividadesDeString(lista_actividades);
			ArrayList<LearningPath> arrayLps = getLearningPathsDeString(lista_lps);
			Profesor esteProfe = new Profesor(contrasenia, nombre, apellido, login, arrayLps, arrayActs);
			listaProf.add(esteProfe);
		}
		
		resultado.close();
		
	
	} catch(SQLException e) {
		e.printStackTrace();
	}

return listaProf;
}


public void getProgreso(){
	Progreso miProgreso = null;
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		String learningPath = null;
		String actividades_completadas = null;
		String actividades_incompletas = null;
		String login;
		float porcentaje = 0;
			
			String qu = "SELECT * FROM PROGRESOS";
			PreparedStatement pstmt = con.prepareStatement(qu);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				login =resultado.getString("login");
				learningPath = resultado.getString("learningPath");
				actividades_completadas = resultado.getString("actividades_completadas");
				actividades_incompletas = resultado.getString("actividades_incompletas");
				porcentaje = resultado.getFloat("porcentaje");
				
				miProgreso = new Progreso(getLearningPathDeString(learningPath),login);
				miProgreso.setActividadesCompletadas(getActividadesDeString(actividades_completadas));
				miProgreso.setActividadesIncompletas(getActividadesDeString(actividades_incompletas));
			}
			
			resultado.close();
			
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
}
public ArrayList<String> getInfo(Actividad actividad) {
	ArrayList<String> datos = new ArrayList<String>();	
	ResultSet resultado;
	ResultSet resultado2;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		String qu2 = "SELECT TIPO FROM ACTIVIDADES WHERE TITULO=?";
		PreparedStatement pstmt2 = con.prepareStatement(qu2);
		pstmt2.setString(1, actividad.getTitulo());
		resultado2 = pstmt2.executeQuery();
		String tipo = resultado2.getString("TIPO");	

		String qu = "SELECT * FROM ? WHERE TITULO =?";
		PreparedStatement pstmt = con.prepareStatement(qu);
		
        pstmt.setString(1, tipo);
        pstmt.setString(2, actividad.getTitulo());
		resultado = pstmt.executeQuery();
		
			while (resultado.next()) {
				if(tipo.equals("TAREA")) {
					
					datos.add(resultado.getString("TITULO"));
					datos.add(resultado.getString("OBJETIVO"));	
					datos.add(resultado.getString("NIVEL"));
					datos.add(resultado.getString("PREREQUISITO"));
					datos.add(resultado.getString("SUGERIDO"));
					datos.add( String.valueOf(resultado.getFloat("RATING")));
					datos.add( String.valueOf(resultado.getFloat("TIEMPO_LIMITE")));
					
				}else if (tipo.equals("QUIZ")) {
					
					
				}else if (tipo.equals("EXAMEN")) {
					
					
				}else if (tipo.equals("RECURSO")) {
					
					
				}else if (tipo.equals("ENCUESTA")) {
					
					
				}
			}
			
			resultado.close();
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	return null;
}

}
