
public class ShareShopFacade {
	UserManager manager;
	
	public ShareShopFacade(String username, String password, String firstname, String lastname, String birthdate,
			String email) {
		manager = new UserManager(username, password, firstname, lastname, birthdate, email);
	}
	
	public boolean register() {
		return manager.register();
	}
}
