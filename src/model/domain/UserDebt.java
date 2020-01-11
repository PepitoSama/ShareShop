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

    public UserDebt(int idDebt, Double amount, int idFrom, int idTo) {
	this.idDebt = idDebt;
	this.amount = amount;
	this.idFrom = idFrom;
	this.idTo = idTo;
    }

    public int getIdDebt() {
	return idDebt;
    }

    public void setIdDebt(int idDebt) {
	this.idDebt = idDebt;
    }

    public Double getAmount() {
	return amount;
    }

    public void setAmount(Double amount) {
	this.amount = amount;
    }

    public int getIdFrom() {
	return idFrom;
    }

    public void setIdFrom(int idFrom) {
	this.idFrom = idFrom;
    }

    public int getIdTo() {
	return idTo;
    }

    public void setIdTo(int idTo) {
	this.idTo = idTo;
    }
}
