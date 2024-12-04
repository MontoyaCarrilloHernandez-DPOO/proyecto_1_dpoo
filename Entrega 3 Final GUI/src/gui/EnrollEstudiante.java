package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class EnrollEstudiante extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EnrollEstudiante(Controlador sistema, Estudiante estudiante) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Unirse a un Learning Path");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccionaElLearning = new JLabel("Selecciona el Learning Path al que te quieres unir:");
		lblSeleccionaElLearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElLearning.setBounds(30, 91, 396, 14);
		contentPane.add(lblSeleccionaElLearning);
		
		JComboBox comboBoxLP = new JComboBox();
		comboBoxLP.setBounds(87, 78, 261, 22);
		for (LearningPath lp : sistema.listaLearningPaths) {
			comboBoxLP.addItem(lp.titulo);
			}
		contentPane.add(comboBoxLP);
		
		JButton btnUnirse = new JButton("Unirse");
		btnUnirse.setBounds(173, 167, 89, 23);
		btnUnirse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lpNombre = (String) comboBoxLP.getSelectedItem();
				
				//Persistencia
				
				
				dispose();
				ExcepcionesFrame exp = new ExcepcionesFrame("Te has inscrito correctamente");
				exp.setVisible(true);
				
			}
		});
		contentPane.add(btnUnirse);
	}

}
