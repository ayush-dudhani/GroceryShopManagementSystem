package com.gmsystem.dbrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gmsystem.entity.login;

public class CRUDRepository {
	public login checkLogin(login log) {
		Connection connect = dbConnection.getConnection();
		String sql = "select username,password from login username=?, and password=?";
		try {
			PreparedStatement pStatement = connect.prepareStatement(sql);
			pStatement.setString(1,log.getUsername());
			pStatement.setString(2, log.getPassword());
			pStatement.executeQuery();
			return log;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public login getLogin(String str, String pass) {
		Connection con = dbConnection.getConnection();
		String sql = "select username,password from gmsystem_db.login where username=? and password=?";
		
		PreparedStatement pStatement;
		try {
			pStatement = con.prepareStatement(sql);
			pStatement.setString(1, str);
			pStatement.setString(2, pass);
			ResultSet resultset = pStatement.executeQuery();
			login l = null;
			
			if(resultset.next() == true) {
				String selectedUser = resultset.getString(1);
				String selectedPassword = resultset.getString(2);
				l = new login(selectedUser, selectedPassword);
			}
			return l;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ResultSet getAllData() {
		Connection con = dbConnection.getConnection();
		String sql = "select * from gmsystem_db.itemdata";
		
		try {
			PreparedStatement pstatement = con.prepareStatement(sql);
			ResultSet result = pstatement.executeQuery();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
}
