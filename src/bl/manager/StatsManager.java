/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import model.dao.AbstractDAOFactory;
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
}
