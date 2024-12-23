package com.orangeHRM.Framework.LogUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtilities {
	
	 public static Logger getLogger(Class<?> clazz) {
	        return LogManager.getLogger(clazz);
	    }

}
