package view;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControladorProfesor;
import model.Docente;

import javax.swing.JTextField;

public class VistaExamen extends JFrame {

	private static final long serialVersionUID = 1L;
	JComboBox<Docente> jcbDocente;

	private List<Docente> profesores;

	private JPanel contentPane;
	private JButton btnNewButton_1;
	private PanelListas p;
	private JTextField jtfProfesor;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaExamen frame = new VistaExamen();
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
	public VistaExamen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		btnNewButton_1 = new JButton("Actualizar asignaturas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.actualizarAsignaturas((Docente) jcbDocente.getSelectedItem());

			}
		});

		JButton btnNewButton = new JButton("Cargar materias");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p.cargarMaterias((Docente) jcbDocente.getSelectedItem());

			}
		});
				
				jtfProfesor = new JTextField();
				GridBagConstraints gbc_jtfProfesor = new GridBagConstraints();
				gbc_jtfProfesor.gridwidth = 11;
				gbc_jtfProfesor.insets = new Insets(0, 0, 5, 5);
				gbc_jtfProfesor.fill = GridBagConstraints.HORIZONTAL;
				gbc_jtfProfesor.gridx = 2;
				gbc_jtfProfesor.gridy = 1;
				contentPane.add(jtfProfesor, gbc_jtfProfesor);
				jtfProfesor.setColumns(10);
				
				btnNewButton_2 = new JButton("Filtrar");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						jcbDocente.removeAllItems();
						profesores = new ArrayList<Docente>();
						profesores = ControladorProfesor.profesorBusqueda(jtfProfesor.getText());
						for (int i = 0; i < profesores.size(); i++) {
							jcbDocente.addItem(profesores.get(i));
						}
					}
				});
				GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
				gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
				gbc_btnNewButton_2.gridx = 16;
				gbc_btnNewButton_2.gridy = 1;
				contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
				jcbDocente = new JComboBox<Docente>();
				GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
				gbc_jcbProfesor.weightx = 1.0;
				gbc_jcbProfesor.gridwidth = 11;
				gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
				gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
				gbc_jcbProfesor.gridx = 2;
				gbc_jcbProfesor.gridy = 2;
				contentPane.add(jcbDocente, gbc_jcbProfesor);

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 16;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		p = new PanelListas();
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 7;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(p, gbc_lblNewLabel_3);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 16;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		


	}
}
