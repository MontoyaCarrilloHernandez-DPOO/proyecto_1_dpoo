package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Encuesta;
import learningPaths.Quiz;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import usuarios.Estudiante;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class ResponderQuiz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int contador = 0;
	private int correctas = 0;
	private ModificarDatos modificarDatos = new ModificarDatos();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private float notaObtenida = 0;
	
	
	public ResponderQuiz(Controlador sistema, Estudiante estudiante, Quiz quiz) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotaMnimaPara = new JLabel("Nota mínima para aprobar: ");
		lblNotaMnimaPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaMnimaPara.setBounds(10, 11, 247, 14);
		contentPane.add(lblNotaMnimaPara);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		String enunciado = quiz.preguntas.get(contador).enunciado;
		textPane.setText(enunciado);
		textPane.setBounds(49, 36, 338, 211);
		contentPane.add(textPane);
		
		
		JRadioButton rdbtnA = new JRadioButton("A");
		buttonGroup.add(rdbtnA);
		rdbtnA.setBounds(420, 74, 111, 23);
		contentPane.add(rdbtnA);
		
		JRadioButton rdbtnB = new JRadioButton("B");
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(420, 111, 111, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnC = new JRadioButton("C");
		buttonGroup.add(rdbtnC);
		rdbtnC.setBounds(420, 147, 111, 23);
		contentPane.add(rdbtnC);
		
		JRadioButton rdbtnD = new JRadioButton("D");
		buttonGroup.add(rdbtnD);
		rdbtnD.setBounds(420, 184, 111, 23);
		contentPane.add(rdbtnD);
		
		JLabel lblEligeTuRespuesta = new JLabel("Elige tu respuesta:");
		lblEligeTuRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeTuRespuesta.setBounds(409, 36, 165, 14);
		contentPane.add(lblEligeTuRespuesta);
		
		JLabel lblNumPreg1 = new JLabel("Quedan "+ quiz.preguntas.size() +" preguntas por responder. Una vez respondidas todas, haz click en Enviar Quiz");
		lblNumPreg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPreg1.setBounds(10, 261, 554, 14);
		contentPane.add(lblNumPreg1);
		
		JButton btnSigPreg = new JButton("Siguiente Pregunta");
		btnSigPreg.setBounds(174, 286, 226, 23);
		btnSigPreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String respuesta = null;
				if (rdbtnA.isSelected()) {
					respuesta = "A";
				}
				else if (rdbtnB.isSelected()) {
					respuesta = "B";
				}
				else if (rdbtnC.isSelected()) {
					respuesta = "C";
				}
				else if (rdbtnD.isSelected()) {
					respuesta = "D";
				}
				contador++;
				if (contador == quiz.preguntas.size()) {
					JButton btnEnviarQuiz = new JButton("Enviar Quiz");
					btnEnviarQuiz.setBounds(174, 320, 226, 23);
					btnEnviarQuiz.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	notaObtenida = (correctas/quiz.preguntas.size())*5;
					    	if (notaObtenida >= quiz.notaMinima) {
					    		ExcepcionesFrame exp = new ExcepcionesFrame("Felicitaciones, aprobaste el quiz con " + notaObtenida);
								exp.setVisible(true);
								estudiante.terminarActividad();
							}
							else {
								ExcepcionesFrame exp2 = new ExcepcionesFrame("No aprobaste el quiz, debes volverlo a hacer. Nota: " + notaObtenida);
								exp2.setVisible(true);
								estudiante.actualActividad=null;
							}
					    	
					    	modificarDatos.cambiarDatosEstudiante(estudiante.login, estudiante.getHistorialLearningPaths(), estudiante.actualLearningPath,null, estudiante.getRespuestas(), estudiante.getProgreso());
							modificarDatos.cambiarDatosProgreso(estudiante.getProgreso());
							
					    }
					});
					contentPane.add(btnEnviarQuiz);
				}
				String respuestaCorrecta = quiz.preguntas.get(contador-1).respuestaCorrecta;
				if (respuesta.equals(respuestaCorrecta.toUpperCase().replace(" ", ""))) {
					System.out.println("Justificacion: " + quiz.preguntas.get(contador-1).justificacion);
					correctas +=1 ;
				}
				else {
					System.out.println("Respuesta incorrecta");
				}
				
				buttonGroup.clearSelection();
				String enunciado = quiz.preguntas.get(contador).enunciado;
				textPane.setText(enunciado);
				int sinContestar = quiz.preguntas.size() - contador;
				lblNumPreg1.setText("Quedan "+ sinContestar + " preguntas por responder. Una vez respondidas todas, haz click en Enviar Quiz");
				
			}
		});
		contentPane.add(btnSigPreg);
		
	}
}
