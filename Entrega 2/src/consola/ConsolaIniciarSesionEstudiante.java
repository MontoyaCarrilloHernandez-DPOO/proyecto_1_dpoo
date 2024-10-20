package consola;
import persistencia.Controlador;
import persistencia.RecogerDatos;
import usuarios.Estudiante;
import learningPaths.LearningPath;

import java.sql.SQLException;
import java.util.ArrayList;

import Excepciones.LPException;
import consola.ConsolaResumirLP;

public class ConsolaIniciarSesionEstudiante extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudiante = new String[]{ "Incribirse a un Learning Path", "Salirse de tu Learning Path", "Continuar con tu Learning Path actual","Salir" };
	
	private Controlador sistema;
	private Estudiante estudiante;
	
	public ConsolaIniciarSesionEstudiante (Controlador sistema) {
		this.sistema= sistema;
	}
	
	public void autenticar() throws SQLException, LPException {
		String login = pedirCadena( "Ingresa tu login " );
    	String contrasenia = pedirCadena( "Ingresa tu contrasenia " );
    	RecogerDatos datos = new RecogerDatos();
    	
    	ArrayList<String> datosEstudiante= datos.getContraseniaEstudiante(login);
    	String contraseniaEsperada = datosEstudiante.get(0);
    	String nombre = datosEstudiante.get(1);
    	String apellido = datosEstudiante.get(2);
    	
    	
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
    		this.estudiante = new Estudiante(contrasenia, nombre, apellido, login);
    		mostrarMenuEstudiante();
    		
    		
    	}
	}
	
	public void mostrarMenuEstudiante() throws SQLException, LPException {
		int opcionSeleccionada = mostrarMenu( "Menú de Estudiante", opcionesMenuEstudiante );
		if( opcionSeleccionada == 1 )
        {
			LearningPath miLP = null;
			ArrayList<LearningPath> lpsDisponibles = sistema.listaLearningPaths;
			ArrayList<String> opcionesLps = new ArrayList<String>();
			for (LearningPath lp: lpsDisponibles) {
				System.out.println("-"+lp.titulo);
				opcionesLps.addLast(lp.titulo);
			}
			String titulo = pedirCadena("Escribe el titulo de alguno de los Learning Paths para unirte");
			for (LearningPath lp: lpsDisponibles) {
				if (lp.titulo.equals(titulo)) {
					 miLP = lp;
				}
			}
			estudiante.enroll(miLP);
        }
        else if( opcionSeleccionada == 2 )
        {
        	estudiante.unenroll();
        	System.out.println( "Haz salido de este Learning Path con éxito" );
        	
        }
        else if( opcionSeleccionada == 3 )
        {
        	ConsolaResumirLP consola = new ConsolaResumirLP(estudiante, sistema);
        	consola.mostrarOpciones();
        }
        
        else if( opcionSeleccionada == 4 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }
		mostrarMenuEstudiante( );
	}
}
