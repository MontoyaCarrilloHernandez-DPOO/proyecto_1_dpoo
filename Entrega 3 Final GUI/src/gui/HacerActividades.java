package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.Encuesta;
import learningPaths.Examen;
import learningPaths.PreguntaAbierta;
import learningPaths.PreguntaCerrada;
import learningPaths.Quiz;
import learningPaths.Recurso;
import learningPaths.Tarea;
import persistencia.AnadirDatos;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import persistencia.RecogerDatos;
import usuarios.Estudiante;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class HacerActividades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private RecogerDatos losDatos= new RecogerDatos();
	private ModificarDatos modificarDatos = new ModificarDatos();
	private AnadirDatos anadirDatos = new AnadirDatos();
	private Actividad actReal = null;

	/**
	 * Create the frame.
	 */
	public HacerActividades(Controlador sistema, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Continuar con actividad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige la actividad que quieres empezar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 33, 317, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrAquSeMostrar = new JTextArea();
		txtrAquSeMostrar.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrAquSeMostrar.setLineWrap(true);
		txtrAquSeMostrar.setWrapStyleWord(true);
		txtrAquSeMostrar.setText("Aquí se mostrará la información de la actividad");
		txtrAquSeMostrar.setBounds(82, 92, 293, 135);
		contentPane.add(txtrAquSeMostrar);
		
		ArrayList<Actividad> actividades = estudiante.progreso.getActividadesCompletas();
		
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(18, 59, 399, 22);
		for (Actividad act : actividades) {
			comboBoxAct.addItem(act.titulo);
			}
		comboBoxAct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String actNombre = (String) comboBoxAct.getSelectedItem();
		        Actividad actReal = null;
		        for (Actividad a : actividades) {
		            if (a.titulo.equals(actNombre)) {
		                actReal = a;
		                break;
		            }
		        }
		        if (actReal != null) {
		            txtrAquSeMostrar.setText("Titulo: " + actReal.titulo + "\n" +
		                                     "Objetivo: " + actReal.objetivo + "\n" +
		                                     "Nivel: " + actReal.nivel + "\n" +
		                                     "Tiempo Límite: " + actReal.tiempoLimite);
		        }
		    }
		});
		contentPane.add(comboBoxAct);
		
		/**String actNombre = (String) comboBoxAct.getSelectedItem();
		for (Actividad a : actividades) {
			if (a.titulo.equals(actNombre)) {
				actReal = a;
			}
		}
			**/
		
		JButton btnNewButton = new JButton("Comenzar actividad");
		btnNewButton.setBounds(138, 238, 159, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				estudiante.comenzarActividad(actReal);
				String tipo = losDatos.getTipo(actReal);
				
				if(tipo.equals("TAREAS")) {
					Tarea miTarea = (Tarea) actReal;
					ResponderTarea resTarea = new ResponderTarea(sistema, estudiante, miTarea);
					resTarea.setVisible(true);
					estudiante.terminarActividad();
					
				}else if (tipo.equals("QUIZES")) {
					Quiz miQuiz = (Quiz) actReal;
					ResponderQuiz resQuiz = new ResponderQuiz(sistema, estudiante, miQuiz);
					resQuiz.setVisible(true);
					
				}else if (tipo.equals("EXAMENES")) {
					Examen miExamen = (Examen) actReal;
					ResponderExamen resExamen = new ResponderExamen(sistema, estudiante, miExamen);
					resExamen.setVisible(true);
					estudiante.actualActividad = null;
					
					
				}else if (tipo.equals("RECURSOS")) {
					Recurso miRecurso = (Recurso) actReal;
					ResponderRecurso resRecurso = new ResponderRecurso(sistema, estudiante, miRecurso);
					resRecurso.setVisible(true);
					estudiante.terminarActividad();
				}
				
				modificarDatos.cambiarDatosEstudiante(estudiante.login, estudiante.getHistorialLearningPaths(), estudiante.actualLearningPath,null, estudiante.getRespuestas(), estudiante.getProgreso());
				modificarDatos.cambiarDatosProgreso(estudiante.getProgreso());
				//Lo mejor es modificar y cambiar datos todo desde los otros botones
				
			}
		});
		contentPane.add(btnNewButton);
		
		
	}
}
