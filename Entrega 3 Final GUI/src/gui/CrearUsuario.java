package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CrearUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Controlador sistema;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 * @param sistema2 
	 */
	public CrearUsuario(Controlador sistema) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnDevolver = new JButton("←");
		btnDevolver.setBounds(25, 11, 71, 23);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMenu menu = new MainMenu(sistema);
				menu.setVisible(true);
				}
			}
		);
		contentPane.add(btnDevolver);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(58, 179, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(58, 218, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 176, 96, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 215, 96, 20);
		contentPane.add(textField_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(58, 100, 77, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBounds(58, 139, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(169, 97, 96, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(169, 136, 96, 20);
		contentPane.add(textField_3);
		
		JRadioButtonMenuItem rdbSeleccion = new JRadioButtonMenuItem("Estudiante");
		buttonGroup.add(rdbSeleccion);
		rdbSeleccion.setBounds(279, 54, 133, 26);
		contentPane.add(rdbSeleccion);
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.setBounds(275, 152, 137, 23);
		contentPane.add(btnNewButton);
		
		JRadioButtonMenuItem rdbtnmntmProfesor = new JRadioButtonMenuItem("Profesor");
		buttonGroup.add(rdbtnmntmProfesor);
		rdbtnmntmProfesor.setBounds(46, 54, 133, 26);
		contentPane.add(rdbtnmntmProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Crear Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(165, 10, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Selecciona el tipo de usuario: ");
		lblNewLabel_3.setBounds(144, 35, 230, 14);
		contentPane.add(lblNewLabel_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (rdbSeleccion.isSelected()) {
				try {
					Estudiante est = sistema.crearEstudiante(textField_2.getText(),textField_3.getText(),textField.getText(),textField_1.getText());
				} catch (SQLException e1) {
					ExcepcionesFrame pop = new ExcepcionesFrame("Falta alguno de los parametros");
					pop.setVisible(true);
					
				}				
				dispose(  );
				ExcepcionesFrame pop = new ExcepcionesFrame("Usuario creado con exito, reinicie el programa e inicie sesion");
				pop.setVisible(true);
				
				
		}
			else if (rdbtnmntmProfesor.isSelected()) {
				try {
					Profesor prof = sistema.crearProfesor(textField_2.getText(),textField_3.getText(),textField.getText(),textField_1.getText());
				} catch (SQLException e1) {
					ExcepcionesFrame pop = new ExcepcionesFrame("El login ya existe o falta algún parámetro");
					pop.setVisible(true);
				}
				dispose( );
				ExcepcionesFrame pop = new ExcepcionesFrame("Usuario Creado con exito, reinicie el programa e inicie sesion");
				pop.setVisible(true);
			}
			else {

				ExcepcionesFrame pop = new ExcepcionesFrame("El login ya existe o falta algún parámetro");
				pop.setVisible(true);
			}
			}
		});
	}
}
