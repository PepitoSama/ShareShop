package bl.facade;

import bl.manager.StatsManager;
import bl.manager.UserManager;
import java.util.Date;
import java.util.List;
import model.domain.Stats;

public class ShareShopFacade {

    private UserManager userManager;
    private StatsManager statsManager;
    private static ShareShopFacade instance = null;

    public static ShareShopFacade getInstance() {
        if (instance == null) {
            instance = new ShareShopFacade();
        }
        return instance;
    }
    
    private ShareShopFacade(){
        userManager = null;
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

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean login(String name, String pwd) {
        userManager = new UserManager();
        return this.userManager.login(name, pwd);
    }
    
    public List<Stats> consultStats(int id){
        statsManager = StatsManager.getInstance();
        return this.statsManager.consultStats(id);
    }
    
    public List<Stats> consultStats(){
        statsManager = StatsManager.getInstance();
        return this.statsManager.consultStats();
    }
    
    public int getNumberUserStats(){
        statsManager = StatsManager.getInstance();
        return this.statsManager.getNumber();
    }
}
