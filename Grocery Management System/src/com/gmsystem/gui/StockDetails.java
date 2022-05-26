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



public class StockDetails {

	private JFrame frame2;
	private JTable table;
	private CRUDRepository crudRepo;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockDetails window = new StockDetails();
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
	public StockDetails() {
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
		
		loadTable();
	}
	
	private void loadTable() {
		ResultSet resultset = crudRepo.getAllData();
		table.setModel(DbUtils.resultSetToTableModel(resultset));
		
	}

}
