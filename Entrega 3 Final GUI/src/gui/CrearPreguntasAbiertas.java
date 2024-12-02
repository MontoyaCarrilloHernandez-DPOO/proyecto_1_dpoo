package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CrearPreguntasAbiertas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pregunta;
	private JTextField rtaGuia;

	/**
	 * Create the frame.
	 */
	public CrearPreguntasAbiertas() {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Pregunta Abierta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(213, 10, 10, 10);
		contentPane.add(panel);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnunciado.setBounds(136, 11, 164, 14);
		contentPane.add(lblEnunciado);
		
		JLabel lblrtaGuia = new JLabel("Respuesta Guía:");
		lblrtaGuia.setHorizontalAlignment(SwingConstants.CENTER);
		lblrtaGuia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblrtaGuia.setBounds(134, 106, 169, 14);
		contentPane.add(lblrtaGuia);
		
		JButton btnCrearPregunta = new JButton("Crear Pregunta");
		btnCrearPregunta.setBounds(154, 201, 129, 23);
		contentPane.add(btnCrearPregunta);
		
		pregunta = new JTextField();
		pregunta.setBounds(10, 48, 416, 35);
		contentPane.add(pregunta);
		pregunta.setColumns(10);
		
		rtaGuia = new JTextField();
		rtaGuia.setColumns(10);
		rtaGuia.setBounds(10, 143, 416, 35);
		contentPane.add(rtaGuia);
	}
}