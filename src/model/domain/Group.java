package model.domain;


public class Group {
	
	private int id;
	private String groupName;
	
	
	public Group(int idGroup, String groupName) {
		this.groupName = groupName;
		this.id = idGroup;
	}
	
	public Group(String groupName) {
		this.groupName = groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return this.groupName;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String toString() {
		return "Group name : " + groupName;
	}
}
