package com.gmsystem.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.gmsystem.dbrepo.CRUDRepository;
import com.gmsystem.entity.login;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class ChangePasswordFrame {

	private JFrame frame;
	private JPasswordField passOld;
	private JPasswordField passNew;
	private JTextField txtNewPass;
	private MainFrame mf; //to use toString function written there
	/**
	 * Launch the application.
	 */
	private CRUDRepository crudRepo;
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordFrame window = new ChangePasswordFrame();
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
	public ChangePasswordFrame() {
		crudRepo = new CRUDRepository();
		mf = new MainFrame();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1192, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePass = new JLabel("Change Password");
		lblChangePass.setForeground(Color.RED);
		lblChangePass.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePass.setFont(new Font("Arial", Font.BOLD, 24));
		lblChangePass.setBounds(643, 67, 329, 49);
		frame.getContentPane().add(lblChangePass);
		
		JLabel lblCurrentPassword = new JLabel("Current Password :");
		lblCurrentPassword.setForeground(new Color(255, 0, 0));
		lblCurrentPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setBounds(564, 297, 208, 49);
		frame.getContentPane().add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setForeground(new Color(255, 0, 0));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewPassword.setBounds(564, 386, 208, 49);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setForeground(new Color(255, 0, 0));
		lblConfirmPassword.setBackground(new Color(244, 164, 96));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblConfirmPassword.setBounds(564, 476, 208, 49);
		frame.getContentPane().add(lblConfirmPassword);
		
		passOld = new JPasswordField();
		passOld.setBounds(822, 307, 221, 33);
		frame.getContentPane().add(passOld);
		
		passNew = new JPasswordField();
		passNew.setBounds(822, 396, 221, 33);
		frame.getContentPane().add(passNew);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(822, 486, 221, 33);
		frame.getContentPane().add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setForeground(new Color(0, 0, 0));
		btnConfirm.setBackground(new Color(255, 0, 0));
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 15));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass("Manager");
			}
		});
		btnConfirm.setBounds(898, 579, 145, 49);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblManager = new JLabel("MANAGER");
		lblManager.setFont(new Font("Arial", Font.BOLD, 24));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(598, 47, 413, 21);
		frame.getContentPane().add(lblManager);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setFont(new Font("Arial", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setBounds(647, 579, 145, 49);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\undraw_Forgot_password_re_hxwm (1).png"));
		lblNewLabel.setBounds(0, 0, 1191, 792);
		frame.getContentPane().add(lblNewLabel);
	}
	
	private void ChangePass(String str) {
		char[] oldPass = passOld.getPassword();
		char[] newPass = passNew.getPassword();
		String newPassConfirm = txtNewPass.getText();
		
		if(crudRepo.getLogin(str, mf.toString(oldPass)) != null){
			if(mf.toString(newPass).isEmpty()!=true && newPassConfirm.isEmpty()!=true && mf.toString(oldPass).isEmpty()!=true) {
			if(mf.toString(newPass).equals(newPassConfirm)) {
				int input = JOptionPane.showConfirmDialog(frame, "Are You Sure ?", "Confirmation",JOptionPane.OK_CANCEL_OPTION);
				if(input == 0) {
				login p = new login(str, newPassConfirm);
				String result = crudRepo.changePassword(p);
				JOptionPane.showMessageDialog(null, result);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Password doesn't match !");
			}
		}
			else {
				JOptionPane.showMessageDialog(null,"One or More fields are empty !");
			}
			}
		
		else {
			JOptionPane.showMessageDialog(null, "Invalid Password !");
		}
		
	}
}
