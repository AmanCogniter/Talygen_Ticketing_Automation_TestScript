package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddGroupAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.TicketGroupListingAction;
import utils.WebTestBase;

public class TicketingGroupTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyAddGroup() {

		test = getTest("TC_Ticketing_Group_14,16,17,18,26");
		new LoginAction(driver).logoutLogin();
		TicketGroupListingAction ticketingListingAction = new TicketGroupListingAction(driver);
		AddGroupAction addGroupAction = new AddGroupAction(driver);
		
		/*
		 * CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		 * companySetupAction.addSkill(); new LoginAction(driver).logoutLogin();
		 * 
		 */		ticketingListingAction.navigateGroupListing();
		ticketingListingAction.clickAddGroupButton();
		addGroupAction.addGroup();
		//addGroupAction.selectDeptSkills();
		addGroupAction.selectRouting();
		addGroupAction.addFirstUser();
		addGroupAction.addGroupConfiguration();
//		addGroupAction.validateCharactersLength();
		addGroupAction.saveButton();
	}

	@Test(priority = 1)
	public void verifyCancelButton() {

		test = getTest("TC_Ticketing_Group_23,27");
		new LoginAction(driver).logoutLogin();
		TicketGroupListingAction ticketingListingAction = new TicketGroupListingAction(driver);
		AddGroupAction addGroupAction = new AddGroupAction(driver);
		ticketingListingAction.navigateGroupListing();
		ticketingListingAction.clickAddGroupButton();
		addGroupAction.addGroup();
		addGroupAction.validateCharactersLength();
		addGroupAction.cancelButton();
		ticketingListingAction.verifyTicketGroupListingUrl();
	}

	@Test(priority = 2)
	public void verifyNoRecordsMessage() {

		test = getTest("TC_Ticketing_Group_24");
		new LoginAction(driver).logoutLogin();
		TicketGroupListingAction ticketingListingAction = new TicketGroupListingAction(driver);
		AddGroupAction addGroupAction = new AddGroupAction(driver);
		ticketingListingAction.navigateGroupListing();
		ticketingListingAction.clickAddGroupButton();
		addGroupAction.addGroup();
		addGroupAction.selectDeptSkills();
//		addGroupAction.addGroupConfiguration();
		addGroupAction.validateNoRecordsMessage();
	}
}
