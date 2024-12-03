package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ReseniarActividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldResenia;

	/**
	 * Create the frame.
	 */
	public ReseniarActividad(Controlador sistema, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Reseñar Actividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccion = new JLabel("Selecciona la actividade que quieres calificar (de 1-5)");
		lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccion.setBounds(20, 50, 396, 14);
		contentPane.add(lblSeleccion);
		
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(87, 78, 261, 22);
		contentPane.add(comboBoxAct);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(173, 197, 89, 23);
		contentPane.add(btnCalificar);
		
		textFieldResenia = new JTextField();
		textFieldResenia.setBounds(28, 157, 380, 29);
		contentPane.add(textFieldResenia);
		textFieldResenia.setColumns(10);
		
		JLabel lblResenia = new JLabel("Ingresa la reseña:");
		lblResenia.setHorizontalAlignment(SwingConstants.CENTER);
		lblResenia.setBounds(20, 132, 396, 14);
		contentPane.add(lblResenia);
	}
}
