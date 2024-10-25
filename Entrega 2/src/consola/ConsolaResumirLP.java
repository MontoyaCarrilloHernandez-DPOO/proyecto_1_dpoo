package consola;

import java.sql.SQLException;
import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.Controlador;
import usuarios.Estudiante;


public class ConsolaResumirLP extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudianteLP = new String[]{ "Continuar con tu actividad actual", "Reseniar tu actividad actual", "Ratear tu actividad actual","Volver al menú principal" };
	private Controlador sistema;
	private Estudiante miEstudiante;
	
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
            	if(miEstudiante.viendoActividad()) {
            		LearningPath lp = miEstudiante.actualLearningPath;
            		ArrayList<Actividad> actividades = lp.getActividades();
            		int i = 1;
            		for(Actividad act : actividades) {
            			System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
						i+=1;
            		}
            		
            		String actual = pedirCadena("Ingrese el titulo de la actividad que quiere empezar");
            		for (Actividad act : actividades) {
						if (act.getTitulo().equals(actual)) {
							miEstudiante.comenzarActividad(act);
							String tipo = "";
							if(tipo.equals("TAREA")) {
								
								
							}else if (tipo.equals("QUIZ")) {
								
								
							}else if (tipo.equals("EXAMEN")) {
								
								
							}else if (tipo.equals("RECURSO")) {
								
								
							}else if (tipo.equals("ENCUESTA")) {
								
								
							}
						}
					}
            	}else {
            		System.out.println("Empieza un Lp o una nueva activiad para continuar.");
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
            mostrarOpciones();
        }

    }

}
