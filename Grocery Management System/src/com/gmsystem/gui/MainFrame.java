package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.border.TitledBorder;

import com.gmsystem.dbrepo.CRUDRepository;
import com.gmsystem.entity.login;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;

public class MainFrame {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	
	public MainFrame() {
		crudRepo = new CRUDRepository();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public static String toString(char[] a)
    {
        // Creating an object of String class
        String string = String.valueOf(a);
 
        return string;
    }
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1191, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 51));
		panel.setForeground(Color.BLACK);
		panel.setBorder(null);
		panel.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Shop Management System");
		title.setForeground(Color.RED);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(351, 74, 564, 67);
		panel.add(title);
		title.setFont(new Font("Pristina", Font.BOLD, 40));
		
		JComboBox dropdownMenu =  new JComboBox();
		dropdownMenu.setForeground(Color.RED);
		dropdownMenu.setBackground(Color.WHITE);
		dropdownMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdownMenu.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Staff"}));
		dropdownMenu.setBounds(590, 239, 247, 30);
		panel.add(dropdownMenu);
		
		JLabel labelUser = new JLabel("User :");
		labelUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelUser.setBounds(486, 239, 56, 30);
		panel.add(labelUser);
		
		JLabel labelPassword = new JLabel("Password : ");
		labelPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelPassword.setBounds(486, 296, 100, 30);
		panel.add(labelPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = passwordField.getPassword();
				String user = (String) dropdownMenu.getItemAt(dropdownMenu.getSelectedIndex());
				login l = crudRepo.getLogin(user, MainFrame.toString(pass));
				if(MainFrame.toString(pass).isEmpty()){
				     JOptionPane.showMessageDialog(null,"Password Field is empty"); 
				  }
				else {
				if(l!=null) {
					if(user.equals("Manager")) {
						MenuFrame mf = new MenuFrame();
						mf.main(null);
						frame.setVisible(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.dispose();
					}
					else {
						MenuFrameStaff mf = new MenuFrameStaff();
						mf.main(null);
						frame.setVisible(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.dispose();
					}
					
					}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Password !"); 
					
				}
				}
				}	
					
					
		});
		btnLogin.setBounds(590, 364, 153, 30);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBackground(Color.WHITE);
		passwordField.setForeground(Color.RED);
		passwordField.setBounds(590, 299, 247, 30);
		panel.add(passwordField);
		
		JCheckBox chkbxShowPass = new JCheckBox("Show Password");
		chkbxShowPass.setFont(new Font("Tahoma", Font.ITALIC, 14));
		chkbxShowPass.setForeground(Color.BLACK);
		chkbxShowPass.setBackground(Color.WHITE);
		chkbxShowPass.setBounds(714, 337, 123, 21);
		panel.add(chkbxShowPass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\undraw_secure_login_pdn4 (1).png"));
		lblNewLabel.setBounds(62, 25, 1033, 712);
		panel.add(lblNewLabel);
		
		chkbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if (chkbxShowPass.isSelected()) {
		      passwordField.setEchoChar((char)0); //password = JPasswordField
		   } else {
		      passwordField.setEchoChar('*');
		   }
		 }
	});
	
	
}}
