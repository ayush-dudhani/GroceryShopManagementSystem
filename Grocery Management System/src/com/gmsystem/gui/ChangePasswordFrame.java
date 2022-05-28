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
		frame.setBounds(100, 100, 993, 747);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChangePass = new JLabel("Change Password");
		lblChangePass.setForeground(Color.RED);
		lblChangePass.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChangePass.setBounds(276, 63, 329, 49);
		frame.getContentPane().add(lblChangePass);
		
		JLabel lblCurrentPassword = new JLabel("Current Password :");
		lblCurrentPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setBounds(192, 163, 174, 49);
		frame.getContentPane().add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewPassword.setBounds(192, 259, 174, 49);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblConfirmPassword.setBounds(192, 360, 174, 49);
		frame.getContentPane().add(lblConfirmPassword);
		
		passOld = new JPasswordField();
		passOld.setBounds(397, 172, 221, 33);
		frame.getContentPane().add(passOld);
		
		passNew = new JPasswordField();
		passNew.setBounds(397, 268, 221, 33);
		frame.getContentPane().add(passNew);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(397, 369, 221, 33);
		frame.getContentPane().add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass("Manager");
			}
		});
		btnConfirm.setBounds(473, 454, 145, 49);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblManager = new JLabel("MANAGER");
		lblManager.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblManager.setHorizontalAlignment(SwingConstants.CENTER);
		lblManager.setBounds(359, 46, 174, 21);
		frame.getContentPane().add(lblManager);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame mf = new MenuFrame();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setBounds(247, 454, 145, 49);
		frame.getContentPane().add(btnBack);
	}
	
	private void ChangePass(String str) {
		char[] oldPass = passOld.getPassword();
		char[] newPass = passNew.getPassword();
		String newPassConfirm = txtNewPass.getText();
		
		if(crudRepo.getLogin(str, mf.toString(oldPass)) != null){
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
			JOptionPane.showMessageDialog(null, "Invalid Password !");
		}
		
	}
}
