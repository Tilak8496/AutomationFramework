package genericUtlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of methof related to property file
 */

public class PropertyFileUtility {
	/**
	 * This method is used to read data from property file provided key
	 * 
	 * @param Key
	 * @return
	 * @throws IOException
	 */

	public String toReadDatFromPropertyFile(String Key) throws IOException {
		FileInputStream fis = new FileInputStream(IconstantUtility.propertyFilepath);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}

}
