package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuFrameStaff {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrameStaff window = new MenuFrameStaff();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuFrameStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1327, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Staff !");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(487, 73, 173, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(501, 124, 144, 34);
		frame.getContentPane().add(btnAddItem);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(501, 183, 144, 34);
		frame.getContentPane().add(btnSearch);
		
		JButton btnSalesEntry = new JButton("Sales Entry");
		btnSalesEntry.setBounds(501, 245, 144, 34);
		frame.getContentPane().add(btnSalesEntry);
		
		JButton btnStockDetails = new JButton("Stock Details");
		btnStockDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockDetails sd = new StockDetails();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnStockDetails.setBounds(501, 306, 144, 34);
		frame.getContentPane().add(btnStockDetails);
		
		JButton btnExpiryReminder = new JButton("Expiry Reminder");
		btnExpiryReminder.setBounds(501, 364, 144, 34);
		frame.getContentPane().add(btnExpiryReminder);
		
		JButton btnQuantityReminder = new JButton("Quantity Reminder");
		btnQuantityReminder.setBounds(501, 420, 144, 34);
		frame.getContentPane().add(btnQuantityReminder);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(501, 488, 144, 34);
		frame.getContentPane().add(btnChangePassword);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(501, 550, 144, 34);
		frame.getContentPane().add(btnExit);
	}

}
