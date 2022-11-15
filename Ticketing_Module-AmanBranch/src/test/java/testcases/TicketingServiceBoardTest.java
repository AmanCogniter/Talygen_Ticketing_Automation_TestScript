package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.TicketingServiceBoardAction;
import utils.WebTestBase;

public class TicketingServiceBoardTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyServiceboardElements() {
		test = getTest("TC_Ticketing_ServiceBoard_32,33,34,35,36,39");
		new LoginAction(driver).logoutLogin();
		TicketingServiceBoardAction ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
		ticketingServiceBoardAction.navigateToServiceBoard();
		ticketingServiceBoardAction.verifyServiceBoardPageUrl();
		ticketingServiceBoardAction.verifyButtonsVisibility();
		ticketingServiceBoardAction.verifyTicketServiceBoardPageUrl();
	}

	@Test(priority = 1)
	public void verifyAddServiceBoardGroupOne() {
		test = getTest("TC_Ticketing_ServiceBoaard_37,55,56,57");
		new LoginAction(driver).logoutLogin();
		TicketingServiceBoardAction ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
		ticketingServiceBoardAction.navigateToServiceBoard();
		ticketingServiceBoardAction.verifyTicketServiceBoardPageUrl();
		ticketingServiceBoardAction.addTicketServiceBoardLevelOne();
		ticketingServiceBoardAction.clickSaveButton();
		ticketingServiceBoardAction.deleteServiceBoardFunctionality();

	}

	@Test(priority = 2)
	public void verifyAddServiceBoardGroupTwo() {
		test = getTest("TC_Ticketing_ServiceBoaard_37,55,56,57");
		new LoginAction(driver).logoutLogin();
		TicketingServiceBoardAction ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
		ticketingServiceBoardAction.navigateToServiceBoard();
		ticketingServiceBoardAction.verifyTicketServiceBoardPageUrl();
		ticketingServiceBoardAction.addTicketServiceBoardLevelTwo();
		ticketingServiceBoardAction.clickSaveButton();
	}

	@Test(priority = 3)
	public void verifyCancelButtonFunctionality() {
		test = getTest("TC_Ticketing_ServiceBoard_37,55,56,57,58,50");
		new LoginAction(driver).logoutLogin();
		TicketingServiceBoardAction ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
		ticketingServiceBoardAction.navigateToServiceBoard();
		ticketingServiceBoardAction.verifyTicketServiceBoardPageUrl();
		ticketingServiceBoardAction.addTicketServiceBoardLevelOne();
		ticketingServiceBoardAction.cancelButton();
		ticketingServiceBoardAction.verifyServiceBoardPageUrl();
	}

	/*
	 * // public void verifyMultipleCheckboxSelection() { // test =
	 * getTest("TC_Ticketing_ServiceBoard_38"); // new
	 * LoginAction(driver).logoutLogin(); // TicketingServiceBoardAction
	 * ticketingServiceBoardAction = new TicketingServiceBoardAction(driver); //
	 * ticketingServiceBoardAction.navigateToServiceBoard(); //
	 * ticketingServiceBoardAction.verifyMultiCheckboxSelection(); // }
	 */
	
	/*
	 * @Test(dependsOnMethods = { "verifyAddServiceBoardGroupOne" }) public void
	 * verifyDeleteButtonFunctionality() { test =
	 * getTest("TC_Ticketing_ServiceBoard_40"); new
	 * LoginAction(driver).logoutLogin(); TicketingServiceBoardAction
	 * ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
	 * ticketingServiceBoardAction.deleteServiceBoardFunctionality(); }
	 */
	 

	@Test(priority = 4)
	public void verifyUpdateServiceBoardNavigation() {
		test = getTest("TC_Ticketing_ServiceBoard_42");
		new LoginAction(driver).logoutLogin();
		TicketingServiceBoardAction ticketingServiceBoardAction = new TicketingServiceBoardAction(driver);
		ticketingServiceBoardAction.navigateToServiceBoard();
		ticketingServiceBoardAction.verifyUpdateTicketScreen();
	}

}
