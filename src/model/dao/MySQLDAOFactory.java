package model.dao;

import model.domain.Group;
import model.domain.Stats;
import model.domain.User;
import model.domain.UserGroup;
import model.domain.GroupList;
import model.domain.Message;

import model.domain.products.GeneralProduct;

import model.domain.UserDebt;

import model.domain.products.PricedProduct;
import model.domain.products.QuantifiedProduct;


/**
 *
 */
public class MySQLDAOFactory extends AbstractDAOFactory {

    /**
     * @return
     */
    public DAO<User> getUserDAO() {
        return new UserDAO();
    }

    public DAOStatsInterface<Stats> getStatsDAO() {
        return new StatsDAO();
    }
    
    public DAO<Group> getGroupDAO() {
    	return new GroupDAO();
    }
    
    public DAO<UserGroup> getUserGroupDAO() {
    	return new UserGroupDAO();
    }

    @Override
    public DAO<GroupList> getGroupListDAO() {
        return new GroupListDAO();
    }

    @Override
    public DAO<PricedProduct> getPricedProductDAO() {
        return new PricedProductDAO();
    }

	@Override
	public DAO<Message> getMessageDAO() {
		return new MessageDAO();
	}


	@Override
	public DAO<GeneralProduct> getProductDAO() {
		return new ProductDAO();
	}

    @Override
    public DAO<UserDebt> getUserDebtDAO() {
	return new UserDebtDAO();
    }

    @Override
    public DAO<QuantifiedProduct> getQuantifiedProductDAO() {
   	return new QuantifiedProductDAO();

    }


}
