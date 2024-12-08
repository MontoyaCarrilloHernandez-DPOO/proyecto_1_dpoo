package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.PreguntaAbierta;
import persistencia.Controlador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;

public class CrearPreguntasAbiertas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pregunta;
	private JTextField rtaGuia;

	/**
	 * Create the frame.
	 */
	public CrearPreguntasAbiertas(Controlador sistema, CrearActividad crearActividad) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Pregunta Abierta");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnunciado.setBounds(136, 11, 164, 14);
		contentPane.add(lblEnunciado);
		
		JLabel lblrtaGuia = new JLabel("Respuesta Guía:");
		lblrtaGuia.setHorizontalAlignment(SwingConstants.CENTER);
		lblrtaGuia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblrtaGuia.setBounds(133, 106, 169, 23);
		contentPane.add(lblrtaGuia);
		
		JButton btnCrearPregunta = new JButton("Crear Pregunta");
		btnCrearPregunta.setBounds(153, 201, 129, 23);
		contentPane.add(btnCrearPregunta);
		
		pregunta = new JTextField();
		pregunta.setBounds(10, 36, 416, 28);
		contentPane.add(pregunta);
		pregunta.setColumns(10);
		
		rtaGuia = new JTextField();
		rtaGuia.setColumns(10);
		rtaGuia.setBounds(10, 131, 416, 28);
		contentPane.add(rtaGuia);
		btnCrearPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//REGISTRAR PREGUNTA
				dispose();
				PreguntaAbierta preg = new PreguntaAbierta(rtaGuia.getText(),pregunta.getText());
				try {
					sistema.crearPreguntaAbierta(preg);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                crearActividad.pregA.add(preg);
				ExcepcionesFrame exp = new ExcepcionesFrame("Pregunta creada con éxito");
				exp.setVisible(true);
			}
		});
	}
}
