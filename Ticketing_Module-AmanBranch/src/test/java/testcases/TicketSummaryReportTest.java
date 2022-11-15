package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.TicketListingAction;
import action.TicketSummaryReportAction;
import utils.WebTestBase;

public class TicketSummaryReportTest extends WebTestBase {

	@Test(priority = 0)
	public void verifySearchTicket() {

		test = getTest("TC_Ticketing_Ticketing_Detail_Report");
		
		   new LoginAction(driver).logoutLogin();  
		   CompanySetupAction companySetupAction = new CompanySetupAction(driver); 
		  companySetupAction.navigateToCompanySetupUser(); 
		  companySetupAction.addUser(); 
		  companySetupAction.addDepartmentNotVisibleClient(); 
		  new LoginAction(driver).logoutLogin();  
		  AddTicketAction addTicketAction = new AddTicketAction(driver);  
		  addTicketAction.navigatetoAddTicket(); 
		  addTicketAction.addTicket();
		TicketSummaryReportAction ticketSummaryReportAction = new TicketSummaryReportAction(driver);
		new LoginAction(driver).logoutLogin();
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.enterTicketToSearch();
		ticketSummaryReportAction.searchButton();
		ticketSummaryReportAction.validateSearchedValues();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
//		new LoginAction(driver).logoutLogin();
		ticketListingAction.verifyTicketValuesFromReport();
	}
}
