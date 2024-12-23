package consola;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Excepciones.LPException;
import gui.MainMenu;
import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;

public class ConsolaPrincipal extends ConsolaBasica
{
    private final String[] opcionesMenuPrincipal = new String[]{ "Crear/Inicializar Sistema", "Iniciar sesion como profesor", "Iniciar sesion como estudiante", "Crear usuario", "Salir" };

    public Controlador sistema;

    private void mostrarMenuPrincipal( ) throws SQLException, LPException
    {
        int opcionSeleccionada = mostrarMenu( "Menú principal", opcionesMenuPrincipal );
        if( opcionSeleccionada == 1 )
        {
        	ConsolaCrearControlador consolaControlador = new ConsolaCrearControlador( );
        	sistema = consolaControlador.crear( );
        	
        }
        else if( opcionSeleccionada == 2 )
        {
        	ConsolaIniciarSesionProfesor consolaProfe = new ConsolaIniciarSesionProfesor( sistema );
        	consolaProfe.autenticar();
        }
        else if( opcionSeleccionada == 3 )
        {
        	ConsolaIniciarSesionEstudiante consolaEstudiante = new ConsolaIniciarSesionEstudiante( sistema );
            consolaEstudiante.autenticar();
        }
        
        else if( opcionSeleccionada == 4 )
        {
        	ConsolaCrearUsuarios consolaUsuarios = new ConsolaCrearUsuarios( sistema );
            consolaUsuarios.mostrarOpciones();
        }
        else if( opcionSeleccionada == 5 )
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
