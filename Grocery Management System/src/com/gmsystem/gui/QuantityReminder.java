package com.gmsystem.gui;

import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;

import com.gmsystem.dbrepo.CRUDRepository;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuantityReminder {

	private JFrame frame;
	private CRUDRepository crudRepo;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuantityReminder window = new QuantityReminder();
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
	public QuantityReminder() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1008, 764);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReminder = new JLabel("REMINDER");
		lblReminder.setHorizontalAlignment(SwingConstants.CENTER);
		lblReminder.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblReminder.setBounds(304, 46, 302, 45);
		frame.getContentPane().add(lblReminder);
		
		JLabel lblAttention = new JLabel("Attention Needed !");
		lblAttention.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttention.setForeground(Color.RED);
		lblAttention.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAttention.setBounds(374, 84, 176, 22);
		frame.getContentPane().add(lblAttention);
		
		JLabel lblList = new JLabel("Following are the list of items which are less in quantity (less than 5)!");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.RED);
		lblList.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblList.setBounds(231, 109, 479, 31);
		frame.getContentPane().add(lblList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 170, 856, 527);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MenuFrame mf = new MenuFrame();
			mf.main(null);
			frame.dispose();
			frame.setVisible(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(83, 46, 147, 31);
		frame.getContentPane().add(btnNewButton);
		
		loadTable();
	}
	
	private void loadTable() {
		ResultSet rs = crudRepo.QuantityReminder();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}
}
