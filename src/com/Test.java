package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		
		Statement st = con.createStatement();
		
		String sqlQuery="select empName , empAddress from employees";
		boolean flag = false;
		ResultSet rs =st.executeQuery(sqlQuery);
		System.out.println("ENAME \t\t EADDR");
		System.out.println("------------------");
		while(rs.next())
		{
			flag=true;
			System.out.println(rs.getString("empName")+"\t\t"+rs.getString("empAddress"));
			//System.out.println(rs.getString(1)+"\t"+rs.getString(2));
		}
		if(flag==false)
		{
			System.out.println("No Records found");
		}
		con.close();
	}

}
