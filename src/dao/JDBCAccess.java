package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCAccess {

	private Connection conn = null;
	
	public void openConnection() {
		System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
		if (this.getConn() == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				String userName = "ShareShop";
				String password = "$hAr�Sh0p";
				String url = "jdbc:mysql://vps414215.ovh.net/ShareShop";
				this.setConn(DriverManager.getConnection(url, userName, password));
				System.out.println("\nDatabase Connection Established...");
			} catch (Exception ex) {
				System.err.println("Cannot connect to database server");
				ex.printStackTrace();
			}
		} else {
			System.err.println("You are already connected");
		}
	}

	public void closeConnection() {
		if (this.getConn() != null) {
			try {
				System.out.println("\n***** Let terminate the Connection *****");
				conn.close();
				System.out.println("\nDatabase connection terminated...");
			} catch (Exception ex) {
				System.out.println("Error in connection termination!");
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public PreparedStatement prepareStatement(String sql) {
		PreparedStatement prepared = null;
		try {
			prepared = this.conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prepared;
	}
}
