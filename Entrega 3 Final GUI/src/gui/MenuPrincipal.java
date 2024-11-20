package gui;

import java.awt.Color;
import java.awt.Toolkit.*;
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
	pantalla.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
	pantalla.setVisible(true);
	
	
	ImageIcon icono = new ImageIcon("datos/psy1.png");
	pantalla.setIconImage(icono.getImage());
	pantalla.getContentPane().setBackground(new Color(0xffffff));
	
	
	JLabel titulo = new JLabel();
	titulo.setText("Menú Principal");
	titulo.setBounds(500, 1, 300, 200);
	titulo.setFont(new Font("Noto Sans", Font.BOLD,40));
	titulo.setForeground(new Color(0,0,0));
	pantalla.add(titulo);
	
	
	JButton loginProfesor = new JButton();
	JButton loginEstudiante = new JButton();
	JButton crearUsuario = new JButton();
	
	loginProfesor.setText("Iniciar sesión como profesor");
	loginProfesor.setBounds(400, 150, 400, 50);
	loginProfesor.setHorizontalTextPosition(JButton.CENTER);
	loginProfesor.setVerticalTextPosition(JButton.CENTER);
	loginProfesor.setFont(new Font ("Noto Sans", Font.PLAIN, 20));
	
	loginEstudiante.setBounds(400, 250, 400, 50);
	loginEstudiante.setText("Iniciar sesión como estudiante");
	loginEstudiante.setHorizontalTextPosition(JButton.CENTER);
	loginEstudiante.setVerticalTextPosition(JButton.CENTER);
	loginEstudiante.setFont(new Font ("Noto Sans", Font.PLAIN, 20));
	
	crearUsuario.setText("Crear un usuario");
	crearUsuario.setBounds(400, 350, 400, 50);
	crearUsuario.setHorizontalTextPosition(JButton.CENTER);
	crearUsuario.setVerticalTextPosition(JButton.CENTER);
	crearUsuario.setFont(new Font ("Noto Sans", Font.PLAIN, 20));
	
	pantalla.add(loginEstudiante);
	pantalla.add(loginProfesor);
	pantalla.add(crearUsuario);
	
	
	//Paleta de colores que me gustó:
	//#fff2e5 - crema
	//#7a90a1 - azul
	//#f9cb9c - naranja
	//#ffe599 - amarillo
	//#93c47d - verde
	}
}
