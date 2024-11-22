package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import persistencia.RecogerDatos;
import usuarios.Profesor;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InicioSesionProfesor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesionProfesor frame = new InicioSesionProfesor();
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
	public InicioSesionProfesor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Downloads\\machine-learning.png"));
		setTitle("Inicio de Sesión Profesor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setBounds(41, 94, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña:");
		lblNewLabel_1.setBounds(41, 133, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextField textFieldLogin = new JTextField();
		textFieldLogin.setBounds(152, 91, 96, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JTextField textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(152, 130, 96, 20);
		contentPane.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Ingresar");
		btnIniciarSesion.setBounds(301, 105, 103, 33);
		contentPane.add(btnIniciarSesion);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login = textFieldLogin.getText();
				String contrasenia = textFieldContrasenia.getText();
				RecogerDatos datos = new RecogerDatos();
		    	
				ArrayList<String> datosProfe= datos.getContraseniaProfesor(login);
		    		String contraseniaEsperada = datosProfe.get(0);
		  
		    	  	if (contrasenia.equals(contraseniaEsperada)) {
			    		
			    		dispose();
			    		MenuProfesor menu = new MenuProfesor();
			    		menu.setVisible(true);
			    		}else {
			    			ExcepcionesFrame pop = new ExcepcionesFrame("Login o contrasenia incorrecta⛔🚫⛔🚫");
			    			pop.setVisible(true);
			    			
			    		}
		  
		    			
				
				}
			}
		);
	}
	}
		
		    		