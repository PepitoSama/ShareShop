/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.manager;

import java.util.ArrayList;
import java.util.List;
import model.dao.AbstractDAOFactory;
import model.dao.Couple;
import model.dao.DAO;
import model.domain.UserDebt;

/**
 *
 * @author fsmag
 */
public class DebtManager {

    private static DebtManager instance = null;
    private UserDebt selectedDebt;

    public UserDebt getSelectedDebt() {
	return selectedDebt;
    }

    public void setSelectedDebt(UserDebt selectedDebt) {
	this.selectedDebt = selectedDebt;
    }

    public static DebtManager getInstance() {
	if (instance == null) {
	    instance = new DebtManager();
	}
	return instance;
    }

    public List<UserDebt> getMyDue(int id) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idFrom", Integer.toString(id)));
	return dao.getWhere(liste);
    }

    public List<UserDebt> getMyDebt(int id) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idTo", Integer.toString(id)));
	return dao.getWhere(liste);
    }

    public void addDebt(int idFrom, int idTo, Double value) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	List<Couple> liste = new ArrayList<Couple>();
	liste.add(new Couple("idFrom", Integer.toString(idFrom)));
	liste.add(new Couple("idTo", Integer.toString(idTo)));
	List<UserDebt> res = dao.getWhere(liste);
	if (res.size() == 0) {
	    List<Couple> liste2 = new ArrayList<Couple>();
	    liste2.add(new Couple("idTo", Integer.toString(idFrom)));
	    liste2.add(new Couple("idFrom", Integer.toString(idTo)));
	    res = dao.getWhere(liste2);
	}
	if (res.size() == 0) {
	    dao.save(new UserDebt(0, value, idFrom, idTo));
	} else {
	    UserDebt ud = res.get(0);
	    Double d = ud.getAmount();
	    if ((d - value) < 0) {
		int i = ud.getIdFrom();
		ud.setIdFrom(ud.getIdTo());
		ud.setIdTo(i);
		ud.setAmount((d - value) * -1);
	    }
	}
    }

    public boolean updateDebt(UserDebt ud) {
	DAO<UserDebt> dao = AbstractDAOFactory.getInstance().getUserDebtDAO();
	return dao.update(ud);
    }
}
