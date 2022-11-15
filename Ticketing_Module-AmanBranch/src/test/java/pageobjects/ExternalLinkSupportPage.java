package pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExternalLinkSupportPage extends WebBasePage{

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;

	public ExternalLinkSupportPage(WebDriver driver) {
		super(driver, "ExternalLink Support Page");
		this.driver = driver;
	}
	
	// click Advanced button
	public void clickAdvancedButton() {
		click(By.cssSelector("#details-button"), "Advanced button", 20);
	}

	// click Advanced button
	public void clickProceed() {
		click(By.cssSelector("#proceed-link"), "Advanced button", 20);
	}
	
	
}
