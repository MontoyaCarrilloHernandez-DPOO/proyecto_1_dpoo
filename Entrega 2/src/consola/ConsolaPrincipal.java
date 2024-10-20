package consola;

import java.sql.SQLException;

import Excepciones.LPException;
import persistencia.Controlador;

public class ConsolaPrincipal extends ConsolaBasica
{
    private final String[] opcionesMenuPrincipal = new String[]{ "Iniciar sesion como profesor", "Iniciar sesion como estudiante", "Crear usuario", "Crear Sistema","Subir Sistema","Salir" };

    public Controlador sistema;

    private void mostrarMenuPrincipal( ) throws SQLException, LPException
    {
        int opcionSeleccionada = mostrarMenu( "Menú principal", opcionesMenuPrincipal );
        if( opcionSeleccionada == 1 )
        {
        	ConsolaIniciarSesionProfesor consolaProfe = new ConsolaIniciarSesionProfesor( sistema );
        	consolaProfe.autenticar();
        }
        else if( opcionSeleccionada == 2 )
        {
        	ConsolaIniciarSesionEstudiante consolaEstudiante = new ConsolaIniciarSesionEstudiante( sistema );
            consolaEstudiante.autenticar();
        }
        else if( opcionSeleccionada == 3 )
        {
        	ConsolaCrearUsuarios consolaUsuarios = new ConsolaCrearUsuarios( sistema );
            consolaUsuarios.mostrarOpciones();
        }
        
        else if( opcionSeleccionada == 4 )
        {
        	ConsolaCrearControlador consolaControlador = new ConsolaCrearControlador( );
        	sistema = consolaControlador.crear( );
        }
        else if( opcionSeleccionada == 5 )
        {
            //TODO Ver cómo subir datos
        }
        else if( opcionSeleccionada == 6 )
        {
            System.out.println( "Saliendo ..." );
            System.exit( 0 );
        }
        mostrarMenuPrincipal( );
    }


	public static void main(String[] args) throws SQLException, LPException {
		ConsolaPrincipal c = new ConsolaPrincipal( );
		c.mostrarMenuPrincipal( );
	}

}
