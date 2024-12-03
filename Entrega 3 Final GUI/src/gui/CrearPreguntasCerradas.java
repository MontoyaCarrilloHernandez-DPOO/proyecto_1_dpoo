package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.PreguntaCerrada;
import persistencia.Controlador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CrearPreguntasCerradas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_5;

	/**
	 * Create the frame.
	 */
	public CrearPreguntasCerradas(Controlador sistema, CrearActividad crearActividad) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Pregunta Cerrada");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 507, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnunciado = new JLabel("Enunciado:");
		lblEnunciado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnunciado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnunciado.setBounds(136, 23, 164, 14);
		contentPane.add(lblEnunciado);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 48, 416, 23);
		contentPane.add(textField);
		
		JLabel lblRtas = new JLabel("Respuestas");
		lblRtas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRtas.setBounds(43, 133, 169, 23);
		contentPane.add(lblRtas);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(40, 158, 227, 23);
		contentPane.add(textField_1);
		
		JButton btnCrearPregunta = new JButton("Crear Pregunta");
		btnCrearPregunta.setBounds(167, 292, 129, 23);
		contentPane.add(btnCrearPregunta);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(40, 192, 227, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(40, 226, 227, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(40, 258, 227, 23);
		contentPane.add(textField_4);
		
		JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta");
		lblRespuestaCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuestaCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespuestaCorrecta.setBounds(277, 133, 169, 23);
		contentPane.add(lblRespuestaCorrecta);
		
		JLabel lblA = new JLabel("A)");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(20, 156, 36, 23);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B)");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblB.setBounds(20, 190, 36, 23);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C)");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblC.setBounds(20, 226, 36, 23);
		contentPane.add(lblC);
		
		JLabel lblA_1_1 = new JLabel("D)");
		lblA_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA_1_1.setBounds(20, 260, 36, 23);
		contentPane.add(lblA_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A)");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(308, 158, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnB = new JRadioButton("B)");
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(308, 192, 111, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnB_1 = new JRadioButton("C)");
		buttonGroup.add(rdbtnB_1);
		rdbtnB_1.setBounds(308, 226, 111, 23);
		contentPane.add(rdbtnB_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("D)");
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(308, 260, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);
		
		JLabel lblJustificacion = new JLabel("Justificacion:");
		lblJustificacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblJustificacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJustificacion.setBounds(136, 82, 164, 14);
		contentPane.add(lblJustificacion);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 107, 416, 23);
		contentPane.add(textField_5);
		btnCrearPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				String rta = new String();
				if(rdbtnNewRadioButton.isSelected()) {
					rta = "A";
				}
				else if(rdbtnB.isSelected()) {
					rta = "B";
				}
				else if(rdbtnB_1.isSelected()) {
                    rta = "C";
                }
				else if(rdbtnNewRadioButton_1_1.isSelected()) {
                    rta = "D";
                }
				PreguntaCerrada nuevaPregunta = new PreguntaCerrada(rta,textField_5.getText(),textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText());
				try {
					sistema.crearPreguntaCerrada(nuevaPregunta);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				crearActividad.pregC.addLast(nuevaPregunta);;
				ExcepcionesFrame exp = new ExcepcionesFrame("Pregunta creada con éxito");
				exp.setVisible(true);
			}
		});
	}
}
