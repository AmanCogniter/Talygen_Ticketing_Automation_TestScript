package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddSLAPage;
import pageobjects.SLAPage;

public class SLAAction {

	WebDriver driver;
	SLAPage slaPage;
	AddSLAPage addSLAPage;

	public SLAAction(WebDriver driver) {
		this.driver = driver;
		this.slaPage = new SLAPage(driver);
	}

	public void clickAddNewSLA() {
		slaPage.addSLA();
	}

	public void searchPolicy() {
		String policyName = AddSLAPage.policyNameWithTime();
		slaPage.searchPolicyName(policyName);
		slaPage.clickOnGoButton();
	}

	public void verifyUpdateStatus() {
		slaPage.clickOnPolicyNameCheckBox();
		slaPage.clickActive();
		slaPage.clickOkStatusPopup();
		slaPage.verifyStatusSuccessMessage();
	}
	
	
}
