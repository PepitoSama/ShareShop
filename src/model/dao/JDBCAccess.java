package model.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

public class JDBCAccess {

	private Connection conn = null;
	private static JDBCAccess instance = null;

	/**
	 * Return, if created the JDBCAccess instance. Else, instantiate JDBCAccess and
	 * return it.
	 * 
	 * @return JDBCAccess
	 */
	public static JDBCAccess getInstance() {
		if (instance == null) {
			instance = new JDBCAccess();
			instance.openConnection();
		}
		return instance;
	}

	/**
	 * Open the connection with database
	 */
	public void openConnection() {
		System.out.println("\n\n***** MySQL JDBC Connection *****");
		if (this.getConn() == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				Hashtable<String, String> logs = getLog();
				String url = "jdbc:mysql://" + logs.get("host") + "/ShareShop";
				this.setConn(DriverManager.getConnection(url, logs.get("username"), logs.get("password")));
				System.out.println("\nDatabase Connection Established...");
			} catch (Exception ex) {
				System.err.println("Cannot connect to database server");
				ex.printStackTrace();
			}
		} else {
			System.err.println("You are already connected");
		}
	}

	/**
	 * Close the connection with database
	 */
	public void closeConnection() {
		if (this.getConn() != null) {
			try {
				System.out.println("\n***** Terminate the Connection *****");
				conn.close();
				System.out.println("\nDatabase connection terminated...");
			} catch (Exception ex) {
				System.out.println("Error in connection termination!");
			}
		}
	}

	/**
	 * Get logs from ./ressources/config/database.properties
	 * 
	 * @return
	 */
	private Hashtable<String, String> getLog() {
		Hashtable<String, String> toGet = new Hashtable<String, String>();
		toGet.put("username", "");
		toGet.put("password", "");
		toGet.put("host", "");
		try {
			toGet = ReadPropertyFile.getValues("database", toGet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toGet;
	}

	/**
	 * Return Connection object
	 * 
	 * @return Connection
	 */
	public Connection getConn() {
		return conn;
	}

	/**
	 * Set Connection object
	 * 
	 * @param Connection
	 */
	public void setConn(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Prepare a sql statement from a String
	 * 
	 * @param sql The Query
	 * @return PreparedStatement object used to fetch data
	 */
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
