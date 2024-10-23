package consola;

import java.sql.SQLException;
import java.util.ArrayList;
import usuarios.Profesor;
import learningPaths.LearningPath;
import persistencia.Controlador;

public class ConsolaCrearActividades extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesorCreador = new String[]{ "Crear quiz", "Crear recurso", "Crear tarea", "Crear examen","Crear encuesta","Crear Pregunta Abierta","Crear Pregunta Cerrada", "Volver al menu de profesor"};
	private final String[] opcionesMenuProfesorCreadorLP = new String[]{ "Crear Learning Path Nuevo", "Copiar Learning Path", "Volver al menu de profesor"};
	
	private Profesor profesor;
	private Controlador sistema;
	
	public ConsolaCrearActividades(Controlador sistema) {
		this.sistema = sistema;
	}
	public void mostrarOpcionesActividad(){
		
		boolean salir = false;
		while(!salir) {
			int opcionSeleccionada=mostrarMenu("Menu crear actividades.",opcionesMenuProfesorCreador);
			//Quiz 
			if(opcionSeleccionada == 1) {
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				//print de las actividades
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				//print de las actividades
				String resenias = "";
				int rating = 5;
				float timepoLimite = (float) pedirNumero("Ingrese la fecha limite con formato ddhh .");
				float notaMinima = (float) pedirNumero("Ingrese la nota minima para aprobar el quiz (recuerde que es de 0 a 5).");
				float notaObtenida;
				
				
				
			}
			//Recurso 
			if(opcionSeleccionada == 2) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
								
			}
			//Tarea 
			if(opcionSeleccionada == 3) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				
			}//Examen 
			if(opcionSeleccionada == 4) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				
			}
			//Encuesta 
			if(opcionSeleccionada == 5) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				
			}
			//Pregunta Abierta 
			if(opcionSeleccionada == 6) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				
			}//Pregunta Cerrada
			if(opcionSeleccionada == 7) {
				//TODO
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				
			}
			else if(opcionSeleccionada == 8) {
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
	
}
