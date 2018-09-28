package activity;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import attr.*;

public class ManageProduct extends JFrame implements ActionListener {
	private JPanel panel;
	ViewProductActivity prev;
	private Product product;
	private JButton buttonBack, buttonEdit, buttonDelete, buttonSell, buttonSubmit;
	private JLabel title, header, productIdLabel, productNameLabel, productQtLabel, productPriceLabel, userIdLabel;
	private JTextField productIdTF, productNameTF, productQtTF, productPriceTF, userIdTF;
	
	public ManageProduct(String pid, ViewProductActivity prev) {
		super("Manage Product");
		
		this.setSize(500,400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.prev = prev;
		
		product = new Product(pid);
		product.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		productIdLabel = new JLabel("Product ID: "+product.getProductId());
		productIdLabel.setBounds(60, 20, 140, 30);
		productIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(productIdLabel);
		
		productNameLabel = new JLabel("Name: ");
		productNameLabel.setBounds(60, 60, 140, 30);
		productNameLabel.setFont(Theme.FONT_INPUT);
		panel.add(productNameLabel);
		
		productPriceLabel = new JLabel("Price: ");
		productPriceLabel.setBounds(60, 100, 140, 30);
		productPriceLabel.setVisible(false);
		productPriceLabel.setFont(Theme.FONT_INPUT);
		panel.add(productPriceLabel);
		
		userIdLabel = new JLabel("CustomerID: ");
		userIdLabel.setBounds(60, 100, 140, 30);
		userIdLabel.setFont(Theme.FONT_INPUT);
		panel.add(userIdLabel);
		
		productQtLabel = new JLabel("Quantity: ");
		productQtLabel.setBounds(60, 140, 140, 30);
		productQtLabel.setFont(Theme.FONT_INPUT);
		panel.add(productQtLabel);
		
		productNameTF = new JTextField(product.getProductName());
		productNameTF.setBounds(180, 60, 220, 30);
		productNameTF.setEnabled(false);
		productNameTF.setFont(Theme.FONT_INPUT);
		panel.add(productNameTF);
		
		userIdTF = new JTextField("");
		userIdTF.setBounds(180, 100, 220, 30);
		userIdTF.setFont(Theme.FONT_INPUT);
		panel.add(userIdTF);
		
		productPriceTF = new JTextField(product.getPrice()+"");
		productPriceTF.setBounds(180, 100, 220, 30);
		productPriceTF.setFont(Theme.FONT_INPUT);
		productPriceTF.setVisible(false);
		panel.add(productPriceTF);
		
		productQtTF = new JTextField("");
		productQtTF.setBounds(180, 140, 220, 30);
		productQtTF.setFont(Theme.FONT_INPUT);
		panel.add(productQtTF);
		
		buttonEdit = new JButton("Edit");
		buttonEdit.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonEdit.setFont(Theme.FONT_BUTTON);
		buttonEdit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonEdit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonEdit.addActionListener(this);
		panel.add(buttonEdit);
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setBounds(180, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSubmit.setFont(Theme.FONT_BUTTON);
		buttonSubmit.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSubmit.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSubmit.setVisible(false);
		buttonSubmit.addActionListener(this);
		panel.add(buttonSubmit);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setBounds(300, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonDelete.setFont(Theme.FONT_BUTTON);
		buttonDelete.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonDelete.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonDelete.addActionListener(this);
		panel.add(buttonDelete);
		
		buttonSell = new JButton("Sell");
		buttonSell.setBounds(60, 180, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonSell.setFont(Theme.FONT_BUTTON);
		buttonSell.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonSell.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonSell.addActionListener(this);
		panel.add(buttonSell);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonSell)) {
			try {
				product.sellProduct(userIdTF.getText().trim(),Integer.parseInt(productQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Product.searchProduct(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Product.searchProduct("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonEdit)) {
			buttonEdit.setVisible(false);
			buttonSubmit.setVisible(true);
			buttonSell.setEnabled(false);
			productQtTF.setText(product.getQuantity()+"");
			productNameTF.setEnabled(true);
			userIdLabel.setVisible(false);
			userIdTF.setVisible(false);
			productPriceLabel.setVisible(true);
			productPriceTF.setVisible(true);
		}
		else if (ae.getSource().equals(buttonSubmit)) {
			try {
				product.updateProduct(productNameTF.getText(),Double.parseDouble(productPriceTF.getText()),Integer.parseInt(productQtTF.getText()));
				if (!prev.keywordTF.getText().trim().isEmpty())
					prev.table.setModel(Product.searchProduct(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
				else
					prev.table.setModel(Product.searchProduct("", "By Name"));
				this.setVisible(false);
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this,"Invalid Input!"); 
			}
		}
		else if (ae.getSource().equals(buttonDelete)) {
			product.deleteProduct();
			if (!prev.keywordTF.getText().trim().isEmpty())
				prev.table.setModel(Product.searchProduct(prev.keywordTF.getText().trim(), prev.byWhatCB.getSelectedItem().toString()));
			else
				prev.table.setModel(Product.searchProduct("", "By Name"));
			this.setVisible(false);
		}
		else {}
	}
}