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
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class MainFrame {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	private String currentUser;
	
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
		frame.setBounds(100, 100, 1111, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Shop Management System");
		title.setFont(new Font("Times New Roman", Font.BOLD, 17));
		title.setBounds(407, 10, 206, 51);
		frame.getContentPane().add(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 102, 51));
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Log In", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(102, 204, 255)));
		panel.setBounds(218, 81, 637, 376);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JComboBox dropdownMenu = new JComboBox();
		dropdownMenu.setBackground(new Color(102, 204, 255));
		dropdownMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dropdownMenu.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Staff"}));
		dropdownMenu.setBounds(285, 92, 247, 30);
		panel.add(dropdownMenu);
		
		JLabel labelUser = new JLabel("User :");
		labelUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelUser.setBounds(184, 92, 56, 30);
		panel.add(labelUser);
		
		JLabel labelPassword = new JLabel("Password : ");
		labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPassword.setBounds(184, 150, 91, 30);
		panel.add(labelPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] pass = passwordField.getPassword();
				String user = (String) dropdownMenu.getItemAt(dropdownMenu.getSelectedIndex());
				login l = crudRepo.getLogin(user, MainFrame.toString(pass));
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
				}	
					
					
		});
		btnLogin.setBounds(285, 216, 153, 30);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setForeground(Color.BLACK);
		passwordField.setBounds(285, 153, 247, 30);
		panel.add(passwordField);
		
		JCheckBox chkbxShowPass = new JCheckBox("Show Password");
		chkbxShowPass.setBackground(new Color(204, 102, 51));
		chkbxShowPass.setBounds(435, 189, 135, 21);
		panel.add(chkbxShowPass);
		private void chkbxShowPassActionPerformed(java.awt.event.ActionEvent evt) {  

			   if (lihat.isSelected()) {
			      password.setEchoChar((char)0); //password = JPasswordField
			   } else {
			      password.setEchoChar('*');
			   }
			}
		
	}
	
	
}
