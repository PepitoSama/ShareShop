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
	liste.add(new Couple("idDue", Integer.toString(id)));
	return dao.getWhere(liste);
    }
}
