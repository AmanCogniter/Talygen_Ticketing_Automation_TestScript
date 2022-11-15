package action;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketListingPage;
import pageobjects.TicketDetailReportPage;

public class TicketDetailReportAction {

	WebDriver driver;
	TicketDetailReportPage ticketDetailReportPage;
	TicketListingPage ticketListingPage;
	AddTicketAction addTicketAction;

	public TicketDetailReportAction(WebDriver driver) {
		this.ticketDetailReportPage = new TicketDetailReportPage(driver);
		this.ticketListingPage = new TicketListingPage(driver);
		this.addTicketAction = new AddTicketAction(driver);
		this.driver = driver;
	}

	public void navigateToTicketingReport() {
		ticketDetailReportPage.clickFullMenu();
		ticketDetailReportPage.clickTicketingSideMenu();
//		ticketDetailReportPage.clickTicketingOption();
		ticketDetailReportPage.clickTicketReport();
	}

	public void enterTicketNo() {
		addTicketAction.ticketSearch();
	}

	public void searchButton() {
		ticketDetailReportPage.clickSearch();
	}

	public void enterTicketToSearch() {
		ticketDetailReportPage.navigateToTicketReportPage();
		ticketDetailReportPage.enterTicketNumber();
		ticketDetailReportPage.enterSubject();
	}

	public void validateSearchedValues() {
		ticketDetailReportPage.ticketNoTextFromSearch();
		ticketDetailReportPage.ticketSubjectFromSearch();
		ticketDetailReportPage.verifyTicketNo();
	}

	public void verifyStatusWidgetByYear() {
		ticketDetailReportPage.clickSelectStatus();
		ticketDetailReportPage.verifyStatusWidgetValues();
	}

	public void statusWidgetValues() {
		ticketDetailReportPage.verifyStatusWidgetValues();
	}

	public void verifyCategoryWidgetCount() {
		ticketDetailReportPage.verifyCategoryStatusValues();
	}

	public void enterToSearch() {
		ticketDetailReportPage.navigateToTicketReportPage();
		ticketDetailReportPage.enterTicketNumber();
		ticketDetailReportPage.enterSubject();
	}

	public void verifyThisMonthCount() {
		ticketDetailReportPage.verifyStatusValues();
	}

	public void verifyProductWidgetValues() {
		ticketDetailReportPage.verifyProductWidgetCount();
	}

	public void verifyChannelWidgetValue() {
		ticketDetailReportPage.verifyChannelWidgetValues();
	}

}
