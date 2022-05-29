package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.gmsystem.dbrepo.CRUDRepository;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class StockDetailsForStaff {

	private JFrame frame2;
	private JTable table;
	private CRUDRepository crudRepo;
	private JScrollPane scrollPane;
	private JButton btnback;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockDetailsForStaff window = new StockDetailsForStaff();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StockDetailsForStaff() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 977, 752);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 182, 883, 455);
		frame2.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblStockDetails = new JLabel("Stock Details");
		lblStockDetails.setForeground(Color.RED);
		lblStockDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStockDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblStockDetails.setBounds(335, 92, 144, 29);
		frame2.getContentPane().add(lblStockDetails);
		
		btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrameStaff mf =new MenuFrameStaff();
				mf.main(null);
				frame2.dispose();
				frame2.setVisible(false);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnback.setBounds(69, 78, 97, 29);
		frame2.getContentPane().add(btnback);
		
		loadTable();
	}
	
	private void loadTable() {
		ResultSet resultset = crudRepo.getAllData();
		table.setModel(DbUtils.resultSetToTableModel(resultset));
		
	}

}
