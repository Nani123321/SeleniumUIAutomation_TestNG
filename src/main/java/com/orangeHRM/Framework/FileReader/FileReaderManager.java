package com.orangeHRM.Framework.FileReader;

import java.nio.file.Paths;

public class FileReaderManager {
	 private static FileReaderManager instance; // Singleton instance
	 private ProperyFileReader propertyFileReader;
	    // Private constructor to prevent instantiation
	    private FileReaderManager() {}

	    // Method to get the single instance
	    public static FileReaderManager getInstance() {
	        if (instance == null) {
	            instance = new FileReaderManager(); // Create instance if it doesn't exist
	        }
	        return instance;
	    }

	    // Method to get the PropertyFileReader
	    public ProperyFileReader getPropertyFileReader() {
	        if (propertyFileReader == null) {
	            String userDir = System.getProperty("user.dir");
	            String configPath = Paths.get(userDir, "src", "test", "resources", "config.properties").toString();
	            propertyFileReader = new ProperyFileReader(configPath);

	            System.out.println("File reader path: " + configPath);
	        }
	        return propertyFileReader;
	    }
}


