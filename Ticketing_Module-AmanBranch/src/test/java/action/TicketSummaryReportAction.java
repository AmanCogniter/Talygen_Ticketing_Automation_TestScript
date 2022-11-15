package action;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketDetailReportPage;
import pageobjects.TicketListingPage;
import pageobjects.TicketSummaryReportPage;

public class TicketSummaryReportAction {

	WebDriver driver;
	TicketDetailReportPage ticketDetailReportPage;
	TicketListingPage ticketListingPage;
	AddTicketAction addTicketAction;
	TicketSummaryReportPage ticketSummaryReportPage;
	
	public TicketSummaryReportAction(WebDriver driver) {
		this.ticketSummaryReportPage	= new TicketSummaryReportPage(driver);
		this.ticketListingPage = new TicketListingPage(driver);
		this.addTicketAction = new AddTicketAction(driver);
		this.driver = driver;
	}

	public void navigateToTicketingReport() {
		ticketSummaryReportPage.clickFullMenu();
		ticketSummaryReportPage.clickTicketingSideMenu();
//		ticketSummaryReportPage.clickTicketingOption();
		ticketSummaryReportPage.clickTicketReport();
		ticketSummaryReportPage.clickTicketSummaryReport();
	}

	public void enterTicketNo() {
		addTicketAction.ticketSearch();
	}

	public void searchButton() {
		ticketSummaryReportPage.clickSearch();
	}

	public void enterTicketToSearch() {
		ticketSummaryReportPage.enterTicketNumber();
		ticketSummaryReportPage.enterSubject();
	}

	public void validateSearchedValues() {
		ticketSummaryReportPage.ticketNoTextFromSearch();
		ticketSummaryReportPage.ticketSubjectFromSearch();
		ticketSummaryReportPage.verifyTicketNo();
		ticketSummaryReportPage.clickReportTicketNo();
	}
}
