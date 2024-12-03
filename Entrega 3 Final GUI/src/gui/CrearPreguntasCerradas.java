package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Create the frame.
	 */
	public CrearPreguntasCerradas() {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Pregunta Cerrada");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		lblRtas.setBounds(33, 77, 169, 23);
		contentPane.add(lblRtas);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(30, 102, 227, 23);
		contentPane.add(textField_1);
		
		JButton btnCrearPregunta = new JButton("Crear Pregunta");
		btnCrearPregunta.setBounds(157, 236, 129, 23);
		btnCrearPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: REGISTRAR PREGUNTA
				dispose();
				ExcepcionesFrame exp = new ExcepcionesFrame("Pregunta creada con éxito");
				exp.setVisible(true);
			}
		});
		contentPane.add(btnCrearPregunta);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(30, 136, 227, 23);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(30, 170, 227, 23);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(30, 202, 227, 23);
		contentPane.add(textField_4);
		
		JLabel lblRespuestaCorrecta = new JLabel("Respuesta Correcta");
		lblRespuestaCorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespuestaCorrecta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRespuestaCorrecta.setBounds(267, 77, 169, 23);
		contentPane.add(lblRespuestaCorrecta);
		
		JLabel lblA = new JLabel("A)");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA.setBounds(10, 100, 36, 23);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B)");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblB.setBounds(10, 134, 36, 23);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C)");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblC.setBounds(10, 170, 36, 23);
		contentPane.add(lblC);
		
		JLabel lblA_1_1 = new JLabel("D)");
		lblA_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblA_1_1.setBounds(10, 204, 36, 23);
		contentPane.add(lblA_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A)");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(298, 102, 111, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnB = new JRadioButton("B)");
		buttonGroup.add(rdbtnB);
		rdbtnB.setBounds(298, 136, 111, 23);
		contentPane.add(rdbtnB);
		
		JRadioButton rdbtnB_1 = new JRadioButton("C)");
		buttonGroup.add(rdbtnB_1);
		rdbtnB_1.setBounds(298, 170, 111, 23);
		contentPane.add(rdbtnB_1);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("D)");
		buttonGroup.add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setBounds(298, 204, 111, 23);
		contentPane.add(rdbtnNewRadioButton_1_1);
	}
}
