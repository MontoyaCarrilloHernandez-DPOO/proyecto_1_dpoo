package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.LearningPath;
import learningPaths.Progreso;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import usuarios.Estudiante;
import usuarios.Profesor;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ModificarDatos modificarDatos = new ModificarDatos();
	/**
	 * Create the frame.
	 */
	public MenuEstudiante(Controlador sistema, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Menú de Estudiante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("¡Bienvenido,");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(9, 84, 204, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnEnroll = new JButton("Únete a un Learning Path");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollEstudiante enroll = new EnrollEstudiante(sistema, estudiante);
				enroll.setVisible(true);
			}
		});
		btnEnroll.setBounds(223, 24, 182, 23);
		contentPane.add(btnEnroll);
		
		JButton btnUnenroll = new JButton("Sal de tu Learning Path");
		btnUnenroll.setBounds(223, 71, 182, 23);
		btnUnenroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LearningPath lpActual = estudiante.actualLearningPath;
	        	
	        	lpActual.quitarEstudiantes(estudiante);
	        	modificarDatos.cambiarDatosLP(lpActual);
	        	
	        	estudiante.unenroll();
	        	
	        	Progreso prog = new Progreso(null, estudiante.login);
	        	modificarDatos.cambiarDatosProgreso(prog);
				
				
				ArrayList<Profesor> misprof = sistema.listaProfesores;
				Profesor miProfLP = null;
				for (Profesor p : misprof) {
					if (p.login.equals(lpActual.propietario)) {
						miProfLP = p;
					}
				}
				miProfLP.learningPaths.remove(lpActual);
				miProfLP.learningPaths.add(lpActual);
				modificarDatos.cambiarDatosProfesor(miProfLP);
				
				ExcepcionesFrame exp = new ExcepcionesFrame("Te has salido del Learning Path con éxito");
			}
		});
		contentPane.add(btnUnenroll);
		
		JButton btnResumir = new JButton("Resume tu Learning Path");
		btnResumir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerActividades act = new HacerActividades(sistema, estudiante);
				act.setVisible(true);
			}
		});
		btnResumir.setBounds(223, 118, 182, 23);
		contentPane.add(btnResumir);
		
		JButton btnRatea = new JButton("Valora Actividades");
		btnRatea.setBounds(223, 165, 182, 23);
		btnRatea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RatearActividad act = new RatearActividad(sistema, estudiante);
				act.setVisible(true);
			}
		});
		contentPane.add(btnRatea);
		
		JButton btnReseniar = new JButton("Reseña Actividades");
		btnReseniar.setBounds(223, 212, 182, 23);
		btnReseniar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReseniarActividad act = new ReseniarActividad(sistema, estudiante);
				act.setVisible(true);
			}
		});
		contentPane.add(btnReseniar);
		
		JLabel lblNewLabel_1 = new JLabel(estudiante.getNombre()+" !");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 118, 228, 47);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
