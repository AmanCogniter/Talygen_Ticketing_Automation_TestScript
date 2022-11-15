package action;

import org.openqa.selenium.WebDriver;

import pageobjects.UnassignedTicketListPage;

public class UnassignedTicketsAction {

	WebDriver driver;

	UnassignedTicketListPage unassignedTicketListPage;

	public UnassignedTicketsAction(WebDriver driver) {
		this.unassignedTicketListPage = new UnassignedTicketListPage(driver);
		this.driver = driver;
	}

	public void navigateToUnassignedTickets() {
		unassignedTicketListPage.clickFullMenu();
		unassignedTicketListPage.clickTicketingSideMenu();
//		unassignedTicketListPage.clickTicketingOption();
		unassignedTicketListPage.clickUnassignedTickets();
	}

	public void validateUnassignedTicketsCount() {
		unassignedTicketListPage.verifyUnassignedTicketsCount();
	}

}