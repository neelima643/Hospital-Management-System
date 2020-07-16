package database;

import java.sql.*;
import net.proteanit.sql.DbUtils;

public class dbconnection {
	public static Connection getCon() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/database?autoReconnect=true&useSSL=false", "root", "123456");
			return con;
			
			}
		catch(Exception e) {
			
			return null;
			
		}
	}
		
	

}
