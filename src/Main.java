
public class Main {

	public static void main(String[] args) {
		// Create new User
		RegisterController rgstr = new RegisterController();
		System.out.println(rgstr.registerForm("pepito", "password", "Etienne", "Saimond", "16/12/1996",
				"etienne.saimond@gmail.com"));
	}

}
