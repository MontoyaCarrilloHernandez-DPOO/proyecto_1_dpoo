package gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import learningPaths.Actividad;
import learningPaths.PreguntaAbierta;
import learningPaths.PreguntaCerrada;
import learningPaths.Quiz;
import persistencia.Controlador;
import persistencia.ModificarDatos;
import persistencia.RecogerDatos;
import usuarios.Profesor;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.util.ArrayList;

public class CrearActividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textFieldCantidadPreg;
	private JTextField textFieldCantidadPregEE;
	private JTextField textFieldCantidadPregEx;
	private JTextField textFieldCantidadPregQuiz;
	private JTextField textField_7;
	 ArrayList<PreguntaAbierta> pregA = new ArrayList<PreguntaAbierta>();
	ArrayList<PreguntaCerrada> pregC = new ArrayList<PreguntaCerrada>();
	private JTextField textFieldNota;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CrearActividad(Controlador programa, Profesor profesor) {
		ModificarDatos datos = new ModificarDatos();
		RecogerDatos recoger = new RecogerDatos();
		ArrayList<String> nombreAct = new ArrayList<String>();
		for (Actividad act:programa.listaActividades) {
			nombreAct.addLast(act.getTitulo());
		}
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear Actividad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		tabbedPane.addTab("   Quiz  ", null, panelQuiz, null);
		panelQuiz.setLayout(null);
		
		JLabel lblPrerequisito = new JLabel("Prerequisito:");
		lblPrerequisito.setBounds(10, 157, 80, 14);
		panelQuiz.add(lblPrerequisito);
		
		JLabel lblSugerido = new JLabel("Sugerido:");
		lblSugerido.setBounds(10, 185, 67, 14);
		panelQuiz.add(lblSugerido);
		
		textFieldCantidadPregQuiz = new JTextField();
		textFieldCantidadPregQuiz.setColumns(10);
		textFieldCantidadPregQuiz.setBounds(314, 77, 87, 20);
		panelQuiz.add(textFieldCantidadPregQuiz);

		JComboBox comboBoxPrereq = new JComboBox();
		comboBoxPrereq.setBounds(94, 153, 166, 22);
		panelQuiz.add(comboBoxPrereq);
		for(String nombre:nombreAct) {
			comboBoxPrereq.addItem(nombre);
		}
		panelQuiz.add(comboBoxPrereq);
		
		JComboBox comboBoxsug = new JComboBox();
		comboBoxsug.setBounds(94, 185, 166, 22);
		for(String nombre:nombreAct) {
			comboBoxsug.addItem(nombre);
		}
		panelQuiz.add(comboBoxsug);
		JButton btnCrearQuiz = new JButton("Crear Quiz");
		btnCrearQuiz.setBounds(311, 185, 120, 23);
		btnCrearQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Quiz creado con éxito");
				exp.setVisible(true);
				Actividad pre = null ;
				Actividad sug = null ;
				for(Actividad act:programa.listaActividades) {
					if(comboBoxPrereq.getSelectedItem().equals(act.getTitulo())){
						pre = act;
					if(comboBoxsug.getSelectedItem().equals(act.getTitulo())) {
						sug = act;
					}
				}}
				Quiz quiz = new Quiz(Float.parseFloat(textFieldNota.getText()),(float) 0,false,pregC,textField_3.getText(),textField.getText(),textField_1.getText(),pre,sug,"",Float.parseFloat(textField_2.getText()),5,false);
				try {
                    programa.crearQuiz(quiz);
                    profesor.anadirActs(quiz);
                    datos.cambiarDatosProfesor(profesor);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
		
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
		lblObjetivo.setBounds(10, 99, 74, 14);
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
		
		
		JButton btnCrearPreguntaQ = new JButton("Crear Preguntas");
		btnCrearPreguntaQ.setBounds(302, 105, 111, 23);
		btnCrearPreguntaQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadPreguntas = Integer.parseInt(textFieldCantidadPregQuiz.getText()) ;
				System.out.println(cantidadPreguntas);
				int j=0;
				while (j < cantidadPreguntas) {
					CrearPreguntasCerradas preg = new CrearPreguntasCerradas(programa, CrearActividad.this);
					preg.setVisible(true);
					j++;
				}
				
			}
		});
		panelQuiz.add(btnCrearPreguntaQ);
		
		
		JLabel lblNotaMinima = new JLabel("Nota Minima:");
		lblNotaMinima.setBounds(10, 128, 74, 14);
		panelQuiz.add(lblNotaMinima);
		
		textFieldNota = new JTextField();
		textFieldNota.setColumns(10);
		textFieldNota.setBounds(94, 124, 166, 20);
		panelQuiz.add(textFieldNota);
		
		
		//
		JPanel panelTarea = new JPanel();
		tabbedPane.addTab("  Tarea  ", null, panelTarea, null);
		panelTarea.setLayout(null);
		
		JLabel lblTituloT = new JLabel("Titulo:");
		lblTituloT.setBounds(10, 14, 32, 14);
		panelTarea.add(lblTituloT);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 11, 166, 20);
		panelTarea.add(textField);
		
		JLabel lblNivelT = new JLabel("Nivel:");
		lblNivelT.setBounds(10, 42, 48, 14);
		panelTarea.add(lblNivelT);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 39, 166, 20);
		panelTarea.add(textField_1);
		
		JLabel lblTiempoLmiteT = new JLabel("Tiempo Límite:");
		lblTiempoLmiteT.setBounds(10, 70, 99, 14);
		panelTarea.add(lblTiempoLmiteT);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 67, 166, 20);
		panelTarea.add(textField_2);
		
		JLabel lblObjetivoT = new JLabel("Objetivo:");
		lblObjetivoT.setBounds(10, 99, 45, 14);
		panelTarea.add(lblObjetivoT);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 95, 166, 20);
		panelTarea.add(textField_3);
		
		JLabel lblMetaT = new JLabel("Metadatos:");
		lblMetaT.setBounds(10, 239, 56, 14);
		panelTarea.add(lblMetaT);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 166, 20);
		panelTarea.add(textField_4);
		
		JLabel lblPrerequisitoT = new JLabel("Prerequisito:");
		lblPrerequisitoT.setBounds(10, 131, 80, 14);
		panelTarea.add(lblPrerequisitoT);
		
		JLabel lblSugeridoT = new JLabel("Sugerido:");
		lblSugeridoT.setBounds(10, 156, 67, 14);
		panelTarea.add(lblSugeridoT);
		
		JButton btnCrearTarea = new JButton("Crear Tarea");
		btnCrearTarea.setBounds(311, 185, 120, 23);
		btnCrearTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Tarea creada con éxito");
				exp.setVisible(true);
			}
		});
		panelTarea.add(btnCrearTarea);
		
		//
		JPanel panelExamen = new JPanel();
		tabbedPane.addTab("   Examen ", null, panelExamen, null);
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
		lblMetaE.setBounds(10, 239, 56, 14);
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
		
		textFieldCantidadPregEx = new JTextField();
		textFieldCantidadPregEx.setColumns(10);
		textFieldCantidadPregEx.setBounds(314, 77, 87, 20);
		panelExamen.add(textFieldCantidadPregEx);
		
		JButton btnCrearPreguntasE = new JButton("Crear Preguntas");
		btnCrearPreguntasE.setBounds(302, 105, 111, 23);
		btnCrearPreguntasE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadPreguntas = Integer.parseInt(textFieldCantidadPregEx.getText()) ;
				System.out.println(cantidadPreguntas);
				int j=0;
				while (j < cantidadPreguntas) {
					CrearPreguntasAbiertas preg = new CrearPreguntasAbiertas();
					preg.setVisible(true);
					j++;
				}
				
			}
		});
		panelExamen.add(btnCrearPreguntasE);
		
		JButton btnCrearExamen = new JButton("Crear Examen");
		btnCrearExamen.setBounds(311, 185, 120, 23);
		btnCrearExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Examen creado con éxito");
				exp.setVisible(true);
			}
		});
		panelExamen.add(btnCrearExamen);
		
		JComboBox comboBoxPre_2 = new JComboBox();
		comboBoxPre_2.setBounds(94, 126, 166, 22);
		panelExamen.add(comboBoxPre_2);
		
		JComboBox comboBoxSug_2 = new JComboBox();
		comboBoxSug_2.setBounds(94, 156, 166, 22);
		panelExamen.add(comboBoxSug_2);
		
		//
		JPanel panelEncuesta = new JPanel();
		tabbedPane.addTab(" Encuesta ", null, panelEncuesta, null);
		panelEncuesta.setLayout(null);
		
		JLabel lblTituloEE = new JLabel("Titulo:");
		lblTituloEE.setBounds(10, 14, 32, 14);
		panelEncuesta.add(lblTituloEE);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 11, 166, 20);
		panelEncuesta.add(textField);
		
		JLabel lblNivelEE = new JLabel("Nivel:");
		lblNivelEE.setBounds(10, 42, 48, 14);
		panelEncuesta.add(lblNivelEE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 39, 166, 20);
		panelEncuesta.add(textField_1);
		
		JLabel lblTiempoLmiteEE = new JLabel("Tiempo Límite:");
		lblTiempoLmiteEE.setBounds(10, 70, 99, 14);
		panelEncuesta.add(lblTiempoLmiteEE);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 67, 166, 20);
		panelEncuesta.add(textField_2);
		
		JLabel lblObjetivoEE = new JLabel("Objetivo:");
		lblObjetivoEE.setBounds(10, 99, 45, 14);
		panelEncuesta.add(lblObjetivoEE);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 95, 166, 20);
		panelEncuesta.add(textField_3);
		
		JLabel lblCantidadDePreguntasEE = new JLabel("Cantidad de preguntas:");
		lblCantidadDePreguntasEE.setBounds(293, 52, 128, 14);
		panelEncuesta.add(lblCantidadDePreguntasEE);
		
		JLabel lblMetaEE = new JLabel("Metadatos:");
		lblMetaEE.setBounds(10, 239, 56, 14);
		panelEncuesta.add(lblMetaEE);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 166, 20);
		panelEncuesta.add(textField_4);
		
		JLabel lblPrerequisitoEE = new JLabel("Prerequisito:");
		lblPrerequisitoEE.setBounds(10, 131, 80, 14);
		panelEncuesta.add(lblPrerequisitoEE);
		
		JLabel lblSugeridoEE = new JLabel("Sugerido:");
		lblSugeridoEE.setBounds(10, 160, 67, 14);
		panelEncuesta.add(lblSugeridoEE);
		
		textFieldCantidadPregEE = new JTextField();
		textFieldCantidadPregEE.setColumns(10);
		textFieldCantidadPregEE.setBounds(314, 77, 87, 20);
		panelEncuesta.add(textFieldCantidadPregEE);
		
		JButton btnCrearPreguntasEE = new JButton("Crear Preguntas");
		btnCrearPreguntasEE.setBounds(302, 105, 111, 23);
		btnCrearPreguntasEE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadPreguntas = Integer.parseInt(textFieldCantidadPregEE.getText()) ;
				System.out.println(cantidadPreguntas);
				int j=0;
				while (j < cantidadPreguntas) {
					CrearPreguntasAbiertas preg = new CrearPreguntasAbiertas();
					preg.setVisible(true);
					j++;
				}
				
			}
		});
		panelEncuesta.add(btnCrearPreguntasEE);
		
		JButton btnCrearEncuesta = new JButton("Crear Encuesta");
		btnCrearEncuesta.setBounds(311, 185, 120, 23);
		btnCrearEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Encuesta creada con éxito");
				exp.setVisible(true);
			}
		});
		panelEncuesta.add(btnCrearEncuesta);
		
		JComboBox comboBoxPre_1 = new JComboBox();
		comboBoxPre_1.setBounds(94, 126, 166, 22);
		panelEncuesta.add(comboBoxPre_1);
		
		JComboBox comboBoxSug_1 = new JComboBox();
		comboBoxSug_1.setBounds(94, 156, 166, 22);
		panelEncuesta.add(comboBoxSug_1);
		
		
		//
		JPanel panelRecurso = new JPanel();
		tabbedPane.addTab("  Recurso", null, panelRecurso, null);
		panelRecurso.setLayout(null);
		
		JLabel lblTituloR = new JLabel("Titulo:");
		lblTituloR.setBounds(10, 14, 32, 14);
		panelRecurso.add(lblTituloR);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(94, 11, 166, 20);
		panelRecurso.add(textField);
		
		JLabel lblNivelR = new JLabel("Nivel:");
		lblNivelR.setBounds(10, 42, 48, 14);
		panelRecurso.add(lblNivelR);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 39, 166, 20);
		panelRecurso.add(textField_1);
		
		JLabel lblTiempoLmiteR = new JLabel("Tiempo Límite:");
		lblTiempoLmiteT.setBounds(10, 70, 99, 14);
		panelRecurso.add(lblTiempoLmiteR);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(94, 67, 166, 20);
		panelRecurso.add(textField_2);
		
		JLabel lblObjetivoR = new JLabel("Objetivo:");
		lblObjetivoR.setBounds(10, 99, 45, 14);
		panelRecurso.add(lblObjetivoR);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(94, 95, 166, 20);
		panelRecurso.add(textField_3);
		
		JLabel lblMetaR = new JLabel("Metadatos:");
		lblMetaR.setBounds(10, 239, 56, 14);
		panelRecurso.add(lblMetaR);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(94, 236, 166, 20);
		panelRecurso.add(textField_4);
		
		JLabel lblPrerequisitoR = new JLabel("Prerequisito:");
		lblPrerequisitoR.setBounds(10, 131, 80, 14);
		panelRecurso.add(lblPrerequisitoR);
		
		JLabel lblSugeridoR = new JLabel("Sugerido:");
		lblSugeridoT.setBounds(10, 156, 67, 14);
		
		JComboBox comboBoxPre_3 = new JComboBox();
		comboBoxPre_3.setBounds(94, 126, 166, 22);
		panelTarea.add(comboBoxPre_3);
		
		JComboBox comboBoxSug_3 = new JComboBox();
		comboBoxSug_3.setBounds(94, 156, 166, 22);
		panelTarea.add(comboBoxSug_3);
		panelRecurso.add(lblSugeridoR);
		
		JButton btnNewButton = new JButton("Crear Recurso");
		btnNewButton.setBounds(311, 185, 120, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Recurso creado con éxito");
				exp.setVisible(true);
				
			}
		});
		panelRecurso.add(btnNewButton);
		
		JLabel lblTiempoLmiteT_1 = new JLabel("Tiempo Límite:");
		lblTiempoLmiteT_1.setBounds(10, 70, 99, 14);
		panelRecurso.add(lblTiempoLmiteT_1);
		
		JLabel lblSugeridoT_1 = new JLabel("Sugerido:");
		lblSugeridoT_1.setBounds(10, 160, 67, 14);
		panelRecurso.add(lblSugeridoT_1);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 189, 45, 14);
		panelRecurso.add(lblTipo);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(94, 185, 166, 20);
		panelRecurso.add(textField_7);
		
		JComboBox comboBoxPre = new JComboBox();
		comboBoxPre.setBounds(94, 126, 166, 22);
		panelRecurso.add(comboBoxPre);
		
		JComboBox comboBoxSug = new JComboBox();
		comboBoxSug.setBounds(94, 156, 166, 22);
		panelRecurso.add(comboBoxSug);
		

		
		
	}
}
