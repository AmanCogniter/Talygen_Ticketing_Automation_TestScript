package action;

import org.openqa.selenium.WebDriver;

import pageobjects.AddSLAPage;
import pageobjects.SLAPage;;

public class AddSLAAction {

	WebDriver driver;

	AddSLAPage addSLAPage;
	SLAPage slaPage;

	public AddSLAAction(WebDriver driver) {
		this.addSLAPage = new AddSLAPage(driver);
		this.slaPage = new SLAPage(driver);
		this.driver = driver;
	} 

	public void addSLA() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectValuesFromTargetDropDown();
		addSLAPage.selectDepartmentCheckbox();
		addSLAPage.clickSaveButton();
		addSLAPage.clickAddResult();
		addSLAPage.resultPop();
		addSLAPage.selectServiceBoard();
		addSLAPage.saveResult();
		configureSLA(20, 50);

		//addSLAPage.violationTimeReminderUser();
		addSLAPage.clickSave();
		//addSLAPage.verifySLASuccessMessage();
	}

	public void configureSLA(int responseTime, int resolveTime) {
		addSLAPage.clickSwitch();
		addSLAPage.selectWeekDaysCheckBox();
		addSLAPage.selectHighPriorityType();
		addSLAPage.addResponseTime(20);
		addSLAPage.selectResponseMin();
		addSLAPage.selectApproachTime();
		addSLAPage.selectResolveTime(50);
		addSLAPage.resolveTimeMin();
		addSLAPage.selectAlertBeforeResponseMin();
		addSLAPage.alertBeforeResolveTimeApproach();
		addSLAPage.selectResolveTimeMin();
		addSLAPage.responseDue();
		addSLAPage.resolveDueMin();
		addSLAPage.notifyToCA();
		addSLAPage.selectUser();
		addSLAPage.resolveDue();
		addSLAPage.resolveDueViolationMin();
		addSLAPage.notifyCAResolveDue();
		addSLAPage.voilationTimeReminderForLessResponsetime();
	}

	public void configureSLAWithLessTime(int responseTime, int resolveTime) {
		addSLAPage.clickSwitch();
		addSLAPage.selectWeekDaysCheckBox();
		addSLAPage.selectHighPriorityType();
		addSLAPage.addResponseTime(responseTime);
		addSLAPage.selectResponseMin();
		addSLAPage.selectApproachTime();
		addSLAPage.selectResolveTime(resolveTime);
		addSLAPage.resolveTimeMin();
		addSLAPage.selectAlertBeforeResponseMin();
		addSLAPage.alertBeforeResolveTimeApproach();
		addSLAPage.selectResolveTimeMin();
		addSLAPage.responseDue();
		addSLAPage.resolveDueMin();
		addSLAPage.notifyToCA();
		addSLAPage.selectUser();
		addSLAPage.resolveDue();
		addSLAPage.resolveDueViolationMin();
		addSLAPage.notifyCAResolveDue();
		addSLAPage.voilationTimeReminderForLessResponsetime();
	}

	public void configureSLAWithLessResolveTime(int resolveTime, int responseTime) {
		addSLAPage.clickSwitch();
		addSLAPage.selectWeekDaysCheckBox();
		addSLAPage.selectHighPriorityType();
		addSLAPage.addResponseTime(20);
		addSLAPage.selectResponseMin();
		addSLAPage.selectApproachTime();
		addSLAPage.selectLessResolveTime(30);
		addSLAPage.resolveTimeMin();
		addSLAPage.selectAlertBeforeResponseMin();
		addSLAPage.alertBeforeResolveTimeApproach();
		addSLAPage.selectResolveTimeMin();
		addSLAPage.responseDue();
		addSLAPage.resolveDueMin();
		addSLAPage.notifyToCA();
		addSLAPage.selectUser();
		addSLAPage.resolveDue();
		addSLAPage.resolveDueViolationMin();
		addSLAPage.notifyCAResolveDue();
		addSLAPage.voilationTimeReminderForLessResponsetime();
	}

	public void lessReponseResolveTime() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectValuesFromTargetDropDown();
		addSLAPage.selectDepartmentCheckbox();
		addSLAPage.clickSaveButton();
		addSLAPage.clickAddResult();
		addSLAPage.resultPop();
		addSLAPage.selectServiceBoard();
		addSLAPage.saveResult();
		configureSLAWithLessTime(19, 50);
		//addSLAPage.violationTimeReminderUser();
		addSLAPage.clickSave();
		verifyResponseTimeMessage();
	}

	public void verifyResponseTimeMessage() {
		addSLAPage.verifyResponseTimeValidation();
	}

	public void verifyResolveTimeMessage() {
		addSLAPage.verifyResolveTimeValidation();
	}

	public void addSLALessResolveTime() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectValuesFromTargetDropDown();
		addSLAPage.selectDepartmentCheckbox();
		addSLAPage.clickSaveButton();
		addSLAPage.clickAddResult();
		addSLAPage.resultPop();
		addSLAPage.selectServiceBoard();
		addSLAPage.saveResult();
		configureSLAWithLessResolveTime(11, 20);
		//addSLAPage.voilationTimeReminderForLessResponsetime();
		addSLAPage.clickSave();
		verifyResolveTimeMessage();
	}

	public void addSLAWithoutMandatoryField() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterpolicyNoDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectValuesFromTargetDropDown();
		addSLAPage.selectDepartmentCheckbox();
		addSLAPage.clickSaveButton();
		addSLAPage.clickAddResult();
		addSLAPage.resultPop();
		addSLAPage.selectServiceBoard();
		addSLAPage.saveResult();
		configureSLA(20, 50);
		addSLAPage.violationTimeReminderUser();
		addSLAPage.clickSave();
		addSLAPage.verifyWarningMessage();
	}

	public void validateCharactersLength() {

		addSLAPage.enterPolicyMoreCharacters();
		addSLAPage.enterpolicyDescMoreCharacters();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectValuesFromTargetDropDown();
		addSLAPage.selectDepartmentCheckbox();
		addSLAPage.clickSaveButton();
		addSLAPage.clickAddResult();
		addSLAPage.resultPop();
		addSLAPage.selectServiceBoard();
		addSLAPage.saveResult();
		configureSLA(20, 50);
		addSLAPage.violationTimeReminderUser();
		addSLAPage.clickSave();
//		addSLAPage.verifySLASuccessMessage();
	}

	public void verifySelectedButton() {
		addSLAPage.verifySelectedRadioButton();
	}

	public void validateClientCategoryFunctionality() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectClientDropDown();
		addSLAPage.selectEqualToMultipleDropDown();
		addSLAPage.verifyMultiSelectDropDown();
	}

	public void validateDepartmentCategoryFunctionality() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectDept();
		addSLAPage.selectNotEqualToMultipleDropDown();
		addSLAPage.verifyMultiSelectDropDown();
	}

	public void validateProductCategoryFunctionality() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		addSLAPage.clickAddTarget();
		addSLAPage.selectProduct();
		addSLAPage.selectEqualToMultipleDropDown();
		addSLAPage.verifyMultiSelectDropDown();
	}

	public void validateSaveButtonFunctionality() {
		addSLAPage.enterPolicyName();
		addSLAPage.enterPolicyDescription();
		addSLAPage.clickSLAPolicyCheckbox();
		addSLAPage.clickOnCreateRadioButton();
		configureSLA(20, 50);
		addSLAPage.clickSaveBtton();

	}

	public void verifyPolicyDate() {
		addSLAPage.clickPolicyDatePicker();
		addSLAPage.verifyPolicyDate();
		addSLAPage.selectCurrentDate();
	}

	public void clickAddOrButton() {
		addSLAPage.clickAddButton();
		addSLAPage.clickOrButton();

	}

	public void booleanSettingTrashButton() {
		validateClientCategoryFunctionality();
		clickAddOrButton();
		equalToTrashButton();
	}

	public void booleanSettingSaveButton() {
		validateClientCategoryFunctionality();
		clickAddOrButton();
		equalToSaveButton();
	}

	public void targetPopupDropdown() {
		addSLAPage.selectDeptOtherDropDown();
		addSLAPage.selectEqualToDropDown();
		addSLAPage.selectThirdTargetDropDown();
	}

	public void equalToTrashButton() {
		targetPopupDropdown();
		addSLAPage.clickTrashButton();
	}

	public void equalToSaveButton() {
		targetPopupDropdown();
		addSLAPage.clickSaveFromTargetPopup();
	}

}
