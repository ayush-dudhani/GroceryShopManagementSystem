package com.gmsystem.dbrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gmsystem.entity.login;

public class CRUDRepository {
	public void saveLogin(login log) {
		Connection connect = dbConnection.getConnection();
		String sql = "insert into login (username, password) values (?,?)";
		try {
			PreparedStatement pStatement = connect.prepareStatement(sql);
			pStatement.setString(1,log.getUsername());
			pStatement.setString(2, log.getPassword());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
