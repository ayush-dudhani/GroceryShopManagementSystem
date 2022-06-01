package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

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
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(443, 51, 315, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.setFont(new Font("Arial", Font.BOLD, 20));
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemFrameForStaff sd = new AddItemFrameForStaff();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnAddItem.setBounds(473, 122, 259, 51);
		frame.getContentPane().add(btnAddItem);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrameForStaff sd = new SearchFrameForStaff();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnSearch.setBounds(473, 183, 259, 49);
		frame.getContentPane().add(btnSearch);
		
		JButton btnSalesEntry = new JButton("SALES ENTRY");
		btnSalesEntry.setFont(new Font("Arial", Font.BOLD, 20));
		btnSalesEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddSalesEntryFrame asef = new AddSalesEntryFrame();
				asef.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();	
			}
		});
		btnSalesEntry.setBounds(473, 245, 259, 51);
		frame.getContentPane().add(btnSalesEntry);
		
		JButton btnStockDetails = new JButton("STOCK DETAILS");
		btnStockDetails.setFont(new Font("Arial", Font.BOLD, 20));
		btnStockDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockDetailsForStaff sd = new StockDetailsForStaff();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnStockDetails.setBounds(473, 306, 259, 48);
		frame.getContentPane().add(btnStockDetails);
		
		JButton btnExpiryReminder = new JButton("EXPIRY REMINDER");
		btnExpiryReminder.setFont(new Font("Arial", Font.BOLD, 20));
		btnExpiryReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpiryReminderForStaff xr = new ExpiryReminderForStaff();
				xr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnExpiryReminder.setBounds(473, 364, 259, 46);
		frame.getContentPane().add(btnExpiryReminder);
		
		JButton btnQuantityReminder = new JButton("QUANTITY REMINDER");
		btnQuantityReminder.setFont(new Font("Arial", Font.BOLD, 20));
		btnQuantityReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuantityReminderForStaff qr = new QuantityReminderForStaff();
				qr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnQuantityReminder.setBounds(473, 420, 259, 48);
		frame.getContentPane().add(btnQuantityReminder);
		
		JButton btnChangePassword = new JButton("CHANGE PASSWORD");
		btnChangePassword.setFont(new Font("Arial", Font.BOLD, 20));
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordFrameForStaff sd = new ChangePasswordFrameForStaff();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnChangePassword.setBounds(473, 478, 259, 49);
		frame.getContentPane().add(btnChangePassword);
		
		JButton btnExit = new JButton("LOG OUT");
		btnExit.setFont(new Font("Arial", Font.BOLD, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(frame, "Are you sure to Log Out Staff ?","Confirmation",JOptionPane.OK_CANCEL_OPTION);
				if(input==0) {
					MainFrame sd = new MainFrame();
					sd.main(null);
					frame.setVisible(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.dispose();
				}
			}
		});
		btnExit.setBounds(473, 539, 259, 49);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\blurred-background-supermarket-products-shelf-can-be-use-as-background_35652-1850.png"));
		lblNewLabel_1.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
