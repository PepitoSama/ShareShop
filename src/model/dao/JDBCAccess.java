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

    public static JDBCAccess getInstance() {
        if (instance == null) {
            instance = new JDBCAccess();
        }
        return instance;
    }

    public void openConnection() {
        System.out.println("\n\n***** MySQL JDBC Connection Testing *****");
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
