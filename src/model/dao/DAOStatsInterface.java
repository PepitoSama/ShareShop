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
 * @param <T>
 */
public interface DAOStatsInterface<T> extends DAO<T>{

    /**
     *
     * @param id
     * @return List<T>
     */
    public List<T> getUser(int id);

    /**
     *
     * @param id
     * @param d
     * @param f
     * @return List<T>
     */
    public List<T> getDate(int id,Date d, Date f);

    /**
     *
     * @param d
     * @param f
     * @return List<T>
     */
    public List<T> getDate(Date d, Date f);

    /**
     *
     * @return int
     */
    public int getNumber();
    
}
