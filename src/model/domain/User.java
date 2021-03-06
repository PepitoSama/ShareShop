package model.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class User {
	private int id;
	private String nickname;
	private String fistname;
	private String lastname;
	private String password;
	private Date birthdate;
	private String email;

	public User(String username, String password, String firstname, String lastname, Date birthdate, String email) {
		this.setBirthdate(birthdate);
		this.setEmail(email);
		this.setFistname(firstname);
		this.setLastname(lastname);
		this.setNickname(username);
		this.setPassword(password);
		this.setId(-1);
	}
	
	public User(String username, String firstname, String lastname, Date birthdate, String email, int id) {
		this.setBirthdate(birthdate);
		this.setEmail(email);
		this.setFistname(firstname);
		this.setLastname(lastname);
		this.setNickname(username);
		this.setId(id);
	}
	
	public User(String username, String password, String firstname, String lastname, Date birthdate, String email, int id) {
		this.setBirthdate(birthdate);
		this.setEmail(email);
		this.setFistname(firstname);
		this.setLastname(lastname);
		this.setNickname(username);
		this.setPassword(password);
		this.setId(id);
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFistname() {
		return fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", fistname=" + fistname + ", lastname=" + lastname
				+ ", password=" + password + ", birthdate=" + birthdate + ", email=" + email + "]";
	}
	
	
}
