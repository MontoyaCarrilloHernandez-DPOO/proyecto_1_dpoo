package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import consola.ConsolaCrearControlador;
import persistencia.Controlador;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsolaCrearControlador consola = new ConsolaCrearControlador();
					Controlador sistema;
					sistema = consola.crear();
					MainMenu frame = new MainMenu(sistema);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu(Controlador sistema) {
		
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(181, 11, 115, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnIniciarSesionProfesor = new JButton("Iniciar Sesión Profesor");
		btnIniciarSesionProfesor.setFont(new Font("Arial", Font.PLAIN, 11));
		btnIniciarSesionProfesor.setBounds(147, 87, 175, 23);
		btnIniciarSesionProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesionProfesor prof = new InicioSesionProfesor(sistema);
				prof.setVisible(true);
			}
		});
			
		contentPane.add(btnIniciarSesionProfesor);
		
		JButton btnIniciarSesionEstudiante = new JButton("Iniciar Sesión Estudiante");
		btnIniciarSesionEstudiante.setFont(new Font("Arial", Font.PLAIN, 11));
		btnIniciarSesionEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesionEstudiante est = new InicioSesionEstudiante(sistema);
				est.setVisible(true);
			}
		});
		btnIniciarSesionEstudiante.setBounds(147, 121, 175, 23);
		contentPane.add(btnIniciarSesionEstudiante);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCrearUsuario.setBounds(147, 155, 175, 23);
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CrearUsuario us = new CrearUsuario(sistema);
				us.setVisible(true);
			}
		});
		
		contentPane.add(btnCrearUsuario);
	}
}
