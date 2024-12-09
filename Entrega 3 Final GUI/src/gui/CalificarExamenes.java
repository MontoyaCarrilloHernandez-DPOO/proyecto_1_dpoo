package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.LearningPath;
import persistencia.Controlador;
import usuarios.Estudiante;
import usuarios.Profesor;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CalificarExamenes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNota;

	/**
	 * Create the frame.
	 */
	public CalificarExamenes(Controlador programa, Profesor profesor) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Calificar Examenes");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBoxLP = new JComboBox<String>();
		comboBoxLP.setBounds(10, 35, 170, 22);
		for (LearningPath lp: programa.listaLearningPaths) {
			comboBoxLP.addItem(lp.getTitulo());
		}
		contentPane.add(comboBoxLP);
		
		JComboBox<String> comboBoxEstudiante = new JComboBox<String>();
		comboBoxEstudiante.setBounds(10, 117, 170, 22);
		contentPane.add(comboBoxEstudiante);
		
		JComboBox<String> comboBoxActividad = new JComboBox<String>();
		comboBoxActividad.setBounds(10, 174, 170, 22);
		contentPane.add(comboBoxActividad);
		
		JButton btnBuscarEst = new JButton("Buscar Respuestas");
		btnBuscarEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sele = (String) comboBoxLP.getSelectedItem();
				for (LearningPath lpa:programa.listaLearningPaths) {
					if (lpa.getTitulo().equals(sele)) {
						for (Estudiante estu:lpa.getEstudiantes()) {
							estu.
						}
					}
				}
			}
		});
		btnBuscarEst.setBounds(10, 216, 170, 22);
		contentPane.add(btnBuscarEst);
		
		JTextArea txtrAquSeMostrarn = new JTextArea();
		txtrAquSeMostrarn.setWrapStyleWord(true);
		txtrAquSeMostrarn.setLineWrap(true);
		txtrAquSeMostrarn.setEditable(false);
		txtrAquSeMostrarn.setText("Aquí se mostrarán las respuestas del estudiante");
		txtrAquSeMostrarn.setBounds(225, 18, 201, 184);
		contentPane.add(txtrAquSeMostrarn);
		
		textFieldNota = new JTextField();
		textFieldNota.setBounds(345, 213, 81, 20);
		contentPane.add(textFieldNota);
		textFieldNota.setColumns(10);
		
		JLabel lblNotaObtenida = new JLabel("Nota Obtenida:");
		lblNotaObtenida.setBounds(225, 216, 110, 14);
		contentPane.add(lblNotaObtenida);
		
		JButton btnCalificar = new JButton("Calificar");
		btnCalificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCalificar.setBounds(173, 239, 89, 23);
		contentPane.add(btnCalificar);
		
		JLabel lblLP = new JLabel("Selecciona un Learning Path:");
		lblLP.setHorizontalAlignment(SwingConstants.CENTER);
		lblLP.setBounds(10, 19, 170, 14);
		contentPane.add(lblLP);
		
		JLabel lblSeleccionaUnEstudiante = new JLabel("Selecciona un estudiante:");
		lblSeleccionaUnEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnEstudiante.setBounds(10, 102, 170, 14);
		contentPane.add(lblSeleccionaUnEstudiante);
		
		JLabel lblSeleccionaUnaActividad = new JLabel("Selecciona una actividad");
		lblSeleccionaUnaActividad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnaActividad.setBounds(10, 157, 170, 14);
		contentPane.add(lblSeleccionaUnaActividad);
		
		JButton btnBuscarEstudiantes = new JButton("Buscar Estudiantes");
		btnBuscarEstudiantes.setBounds(33, 68, 127, 23);
		btnBuscarEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sele = (String) comboBoxLP.getSelectedItem();
				for (LearningPath lpa:programa.listaLearningPaths) {
					if (lpa.getTitulo().equals(sele)) {
						for (Estudiante estu:lpa.getEstudiantes()) {
                            comboBoxEstudiante.addItem(estu.getNombre());
                        }
						for (Actividad act:lpa.getActividades()) {
							comboBoxActividad.addItem(act.getTitulo());
						}
					}
				}
			}
		});
		contentPane.add(btnBuscarEstudiantes);
	}
}
