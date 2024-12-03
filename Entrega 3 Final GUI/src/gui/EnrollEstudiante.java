package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EnrollEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EnrollEstudiante(Controlador programa, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Unirse a un Learning Path");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaElLearning = new JLabel("Selecciona el Learning Path al que te quieres unir:");
		lblSeleccionaElLearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElLearning.setBounds(30, 91, 396, 14);
		contentPane.add(lblSeleccionaElLearning);
		
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(87, 116, 261, 22);
		contentPane.add(comboBoxAct);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.setBounds(173, 167, 89, 23);
		contentPane.add(btnUnirse);
	}

}
