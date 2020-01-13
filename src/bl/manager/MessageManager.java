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
import model.domain.User;

/**
 *
 * @author pepito
 */
public class MessageManager {

	private Group selected;
	private static MessageManager instance = null;

	/**
	 * Return, if created the MessageManager instance. Else, instantiate
	 * MessageManager and return it.
	 * 
	 * @return MessageManager
	 */
	public static MessageManager getInstance() {
		if (instance == null) {
			instance = new MessageManager();
		}
		return instance;
	}

	/**
	 * Return the selected Group (Used to know what messages show)
	 * 
	 * @return Group
	 */
	public Group getSelected() {
		return selected;
	}

	/**
	 * Set the selected Group (Used to know what messages show)
	 * 
	 * @param selected Group (Used to know what messages show)
	 */
	public void setSelected(Group selected) {
		this.selected = selected;
	}

	/**
	 * Get all messages from a group
	 * 
	 * @return List<Message>
	 */
	public List<Message> getAllMessages() {
		DAO<Message> dao = AbstractDAOFactory.getInstance().getMessageDAO();
		Couple condition1 = new Couple("`MessageSent`.`idGroup`", Integer.toString(selected.getId()));
		List<Couple> listCondition = new ArrayList<>();
		listCondition.add(condition1);
		List<Message> messageList = dao.get(listCondition);
		return messageList;
	}

	/**
	 * Send a message
	 * 
	 * @param message The message that has to be sent
	 * @param sentBy  The User who sent the message
	 * @param group   The Group which will have access to the message
	 * @return
	 */
	public boolean sendMessage(String message, User sentBy, Group group) {
		DAO<Message> dao = AbstractDAOFactory.getInstance().getMessageDAO();
		Message toSend = new Message(sentBy, group, message);
		return dao.save(toSend);
	}

}
