import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;  

public class UserManager {
	
	User user = null;
	
	public UserManager(String username, String password, String firstname, String lastname, String birthdate, String email) {
		String hashed;
		try {
			hashed = hashPassword(password, username);
			this.setUser(new User(username, hashed, firstname, lastname, birthdate, email));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Can be improved
	// Source : https://www.geeksforgeeks.org/sha-256-hash-in-java/
	public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    }
	// End Source
    
	
	public String hashPassword(String password, String username) throws NoSuchAlgorithmException{
		String toHash = username + password;
		String hashed = null;
		try {
			hashed =  toHexString(getSHA(toHash));
		} catch (NoSuchAlgorithmException e) {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }
		return hashed;
	}
	
	public boolean register() {
		UserDAO dao = new UserDAO();
		return dao.save(this.getUser());
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
