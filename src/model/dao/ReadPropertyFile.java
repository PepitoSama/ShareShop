package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

public class ReadPropertyFile {
	
	/**
	 * Method used to get values from a .properties file stored in ressources/config/
	 * Note, could be improved by using prop.keySet() method instead of providing Hashtable
	 * @param fileName The config file name to read
	 * @param toGet A Hashtable containing keys of wanted values
	 * @return Hashtable<String, String>
	 * @throws IOException
	 */
	public static Hashtable<String, String> getValues(String fileName, Hashtable<String, String> toGet) throws IOException{
		try {
			Properties prop = new Properties();
			FileInputStream is = new FileInputStream("ressources/config/" + fileName + ".properties");
			prop.load(is);
			for(String key : toGet.keySet()) {
				toGet.put(key, prop.getProperty(key));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return toGet;
	}
}
