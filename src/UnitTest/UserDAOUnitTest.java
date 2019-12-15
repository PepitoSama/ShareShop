package UnitTest;

import java.io.IOException;

import bl.facade.ShareShopFacade;
import model.dao.UserDAO;
import model.domain.User;
import ui.controller.RegisterController;

public class UserDAOUnitTest {
	public static void main(String[] args) {
//		UserDAO dao = new UserDAO();
//		User user = new User("sampleNickname", "password", "Prenom", "Nom", "16/12/1996", "email@email.com");
//		dao.save(user);
//		for(User userf : dao.getAll()) {
//			System.out.println(userf.toString());
//		}
//		User pepito = dao.get("sampleNickname");
//		System.out.println(pepito);
//		pepito.setEmail("email@gmail.com");
//		dao.update(pepito);
//		dao.delete(pepito);

		ShareShopFacade facade = new ShareShopFacade();
		RegisterController register;
		try {
			register = new RegisterController(facade);
			register.registerForm("pepitosama", "password", "Etienne", "Saimond", "16/12/1996", "etienne.saimond@gmail.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
