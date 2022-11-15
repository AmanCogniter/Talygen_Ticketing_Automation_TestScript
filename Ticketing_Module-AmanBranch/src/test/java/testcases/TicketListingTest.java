package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.TicketListingAction;
import action.UpdateTicketAction;
import utils.WebTestBase;

public class TicketListingTest extends WebTestBase {
	@Test(priority = 0)
	public void verifyUrlOnClickingBreadCrumb() {

		test = getTest("TC_Ticketing_TicketListing_60");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickHome();
		ticketListingAction.verifyhomePageUrl();
	}

	@Test(priority = 1)
	public void verifyResetButtonFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_62,72,69,73,91");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.ticketNumberValues();
		ticketListingAction.resetButton();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.ticketNoPlaceholderValue();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.checkfunctionalityOfClaimButton();
	}

	@Test(priority = 2)
	public void verifyExpandCollapseFeature() {

		test = getTest("TC_Ticketing_TicketListing_61");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.checkExpandCollapseFunctionality();
	}

	@Test(priority = 3)
	public void verifySearchFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_66");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.clickOnTicketNumber();
		ticketListingAction.validateSearch();
		ticketListingAction.validateSearchWithResetButton();
	}

	@Test(priority = 4)
	public void verifyUnassignedTicketWidget() {

		test = getTest("TC_Ticketing_TicketListing_118,119");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.unassignedTicketWidget();
	}

	@Test(priority = 5)
	public void verifyReplyCount() {

		test = getTest("TC_Ticketing_TicketListing_74,75,93");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		ticketListingAction.verifyReplyFunctionality();
	}

	@Test(priority = 6)
	public void verifyFollowUpFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_70,77,108");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver) ;
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		ticketListingAction.verifyFollowUp();
	}

	@Test(priority = 7)
	public void verifyMergeButtonFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_71");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyMergeButtonFunctionality();
	}

	@Test(priority = 8)
	public void verifyUpdateTicketFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_76,87,109,102,101,104,105");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addticketAction = new AddTicketAction(driver);
		addticketAction.navigatetoAddTicket();
		addticketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.updateTicket();
	}

	@Test(priority = 9)
	public void verifyDeleteTicketFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_78,79,68");
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.verifyDeleteTicket();
		new LoginAction(driver).logoutLogin();
		ticketListingAction.navigatetoTicketListing();
	}

	@Test(priority = 10)
	public void verifyNotesFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_84,85,86");
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		updateTicketAction.verifyAddNotesFunctionality();
		updateTicketAction.verifyEditNotesFunctionality();
		updateTicketAction.verifyDeleteNotesFunctionality();
	}

	@Test(priority = 11)
	public void verifyAttachmentTabFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_94");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		addticketAction.navigatetoAddTicket();
		addticketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		updateTicketAction.clickOnAttachmentTab();
	}

	@Test(priority = 12)
	public void verifyWidgetsFunctionality() {

		test = getTest("TC_Ticketing_TicketListing_117");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.verifyWidgets();
	}

	@Test(priority = 13)
	public void verifyCannedReplyFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_93");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		addticketAction.navigatetoAddTicket();
		addticketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyCannedReplies();
	}

	@Test(priority = 14)
	public void verifyDraftReplyFunctionality() {
		test = getTest("TC_Ticketing_TicketListing_88");
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		AddTicketAction addticketAction = new AddTicketAction(driver);
		addticketAction.navigatetoAddTicket();
		addticketAction.addTicketOnSelf();
		new LoginAction(driver).logoutLogin();
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.viewTicket();
		UpdateTicketAction updateTicketAction = new UpdateTicketAction(driver);
		updateTicketAction.verifyTicketReplyDraftedFunctionality();
	}
}
