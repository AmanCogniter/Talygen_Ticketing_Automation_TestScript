package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.CompanySetupAction;
import action.LoginAction;
import utils.WebTestBase;

public class CompanySetupConfiguration extends WebTestBase {

	@Test(priority = 0)
	public void addNewUser() {
		test = getTest("TC_Ticketing_Company_Setup_UserConfiguration");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		
		  companySetupAction.navigateUsersListScreen();
		   companySetupAction.deleteUser();
		  companySetupAction.addNewUsers();
		  //companySetupAction.addSkills();
		 
	}

	@Test(priority = 1)
	public void addChannel() {
		test = getTest("TC_Ticketing_Company_Setup_UserConfiguration");

		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		new LoginAction(driver).logoutLogin();
//		companySetupAction.navigateUsersListScreen();
		companySetupAction.addChannelTab();
	}

	@Test(priority = 3)
	public void addUserAndDepartment() {
		test = getTest("TC_Ticketing_Company_Setup_UserConfiguration");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
	}
}
