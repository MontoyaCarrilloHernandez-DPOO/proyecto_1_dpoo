package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Profesor;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;

public class CrearActividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textFieldCantidadPreg;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CrearActividad(Controlador programa, Profesor profesor) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Actividad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crear una actividad: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(140, 0, 161, 21);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tabbedPane.setBounds(0, 25, 436, 238);
		contentPane.add(tabbedPane);
		
		JPanel panelQuiz = new JPanel();
		tabbedPane.addTab("      Quiz      ", null, panelQuiz, null);
		panelQuiz.setLayout(null);
		
		JButton btnCrearQuiz = new JButton("Crear Quiz");
		btnCrearQuiz.setBounds(311, 185, 120, 23);
		panelQuiz.add(btnCrearQuiz);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(10, 14, 32, 14);
		panelQuiz.add(lblTitulo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 11, 166, 20);
		panelQuiz.add(textField);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 42, 48, 14);
		panelQuiz.add(lblNivel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 39, 166, 20);
		panelQuiz.add(textField_1);
		
		JLabel lblTiempoLmite = new JLabel("Tiempo Límite:");
		lblTiempoLmite.setBounds(10, 70, 99, 14);
		panelQuiz.add(lblTiempoLmite);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 67, 166, 20);
		panelQuiz.add(textField_2);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(10, 99, 45, 14);
		panelQuiz.add(lblObjetivo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 95, 166, 20);
		panelQuiz.add(textField_3);
		
		JLabel lblCantidadDePreguntas = new JLabel("Cantidad de preguntas:");
		lblCantidadDePreguntas.setBounds(293, 52, 128, 14);
		panelQuiz.add(lblCantidadDePreguntas);
		
		JLabel lblMeta = new JLabel("Metadatos:");
		lblMeta.setBounds(10, 239, 56, 14);
		panelQuiz.add(lblMeta);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 166, 20);
		panelQuiz.add(textField_4);
		
		JLabel lblPrerequisito = new JLabel("Prerequisito:");
		lblPrerequisito.setBounds(10, 131, 80, 14);
		panelQuiz.add(lblPrerequisito);
		
		JLabel lblSugerido = new JLabel("Sugerido:");
		lblSugerido.setBounds(10, 156, 67, 14);
		panelQuiz.add(lblSugerido);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(94, 126, 166, 20);
		panelQuiz.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(94, 157, 166, 20);
		panelQuiz.add(textField_6);
		
		textFieldCantidadPreg = new JTextField();
		textFieldCantidadPreg.setColumns(10);
		textFieldCantidadPreg.setBounds(314, 77, 87, 20);
		panelQuiz.add(textFieldCantidadPreg);
		
		JButton btnNewButton_1 = new JButton("Crear Preguntas");
		btnNewButton_1.setBounds(302, 105, 111, 23);
		panelQuiz.add(btnNewButton_1);
		
		//
		JPanel panelTarea = new JPanel();
		tabbedPane.addTab("     Tarea     ", null, panelTarea, null);
		panelTarea.setLayout(null);
		
		JButton btnCrearTarea = new JButton("Crear Tarea");
		btnCrearTarea.setBounds(311, 185, 120, 23);
		panelTarea.add(btnCrearTarea);
		
		//
		JPanel panelExamen = new JPanel();
		tabbedPane.addTab("    Examen    ", null, panelExamen, null);
		panelExamen.setLayout(null);
		
		JLabel lblTituloE = new JLabel("Titulo:");
		lblTituloE.setBounds(10, 14, 32, 14);
		panelExamen.add(lblTituloE);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 11, 166, 20);
		panelExamen.add(textField);
		
		JLabel lblNivelE = new JLabel("Nivel:");
		lblNivelE.setBounds(10, 42, 48, 14);
		panelExamen.add(lblNivelE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 39, 166, 20);
		panelExamen.add(textField_1);
		
		JLabel lblTiempoLmiteE = new JLabel("Tiempo Límite:");
		lblTiempoLmiteE.setBounds(10, 70, 99, 14);
		panelExamen.add(lblTiempoLmiteE);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 67, 166, 20);
		panelExamen.add(textField_2);
		
		JLabel lblObjetivoE = new JLabel("Objetivo:");
		lblObjetivoE.setBounds(10, 99, 45, 14);
		panelExamen.add(lblObjetivoE);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 95, 166, 20);
		panelExamen.add(textField_3);
		
		JLabel lblCantidadDePreguntasE = new JLabel("Cantidad de preguntas:");
		lblCantidadDePreguntasE.setBounds(293, 52, 128, 14);
		panelExamen.add(lblCantidadDePreguntasE);
		
		JLabel lblMetaE = new JLabel("Metadatos:");
		lblMeta.setBounds(10, 239, 56, 14);
		panelExamen.add(lblMetaE);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 166, 20);
		panelExamen.add(textField_4);
		
		JLabel lblPrerequisitoE = new JLabel("Prerequisito:");
		lblPrerequisitoE.setBounds(10, 131, 80, 14);
		panelExamen.add(lblPrerequisitoE);
		
		JLabel lblSugeridoE = new JLabel("Sugerido:");
		lblSugeridoE.setBounds(10, 156, 67, 14);
		panelExamen.add(lblSugeridoE);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(94, 126, 166, 20);
		panelExamen.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(94, 157, 166, 20);
		panelExamen.add(textField_6);
		
		textFieldCantidadPreg = new JTextField();
		textFieldCantidadPreg.setColumns(10);
		textFieldCantidadPreg.setBounds(314, 77, 87, 20);
		panelExamen.add(textFieldCantidadPreg);
		
		JButton btnCrearPreguntas = new JButton("Crear Preguntas");
		btnCrearPreguntas.setBounds(302, 105, 111, 23);
		panelExamen.add(btnCrearPreguntas);
		
		JButton btnCrearExamen = new JButton("Crear Examen");
		btnCrearExamen.setBounds(311, 185, 120, 23);
		panelExamen.add(btnCrearExamen);
		
		//
		JPanel panelEncuesta = new JPanel();
		tabbedPane.addTab("    Encuesta    ", null, panelEncuesta, null);
		panelEncuesta.setLayout(null);
		
		JButton btnCrearEncuesta = new JButton("Crear Encuesta");
		btnCrearEncuesta.setBounds(311, 185, 120, 23);
		panelEncuesta.add(btnCrearEncuesta);
		
		
		//
		JPanel panelRecurso = new JPanel();
		tabbedPane.addTab("   Recurso ", null, panelRecurso, null);
		panelRecurso.setLayout(null);
		
		JButton btnNewButton = new JButton("Crear Recurso");
		btnNewButton.setBounds(311, 185, 120, 23);
		panelRecurso.add(btnNewButton);
		
		
	}
}
