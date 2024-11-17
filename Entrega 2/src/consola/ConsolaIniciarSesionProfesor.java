package consola;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import consola.ConsolaCrearActividades;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import persistencia.RecogerDatos;
import usuarios.Estudiante;
import usuarios.Profesor;
import learningPaths.LearningPath;
import learningPaths.*;
public class ConsolaIniciarSesionProfesor extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesor = new String[]{ "Crear un Learning Path", "Crear actividad", "Calificar estudiantes", "Salir" };
	private Controlador sistema;
	private Profesor profesor;
	private RecogerDatos recogerDatos = new RecogerDatos();
	
	
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
        	//escoger lp
        	ArrayList<LearningPath> lps = profesor.getLearningPaths();
        	int i = 1;
        	for(LearningPath lp:lps) {
        		System.out.println(i + ")"+lp.getTitulo());
        		i++;
        		
        	}
        int n = 	pedirEntero("Ingrese el numero del lp que quiere calificar");
        LearningPath lp = lps.get(n-1);
        //ArrayList<Estudiante> estudiantes = lp.getEstudiantes();
        
        ArrayList<Estudiante> estudiantes = sistema.listaEstudiantes;
        
        int e = 1;
        for (Estudiante estudiante: estudiantes) {
        		System.out.println(e + ")"+estudiante.getNombre() +" "+ estudiante.getApellido()+":"+estudiante.getLogin());
        		e++;
        }
        int m = 	pedirEntero("Ingrese el numero de la lista de estudiantes que quiera calificar");
        Estudiante estudianteE = estudiantes.get(m-1);
        
        ArrayList<String> examenes = recogerDatos.getListaExamenes(estudianteE);
        
        int p = 1;
        for(String examen:examenes) {
        	System.out.println(p+")"+examen);
    		p++;
        }
        int h = 	pedirEntero("Ingrese el numero de la lista de examenes del estudiante:" + estudianteE.getLogin()+" que quiera calificar");
        String examenE = examenes.get(h-1);
        
		HashMap<String,String> pyr = recogerDatos.getPreguntaRespuesta(estudianteE, examenE);
		int o = 1;
		for(String preg:pyr.keySet()) {
			System.out.println(o+")"+preg+":"+pyr.get(preg));
		
        
		}
		float nota = (float) pedirNumero("Ingrese la nota del examen para este estudiante");
		profesor.calificar(estudianteE, examenE, nota);
		ModificarDatos modificarDatos = new ModificarDatos();
		modificarDatos.cambiarDatosEstudiante(estudianteE.getLogin(), estudianteE.getHistorialLearningPaths(), estudianteE.getActualLearningPath(), estudianteE.getActualActividad(), estudianteE.getRespuestas(), estudianteE.getProgreso());
		modificarDatos.cambiarDatosProgreso(estudianteE.getProgreso());
		}
        
        else if( opcionSeleccionada == 4 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }
		mostrarMenuProfesor( );
	}

}

