package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class UnassignedTicketListPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public UnassignedTicketListPage(WebDriver driver) {
		super(driver, "Unassigned Ticket List Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		staticWait(3000);
		click(By.cssSelector("#menuitem22  a"), "Ticketing", 20);
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on Unassigned Tickets
	public void clickUnassignedTickets() {
		staticWait(3000);
		click(By.xpath(
				"//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Unassigned Tickets' and @id='cadmin_messageboard_link']"),
				"Unassigned Tickets", 20);
	}

	// get Text of Unassigned count
	public void verifyUnassignedTicketsCount() {

		String unassignedTickets = getText(By.xpath("//div[@id='divMinWidgetDetailChild']//ul[1]/li[@class='one_wid']//h3"),
				20);
		unassignedTickets = unassignedTickets.replaceAll("\\D+", "");

		logger.info("Unassigned tickets count " + unassignedTickets);

		String countFromBottom = getText(By.xpath("//span[@class='ml-2']"), 20);
		countFromBottom = countFromBottom.replaceAll("\\D+", "");

		logger.info("Bottom tickets count :: " + countFromBottom);

		if (countFromBottom.contains(unassignedTickets)) {
			getTest().log(LogStatus.PASS, "Unassigned tickets count From Bottom is matched:: " + unassignedTickets);
			logger.info("Unassigned tickets count From Bottom :: " + unassignedTickets);
		} else {
			getTest().log(LogStatus.FAIL, "Unassigned tickets count From Bottom is not matched:: " + unassignedTickets);
			logger.info("Unassigned tickets count From Bottom :: " + unassignedTickets);
			takeScreenshot("CountofTicketsisnotmatched");
			Assert.fail("Count of Tickets is not matched" + countFromBottom);
		}
	}
}
