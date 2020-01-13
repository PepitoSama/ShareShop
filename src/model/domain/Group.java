package model.domain;

import java.util.ArrayList;
import java.util.List;

import model.domain.products.GeneralProduct;

public class Group {

    private int id;
    private String groupName;
    private List<GeneralProduct> favoriteList;

    public Group(int idGroup, String groupName) {
        this.groupName = groupName;
        this.id = idGroup;
        setFavoriteList(new ArrayList<>());
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

	public List<GeneralProduct> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<GeneralProduct> favoriteList) {
		this.favoriteList = favoriteList;
	}
    
    
    
}
