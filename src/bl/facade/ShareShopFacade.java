package bl.facade;

import bl.manager.StatsManager;
import bl.manager.UserManager;

import java.sql.SQLException;
import java.time.LocalDate;
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

    private ShareShopFacade() {
        userManager = null;
    }

    public boolean register(String username, String password, String firstname, String lastname, Date birthdate,
            String email, String passwordC) throws Exception {
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
    
    public int getNumberUserStats() {
        statsManager = StatsManager.getInstance();
        return this.statsManager.getNumber();
    }


    public String getNickname() {
        return userManager.getNickname();
    }

    public String getName() {
        return userManager.getName();
    }

    public String getLastname() {
        return userManager.getLastname();
    }

    public String getMail() {
        return userManager.getMail();
    }

    public Date getBirthdate() {
        return userManager.getBirthdate();
    }

    public LocalDate getLocalBirthdate() {
        return userManager.getLocalBirthdate();
    }

    public String getPassword() {
        return userManager.getPassword();
    }

    public boolean updateUser() throws SQLException {
        return userManager.updateUser();
    }

    public void setName(String text) {
        userManager.setName(text);
    }

    public void setLastname(String text) {
        userManager.setLastname(text);
    }

    public void setNickname(String text) {
        userManager.setNickname(text);
    }

    public void setMail(String text) {
        userManager.setMail(text);
    }

    public void setPassword(String text) {
        userManager.setPassword(text);
    }

    public void setBirthdate(Date date) {
        userManager.setBirthdate(date);
    }
}
