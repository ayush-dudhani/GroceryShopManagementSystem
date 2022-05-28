package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.gmsystem.dbrepo.CRUDRepository;

import java.awt.Font;
import java.awt.Color;

public class MenuFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame window = new MenuFrame();
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
	public MenuFrame() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrame sd = new SearchFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(276, 130, 141, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExpiryReminder = new JButton("Expiry Reminder");
		btnExpiryReminder.setBounds(276, 187, 141, 33);
		frame.getContentPane().add(btnExpiryReminder);
		
		JButton btnNewButton_1_1 = new JButton("Quantity Reminder");
		btnNewButton_1_1.setBounds(276, 242, 141, 33);
		frame.getContentPane().add(btnNewButton_1_1);
		
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
		btnStockDetails.setBounds(276, 296, 141, 33);
		frame.getContentPane().add(btnStockDetails);
		
		JButton btnNewButton_1_2_1 = new JButton("Sales Record");
		btnNewButton_1_2_1.setBounds(276, 352, 141, 33);
		frame.getContentPane().add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_1_1 = new JButton("Change Password");
		btnNewButton_1_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordFrame sd = new ChangePasswordFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnNewButton_1_2_1_1.setBounds(276, 405, 141, 33);
		frame.getContentPane().add(btnNewButton_1_2_1_1);
		
		JButton btnNewButton_1_2_1_1_1 = new JButton("LOG OUT");
		btnNewButton_1_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(frame, "Are you sure to Log Out Manager ?","Confirmation",JOptionPane.OK_CANCEL_OPTION,JOptionPane.ABORT);
				if(input==1) {
					MainFrame sd = new MainFrame();
					sd.main(null);
					frame.setVisible(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.dispose();
				}
			}
		});
		btnNewButton_1_2_1_1_1.setBounds(276, 459, 141, 33);
		frame.getContentPane().add(btnNewButton_1_2_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Add Item");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemFrame sd = new AddItemFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(276, 78, 141, 33);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Welcome Manager !");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(276, 26, 134, 28);
		frame.getContentPane().add(lblNewLabel);
	}
}
