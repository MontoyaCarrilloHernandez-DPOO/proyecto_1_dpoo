package consola;

public class ConsolaCrearActividades extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesorCreador = new String[]{ "Crear quiz", "Crear recurso", "Crear tarea", "Crear examen","Crear encuesta","Crear Pregunta Abierta","Crear Pregunta Cerrada", "Salir"};
	
	public void mostrarOpciones(){
		
		boolean salir = false;
		while(!salir) {
			int opcionSeleccionada=mostrarMenu("Menu crear actividades.",opcionesMenuProfesorCreador);
			if(opcionSeleccionada == 1) {
				String titulo = pedirCadena("Ingrese el titulo del quiz");
				String objetivo = pedirCadena("Ingrese el objetivo del quiz");
				String nivel = pedirCadena("Ingrese el nivel del quiz");
				int prerequisistos = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				//print de las actividades
				int sugerido = pedirEntero("Ingrese el prerequisito del quiz como un entero");
				//print de las actividades
				
			}
			//String objetivo,String titulo,String nivel,int prerequisistos,int sugeridos,String resenias,int rating,float tiempoLimite,boolean completado,float notaMinima,float notaObtenida,boolean exitoso,String preguntas
			mostrarOpciones();
		}
	}
	
}
