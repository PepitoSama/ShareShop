/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.util.ArrayList;
import java.util.List;

import model.dao.AbstractDAOFactory;
import model.dao.Couple;
import model.dao.DAO;
import model.domain.Group;
import model.domain.Message;

/**
 *
 * @author pepito
 */
public class MessageManager {

    private Group selected;
    private static MessageManager instance = null;
    
    public Group getSelected() {
        return selected;
    }

    public void setSelected(Group selected) {
        this.selected = selected;
    }
    
    public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
        }
        return instance;
    }

    public List<Message> getAllMessages() {
    	DAO<Message> dao = AbstractDAOFactory.getInstance().getMessageDAO();
    	Couple condition1 = new Couple("idGroup", Integer.toString(selected.getId()));
    	List<Couple> listCondition = new ArrayList<>();
    	listCondition.add(condition1);
    	List<Message> messageList = dao.getWhere(listCondition);
    	return messageList;
    }
    
}