package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.ExternalLinkAction;
import action.LoginAction;
import utils.WebTestBase;

public class ExternalLinkTest extends WebTestBase{

	@Test(priority = 0)
	public void verifyExternalLinkPageUrl() {
		test = getTest("TC_Ticketing_ExternalLink_343");
		new LoginAction(driver).logoutLogin();
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.navigateToExternalLink();
		externalLinkAction.verifyManageLayoutUrl();
	}
	
	@Test(priority = 1)
	public void verifyValidationMessage() {
		test = getTest("TC_Ticketing_ExternalLink_344,359");
		new LoginAction(driver).logoutLogin();
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.navigateToExternalLink();
		externalLinkAction.resetButton();
		externalLinkAction.clickonOk();
		externalLinkAction.clickSaveButton();
		externalLinkAction.checkValidationMessage();
	}
	
	@Test(priority = 2)
	public void verifyFrameText() {
		test = getTest("TC_Ticketing_ExternalLink_346");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		new LoginAction(driver).logoutLogin();
		externalLinkAction.navigateToExternalLink();
		externalLinkAction.enterHeaderFrameText();
		externalLinkAction.saveButton();

	}
	
	@Test(dependsOnMethods = "verifyExternalLinkPageUrl")
	public void verifyCharactersLength() {
		test = getTest("TC_Ticketing_ExternalLink_346");
		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
		externalLinkAction.verifyCharactersLength();
	}
	
//	@Test(priority = 4)
//	public void verifyColorPickerFunctionality() {
//		test = getTest("TC_Ticketing_ExternalLink_346");
//		ExternalLinkAction externalLinkAction = new ExternalLinkAction(driver);
//		new LoginAction(driver).logoutLogin();
//		externalLinkAction.navigateToExternalLink();
//     	externalLinkAction.colorPicker();
//	}
	
	
	
}
