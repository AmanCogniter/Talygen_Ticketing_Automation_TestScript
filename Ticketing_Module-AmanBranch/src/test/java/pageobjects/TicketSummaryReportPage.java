package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketSummaryReportPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	AddTicketPage addTicketPage;
	String ticketNoText;
	static String subjectText;
	static String subjectTextFromReport;
	static String ticketStatus;
	static String ticketvalue;

	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd//yyyy");

	TicketListingPage ticketListingPage;

	public TicketSummaryReportPage(WebDriver driver) {

		super(driver, "Ticketing Summary Page");
		this.driver = driver;
		this.addTicketPage = new AddTicketPage(driver);
		this.ticketListingPage = new TicketListingPage(driver);
	}

	// click on full menu
	public void clickFullMenu() {
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.cssSelector("menuitem20"), "Ticketing", 20);
	}
//			click(By.cssSelector("#menuitem16"), "Ticketing", 20);

	// click on Side menu
	public void clickTicketingSideMenu() {
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on Ticket Report
	public void clickTicketReport() {
		click(By.xpath(
				"//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticket Report' and @id='cadmin_messageboard_link']"),
				"Ticket Report", 20);
	}

	// click on Ticket Summary
	public void clickTicketSummaryReport() {
		click(By.xpath("//a[@data-ordername='TicketSummary']"), "Ticket Summary", 20);
	}

	// enter Ticket Number
	public void enterTicketNumber() {
		ticketvalue = addTicketPage.ticketNoGenerated;
		enter(By.cssSelector("#ticketnumber"), ticketvalue, "enter ticket number", 20);

	}

	// get TicketNo Text
	public void ticketNoTextFromSearch() {
		staticWait(3000);
		switchToFrame();
		ticketNoText = gettextByJSexecuter(By.xpath("//table/tbody/tr[4]/td/div"), "", 20);
		logger.info("ticket no :: " + ticketNoText);
	}

	// get Ticket subject Text
	public void ticketSubjectFromSearch() {
		staticWait(3000);
		subjectTextFromReport = gettextByJSexecuter(By.xpath("//table/tbody/tr[4]/td[2]/div"), "", 20);
		logger.info("Subject from created ticket :: " + subjectTextFromReport);
	}

	public void verifyTicketNo() {
		String val1 = String.valueOf(addTicketPage.ticketNoGenerated);
		String val2 = String.valueOf(ticketNoText).replaceAll(".", "");

		subjectText = AddTicketPage.getTicketSubject;
		logger.info("subject" + AddTicketPage.ticketSubject);
		logger.info("subject report " + subjectTextFromReport);

		if (val1.contains(val2) && AddTicketPage.ticketSubject.equals(subjectTextFromReport)) {
			getTest().log(LogStatus.PASS, ticketvalue + " reference no. is matched as expected.");
		} else {
			getTest().log(LogStatus.FAIL, "reference no. is not matched as expected.");
			logger.debug("reference no. is not matched as expected.");
			takeScreenshot("verifyTicketNo");
			Assert.fail("verifyTicketNo");
		}
	}

	// enter Ticket Subject
	public void enterSubject() {
//		subjectText = AddTicketPage.getTicketSubject;
		enter(By.cssSelector("#subject"), AddTicketPage.ticketSubject, "enter ticket Subject", 20);
	}

	// click on Search
	public void clickSearch() {
		click(By.cssSelector("#aSearch"), "click on Search", 20);
		//findElementInVisibility(By.cssSelector("#reportViewer_AsyncWait_Wait"), 30);
	}

	public void switchToFrame() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		WebElement body = driver.findElement(By.tagName("tbody"));
	}

	// navigate to TicketReportPagea
	public void navigateToTicketReportPage() {
		pageNavigate(prop.getProperty("ticketSummaryReportUrl"), "Ticket summary Report Page");
	}

	// click on ticket no from report
	public void clickReportTicketNo() {
		click(By.xpath("//table/tbody/tr[4]/td/div"), "click on ticket no. on Report.", 20);

		
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs.get(1)); // switches to new tab
		 
		
	}
}
