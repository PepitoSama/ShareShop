package model.domain;

import java.util.Date;

public class Message {
	
	String sentBy;
	String text;
	private Date date;
	
	public Message(String sentBy, String text, Date date) {
		this.setText(text);
		this.setDate(date);
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

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}
	
	public String toString() {
		return "Message from : " + getSentBy() + ", " + getDate() + "\n" + getText();
	}
	
}
