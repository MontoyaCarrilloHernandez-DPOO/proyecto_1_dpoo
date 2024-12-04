package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.Encuesta;
import learningPaths.Examen;
import learningPaths.Quiz;
import learningPaths.Recurso;
import learningPaths.Tarea;
import persistencia.Controlador;
import usuarios.Estudiante;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HacerActividades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		//TODO anadir las actividades del estudiante que son incompletas}11
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(18, 59, 399, 22);
		for (Actividad act : sistema.listaActividades) {
			comboBoxAct.addItem(act.titulo);
			}
		comboBoxAct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String actNombre = (String) comboBoxAct.getSelectedItem();
		        Actividad actReal = null;
		        for (Actividad a : sistema.listaActividades) {
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
		
		String actNombre = (String) comboBoxAct.getSelectedItem();
		Actividad actReal = null;
		for (Actividad a : sistema.listaActividades) {
			if (a.titulo.equals(actNombre)) {
				actReal = a;
			}
		}
			
		JButton btnNewButton = new JButton("Comenzar actividad");
		btnNewButton.setBounds(138, 238, 159, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if("completar lo del" == "tipo") {
					Quiz quiz = null;
				}
				else if("completar lo del" == "tipo") {
					Tarea tarea = null;
				}
				else if("completar lo del" == "tipo") {
					Encuesta encuesta = null;
				}
				else if("completar lo del" == "tipo") {
					Examen examen = null;
				}
				else if("completar lo del" == "tipo") {
					Recurso recurso = null;
				}
				
			}
		});
		contentPane.add(btnNewButton);
		
		
	}
}
