package consola;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Excepciones.LPException;
import gui.MenuPrincipal;
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
        	if (!(sistema.listaEstudiantes.isEmpty())){
        		for (Estudiante e : sistema.listaEstudiantes) {
        			System.out.println(e.login);
        		}
        	}
        	
        	if (!(sistema.listaProfesores.isEmpty())){
        		for (Profesor p : sistema.listaProfesores) {
        			System.out.println(p.login);
        		}
        	}
        	
        	if (!(sistema.listaActividades.isEmpty())){
        		for (Actividad a : sistema.listaActividades) {
        			System.out.println(a.titulo);
        		}
        	}
        	
        	if (!(sistema.listaLearningPaths.isEmpty())){
        		for (LearningPath a : sistema.listaLearningPaths) {
        			System.out.println(a.titulo);
        			System.out.println(a.propietario);
        			System.out.println(a.getActividades());
        			System.out.println(a.getEstudiantes());
        		}
        	}
        	
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
		MenuPrincipal frame = new MenuPrincipal();
		
		c.mostrarMenuPrincipal( );
	}

}
