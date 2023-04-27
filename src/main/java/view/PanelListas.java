package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import controller.ControladorAsignatura;
import controller.ControladorAsignaturapordocente;
import model.Asignatura;
import model.Asignaturaspordocente;
import model.Docente;

public class PanelListas extends JPanel {

	JList listAsigSi;
	JList listAsigNo;
	private List<Asignaturaspordocente> idAsignaturasSi;
	private DefaultListModel<Asignatura> listModelAsignatura = null;
	private DefaultListModel<Asignatura> listModelAsignaturaSel = null;

	/**
	 * Create the panel.
	 */
	public PanelListas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Asignaturas no seleccionadas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Asignaturas seleccionadas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		listAsigNo = new JList(this.getDefaultListModel());
		listAsigNo.setBackground(Color.LIGHT_GRAY);
		this.listAsigNo.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		GridBagConstraints gbc_listAlumnosNo = new GridBagConstraints();
		gbc_listAlumnosNo.weightx = 1.0;
		gbc_listAlumnosNo.insets = new Insets(0, 0, 5, 5);
		gbc_listAlumnosNo.fill = GridBagConstraints.BOTH;
		gbc_listAlumnosNo.gridx = 0;
		gbc_listAlumnosNo.gridy = 1;
		add(listAsigNo, gbc_listAlumnosNo);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 2.0;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodosEstudiantesSi();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverEstudiantesSi();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 2;
		panel.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JButton(">");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 3;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_3 = new JButton(">>");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moverTodosEstudiantes();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 4;
		panel.add(btnNewButton_3, gbc_btnNewButton_3);

		listAsigSi = new JList(this.getDefaultListModelEstuSi());
		listAsigSi.setBackground(Color.LIGHT_GRAY);
		this.listAsigSi.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		GridBagConstraints gbc_listAlumnosSi = new GridBagConstraints();
		gbc_listAlumnosSi.insets = new Insets(0, 0, 5, 0);
		gbc_listAlumnosSi.weightx = 1.0;
		gbc_listAlumnosSi.fill = GridBagConstraints.BOTH;
		gbc_listAlumnosSi.gridx = 3;
		gbc_listAlumnosSi.gridy = 1;
		add(listAsigSi, gbc_listAlumnosSi);

	}

	public void cargarMaterias(Docente doce) {
		this.listModelAsignatura.removeAllElements();
		this.listModelAsignaturaSel.removeAllElements();
		int i = 0;

		idAsignaturasSi = ControladorAsignaturapordocente.profesorBusqueda(doce);
		List<Asignatura> asignaturas = ControladorAsignatura.findAll();

		try {
			for (Asignaturaspordocente estu : idAsignaturasSi) {
				this.listModelAsignaturaSel.addElement(estu.getAsignatura());
			}

			for (i = asignaturas.size() - 1; i >= 0; i--) {

				for (int j = idAsignaturasSi.size() - 1; j >= 0; j--) {
					Asignatura asig1 = asignaturas.get(i);
					Asignatura asig2 = idAsignaturasSi.get(j).getAsignatura();

					if (asig1.getId() == asig2.getId()) {
						asignaturas.remove(i);
					}

				}

			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			asignaturas.remove(i - 1);

		}

		for (Asignatura estu : asignaturas) {
			this.listModelAsignatura.addElement(estu);

		}

	}

	private DefaultListModel getDefaultListModel() {
		this.listModelAsignatura = new DefaultListModel<Asignatura>();
		return this.listModelAsignatura;
	}

	private DefaultListModel getDefaultListModelEstuSi() {
		this.listModelAsignaturaSel = new DefaultListModel<Asignatura>();
		return this.listModelAsignaturaSel;
	}

	private void moverEstudiantes() {
		for (int i = this.listAsigNo.getSelectedIndices().length - 1; i >= 0; i--) {
			Asignatura estu = (Asignatura) this.listModelAsignatura.get(listAsigNo.getSelectedIndices()[i]);
			this.listModelAsignatura.removeElementAt(this.listAsigNo.getSelectedIndices()[i]);
			this.listModelAsignaturaSel.addElement(estu);
		}
	}

	private void moverEstudiantesSi() {
		for (int i = this.listAsigSi.getSelectedIndices().length - 1; i >= 0; i--) {
			Asignatura estu = (Asignatura) this.listModelAsignaturaSel.get(listAsigSi.getSelectedIndices()[i]);
			this.listModelAsignaturaSel.removeElementAt(this.listAsigSi.getSelectedIndices()[i]);
			this.listModelAsignatura.addElement(estu);
		}
	}

	private void moverTodosEstudiantes() {

		for (int i = this.listModelAsignatura.getSize() - 1; i >= 0; i--) {

			Asignatura estu = (Asignatura) this.listModelAsignatura.get(i);
			this.listModelAsignatura.removeElementAt(i);
			this.listModelAsignaturaSel.addElement(estu);

		}

	}

	private void moverTodosEstudiantesSi() {

		for (int i = this.listModelAsignaturaSel.getSize() - 1; i >= 0; i--) {

			Asignatura estu = (Asignatura) this.listModelAsignaturaSel.get(i);
			this.listModelAsignaturaSel.removeElementAt(i);
			this.listModelAsignatura.addElement(estu);

		}

	}

	public void actualizarAsignaturas(Docente prof) {

		List<Asignaturaspordocente> asignaturasProfesor = ControladorAsignaturapordocente.profesorBusqueda(prof);
		
	

		for (int i = listModelAsignaturaSel.getSize() - 1; i >= 0; i--) {
			for (int j = asignaturasProfesor.size() - 1; j >= 0; j--) {
				Asignatura asig = asignaturasProfesor.get(j).getAsignatura();
				Asignatura asig2 = listModelAsignaturaSel.get(i);

				if (asig.getId() == asig2.getId()) {
					asignaturasProfesor.remove(j);

				}
			}

		}

		for (Asignaturaspordocente apd : asignaturasProfesor) {
			ControladorAsignaturapordocente.eliminar(apd);

		}
		
		idAsignaturasSi = ControladorAsignaturapordocente.profesorBusqueda(prof);
		
		for (int i = listModelAsignaturaSel.getSize() - 1; i >= 0; i--) {
			for (int j =  idAsignaturasSi.size() - 1; j >= 0; j--) {
				Asignatura asig = idAsignaturasSi.get(j).getAsignatura();
				Asignatura asig2 = listModelAsignaturaSel.get(i);

				if (asig.getId() != asig2.getId()) {

					Asignaturaspordocente nuevoApd = new Asignaturaspordocente();

					nuevoApd.setAsignatura(listModelAsignaturaSel.get(i));
					nuevoApd.setDocente(prof);
					ControladorAsignaturapordocente.insertar(nuevoApd);

				} else {

				}
			}

		}


	}

}
