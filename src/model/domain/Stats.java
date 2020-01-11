/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

import java.util.Date;

/**
 *
 * @author fsmag
 */
public class Stats {

    private int idUser;
    private Date date;
    private float amount;

    /**
     *
     * getter for attribut idUser
     *
     * @return int
     */
    public int getIdUser() {
	return idUser;
    }

    /**
     *
     * setter for attribut idUser
     *
     * @param idUser
     */
    public void setIdUser(int idUser) {
	this.idUser = idUser;
    }

    /**
     *
     * getter for attribut date
     *
     * @return Date
     */
    public Date getDate() {
	return date;
    }

    /**
     *
     * setter for attribut date
     *
     * @param date
     */
    public void setDate(Date date) {
	this.date = date;
    }

    /**
     * getter for attribut amount
     *
     * @return float
     */
    public float getAmount() {
	return amount;
    }

    /**
     *
     * setter for attribut amount
     *
     * @param amount
     */
    public void setAmount(float amount) {
	this.amount = amount;
    }

    /**
     * Stat constructor
     *
     * @param idUser
     * @param date
     * @param amount
     */
    public Stats(int idUser, Date date, float amount) {
	this.idUser = idUser;
	this.date = date;
	this.amount = amount;
    }

}
