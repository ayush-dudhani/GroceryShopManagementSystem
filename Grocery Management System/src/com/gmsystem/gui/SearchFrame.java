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
import javax.swing.ImageIcon;

public class SearchFrame {

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
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame window = new SearchFrame();
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
	public SearchFrame() {
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
		
		lblNewLabel_2 = new JLabel("MANAGER");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(1057, 10, 110, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("SEARCH");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(436, 10, 228, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textName = new JTextField();
		textName.setToolTipText("SEARCH");
		textName.setBounds(395, 66, 348, 27);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		JButton lblSearch = new JButton("SEARCH");
		lblSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchItem();
			}
		});
		lblSearch.setFont(new Font("Arial", Font.BOLD, 16));
		lblSearch.setBounds(753, 66, 141, 27);
		frame.getContentPane().add(lblSearch);
		
		JLabel lblNameOfItem = new JLabel("NAME OF ITEM :");
		lblNameOfItem.setFont(new Font("Arial", Font.BOLD, 16));
		lblNameOfItem.setForeground(new Color(0, 0, 0));
		lblNameOfItem.setBounds(205, 66, 154, 26);
		frame.getContentPane().add(lblNameOfItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(143, 168, 915, 478);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setForeground(Color.RED);
		textField.setEditable(false);
		textField.setBounds(395, 113, 348, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setBounds(48, 28, 127, 44);
		frame.getContentPane().add(btnBack);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\blurred-background-supermarket-products-shelf-can-be-use-as-background_35652-1850.png"));
		lblNewLabel_1.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel_1);
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
