package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import attr.*;

public class MyProfileActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonEdit, buttonBack;
	private JFrame backActivity;
	private JButton buttonViewCustomer, buttonViewEmployee, buttonAddEmployee;
	private JLabel title, header, usernameLabel, nameLabel, phoneLabel, addressLabel;
	private JLabel roleLabel, salaryLabel;
	public MyProfileActivity(JFrame activity, Customer customer) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(Theme.GUI_WIDTH-150, 80, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Color.WHITE);
		buttonBack.setForeground(Theme.COLOR_TITLE);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("User ID: "+customer.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: "+customer.getCustomerName());
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: "+customer.getPhoneNumber());
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		addressLabel = new JLabel("Address: "+customer.getAddress());
		addressLabel.setBounds(60, 290, 440, 30);
		addressLabel.setFont(Theme.FONT_REGULAR);
		panel.add(addressLabel);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public MyProfileActivity(JFrame activity, Employee employee) {
		super("My Profile");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		backActivity = activity;
		
		title = new JLabel("My Profile");
		title.setBounds(30, 40, 260,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonEdit = new JButton("Edit Profile");
		buttonEdit.setBounds(Theme.GUI_WIDTH-160, 80, 120, 30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Color.WHITE);
		buttonBack.setForeground(Theme.COLOR_TITLE);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		usernameLabel = new JLabel("User ID: "+employee.getUserId());
		usernameLabel.setBounds(60, 140, 440, 30);
		usernameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(usernameLabel);
		
		nameLabel = new JLabel("Name: "+employee.getEmployeeName());
		nameLabel.setBounds(60, 190, 440, 30);
		nameLabel.setFont(Theme.FONT_REGULAR);
		panel.add(nameLabel);
		
		phoneLabel = new JLabel("Phone No: "+employee.getPhoneNumber());
		phoneLabel.setBounds(60, 240, 440, 30);
		phoneLabel.setFont(Theme.FONT_REGULAR);
		panel.add(phoneLabel);
		
		roleLabel = new JLabel("Role: "+employee.getRole());
		roleLabel.setBounds(60, 290, 440, 30);
		roleLabel.setFont(Theme.FONT_REGULAR);
		panel.add(roleLabel);
		
		salaryLabel = new JLabel("Salary: "+employee.getSalary());
		salaryLabel.setBounds(60, 340, 440, 30);
		salaryLabel.setFont(Theme.FONT_REGULAR);
		panel.add(salaryLabel);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			backActivity.setVisible(true);
		}
		else {}
	}
}