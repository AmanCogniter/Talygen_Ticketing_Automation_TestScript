package action;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.TicketListingPage;
import pageobjects.UpdateTicketPage;
import utils.PropertiesLoader;

public class TicketListingAction extends TicketListingPage {

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;
	AddTicketAction addTicketAction;
	TicketListingPage ticketListingPage;
	UpdateTicketPage updateTicketPage;

	public TicketListingAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.addTicketAction = new AddTicketAction(driver);
		this.ticketListingPage = new TicketListingPage(driver);
		this.updateTicketPage = new UpdateTicketPage(driver);
	}

	public void navigatetoTicketListing() {
		addTicketAction.clickFullMenu();
		addTicketAction.clickTicketingSideMenu();
//		addTicketAction.clickTicketingOption();
		clickTicketing();
	}

	public void clickTicketing() {
		ticketListing();
	}

	public void clickHome() {
		homeBreadcrumb();
	}

	public void verifyhomePageUrl() {
		validateUrlOfHomePage();
	}

	public void clickOnTicketNumber() {
		ticketNumber();
	}

	public void ticketNumberValues() {
		enterValueInTicketNo();
	}

	public void resetButton() {
		clickOnResetButton();
	}

	public void ticketNoPlaceholderValue() {
		ticketNoPlaceholder();
	}

	public void actionButton() {
		clickOnActionButton();
	}

	public void viewButton() {
		clickOnViewButton();
	}

	public void viewTicket() {
		actionButton();
		viewButton();

	}

	public void checkExpandCollapseFunctionality() {
		collapseButton();
		expandButtonFunctionality();
	}

	public void collapseButton() {
		clickCollapseButton();
	}

	public void expandButtonFunctionality() {
		collapseExpandFunctionality();
	}

	public void validateSearch() {
		enterTicketNumber();
		clickSearchIcon();
		matchSearchedValues();
	}

	public void validateSearchWithResetButton() {
		validateSearch();
		resetButton();
		matchSearchWithResetButton();
	}

	public void unassignedTicketWidget() {
		clickUnassignedWidget();
		verifyTicketStatus();
		clickOnHoldWidgets();
	}

	public void verifyReplyFunctionality() {
		clickOnReplyButton();
		clickOnShowAddTicket();
		selectCannedReply();
		addTicketAction.uploadDocument();
		clickOnSubmitReply();
		pageRefresh("Page refreshed ");
		clickOnReplyButton();
		validateCountOfReplyButton("reply count");
		verifyCannedReplies();
	}

	public void verifyFollowUp() {
		clickOnActionButton();
		clickFollowUp();
		clickAddFollowUp();
		checkFollowUpPopup();
		clickOnDatePicker();
		clickOnTimePicker();
		//selectTime();
		
		enterFollowUpComment();
		saveFollowUp();
		followUpSuccessMessage();
	}

	public void verifyMergeButton() {
		actionButton();
		viewButton();
		updateTicketPage.clickMergeButton();
	}

	public void verifyDeleteTicket() {
		actionButton();
		clickDeleteButton();
		clickOnDeletePopUp();
		// unable to capture delete message
//		deleteRecordMessage();

	}

	public void navigateTicketListing() {

		navigateToTicketListingPage();

	}

	public void verifyWidgets() {
		checkWidgets();
	}

	public void validateSolvedCount() {
		clickAssignedTo();
		verifyStatusByResolver();
		enterTodaysOpenedDate();
		clickSearchIcon();
		verifyTodayStatusByResolver();
	}

	public void validateLastMonthResolverSolvedCount() {
		clickAssignedTo();
		verifyStatusByResolver();
		//enterLastMonthOpenedDate();
		clickSearchIcon();
	   verifyTodayStatusByResolver();
	}

	public void verifyTicketNoFromListing() {
		verifyTicketValuesFromReport();
	}

	public void verifySLATooltip() {
		mouseHover();
	}

}
