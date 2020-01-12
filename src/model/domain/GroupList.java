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
    private List<PricedProduct> boughtProducts;

    /**
     * GroupList constructor
     *
     * @param idGroupList
     * @param idGroup
     * @param name
     * @param date
     * @param type
     */
    public GroupList(int idGroupList, int idGroup, String name, Date date, char type) {
	this.idGroupList = idGroupList;
	this.idGroup = idGroup;
	this.name = name;
	this.date = date;
	this.type = type;
    }

    /**
     * getter for attribut boughtProducts
     *
     * @return List<PricedProduct>
     * @see PricedProduct
     */
    public List<PricedProduct> getBoughtProducts() {
	return boughtProducts;
    }

    /**
     * setter for attribut boughtProducts
     *
     * @param boughtProducts
     * @see PricedProduct
     */
    public void setBoughtProducts(List<PricedProduct> boughtProducts) {
	this.boughtProducts = boughtProducts;
    }

    /**
     * getter for attribut idGroupList
     *
     * @return int
     */
    public int getIdGroupList() {
	return idGroupList;
    }

    /**
     *
     * setter for attribut idGroupList
     *
     * @param idGroupList
     */
    public void setIdGroupList(int idGroupList) {
	this.idGroupList = idGroupList;
    }

    /**
     *
     * getter for attribut idGroup
     *
     * @return int
     */
    public int getIdGroup() {
	return idGroup;
    }

    /**
     * setter for attribut idGroup
     *
     * @param idGroup
     */
    public void setIdGroup(int idGroup) {
	this.idGroup = idGroup;
    }

    /**
     * getter for attribut name
     *
     * @return String
     */
    public String getName() {
	return name;
    }

    /**
     * setter for attribut name
     *
     * @param name
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * getter for attribut date
     *
     * @return Date
     */
    public Date getDate() {
	return date;
    }

    /**
     * setter for attribut date
     *
     * @param date
     */
    public void setDate(Date date) {
	this.date = date;
    }

    /**
     * getter for attribut type
     *
     * @return char
     */
    public char getType() {
	return type;
    }

    /**
     * setter for attribut type
     *
     * @param type
     */
    public void setType(char type) {
	this.type = type;
    }

}
