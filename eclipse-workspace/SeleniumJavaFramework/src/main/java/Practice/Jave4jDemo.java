package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Jave4jDemo {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(Jave4jDemo.class);

		logger.info("This is info log test");
		logger.warn("This is warning log test");
		logger.error("This is error log test");
		logger.fatal("This is fatal log test");


		try {
			String projPath = System.getProperty("user.dir");
			Properties prop = new Properties();
			InputStream input = new FileInputStream(projPath+"/src/test/resources/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			
			OutputStream output = new FileOutputStream(projPath+"/src/test/resources/config.properties");
			prop.setProperty("browser", "IE");
			prop.store(output, null);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
