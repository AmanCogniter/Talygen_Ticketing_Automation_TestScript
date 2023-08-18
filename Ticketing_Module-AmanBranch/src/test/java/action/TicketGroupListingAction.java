package action;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketGroupListingPage;

public class TicketGroupListingAction {

	WebDriver driver;

	TicketGroupListingPage ticketGroupListingPage;

	public TicketGroupListingAction(WebDriver driver) {
		this.driver = driver;
		this.ticketGroupListingPage = new TicketGroupListingPage(driver);

	}

	public void navigateGroupListing() {
		ticketGroupListingPage.clickFullMenu();
		ticketGroupListingPage.clickOnFSMLocate();
//		ticketGroupListingPage.clickTicketingOption();
		ticketGroupListingPage.clickTicketingGroup();
	}

	public void clickAddGroupButton() {
		ticketGroupListingPage.clickAddGroup();
	}

	public void verifyTicketGroupListingUrl() {
		ticketGroupListingPage.validateTicketingGroupListingUrl();
	}

	public void verifyGroupNameSearched() {
		ticketGroupListingPage.searchByGroupName();
		ticketGroupListingPage.checkSearchedGroupName();
	}

	public void verifyResetNameSearched() {
		ticketGroupListingPage.searchByGroupName();
		ticketGroupListingPage.searchByGroupNameTextField();
		ticketGroupListingPage.clickResetButton();
		ticketGroupListingPage.searchByGroupName();
		ticketGroupListingPage.verifyResetSearched();
	}

	public void verifyButtonsVisibility() {
		ticketGroupListingPage.clickOnSelectAllCheckBox();
		ticketGroupListingPage.verifyHeaderButtons();
	}

}
