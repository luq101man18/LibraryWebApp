package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class loginDAO{
	
	String DataBase_username = "root";
    
	String url = "jdbc:mysql://localhost/library";
	Statement statement = null;
    ResultSet resultSet = null;
    ResultSetMetaData resultSetMetaData  = null;
    PreparedStatement preparedStatement = null;
    Connection con;
    
	public void connect() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,DataBase_username, DataBase_passsword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String username, String password) throws SQLException{
		String query = "select username, password from user where username=? and password=?";
		preparedStatement =	con.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);
		resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
			return true;
		return false;
	}
	
}