package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketingServiceBoardPage extends WebBasePage {

	WebDriver driver;

	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TicketingServiceBoardPage(WebDriver driver) {
		super(driver, "Ticketing Service Board Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), "Ticketing",
				20);
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}
	// click on Side menu
			public void clickOnFSMLocate() {
				clickByJavascript(By.xpath("//li[@data-name='FSM- Locate']/span"), "FSM Locate", 20);
			}

	// click on Manage Service Board
	public void clickServiceBoard() {
		staticWait(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement manageLayout = driver
				.findElement(By.xpath("(//div/ul/li/a[@data-original-title='Manage Layout'])[last()]"));
		js.executeScript("arguments[0].scrollIntoView();", manageLayout);
		
		click(By.xpath(
				"//div/ul/li/a[@data-original-title='Manage Service Board']"),
				"Manage Service Board", 20);
	}

	// verify Manage Service Board Url
	public void validateServiceBoardUrl() {
		getCurrentUrl(prop.getProperty("ticketingServiceBoardPageUrl"), "Manage Service Board Url");
	}

	// click on Service Board checkbox
	public void clickServiceBoardCheckbox() {
		clickByJavascript(
				By.cssSelector("#tblTicketChain > tbody > tr:nth-child(1) > td:nth-child(1) > div > div > label"),
				"click on service board checkbox", 30);
	}

	// verify Action buttons
	public void verifyActionButtonsAvailability() {
		toCheckElementIsDisplayed((By.xpath("//a[@id='ancActInact' and @data-original-title='Active']")), 30,
				"Action button ");
		toCheckElementIsDisplayed((By.xpath("//a[@id='ancActInact' and @data-original-title='Inactive']")), 30,
				"InActive button ");
		toCheckElementIsDisplayed((By.xpath("//a[@id='DeleteMultiple' and @data-original-title='Delete']")), 30,
				"Delete button ");
		toCheckElementIsDisplayed(
				(By.xpath("//a[@id='aAddticket' and @data-original-title='Add Ticket Service Board']")), 30,
				"Add Ticket Service Boad");
	}

	// click on add Ticket Service Board
	public void clickAddTicketServiceBoard() {
		click(By.xpath("//a[@data-original-title='Add Ticket Service Board' and @id='aAddticket']"),
				"add Ticket Service Board", 20);

	}

	// click Delete button
	public void clickDeleteButton() {
		click(By.xpath("//a[@id='DeleteMultiple' and @data-original-title='Delete']"), "Delete button", 20);
	}

	// verify URL Add ticket Service Board
	public void verifyAddTicketServiceBoardUrl() {
		getCurrentUrl(prop.getProperty("addServiceGroupUrl"), "Add ticket Service Board Url");
	}

	// verify column names
	public void verifyColumnsVisibility() {
		toCheckElementIsDisplayed(By.cssSelector("#th-TICKETSERVICEBOARDNAME"), 30, "add Ticket Service Board");
		toCheckElementIsDisplayed(By.cssSelector("#ticket_group_level"), 30, "Level column");
		toCheckElementIsDisplayed(By.cssSelector("#th-GROUPNAME"), 30, "Group name");
		toCheckElementIsDisplayed(By.cssSelector("#STATUS_NAME"), 30, "Status name");
	}

	// enter Ticket Service Board Name:
	public void enterTicketServiceBoardName() {
		enter(By.cssSelector("#TicketChainName"), prop.getProperty("enterTicketServiceBoardName") + datevalue,
				"Ticket Service board name.", 20);
	}

	// enter Description
	public void enterDescription() {
		enter(By.cssSelector("#Description"), datevalue + prop.getProperty("enterDescription"), "enter Description",
				20);
	}

	// select Level
	public void selectFirstLevel() {
		selectValueWithText(By.cssSelector("#GroupLevelId"), "Level 1", "Level 1 from dropdown", 20);
	}

	// select Level
	public void selectSecondLevel() {
		selectValueWithText(By.cssSelector("#GroupLevelId"), "Level 2", "Level 2 from dropdown", 20);
	}

	// select Group
	public void selectGroup() {
		selectValueWithText(By.cssSelector("#ddlTicketGroupIds"), "Group1", "Group1 from dropdown", 20);
	}

	// click on Save button
	public void clickSaveButton() {
		click(By.cssSelector("#aChainTicketSave"), "Save button.", 20);
	}

	// click on cancel button
	public void clickCancelButton() {
		click(By.cssSelector("#gobacktolistscreen"), "Cancel button.", 20);
	}

	// click on Service Board All checkbox
	public void selectAllCheckbox() {
		clickByJavascript(By.id("chkAll_0"), "Select service board all checkbox", 30);
	}

	// verify multiple checkbox selection
	public void verifyMultiCheckboxSelected() {
		validateCheckboxSelection(By.xpath(
				"//div[@class='custom-control custom-checkbox']//following::input[@class='chkItems custom-control-input' and @checked='checked' and @id='chk_1']"),
				"checked", 20, "Serviceboard");
	}

	// click ok button
	public void clickOkButton() {
		findElementVisibility(By.xpath("//div[@class='-body alert alert-warning p-3 mb-0']"), 30);
		click(By.xpath("//button[@data-bb-handler='confirm']"), "Ok button.", 20);
	}

	// verify delete message
	public void verifyDeleteServiceBoardSuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("deleteServiceBoardMessage"), 40);
	}

	// verify service board name
	public void clickOnServiceBoardName() {

		for (int i = 0; i <= 0; i++) {
			findMultipleElement(By.xpath("//thead[@class='thead-bg']//following::tbody//td//a"), 30).get(0).click();
		}
	}

	// verify URL Update Add ticket Service Board
	public void verifyUpdateServiceBoardUrl() {
		getCurrentUrl(prop.getProperty("updateServiceboardUrl"), "Update Add ticket Service Board Url");
	}

	// select last group from dropdown
	public void selectLastGroup() {
		click(By.xpath("//select[@class='form-control group text-truncate']//option[@value][last()]"),
				"select last group", 40);
	}

	// select second last group from dropdown
	public void selectSecondLastGroup() {
		click(By.xpath("//select[@class='form-control group text-truncate']//option[@value][last()-1]"),
				"select second last group", 40);
	}
}
