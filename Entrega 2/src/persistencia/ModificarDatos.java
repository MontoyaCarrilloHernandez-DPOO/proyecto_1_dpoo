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
	
	public void cambiarDatosEstudiante (String usuario,  ArrayList <LearningPath> historialLearningPaths, LearningPath actualLearningPath, Actividad actualActividad, HashMap<PreguntaAbierta, String> respuestas, Progreso progreso) {
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "UPDATE ESTUDIANTES SET historial_lp = ?, lp_actual = ?, actividad_actual = ? WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String listaIdLP = "";
			for (LearningPath lp : historialLearningPaths) {
				listaIdLP += lp.titulo + ",";
			}
			pstmt.setString(1, listaIdLP);
			pstmt.setString(2, actualLearningPath.titulo);
			pstmt.setString(3, actualActividad.titulo);
			pstmt.setString(4, usuario);
			
			
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");

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
	
			String qu = "UPDATE PROFESORES SET lista_lps = ?, lista_actividades = ? WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String listaIdLP = "";
			String listaIdAct = "";
			if (listaLPs != null) {
			for (LearningPath lp : listaLPs) {
				listaIdLP += lp.titulo + ",";
			}}
			for (Actividad act : listaAct) {
				listaIdAct += act.titulo + ",";
			}
			pstmt.setString(1, listaIdLP);
			pstmt.setString(2, listaIdAct);
			pstmt.setString(3, profesor.login);
			
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");
	        
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
			
			
			int filasActualizadas = pstmt.executeUpdate();
	        System.out.println(filasActualizadas + " filas actualizadas.");
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
	
public void cambiarDatosProgreso(Progreso progreso){
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);

		String qu = "UPDATE PROGESOS SET learningPath = ?, actividades_completadas = ?, actividades_incompletas = ?, porcentaje = ? WHERE login = ?";
		
		
		PreparedStatement pstmt = con.prepareStatement(qu);
		
		String misActCompletas = "";
		String misActIncompletas = "";
		for (Actividad act : progreso.getActividadesCompletas()) {
			misActCompletas+= act.titulo + ",";
		}
		
		for (Actividad act : progreso.getActividadesIncompletas()) {
			misActIncompletas+= act.titulo + ",";
		}
		
		pstmt.setString(1, progreso.getEstudiante());
		pstmt.setString(2, progreso.getLearningPath().titulo);
		pstmt.setString(3, misActCompletas);
		pstmt.setString(4, misActIncompletas);
		pstmt.setFloat(5, (float) progreso.calcularProgreso());
		
		int filasActualizadas = pstmt.executeUpdate();
        System.out.println(filasActualizadas + " filas actualizadas.");
		
		} catch(SQLException e) {
			e.printStackTrace();
		}
}

public void eliminarProgreso(Progreso progreso){
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);

		String qu = "DELETE FROM PROGRESOS WHERE login = ?;";
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
