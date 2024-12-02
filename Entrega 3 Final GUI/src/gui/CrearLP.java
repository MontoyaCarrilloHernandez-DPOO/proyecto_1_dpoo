package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.Controlador;
import usuarios.Profesor;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

public class CrearLP extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldTitulo;
	private JTextField textFieldDuracion;
	private JTextField textFieldDescripcion;
	private JTextField textFieldObjetivo;
	private JTextField textFieldMetadatos;

	/**
	 * Create the frame.
	 */
	public CrearLP(Controlador programa, Profesor profesor) {
		ImageIcon logo = new ImageIcon("datos/logo.png");
		setIconImage(logo.getImage());
		setTitle("Crear o duplicar un Learning Path");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(tabbedPane);
		
		JPanel Crear = new JPanel();
		tabbedPane.addTab("        Crear un Learning Path original       ", null, Crear, null);
		Crear.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(26, 31, 57, 14);
		Crear.add(lblTitulo);
		
		JLabel lblDuracion = new JLabel("Duración:");
		lblDuracion.setBounds(26, 76, 73, 14);
		Crear.add(lblDuracion);
		
		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(26, 121, 86, 14);
		Crear.add(lblDescripcion);
		
		JLabel lblObjetivo = new JLabel("Objetivo:");
		lblObjetivo.setBounds(26, 166, 70, 14);
		Crear.add(lblObjetivo);
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setBounds(26, 211, 76, 14);
		Crear.add(lblDificultad);
		
		JLabel lblMeta = new JLabel("Metadatos:");
		lblMeta.setBounds(26, 267, 81, 14);
		Crear.add(lblMeta);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(116, 31, 166, 20);
		Crear.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(116, 76, 166, 20);
		Crear.add(textFieldDuracion);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(116, 121, 166, 20);
		Crear.add(textFieldDescripcion);
		
		textFieldObjetivo = new JTextField();
		textFieldObjetivo.setColumns(10);
		textFieldObjetivo.setBounds(116, 165, 166, 20);
		Crear.add(textFieldObjetivo);
		
		textFieldMetadatos = new JTextField();
		textFieldMetadatos.setColumns(10);
		textFieldMetadatos.setBounds(116, 267, 166, 20);
		Crear.add(textFieldMetadatos);
		
		JList listLP = new JList();
		listLP.setBounds(382, 45, 348, 229);
		Crear.add(listLP);
		
		JButton btnNewButton = new JButton("Crear Learning Path");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExcepcionesFrame exp = new ExcepcionesFrame("Learning Path creado con éxito");
				exp.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(488, 285, 144, 23);
		Crear.add(btnNewButton);
		
		JLabel lblAct = new JLabel("Selecciona las actividades que tu Learning Path contendrá: ");
		lblAct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAct.setBounds(358, 20, 384, 14);
		Crear.add(lblAct);
		
		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setValue(5);
		slider.setMinimum(1);
		slider.setMaximum(10);
		slider.setBounds(116, 200, 166, 56);
		Crear.add(slider);
		
		JPanel Duplicar = new JPanel();
		tabbedPane.addTab("      Duplicar un Learning Path existente        ", null, Duplicar, null);
		Duplicar.setLayout(null);
		
		JButton btnDuplicarLearningPath = new JButton("Duplicar Learning Path");
		btnDuplicarLearningPath.setBounds(498, 270, 186, 23);
		Duplicar.add(btnDuplicarLearningPath);
		btnDuplicarLearningPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ExcepcionesFrame exp = new ExcepcionesFrame("Learning Path duplicado con éxito");
				exp.setVisible(true);
			}
		});
		
		JList list_1 = new JList();
		list_1.setBounds(217, 41, 260, 246);
		Duplicar.add(list_1);
		
		JLabel lblNewLabel_4 = new JLabel("Selecciona uno de los siguientes Learning Paths para duplicarlo:");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(45, 16, 601, 14);
		Duplicar.add(lblNewLabel_4);
	}
}
