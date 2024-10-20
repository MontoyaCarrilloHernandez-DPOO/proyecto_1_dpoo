package consola;
import persistencia.RecogerDatos;

public class ConsolaIniciarSesionEstudiante extends ConsolaBasica {
	
	private final String[] opcionesMenuEstudiante = new String[]{ "Incribirse a un Learning Path", "Salirse de un Learning Path", "Continuar con tu Learning Path actual","Salir" };
	private final String[] opcionesMenuEstudianteLP = new String[]{ "Continuar con tu actividad actual", "Reseniar tu actividad actual", "Reseniar tu Learning Path actual","Volver al menú principal" };
	
	
	public void autenticar() {
		String login = pedirCadena( "Ingresa tu login " );
    	String contrasenia = pedirCadena( "Ingresa tu contrasenia " );
    	
    	RecogerDatos datos = new RecogerDatos();
    	String contraseniaEsperada = datos.getContraseniaEstudiante(login);
    	
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
