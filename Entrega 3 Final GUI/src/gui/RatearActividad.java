package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Estudiante;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

public class RatearActividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RatearActividad(Controlador sistema, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Ratear Actividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccion = new JLabel("Selecciona la actividade que quieres calificar (de 1-5)");
		lblSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccion.setBounds(20, 36, 396, 14);
		contentPane.add(lblSeleccion);
		
		JComboBox comboBoxAct = new JComboBox();
		comboBoxAct.setBounds(87, 64, 261, 22);
		contentPane.add(comboBoxAct);
		
		JSlider slider = new JSlider();
		slider.setValue(3);
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setMajorTickSpacing(5);
		slider.setBounds(118, 114, 200, 58);
		contentPane.add(slider);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(173, 183, 89, 23);
		contentPane.add(btnCalificar);
	}
}
