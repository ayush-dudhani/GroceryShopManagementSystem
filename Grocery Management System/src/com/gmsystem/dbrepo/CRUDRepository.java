package com.gmsystem.dbrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gmsystem.entity.Item;
import com.gmsystem.entity.login;
import com.mysql.cj.protocol.Resultset;

public class CRUDRepository {
	
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
	
	public Item getitemdata(String item_name)
	{
		 Connection connection=dbConnection.getConnection();
		 String sql="select * from gmsystem_db.itemdata where itemdata.item_name=?";
		 try {
			 PreparedStatement pStatement=connection.prepareStatement(sql);
			 pStatement.setString(1,item_name);
			 ResultSet resultSet=pStatement.executeQuery();
			 Item items=null;
			 if(resultSet.next()==true)
			 {   
				 int item_id =resultSet.getInt(2);
				 String selectedName = resultSet.getString(3);
				 int quantity=resultSet.getInt(4);
				 float prices=resultSet.getFloat(5);
				 String manuf_date=resultSet.getString(6);
				 String category=resultSet.getString(7);
                 String exp_date=resultSet.getString(8);
                                  
                 items=new Item(item_id,selectedName,quantity,prices,manuf_date,exp_date,category);
                                 
			 }
                       return items;
                       
		 }
               catch(SQLException e){
               e.printStackTrace();
               return null;} 
	}
	
	public ResultSet showitemdata(String item_name)
	{
		 Connection connection=dbConnection.getConnection();
		 String sql="select * from gmsystem_db.itemdata where itemdata.item_name=?";
		 try {
			 PreparedStatement pStatement=connection.prepareStatement(sql);
			 pStatement.setString(1,item_name);
			 ResultSet resultSet=pStatement.executeQuery();
                       return resultSet;
                       
		 }
               catch(SQLException e){
               e.printStackTrace();
               return null;
               } 
	}
	 
	
	public String saveitemdata(Item items)
	{
		Connection connection=dbConnection.getConnection();
		
		String sql="insert into itemdata (sr_no,item_id,item_name,quantity,price,manuf_date,category,exp_date)values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement=  connection.prepareStatement(sql);
		pStatement.setInt(1, items.getSr_no());
		pStatement.setInt(2,items.getItem_id());
		pStatement.setString(3, items.getItem_name());
		pStatement.setInt(4, items.getQuantity());
		pStatement.setFloat(5, items.getPrice());
		pStatement.setString(6, items.getManu_date());
		pStatement.setString(7, items.getCategory());
		pStatement.setString(8,items.getExp_date());
		
		int i=pStatement.executeUpdate();
		System.out.println(i+" item record inserted...");
		return "Item added to Inventory SuccessFully !!";
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed to add item to Inventory...";
		}
		
	}
	
	public String saveItemtoDB(Item it) {
		Connection connection = dbConnection.getConnection();

		String sql = "insert into gmsystem_db.item_data (item_id,item_name,quantity,price,manuf_date,exp_date,category) values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, it.getItem_id());
			pStatement.setString(2, it.getItem_name());
			pStatement.setInt(3, it.getQuantity());
			pStatement.setFloat(4, it.getPrice());
			pStatement.setString(5, it.getManu_date());
			pStatement.setString(6, it.getExp_date());
			pStatement.setString(7, it.getCategory());

			int i = pStatement.executeUpdate();

			return "Record is added succesfully....";
		} catch (SQLException e) {

			e.printStackTrace();
			return "Failed to insert record....";
		}
	}
	
	public String changePassword(login p) {
		Connection connection = dbConnection.getConnection();
		String sql = "update gmsystem_db.login set password = ? where username = ?";
		
		PreparedStatement pStatement;
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, p.getPassword());
			pStatement.setString(2, p.getUsername());
			pStatement.executeUpdate();
			
			return "Password Updated Successfully..";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error Occured";
		}
		
		
	}
	
	
	
	
	
	
	
	
}
