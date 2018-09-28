package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import attr.*;

public class CustomerActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JButton buttonLogout, buttonProfile, buttonViewProduct, buttonMyProduct;
	private JLabel title, header;
	public CustomerActivity(String userId) {
		super("Dashboard - Customer");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		customer = new Customer(userId);
		customer.fetch();
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 40, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Color.WHITE);
		buttonLogout.setForeground(Theme.COLOR_TITLE);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		
		buttonViewProduct = new JButton("View Product");
		buttonViewProduct.setBounds(60, 160, 200, 30);
		buttonViewProduct.setFont(Theme.FONT_BUTTON);
		buttonViewProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewProduct.addActionListener(this);
		panel.add(buttonViewProduct);
		
		buttonMyProduct = new JButton("Purchase History");
		buttonMyProduct.setBounds(60, 190, 200, 30);
		buttonMyProduct.setFont(Theme.FONT_BUTTON);
		buttonMyProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonMyProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonMyProduct.addActionListener(this);
		panel.add(buttonMyProduct);
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewProduct)) {
			this.setVisible(false);
			new ViewProductActivity(this, customer).setVisible(true);
		}
		else if (ae.getSource().equals(buttonMyProduct)) {
			this.setVisible(false);
			new MyProductActivity(this, customer).setVisible(true);
		}
		else {}
	}
}