package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.Encuesta;
import learningPaths.Tarea;
import persistencia.Controlador;
import usuarios.Estudiante;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ResponderTarea extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ResponderTarea(Controlador sistema, Estudiante estudiante, Tarea tarea) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnOk = new JButton("Completar Tarea");
		btnOk.setBounds(105, 193, 226, 23);
		btnOk.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	tarea.setCompletado();
		    }
		});
		contentPane.add(btnOk);
		
		JLabel lblTarea = new JLabel("Te recomendamos hacer la tarea; es importante para tu conocimiento");
		lblTarea.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarea.setBounds(10, 96, 416, 14);
		contentPane.add(lblTarea);
	}
}
