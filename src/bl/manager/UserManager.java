package bl.manager;

import model.dao.AbstractDAOFactory;
import model.dao.UserDAO;
import model.domain.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import model.dao.*;

public class UserManager {

    User user = null;

    public UserManager(String username, String password, String firstname, String lastname, Date birthdate, String email) {
        String hashed;
        try {
            hashed = hashPassword(password, username);
            this.setUser(new User(username, hashed, firstname, lastname, birthdate, email));
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public UserManager() {
    }

    // Can be improved
    // Source : https://www.geeksforgeeks.org/sha-256-hash-in-java/
    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    // End Source

    public String hashPassword(String password, String username) throws NoSuchAlgorithmException {
        String toHash = username + password;
        String hashed = null;
        try {
            hashed = toHexString(getSHA(toHash));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return hashed;
    }

    public boolean register(String username, String password, String firstname, String lastname, Date birthdate, String email, String passwordC) throws Exception {

        DAO<User> dao = AbstractDAOFactory.getInstance().getUserDAO();
        User u;
        checkExisting(email, username);
        if (!password.equals(passwordC)) {
            throw new Exception("Les mots de passent ne correspondent pas");
        }
        try {
            u = new User(username, hashPassword(password, username), firstname, lastname, birthdate, email);
            return dao.save(u);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean login(String name, String pwd) {

        DAO<User> dao = AbstractDAOFactory.getInstance().getUserDAO();
        User u = dao.get(name);

        if (u != null) {
            try {
                if (hashPassword(pwd, name).equals(u.getPassword())) {
                    user = u;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return user != null;
    }

    public void checkExisting(String mail, String nickname) throws Exception {
        DAO<User> dao = AbstractDAOFactory.getInstance().getUserDAO();
        List<User> users = dao.getAll();
        boolean res = false;
        for (User u : users) {
            if (u.getNickname().equals(nickname)) {
                throw new Exception("Nickname already use");
            }
            if (u.getEmail().equals(mail)) {
                throw new Exception("Mail already use");
            }
        }
    }
}