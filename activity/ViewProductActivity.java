package activity;

import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import attr.*;

public class ViewProductActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Customer customer;
	private JFrame activity;
	private Employee employee;
	private JScrollPane frame;
	JComboBox byWhatCB;
	JTable table;
	private JButton buttonLogout, buttonBack, buttonCheck, buttonAddProduct;
	private JLabel title, header, keywordLabel;
	JTextField keywordTF;
	public ViewProductActivity(JFrame prev, Customer customer) {
		super("View Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.customer = customer;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("View Product");
		title.setBounds(30, 40, 300,75);
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
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Product.searchProduct("", "By Name"));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public ViewProductActivity(JFrame prev, Employee employee) {
		super("View Product");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee = employee;
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("View Product");
		title.setBounds(30, 40, 300,75);
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
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);
		
		buttonAddProduct = new JButton("Add");
		buttonAddProduct.setBounds(Theme.GUI_WIDTH-140, 115, Theme.BUTTON_PRIMARY_WIDTH, 30);
		buttonAddProduct.setFont(Theme.FONT_BUTTON);
		buttonAddProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddProduct.addActionListener(this);
		panel.add(buttonAddProduct);
		
		keywordLabel = new JLabel("Keyword: ");
		keywordLabel.setBounds(60, 140, 140, 30);
		keywordLabel.setFont(Theme.FONT_REGULAR);
		panel.add(keywordLabel);
		
		keywordTF = new JTextField();
		keywordTF.setBounds(160, 140, 240, 30);
		keywordTF.setFont(Theme.FONT_INPUT);
		panel.add(keywordTF);
		
		byWhatCB = new JComboBox(new Object[]{"By ID", "By Name"});
		byWhatCB.setBounds(400, 140, 100,30);
		byWhatCB.setFont(Theme.FONT_INPUT);
		panel.add(byWhatCB);
		
		buttonCheck = new JButton("Search");
		buttonCheck.setBounds(500, 140, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonCheck.setFont(Theme.FONT_BUTTON);
		buttonCheck.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonCheck.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonCheck.addActionListener(this);
		panel.add(buttonCheck);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(Product.columnNames);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
               jTable_ClickMouseClicked(evt);
            }
		});
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		panel.add(frame);
		
		table.setModel(Product.searchProduct("", "By Name"));
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}
		else if (ae.getSource().equals(buttonCheck)) {
			table.setModel(Product.searchProduct(keywordTF.getText().trim(), byWhatCB.getSelectedItem().toString()));
		}
		else if (ae.getSource().equals(buttonAddProduct)) {
			this.setVisible(false);
			new AddProductActivity(this, employee).setVisible(true);
		}
		else {}
	}
	
	private void jTable_ClickMouseClicked(MouseEvent evt) {                                          
       int index = table.getSelectedRow();

       TableModel model = table.getModel();

       String value1 = model.getValueAt(index, 0).toString();
       
		if (customer!=null) {}
		else if (employee!=null)
			new ManageProduct(value1, this).setVisible(true);
		else {}
    }
}