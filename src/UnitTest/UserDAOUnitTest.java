package UnitTest;

import java.util.Date;
import model.dao.UserDAO;
import model.domain.User;
import ui.controller.RegisterController;

public class UserDAOUnitTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User user = new User("sampleNickname", "password", "Prenom", "Nom", new Date("16/12/1996"), "email@email.com");
		dao.save(user);
		for(User userf : dao.getAll()) {
			System.out.println(userf.toString());
		}

	}
}
