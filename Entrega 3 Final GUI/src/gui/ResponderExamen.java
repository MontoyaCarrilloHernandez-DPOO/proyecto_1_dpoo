package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Encuesta;
import learningPaths.Examen;
import persistencia.Controlador;
import usuarios.Estudiante;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ResponderExamen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int contador = 0;

	public ResponderExamen(Controlador sistema, Estudiante estudiante, Examen examen) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotaMnimaPara = new JLabel("Nota mínima para aprobar: ");
		lblNotaMnimaPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaMnimaPara.setBounds(10, 11, 247, 14);
		contentPane.add(lblNotaMnimaPara);
		
		
		JLabel lblEscribeTuRespuesta = new JLabel("Escribe tu respuesta:");
		lblEscribeTuRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscribeTuRespuesta.setBounds(233, 178, 165, 14);
		contentPane.add(lblEscribeTuRespuesta);
		
		JLabel lblEnunciado = new JLabel("Enunciado: ");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setBounds(10, 69, 612, 14);
		contentPane.add(lblEnunciado);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(39, 94, 569, 62);
		contentPane.add(textPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 203, 578, 72);
		contentPane.add(textArea);
		
		JLabel lblNumPreg = new JLabel("Quedan"+ examen.preguntas.size() +" preguntas por responder. Una vez respondidas todas, haz click en Enviar Examen");
		lblNumPreg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPreg.setBounds(10, 289, 612, 14);
		contentPane.add(lblNumPreg);
		
		JButton btnSigPreg = new JButton("Siguiente Pregunta");
		btnSigPreg.setBounds(199, 256, 226, 23);
		btnSigPreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = textArea.getText();
				contador++;
				if (contador == examen.preguntas.size()) {
					JButton btnEnviarExamen = new JButton("Enviar Examen");
					btnEnviarExamen.setBounds(204, 348, 226, 23);
					contentPane.add(btnEnviarExamen);
				}
				
				//Persistencia
				
				textArea.setText("");
				textPane.setText("");
				int sinContestar = examen.preguntas.size() - contador;
				lblNumPreg.setText("Quedan "+ sinContestar + " preguntas por responder. Una vez respondidas todas, haz click en Enviar Encuesta");
				
			}
		});
		contentPane.add(btnSigPreg);
	}
}
