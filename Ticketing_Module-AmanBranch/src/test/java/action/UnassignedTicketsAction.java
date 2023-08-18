package action;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketListingPage;
import pageobjects.UnassignedTicketListPage;

public class UnassignedTicketsAction {

	WebDriver driver;

	UnassignedTicketListPage unassignedTicketListPage;
	TicketListingPage ticketListingPage;
	AddTicketAction addTicketAction;

	public UnassignedTicketsAction(WebDriver driver) {
		this.unassignedTicketListPage = new UnassignedTicketListPage(driver);
		this.addTicketAction = new AddTicketAction(driver);
		this.ticketListingPage = new TicketListingPage(driver);
		this.driver = driver;
	}

	public void navigateToUnassignedTickets() {
		//unassignedTicketListPage.clickFullMenu();
		//unassignedTicketListPage.clickTicketingSideMenu();
//		unassignedTicketListPage.clickTicketingOption();
		//unassignedTicketListPage.clickUnassignedTickets();
		addTicketAction.clickFullMenu();
		addTicketAction.clickOnFSMLocate();
		addTicketAction.clickTicketingSideMenu();
		ticketListingPage.clickOnListView();
	}

	public void validateUnassignedTicketsCount() {
		unassignedTicketListPage.verifyUnassignedTicketsCount();
	}

}