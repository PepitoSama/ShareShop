/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.Couple;
import model.dao.DAO;
import model.dao.DAOStatsInterface;
import model.dao.StatsDAO;
import model.domain.Stats;

/**
 *
 * @author fsmag
 */
public class StatsManager {

    private static StatsManager instance = null;

    public static StatsManager getInstance() {
	if (instance == null) {
	    instance = new StatsManager();
	}
	return instance;
    }

    public List<Stats> consultStats(int id, Date dd, Date df) {
	DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();

	try {
	    if (dd != null || df != null) {
		return dao.getDate(id, dd, df);
	    } else {
		return dao.getUser(id);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<Stats> consultStats(Date dd, Date df) {
	DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();
	try {
	    if (dd != null || df != null) {
		return dao.getDate(dd, df);
	    } else {
		return dao.getAll();
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public int getNumber() {
	DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();
	try {
	    return dao.getNumber();
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return 1;
    }

    public boolean addStat(int id, float amount, Date date) {
	DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();
	List<Couple> liste = new ArrayList<Couple>();
	java.sql.Date d = new java.sql.Date(date.getTime());
	liste.add(new Couple("date", d.toString()));
	liste.add(new Couple("idUser", Integer.toString(id)));
	liste.add(new Couple("amount", Float.toString(amount)));
	List<Stats> s = dao.get(liste);
	if(s.size()>0){
	    Stats stat = s.get(0);
	    stat.setAmount(stat.getAmount()+amount);
	    return dao.update(stat);
	}
	else{
	    return dao.save(new Stats(id, date, amount));
	}
    }
}
