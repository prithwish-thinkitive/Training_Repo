package com.Thinkitive.Assignment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyDatabaseOperations {

	ConnectionProvider db = new ConnectionProvider();
	Statement st;
	PreparedStatement ps;

	public void insert(String firstname, String middlename, String lastname, String email, String phone, String password) {

		try {
			ps = db.getPreparedStatement("insert into user (firstname, middlename, lastname, email, phone, password) values(?,?,?,?,?,?)");
			ps.setString(1, firstname);
			ps.setString(2, middlename);
			ps.setString(3, lastname);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, password);
			ps.execute();

			db.closeConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public boolean isEmailPresent(String email) {
		
		String query = "select id from user where email = '" + email + "'";
		st = db.getStatement();
		
		boolean flag = false;
		try {
			ResultSet rs = st.executeQuery(query);
			
			flag = rs.isBeforeFirst();
			
			rs.close();
			st.close();
			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean isPasswordPresent(String password) {
		
		String query = "select id from user where password = '" + password + "'";
		
		st = db.getStatement();
		boolean flag = false;
		
		try {
			ResultSet rs = st.executeQuery(query);
			
			flag = rs.isBeforeFirst();
			
//			rs.close();
			st.close();
			db.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean isValidCredential(String email, String password) {
		
		boolean isPassPresent = isPasswordPresent(password);
		boolean isemailPresent = isEmailPresent(email);
		
		if(isPassPresent && isemailPresent) { 
			
			String query = "select id from user where email= '" + email + "' && password = '" + password + "'";
			
			st = db.getStatement();
			
			boolean flag = false;
			
			try {
				ResultSet rs = st.executeQuery(query);
				
				
				flag = rs.isBeforeFirst();
				
				//System.out.println(flag);
				rs.close();
				
				st.close();
				db.closeConnection();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
			return flag;
		}
		return false;
	}

	public void deleteEmp(int id) {

		try {
			ps = db.getPreparedStatement("delete from user where id=?");
			ps.setInt(1, id);
			ps.execute();
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void updateEmp(int id, String name) {

		try {
			ps = db.getPreparedStatement("update think_emp set name=? where id=?");
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.execute();
			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/

	public List displayEmp() {
		List l=new ArrayList();
		st = db.getStatement();

		try {
			ResultSet rs = st.executeQuery("select * from user");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) +" "+ rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				l.add(rs.getInt(1) + " " + rs.getString(2) +" "+ rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}

			db.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;

	}
}