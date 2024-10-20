package consola;
import persistencia.RecogerDatos;

public class ConsolaIniciarSesionProfesor extends ConsolaBasica {
	
	private final String[] opcionesMenuProfesor = new String[]{ "Crear un Learning Path", "Crear actividad", "Calificar estudiantes", "Salir" };
	private final String[] opcionesMenuProfesorCreador = new String[]{ "Crear quiz", "Crear recurso", "Crear tarea", "Crear examen","Crear encuesta","Crear Pregunta Abierta","Crear Pregunta Cerrada", "Salir"};
	
	public void autenticar() {
		String login = pedirCadena( "Ingresa tu login " );
    	String contrasenia = pedirCadena( "Ingresa tu contrasenia " );
    	
    	RecogerDatos datos = new RecogerDatos();
    	String contraseniaEsperada = datos.getContraseniaProfesor(login);
    	
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
    		
    	}
	}

}

