package consola;
import java.sql.SQLException;
import java.util.ArrayList;
import consola.ConsolaCrearActividades;
import persistencia.Controlador;
import persistencia.RecogerDatos;
import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;
import learningPaths.*;
public class ConsolaIniciarSesionProfesor extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesor = new String[]{ "Crear un Learning Path", "Crear actividad", "Calificar estudiantes", "Salir" };
	private Controlador sistema;
	private Profesor profesor;
	
	public ConsolaIniciarSesionProfesor (Controlador sistema) {
		this.sistema= sistema;
	}
	
	public void autenticar() throws SQLException {
		String login = pedirCadena( "Ingresa tu login " );
    	String contrasenia = pedirCadena( "Ingresa tu contrasenia " );
    	RecogerDatos datos = new RecogerDatos();
    	
    	ArrayList<String> datosProfe= datos.getContraseniaProfesor(login);
    	String contraseniaEsperada = datosProfe.get(0);
    	String nombre = datosProfe.get(1);
    	String apellido = datosProfe.get(2);
    	String DBLearningPaths = datosProfe.get(3);
    	String DBActividades = datosProfe.get(4);
    	
    	if (! contrasenia.equals(contraseniaEsperada)) {
    		int respuesta = pedirEntero( "Contrasena o login incorrecto. Pulsa 1 para volver a intentar o 2 para salir ");
    		if (respuesta == 1) {
    			autenticar();
    		} else {
    			System.out.println( "Saliendo ..." );
                System.exit( 0 );
    		}
    	} else {
    		System.out.println("Inicio de sesión correcto");
    		
    		for (Profesor prof : sistema.listaProfesores) {
    			if (prof.login.equals(login)) {
    				this.profesor = prof;
    			}
    		}
    		/**
    		ArrayList<LearningPath> LearningPaths = datos.getLearningPathsDeString(DBLearningPaths);
    		ArrayList<Actividad> actividades = datos.getActividadesDeString(DBActividades);
    		this.profesor = new Profesor(contrasenia, nombre, apellido, login,LearningPaths, actividades);
    		**/
    		
    		mostrarMenuProfesor();
    		
    	}
	}
	
	public void mostrarMenuProfesor() throws SQLException {
		int opcionSeleccionada = mostrarMenu( "Menú de Profesor", opcionesMenuProfesor );
		ConsolaCrearActividades consola = new ConsolaCrearActividades(sistema, profesor);
		if( opcionSeleccionada == 1 )
        {
			consola.mostrarOpcionesLP();
        }
        else if( opcionSeleccionada == 2 )
        { 
        	consola.mostrarOpcionesActividad();
        }
        else if( opcionSeleccionada == 3 )
        {
        	//TODO MIRAR COMO HACER LAS PREGUNTSAS Y CALIFICAR
        }
        
        else if( opcionSeleccionada == 4 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }
		mostrarMenuProfesor( );
	}

}

