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
import learningPaths.Tarea;
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
	private JTextField textFieldTituloRecurso;
	private JTextField textFieldTituloEncuesta;
	private JTextField textFieldTituloExamen;
	private JTextField textFieldTituloTarea;
	private JTextField textFieldTituloQuiz;
	private JTextField textField_1;
	private JTextField textFieldNivelRecurso;
	private JTextField textFieldNivelEncuesta;
	private JTextField textFieldNivelExamen;
	private JTextField textFieldNivelTarea;
	private JTextField textFieldNivelQuiz;
	private JTextField textField_2;
	private JTextField textFieldTiempoRecurso;
	private JTextField textFieldTiempoEncuesta;
	private JTextField textFieldTiempoExamen;
	private JTextField textFieldTiempoTarea;
	private JTextField textFieldTiempoQuiz;
	private JTextField textField_3;
	private JTextField textFieldObjetivoRecurso;
	private JTextField textFieldObjetivoEncuesta;
	private JTextField textFieldObjetivoExamen;
	private JTextField textFieldObjetivoTarea;
	private JTextField textFieldObjetivoQuiz;
	private JTextField textField_4;
	private JTextField textFieldCantidadPreg;
	private JTextField textFieldCantidadPregEncuesta;
	private JTextField textFieldCantidadPregExamen;
	private JTextField textFieldCantidadPregQuiz;
	private JTextField textFieldTipoRecurso;
	 ArrayList<PreguntaAbierta> pregA = new ArrayList<PreguntaAbierta>();
	ArrayList<PreguntaCerrada> pregC = new ArrayList<PreguntaCerrada>();
	private JTextField textFieldNotaQuiz;
	private JTextField textFieldNotaExamen;
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
		
		//quiz
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
		JComboBox comboBoxsug = new JComboBox();
		comboBoxPrereq.setBounds(94, 153, 166, 22);
		comboBoxsug.setBounds(94, 185, 166, 22);
		panelQuiz.add(comboBoxPrereq);
		for(String nombre:nombreAct) {
			comboBoxPrereq.addItem(nombre);
			comboBoxsug.addItem(nombre);
		}
		panelQuiz.add(comboBoxPrereq);
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
						pre = act;}
					if(comboBoxsug.getSelectedItem().equals(act.getTitulo())) {
						sug = act;
					}
				}
				Quiz quiz = new Quiz(Float.parseFloat(textFieldNotaQuiz.getText()),(float) 0,false,pregC,textFieldObjetivoQuiz.getText(),
						textFieldTituloQuiz.getText(),textFieldNivelQuiz.getText(),pre,sug,"",Float.parseFloat(textFieldTiempoQuiz.getText()),5,false);
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
		
		textFieldTituloQuiz = new JTextField();
		textFieldTituloQuiz.setColumns(10);
		textFieldTituloQuiz.setBounds(94, 11, 166, 20);
		panelQuiz.add(textFieldTituloQuiz);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(10, 42, 48, 14);
		panelQuiz.add(lblNivel);
		
		textFieldNivelQuiz = new JTextField();
		textFieldNivelQuiz.setColumns(10);
		textFieldNivelQuiz.setBounds(94, 39, 166, 20);
		panelQuiz.add(textFieldNivelQuiz);
		
		JLabel lblTiempoLmite = new JLabel("Tiempo Límite:");
		lblTiempoLmite.setBounds(10, 70, 99, 14);
		panelQuiz.add(lblTiempoLmite);
		
		textFieldTiempoQuiz = new JTextField();
		textFieldTiempoQuiz.setColumns(10);
		textFieldTiempoQuiz.setBounds(94, 67, 166, 20);
		panelQuiz.add(textFieldTiempoQuiz);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(10, 99, 74, 14);
		panelQuiz.add(lblObjetivo);
		
		textFieldObjetivoQuiz = new JTextField();
		textFieldObjetivoQuiz.setColumns(10);
		textFieldObjetivoQuiz.setBounds(94, 95, 166, 20);
		panelQuiz.add(textFieldObjetivoQuiz);
		
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
		
		textFieldNotaQuiz = new JTextField();
		textFieldNotaQuiz.setColumns(10);
		textFieldNotaQuiz.setBounds(94, 124, 166, 20);
		panelQuiz.add(textFieldNotaQuiz);
		
		
		//tarea
		JPanel panelTarea = new JPanel();
		tabbedPane.addTab("  Tarea  ", null, panelTarea, null);
		panelTarea.setLayout(null);
		
		JLabel lblTituloT = new JLabel("Titulo:");
		lblTituloT.setBounds(10, 14, 32, 14);
		panelTarea.add(lblTituloT);
		
		textFieldTituloTarea = new JTextField();
		textFieldTituloTarea.setColumns(10);
		textFieldTituloTarea.setBounds(94, 11, 166, 20);
		panelTarea.add(textFieldTituloTarea);
		
		JLabel lblNivelT = new JLabel("Nivel:");
		lblNivelT.setBounds(10, 42, 48, 14);
		panelTarea.add(lblNivelT);
		
		textFieldNivelTarea = new JTextField();
		textFieldNivelTarea.setColumns(10);
		textFieldNivelTarea.setBounds(94, 39, 166, 20);
		panelTarea.add(textFieldNivelTarea);
		
		JLabel lblTiempoLmiteT = new JLabel("Tiempo Límite:");
		lblTiempoLmiteT.setBounds(10, 70, 99, 14);
		panelTarea.add(lblTiempoLmiteT);
		
		textFieldTiempoTarea = new JTextField();
		textFieldTiempoTarea.setColumns(10);
		textFieldTiempoTarea.setBounds(94, 67, 166, 20);
		panelTarea.add(textFieldTiempoTarea);
		
		JLabel lblObjetivoT = new JLabel("Objetivo:");
		lblObjetivoT.setBounds(10, 99, 45, 14);
		panelTarea.add(lblObjetivoT);
		
		textFieldObjetivoTarea = new JTextField();
		textFieldObjetivoTarea.setColumns(10);
		textFieldObjetivoTarea.setBounds(94, 95, 166, 20);
		panelTarea.add(textFieldObjetivoTarea);
		
		JLabel lblPrerequisitoT = new JLabel("Prerequisito:");
		lblPrerequisitoT.setBounds(10, 131, 80, 14);
		panelTarea.add(lblPrerequisitoT);
		
		JLabel lblSugeridoT = new JLabel("Sugerido:");
		lblSugeridoT.setBounds(10, 156, 67, 14);
		panelTarea.add(lblSugeridoT);
		
		JComboBox comboBoxPrereqTarea = new JComboBox();
		comboBoxPrereqTarea.setBounds(94, 126, 166, 22);
		
		JComboBox comboBoxSugTarea = new JComboBox();
		comboBoxSugTarea.setBounds(94, 156, 166, 22);
		
		for(String nombre:nombreAct) {
			comboBoxPrereqTarea.addItem(nombre);
			comboBoxSugTarea.addItem(nombre);
		}
	
		panelTarea.add(comboBoxSugTarea);
		panelTarea.add(comboBoxPrereqTarea);
		
		JButton btnCrearTarea = new JButton("Crear Tarea");
		btnCrearTarea.setBounds(311, 185, 120, 23);
		btnCrearTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Tarea Creada con exito");
				exp.setVisible(true);
				Actividad pre = null ;
				Actividad sug = null ;
				for(Actividad act:programa.listaActividades) {
					if(comboBoxPrereqTarea.getSelectedItem().equals(act.getTitulo())){
						pre = act;
					}
					if(comboBoxSugTarea.getSelectedItem().equals(act.getTitulo())) {
						sug = act;
					}
				}
				Tarea tarea = new Tarea(false,textFieldObjetivoTarea.getText(),textFieldTituloTarea.getText(),textFieldNivelTarea.getText()
						,pre,sug,"",Float.parseFloat(textFieldTiempoTarea.getText()),5,false);
				try {
                    programa.crearTarea(tarea);
                    profesor.anadirActs(tarea);
                    datos.cambiarDatosProfesor(profesor);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
			}
		});
		panelTarea.add(btnCrearTarea);
		lblTiempoLmiteT.setBounds(10, 70, 99, 14);
		lblSugeridoT.setBounds(10, 156, 67, 14);
		
		//Examen
		JPanel panelExamen = new JPanel();
		tabbedPane.addTab("   Examen ", null, panelExamen, null);
		panelExamen.setLayout(null);
		
		JLabel lblTituloE = new JLabel("Titulo:");
		lblTituloE.setBounds(10, 14, 32, 14);
		panelExamen.add(lblTituloE);
		
		textFieldTituloExamen = new JTextField();
		textFieldTituloExamen.setColumns(10);
		textFieldTituloExamen.setBounds(94, 11, 166, 20);
		panelExamen.add(textFieldTituloExamen);
		
		JLabel lblNivelE = new JLabel("Nivel:");
		lblNivelE.setBounds(10, 42, 48, 14);
		panelExamen.add(lblNivelE);
		
		textFieldNivelExamen = new JTextField();
		textFieldNivelExamen.setColumns(10);
		textFieldNivelExamen.setBounds(94, 39, 166, 20);
		panelExamen.add(textFieldNivelExamen);
		
		JLabel lblTiempoLmiteE = new JLabel("Tiempo Límite:");
		lblTiempoLmiteE.setBounds(10, 70, 99, 14);
		panelExamen.add(lblTiempoLmiteE);
		
		textFieldTiempoExamen = new JTextField();
		textFieldTiempoExamen.setColumns(10);
		textFieldTiempoExamen.setBounds(94, 67, 166, 20);
		panelExamen.add(textFieldTiempoExamen);
		
		JLabel lblObjetivoE = new JLabel("Objetivo:");
		lblObjetivoE.setBounds(10, 99, 56, 14);
		panelExamen.add(lblObjetivoE);
		
		textFieldObjetivoExamen = new JTextField();
		textFieldObjetivoExamen.setColumns(10);
		textFieldObjetivoExamen.setBounds(94, 95, 166, 20);
		panelExamen.add(textFieldObjetivoExamen);
		
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
		lblPrerequisitoE.setBounds(10, 161, 80, 14);
		panelExamen.add(lblPrerequisitoE);
		
		JLabel lblSugeridoE = new JLabel("Sugerido:");
		lblSugeridoE.setBounds(10, 186, 67, 14);
		panelExamen.add(lblSugeridoE);
		
		textFieldCantidadPregExamen = new JTextField();
		textFieldCantidadPregExamen.setColumns(10);
		textFieldCantidadPregExamen.setBounds(314, 77, 87, 20);
		panelExamen.add(textFieldCantidadPregExamen);
		
		JButton btnCrearPreguntasExamen = new JButton("Crear Preguntas");
		btnCrearPreguntasExamen.setBounds(302, 105, 111, 23);
		btnCrearPreguntasExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadPreguntas = Integer.parseInt(textFieldCantidadPregExamen.getText()) ;
				System.out.println(cantidadPreguntas);
				int j=0;
				while (j < cantidadPreguntas) {
					CrearPreguntasAbiertas preg = new CrearPreguntasAbiertas();
					preg.setVisible(true);
					j++;
				}
				
			}
		});
		panelExamen.add(btnCrearPreguntasExamen);
		
		JButton btnCrearExamen = new JButton("Crear Examen");
		btnCrearExamen.setBounds(311, 185, 120, 23);
		btnCrearExamen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Examen creado con éxito");
				exp.setVisible(true);
			}
		});
		panelExamen.add(btnCrearExamen);
		
		JComboBox comboBoxPrereqExamen = new JComboBox();
		comboBoxPrereqExamen.setBounds(94, 156, 166, 22);
		panelExamen.add(comboBoxPrereqExamen);
		
		JComboBox comboBoxSugExamen = new JComboBox();
		comboBoxSugExamen.setBounds(94, 186, 166, 22);
		panelExamen.add(comboBoxSugExamen);
		
		JLabel lblNotaMinima_1 = new JLabel("Nota Minima");
		lblNotaMinima_1.setBounds(10, 128, 80, 14);
		panelExamen.add(lblNotaMinima_1);
		
		textFieldNotaExamen = new JTextField();
		textFieldNotaExamen.setColumns(10);
		textFieldNotaExamen.setBounds(94, 124, 166, 20);
		panelExamen.add(textFieldNotaExamen);
		
		//
		JPanel panelEncuesta = new JPanel();
		tabbedPane.addTab(" Encuesta ", null, panelEncuesta, null);
		panelEncuesta.setLayout(null);
		
		JLabel lblTituloEE = new JLabel("Titulo:");
		lblTituloEE.setBounds(10, 14, 32, 14);
		panelEncuesta.add(lblTituloEE);
		
		textFieldTituloEncuesta = new JTextField();
		textFieldTituloEncuesta.setColumns(10);
		textFieldTituloEncuesta.setBounds(94, 11, 166, 20);
		panelEncuesta.add(textFieldTituloEncuesta);
		
		JLabel lblNivelEE = new JLabel("Nivel:");
		lblNivelEE.setBounds(10, 42, 48, 14);
		panelEncuesta.add(lblNivelEE);
		
		textFieldNivelEncuesta = new JTextField();
		textFieldNivelEncuesta.setColumns(10);
		textFieldNivelEncuesta.setBounds(94, 39, 166, 20);
		panelEncuesta.add(textFieldNivelEncuesta);
		
		JLabel lblTiempoLmiteEE = new JLabel("Tiempo Límite:");
		lblTiempoLmiteEE.setBounds(10, 70, 99, 14);
		panelEncuesta.add(lblTiempoLmiteEE);
		
		textFieldTiempoEncuesta = new JTextField();
		textFieldTiempoEncuesta.setColumns(10);
		textFieldTiempoEncuesta.setBounds(94, 67, 166, 20);
		panelEncuesta.add(textFieldTiempoEncuesta);
		
		JLabel lblObjetivoEE = new JLabel("Objetivo:");
		lblObjetivoEE.setBounds(10, 99, 45, 14);
		panelEncuesta.add(lblObjetivoEE);
		
		textFieldObjetivoEncuesta = new JTextField();
		textFieldObjetivoEncuesta.setColumns(10);
		textFieldObjetivoEncuesta.setBounds(94, 95, 166, 20);
		panelEncuesta.add(textFieldObjetivoEncuesta);
		
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
		
		textFieldCantidadPregEncuesta = new JTextField();
		textFieldCantidadPregEncuesta.setColumns(10);
		textFieldCantidadPregEncuesta.setBounds(314, 77, 87, 20);
		panelEncuesta.add(textFieldCantidadPregEncuesta);
		
		JButton btnCrearPreguntasEncuesta = new JButton("Crear Preguntas");
		btnCrearPreguntasEncuesta.setBounds(302, 105, 111, 23);
		btnCrearPreguntasEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidadPreguntas = Integer.parseInt(textFieldCantidadPregEncuesta.getText()) ;
				System.out.println(cantidadPreguntas);
				int j=0;
				while (j < cantidadPreguntas) {
					CrearPreguntasAbiertas preg = new CrearPreguntasAbiertas();
					preg.setVisible(true);
					j++;
				}
				
			}
		});
		panelEncuesta.add(btnCrearPreguntasEncuesta);
		
		JButton btnCrearEncuesta = new JButton("Crear Encuesta");
		btnCrearEncuesta.setBounds(311, 185, 120, 23);
		btnCrearEncuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Encuesta creada con éxito");
				exp.setVisible(true);
			}
		});
		panelEncuesta.add(btnCrearEncuesta);
		JComboBox comboBoxPrereqEncuesta = new JComboBox();
		comboBoxPrereqEncuesta.setBounds(94, 126, 166, 22);
		panelEncuesta.add(comboBoxPrereqEncuesta);
		
		JComboBox comboBoxSugEncuesta = new JComboBox();
		comboBoxSugEncuesta.setBounds(94, 156, 166, 22);
		panelEncuesta.add(comboBoxSugEncuesta);
		
		
		//
		JPanel panelRecurso = new JPanel();
		tabbedPane.addTab("  Recurso", null, panelRecurso, null);
		panelRecurso.setLayout(null);
		
		JLabel lblTituloR = new JLabel("Titulo:");
		lblTituloR.setBounds(10, 14, 32, 14);
		panelRecurso.add(lblTituloR);
		
		textFieldTituloRecurso = new JTextField();
		textFieldTituloRecurso.setColumns(10);
		textFieldTituloRecurso.setBounds(94, 11, 166, 20);
		panelRecurso.add(textFieldTituloRecurso);
		
		JLabel lblNivelR = new JLabel("Nivel:");
		lblNivelR.setBounds(10, 42, 48, 14);
		panelRecurso.add(lblNivelR);
		
		textFieldNivelRecurso = new JTextField();
		textFieldNivelRecurso.setColumns(10);
		textFieldNivelRecurso.setBounds(94, 39, 166, 20);
		panelRecurso.add(textFieldNivelRecurso);
		
		JLabel lblTiempoLmiteR = new JLabel("Tiempo Límite:");
		panelRecurso.add(lblTiempoLmiteR);
		
		textFieldTiempoRecurso = new JTextField();
		textFieldTiempoRecurso.setColumns(10);
		textFieldTiempoRecurso.setBounds(94, 67, 166, 20);
		panelRecurso.add(textFieldTiempoRecurso);
		
		JLabel lblObjetivoR = new JLabel("Objetivo:");
		lblObjetivoR.setBounds(10, 99, 45, 14);
		panelRecurso.add(lblObjetivoR);
		
		textFieldObjetivoRecurso = new JTextField();
		textFieldObjetivoRecurso.setColumns(10);
		textFieldObjetivoRecurso.setBounds(94, 95, 166, 20);
		panelRecurso.add(textFieldObjetivoRecurso);
		
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
		panelRecurso.add(lblSugeridoR);
		
		
		
		JButton btnCrearRecurso = new JButton("Crear Recurso");
		btnCrearRecurso.setBounds(311, 185, 120, 23);
		btnCrearRecurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcepcionesFrame exp = new ExcepcionesFrame("Recurso creado con éxito");
				exp.setVisible(true);
				
			}
		});
		panelRecurso.add(btnCrearRecurso);
		
		JLabel lblTiempoLmiteT_1 = new JLabel("Tiempo Límite:");
		lblTiempoLmiteT_1.setBounds(10, 70, 99, 14);
		panelRecurso.add(lblTiempoLmiteT_1);
		
		JLabel lblSugeridoT_1 = new JLabel("Sugerido:");
		lblSugeridoT_1.setBounds(10, 160, 67, 14);
		panelRecurso.add(lblSugeridoT_1);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 189, 45, 14);
		panelRecurso.add(lblTipo);
		
		textFieldTipoRecurso = new JTextField();
		textFieldTipoRecurso.setColumns(10);
		textFieldTipoRecurso.setBounds(94, 185, 166, 20);
		panelRecurso.add(textFieldTipoRecurso);
		
		JComboBox comboBoxPrereqRecurso = new JComboBox();
		comboBoxPrereqRecurso.setBounds(94, 126, 166, 22);
		panelRecurso.add(comboBoxPrereqRecurso);
		
		JComboBox comboBoxSugRecurso = new JComboBox();
		comboBoxSugRecurso.setBounds(94, 156, 166, 22);
		panelRecurso.add(comboBoxSugRecurso);
		

		
		
	}
}
