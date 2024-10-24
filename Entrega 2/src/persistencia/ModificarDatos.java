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
		ResultSet resultado;
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
		ResultSet resultado;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
			
			ArrayList<LearningPath> listaLPs = profesor.learningPaths;
			ArrayList<Actividad> listaAct = profesor.actividades;
	
			String qu = "UPDATE PROFESORES SET lista_lps = ?, lista_actividades = ? WHERE login = ?";
			PreparedStatement pstmt = con.prepareStatement(qu);
			String listaIdLP = "";
			String listaIdAct = "";
			for (LearningPath lp : listaLPs) {
				listaIdLP += lp.titulo + ",";
			}
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

	
	public void cambiarDatosLP(String cadena){
		
		ResultSet resultado;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "UPDATE LEARNING_PATHS SET *COMPLETAR* WHERE login = ?";
			//TODO
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
		
	
public void cambiarDatosActividad(String cadena){
	ResultSet resultado;
	try {
		Connection con = DriverManager.getConnection(JDBC_URL);

		String qu = "UPDATE ACTIVIDADES SET *COMPLETAR* WHERE login = ?";
		//TODO
		
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
