package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.TicketDetailReportAction;
import utils.WebTestBase;

public class TicketDetailReportTest extends WebTestBase {

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
		TicketDetailReportAction ticketDetailReportAction = new TicketDetailReportAction(driver);
		ticketDetailReportAction.enterTicketToSearch();
		//ticketDetailReportAction.searchButton();
	
	}
}
