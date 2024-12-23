package persistencia;
import java.sql.DriverManager;
import usuarios.Profesor;
import usuarios.Estudiante;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import learningPaths.PreguntaAbierta;
import learningPaths.Progreso;
import learningPaths.LearningPath;
import learningPaths.PreguntaAbierta;
import learningPaths.Actividad;
import usuarios.Estudiante;


import java.sql.PreparedStatement;

public class ModificarDatos {
	
	private static final String JDBC_URL =  "jdbc:derby:proyecto1";
	
	public void cambiarDatosEstudiante (String usuario,  ArrayList <LearningPath> historialLearningPaths, LearningPath actualLearningPath, Actividad actualActividad, HashMap<Integer, String> respuestas, Progreso progreso) {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "UPDATE ESTUDIANTES SET historial_lp = ?, lp_actual = ?, actividad_actual = ?, respuestas = ?, progreso = ? WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String listaIdLP = "";
			
			for (LearningPath lp : historialLearningPaths) {
				listaIdLP += lp.titulo + ",";
			}
			pstmt.setString(1, listaIdLP);
			
			String miActLP = ".";
			if (!(actualLearningPath==null)) {
				miActLP = actualLearningPath.titulo;
			}
			pstmt.setString(2, miActLP);
			;
			String miAct = ".";
			if (!(actualActividad==null)) {
				miAct = actualActividad.titulo;
			}
			pstmt.setString(3, miAct);
			
			
			String misRtas = "";
			if (respuestas != null) {
			if (!(respuestas.isEmpty())) {
				for (int rta : respuestas.keySet()) {
					misRtas += rta + ",";
				}
			}
			}
			pstmt.setString(4, misRtas);
			
			float miNumero = 0;
			if (progreso!= null) {
				miNumero = (float) (progreso.calcularProgreso());
				
			}
			pstmt.setFloat(5, miNumero);
			pstmt.setString(6, usuario);
			
			
			
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");
	        
	        
	        Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from ESTUDIANTES");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			 pstmt.close();
		     con.close();
		        
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public  void cambiarDatosProfesor(Profesor profesor) {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			
			ArrayList<LearningPath> listaLPs = profesor.learningPaths;
			ArrayList<Actividad> listaAct = profesor.actividades;
			
	
			String qu = "UPDATE PROFESORES SET lista_lps = ?, lista_actividades = ?, lista_estudiantes = ? WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String listaIdLP = "";
			String listaIdAct = "";
			String listaIdEstu = "";
			
			if (listaLPs != null) {
			for (LearningPath lp : listaLPs) {
				listaIdLP += lp.getTitulo() + ",";
				
				ResultSet result;
				PreparedStatement pstmt1 = con.prepareStatement( "SELECT * FROM LEARNING_PATHS WHERE TITULO = ?");
				pstmt1.setString(1, lp.getTitulo());
				result = pstmt1.executeQuery();
				String idsEstu = "";
				if (result.next()) {
					idsEstu = result.getString("ESTUDIANTES"); 
				}
				String[] estArray = null;
				if (idsEstu!="") {
				estArray = idsEstu.split(",");
				}
				if (estArray != null) {
				for (String e : estArray) {
					listaIdEstu += e+",";
				}}
				
				
			}}
			
			if (listaAct != null) {
			for (Actividad actividad : listaAct) {
				listaIdAct += actividad.titulo + ",";
			}}
			
			
			pstmt.setString(1, listaIdLP);
			pstmt.setString(2, listaIdAct);
			pstmt.setString(3, listaIdEstu);
			pstmt.setString(4, profesor.login);
			
			System.out.println("\n");
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");
	        System.out.println("\n");
	        Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from PROFESORES");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");}

	        pstmt.close();
	        con.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}

	
	public void cambiarDatosLP(LearningPath lp){
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "UPDATE LEARNING_PATHS SET Actividades = ?, Estudiantes = ? WHERE titulo = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String misAct = "";
			String misEst = "";
			for (Actividad act : lp.getActividades()) {
				misAct+= act.titulo + ",";
			}
			
			for (Estudiante est : lp.getEstudiantes()) {
				misEst+= est.login + ",";
			}
			
			pstmt.setString(1, misAct);
			pstmt.setString(2, misEst);
			pstmt.setString(3, lp.titulo);
			
			System.out.println("\n");
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");
	        System.out.println("\n");
	        Statement statement  = con.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from LEARNING_PATHS");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int columnCount = resultSetMetaData.getColumnCount();
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
			while (resultSet.next()) {
				System.out.println("");
				for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
			}
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
	
public void cambiarDatosProgreso(Progreso progreso){
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);

		String qu = "UPDATE PROGRESOS SET learningPath = ?, actividades_completadas = ?, actividades_incompletas = ?, porcentaje = ? WHERE login = ?";
		
		
		PreparedStatement pstmt = con.prepareStatement(qu);
		
	
		String misActCompletas = "";
		String misActIncompletas = "";
		
		if (!progreso.getActividadesCompletas().isEmpty() || progreso.getActividadesCompletas() != null ) {
		for (Actividad act : progreso.getActividadesCompletas()) {
			if (act != null) {
			misActCompletas+= act.titulo + ",";}
		}
		}
		
		if (!progreso.getActividadesIncompletas().isEmpty() || progreso.getActividadesCompletas() != null) {
		for (Actividad act : progreso.getActividadesIncompletas()) {
			if (act != null) {
			misActIncompletas+= act.titulo + ",";}
		}
		}
		
		String lpTitulo = null;
		
		if (progreso.getLearningPath() != null) {
			lpTitulo=progreso.getLearningPath().titulo;
		}
		pstmt.setString(1, lpTitulo);
		pstmt.setString(2, misActCompletas);
		pstmt.setString(3, misActIncompletas);
		pstmt.setFloat(4, (float) progreso.calcularProgreso());
		pstmt.setString(5, progreso.getEstudiante());
		
		
		System.out.println("\n");
		int filasActualizadas = pstmt.executeUpdate();
        System.out.println(filasActualizadas + " filas actualizadas.");
        System.out.println("\n");
        Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from PROGRESOS");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
}

public void cambiarDatosActividad(Actividad act){
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);
		ResultSet resultado;
		float ratingOriginal = 0;
		String reseniasOriginales = "";
		
		PreparedStatement pstmt1 = con.prepareStatement("SELECT * FROM ACTIVIDADES WHERE titulo = ?");
	    pstmt1.setString(1, act.titulo);
		resultado = pstmt1.executeQuery();
		if (resultado.next()) {
			ratingOriginal= resultado.getFloat("rating");
			reseniasOriginales = resultado.getString("lista_resenias");
		}
		resultado.close();
		
		
		String qu = "UPDATE ACTIVIDADES SET rating = ?, lista_resenias = ? WHERE titulo = ?";
		PreparedStatement pstmt = con.prepareStatement(qu);
		float miRating = 0;
		String misResenias = "";
		
		miRating = ((float) act.getRating() + ratingOriginal)/2;
		misResenias = reseniasOriginales +","+ act.getResenias();
		
		
		pstmt.setFloat(1, miRating);
		pstmt.setString(2, misResenias);
		pstmt.setString(3, act.titulo);
		
		System.out.println("\n");
		int filasActualizadas = pstmt.executeUpdate();
        System.out.println(filasActualizadas + " filas actualizadas.");
        System.out.println("\n");
        Statement statement  = con.createStatement();
		ResultSet resultSet = statement.executeQuery("Select * from ACTIVIDADES");
		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSetMetaData.getColumnName(x)+ " | ");
		while (resultSet.next()) {
			System.out.println("");
			for (int x = 1; x<=columnCount; x++) System.out.format("%20s", resultSet.getString(x)+ " | ");
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
}
	

public void eliminarProgreso(Progreso progreso){
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);

		String qu = "DELETE FROM PROGRESOS WHERE login = ?";
		PreparedStatement pstmt = con.prepareStatement(qu);
		pstmt.setString(1, progreso.getEstudiante());
		int filasActualizadas = pstmt.executeUpdate();
        System.out.println(filasActualizadas + " filas actualizadas.");
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
}


	public ArrayList<String> stringToArrayList(String string){
		ArrayList<String> arrayFinal = new ArrayList<String>();
		String[] arrayStrings = string.split(",");
		for (String cadena:arrayStrings) {
			arrayFinal.addLast(cadena);
		}
		return arrayFinal;
	}
	
	}
