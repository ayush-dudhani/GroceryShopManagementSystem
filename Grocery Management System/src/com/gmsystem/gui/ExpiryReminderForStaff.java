package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.gmsystem.dbrepo.CRUDRepository;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpiryReminderForStaff {

	private JFrame frame;
	private JTable table;
	private CRUDRepository crudRepo;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpiryReminderForStaff window = new ExpiryReminderForStaff();
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
	public ExpiryReminderForStaff() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1007, 763);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblReminder = new JLabel("REMINDER");
		lblReminder.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblReminder.setHorizontalAlignment(SwingConstants.CENTER);
		lblReminder.setBounds(292, 47, 302, 45);
		frame.getContentPane().add(lblReminder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 173, 805, 513);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblList = new JLabel("Following are the list of items which are going to expire soon!");
		lblList.setHorizontalAlignment(SwingConstants.CENTER);
		lblList.setForeground(Color.RED);
		lblList.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblList.setBounds(231, 115, 479, 31);
		frame.getContentPane().add(lblList);
		
		JLabel lblAttention = new JLabel("Attention Needed !");
		lblAttention.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAttention.setForeground(Color.RED);
		lblAttention.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttention.setBounds(358, 86, 176, 22);
		frame.getContentPane().add(lblAttention);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrameStaff mf = new MenuFrameStaff();
				mf.main(null);
				frame.dispose();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(95, 63, 121, 29);
		frame.getContentPane().add(btnNewButton);
		
		loadTable();
	}
	
	private void loadTable() {
		ResultSet rs = crudRepo.expiryReminder();
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}

}
