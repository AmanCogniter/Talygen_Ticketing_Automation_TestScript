package testcases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddSLAAction;
import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.SLAAction;
import action.TicketListingAction;
import utils.WebTestBase;

public class AddSLA extends WebTestBase {

	@Test(priority = 15)
	public void addTicketForSLA() {
		test = getTest("TC_Ticketing_Add_Ticket_SLA");
		 new LoginAction(driver).logoutLogin(); 
		 CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		  companySetupAction.navigateToCompanySetupUser();
		  companySetupAction.addUser();
		  companySetupAction.addDepartmentNotVisibleClient();
		  //companySetupAction.addDepartmentVisibleToClient();
		  //companySetupAction.addUserGeneralSettings();
		  //companySetupAction.addUserAdvanceSettingsforSLA();
		 
			new LoginAction(driver).logoutLogin();
			AddSLAAction addSLAAction = new AddSLAAction(driver);
			AddTicketAction addTicketAction = new AddTicketAction(driver);
			SLAAction slaAction = new SLAAction(driver);
			addTicketAction.navigatetoSLA();
			slaAction.clickAddNewSLA();
			addSLAAction.addSLA();
		 
		new LoginAction(driver).logoutLogin();
		//AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketForSLA();
		new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigatetoTicketListing();
		ticketListingAction.verifySLATooltip();
	
	}
}
