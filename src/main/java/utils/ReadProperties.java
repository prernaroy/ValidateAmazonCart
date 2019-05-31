package utils;

//-----------------------------------------------------------------------------------------------------------
//Description    :   Read properties file 
//Creator        :   Sapna Bansal
//Create         :   
//Modified on/By :   -
//-----------------------------------------------------------------------------------------------------------

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadProperties {

	/**
	 * This function will return the value for the provided property key
	 * 
	 * @param propertyKey
	 *            the key value from Testing.properties file
	 * @return String containing the path mentioned in testing.properties for
	 *         specific property key
	 */
	private static final Logger lowlevellogsobj = Logger.getLogger(ReadProperties.class);
	
	public static String readProperty(String propertyKey) {

		Properties prop = new Properties();
		File dir1 = new File(".");
		String strBasePath = null;
		String val = null;
		try {
			// read the data from the properties file
			strBasePath = dir1.getCanonicalPath();
			prop.load(new FileInputStream(strBasePath + File.separator + "Resources" + File.separator + "Config"
					+ File.separator + "Testing.properties"));
			val = prop.getProperty(propertyKey);
		} catch (FileNotFoundException e) {
			lowlevellogsobj.error(
					"FileNotFoundException in readProperty: " + e.getMessage(),
					e);
		} catch (IOException e) {
			lowlevellogsobj.error(
					"IOException in readProperty: " + e.getMessage(), e);
		}
		return val;
	}
}