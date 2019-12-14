package UnitTest;

import java.util.Date;
import model.dao.UserDAO;
import model.domain.User;

public class UserDAOUnitTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User user = new User("sampleNickname", "password", "Prenom", "Nom", new Date("16/12/1996"), "email@email.com");
		dao.save(user);
		for(User userf : dao.getAll()) {
			System.out.println(userf.toString());
		}
		User pepito = dao.get("sampleNickname");
		System.out.println(pepito);
		pepito.setEmail("email@gmail.com");
		dao.update(pepito);
		dao.delete(pepito);
	}
}
