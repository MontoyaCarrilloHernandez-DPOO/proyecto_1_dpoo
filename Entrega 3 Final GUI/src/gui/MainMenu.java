package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Principal");
		lblNewLabel.setBounds(190, 11, 70, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnIniciarSesionProfesor = new JButton("Iniciar Sesion Profesor");
		btnIniciarSesionProfesor.setFont(new Font("Arial", Font.PLAIN, 11));
		btnIniciarSesionProfesor.setBounds(147, 87, 153, 23);
		btnIniciarSesionProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesionProfesor prof = new InicioSesionProfesor();
				prof.setVisible(true);
			}
		});
			
		contentPane.add(btnIniciarSesionProfesor);
		
		JButton btnIniciarSesionEstudiante = new JButton("Iniciar Sesion Estudiante");
		btnIniciarSesionEstudiante.setFont(new Font("Arial", Font.PLAIN, 11));
		btnIniciarSesionEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				InicioSesionEstudiante est = new InicioSesionEstudiante();
				est.setVisible(true);
			}
		});
		btnIniciarSesionEstudiante.setBounds(147, 121, 153, 23);
		contentPane.add(btnIniciarSesionEstudiante);
		
		JButton btnCrearUsuario = new JButton("Crear Usuario");
		btnCrearUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCrearUsuario.setBounds(147, 155, 153, 23);
		contentPane.add(btnCrearUsuario);
	}
}
