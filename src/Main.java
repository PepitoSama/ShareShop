import controller.RegisterController;

public class Main {
	/*
	 * Fichier servant aux test des controllers
	 */
	public static void main(String[] args) {
		RegisterController register = new RegisterController();
		System.out.println(register.registerForm("PepitoLRoiDuGato", "motdepasse", "Etienne", "Saimond", "16/12/1996", "etienne.saimond@gmail.com"));
	}

}
