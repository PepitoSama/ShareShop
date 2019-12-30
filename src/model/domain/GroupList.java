/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Date;
import java.util.List;
import model.domain.products.*;

/**
 *
 * @author fsmag
 */
public class GroupList {

    private int idGroupList;
    private int idGroup;
    private String name;
    private Date date;
    private char type;
    

    public int getIdGroupList() {
        return idGroupList;
    }

    public void setIdGroupList(int idGroupList) {
        this.idGroupList = idGroupList;
    }

    public GroupList(int idGroupList, int idGroup, String name, Date date, char type) {
        this.idGroupList = idGroupList;
        this.idGroup = idGroup;
        this.name = name;
        this.date = date;
        this.type = type;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }


}
