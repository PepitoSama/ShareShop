package model.domain;

public class UserGroup {
	private int idUser;
	private int idGroup;

	public UserGroup(int idUser, int idGroup) {
		this.setIdUser(idUser);
		this.setIdGroup(idGroup);
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	@Override
	public String toString() {
		return "UserGroup : u " + idUser + " - g " + idGroup;
	}
	
	
}
