package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

import com.gmsystem.dbrepo.CRUDRepository;
import com.gmsystem.entity.Item;
import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchFrameForStaff {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	private JTable table;
	private JTextField textField;
	private JButton btnBack;
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrameForStaff window = new SearchFrameForStaff();
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
	public SearchFrameForStaff() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1098, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(446, 10, 133, 17);
		frame.getContentPane().add(lblNewLabel);
		
		textName = new JTextField();
		textName.setToolTipText("SEARCH");
		textName.setBounds(395, 67, 348, 26);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JButton lblSearch = new JButton("Search");
		lblSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchItem();
			}
		});
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSearch.setBounds(753, 66, 99, 26);
		frame.getContentPane().add(lblSearch);
		
		JLabel lblNameOfItem = new JLabel("Name Of Item :");
		lblNameOfItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNameOfItem.setForeground(new Color(0, 0, 0));
		lblNameOfItem.setBounds(205, 66, 114, 26);
		frame.getContentPane().add(lblNameOfItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 168, 792, 295);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.RED);
		textField.setEditable(false);
		textField.setBounds(373, 119, 266, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrameStaff mf = new MenuFrameStaff();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setBounds(69, 28, 106, 26);
		frame.getContentPane().add(btnBack);
	}
	
	
	private void searchItem() {
		String namestr = textName.getText();
		Item it = null;
		it = crudRepo.getitemdata(namestr);
		if(it != null) {
			textField.setText("Item found !!");
			ResultSet rs= crudRepo.showitemdata(namestr);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		else {
			textField.setText("Item Not Found, Check Spellings Please");
		}
	}
}
