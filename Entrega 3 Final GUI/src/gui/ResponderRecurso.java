package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Encuesta;
import learningPaths.Recurso;
import persistencia.Controlador;
import usuarios.Estudiante;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class ResponderRecurso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ResponderRecurso(Controlador sistema, Estudiante estudiante, Recurso recurso) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecurso = new JLabel("Disfruta del recurso!");
		lblRecurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecurso.setBounds(10, 116, 416, 14);
		contentPane.add(lblRecurso);
		
		JButton btnCompletarRecurso = new JButton("Completar Recurso");
		btnCompletarRecurso.setBounds(105, 165, 226, 23);
		contentPane.add(btnCompletarRecurso);
		
		JLabel lblTipoDeRecurso = new JLabel("Tipo de recurso:");
		lblTipoDeRecurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeRecurso.setBounds(10, 77, 416, 14);
		contentPane.add(lblTipoDeRecurso);
	}

}
