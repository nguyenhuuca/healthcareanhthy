package com.canh.healthcare.mdimanager.patientgui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PatientForm extends JInternalFrame {

	// private static final int BORDER = 12; // Window border in pixels.
	// private static final int GAP = 5; // Default gap btwn components.

	private JLabel lblId = new JLabel("Id bệnh nhân");
	private JLabel lblName = new JLabel("Tên bệnh nhân");
	private JTextField txtId = new JTextField("test", 10);
	private JTextField txtName = new JTextField("test", 20);
	private JLabel lblBirthDay = new JLabel("Năm sinh");
	private JTextField txtBirthDate = new JTextField(10);
	private JLabel lblGender = new JLabel("Giới tính");
	private JTextField txtGender = new JTextField(10);
	private JLabel lblFirstDateJoin = new JLabel("Ngày khám ĐT");
	private JTextField txtFirstDateJoin = new JTextField(10);
	private JLabel lblAddress = new JLabel("Địa chỉ");
	private JTextField txtAddress = new JTextField(30);
	private JLabel lblMobile = new JLabel("SĐT");
	private JTextField txtMobile = new JTextField(10);
	private JLabel lblFamilyContact = new JLabel("Người thân");
	private JTextField txtFamilyContact = new JTextField(20);
	private JLabel lblUrgentContact = new JLabel("LHKC");
	private JTextField txtUrgent = new JTextField(20);
	private JButton buttonLogin = new JButton("Tạo mới");

	public PatientForm() {
		super();
		createInputForm();
		createListPatient();
		setSize(1000, 400);
		// setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		// setResizable(true);
		this.setTitle("Thông tin bệnh nhân");
		this.setVisible(true);
		// setLocationRelativeTo(null);
	}

	public void createInputForm() {
		JPanel newPanel = new JPanel(new GridBagLayout());
		newPanel.setPreferredSize(new Dimension(300, 200));
		// newPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		/*
		 * GBHelper pos = new GBHelper(); newPanel.add(lblId, pos);
		 * newPanel.add(new Gap(GAP), pos.nextCol()); newPanel.add(txtId,
		 * pos.nextCol());
		 */
		//constraints.insets = new Insets(5, 10, 5, 10);
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill=GridBagConstraints.VERTICAL;
		// add components to the panel

		constraints.gridx = 0;
		constraints.gridy = 0;
		// constraints.weightx = 0.5;
		newPanel.add(lblId, constraints);
		constraints.gridx = 1;
		txtId.setMinimumSize(txtId.getPreferredSize());
		newPanel.add(txtId, constraints);
		constraints.gridx = 2;
		// constraints.gridy = 1;
		newPanel.add(lblName, constraints);
		constraints.gridx = 3;
		txtName.setMinimumSize(txtName.getPreferredSize());
		newPanel.add(txtName, constraints);
		constraints.gridx = 4;
		lblBirthDay.setMinimumSize(lblBirthDay.getPreferredSize());
		newPanel.add(lblBirthDay, constraints);
		constraints.gridx = 5;
		txtBirthDate.setMinimumSize(txtBirthDate.getPreferredSize());
		newPanel.add(txtBirthDate, constraints);
		//
		constraints.gridx = 0;
		constraints.gridy = 1;
		newPanel.add(lblGender, constraints);
		constraints.gridx = 1;
		txtGender.setMinimumSize(txtGender.getPreferredSize());
		newPanel.add(txtGender, constraints);
		constraints.gridx = 2;
		newPanel.add(lblFirstDateJoin, constraints);
		constraints.gridx = 3;
		txtFirstDateJoin.setMinimumSize(txtFirstDateJoin.getPreferredSize());
		newPanel.add(txtFirstDateJoin, constraints);
		constraints.gridx = 4;
		// constraints.gridy = 1;
		newPanel.add(lblAddress, constraints);
		constraints.gridx = 5;
		txtAddress.setMinimumSize(txtAddress.getPreferredSize());
		newPanel.add(txtAddress, constraints);
		//

		//
		constraints.gridx = 0;
		constraints.gridy = 2;
		newPanel.add(lblMobile, constraints);
		constraints.gridx = 1;
		txtMobile.setMinimumSize(txtMobile.getPreferredSize());
		newPanel.add(txtMobile, constraints);
		constraints.gridx = 2;
		newPanel.add(lblFamilyContact, constraints);
		constraints.gridx = 3;
		txtFamilyContact.setMinimumSize(txtFamilyContact.getPreferredSize());
		newPanel.add(txtFamilyContact, constraints);
		constraints.gridx = 4;
		// constraints.gridy = 1;
		newPanel.add(lblUrgentContact, constraints);
		constraints.gridx = 5;
		txtUrgent.setMinimumSize(txtUrgent.getPreferredSize());
		newPanel.add(txtUrgent, constraints);
		//

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		newPanel.add(buttonLogin, constraints);

		// set border for the panel
		newPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Thông tin bệnh nhân"));

		// add the panel to this frame
		
		//newPanel.setSize(950,200);
		add(newPanel);
		pack();
		
	}

	public void createListPatient() {
		JPanel pnlListPatient = new JPanel(new GridBagLayout());
		add(pnlListPatient, BorderLayout.AFTER_LAST_LINE);
		pnlListPatient.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Danh sách"));
		
		//pnlListPatient.setVisible(true);
	}
}
