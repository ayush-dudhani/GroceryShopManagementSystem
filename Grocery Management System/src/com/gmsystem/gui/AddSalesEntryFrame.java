package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.gmsystem.dbrepo.CRUDRepository;
import com.gmsystem.entity.Item;
import com.gmsystem.entity.Sales;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddSalesEntryFrame {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtQuantity;
	private JTextField txtTotalAmount;
	private CRUDRepository crudRepo;
	private JTextField txtCategory;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSalesEntryFrame window = new AddSalesEntryFrame();
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
	public AddSalesEntryFrame() {
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
		
		JLabel lblNewLabel = new JLabel("ADD SALES ENTRY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(427, 25, 286, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblItemId = new JLabel("ITEM ID :");
		lblItemId.setForeground(new Color(0, 0, 0));
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblItemId.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemId.setBounds(374, 185, 178, 32);
		frame.getContentPane().add(lblItemId);
		
		JLabel lblItemName = new JLabel("ITEM NAME :");
		lblItemName.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblItemName.setBounds(393, 354, 178, 32);
		frame.getContentPane().add(lblItemName);
		
		JLabel lblQuantitySold = new JLabel("QUANTITY SOLD :");
		lblQuantitySold.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantitySold.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblQuantitySold.setBounds(393, 245, 178, 32);
		frame.getContentPane().add(lblQuantitySold);
		
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT :");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTotalAmount.setBounds(403, 528, 178, 32);
		frame.getContentPane().add(lblTotalAmount);
		
		JLabel lblCategory = new JLabel("CATEGORY :");
		lblCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCategory.setBounds(403, 400, 178, 32);
		frame.getContentPane().add(lblCategory);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrameStaff mfs = new MenuFrameStaff();
				mfs.main(null);
				frame.dispose();
				frame.setVisible(false);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnBack.setBounds(76, 43, 151, 41);
		frame.getContentPane().add(btnBack);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddToSales();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(486, 597, 204, 37);
		frame.getContentPane().add(btnNewButton);
		
		txtID = new JTextField();
		txtID.setBounds(562, 189, 178, 27);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(562, 358, 178, 27);
		frame.getContentPane().add(txtName);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(562, 249, 178, 27);
		frame.getContentPane().add(txtQuantity);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.setEditable(false);
		txtTotalAmount.setColumns(10);
		txtTotalAmount.setBounds(562, 532, 178, 27);
		frame.getContentPane().add(txtTotalAmount);
		
		JLabel lblDate = new JLabel(datemilega());
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDate.setBounds(885, 39, 217, 47);
		frame.getContentPane().add(lblDate);
		
		JButton btnGenerateAmount = new JButton("GENERATE AMOUNT");
		btnGenerateAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=String.valueOf(Integer.parseInt(txtQuantity.getText())*crudRepo.fetchTotalAmount(Integer.parseInt(txtID.getText())));  
				txtTotalAmount.setText(s);
			}
		});
		btnGenerateAmount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnGenerateAmount.setBounds(486, 460, 204, 37);
		frame.getContentPane().add(btnGenerateAmount);
		
		txtCategory = new JTextField();
		txtCategory.setEditable(false);
		txtCategory.setColumns(10);
		txtCategory.setBounds(562, 404, 178, 27);
		frame.getContentPane().add(txtCategory);
		
		JButton btnFind = new JButton("FIND");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtID.getText().isEmpty() || txtQuantity.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "One or More Fields are empty");
				}
				
				else if(crudRepo.getitemdataID(Integer.parseInt(txtID.getText()))==null) {
					JOptionPane.showMessageDialog(frame,"INVALID ID");
				}
				else {
					txtName.setText(crudRepo.Name_De(Integer.parseInt(txtID.getText())));
					txtCategory.setText(crudRepo.Category_De(Integer.parseInt(txtID.getText())));
				}	
			}
		});
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnFind.setBounds(486, 300, 204, 37);
		frame.getContentPane().add(btnFind);
		
		JLabel lblInventory = new JLabel("");
		lblInventory.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblInventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblInventory.setBounds(251, 274, 311, 29);
		frame.getContentPane().add(lblInventory);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\back 2.png"));
		lblNewLabel_1.setBounds(-24, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel_1);
	}
	public String datemilega() {
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	String strDate = dateFormat.format(date);
	return strDate;  
	}
	
	public void AddToSales() {
		int id = Integer.parseInt(txtID.getText());
		int Quan = Integer.parseInt(txtQuantity.getText());
		String name = txtName.getText();
		String category = txtCategory.getText();
		float amt = Float.parseFloat(txtTotalAmount.getText());
		Sales s = new Sales(id,name,Quan,amt,datemilega(),category);
		JOptionPane.showMessageDialog(frame, crudRepo.Salesrecord_insert(s));;

	}
}
