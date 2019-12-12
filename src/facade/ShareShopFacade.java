package facade;


import manager.UserManager;


public class ShareShopFacade {
    private UserManager manager;

    public ShareShopFacade() {
        this.manager = null;
    }
/*
    public void register(String username, String password, String firstname, String lastname, String birthdate,
	String email) {
	manager = new UserManager(username, password, firstname, lastname, birthdate, email);
    }
*/	
    public boolean register() {
        return manager.register();
    }

    public UserManager getManager() {
        return manager;
    }

    public void setManager(UserManager manager) {
        this.manager = manager;
    }
    
    public boolean login(){
        manager = new UserManager();
        return this.manager.login();
    }
}
