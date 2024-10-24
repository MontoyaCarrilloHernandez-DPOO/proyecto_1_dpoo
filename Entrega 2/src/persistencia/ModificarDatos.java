package persistencia;
import java.sql.DriverManager;
import usuarios.Profesor;
import usuarios.Estudiante;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import persistencia.DBConnection;
import java.sql.ResultSet;
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
			resultado = pstmt.executeQuery();
			resultado.close();
			
			} catch(SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public  void cambiarDatosProfesor(String usuario, Profesor profesor) {
		ResultSet resultado;
		try {
			Connection con = DriverManager.getConnection(JDBC_URL);
	
			String qu = "UPDATE PROFESORES SET *COMPLETAR* WHERE login = ?";
			//TODO
			
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
