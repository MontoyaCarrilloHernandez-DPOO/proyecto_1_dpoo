package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuPrincipal extends JFrame {
	
	public MenuPrincipal(){
	JFrame pantalla = new JFrame();
	pantalla.setTitle("Menu Principal");
	pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pantalla.setResizable(false);
	pantalla.setSize(600,600);
	pantalla.setVisible(true);
	
	
	ImageIcon icono = new ImageIcon("datos/psy1.png");
	pantalla.setIconImage(icono.getImage());
	pantalla.getContentPane().setBackground(new Color(0xfff2e5));
	
	
	JLabel titulo = new JLabel();
	pantalla.add(titulo);
	titulo.setText("Menú Principal");
	titulo.setBounds(250, 50, 300, 200);
	titulo.setHorizontalTextPosition(JLabel.CENTER);
	titulo.setVerticalTextPosition(JLabel.TOP);
	titulo.setFont(new Font("Noto Sans", Font.BOLD,40));
	titulo.setForeground(new Color(0,0,0));
	
	/**
	JButton loginProfesor = new JButton();
	pantalla.add(loginProfesor);
	loginProfesor.setText("Iniciar sesión como profesor");
	loginProfesor.setBounds(200, 150, 300, 50);
	loginProfesor.setHorizontalTextPosition(JButton.CENTER);
	loginProfesor.setVerticalTextPosition(JButton.CENTER);
	loginProfesor.setFont(new Font ("Noto Sans", Font.PLAIN, 25));
	loginProfesor.setBackground(new Color (0xf9cb9c));

	
	JButton loginEstudiante = new JButton();
	pantalla.add(loginEstudiante);
	loginEstudiante.setBounds(200, 250, 300, 50);
	loginEstudiante.setText("Iniciar sesión como estudiante");
	loginEstudiante.setHorizontalTextPosition(JButton.CENTER);
	loginEstudiante.setVerticalTextPosition(JButton.CENTER);
	loginEstudiante.setFont(new Font ("Noto Sans", Font.PLAIN, 25));
	loginEstudiante.setBackground(new Color (0xf9cb9c));
	
	
	JButton crearUsuario = new JButton();
	pantalla.add(crearUsuario);
	crearUsuario.setText("Crear un usuario");
	crearUsuario.setBounds(200, 350, 300, 50);
	crearUsuario.setHorizontalTextPosition(JButton.CENTER);
	crearUsuario.setVerticalTextPosition(JButton.CENTER);
	crearUsuario.setFont(new Font ("Noto Sans", Font.PLAIN, 25));
	crearUsuario.setBackground(new Color (0xf9cb9c));
	**/
	
	
	//Paleta de colores que me gustó:
	//#fff2e5 - crema
	//#7a90a1 - azul
	//#f9cb9c - naranja
	//#ffe599 - amarillo
	//#93c47d - verde
	}
}
