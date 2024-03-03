package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropReader {
public static String readproperties(String key) throws Exception {
	String value="";
	String path=System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
	Properties prop =new Properties();
	FileInputStream fis=new FileInputStream(path);
	try {
		prop.load(fis);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	value=prop.getProperty(key);
	
	return value;
}
}
