/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import java.util.List;
import model.dao.GroupListDAO;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class GroupListDAOUnitTest {
    public static void main(String[] args) {
		GroupListDAO dao = new GroupListDAO();
		List<GroupList> liste = dao.getShoppingList(1);
                System.out.println(liste);
	}
}
