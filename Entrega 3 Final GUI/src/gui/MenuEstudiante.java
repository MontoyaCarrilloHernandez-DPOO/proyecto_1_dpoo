package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		lblNewLabel.setBounds(10, 119, 228, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel);
		
		JButton btnEnroll = new JButton("Únete a un Learning Path");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnrollEstudiante enroll = new EnrollEstudiante(sistema, estudiante);
				enroll.setVisible(true);
			}
		});
		btnEnroll.setBounds(248, 24, 157, 23);
		contentPane.add(btnEnroll);
		
		JButton btnUnenroll = new JButton("Sal de tu Learning Path");
		btnUnenroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnUnenroll.setBounds(248, 71, 157, 23);
		contentPane.add(btnUnenroll);
		
		JButton btnResumir = new JButton("Resume tu Learning Path");
		btnResumir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HacerActividades act = new HacerActividades(sistema, estudiante);
				act.setVisible(true);
			}
		});
		btnResumir.setBounds(248, 118, 157, 23);
		contentPane.add(btnResumir);
		
		JButton btnRatea = new JButton("Valora Actividades");
		btnRatea.setBounds(248, 165, 157, 23);
		btnRatea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RatearActividad act = new RatearActividad(sistema, estudiante);
				act.setVisible(true);
			}
		});
		contentPane.add(btnRatea);
		
		JButton btnReseniar = new JButton("Reseña Actividades");
		btnReseniar.setBounds(248, 212, 157, 23);
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
		lblNewLabel_1.setBounds(10, 145, 228, 25);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
