package testcases;

import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddSLAAction;
import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.SLAAction;
import utils.WebTestBase;

public class SLATest extends WebTestBase {

	@Test(priority = 0)
	public void verifyAddSLA() {

		test = getTest("TC_Ticketing_SLA_157,163,166,188,177,179,187");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.addSLA();
		slaAction.searchPolicy();
		slaAction.verifyUpdateStatus();
	}

	@Test(priority = 1)
	public void verifyMandatoryValidation() {
		test = getTest("TC_Ticketing_SLA_159");
		
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction=
		 * new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		 
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.addSLAWithoutMandatoryField();
	}

	@Test(priority = 2)
	public void VerifyCharactersValidation() {
		test = getTest("TC_Ticketing_SLA_162,160");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction=
		 * new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.validateCharactersLength();

	}
	@Test(priority=3)
	public void verifyRadioButtonsFunctionality() {
		test = getTest("TC_Ticketing_SLA_165");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction=
		 * new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.verifySelectedButton();
	}

	@Test(priority = 4)
	public void verifyClientCategoryFunctionality() {

		test = getTest("TC_Ticketing_SLA_167");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.validateClientCategoryFunctionality();
	}

	@Test(priority = 5)
	public void verifyDepartmentCategoryFunctionality() {

		test = getTest("TC_Ticketing_SLA_168");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.validateDepartmentCategoryFunctionality();
	}

	@Test(priority = 6)
	public void verifyProductCategoryFunctionality() {

		test = getTest("TC_Ticketing_SLA_169");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.validateProductCategoryFunctionality();
	}

	@Test(priority = 7)
	public void verifyDeleteButtonFunctionality() {

		test = getTest("TC_Ticketing_SLA_189");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.validateSaveButtonFunctionality();
	}

	@Test(priority = 8)
	public void verifyPolicyDatePickerFunctionality() {
		test = getTest("TC_Ticketing_SLA_161");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.verifyPolicyDate();
	}

	@Test(priority = 9)
	public void verifyBooleanFunctionality() {
		test = getTest("TC_Ticketing_SLA_171");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.booleanSettingTrashButton();
	}

	@Test(priority = 10)
	public void verifyBooleanSaveButtonFunctionality() {
		test = getTest("TC_Ticketing_SLA_171");
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.booleanSettingSaveButton();
	}

	@Test(priority = 11)
	public void verifyResponseTimeValidations() {

		test = getTest("TC_Ticketing_SLA_180");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction=
		 * new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.lessReponseResolveTime();
	}

	@Test(priority = 12)
	public void verifyResolveTimeValidations() {

		test = getTest("TC_Ticketing_SLA_182");
		
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction=
		 * new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddSLAAction addSLAAction = new AddSLAAction(driver);
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		SLAAction slaAction = new SLAAction(driver);
		addTicketAction.navigatetoSLA();
		slaAction.clickAddNewSLA();
		addSLAAction.addSLALessResolveTime();
		
	}
}
