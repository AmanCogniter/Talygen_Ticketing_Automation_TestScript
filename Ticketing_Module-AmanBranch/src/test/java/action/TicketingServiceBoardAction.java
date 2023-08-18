package action;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketingServiceBoardPage;
import utils.PropertiesLoader;

public class TicketingServiceBoardAction {

	WebDriver driver;

	TicketingServiceBoardPage ticketServiceBoardPage;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TicketingServiceBoardAction(WebDriver driver) {
		this.ticketServiceBoardPage = new TicketingServiceBoardPage(driver);
		this.driver = driver;
	}

	public void navigateToServiceBoard() {
		ticketServiceBoardPage.clickFullMenu();
		ticketServiceBoardPage.clickOnFSMLocate();
//		ticketServiceBoardPage.clickTicketingOption();
		ticketServiceBoardPage.clickServiceBoard();
	}

	public void verifyServiceBoardPageUrl() {
		ticketServiceBoardPage.validateServiceBoardUrl();
		ticketServiceBoardPage.clickServiceBoardCheckbox();
	}

	public void verifyButtonsVisibility() {
		ticketServiceBoardPage.clickServiceBoardCheckbox();
		ticketServiceBoardPage.verifyActionButtonsAvailability();
		ticketServiceBoardPage.verifyColumnsVisibility();
	}

	public void verifyTicketServiceBoardPageUrl() {
		ticketServiceBoardPage.clickAddTicketServiceBoard();
		ticketServiceBoardPage.verifyAddTicketServiceBoardUrl();
	}

	public void cancelButton() {
		ticketServiceBoardPage.clickCancelButton();
	}

	public void addTicketServiceBoardLevelOne() {

		ticketServiceBoardPage.enterTicketServiceBoardName();
		ticketServiceBoardPage.enterDescription();
		ticketServiceBoardPage.selectFirstLevel();
		ticketServiceBoardPage.selectLastGroup();
	}
	
	public void addTicketServiceBoardLevelTwo() {

		ticketServiceBoardPage.enterTicketServiceBoardName();
		ticketServiceBoardPage.enterDescription();
		ticketServiceBoardPage.selectSecondLevel();
		ticketServiceBoardPage.selectSecondLastGroup();
	}
	
	public void clickSaveButton() {

		ticketServiceBoardPage.clickSaveButton();
	}

	public void selectMultipleCheckbox() {
		ticketServiceBoardPage.selectAllCheckbox();
		ticketServiceBoardPage.verifyMultiCheckboxSelected();

	}
	public void deleteServiceBoardFunctionality() {
		ticketServiceBoardPage.clickServiceBoardCheckbox();
		ticketServiceBoardPage.clickDeleteButton();
		ticketServiceBoardPage.clickOkButton();
		ticketServiceBoardPage.verifyDeleteServiceBoardSuccessMessage();
	}
	
	public void verifyUpdateTicketScreen() {
		ticketServiceBoardPage.clickOnServiceBoardName();
		ticketServiceBoardPage.verifyUpdateServiceBoardUrl();	
	}
}
