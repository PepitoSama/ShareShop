/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Date;
import java.util.List;

/**
 *
 * @author fsmag
 */
public interface DAOGroupListInterface<T> extends DAO<T>{
    public List<T> getShoppingList(int id);
    
}