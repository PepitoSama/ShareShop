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

	
	/**
	 * Return a list of Stats within a date range for a specific user
	 * 
	 * @param id
	 *            the id of the user
	 * @param dd
	 *            the start date
	 * @param df
	 *            the end date
	 * @return The list of stats
	 */
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

	
	/**
	 * Return the list of stats within a date range for all the users
	 * 
	 * @param dd
	 *            the start date
	 * @param df
	 *            the end date
	 * @return The list of stats
	 */
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

	
	/**
	 * @return the number of stats entries in the database. Can be used in to adjust
	 *         the scale in a graph in the ui
	 */
	public int getNumber() {
		DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();
		try {
			return dao.getNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	
	/**
	 * Add a new stat 
	 * @param id	the id of the user
	 * @param amount	the amount
	 * @param date	the date
	 * @return	true if the stats has been added
	 */
	public boolean addStat(int id, float amount, Date date) {
		DAOStatsInterface<Stats> dao = AbstractDAOFactory.getInstance().getStatsDAO();
		List<Couple> liste = new ArrayList<Couple>();
		java.sql.Date d = new java.sql.Date(date.getTime());
		liste.add(new Couple("date", d.toString()));
		liste.add(new Couple("idUser", Integer.toString(id)));
		List<Stats> s = dao.get(liste);
		if (s.size() > 0) {
			Stats stat = s.get(0);
			stat.setAmount(stat.getAmount() + amount);
			return dao.update(stat);
		} else {
			return dao.save(new Stats(id, date, amount));
		}
	}
}
