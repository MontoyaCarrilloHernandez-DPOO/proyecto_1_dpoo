package consola;

import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;
import java.sql.SQLException;
import java.util.ArrayList;
import Excepciones.LPException;
import consola.ConsolaResumirLP;
import persistencia.*;
import learningPaths.*;

public class ConsolaIniciarSesionEstudiante extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudiante = new String[]{ "Incribirse a un Learning Path", "Salirse de tu Learning Path", "Continuar con tu Learning Path actual","Salir" };
	
	private Controlador sistema;
	private Estudiante estudiante;
	private ModificarDatos modificarDatos = new ModificarDatos();
	
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
    	String historial_lp = datosEstudiante.get(3);
		String lp_actual = datosEstudiante.get(4);
		String actividad_actual = datosEstudiante.get(5);
    	
    	
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
    		for (Estudiante estu : sistema.listaEstudiantes) {
    			if (estu.login.equals(login)) {
    				this.estudiante = estu;
    			}
    		}
    		/**
    		this.estudiante = new Estudiante(contrasenia, nombre, apellido, login);
    		Actividad miActividad = null;
    		LearningPath miLP = null;
    		ArrayList<LearningPath> miHistorial = null;
    		
    		if (actividad_actual != null || actividad_actual != "") {
    		 miActividad = datos.getActividadDeString(actividad_actual);}
    		if (lp_actual != null || lp_actual != "") {
    		 miLP = datos.getLearningPathDeString(lp_actual);}
    		if (historial_lp != null || historial_lp != "") {
    		miHistorial = datos.getLearningPathsDeString(historial_lp);}
    		
    		Progreso miProgreso = datos.getProgresoDeString(this.estudiante.login);
    		
    		this.estudiante.actualActividad = miActividad;
    		this.estudiante.actualLearningPath = miLP;
    		this.estudiante.historialLearningPaths = miHistorial;
    		this.estudiante.progreso = miProgreso;
    		
    		this.sistema.listaEstudiantes.add(estudiante);
    		**/
    		
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
				if (lp.titulo.toUpperCase().equals(titulo.toString().toUpperCase())) {
					System.out.println(":)");
					 miLP = lp;
				}
			}
			
			estudiante.enroll(miLP);
			modificarDatos.cambiarDatosLP(miLP);
			ArrayList<Profesor> misprof = sistema.listaProfesores;
			Profesor miProfLP = null;
			for (Profesor p : misprof) {
				if (p.login.equals(miLP.propietario)) {
					miProfLP = p;
				}
			}
			modificarDatos.cambiarDatosProfesor(miProfLP);
			
        }
        else if( opcionSeleccionada == 2 )
        {
        	LearningPath lpActual = estudiante.actualLearningPath;
        	estudiante.unenroll();
        	Progreso prog = new Progreso(null, estudiante.login);
        	modificarDatos.cambiarDatosEstudiante(this.estudiante.login, this.estudiante.getHistorialLearningPaths(), this.estudiante.actualLearningPath, this.estudiante.actualActividad, this.estudiante.respuestas, this.estudiante.progreso);
        	modificarDatos.cambiarDatosProgreso(prog);
        
			modificarDatos.cambiarDatosLP(lpActual);
			
			ArrayList<Profesor> misprof = sistema.listaProfesores;
			Profesor miProfLP = null;
			for (Profesor p : misprof) {
				if (p.login.equals(lpActual.propietario)) {
					miProfLP = p;
				}
			}
			modificarDatos.cambiarDatosProfesor(miProfLP);
        	
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
