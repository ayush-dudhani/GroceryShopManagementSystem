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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrame sd = new SearchFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnSearch.setBounds(276, 130, 141, 33);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExpiryReminder = new JButton("Expiry Reminder");
		btnExpiryReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpiryReminder xr = new ExpiryReminder();
				xr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnExpiryReminder.setBounds(276, 187, 141, 33);
		frame.getContentPane().add(btnExpiryReminder);
		
		JButton btnQuantityReminder = new JButton("Quantity Reminder");
		btnQuantityReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuantityReminder qr = new QuantityReminder();
				qr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnQuantityReminder.setBounds(276, 242, 141, 33);
		frame.getContentPane().add(btnQuantityReminder);
		
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
		
		JButton btnSalesRecord = new JButton("Sales Record");
		btnSalesRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalesRecordFrame sr = new SalesRecordFrame();
				sr.main(null);
				frame.dispose();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnSalesRecord.setBounds(276, 352, 141, 33);
		frame.getContentPane().add(btnSalesRecord);
		
		JButton btnChangePass = new JButton("Change Password");
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordFrame sd = new ChangePasswordFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnChangePass.setBounds(276, 405, 141, 33);
		frame.getContentPane().add(btnChangePass);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(frame, "Are you sure to Log Out Manager ?","Confirmation",JOptionPane.OK_CANCEL_OPTION);
				if(input==0) {
					MainFrame sd = new MainFrame();
					sd.main(null);
					frame.setVisible(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.dispose();
				}
			}
		});
		btnLogOut.setBounds(276, 459, 141, 33);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemFrame sd = new AddItemFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnAddItem.setBounds(276, 78, 141, 33);
		frame.getContentPane().add(btnAddItem);
		
		JLabel lblWelcomeManager = new JLabel("Welcome Manager !");
		lblWelcomeManager.setForeground(Color.RED);
		lblWelcomeManager.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWelcomeManager.setBounds(276, 26, 134, 28);
		frame.getContentPane().add(lblWelcomeManager);
	}
}
