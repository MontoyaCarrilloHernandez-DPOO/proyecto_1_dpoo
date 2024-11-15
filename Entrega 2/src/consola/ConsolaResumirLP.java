package consola;

import java.sql.SQLException;
import java.util.ArrayList;

import learningPaths.Actividad;
import learningPaths.Encuesta;
import learningPaths.Examen;
import learningPaths.LearningPath;
import learningPaths.Quiz;
import learningPaths.Recurso;
import learningPaths.Tarea;
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
            			System.out.println("\n"+i+". Titulo: "+act.getTitulo()+" - Objetivo: "+act.getObjetivo() + "\n");
						i+=1;
            		}
            		
            		String actual = pedirCadena("Ingresa el titulo de la actividad que quieres empezar");
            		
            		for (Actividad act : actividades) {
            			//if (act.getTitulo().equals(actual) )&& miEstudiante.verificarActividadEnLP(act)
						if (act.getTitulo().equals(actual) ) {
							Actividad estaActividad = act;
							estaActividad.getClass();
							
							miEstudiante.comenzarActividad(estaActividad);
							String tipo = losDatos.getTipo(estaActividad);
							System.out.println("Esta actividad es de tipo "+ tipo);
							System.out.println("Titulo: "+ estaActividad.titulo);
							System.out.println("Objetivo: "+ estaActividad.objetivo);
							System.out.println("Nivel: "+ estaActividad.nivel);
							System.out.println("Tiempo limite : "+ estaActividad.tiempoLimite);
							
							
							if(tipo.equals("TAREAS")) {
								Tarea miTarea = (Tarea) estaActividad;
								  
								//seguir modificando
								
								
							}else if (tipo.equals("QUIZES")) {
								Quiz miQuiz = (Quiz) estaActividad;
								
							}else if (tipo.equals("EXAMENES")) {
								Examen miExamen = (Examen) estaActividad;
								
								
							}else if (tipo.equals("RECURSOS")) {
								Recurso miRecurso = (Recurso) estaActividad;
								System.out.println("Tipo de recurso: "+ miRecurso.tipo);
								System.out.println("Disfruta del recurso!");
								
							}else if (tipo.equals("ENCUESTAS")) {
								Encuesta miEncuesta = (Encuesta) estaActividad;
								
							}
							
							//modificiar
							System.out.println("Actividad terminada");
							miEstudiante.terminarActividad();
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
