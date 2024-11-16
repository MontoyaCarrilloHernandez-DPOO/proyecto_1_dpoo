package consola;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import learningPaths.*;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import persistencia.RecogerDatos;
import usuarios.Estudiante;
import persistencia.AnadirDatos;


public class ConsolaResumirLP extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudianteLP = new String[]{ "Continuar con tu actividad actual", "Reseniar una actividad", "Ratear una actividad","Volver al menú principal" };
	private Controlador sistema;
	private Estudiante miEstudiante;
	private RecogerDatos losDatos= new RecogerDatos();
	private ModificarDatos modificarDatos = new ModificarDatos();
	private AnadirDatos anadirDatos = new AnadirDatos();
	
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
							
							miEstudiante.comenzarActividad(estaActividad);
							String tipo = losDatos.getTipo(estaActividad);
							System.out.println("Esta actividad es de tipo "+ tipo);
							System.out.println("Titulo: "+ estaActividad.titulo);
							System.out.println("Objetivo: "+ estaActividad.objetivo);
							System.out.println("Nivel: "+ estaActividad.nivel);
							System.out.println("Tiempo limite : "+ estaActividad.tiempoLimite);
							
							
							
							if(tipo.equals("TAREAS")) {
								Tarea miTarea = (Tarea) estaActividad;
								System.out.println("Te recomendamos hacer la tarea; es importante para tu conocimiento");
								String rta = pedirCadena("Ingresa 1 si ya terminaste la tarea");
								if (rta=="1") {
									miTarea.setCompletado();
								}
								System.out.println("Actividad terminada");
								miEstudiante.terminarActividad();
								
								
							}else if (tipo.equals("QUIZES")) {
								Quiz miQuiz = (Quiz) estaActividad;
								System.out.println("A continuacion presentaras un quiz de " + miQuiz.preguntas.size() + " preguntas.");
								System.out.println("La nota minima para aprobar es " + miQuiz.notaMinima);
								System.out.println("Escribe la letra de la respuesta en mayuscula sin espacios, de lo contrario no se contara la respuesta.");
								int numb = 1;
								int correctas = 0;
								int numeroPreguntas = miQuiz.preguntas.size();
								for (PreguntaCerrada preg : miQuiz.preguntas) {
									System.out.println(numb + "." + " " + preg.getEnunciado());
									System.out.println("A) " + preg.opcionA);
									System.out.println("B) " + preg.opcionA);
									System.out.println("C) " + preg.opcionA);
									System.out.println("D) " + preg.opcionA);
									String rta = pedirCadena("Respuesta: ");
									String respuestaCorrecta = preg.respuestaCorrecta;
									if (rta.equals(respuestaCorrecta)) {
										System.out.println("Justificacion: " + preg.justificacion);
										correctas +=1 ;
									}
									else {
										System.out.println("Respuesta incorrecta");
									}
									numb+=1;
								}
								float notaObtenida = (correctas/numeroPreguntas)*5;
								if (notaObtenida >= miQuiz.notaMinima) {
									System.out.println("Felicitaciones, aprobaste el quiz con " + notaObtenida);
									System.out.println("Actividad terminada");
									miEstudiante.terminarActividad();
								}
								else {
									System.out.println("No aprobaste el quiz, debes volverlo a hacer");
									System.out.println("Tu calificacion fue : " + notaObtenida);
								}
								
							}else if (tipo.equals("EXAMENES")) {
								Examen miExamen = (Examen) estaActividad;
								System.out.println("A continuacion presentaras un examen de " + miExamen.preguntas.size() + " preguntas.");
								System.out.println("La nota minima para aprobar es " + miExamen.notaMinima);
								int numb = 1;
								for (PreguntaAbierta preg : miExamen.preguntas) {
									System.out.println(numb + "." + " " + preg.getEnunciado());
									String rta = pedirCadena("Respuesta: ");
									int idEsperado = anadirDatos.nuevaRespuesta(miEstudiante.login, estaActividad.titulo, preg.enunciado, rta);
									miEstudiante.respuestas.put(idEsperado, actual);
									numb+=1;
								}
								System.out.println("Tu progreso no se modificara hasta que tu profesor haya calificado el examen.");
								System.out.println("No intentes volver a hacer el examen, sino sera anulado.");
								miEstudiante.actualActividad = null;
								
								
							}else if (tipo.equals("RECURSOS")) {
								Recurso miRecurso = (Recurso) estaActividad;
								System.out.println("Tipo de recurso: "+ miRecurso.tipo);
								System.out.println("Disfruta del recurso!");
								miRecurso.setCompletado();
								System.out.println("Actividad terminada");
								miEstudiante.terminarActividad();
								
							}else if (tipo.equals("ENCUESTAS")) {
								Encuesta miEncuesta = (Encuesta) estaActividad;
								System.out.println("A continuacion responderas una encuesta de " + miEncuesta.preguntas.size() + " preguntas.");
								int numb = 1;
								HashMap<PreguntaAbierta, String> pregsRes = new HashMap<PreguntaAbierta, String> ();
								for (PreguntaAbierta preg : miEncuesta.preguntas) {
									//la verdad me da pereza implementarlo en la DB ya que las encuestas no se califican
									//lo dejo así mientras
									System.out.println(numb + "." + " " + preg.getEnunciado());
									String rta = pedirCadena("Respuesta: ");
									pregsRes.put(preg, rta);
									numb+=1;
								}
								miEncuesta.setCompletado();
								System.out.println("Actividad terminada");
								miEstudiante.terminarActividad();
							}
							
							modificarDatos.cambiarDatosEstudiante(miEstudiante.login, miEstudiante.getHistorialLearningPaths(), miEstudiante.actualLearningPath,miEstudiante.actualActividad, miEstudiante.getRespuestas(), miEstudiante.getProgreso());
							modificarDatos.cambiarDatosProgreso(miEstudiante.getProgreso());
							}
							
						}
					}
            	else {
            		System.out.println("Inscribete a un LP para comenzar");
            	}
    		}
            else if( opcionSeleccionada == 2 )
            {
            	ArrayList<Actividad> actividades = miEstudiante.progreso.getActividadesCompletas();
		 		
        		int i = 1;
        		for(Actividad act : actividades) {
        			System.out.println("\n"+i+". Titulo: "+act.getTitulo()+" - Objetivo: "+act.getObjetivo() + "\n");
					i+=1;
        		}
        		
        		String actual = pedirCadena("Ingresa el titulo de la actividad que quieres empezar");
        		
        		for (Actividad act : actividades) {
					if (act.getTitulo().equals(actual) ) {
						Actividad estaActividad = act;
						String resenia = pedirCadena("Ingresa tu resenia");
						miEstudiante.reseniar(resenia,estaActividad);
						modificarDatos.cambiarDatosActividad(act);
					}
        		}
        		
        		
            }
            else if( opcionSeleccionada == 3 )
            {
ArrayList<Actividad> actividades = miEstudiante.progreso.getActividadesCompletas();
		 		
        		int i = 1;
        		for(Actividad act : actividades) {
        			System.out.println("\n"+i+". Titulo: "+act.getTitulo()+" - Objetivo: "+act.getObjetivo() + "\n");
					i+=1;
        		}
        		
        		String actual = pedirCadena("Ingresa el titulo de la actividad que quieres empezar");
        		
        		for (Actividad act : actividades) {
					if (act.getTitulo().equals(actual) ) {
						Actividad estaActividad = act;
						double rating = pedirNumero("Ingresa tu rating (recuerda que es sobre 5)");
		            	miEstudiante.ratear(rating, estaActividad);
						modificarDatos.cambiarDatosActividad(act);
					}
        		}
        		
            	
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
