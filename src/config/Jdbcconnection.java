package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcconnection {
	
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		
		//Datasource information
		String url="jdbc:h2:tcp://localhost/~/test";
		String username="sa";
		String password="";
		//Loading Driver
		Class.forName("org.h2.Driver");
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}

}
