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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		frame.setBounds(100, 100, 1191, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.setFont(new Font("Arial", Font.BOLD, 20));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrame sd = new SearchFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnSearch.setBounds(440, 171, 308, 42);
		frame.getContentPane().add(btnSearch);
		
		JButton btnExpiryReminder = new JButton("EXPIRY REMINDER");
		btnExpiryReminder.setFont(new Font("Arial", Font.BOLD, 20));
		btnExpiryReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExpiryReminder xr = new ExpiryReminder();
				xr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnExpiryReminder.setBounds(440, 366, 308, 42);
		frame.getContentPane().add(btnExpiryReminder);
		
		JButton btnQuantityReminder = new JButton("QUANTITY REMINDER");
		btnQuantityReminder.setFont(new Font("Arial", Font.BOLD, 20));
		btnQuantityReminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuantityReminder qr = new QuantityReminder();
				qr.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnQuantityReminder.setBounds(440, 428, 308, 42);
		frame.getContentPane().add(btnQuantityReminder);
		
		JButton btnStockDetails = new JButton("STOCK DETAILS");
		btnStockDetails.setFont(new Font("Arial", Font.BOLD, 20));
		btnStockDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockDetails sd = new StockDetails();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnStockDetails.setBounds(440, 235, 308, 42);
		frame.getContentPane().add(btnStockDetails);
		
		JButton btnSalesRecord = new JButton("SALES RECORD");
		btnSalesRecord.setFont(new Font("Arial", Font.BOLD, 20));
		btnSalesRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalesRecordFrame sr = new SalesRecordFrame();
				sr.main(null);
				frame.dispose();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnSalesRecord.setBounds(440, 300, 308, 42);
		frame.getContentPane().add(btnSalesRecord);
		
		JButton btnChangePass = new JButton("CHANGE PASSWORD");
		btnChangePass.setFont(new Font("Arial", Font.BOLD, 20));
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePasswordFrame sd = new ChangePasswordFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnChangePass.setBounds(440, 499, 308, 42);
		frame.getContentPane().add(btnChangePass);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Arial", Font.BOLD, 20));
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
		btnLogOut.setBounds(440, 565, 308, 42);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.setFont(new Font("Arial", Font.BOLD, 20));
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddItemFrame sd = new AddItemFrame();
				sd.main(null);
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.dispose();
			}
		});
		btnAddItem.setBounds(440, 106, 308, 42);
		frame.getContentPane().add(btnAddItem);
		
		JLabel lblWelcomeManager = new JLabel("Welcome Manager !");
		lblWelcomeManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeManager.setForeground(Color.RED);
		lblWelcomeManager.setFont(new Font("Arial", Font.BOLD, 30));
		lblWelcomeManager.setBounds(440, 29, 308, 42);
		frame.getContentPane().add(lblWelcomeManager);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\blurred-background-supermarket-products-shelf-can-be-use-as-background_35652-1850.png"));
		lblNewLabel.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel);
	}
}
