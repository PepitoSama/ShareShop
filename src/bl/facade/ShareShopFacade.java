package bl.facade;

import bl.manager.ListManager;
import bl.manager.StatsManager;
import bl.manager.UserGroupManager;
import bl.manager.UserManager;
import bl.manager.GroupManager;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import model.domain.Group;
import model.domain.Stats;
import model.domain.UserGroup;
import model.domain.GroupList;

public class ShareShopFacade {

    private UserManager userManager;
    private StatsManager statsManager;
    private GroupManager groupManager;
    private UserGroupManager userGroupManager;
    private ListManager listManager;

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

    public List<Stats> consultStats(int id, Date dd, Date df) {
        statsManager = StatsManager.getInstance();
        return this.statsManager.consultStats(id, dd, df);
    }

    public List<Stats> consultStats(Date dd, Date df) {
        statsManager = StatsManager.getInstance();
        return this.statsManager.consultStats(dd, df);
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

    public boolean createGroup(String groupName) {
        groupManager = GroupManager.getInstance();
        userGroupManager = userGroupManager.getInstance();
        groupManager.createGroup(groupName);

        int newGroupId = groupManager.getGroupId(groupName);

        return userGroupManager.createUserGroup(getUserId(), newGroupId);
    }

    public int getUserId() {
        return userManager.getUserId();
    }

    public List<UserGroup> getUserGroupList(int userId) {
        userGroupManager = UserGroupManager.getInstance();
        return userGroupManager.getUserGroupList(userId);
    }

    public List<Group> getGroupList(List<UserGroup> userGroupList) {
        GroupManager groupManager = GroupManager.getInstance();
        return groupManager.getGroupList(userGroupList);
    }

    public GroupManager getGroupManager() {
        return GroupManager.getInstance();
    }

    public ListManager getListManager() {
        return ListManager.getInstance();
    }

    public List<GroupList> getShoppingList() {
        listManager = getListManager();
        return listManager.getShoppingList(getSelectedGroupID());
    }

    public int getSelectedGroupListID(){
        return this.listManager.getGroupListId();
    }
    
    public GroupList getSelectedGroupList(){
        listManager = ListManager.getInstance();
        return this.listManager.getSelected();
    }
    
    public int getSelectedGroupID(){
        groupManager = GroupManager.getInstance();  
        return this.groupManager.getSelectedGroupId();
    }
    
    public boolean addShopList(String name) {
        return listManager.addShopList(name, this.getSelectedGroupID() );
    }

    public String getListName() {
        return listManager.getNameSelected();
    }

    public GroupList getBoughtProduct() {
        listManager.getBoughtProducts(listManager.getSelected());
        return listManager.getSelected();
    }

    public boolean updateShopList(String name) {
        return listManager.updateShopList(name);
    }
}
