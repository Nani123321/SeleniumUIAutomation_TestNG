package com.orangeHRM.Framework.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProperyFileReader implements ConfigReader{
	private static Properties properties;
    public ProperyFileReader(String fileName) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
        } catch (IOException ex) {
            System.out.println("Error loading properties file: " + ex.getMessage());
        }
    }
	    @Override
	    public String getUrl() {
	        return properties.getProperty("url");
	    }

	    public String getUserName() {
	        return properties.getProperty("username");
	    }

	    public String getPassWord() {
	       
				return properties.getProperty("password");
	    }

	   	   

}
