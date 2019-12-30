/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;

/**
 *
 * @author fsmag
 */
public interface DAOProductsInterface<T> extends DAO<T> {

    public List<T> getProducts(int id);
}
