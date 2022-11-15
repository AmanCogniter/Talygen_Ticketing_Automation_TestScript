package action;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.ExternalLinkPage;
import utils.PropertiesLoader;

public class ExternalLinkSupportAction{
	
	
	WebDriver driver;

	ExternalLinkSupportAction externalLinkSupportAction;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testadata ++.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ExternalLinkSupportAction(WebDriver driver) {
		this.externalLinkSupportAction = new ExternalLinkSupportAction(driver);
		this.driver = driver;
	}
	
}
