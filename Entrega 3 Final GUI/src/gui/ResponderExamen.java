package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Encuesta;
import learningPaths.Examen;
import persistencia.AnadirDatos;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import usuarios.Estudiante;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ResponderExamen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int contador = 0;
	private ModificarDatos modificarDatos = new ModificarDatos();
	private AnadirDatos anadirDatos = new AnadirDatos();

	public ResponderExamen(Controlador sistema, Estudiante estudiante, Examen examen) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Examen: " + examen.titulo);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNotaMnimaPara = new JLabel("Nota mínima para aprobar: " + examen.notaMinima);
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
		String enunciado = examen.preguntas.get(contador).enunciado;
		textPane.setText(enunciado);
		textPane.setBounds(39, 94, 569, 62);
		contentPane.add(textPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(39, 194, 578, 72);
		contentPane.add(textArea);
		
		JLabel lblNumPreg = new JLabel("Quedan"+ examen.preguntas.size() +" preguntas por responder. Una vez respondidas todas, haz click en Enviar Examen");
		lblNumPreg.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPreg.setBounds(10, 316, 612, 14);
		contentPane.add(lblNumPreg);
		
		JButton btnSigPreg = new JButton("Siguiente Pregunta");
		btnSigPreg.setBounds(203, 282, 226, 23);
		btnSigPreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (contador == examen.preguntas.size()) {
					JButton btnEnviarExamen = new JButton("Enviar Examen");
					btnEnviarExamen.setBounds(204, 348, 226, 23);
					btnEnviarExamen.addActionListener(new ActionListener() {
					    public void actionPerformed(ActionEvent e) {
					    	estudiante.actualActividad=null;
					    	modificarDatos.cambiarDatosEstudiante(estudiante.login, estudiante.getHistorialLearningPaths(), estudiante.actualLearningPath,null, estudiante.getRespuestas(), estudiante.getProgreso());
							modificarDatos.cambiarDatosProgreso(estudiante.getProgreso());
							dispose();
							ExcepcionesFrame exp2 = new ExcepcionesFrame("No intentes volver a hacer el examen, sino sera anulado.");
							exp2.setVisible(true);
							ExcepcionesFrame exp = new ExcepcionesFrame("Tu progreso no se modificará hasta que \n tu profesor haya calificado el examen.");
							exp.setVisible(true);
							
					    }
					});
					contentPane.add(btnEnviarExamen);
				}
				else {
					String respuesta = textArea.getText();
					contador++;
				
				try {
					int idEsperado = anadirDatos.nuevaRespuesta(estudiante.login, examen.titulo, examen.preguntas.get(contador-1).enunciado, respuesta);
					estudiante.respuestas.put(idEsperado, examen.titulo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				if (contador != examen.preguntas.size()) {
				String enunciado = examen.preguntas.get(contador).enunciado;
				textPane.setText(enunciado);
				textArea.setText("");}
				else {
					textPane.setText("");
					textArea.setText("");
				}
				int sinContestar = examen.preguntas.size() - contador;
				lblNumPreg.setText("Quedan "+ sinContestar + " preguntas por responder. Una vez respondidas todas, haz click en Enviar Encuesta");
				}
			}
		});
		contentPane.add(btnSigPreg);
	}
}
