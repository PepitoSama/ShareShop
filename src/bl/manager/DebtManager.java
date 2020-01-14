/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.Couple;
import model.dao.DAO;
import model.domain.User;
import model.domain.UserDebt;

/**
 *
 * @author fsmag
 */
public class DebtManager {

    private static DebtManager instance = null;
    private UserDebt selectedDebt;

    /**
     * Return, if created the DebtManager instance. Else, instantiate
     * DebtManager and return it.
     *
     * @return DebtManager
     */
    public static DebtManager getInstance() {
	if (instance == null) {
	    instance = new DebtManager();
	}
	return instance;
    }

    /**
     * Return the selected UserDebt
     *
     * @return UserDebt
     */
    public UserDebt getSelectedDebt() {
	return selectedDebt;
    }

    /**
     * Set the selected UserDebt
     *
     * @param UserDebt
     */
    public void setSelectedDebt(UserDebt selectedDebt) {
	this.selectedDebt = selectedDebt;
    }

    /**
     *
     *
     * @param id
     * @return
     */
    public List<UserDebt> getMyDue(int id) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idFrom", Integer.toString(id)));
	return dao.get(liste);
    }

    /**
     *
     *
     * @param id
     * @return
     */
    public List<UserDebt> getMyDebt(int id) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idTo", Integer.toString(id)));
	return dao.get(liste);
    }

    /**
     *
     *
     * @param idFrom
     * @param idTo
     * @param value
     */
    public void addDebt(int idFrom, int idTo, Double value) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idFrom", Integer.toString(idFrom)));
	liste.add(new Couple("idTo", Integer.toString(idTo)));
	List<UserDebt> res = dao.get(liste);
	if (!res.isEmpty()) {
	    UserDebt ud = res.get(0);
	    Double d = ud.getAmount();
	    ud.setAmount(d + value);
	    dao.update(ud);
	} else {
	    List<Couple> liste2 = new ArrayList<Couple>();
	    liste2.add(new Couple("idTo", Integer.toString(idTo)));
	    liste2.add(new Couple("idFrom", Integer.toString(idFrom)));
	    res = dao.get(liste2);
	    if (res.isEmpty()) {
		dao.save(new UserDebt(0, value, idFrom, idTo));
	    } else {
		UserDebt ud = res.get(0);
		Double d = ud.getAmount();
		if ((d - value) < 0) {
		    int i = ud.getIdFrom();
		    ud.setIdFrom(ud.getIdTo());
		    ud.setIdTo(i);
		    ud.setAmount((d - value) * -1);
		    dao.update(ud);
		} else {
		    ud.setAmount(d - value);
		    dao.update(ud);
		}
	    }
	}

    }

    /**
     *
     *
     * @param ud
     * @return
     */
    public boolean updateDebt(UserDebt ud) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	return dao.update(ud);
    }

    /**
     *
     *
     * @param users
     * @param userId
     * @param price
     */
    public void addGroupDebt(List<User> users, int userId, Double price) {
	Double prix = price / users.size();
	DecimalFormat df = new DecimalFormat("#.##");
	String aff = (df.format(prix)).replace(",", ".");
	prix = Double.parseDouble(aff);
	for (User user : users) {
	    if (user.getId() != userId) {
		addDebt(user.getId(), userId, prix);
	    }
	}
    }
}
