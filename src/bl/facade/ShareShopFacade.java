package bl.facade;

import bl.manager.DebtManager;
import bl.manager.ListManager;
import bl.manager.MessageManager;
import bl.manager.ProductManager;
import bl.manager.StatsManager;
import bl.manager.UserGroupManager;
import bl.manager.UserManager;
import javafx.scene.image.Image;
import bl.manager.GroupManager;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import model.domain.Group;
import model.domain.Stats;
import model.domain.UserGroup;
import model.domain.products.GeneralProduct;
import model.domain.GroupList;
import model.domain.Message;
import model.domain.User;
import model.domain.UserDebt;
import model.domain.products.PricedProduct;
import model.domain.products.QuantifiedProduct;

/**
 * ShareShop Application Facade It contains all the public accessible method
 * from the business logic of the application.
 * 
 * This facade is implemented as a singleton : Use ShareShopFacade.getInstance()
 * to get the instance.
 */
public class ShareShopFacade {

	private UserManager userManager;
	private StatsManager statsManager;
	private GroupManager groupManager;
	private UserGroupManager userGroupManager;
	private ListManager listManager;
	private MessageManager messageManager;
	private ProductManager productManager;
	private DebtManager debtManager;

	
	// === SINGLETON IMPLEMENTATION ===

	private static ShareShopFacade instance = null;

	/**
	 * @return the Instance of the Facade
	 */
	public static ShareShopFacade getInstance() {
		if (instance == null) {
			instance = new ShareShopFacade();
		}
		return instance;
	}

	private ShareShopFacade() {
		userManager = null;
	}
	
	
	
	
	

	// === USER METHODS ===

	/**
	 * Register a new user in the application
	 * 
	 * @param username
	 *            The username of the user
	 * @param password
	 *            The password of the user
	 * @param firstname
	 *            The firstname of the user
	 * @param lastname
	 *            The last name of the user
	 * @param birthdate
	 *            The birth date of the user
	 * @param email
	 *            The email adress of the user
	 * @param passwordC
	 *            The password confirmation
	 * @return true if the user has been created, false else
	 * @throws Exception
	 */
	public boolean register(String username, String password, String firstname, String lastname, Date birthdate,
			String email, String passwordC) throws Exception {
		if (userManager == null) {
			userManager = new UserManager();
		}
		return userManager.register(username, password, firstname, lastname, birthdate, email, passwordC);
	}

	/**
	 * Log the user in the application
	 * 
	 * @param name
	 *            the nickname of the user
	 * @param pwd
	 *            the password of the user
	 * @return true if the user is connected, false else
	 */
	public boolean login(String name, String pwd) {
		userManager = new UserManager();
		return this.userManager.login(name, pwd);
	}

	/**
	 * @return the id of the user
	 */
	public int getUserId() {
		return userManager.getUserId();
	}

	/**
	 * @return The nickname of the user
	 */
	public String getNickname() {
		return userManager.getNickname();
	}

	/**
	 * @return the first name of the user
	 */
	public String getName() {
		return userManager.getName();
	}

	/**
	 * @return the last name of the user
	 */
	public String getLastname() {
		return userManager.getLastname();
	}

	/**
	 * @return the mail of the user
	 */
	public String getMail() {
		return userManager.getMail();
	}

	/**
	 * @return the birth date of the user
	 */
	public Date getBirthdate() {
		return userManager.getBirthdate();
	}

	/**
	 * @return The local birth date of the user
	 */
	public LocalDate getLocalBirthdate() {
		return userManager.getLocalBirthdate();
	}

	/**
	 * Update the user with the selected user
	 * 
	 * @return true if the user has been updated
	 */
	public boolean updateUser() {
		try {
			return userManager.updateUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Set the name of the user
	 * 
	 * @param text
	 *            the first name
	 */
	public void setName(String text) {
		userManager.setName(text);
	}

	/**
	 * Set the last name of the user
	 * 
	 * @param text
	 *            the last name
	 */
	public void setLastname(String text) {
		userManager.setLastname(text);
	}

	/**
	 * Set the nickname of the user
	 * 
	 * @param text
	 *            The nickname
	 */
	public void setNickname(String text) {
		userManager.setNickname(text);
	}

	/**
	 * Set the mail of the user
	 * 
	 * @param text
	 *            The mail
	 */
	public void setMail(String text) {
		userManager.setMail(text);
	}

	/**
	 * Set the password of the user
	 * 
	 * @param text
	 *            the password
	 */
	public void setPassword(String text) {
		userManager.setPassword(text);
	}

	/**
	 * Set the birthdate of the user
	 * 
	 * @param date
	 */
	public void setBirthdate(Date date) {
		userManager.setBirthdate(date);
	}
	
	/**
	 * Get the user whose id is given in parameter
	 * 
	 * @param id
	 *            the id of the user
	 * @return The user if the id matches, null else
	 */
	public User getUserById(int id) {
		return this.userManager.getUserById(id);
	}

	
	
	
	

	
	
	
	// === STATS METHODS ===

	/**
	 * Return a list of Stats within a date range for a specific user
	 * 
	 * @param id
	 *            the id of the user
	 * @param dd
	 *            the start date
	 * @param df
	 *            the end date
	 * @return The list of stats
	 */
	public List<Stats> consultStats(int id, Date dd, Date df) {
		statsManager = StatsManager.getInstance();
		return this.statsManager.consultStats(id, dd, df);
	}

	/**
	 * Return the list of stats within a date range for all the users
	 * 
	 * @param dd
	 *            the start date
	 * @param df
	 *            the end date
	 * @return The list of stats
	 */
	public List<Stats> consultStats(Date dd, Date df) {
		statsManager = StatsManager.getInstance();
		return this.statsManager.consultStats(dd, df);
	}

	/**
	 * @return the number of stats entries in the database. Can be used in to adjust
	 *         the scale in a graph in the ui
	 */
	public int getNumberUserStats() {
		statsManager = StatsManager.getInstance();
		return this.statsManager.getNumber();
	}
	
	
	
	
	
	
	
	// === GROUP METHODS ===

	/**
	 * Create a new group, of which the current user is a member
	 * 
	 * @param groupName
	 *            the name of the group
	 * @return true if the group has been created
	 */
	public boolean createGroup(String groupName) {
		groupManager = GroupManager.getInstance();
		userGroupManager = userGroupManager.getInstance();
		groupManager.createGroup(groupName);

		int newGroupId = groupManager.getGroupId(groupName);

		return userGroupManager.createUserGroup(getUserId(), newGroupId);
	}

	/**
	 * Get the list of UserGroup for the user
	 * 
	 * @param userId
	 *            the id of the user
	 * @return The list of UserGroup
	 */
	public List<UserGroup> getUserGroupList(int userId) {
		userGroupManager = UserGroupManager.getInstance();
		return userGroupManager.getUserGroupList(userId);
	}

	/**
	 * Get the groups details for the UserGroup list
	 * 
	 * @param userGroupList
	 *            the UserGroup list
	 * @return a list of Group
	 */
	public List<Group> getGroupList(List<UserGroup> userGroupList) {
		GroupManager groupManager = GroupManager.getInstance();
		return groupManager.getGroupList(userGroupList);
	}

	/**
	 * @return the group manager
	 */
	public GroupManager getGroupManager() {
		return GroupManager.getInstance();
	}

	/**
	 * @return the UserGroupManager
	 */
	public UserGroupManager getUserGroupManager() {
		return UserGroupManager.getInstance();
	}
	
	
	/**
	 * @return the id of the currently selected group
	 */
	public int getSelectedGroupID() {
		groupManager = GroupManager.getInstance();
		return this.groupManager.getSelectedGroupId();
	}
	
	/**
	 * Remove the selected user from the selected group in the in the
	 * UserGroupManager
	 * 
	 * @return true if the user has been removed
	 */
	public boolean removeSelectedMember() {
		return UserGroupManager.removeMember();
	}
	
	/**
	 * @return the users of the currently selected group
	 */
	public List<User> getUserbyGroupId() {
		userGroupManager = UserGroupManager.getInstance();
		List<Integer> users = userGroupManager.getUsersIdGroupList(getSelectedGroupID());
		List<User> liste = userManager.getGroupUsers(users);
		return liste;
	}
	
	
	
	
	
	
	// === LISTS METHODS ===

	/**
	 * @return the ListManager
	 */
	public ListManager getListManager() {
		return ListManager.getInstance();
	}

	/**
	 * @return the shopping lists for the selectd group
	 */
	public List<GroupList> getShoppingList() {
		listManager = getListManager();
		return listManager.getShoppingList(getSelectedGroupID());
	}

	/**
	 * @return the ids of the selected lists
	 */
	public int getSelectedGroupListID() {
		return this.listManager.getGroupListId();
	}

	/**
	 * @return the selected GroupList
	 */
	public GroupList getSelectedGroupList() {
		listManager = ListManager.getInstance();
		return this.listManager.getSelected();
	}


	/**
	 * Add a new shopping List to the currently selected group
	 * 
	 * @param name
	 *            the name of the shopping List
	 * @return true if the shopping list has been created
	 */
	public boolean addShopList(String name) {
		return listManager.addShopList(name, this.getSelectedGroupID());
	}

	/**
	 * @return the name of the currently selected shoppinglist
	 */
	public String getListName() {
		return listManager.getNameSelected();
	}

	
	/**
	 * Change the name of the current shopping list
	 * 
	 * @param name
	 *            the new name
	 * @return true if the shopping list has been updated
	 */
	public boolean updateShopList(String name) {
		return listManager.updateShopList(name);
	}

	/**
	 * Remove the list selected
	 * 
	 * @return true if the list has been deleted
	 */
	public boolean removeSelectedList() {
		return listManager.removeList();
	}
	
	
	
	
	
	
	
	// === MESSAGES METHODS ===

	/**
	 * @return the messages of the group
	 */
	public List<Message> getMessages() {
		this.messageManager = messageManager.getInstance();
		return this.messageManager.getAllMessages();
	}

	/**
	 * @return the MessageManager
	 */
	private MessageManager getMessageManager() {
		this.messageManager = messageManager.getInstance();
		return this.messageManager;
	}

	/**
	 * Set the currently selected group as the selected group in the messageManager
	 */
	public void setMessageSelected() {
		this.getMessageManager().setSelected(this.groupManager.getSelected());
	}
	
	/**
	 * Send a message to the current group
	 * 
	 * @param text
	 *            The String containing the text of the message
	 * @return true if the message has been sent, false else
	 */
	public boolean sendMessage(String text) {
		return messageManager.sendMessage(text, this.userManager.getUser(), getGroupManager().getSelected());
	}



	
	
	
	
	// === PRODUCTS METHODS ===

	/**
	 * @return all the products in the database
	 */
	public List<GeneralProduct> getAllProducts() {
		this.productManager = ProductManager.getInstance();
		return this.productManager.getAllProducts();
	}

	/**
	 * Add a Custom product. This product will be linked to the currently selected
	 * group in the groupManager
	 *
	 * @param name
	 *            The name of the product
	 * @param image
	 *            The image of the product
	 * @param description
	 *            The description of the product
	 * @param idFather
	 *            The id of the Parent Product. Give a negative number or 0 if this
	 *            product doesn't have a parent Product
	 * @return true if the product has been created
	 */
	public boolean addProduct(String name, Image image, String description, int idFather) {
		this.productManager = ProductManager.getInstance();
		return this.productManager.addCustomProduct(name, image, description, idFather, groupManager.getSelected());
	}

	/**
	 * Search products whose name is like the string given in parameter or is a
	 * child product of the former.
	 *
	 * @param name
	 *            The name or part of the name of the product or parent product
	 * @return the List of products found
	 */
	public List<GeneralProduct> searchProducts(String name) {
		this.productManager = ProductManager.getInstance();
		return this.productManager.searchProducts(name);
	}
	

	/**
	 * Add a List of product to the current Shopping List
	 * 
	 * @param selectedProducts
	 *            A list containing the products to add
	 * @return true if the product have been added
	 */
	public boolean addProductsToShopList(List<GeneralProduct> selectedProducts) {
		listManager = ListManager.getInstance();
		return listManager.addProductsToShopList(selectedProducts);
	}

	/**
	 * Get a product
	 * 
	 * @param idProduct
	 *            the id of the product
	 * @return The product if the id matches, null else
	 */
	public GeneralProduct getProductById(int idProduct) {
		productManager = ProductManager.getInstance();
		return productManager.getProductById(idProduct);
	}

	/**
	 * @return all the subgeneralProducts in the database
	 */
	public List<GeneralProduct> getAllSubGeneralProducts() {
		productManager = ProductManager.getInstance();
		return productManager.getAllSubGeneralProducts();
	}

	/**
	 * @return all the product Bought for the current Shopping List
	 */
	public List<PricedProduct> getBoughtProducts() {
		listManager = ListManager.getInstance();
		listManager.getBoughtProducts(getSelectedGroupList());
		return getSelectedGroupList().getBoughtProducts();
	}

	/**
	 * @return the content of the current Shopping List
	 */
	public List<QuantifiedProduct> getShopList() {
		listManager = ListManager.getInstance();
		listManager.getShopList(getSelectedGroupList());
		return getSelectedGroupList().getShoppinglist();
	}

	/**
	 * Transfert the product from the Shopping List to the Bought Products List with
	 * the specified price
	 * 
	 * @param p
	 *            The product to transfer
	 * @param price
	 *            The price of the product when it was bought
	 */
	public void buyProduct(QuantifiedProduct p, Double price) {
		statsManager = StatsManager.getInstance();
		statsManager.addStat(getUserId(), price.floatValue() * p.getQuantity(), new Date());
		debtManager = DebtManager.getInstance();
		debtManager.addGroupDebt(getUserbyGroupId(), getUserId(), price * p.getQuantity());
		listManager = ListManager.getInstance();
		listManager.buyProduct(p, price);
	}
	
	/**
	 * Increase the quantity of the product by one in the shoppingList
	 * 
	 * @param p
	 *            The product to increase
	 */
	public void addOne(QuantifiedProduct p) {
		listManager = ListManager.getInstance();
		listManager.addOne(p);
	}

	/**
	 * Decrease the quantity of the product by one in the shoppingList
	 * 
	 * @param p
	 *            The product to decrease
	 */
	public void removeOne(QuantifiedProduct p) {
		listManager = ListManager.getInstance();
		listManager.removeOne(p);
	}

	/**
	 * Remove the product from the shopping list
	 * 
	 * @param p
	 *            The product to remove
	 */
	public void removeProductInShopList(QuantifiedProduct p) {
		listManager = ListManager.getInstance();
		listManager.remove(p);
	}
	
	

	

	
	
	// === DEPTS METHODS ===
	
	
	/**
	 * @return the dept of the user
	 */
	public List<UserDebt> getMyDebt() {
		debtManager = DebtManager.getInstance();
		return debtManager.getMyDebt(this.getUserId());
	}


	/**
	 * @return the dept the other users owe to the current user
	 */
	public List<UserDebt> getMyDue() {
		debtManager = DebtManager.getInstance();
		return debtManager.getMyDue(this.getUserId());
	}

	/**
	 * Set the dept as the current dept
	 * 
	 * @param debt
	 *            the dept to set
	 */
	public void setSelectedDebt(UserDebt debt) {
		debtManager = DebtManager.getInstance();
		debtManager.setSelectedDebt(debt);
	}

	/**
	 * @return the selected dept
	 */
	public UserDebt getSelectedDebt() {
		debtManager = DebtManager.getInstance();
		return debtManager.getSelectedDebt();
	}

	/**
	 * Update the currently selected dept
	 * 
	 * @return true if the dept has been updated
	 */
	public boolean updateDebt() {
		debtManager = DebtManager.getInstance();
		return debtManager.updateDebt(getSelectedDebt());
	}

}
