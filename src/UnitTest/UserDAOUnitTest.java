package UnitTest;
import dao.UserDAO;
import model.User;

public class UserDAOUnitTest {
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User user = new User("sampleNickname", "password", "Prenom", "Nom", "16/12/1996", "email@email.com");
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
