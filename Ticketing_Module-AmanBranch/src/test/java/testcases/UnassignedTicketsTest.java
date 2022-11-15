package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.UnassignedTicketsAction;
import utils.WebTestBase;

public class UnassignedTicketsTest extends WebTestBase {

	@Test(priority = 1)
	public void verifyUnassignedTicketsCount() {
		test = getTest("TC_Ticketing_Unassigned_Tickets");
		new LoginAction(driver).logoutLogin();
		UnassignedTicketsAction unassignedTicketsAction = new UnassignedTicketsAction(driver);
		unassignedTicketsAction.navigateToUnassignedTickets();
		unassignedTicketsAction.validateUnassignedTicketsCount();
	}
}
