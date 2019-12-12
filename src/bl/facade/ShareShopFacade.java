package bl.facade;


import bl.manager.UserManager;


public class ShareShopFacade {
    private UserManager manager;

    public ShareShopFacade() {
        this.manager = null;
    }

    public void register(String username, String password, String firstname, String lastname, String birthdate,
	String email) {
        manager = new UserManager();
		manager.register(username, password, firstname, lastname, birthdate, email);
    }


    public UserManager getManager() {
        return manager;
    }

    public void setManager(UserManager manager) {
        this.manager = manager;
    }
    
    public boolean login(String name, String pwd){
        manager = new UserManager();
        return this.manager.login(name, pwd);
    }
}
