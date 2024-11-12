package consola;

import java.sql.SQLException;
import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.Controlador;
import persistencia.RecogerDatos;
import usuarios.Estudiante;


public class ConsolaResumirLP extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudianteLP = new String[]{ "Continuar con tu actividad actual", "Reseniar tu actividad actual", "Ratear tu actividad actual","Volver al menú principal" };
	private Controlador sistema;
	private Estudiante miEstudiante;
	private RecogerDatos losDatos= new RecogerDatos();
	
	public ConsolaResumirLP(Estudiante estudiante, Controlador sistema) {
		this.miEstudiante = estudiante;
		this.sistema = sistema;
	}
	
	public void mostrarOpciones() throws SQLException
    {
        boolean regresar = false;
        while( !regresar )
        {
            int opcionSeleccionada = mostrarMenu( "Menú de Progreso", opcionesMenuEstudianteLP );
            if( opcionSeleccionada == 1 )
            {
            	// TODO Crear nueva funcion que muestre las atcividades y eso e imprimir y cambie el progreso
            	
            	if(!miEstudiante.actualLearningPath.equals(null)) {
            		
            		LearningPath lp = miEstudiante.actualLearningPath;
            		
            		ArrayList<Actividad> actividades = miEstudiante.progreso.getActividadesIncompletas();
            		       		
            		int i = 1;
            		for(Actividad act : actividades) {
            			System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
						i+=1;
            		}
            		
            		String actual = pedirCadena("Ingresa el titulo de la actividad que quieres empezar");
            		
            		for (Actividad act : actividades) {
						if (act.getTitulo().equals(actual) && miEstudiante.verificarActividadEnLP(act)) {
							miEstudiante.comenzarActividad(act);
							Actividad actividad = losDatos.getActividadDeString(actual);
							ArrayList<String> info = losDatos.getInfo(actividad);
							for (String ele:info) {
								System.out.println(ele);
								
								
							Actividad estaActividad = act;
							String cadena = pedirCadena("Ingrese 1 cuando termine la tarea");
							if (cadena.equals("1")) {
								miEstudiante.terminarActividad();
							}
							}
						}
					}
            	}
            	else {
            		System.out.println("Inscribete a un LP para comenzar");
            	}
            }
            else if( opcionSeleccionada == 2 )
            {
            	String resenia = pedirCadena("Ingresa tu resenia");
            	miEstudiante.reseniar(resenia, miEstudiante.actualActividad);
            }
            else if( opcionSeleccionada == 3 )
            {
            	double rating = pedirNumero("Ingresa tu rating (recuerda que es sobre 5)");
            	miEstudiante.ratear(rating, miEstudiante.actualActividad);
            }
            else if( opcionSeleccionada == 4 )
            {
                regresar = true;
            }
            
            if (!regresar) {
            	mostrarOpciones();
            }
            
        }

    }

}
