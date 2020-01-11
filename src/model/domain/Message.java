package model.domain;

import java.sql.Date;
import java.util.Calendar;

public class Message {
	
	User sentBy;
	Group group;
	String text;
	private Date date;
	
	public Message(User sentBy, Group group, String text) {
		this.setText(text);
		this.setDate(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
		this.setGroup(group);
		this.setSentBy(sentBy);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getSentBy() {
		return sentBy;
	}

	public void setSentBy(User sentBy2) {
		this.sentBy = sentBy2;
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String toString() {
		return "Message from : " + getSentBy().getNickname() + "\n" + getDate() + "\n" + getText();
	}
	
}
