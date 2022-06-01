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
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.Color;
import javax.swing.ImageIcon;
public class AddItemFrame {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtID;
	private JTextField txtQuantity;
	private JTextField txtPrice;

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
		frame.setBounds(100, 100, 1191, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD ITEM");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 33));
		lblNewLabel.setBounds(468, 51, 210, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblItemName = new JLabel("ITEM NAME :");
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblItemName.setBounds(385, 142, 122, 30);
		frame.getContentPane().add(lblItemName);
		
		txtName = new JTextField();
		txtName.setBounds(566, 146, 170, 27);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblItemID = new JLabel("ITEM ID :");
		lblItemID.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemID.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblItemID.setBounds(385, 201, 122, 30);
		frame.getContentPane().add(lblItemID);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(566, 205, 170, 27);
		frame.getContentPane().add(txtID);
		
		JLabel lblQuantity = new JLabel("QUANTITY :");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuantity.setBounds(385, 254, 122, 30);
		frame.getContentPane().add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(566, 258, 170, 27);
		frame.getContentPane().add(txtQuantity);
		
		JLabel lblPrice = new JLabel("PRICE :");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPrice.setBounds(385, 316, 122, 30);
		frame.getContentPane().add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(566, 320, 170, 27);
		frame.getContentPane().add(txtPrice);
		
		JDateChooser thisMFG = new JDateChooser();
		thisMFG.setBounds(566, 377, 170, 27);
		frame.getContentPane().add(thisMFG);
		
		JDateChooser thisEXP = new JDateChooser();
		thisEXP.setBounds(566, 438, 170, 27);
		frame.getContentPane().add(thisEXP);
		
		JLabel lblMfgDate = new JLabel("MFG DATE :");
		lblMfgDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblMfgDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMfgDate.setBounds(385, 377, 122, 30);
		frame.getContentPane().add(lblMfgDate);
		
		JLabel lbleExpDate = new JLabel("EXP DATE :");
		lbleExpDate.setHorizontalAlignment(SwingConstants.CENTER);
		lbleExpDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbleExpDate.setBounds(385, 435, 122, 30);
		frame.getContentPane().add(lbleExpDate);
		
		JLabel lblCategory = new JLabel("CATEGORY :");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCategory.setBounds(385, 504, 122, 30);
		frame.getContentPane().add(lblCategory);
		
		JComboBox dropdownCategory = new JComboBox();
		dropdownCategory.setFont(new Font("Tahoma", Font.BOLD, 16));
		dropdownCategory.setModel(new DefaultComboBoxModel(new String[] {"Dairy", "Cereals", "Cleaners", "Spices", "Snacks", "Others"}));
		dropdownCategory.setBounds(566, 506, 170, 27);
		frame.getContentPane().add(dropdownCategory);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String item_name = txtName.getText();
					String item_idStr = txtID.getText();
					int item_id = Integer.parseInt(item_idStr);
					String QuantityStr = txtQuantity.getText();
					int Quantity = Integer.parseInt(QuantityStr);
					String PriceStr = txtPrice.getText();
					float Price = Float.parseFloat(PriceStr);
//					String mfg = mfgDate.getText();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        String mfg = sdf.format(thisMFG.getDate());
					String exp = sdf.format(thisEXP.getDate());
					
					String category = (String) dropdownCategory.getItemAt(dropdownCategory.getSelectedIndex());
					
					Item i  = new Item (item_id, item_name, Quantity, Price, mfg,exp, category);
					
					String str = crudRepo.saveItemtoDB(i);
					
					JOptionPane.showMessageDialog(null, str);
					
				
			}
		});
		btnAdd.setBounds(593, 597, 143, 56);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		btnBack.setBounds(385, 597, 156, 56);
		frame.getContentPane().add(btnBack);
		
		JLabel lblunique = new JLabel("Item ID must be unique");
		lblunique.setHorizontalAlignment(SwingConstants.LEFT);
		lblunique.setForeground(new Color(255, 0, 0));
		lblunique.setBounds(621, 175, 143, 13);
		frame.getContentPane().add(lblunique);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\updatd background.png"));
		lblNewLabel_1.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
	}
}
