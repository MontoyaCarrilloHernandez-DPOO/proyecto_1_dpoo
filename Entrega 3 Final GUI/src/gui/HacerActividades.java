package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;

public class HacerActividades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HacerActividades(Controlador programa, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Continuar con actividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(18, 59, 399, 22);
		contentPane.add(comboBoxAct);
		
		JLabel lblNewLabel = new JLabel("Elige la actividad que quieres empezar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 33, 317, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Comenzar actividad");
		btnNewButton.setBounds(138, 238, 159, 23);
		contentPane.add(btnNewButton);
		
		JTextArea txtrAquSeMostrar = new JTextArea();
		txtrAquSeMostrar.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrAquSeMostrar.setLineWrap(true);
		txtrAquSeMostrar.setWrapStyleWord(true);
		txtrAquSeMostrar.setText("Aquí se mostrará la información de la actividad");
		txtrAquSeMostrar.setBounds(82, 92, 293, 135);
		contentPane.add(txtrAquSeMostrar);
	}
}
