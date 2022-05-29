package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.gmsystem.dbrepo.CRUDRepository;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesRecordFrame {

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
					SalesRecordFrame window = new SalesRecordFrame();
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
	public SalesRecordFrame() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1007, 767);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSalesRecord = new JLabel("SALES RECORD ");
		lblSalesRecord.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblSalesRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalesRecord.setBounds(323, 36, 359, 60);
		frame.getContentPane().add(lblSalesRecord);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 129, 847, 555);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.dispose();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(92, 51, 156, 30);
		frame.getContentPane().add(btnBack);
		
		loadTable();
	}
	
	private void loadTable() {
		ResultSet resultset = crudRepo.getAllDataSales();
		table.setModel(DbUtils.resultSetToTableModel(resultset));
		
	}

}
