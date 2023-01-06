package action;

import org.openqa.selenium.WebDriver;

import pageobjects.CompanySetupPage;

public final class CompanySetupAction {

	WebDriver driver;
	CompanySetupPage companySetupPage;

	public CompanySetupAction(WebDriver driver) {
		this.driver = driver;
		this.companySetupPage = new CompanySetupPage(driver);
	}

	public void navigateToCompanySetupUser() {
		companySetupPage.clickFullMenu();
		companySetupPage.clickCompanySideMenu();
		companySetupPage.clickUser();
	}

	public void addUser() {
		companySetupPage.clickAddUser();
	}

	public void addUserGeneralSettings() {
		companySetupPage.selectTitle();
		companySetupPage.selectUserType();
		companySetupPage.enterFirstName();
		companySetupPage.enterLastName();
		companySetupPage.enterEmail();
		companySetupPage.selectGender();
		companySetupPage.clickEnableLoginSwitch();
		companySetupPage.enterPassword();
		companySetupPage.enterConfirmPassword();
	}

	public void addUserAdvanceSettings() {

		companySetupPage.selectTimezone();
		companySetupPage.selectDOB();
		companySetupPage.selectDOD();
		companySetupPage.selectDOJ();
		companySetupPage.selectDOL();
		companySetupPage.selectDepartment();
		companySetupPage.selectDesignation();
		companySetupPage.selectShift();
		companySetupPage.enterEmployeeId();
		companySetupPage.enterAliasName();
		companySetupPage.clickVirtualUserSwitch();
	}
	public void addUserAdvanceSettingsforSLA() {

		companySetupPage.selectTimezone();
		companySetupPage.selectDOB();
		companySetupPage.selectDOD();
		companySetupPage.selectDOJ();
		companySetupPage.selectDOL();
		companySetupPage.selectDepartmentForSLA();
		companySetupPage.selectDesignation();
		companySetupPage.selectShift();
		companySetupPage.enterEmployeeId();
		companySetupPage.enterAliasName();
		companySetupPage.clickVirtualUserSwitch();
	}


	public void clickSaveButton() {
		companySetupPage.clickSave();
	}

	public void deleteUser() {
		companySetupPage.deleteCreatedUser();
	}

	public void addNewUsers() {

		companySetupPage.addMultipleUsers();
	}

	public void addSkills() {

		companySetupPage.addSkillsForCreatedUser();
	}

	public void delaaaeteUser() {

		companySetupPage.navigateToAddGroup();
	}

	public void navigateUsersListScreen() {
		companySetupPage.navigateToCompanySetupUsersList();
	}

	public void addTicketingLicense() {

		companySetupPage.clickActionButton();
		companySetupPage.clickAssociateLicenses();
		companySetupPage.clickTicketingLicense();
		companySetupPage.addLicenseSuccessMessage();
		companySetupPage.closeLicensePopup();
	}

	public void enableTicketResolver() {

		companySetupPage.clickConfiguration();
		companySetupPage.enableTicketResolve();
		companySetupPage.clickCloseConfiguration();

	}

	public void addDepartmentNotVisibleClient() {
		companySetupPage.AddButton();
		companySetupPage.enterDepttNameNotVisibleClient();
		companySetupPage.enterDepartmentDesciption();
		companySetupPage.clickOnVisibleToTicketing();
		companySetupPage.departmentDesciption();
		companySetupPage.Save();
	}
	public void addDepartmentVisibleToClient() {
		companySetupPage.AddButton();
		companySetupPage.enterDepttNameNotVisibleClient();
		companySetupPage.enterDepartmentDesciption();
		companySetupPage.clickOnVisibleToClient();
		companySetupPage.clickOnVisibleToTicketing();
		companySetupPage.departmentDesciption();
		companySetupPage.Save();
	}

	public void addChannelTab() {
		companySetupPage.clickFullMenu();
		companySetupPage.clickCompanySetup();
		companySetupPage.companySetup();
		companySetupPage.clickOnChannel();
		companySetupPage.clickOnAdd();
		companySetupPage.enterChannelName();
		companySetupPage.selectStatus();
		companySetupPage.save();
	}
	public void addSkill() {
		companySetupPage.clickFullMenu();
		companySetupPage.clickCompanySideMenu();
		companySetupPage.clickCompanySetup();
		companySetupPage.clickSkill();
		companySetupPage.clickAddSkill();
		companySetupPage.enterSkillTitleName();
		companySetupPage.enterSkillDescription();
		companySetupPage.saveskill();	
	}

}