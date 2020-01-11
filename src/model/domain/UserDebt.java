/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.domain;

/**
 *
 * @author fsmag
 */
public class UserDebt {

    private int idDebt;
    private Double amount;
    private int idFrom;
    private int idTo;

    /**
     * UserDebt constructor
     *
     * @param idDebt
     * @param amount
     * @param idFrom
     * @param idTo
     */
    public UserDebt(int idDebt, Double amount, int idFrom, int idTo) {
	this.idDebt = idDebt;
	this.amount = amount;
	this.idFrom = idFrom;
	this.idTo = idTo;
    }

    /**
     * getter for attribut idDebt
     *
     * @return int
     */
    public int getIdDebt() {
	return idDebt;
    }

    /**
     *
     * setter for attribut idDebt
     *
     * @param idDebt
     */
    public void setIdDebt(int idDebt) {
	this.idDebt = idDebt;
    }

    /**
     * getter for attribut amount
     *
     * @return Double
     */
    public Double getAmount() {
	return amount;
    }

    /**
     * setter for attribut amount
     *
     * @param amount
     */
    public void setAmount(Double amount) {
	this.amount = amount;
    }

    /**
     * getter for attribut idFrom
     *
     * @return int
     */
    public int getIdFrom() {
	return idFrom;
    }

    /**
     *
     * setter for attribut idFrom
     *
     * @param idFrom
     */
    public void setIdFrom(int idFrom) {
	this.idFrom = idFrom;
    }

    /**
     * getter for attribut idTo
     *
     * @return int
     */
    public int getIdTo() {
	return idTo;
    }

    /**
     * setter for attribut idTo
     *
     * @param idTo
     */
    public void setIdTo(int idTo) {
	this.idTo = idTo;
    }
}
