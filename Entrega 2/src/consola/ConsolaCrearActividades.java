package consola;

import java.sql.SQLException;
import java.util.ArrayList;
import usuarios.Profesor;
import learningPaths.*;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import persistencia.RecogerDatos;
import consola.*;


public class ConsolaCrearActividades extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesorCreador = new String[]{ "Crear quiz", "Crear recurso", "Crear tarea", "Crear examen","Crear encuesta", "Volver al menu de profesor"};
	private final String[] opcionesMenuProfesorCreadorLP = new String[]{ "Crear Learning Path Nuevo", "Copiar Learning Path", "Volver al menu de profesor"};
	private ModificarDatos modificarDatos;
	private Profesor profesor;
	private Controlador sistema;
	private RecogerDatos recogerDatos = new RecogerDatos();
	private ConsolaIniciarSesionProfesor consolaProfe;
	
	public ConsolaCrearActividades(Controlador sistema, Profesor profe) {
		this.sistema = sistema;
		this.profesor = profe;
		this.modificarDatos = new ModificarDatos();
		this.consolaProfe =  new ConsolaIniciarSesionProfesor(this.sistema);
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
					int i = 1;
					for (Actividad act : actividades) {
						System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
						i+=1;
					}
					String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del quiz. Si no hay, digita \".\" ");
					Actividad miPrerequisito = null;
					for (Actividad act : actividades) {
						if (prerequisito.equals(act.titulo)) {
							miPrerequisito = act;
						}
					}
					String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del quiz. Si no hay, digita \".\" ");
					Actividad miSugerido = null;
					for (Actividad act : actividades) {
						if (sugerido.equals(act.titulo)) {
							miSugerido = act;
						}
					}			
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese el tiempo limite con formato hhmm");
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
					sistema.crearPreguntaCerrada(nuevaPregunta);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				Quiz miQuiz= new Quiz(notaMinima, notaObtenida, false, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				
				this.profesor.anadirActs(miQuiz);
				
				sistema.crearQuiz(miQuiz);
				modificarDatos.cambiarDatosProfesor(this.profesor);
				
			}
			//Recurso 
			else if(opcionSeleccionada == 2) {
				String titulo = pedirCadena("Ingrese el titulo del recurso (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo del recurso");
				String nivel = pedirCadena("Ingrese el nivel del recurso");
				System.out.println("\n A continuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del recurso.  Si no hay, digita \".\"");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del recurso.  Si no hay, digita \".\"");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese el tiempo limite con formato hhmm");
				String tipo = pedirCadena("Ingrese el tipo del recurso");
				Recurso miRecurso= new Recurso(objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false,tipo);
				profesor.actividades.add(miRecurso);
				
				
				sistema.crearRecurso(miRecurso);
				modificarDatos.cambiarDatosProfesor(profesor);
				
			}
			//Tarea 
			else if(opcionSeleccionada == 3) {
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
				float timepoLimite = (float) pedirNumero("Ingrese el tiempo limite con formato hhmm");
				boolean estado = false;
				Tarea miTarea = new Tarea(estado, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, timepoLimite, rating, false);
				profesor.actividades.add(miTarea);
				sistema.crearTarea(miTarea);
				modificarDatos.cambiarDatosProfesor(profesor);
				
			}//Examen 
			else if(opcionSeleccionada == 4) {
				String titulo = pedirCadena("Ingrese el titulo del examen (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo del examen");
				String nivel = pedirCadena("Ingrese el nivel del examen");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito del examen. Si no hay, digita \".\"");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después del examen. Si no hay, digita \".\"");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese el tiempo limite con formato hhmm");
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
					sistema.crearPreguntaAbierta(nuevaPregunta);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				Examen miExamen = new Examen(false, false, 0, notaMinima, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				profesor.actividades.add(miExamen);
				sistema.crearExamen(miExamen);
				modificarDatos.cambiarDatosProfesor(profesor);
				
			}
			//Encuesta 
			else if(opcionSeleccionada == 5) {
				String titulo = pedirCadena("Ingrese el titulo de la encuesta (sin espacios)");
				String objetivo = pedirCadena("Ingrese el objetivo de la encuesta");
				String nivel = pedirCadena("Ingrese el nivel de la encuesta");
				System.out.println("\n A conitnuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println("\n"+i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				String prerequisito = pedirCadena("Ingrese el nombre del prerequisito de la encuesta. Si no hay, digita \".\"");
				Actividad miPrerequisito = null;
				for (Actividad act : actividades) {
					if (prerequisito.equals(act.titulo)) {
						miPrerequisito = act;
					}
				}
				String sugerido = pedirCadena("Ingrese el nombre de la actividad sugerida después de la encuesta. Si no hay, digita \".\"");
				Actividad miSugerido = null;
				for (Actividad act : actividades) {
					if (sugerido.equals(act.titulo)) {
						miSugerido = act;
					}
				}
				
				String resenias = "";
				int rating = 5;
				float tiempoLimite = (float) pedirNumero("Ingrese el tiempo limite con formato hhmm");
				int cantidadPreguntas = pedirEntero("\n Cuantas preguntas tendra tu examen?");
				ArrayList<PreguntaAbierta> preguntas = new ArrayList<PreguntaAbierta>();
				int j=1;
				while (j <= cantidadPreguntas) {
					System.out.println("\n Pregunta " + j + ".");
					String enunciado = pedirCadena("Ingresa el enunciado de la pregunta");
					String respuestaGuia = pedirCadena("Ingresa la respuesta guia para calificar");
					PreguntaAbierta nuevaPregunta = crearPreguntaAbierta(enunciado, respuestaGuia);
					sistema.crearPreguntaAbierta(nuevaPregunta);
					preguntas.add(nuevaPregunta);
					j+=1;
				}
				
				Encuesta miEncuesta = new Encuesta(false, preguntas, objetivo, titulo, nivel, miPrerequisito, miSugerido, resenias, tiempoLimite, rating, false);
				profesor.actividades.add(miEncuesta);
				sistema.crearEncuesta(miEncuesta);
				modificarDatos.cambiarDatosProfesor(profesor);
				
			}
			
			else if(opcionSeleccionada == 6) {
				salir = true;
				
			}
		}
	}
	
public void mostrarOpcionesLP() throws SQLException{
		
		boolean salir = false;
		while(!salir) {
			int opcionSeleccionada=mostrarMenu("Menu crear Learning Paths",opcionesMenuProfesorCreadorLP);
			if(opcionSeleccionada == 1) {
				ArrayList<Actividad> actividades = sistema.listaActividades;
				
				String titulo = pedirCadena("Ingresa el nombre del Learning Path (sin espacios)");
				float duracion = (float) pedirNumero("Ingesa la duracion del Learning Path");
				String descripcion = pedirCadena("Ingresa la descripcion del Learning Path");
				String objetivo = pedirCadena("Ingresa el objetivo del Learning Path");
				float dificultad = (float) pedirNumero("Ingresa la dificultad del Learning Path");
				String metadatos = pedirCadena("Ingresa los metadatos del Learning Path");
				System.out.println("\n A cotinuacion se presentan las actividades disponibles");
				int i = 1;
				for (Actividad act : actividades) {
					System.out.println(i+". Titulo: "+act.titulo+" - Objetivo: "+act.objetivo + "\n");
					i+=1;
				}
				String actividadesLP = pedirCadena("Ingrese los titulos de las actividades separados por comas y sin espacios");
				ArrayList<Actividad> Actividades = recogerDatos.getActividadesDeString(actividadesLP);
				
				LearningPath miLP = new LearningPath(profesor.login, titulo, duracion, dificultad, 5, descripcion, objetivo, metadatos, Actividades, null);
				sistema.crearLearningPath(miLP);
				profesor.crearLearningPath(Actividades, titulo, descripcion, objetivo, metadatos, duracion, dificultad,5);
				
				modificarDatos.cambiarDatosProfesor(profesor);
				
				
			}
			//Duplicar
			else if(opcionSeleccionada == 2) {
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
						e.printStackTrace();
					}
				}
				this.profesor.duplicarLP(miLP);
				sistema.crearLearningPath(miLP);
				modificarDatos.cambiarDatosProfesor(profesor);
								
			}
			else if(opcionSeleccionada == 3) {
				salir = true;
				
			}
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
