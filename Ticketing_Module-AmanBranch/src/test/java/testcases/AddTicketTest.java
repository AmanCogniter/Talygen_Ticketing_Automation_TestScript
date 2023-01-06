package testcases;

import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import utils.WebTestBase;

public class AddTicketTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyAssignToDeptDropDown() {

		test = getTest("TC_Ticketing_AddTicket_125");
		
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.clickAssignedToDepartment();
		addTicket.departmentDropDown();
	}

	@Test(priority = 1)
	public void verifyTicketCategoryDropdown() {

		test = getTest("TC_Ticketing_AddTicket_131");
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.ticketCategory();
		addTicket.ticketCategoryDropDown();
	}

	@Test(priority = 2)
	public void verifyPriorityDeptDropDown() {
		try {
			test = getTest("TC_Ticketing_AddTicket_127");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.clickPriorityDropDown();
			addTicket.priorityDropDown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void verifyValidations() {

		try {
			test = getTest("TC_Ticketing_AddTicket_124,126,128");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.submitButton();
			addTicket.verifyValidations();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void verifyTicketForRadioButtons() {

		try {
			test = getTest("TC_Ticketing_AddTicket_136");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.validateRadioButtons();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5)
	public void verifyProductDropDown() {

		test = getTest("TC_Ticketing_AddTicket_129");
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.productDropDown();
		addTicket.verifyproductDropDown();

	}

	@Test(priority = 6)
	public void verifyNoValidations() {

		try {
			test = getTest("TC_Ticketing_AddTicket_132");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.submitButton();
			addTicket.checkNoValidationMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7)
	public void verifyTwoRadioButtons() {

		try {
			test = getTest("TC_Ticketing_AddTicket_140,136,137");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.selfButton();
			addTicket.onBehalfButton();
			addTicket.checkPresenceOfRadioButtons();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8)
	public void addOwnTickets() {
		test = getTest("TC_Ticketing_AddTicket_134,135,141");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.addTicketOnBehalfOfUser();
		addTicket.verifySuccess();

	}

	@Test(priority = 9)
	public void verifyValidationForEmptyUser() {
		test = getTest("TC_Ticketing_AddTicket_142");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.verifyUserDropDownValidation();
		addTicket.validationForEmptyUser();
	}

	@Test(priority = 10)
	public void verifyValidationOnClientsField() {

		try {
			test = getTest("TC_Ticketing_AddTicket_144");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.selectTicketForOnBehalf();
			addTicket.onBehalfButton();
			addTicket.selectUserOnBehalfClient();
			addTicket.submitTicket();
			addTicket.checkClientValidation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 11)
	public void checkAddMoreFunctionality() {

		try {
			test = getTest("TC_Ticketing_AddTicket_146,147");
			/*
			 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
			 * = new CompanySetupAction(driver);
			 * companySetupAction.navigateToCompanySetupUser();
			 * companySetupAction.addUser();
			 * companySetupAction.addDepartmentNotVisibleClient();
			 */
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.addMoreDocumentField();
			addTicket.verifyNewAttachmentTab();
			addTicket.uploadDocument();
			addTicket.verifyFileUploadTrue();
			addTicket.ClearButton();
			addTicket.validateClearButtonFunctionality();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 12)
	public void verifyCharctersInDescriptionField() {
		try {
			test = getTest("TC_Ticketing_AddTicket_150,152,138");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.selfTicketSettings();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 13)
	public void verifyFontOfUserGuide() {
		try {
			test = getTest("TC_Ticketing_AddTicket_150,152,138");
			new LoginAction(driver).logoutLogin();
			AddTicketAction addTicket = new AddTicketAction(driver);
			addTicket.navigatetoAddTicket();
			addTicket.userGuide();
			addTicket.FontOfUserGuide();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 14)
	public void addTicket() {
		test = getTest("TC_Ticketing_AddTicket");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient();
		 */
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicketAction = new AddTicketAction(driver);
		addTicketAction.navigatetoAddTicket();
		addTicketAction.addTicketOnSelf();
	}

//	@Test(priority = 15)
//	public void addTicketForSLA() {
//		test = getTest("TC_Ticketing_Unassigned_Tickets");
////		new LoginAction(driver).logoutLogin();
////		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
////		companySetupAction.navigateToCompanySetupUser();
////		companySetupAction.addUser();
////		companySetupAction.addDepartmentNotVisibleClient();
//		new LoginAction(driver).logoutLogin();
//		AddTicketAction addTicketAction = new AddTicketAction(driver);
//		addTicketAction.navigatetoAddTicket();
//		addTicketAction.addTicketForSLA();
//	}
}