package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.domain.Group;
import model.domain.Message;
import model.domain.User;

public class MessageDAO implements DAO<Message>{
	
	JDBCAccess jdbc;
    String tableName;

    public MessageDAO() {
        this.jdbc = JDBCAccess.getInstance();
        this.tableName = "`MessageSent`";
    }


	@Override
	public List<Message> getAll() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Message get(String id) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean save(Message obj) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean update(Message obj) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public boolean delete(Message obj) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Message> getWhere(List<Couple> where) {
		String sql = "SELECT * FROM " + this.tableName + ", `User` WHERE ";
		
		// JOIN USER AND MESSAGES
        sql += " `User`.`idUser` = `MessageSent`.`idUser` ";
        
        for (Couple couple : where) {
            sql += " AND ";
            sql += couple.getName();
            sql += " LIKE ";
            sql += couple.getValue();
        }
        
        // ORDER BY DATE
        sql += " ORDER BY `MessageSent`.`date`";
      
        Statement statement;
        ArrayList<Message> messageList = new ArrayList<>();

        statement = jdbc.prepareStatement(sql);
        ResultSet result;
        try {
            result = statement.executeQuery(sql);
            if (result != null) {
                while (result.next()) {
                    String sentBy = result.getString("nickname");
                    String text = result.getString("text");
                    Date date = result.getDate("date");
                    messageList.add(new Message(sentBy, text, date));
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return messageList;	}

}
