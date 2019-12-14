package bl.facade;

import bl.manager.UserManager;
import java.util.Date;

public class ShareShopFacade {

    private UserManager userManager;

    public ShareShopFacade() {
        this.userManager = null;
    }

    public boolean register(String username, String password, String firstname, String lastname, Date birthdate, String email, String passwordC) throws Exception{
        if (userManager == null) {
            userManager = new UserManager();
        }
        return userManager.register(username, password, firstname, lastname, birthdate, email, passwordC);
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean login(String name, String pwd) {
        userManager = new UserManager();
        return this.userManager.login(name, pwd);
    }
}
