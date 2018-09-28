package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;

public class ManageEmployee extends JFrame implements ActionListener {
	private JPanel panel;
	ViewEmployeeActivity prev;
	private Employee employee;
	private JButton buttonBack, buttonEdit, buttonDelete;
	private JLabel title, header, userIdLabel, employeeNameLabel, phoneNumberLabel, roleLabel, salaryLabel;
	private JTextField userIdTF, employeeNameTF, phoneNumberTF, phoneCodeTF, salaryTF;
	private JComboBox roleCB;
	
	public ManageEmployee(String eid, ViewEmployeeActivity prev) {
		super("Manage Employee");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		employee = new Employee(eid);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		userIdLabel = new JLabel("Employee ID: "+employee.getUserId());
		userIdLabel.setBounds(60, 20, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		employeeNameLabel = new JLabel("Name: ");
		employeeNameLabel.setBounds(60, 60, 140, 30);
		employeeNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameLabel);
		
		phoneNumberLabel = new JLabel("Phone: ");
		phoneNumberLabel.setBounds(60, 100, 140, 30);
		phoneNumberLabel.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberLabel);
		
		roleLabel = new JLabel("Role: ");
		roleLabel.setBounds(60, 140, 140, 30);
		roleLabel.setFont(Theme.FONT_INPUT);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary: ");
		salaryLabel.setBounds(60, 180, 140, 30);
		salaryLabel.setFont(Theme.FONT_INPUT);
		panel.add(salaryLabel);
		
		employeeNameTF = new JTextField(employee.getEmployeeName());
		employeeNameTF.setBounds(160, 60, 220, 30);
		employeeNameTF.setFont(Theme.FONT_INPUT);
		panel.add(employeeNameTF);
		
		phoneCodeTF = new JTextField("+880");
		phoneCodeTF.setEnabled(false);
		phoneCodeTF.setBounds(160, 100, 40, 30);
		phoneCodeTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneCodeTF);
		

		phoneNumberTF = new JTextField(employee.getPhoneNumber().substring(4)+"");
		phoneNumberTF.setBounds(200, 100, 180, 30);
		phoneNumberTF.setFont(Theme.FONT_INPUT);
		panel.add(phoneNumberTF);
		
		roleCB = new JComboBox(Employee.roles);
		roleCB.setBounds(160, 140, 160, 30);
		roleCB.setSelectedIndex(employee.getRole().equals("Manager") ? 1 : 0);
		roleCB.setFont(Theme.FONT_INPUT);
		panel.add(roleCB);
		
		salaryTF = new JTextField(employee.getSalary()+"");
		salaryTF.setBounds(160, 180, 220, 30);
		salaryTF.setFont(Theme.FONT_INPUT);
		panel.add(salaryTF);
		
		buttonEdit = new JButton("Edit");
		buttonEdit.setBounds(60, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(180, 220, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonEdit)) {
			try {
				employee.updateEmployee(employeeNameTF.getText(),Integer.parseInt(phoneNumberTF.getText()),roleCB.getSelectedItem().toString(), Double.parseDouble(salaryTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Employee.searchEmployee(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Employee.searchEmployee("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			employee.deleteEmployee();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Employee.searchEmployee(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Employee.searchEmployee("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}