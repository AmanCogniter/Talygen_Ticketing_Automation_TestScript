package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import action.AddTicketAction;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class AddSLAPage extends WebBasePage {
	WebDriver driver;
	static String policyname;
	CompanySetupPage companySetupPage;
	AddTicketAction addTicketAction;
	AddTicketPage addTicketPage;
	AddSLAPage addSLAPage;
	static String policyName;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public AddSLAPage(WebDriver driver) {
		super(driver, "SLA Page");
		this.driver = driver;
		this.companySetupPage = new CompanySetupPage(driver);
		this.addTicketAction = new AddTicketAction(driver);
		this.addTicketPage = new AddTicketPage(driver);

	}

	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);
	static String departmentName;

	// click on full menu
	public void clickFullMenu() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), "Ticketing",
				20);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on sla
	public void clickSLA() {
		click(By.xpath("//a[@data-original-title='SLA' and @id='cadmin_messageboard_link']"), "SLA", 30);
	}

	public static String policyNameWithTime() {
		policyName = prop.getProperty("enterPolicyName") + datevalue;
		return policyName;
	}

	// enter Policy Name
	public void enterPolicyName() {
		String policyNameWithTime = policyNameWithTime();
		enter(By.cssSelector("#PolicyName"), policyNameWithTime, "Enter Policy Name", 35);
	}

	// enter Policy Name
	public void enterPolicyMoreCharacters() {
//			policyname = prop.getProperty("enterPolicyMoreCharacters") + datevalue;
		String policyNameMoreCharacters = datevalue + prop.getProperty("policyNameWithMoreCharacters");
		enter(By.cssSelector("#PolicyName"), policyNameMoreCharacters, "Enter Policy Name", 35);

		String textAreaCharacters = getAtribute(By.cssSelector("#PolicyName"), "value", 40);
		textAreaCharacters = textAreaCharacters.replaceAll("\\s", "");
		int charactersLength = textAreaCharacters.length();

		if (charactersLength <= 200) {
			getTest().log(LogStatus.PASS, "characters length is :: " + charactersLength);
			logger.info("characters length is :: " + charactersLength);
		} else {
			getTest().log(LogStatus.FAIL, "characters length is :: " + charactersLength);
			logger.info("characters length is  :: " + charactersLength);
			takeScreenshot("VerifyCharactersValidation");
			Assert.fail("VerifyCharactersValidation");
		}
	}

	// enter Policy Description
	public void enterPolicyDescription() {
		enter(By.cssSelector("#PolicyDescription"), prop.getProperty("enterPolicyDescription"),
				"Enter Policy Description", 35);
	}

	// enter Policy Description without Policy Description
	public void enterPolicyWithNoDescription() {
		enter(By.cssSelector("#PolicyDescription"), "", "Enter Policy With no Description", 35);
	}

	// policy checkbox
	public void clickSLAPolicyCheckbox() {
		staticWait(3000);
		// div[@class='custom-control
		// custom-checkbox']//input//following::label[@class='custom-control-label
		// universal-custom-control-label pt-1' and @for='chk_0']

		/*
		 * click(By.xpath(
		 * "//div[@class='custom-control custom-checkbox custom-control-inline']/ancestor::div[@class='form-check form-check-inline  checkbox-inline font-weight-light']/descendant::label"
		 * ), "SLA Policy checkbox", 20);
		 */
		WebElement selectcheckBox = driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox custom-control-inline']/ancestor::div[@class='form-check form-check-inline  checkbox-inline font-weight-light']/descendant::div[@class='custom-control custom-checkbox custom-control-inline']/label"));
		Actions action= new Actions(driver);
		action.moveToElement(selectcheckBox).click().perform();
		Reporter.log("Policy checkbox clicked", true);
	}

	// select radio button
	public void clickOnCreateRadioButton() {
		click(By.xpath("//label[@for='rdo_0']//parent::div"), "On Create radio button", 20);

	}

	// select radio button

	//
	public void verifySelectedRadioButton() {

		WebElement option1 = driver.findElement(By.xpath("//label[@for='rdo_0']//parent::div"));

		click(By.xpath("//label[@for='rdo_0']//parent::div"), "on create radio", 40);
		//click(By.xpath("//div[@class='parenthead']/span[@title='Back']"), "Back Button", 40);
		staticWait(3000);
		click(By.xpath("//*[@id='divruleflowdatashow']/ul/li[1]/ul/li/div/div[2]/div[2]/a/div"), "edit Event", 40);


		if (option1.isEnabled()) {
			logger.info("Radio button is selected ::" + option1.isEnabled());
			getTest().log(LogStatus.PASS, "Radio button is selected ::" + option1.isEnabled());

		} else {
			logger.info("Radio button is NOT selected ::" + option1.isEnabled());
			getTest().log(LogStatus.FAIL, "Radio button is NOT selected ::" + option1.isEnabled());
			takeScreenshot("verifyRadioButtonsFunctionality");
			Assert.fail("verifyRadioButtonsFunctionality");
		}

	}

	// select radio button
	public void clickAddTarget() {
		click(By.cssSelector("#litarger_0 p a"), "Add Target", 20);
	}

	// Select ' equal to ' from Target dropDown
	public void selectValuesFromTargetDropDown() {
		click(By.xpath("//ul//li[@class='form-group align-middle px-2'][3]//select//option[@data-second='bigint']"),
				"select 'Equal to' from Target popup Dropdown", 30);

		String dropDownValue = getText(By.xpath("//div[@class='boxsizing wordbreak text-left pl-2 float-left  py-1']"),
				30);
		if (dropDownValue.contains("Equal To")) {

			getTest().log(LogStatus.PASS, dropDownValue + " is successfully displayed");
		}

		else {
			getTest().log(LogStatus.FAIL, dropDownValue + " is not successfully displayed");
			logger.debug("Equal to is not displayed");
			takeScreenshot("DropDownValue");
			Assert.fail("DropDownValue");
		}
	}

	// Select Department
	public void selectDept() {
		click(By.xpath("//select[@id='RuleTarget_0__FieldId']"), "Select Dropdown", 20);

		click(By.xpath("//select[@id='RuleTarget_0__FieldId']//option[@data-fourth='department']"),
				"Select Department Dropdown", 20);
	}

	// Select Department from 2 dropdown
	public void selectDeptOtherDropDown() {
		click(By.xpath(
				"//*[@id='divTargetsdata']/div[2]//ul[@class='backgroundEDEDED borderbababa col-12 coloredmandatory']//li[@class='form-group align-middle px-2'][2]//select"),
				"Select Dropdown", 20);

		click(By.xpath(
				"//*[@id='divTargetsdata']/div[2]//ul[@class='backgroundEDEDED borderbababa col-12 coloredmandatory']//li[@class='form-group align-middle px-2'][2]//select//option[4]"),
				"Select Department second Dropdown", 20);
	}

	// Select Department from 2 dropdown
	public void selectEqualToDropDown() {
		click(By.xpath(
				"(//li[@class='form-group align-middle px-2']/select[@class='form-control ddlOperatorId'])[2]"),
				"Select Dropdown", 20);

		click(By.xpath(
				"(//li[@class='form-group align-middle px-2']/select[@class='form-control ddlOperatorId']/option[text()='Equal To'])[2]"),
				"Select Department second Dropdown", 20);
	}

	// Select Product
	public void selectProduct() {
		click(By.xpath("//select[@id='RuleTarget_0__FieldId']"), "Select Dropdown", 20);

		click(By.xpath("//select[@id='RuleTarget_0__FieldId']//option[@data-fourth='product']"),
				"Select Product Dropdown", 20);
	}

	// Select values from multiple checkBox dropdown
	public void selectDepartmentCheckbox() {

		departmentName = CompanySetupPage.departmentname;
		click(By.xpath("//div[@id='divTargetsdata']//span/div/button"), "select Sales from Target popup Dropdown", 30);
		enter(By.xpath(
				"//ul[@class='multiselect-container dropdown-menu show']//li[@class='multiselect-item multiselect-filter multiselect-filter-search']//input"),
				departmentName, "select department :: " + departmentName, 20);
		staticWait(2000);

		List<WebElement> options = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu show']/li"));
		for (WebElement option : options) {
			if (option.getText().equals(departmentName)) {
				option.click(); // click the desired option
				break;
			}
		}
	}

	// Select values from multiple checkBox dropdown
	public void selectClientCheckbox() {

		click(By.xpath("//div[@id='divTargetsdata']//span/div/button"), "select Sales from Target popup Dropdown", 30);
		click(By.xpath(
				"//ul[@class='multiselect-container dropdown-menu show']//li[@class='multiselect-item multiselect-filter multiselect-filter-search']//div//span//following::li[2]"),
				"select Sales from Target popup Dropdown", 30);

	}

	// Select client from first target dropdown
	public void selectClientDropDown() {

		click(By.xpath("//div[@id='divTargetsdata']//select[@id='RuleTarget_0__FieldId']//option[1]"),
				"select client from Target popup Dropdown", 30);
		click(By.xpath("//div[@id='divTargetsdata']//select[@id='RuleTarget_0__FieldId']//option[3]"),
				"select client from Target popup Dropdown", 30);

	}

	public void verifyMultiSelectDropDown() {

		click(By.xpath("//*[@id='divTargetsdata']//button[@class='multiselect custom-select btn btn-default']"),
				"Select Target popup Dropdown", 30);

		click(By.xpath("//ul[@class='multiselect-container dropdown-menu show']//span"),
				"select multi select Target popup Dropdown", 30);
		click(By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li//span//following::li//label"),
				"select multi select Target popup Dropdown", 30);

		String attributeName = getAtribute(
				By.xpath("//li[@class='multiselect-item multiselect-filter multiselect-filter-search active']"),
				"class", 40);

		if (attributeName.contains("active")) {

			getTest().log(LogStatus.PASS, attributeName + " multiple elements are selected.");
			logger.debug("multiple elements are selected.");

		} else {
			getTest().log(LogStatus.FAIL, attributeName + "multiple elements are not selected.");
			logger.debug("multiple elements are not selected.");
			takeScreenshot("verifyMultiSelectDropDown");
			Assert.fail("verifyMultiSelectDropDown");
		}
	}

	// Select EqualToMultiple from first target dropdown
	public void selectEqualToMultipleDropDown() {

		click(By.xpath("//div[@class='clstargetdata w-100']//li[@class='form-group align-middle px-2'][3]//option[1]"),
				"select ''Equal to one of multiple possible values'' Target popup Dropdown", 30);
		click(By.xpath("//div[@class='clstargetdata w-100']//li[@class='form-group align-middle px-2'][3]//option[3]"),
				"select ''Equal to one of multiple possible values'' from Target popup Dropdown", 30);

	}

	// Select Not Equal to one of multiple possible values from first target
	// dropdown
	public void selectNotEqualToMultipleDropDown() {

		click(By.xpath("//div[@class='clstargetdata w-100']//li[@class='form-group align-middle px-2'][3]//option[1]"),
				"select ''Not Equal to one of multiple possible values'' Target popup Dropdown", 30);
		click(By.xpath("//div[@class='clstargetdata w-100']//li[@class='form-group align-middle px-2'][3]//option[4]"),
				"select ''Not Equal to one of multiple possible values'' from Target popup Dropdown", 30);

	}

	public void verifySelectedValue(By by, String name, String dropDown, int time) {
		String selectedValue = " ";
		staticWait(200);
		WebElement element = findElementVisibility(by, time);
		Select select = new Select(element);
		selectedValue = select.getFirstSelectedOption().getText();
		if (selectedValue.equals(dropDown)) {
			getTest().log(LogStatus.PASS, name + " selected with value - " + selectedValue);
			logger.info(name + " selected with value - " + selectedValue);
			// System.out.println(name + " selected with value - " + selectedValue);
		} else {
			getTest().log(LogStatus.FAIL,
					name + " not selected with value - " + selectedValue + ". And Error Occurred. ");
			logger.info(name + " not selected with value - " + selectedValue + ". And Error Occurred. ");
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
		}
	}

	// click on save button
	public void clickSaveButton() {
		click(By.cssSelector("#btnSaveTarget"), "save button", 30);
	}

	// click on Add Result button
	public void clickAddResult() {
		staticWait(2000);
		click(By.cssSelector("#litargerresult_0  p a"), "Add Result button", 30);
	}

	// result Pop-up
	public void resultPop() {
		click(By.xpath("//select[@class='form-control ddlwarningMessageTypeId']//option[2]"), "assign to option", 30);
	}

	// select weekdays Sat and Sun
	public void selectWeekDaysCheckBox() {
		click(By.xpath("//label[@class='custom-control-label universal-custom-control-label pt-1' and @for='chk_7']"),
				"Select WeekDays Sat", 30);
		click(By.xpath("//label[@class='custom-control-label universal-custom-control-label pt-1' and @for='chk_8']"),
				"Select WeekDays Sun", 30);
	}

	// select Targets priority Type
	public void selectHighPriorityType() {
		click(By.xpath("//div[@id='apply_on_outer_div']/div[2]/div/table/tbody/tr[1]/td[1]/div"),
				"Select High priority type", 30);
	}

	// select Targets Low priority Type
	public void selectLowPriorityType() {

		click(By.xpath("//div[@id='apply_on_outer_div']/div[2]/div/table/tbody/tr[2]/td[1]/div"),
				"Select Low priority type", 30);
	}

	// select Response Time
	public void addResponseTime(int responseTime) {
		/*
		 * click(By.xpath("//select[@id='ListTarget_0__ResponseTime']//option[@value='"
		 * + responseTime + "']"), "Response time 20 Min", 30);
		 */
		click(By.xpath("//tg-select/select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResponseTime']/option[text()='"+responseTime+"']"),
				"Response time 20 Min", 30);
	}

	// select Response Time
	public void selectResponseTime() {
		click(By.xpath("//select[@id='ListTarget_0__ResponseTime']//option[@value='20']"), "Response time 20 Min", 30);
	}

	// select Response min
	public void selectResponseMin() {
		//click(By.xpath("//select[@id='ListTarget_0__ResponseTimeType']//option[2]"), "Select Response Min", 30);
		click(By.xpath("(//tg-select/select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResponseTimeType'])[1]/option[text()='Minute']"), "Select Response Min", 30);
	}

	// select Approach Response Time
	public void selectApproachTime() {
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResponseTimeApproach']/option[text()='11']"),
				"Alert before Response Time Approaches 11 Min", 30);
	}

	// Alert Before Response min
	public void selectAlertBeforeResponseMin() {
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResponseTimeApproachType']/option[text()='Minute']"),
				"Alert Before Response Time approach min", 30);
	}

	// select Resolve Time
	public void selectResolveTime(int resolveTime) {
		/*
		 * click(By.xpath("//select[@id='ListTarget_0__ResolveTime']//option[@value='" +
		 * resolveTime + "']"), "Response time 20 Min", 30);
		 */
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResolveTime']/option[@value='50']"),
				"Resolve time 20 Min", 30);

	}
	// select Resolve Time
		public void selectLessResolveTime(int resolveTime) {
			/*
			 * click(By.xpath("//select[@id='ListTarget_0__ResolveTime']//option[@value='" +
			 * resolveTime + "']"), "Response time 20 Min", 30);
			 */
			click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResolveTime']/option[@value='11']"),
					"Resolve time 11 Min", 30);

		}

	// select Alert before Resolve Time
	public void alertBeforeResolveTimeApproach() {
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResolveTimeApproach']/option[@value='11']"),
				"Alert before Resolve Time 50 min", 30);
	}

	// select Resolve Time min
	public void resolveTimeMin() {
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResolveTimeType']/option[text()='Minute']"), "Resolve Time minute",
				30);
	}

	// Alert Before Resolve Time approach min
	public void selectResolveTimeMin() {
		click(By.xpath("//select[@id='ListTarget[Model.ListTarget.IndexOf(target)].ResolveTimeApproachType']/option[text()='Minute']"),
				"Resolve Time Approach min", 30);
	}

	// select Response Time for low priority
	public void responseTimeLowPriority() {
		click(By.xpath("//select[@id='ListTarget_0__ResponseTime']//option[@value='5']"),
				"Response time for low priority 5 Hour", 30);
	}

	// select Approach Response Time
	public void approachTimeLowPriority() {
		click(By.xpath("//select[@id='ListTarget_1__ResponseTimeApproach']//option[@value='2']"),
				"Alert before Response Time Approaches 2 hour", 30);
	}

	// select Approach Response Time
	public void resolveTimeLowPriority() {
		click(By.xpath("//select[@id='ListTarget_1__ResolveTimeApproach']//option[@value='1']"),
				"Alert before Resolve Time Approaches 1 hour", 30);
	}

	// select Response Due
	public void responseDue() {
		click(By.xpath("//select[@id='ViolationResponseTime']//option[@value='3']"), "Violation Time Reminder 3 min.",
				30);
	}

	// select Resolve Due
	public void resolveDueViolationMin() {
		click(By.xpath("//select[@id='ViolationResolveTime']//option[@value='3']"), "Violation resolve due min.", 30);
	}

	// select Notify To CA
	public void notifyToCA() {
		click(By.xpath("//div[@id='divVoilationSLA']/div[2]/div/table/tbody/tr[1]/td[4]/div/div/div[2]/div"),
				"Notify To CA.", 30);
	}

	// select user
	public void selectUser() {
		click(By.xpath("//span[@class='multiselect-native-select']//select[@id='ResponseAssignToIds']//parent::span"),
				"select user from Response due.", 30);

		click(By.xpath("//ul[@class='multiselect-container dropdown-menu show']//li[3]"), "response user selected", 30);
	}

	// select Resolve Due
	public void resolveDue() {
		click(By.xpath("//select[@id='ViolationResponseTime']//option[@value='2']"), "Resolve due.", 30);
	}

	// select Resolve Due
	public void saveResult() {
		click(By.cssSelector("#btnSaveTargetResult"), "Save from Result Popup.", 30);
	}

	// CA Resolve Due
	public void notifyCAResolveDue() {
		click(By.xpath("(//div[@class='row']/ancestor::td[@class='overflow-visible']/descendant::div[@class='custom-control custom-checkbox'])[2]"), "Notify To CA in Resolve Due.", 30);
	}

	// select Resolve Due
	public void resolveDueMin() {
		click(By.xpath("//select[@id='policySLAReminderResponse_TimeApproachesType']//option[@value='Minute']"),
				"Select Resolve due min.", 30);
	}

	// select user in violation resolve due
	public void violationTimeReminderUser() {
		click(By.xpath("//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span"),
				"select user.", 30);

		
		  click(By.xpath(
		  "//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span"
		  ), "select user in Resolve due violation reminder.", 30);
		 
		
			/*
			 * click(By.xpath(
			 * "(//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span/descendant::li/a/label)[2]"
			 * ), "select user in Resolve due violation reminder.", 30);
			 */

	}
	public void voilationTimeReminderForLessResponsetime() {
		staticWait(3000);
		click(By.xpath("//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span"),
				"select user.", 30);
		click(By.xpath(
				 "(//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span/descendant::li/a/label)[2]"
				  ), "select user in Resolve due violation reminder.", 30);
		click(By.xpath("//span[@class='multiselect-native-select']//select[@id='ResolveAssignToIds']//parent::span"),
				"select user.", 30);
		staticWait(3000);
	}

	// select Third Target DropDown
	public void selectThirdTargetDropDown() {

		click(By.xpath("//div[@id='divTargetsdata']/div[2]/ul/li[4]"), "select DropDown.", 30);
		click(By.xpath(
				"//button[@type='button']/ancestor::div[@class='btn-group show']/descendant::ul/li/a/label"),
				"select Third Target DropDown.", 30);
	}

	// select user in violation
	public void selectUserInViolation() {
		click(By.xpath(
				"//div[@id='divVoilationSLA']/div[2]/div/table/tbody/tr[2]/td[4]/div/div/div[3]/span/div/ul/li[4]/a/label"),
				"select user.", 30);
	}

	// select user in violation
	public void clickSave() {
		click(By.cssSelector("#btnSave"), "Save button.", 30);
	}

	public void selectServiceBoard() {
//		click(By.cssSelector("#ddlwarningMessageTypeId"), "Select Result Type", 30);
		click(By.xpath("//select[@class='form-control ddlResultChainIds multiselectdd']//option[@value][last()]"),
				"Select Recent service board.", 30);
	}

	// click on switch
	public void clickSwitch() {
		click(By.xpath("//div[@id='General']//div//parent::span/span[2]"), "switch button.", 30);
	}

	public void verifyResponseTimeValidation() {
		staticWait(2000);
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("responseTimeMessage"), 50);
	}

	public void verifyResolveTimeValidation() {
		staticWait(2000);
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("resolveTimeValidation"), 50);
	}

	public void verifySLASuccessMessage() {
//		staticWait(3000);
		findElementVisibility(By.cssSelector("#notifymessage"), 20);
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("slaSuccessMessage"), 50);

	}

	public void verifyWarningMessage() {
		staticWait(3000);
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("slaWarningMessage"), 50);

	}

	// enter Policy Description with No Description.
	public void enterpolicyNoDescription() {
		enter(By.cssSelector("#PolicyDescription"), "", "Enter Policy with no Description", 35);
	}

	// enter Policy Description with 600 characters and verify length
	public void enterpolicyDescMoreCharacters() {
		enter(By.cssSelector("#PolicyDescription"), prop.getProperty("policyDescMoreCharacters"),
				"Enter Policy Description", 35);

		String textAreaCharacters = getAtribute(By.cssSelector("#PolicyDescription"), "value", 40);
		textAreaCharacters = textAreaCharacters.replaceAll("\\s", "");
		int charactersLength = textAreaCharacters.length();

		if (charactersLength <= 500) {
			getTest().log(LogStatus.PASS, "characters length is :: " + charactersLength);
			logger.info("characters length is :: " + charactersLength);
		} else {
			getTest().log(LogStatus.FAIL, "characters length is :: " + charactersLength);
			logger.info("characters length is  :: " + charactersLength);
			takeScreenshot("VerifyCharactersValidation");
			Assert.fail("VerifyCharactersValidation");
		}
	}

	// click on save button
	public void clickSaveBtton() {
		click(By.cssSelector("#gobacktolistscreen"), "save button.", 30);
	}

	// click on save button
	public void clickAddButton() {
		click(By.cssSelector("#ancAddMoreData"), "add button.", 30);
	}

	// click on or button
	public void clickOrButton() {
		click(By.xpath("//div[@id='divaddmoredatabutton']/a[2]/div"), "or button.", 30);
	}

	// select current date
	public void selectCurrentDate() {
		click(By.xpath("//td[@class='day active today weekend']"), "Select Current Date.", 30);
	}

	// click PolicyDatePicker
	public void clickPolicyDatePicker() {
		click(By.xpath(
				"//div[@class='col-sm-12 col-md-6 col-lg-4 col-xl-4 float-left '][2]//following::div[@class='input-group-append' and @data-target='#txtPolicyDate'][1]"),
				"Policy Date Picker.", 30);
	}

	// click Business Date picker
	public void clickBusinessDatePicker() {
		click(By.xpath("//div[@class='input-group-append' and @data-target='#StartTime']"), "Business Date Picker.",
				30);
		click(By.xpath("//div[@class='input-group-append' and @data-target='#StartTime']"), "Business Date Picker.",
				30);
	}

	// Get current Date
	public void verifyPolicyDate() {
		staticWait(3000);
		
		String dateAttribute = getAtribute(By.xpath(
				/*
				 * "//table[@class='table table-sm']//td[@class='day active today']//preceding-sibling::td[@class='day disabled'][1]"
				 * ),
				 */
				"//table[@class='table table-sm']/tbody/tr//td[@class='day active today weekend']//preceding-sibling::td[@class='day disabled'][1]"),
				"class", 0);
		/*
		 * "//tg-input/input[@id='txtPolicyDate']"), "class", 0);
		 */

		if (dateAttribute.contains("disabled")) {
		//if (dateAttribute.contains("txtPolicyDate")) {
			getTest().log(LogStatus.PASS, "Past Date should not be selected is disabled.." + dateAttribute);
			logger.debug("Past Date should not be selected is disabled..");
		} else {
			getTest().log(LogStatus.FAIL, "Past Date should is selected is not disabled.." + dateAttribute);
			logger.debug("Past Date should not be selected is disabled..");
			takeScreenshot("verifyPolicyDate");
		}
	}

	// click PolicyDatePicker
	public void clickSaveFromTargetPopup() {
		click(By.xpath("//a[@id='btnSaveTarget']"), "Save from target Pop-up button.", 30);
	}

	// click PolicyDatePicker
	public void clickTrashButton() {
		click(By.xpath("//a[@class='recyclebin enable anddeldata']"), "Trash button.", 30);
	}
}
