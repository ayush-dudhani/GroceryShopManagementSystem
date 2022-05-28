package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.gmsystem.dbrepo.CRUDRepository;
import com.gmsystem.entity.Item;
import com.toedter.calendar.DateUtil;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.util.Calendar;
public class AddItemFrame {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtQuantity;
	private JTextField txtPrice;
	private JDateChooser dateMFG;
	private JDateChooser dateEXP;
	private JComboBox dropdownCategory;

	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemFrame window = new AddItemFrame();
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
	
	public AddItemFrame() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 987, 743);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Item");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(355, 52, 122, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("Item Name : ");
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemName.setBounds(276, 121, 122, 30);
		frame.getContentPane().add(lblItemName);
		
		txtName = new JTextField();
		txtName.setBounds(417, 127, 111, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblItemID = new JLabel("Item ID :");
		lblItemID.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblItemID.setBounds(276, 172, 122, 30);
		frame.getContentPane().add(lblItemID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(417, 178, 111, 19);
		frame.getContentPane().add(txtID);
		
		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQuantity.setBounds(276, 217, 122, 30);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(417, 223, 111, 19);
		frame.getContentPane().add(txtQuantity);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrice.setBounds(276, 269, 122, 30);
		frame.getContentPane().add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(417, 275, 111, 19);
		frame.getContentPane().add(txtPrice);
		
		JLabel lblMfgDate = new JLabel("MFG Date :");
		lblMfgDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfgDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMfgDate.setBounds(276, 314, 122, 30);
		frame.getContentPane().add(lblMfgDate);
		
		JLabel lbleExpDate = new JLabel("EXP Date :");
		lbleExpDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbleExpDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbleExpDate.setBounds(276, 366, 122, 30);
		frame.getContentPane().add(lbleExpDate);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCategory.setBounds(276, 416, 122, 30);
		frame.getContentPane().add(lblCategory);
		
		JDateChooser dateMFG = new JDateChooser();
		dateMFG.setDateFormatString("yyyy-MM-d");
		dateMFG.setBounds(417, 324, 111, 19);
		frame.getContentPane().add(dateMFG);
		
		JDateChooser dateEXP = new JDateChooser();
		dateEXP.setDateFormatString("yyyy-MM-d");
		dateEXP.setBounds(417, 366, 111, 19);
		frame.getContentPane().add(dateEXP);
		
		JComboBox dropdownCategory = new JComboBox();
		dropdownCategory.setModel(new DefaultComboBoxModel(new String[] {"Dairy", "Cereals", "Cleaners", "Spices", "Snacks", "Others"}));
		dropdownCategory.setBounds(417, 421, 111, 21);
		frame.getContentPane().add(dropdownCategory);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveItem();
			}
		});
		btnAdd.setBounds(448, 481, 85, 21);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		btnBack.setBounds(320, 481, 85, 21);
		frame.getContentPane().add(btnBack);
	}
	
	
	private void saveItem() {
		String item_name = txtName.getText();
		String item_idStr = txtID.getText();
		int item_id = Integer.parseInt(item_idStr);
		String QuantityStr = txtQuantity.getText();
		int Quantity = Integer.parseInt(QuantityStr);
		String PriceStr = txtPrice.getText();
		float Price = Float.parseFloat(PriceStr);
		dateMFG.setCalendar(Calendar.getInstance());
		dateEXP.setCalendar(Calendar.getInstance());
		String mfg=null;
		String exp=null;
		if(dateMFG.getDate()!=null) {
			mfg = new String ("" + dateMFG.getDate());
		}
		if(dateEXP.getDate()!=null) {
			exp = new String ("" + dateEXP.getDate());
		}
		String category = (String) dropdownCategory.getItemAt(dropdownCategory.getSelectedIndex());
		
		Item i  = new Item (item_id, item_name, Quantity, Price, mfg,exp, category);
		
		String str = crudRepo.saveItemtoDB(i);
		
		JOptionPane.showMessageDialog(null, str);
		
	}
	
	

}
