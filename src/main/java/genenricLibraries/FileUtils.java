package genenricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtils {
//cannot invoke these classes directly no main methods
	/**
	 * this method used to read data from property file
	 * @author
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public String readDataFromPropertyFile(String key) throws Exception {
		FileInputStream fis=new FileInputStream(IPathConstants.filePath);
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
}

