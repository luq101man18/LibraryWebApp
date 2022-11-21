package com.login;

import java.sql.SQLException;

import javax.print.DocFlavor.URL;

public class test{
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		java.net.URL url = classLoader.getResource("path/folder");
		System.out.print(url);

	
	}
}