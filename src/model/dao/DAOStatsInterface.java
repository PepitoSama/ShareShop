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
public interface DAOStatsInterface<T> extends DAO<T>{
    public List<T> getUser(int id);
    public List<T> getDate(int id,Date d, Date f);
    public List<T> getDate(Date d, Date f);
    public int getNumber();
    
}
