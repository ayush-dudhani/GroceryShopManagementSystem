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
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChangePasswordFrameForStaff {

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
					ChangePasswordFrameForStaff window = new ChangePasswordFrameForStaff();
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
	public ChangePasswordFrameForStaff() {
		crudRepo = new CRUDRepository();
		mf = new MainFrame();
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
		
		JLabel lblChangePass = new JLabel("Change Password");
		lblChangePass.setForeground(Color.RED);
		lblChangePass.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePass.setFont(new Font("Arial", Font.BOLD, 24));
		lblChangePass.setBounds(615, 65, 399, 49);
		frame.getContentPane().add(lblChangePass);
		
		JLabel lblCurrentPassword = new JLabel("Current Password :");
		lblCurrentPassword.setForeground(new Color(255, 0, 0));
		lblCurrentPassword.setBackground(new Color(255, 0, 0));
		lblCurrentPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentPassword.setBounds(584, 320, 200, 49);
		frame.getContentPane().add(lblCurrentPassword);
		
		JLabel lblNewPassword = new JLabel("New Password :");
		lblNewPassword.setForeground(new Color(255, 0, 0));
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewPassword.setBounds(584, 413, 200, 49);
		frame.getContentPane().add(lblNewPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password :");
		lblConfirmPassword.setForeground(new Color(255, 0, 0));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 20));
		lblConfirmPassword.setBounds(584, 508, 200, 49);
		frame.getContentPane().add(lblConfirmPassword);
		
		passOld = new JPasswordField();
		passOld.setBounds(848, 329, 221, 33);
		frame.getContentPane().add(passOld);
		
		passNew = new JPasswordField();
		passNew.setBounds(848, 422, 221, 33);
		frame.getContentPane().add(passNew);
		
		txtNewPass = new JTextField();
		txtNewPass.setBounds(848, 517, 221, 33);
		frame.getContentPane().add(txtNewPass);
		txtNewPass.setColumns(10);
		
		JButton btnConfirm = new JButton("CONFIRM");
		btnConfirm.setFont(new Font("Arial", Font.BOLD, 16));
		btnConfirm.setBackground(new Color(255, 0, 0));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass("Staff");
			}
		});
		btnConfirm.setBounds(869, 593, 145, 49);
		frame.getContentPane().add(btnConfirm);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBackground(new Color(255, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrameStaff mf = new MenuFrameStaff();
				mf.main(null);
				frame.setVisible(false);
				frame.dispose();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnBack.setBounds(653, 593, 145, 49);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("STAFF");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(726, 33, 158, 41);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dudha\\Downloads\\undraw_Forgot_password_re_hxwm (1).png"));
		lblNewLabel_1.setBounds(0, -12, 1191, 802);
		frame.getContentPane().add(lblNewLabel_1);
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
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
