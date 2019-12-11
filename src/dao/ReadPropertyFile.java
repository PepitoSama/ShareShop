package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Properties;

public class ReadPropertyFile {
	
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
