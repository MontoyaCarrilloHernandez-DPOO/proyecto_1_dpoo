package consola;

import java.sql.SQLException;
import java.util.ArrayList;
import usuarios.Profesor;
import learningPaths.*;
import persistencia.Controlador;

public class ConsolaCrearActividades extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesorCreador = new String[]{ "Crear quiz", "Crear recurso", "Crear tarea", "Crear examen","Crear encuesta", "Volver al menu de profesor"};
	private final String[] opcionesMenuProfesorCreadorLP = new String[]{ "Crear Learning Path Nuevo", "Copiar Learning Path", "Volver al menu de profesor"};
	
	private Profesor profesor;
	private Controlador sistema;
	
	public ConsolaCrearActividades(Controlador sistema, Profesor profe) {
		this.sistema = sistema;
		this.profesor = profe;
	}
	public void mostrarOpcionesActividad() throws SQLException{
		
		boolean salir = false;
		ArrayList<Actividad> actividades = sistema.listaActividades;
		while(!salir) {
			int opcionSeleccionada=mostrarMenu("Menu crear actividades.",opcionesMenuProfesorCreador);
			//Quiz 
			if(opcionSeleccionada == 1) {
				String titulo = pedirCadena("Ingrese el titulo del quiz (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				System.out.println("A continuacion se presentan las actividades disponibles");
				if (actividades == null) {
					System.out.println("No hay actividades disponibles. Esta actividad no tendrá prerequisitos ni actividades sugeridas");
				}
				else {
					int i = 1;
					for (Actividad act : actividades) {
						System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
						i+=1;
					}
					String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del quiz");
					Actividad miPrerequisito = null;
					for (Actividad act : actividades) {
						if (prerequisito.equals(act.titulo)) {
							miPrerequisito = act;
						}
					}
					String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del quiz");
					Actividad miSugerido = null;
					for (Actividad act : actividades) {
						if (sugerido.equals(act.titulo)) {
							miSugerido = act;
						}
					}
					
				}
				
				Actividad miPrerequisito = null;
				Actividad miSugerido = null;
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				float notaMinima = (float) pedirNumero("Ingrese la nota minima para aprobar el quiz (recuerde que es de 0 a 5).");
				float notaObtenida = 0;
				
				System.out.println("A continuacion, podrás crear preguntas cerradas para incluir en tu quiz");
				int cantidadPreguntas = pedirEntero("¿Cuantas preguntas tendra tu quiz?");
				ArrayList<PreguntaCerrada> preguntas = new ArrayList<PreguntaCerrada>();
				int j=1;
				while (j <= cantidadPreguntas) {
					System.out.println("Pregunta " + j + ".");
					String enunciado = pedirCadena("Ingresa el enunciado de la pregunta");
					String opcionA = pedirCadena("Ingresa la opcion A");
					String opcionB = pedirCadena("Ingresa la opcion B");
					String opcionC = pedirCadena("Ingresa la opcion C");
					String opcionD = pedirCadena("Ingresa la opcion D");
					String respuestaCorrecta= pedirCadena("Ingresa la respuesta correcta (Letra)");
					String justificacion = pedirCadena("Ingresa la justificacion de la respuesta");
					
					
					PreguntaCerrada nuevaPregunta = crearPreguntaCerrada(respuestaCorrecta, justificacion, enunciado,opcionA,
							opcionB, opcionC, opcionD);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				
				Quiz miQuiz= new Quiz(notaMinima, notaObtenida, false, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				sistema.listaActividades.add(miQuiz);
				sistema.crearActividad(miQuiz, "Quiz");
				
				
			}
			//Recurso 
			if(opcionSeleccionada == 2) {
				String titulo = pedirCadena("Ingrese el titulo del recurso (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo del recurso");
				String nivel = pedirCadena("Ingrese el nivel del recurso");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del recurso");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del recurso");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				
				Recurso miRecurso= new Recurso(objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				profesor.actividades.add(miRecurso);
				sistema.listaActividades.add(miRecurso);
				sistema.crearActividad(miRecurso, "Recurso");
				
			}
			//Tarea 
			if(opcionSeleccionada == 3) {
				String titulo = pedirCadena("Ingrese el titulo de la tarea (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo de la tarea");
				String nivel = pedirCadena("Ingrese el nivel de la tarea");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito de la tarea");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después de la tarea");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
					
				String resenias = "";
				int rating = 5;
				float timepoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				boolean estado = false;
				Tarea miTarea = new Tarea(false, estado, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, timepoLimite, rating, false);
				sistema.listaActividades.add(miTarea);
				profesor.actividades.add(miTarea);
				sistema.crearActividad(miTarea, "Tarea");
				
			}//Examen 
			if(opcionSeleccionada == 4) {
				String titulo = pedirCadena("Ingrese el titulo del examen (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo del examen");
				String nivel = pedirCadena("Ingrese el nivel del examen");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del examen");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del examen");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				boolean exitoso = false;
				float notaObtenida = 0;
				float notaMinima = (float) pedirNumero("Ingresa la nota mínima para aprobar");
				System.out.println("\n A continuacion, podrás crear preguntas abiertas para incluir en tu examen");
				int cantidadPreguntas = pedirEntero("\n Cuantas preguntas tendra tu examen?");
				ArrayList<PreguntaAbierta> preguntas = new ArrayList<PreguntaAbierta>();
				int j=1;
				while (j <= cantidadPreguntas) {
					System.out.println("\n Pregunta " + j + ".");
					String enunciado = pedirCadena("Ingresa el enunciado de la pregunta");
					String respuestaGuia = pedirCadena("Ingresa la respuesta guia para calificar");
					PreguntaAbierta nuevaPregunta = crearPreguntaAbierta(enunciado, respuestaGuia);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				Examen miExamen = new Examen(false, false, 0, notaMinima, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				profesor.actividades.add(miExamen);
				sistema.listaActividades.add(miExamen);
				sistema.crearActividad(miExamen, "Examen");
				
			}
			//Encuesta 
			if(opcionSeleccionada == 5) {
				String titulo = pedirCadena("Ingrese el titulo de la encuesta (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo de la encuesta");
				String nivel = pedirCadena("Ingrese el nivel de la encuesta");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito de la encuesta");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después de la encuesta");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				int cantidadPreguntas = pedirEntero("\n Cuantas preguntas tendra tu examen?");
				ArrayList<PreguntaAbierta> preguntas = new ArrayList<PreguntaAbierta>();
				int j=1;
				while (j <= cantidadPreguntas) {
					System.out.println("\n Pregunta " + j + ".");
					String enunciado = pedirCadena("Ingresa el enunciado de la pregunta");
					String respuestaGuia = pedirCadena("Ingresa la respuesta guia para calificar");
					PreguntaAbierta nuevaPregunta = crearPreguntaAbierta(enunciado, respuestaGuia);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				
				Encuesta miEncuesta = new Encuesta(false, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				profesor.actividades.add(miEncuesta);
				sistema.listaActividades.add(miEncuesta);
				sistema.crearActividad(miEncuesta, "Encuesta");
				
			}
			
			else if(opcionSeleccionada == 6) {
				salir = true;
				
			}
			mostrarOpcionesActividad();
		}
	}
	
public void mostrarOpcionesLP() throws SQLException{
		
		boolean salir = false;
		while(!salir) {
			int opcionSeleccionada=mostrarMenu("Menu crear Learning Paths",opcionesMenuProfesorCreadorLP);
			//Crear de 0
			if(opcionSeleccionada == 1) {
				//TODO
								
			}
			//Duplicar
			if(opcionSeleccionada == 2) {
				LearningPath miLP = null;
				ArrayList<LearningPath> lpsDisponibles = sistema.listaLearningPaths;
				ArrayList<String> opcionesLps = new ArrayList<String>();
				for (LearningPath lp: lpsDisponibles) {
					System.out.println("-"+lp.titulo);
					opcionesLps.addLast(lp.titulo);
				}
				String titulo = pedirCadena("Escribe el titulo de alguno de los Learning Paths para duplicar");
				for (LearningPath lp: lpsDisponibles) {
					try {
						if (lp.titulo.equals(titulo)) {
							 miLP = lp;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				this.profesor.duplicarLP(miLP);
								
			}
			else if(opcionSeleccionada == 3) {
				salir = true;
				
			}
			mostrarOpcionesLP();
		}
	}
	
public PreguntaAbierta crearPreguntaAbierta(String enunciado, String respuestaGuia) {
	PreguntaAbierta miPreguntaAbierta = new PreguntaAbierta(respuestaGuia, enunciado);
	return miPreguntaAbierta;
	}

public PreguntaCerrada crearPreguntaCerrada(String respuestaCorrecta, String justificacion, String enunciado, String opcionA,
		String opcionB, String opcionC, String opcionD) {
	PreguntaCerrada miPreguntaCerrada = new PreguntaCerrada( respuestaCorrecta,  justificacion,  enunciado,  opcionA,
			 opcionB,  opcionC,  opcionD);
	return miPreguntaCerrada;
	}


}
