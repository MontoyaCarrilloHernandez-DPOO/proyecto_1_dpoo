package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consola.ConsolaCrearControlador;
import learningPaths.Encuesta;
import learningPaths.Examen;
import learningPaths.Quiz;
import learningPaths.Recurso;
import learningPaths.Tarea;
import persistencia.Controlador;
import usuarios.Estudiante;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ResponderEncuesta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int contador = 0;
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */

	public ResponderEncuesta(Controlador sistema, Estudiante estudiante, Encuesta encuesta) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnunciado = new JLabel("Enunciado: ");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setBounds(6, 11, 612, 14);
		contentPane.add(lblEnunciado);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(28, 36, 569, 62);
		contentPane.add(textPane);
		
		JLabel lblEscribeTuRespuesta = new JLabel("Escribe tu respuesta:");
		lblEscribeTuRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribeTuRespuesta.setBounds(230, 120, 165, 14);
		contentPane.add(lblEscribeTuRespuesta);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 145, 578, 72);
		contentPane.add(textArea);
		
		
		JLabel lblNumPreg = new JLabel("Quedan "+ encuesta.preguntas.size() + " preguntas por responder. Una vez respondidas todas, haz click en Enviar Encuesta");
		lblNumPreg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPreg.setBounds(6, 228, 612, 14);
		contentPane.add(lblNumPreg);
		
		JButton btnSigPreg = new JButton("Siguiente Pregunta");
		btnSigPreg.setBounds(199, 256, 226, 23);
		btnSigPreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = textArea.getText();
				contador++;
				if (contador == encuesta.preguntas.size()) {
					JButton btnEnviarEncuesta = new JButton("Enviar Encuesta");
					btnEnviarEncuesta.setBounds(199, 290, 226, 23);
					contentPane.add(btnEnviarEncuesta);
				}
				
				//Persistencia
				
				textArea.setText("");
				textPane.setText("");
				int sinContestar = encuesta.preguntas.size() - contador;
				lblNumPreg.setText("Quedan "+ sinContestar + " preguntas por responder. Una vez respondidas todas, haz click en Enviar Encuesta");
				
			}
		});
		contentPane.add(btnSigPreg);
		
		
		
		
	}

}
