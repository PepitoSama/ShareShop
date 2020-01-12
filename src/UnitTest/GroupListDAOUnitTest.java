/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import java.util.ArrayList;
import java.util.List;
import model.dao.Couple;
import model.dao.GroupListDAO;
import model.domain.GroupList;

/**
 *
 * @author fsmag
 */
public class GroupListDAOUnitTest {

    public static void main(String[] args) {
        GroupListDAO dao = new GroupListDAO();
        List<Couple> couple = new ArrayList<Couple>();
        couple.add(new Couple("idGroup", Integer.toString(1)));
        couple.add(new Couple("type", "S"));
        List<GroupList> liste = dao.get(couple);
        System.out.println(liste);
    }
}
