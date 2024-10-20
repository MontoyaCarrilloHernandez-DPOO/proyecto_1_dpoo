package consola;
import persistencia.RecogerDatos;

public class ConsolaIniciarSesionEstudiante extends ConsolaBasica {
	
	
	
	public void autenticar() {
		String login = pedirCadena( "Ingresa tu login: " );
    	String contrasenia = pedirCadena( "Ingresa tu contrasenia: " );
    	
    	RecogerDatos datos = new RecogerDatos();
    	String contraseniaEsperada = datos.getContrasenia(login);
    	
    	if (contrasenia != contraseniaEsperada) {
    		int respuesta = pedirEntero( "Contrasena o login incorrecto. Pulsa 1 para volver a intentar o 2 para salir: ");
    		if (respuesta == 1) {
    			autenticar();
    		} else {
    			System.out.println( "Saliendo ..." );
                System.exit( 0 );
    		}
    	} else if(contraseniaEsperada == null) {
    		System.out.println("Este usuario no existe");
    		System.out.println( "Saliendo ..." );
            System.exit( 0 );
    	} else {
    		System.out.println("Inicio de sesión correcto");
    		
    	}
	}

}
