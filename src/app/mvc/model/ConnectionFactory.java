package app.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private String url = "jdbc:mysql://localhost/encomenda";
	private String user = "eclipse";
	private String pwd = "eclipse";
	
	private DriverManager driverManager;
	
	public Connection getConnection(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return this.driverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	

}
