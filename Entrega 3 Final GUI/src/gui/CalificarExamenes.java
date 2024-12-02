package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Profesor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CalificarExamenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNota;

	/**
	 * Create the frame.
	 */
	public CalificarExamenes(Controlador programa, Profesor profesor) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Calificar Examenes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxLP = new JComboBox();
		comboBoxLP.setBounds(10, 35, 170, 22);
		contentPane.add(comboBoxLP);
		
		JComboBox comboBoxEstudiante = new JComboBox();
		comboBoxEstudiante.setBounds(10, 92, 170, 22);
		contentPane.add(comboBoxEstudiante);
		
		JComboBox comboBoxActividad = new JComboBox();
		comboBoxActividad.setBounds(10, 149, 170, 22);
		contentPane.add(comboBoxActividad);
		
		JButton btnNewButton = new JButton("Buscar Respuestas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(31, 188, 138, 22);
		contentPane.add(btnNewButton);
		
		JTextArea txtrAquSeMostrarn = new JTextArea();
		txtrAquSeMostrarn.setWrapStyleWord(true);
		txtrAquSeMostrarn.setLineWrap(true);
		txtrAquSeMostrarn.setEditable(false);
		txtrAquSeMostrarn.setText("Aquí se mostrarán las respuestas del estudiante");
		txtrAquSeMostrarn.setBounds(231, 27, 195, 176);
		contentPane.add(txtrAquSeMostrarn);
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(322, 213, 104, 20);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
		
		JLabel lblNotaObtenida = new JLabel("Nota Obtenida:");
		lblNotaObtenida.setBounds(241, 216, 93, 14);
		contentPane.add(lblNotaObtenida);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(161, 240, 89, 23);
		contentPane.add(btnCalificar);
		
		JLabel lblLP = new JLabel("Selecciona un Learning Path:");
		lblLP.setHorizontalAlignment(SwingConstants.CENTER);
		lblLP.setBounds(10, 19, 170, 14);
		contentPane.add(lblLP);
		
		JLabel lblSeleccionaUnEstudiante = new JLabel("Selecciona un estudiante:");
		lblSeleccionaUnEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnEstudiante.setBounds(10, 77, 170, 14);
		contentPane.add(lblSeleccionaUnEstudiante);
		
		JLabel lblSeleccionaUnaActividad = new JLabel("Selecciona una actividad");
		lblSeleccionaUnaActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnaActividad.setBounds(10, 132, 170, 14);
		contentPane.add(lblSeleccionaUnaActividad);
	}
}
