package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Profesor;
import javax.swing.SwingConstants;

public class MenuProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuProfesor(Controlador sistema, Profesor profesor) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido,");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 73, 196, 60);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnCrearLP = new JButton("Crea un Learning Path");
		btnCrearLP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearLP crearLP = new CrearLP(sistema, profesor);
				crearLP.setVisible(true);
				
			}
		});
		btnCrearLP.setBounds(248, 48, 157, 23);
		contentPane.add(btnCrearLP);
		
		JButton btnCrearActividad = new JButton("Crear una Actividad");
		btnCrearActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearActividad crearActividad = new CrearActividad(sistema, profesor);
				crearActividad.setVisible(true);
			}
		});
		btnCrearActividad.setBounds(248, 119, 157, 23);
		contentPane.add(btnCrearActividad);
		
		JButton btnCalificar = new JButton("Calificar Exámenes");
		btnCalificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalificarExamenes calificar = new CalificarExamenes(sistema, profesor);
				calificar.setVisible(true);
			}
		});
		btnCalificar.setBounds(248, 190, 157, 23);
		contentPane.add(btnCalificar);
		
		JLabel lblNewLabel_1 = new JLabel(profesor.getNombre()+"!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 132, 196, 60);
		contentPane.add(lblNewLabel_1);
		
	}
}
