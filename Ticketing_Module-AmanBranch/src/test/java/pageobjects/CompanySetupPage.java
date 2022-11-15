package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class CompanySetupPage extends WebBasePage {
	WebDriver driver;
	
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);
	static String departmentDescription;
	static String departmentname;
	public static String Channelnewname;
	public static String skillname;

	public CompanySetupPage(WebDriver driver) {
		super(driver, "CompanySetup Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on Company Setup
	public void clickCompanySetup() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='COMPANY SETUP']/span"), "Company Setup", 20);
	}

	// click on Side menu
	public void clickCompanySideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='COMPANY SETUP']/span"),
				"Company Side menu", 20);
	}

	// click on user
	public void clickUser() {
		staticWait(3000);
		//findElementVisibility(By.xpath("//ul[@class='submenu clschild_0 d-flex']//a[@data-original-title='User']"), 20);
		click(By.xpath("//ul[@class='submenu clschild_0 d-flex']//a[@data-original-title='User']"), "User", 20);
	}

	// click on user
	public void clickAddUser() {
		click(By.cssSelector("#ancCreateDepartment"), "Add User", 20);
	}

	// select title
	public void selectTitle() {
		staticWait(3000);
		selectValueWithText(By.xpath("//tg-select/select[@id='user_title_id']"), "Mr.", "Select Title", 0);
	}

	// Select User Type
	public void selectUserType() {
		staticWait(3000);
		selectValueWithText(By.cssSelector("#Clientdetail_user_type_id"), "Company Admin", "Select User Type", 0);
	}

	// enter First Name
	public void enterFirstName() {
		enter(By.cssSelector("#txtFirstName"), prop.getProperty("userFirstName"), "First name", 40);
	}

	// enter Last Name
	public void enterLastName() {
		enter(By.cssSelector("#Clientdetail_last_name"), prop.getProperty("enterLastName"), "Last name", 40);
	}

	// enter Last Name one
	public void enterLastNameOne() {
		enter(By.cssSelector("#Clientdetail_last_name"), prop.getProperty("enterLastNameOne"), "Last name 1", 40);
	}

	// enter Email
	public void enterEmail() {
		enter(By.cssSelector("#txtEmail"), prop.getProperty("enterEmail")+datevalue+prop.getProperty("email"), "Email", 20);
	}

	// enter Email One
	public void enterEmailOne() {
		enter(By.cssSelector("#txtEmail"), prop.getProperty("enterEmailOne"), "Email 1", 20);
	}

	// Select Gender
	public void selectGender() {
		selectValueWithText(By.cssSelector("#Clientdetail_gender"), "Male", "Select Gender", 20);
	}

	// Select Enable Login
	public void clickEnableLoginSwitch() {
		staticWait(2000);
		click(By.xpath("//div[@id='divAttForm']/div[7]/div//asp-checkbox-toggle//span"), "Enable Login switch", 30);

		// input[@id='chkHourFormatN']//following::span[@class='slider
		// round'][1]//span[@class='slider-no']
	}

	// enter Password
	public void enterPassword() {
		enter(By.cssSelector("#txtPassword"), prop.getProperty("enterPassword"), "Password", 20);
	}

	// enter Confirm Password
	public void enterConfirmPassword() {
		enter(By.cssSelector("#txtConfirmPassword"), prop.getProperty("enterConfirmPassword"), "ConfirmPassword", 20);
	}

	// Select Timezone
	public void selectTimezone() {
		selectValueWithText(By.xpath("//select[@id='ddlTimeZone']"),
				"(GMT+05:30) Chennai, Kolkata, Mumbai, New Delhi Standard Time", "Time zone", 20);
	}

	// Select Date Format
	public void selectDOB() {
		staticWait(3000);

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_birth']"), "Date picker", 30);
		click(By.cssSelector("td.day.active.today"), "Todays Date", 30);
	}

	// Select DOD
	public void selectDOD() {
		staticWait(3000);

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_death']"), "Date picker", 30);
		click(By.cssSelector("td.day.active"), "Date of death", 30);
	}

	// Select DOJ
	public void selectDOJ() {
		staticWait(3000);

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_join']"), "Date picker", 20);
		click(By.cssSelector("td.day.active"), "Date of joining", 30);

	}

	// Select DOL
	public void selectDOL() {
		staticWait(3000);

		click(By.xpath("//div[@data-target='#Clientdetail_date_of_leave']"), "Date picker", 20);
		click(By.cssSelector("td.day.active.today"), "Date of leave", 30);

	}

	// Select Department
	public void selectDepartment() {
		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_department_id"), "Sales", "Sales", 20);
	}

	// Select Designation
	public void selectDesignation() {
		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_designation_id"), "CEO", "CEO", 20);
	}

	// Select Shift
	public void selectShift() {
		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Select", "Select", 20);
		selectValueWithText(By.cssSelector("#Clientdetail_shift_id"), "Day(Texas)", "CEO", 20);
	}

	// enter Employee Id:
	public void enterEmployeeId() {
//		prop.getProperty("employeeId") 
		enter(By.cssSelector("#Clientdetail_user_emp_id"), datevalue + prop.getProperty("employeeId"), "Employee Id:",
				20);
	}

	// enter Employee Id:
	public void enterEmployeeIdOne() {
//			prop.getProperty("employeeId") 
		enter(By.cssSelector("#Clientdetail_user_emp_id"), prop.getProperty("employeeIdOne") + datevalue,
				"Employee Id one:", 20);
	}

	// enter Alias Name
	public void enterAliasName() {
		enter(By.cssSelector("#Clientdetail_AliasName"), prop.getProperty("aliasName"), "Alias Name", 20);
	}

	// Select Virtual User
	public void clickVirtualUserSwitch() {
		click(By.xpath("//*[@id='divAttForm']/div[14]/div/div/asp-checkbox-toggle//span"), "Virtual User switch", 20);
		// input[@id='chkHourFormatN']//following::span[@class='slider
		// round'][1]//span[@class='slider-no']
	}

	public void clickSave() {

		click(By.cssSelector("#btnSave"), "Save button", 20);
		staticWait(6000);
	}

	public void clickDeleteButton() {

		click(By.cssSelector("#DeleteMultiple"), "Delete button", 20);
	}

	public void clickActionButton() {
		staticWait(6000);
		click(By.xpath("//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']"),
				"Action button", 20);
	}

	public void clickAssociateLicenses() {
		click(By.xpath(
				"//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']//following::a[@class='aAssociateLicenses actions-onclick'][1]"),
				"Associate Licenses button", 20);
	}

	// add Ticketing License
	public void clickTicketingLicense() {
		staticWait(3000);
		click(By.xpath("//a[@class='aAddLicense float-right' and @moduleid='12']//i"), "click Ticketing License",
				20);
	}

	// License Success Message
	public void addLicenseSuccessMessage() {
//		verifySuccessMessage(By.cssSelector("#notifymessage div"), "User has been successfully deleted.", 40);

		findElementVisibility(By.cssSelector("#notifymessage div"), 30);

	}

	// close license popup
	public void closeLicensePopup() {
		staticWait(3000);
		click(By.xpath("//a[@class='closeassoLicense btn btn-danger']"), "close License Popup", 20);
	}

	// click configuration
	public void clickConfiguration() {
		click(By.xpath(
				"//table[@id='tableResponsive']/tbody/tr[1]//td//span/i[@class='fa fa-ellipsis-h action_icon']//following::a[@class='aConfig actions-onclick'][1]"),
				"configuration Popup", 20);

	}

	// click enable Ticket Resolve
	public void enableTicketResolve() {
		click(By.xpath("//*[@id='ulKeysContainer']/div[1]/div[2]/div/div/div/label[1]/div/label"),
				"Enable Ticket Resolver", 20);
	}

	// click close Configuration
	public void clickCloseConfiguration() {
		staticWait(6000);

		clickByJavascript(By.xpath("//h5[@id='ui-id-16']//following::button[@data-original-title='Close'][1]"),
				"click close configuration", 20);
	}

	public void deleteCreatedUser() {
		staticWait(3000);
		try {
			pageNavigate(prop.getProperty("companyUsersListingPage"), "Company Users Listing PageU rl");
			List<WebElement> createdUsers = driver
					.findElements(By.xpath("//table[@id='tableResponsive']/tbody/tr//Td[2]//a"));
			List<WebElement> checkBoxes = driver
					.findElements(By.xpath("//table[@id='tableResponsive']/tbody/tr/td[1]"));

			for (int i = 0; i < 1; i++) {
				if (createdUsers.get(i).getText().contains("James Mills")
						&& (createdUsers.get(i).getText().contains("James Mills1"))) {
					checkBoxes.get(0).click();
					checkBoxes.get(1).click();
					staticWait(2000);
					clickDeleteButton();
					staticWait(4000);
					//driver.switchTo().alert().accept();
					click(By.xpath("//div/button[@title='OK']"),
							"Ok button", 20);
					System.out.println("user deleted");
					break;
				} else if (createdUsers.get(i).getText().startsWith("James")) {
					checkBoxes.get(0).click();
					staticWait(2000);
					clickDeleteButton();
					staticWait(4000);
					//driver.switchTo().alert().accept();
					click(By.xpath("//div/button[@title='OK']"),
							"Ok button", 20);
					System.out.println("user deleted");
					break;
				} else {
					System.out.println("Users with Name james not found.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void addMultipleUsers() {

		for (int j = 1; j <= 2; j++) {
			staticWait(7000);
			clickAddUser();
			selectTitle();
			selectUserType();
			enterFirstName();
			if (j == 1) {
				enterLastName();
			} else {
				enterLastNameOne();
			}
			if (j == 1) {
				enterEmail();
			} else {
				enterEmailOne();
			}
			selectGender();
			clickEnableLoginSwitch();
			enterPassword();
			enterConfirmPassword();
			selectTimezone();
			selectDOB();
			//selectDOD();
			selectDOJ();
			selectDOL();
			selectDepartment();
			selectDesignation();
			selectShift();
			if (j == 1) {
				enterEmployeeId();
			} else {
				enterEmployeeIdOne();
			}
			enterAliasName();
			clickVirtualUserSwitch();
			clickSave();
			clickActionButton();
			clickAssociateLicenses();
			clickTicketingLicense();
			addLicenseSuccessMessage();
			closeLicensePopup();
			clickActionButton();
			clickConfiguration();
			enableTicketResolve();
			clickSaveSettings();
			verifySuccessMessage(By.cssSelector("#notifymessage div"), "Record(s) has been successfully saved.", 20);
			clickCloseConfiguration();

		}
	}

	public void addSkillsForCreatedUser() {

		staticWait(4000);
		for (int i = 0; i <= 1; i++) {
			if (findMultipleElement(By.xpath("//table[@id='tableResponsive']/tbody/tr//td[2]//a"), 30).get(i).getText()
					.startsWith("James")
					&& (findMultipleElement(By.xpath("//table[@id='tableResponsive']/tbody/tr//td[2]//a"), 30).get(i)
							.getText().startsWith("James"))) {
				findMultipleElement(By.xpath("//table[@id='tableResponsive']/tbody/tr//td[2]//a"), 30).get(i).click();
				clickSkill();
				clickAddSkill();
				clickSkillCheckbox();
				clickSaveButton();
				navigateToCompanySetupUsersList();
				staticWait(5000);
			} else {
				System.out.println("Users with Name james not found.");
			}

		}
	}

	// click Skill Checkbox
	public void clickSkillCheckbox() {
		clickByJavascript(By.id("chk_5"), "Skill Checkbox", 5);
	}

	// click Save button
	public void clickSaveButton() {
		click(By.cssSelector("#btnPopupSave"), "Save Button", 20);
	}

	public void navigateToCompanySetupUsersList() {
		staticWait(3000);
		pageNavigate(prop.getProperty("companyUsersListingPage"), "Company Setup User screen.");
	}

	// click Save Settings
	public void clickSaveSettings() {
		click(By.cssSelector("#hlkSave"), "Save Settings", 20);
	}

	public void navigateToAddGroup() {
		pageNavigate(prop.getProperty("addGroupPage"), "Add group page.");
	}

	// click Skill
	public void clickSkill() {
		staticWait(3000);
		clickByJavascript(By.xpath("//a[text()=' Skill']"), "Skill", 20);
		
	}
	

	// click Add Skill
	public void clickAddSkill() {
		staticWait(3000);
		click(By.xpath("//a[@id='addSkills']"), "Add Skill", 25);
	}

	/*
	 * public String getSkillName() { String skillname =
	 * prop.getProperty("skilltitle") + datevalue; return skillname; }
	 */
	public void enterSkillTitleName() {
		staticWait(3000);
		skillname = prop.getProperty("skilltitle") + datevalue;
		//enter(By.id("SkillTitle"), skillname, "skill Title", 25);
		enter(By.xpath("//tg-input/descendant::input[@id='SkillId']"), skillname, "skill Title", 25);
		//String skillnewname = skillname;
	

	}
	public void enterSkillDescription() {
		staticWait(2000);

		enter(By.xpath("//textarea[@id='Description']"), prop.getProperty("skillDescription"), "Enter Description", 20);
	}
	public void saveskill() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Skill Name", 20);
		staticWait(3000);
	}


	public void AddButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@popupopenaction='OpenDepartmentPopUp']"), "Add Department", 25);
	}

	public String enterDepttNameNotVisibleClient() {

		departmentname = prop.getProperty("departmentname") + datevalue;
		return departmentname;
	}

	public void enterDepartmentDesciption() {
		staticWait(2000);

		enter(By.xpath("//tg-input/input[@id='DepartmentName']"), departmentname, " Department Name", 25);
	}

	public void departmentDesciption() {
		staticWait(2000);
		departmentDescription = prop.getProperty("enterDeptDescription");
		enter(By.xpath("//tg-textarea/textarea[@id='DepartmentDescription']"), departmentDescription, "Department Description", 25);
	}

	public void Save() {
		staticWait(2000);
		clickByJavascript(By.xpath("//button[text()='Save']"), "save button", 30);
		staticWait(2500);
	}

	public void clickFullMenuDropDown() {
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
		staticWait(2000);
	}

	public void clickCompanySetupLink() {
		click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"), "Company Setup Link", 30);
		staticWait(2000);
	}

	public void clickCompanySetupPage() {
		click(By.xpath("//a[contains(text(),'Company Setup')]"), " Company Setup Page", 30);
		staticWait(2000);
	}

	public void companySetup() {
		findElementVisibility(By.xpath("//a[@id='cadmin_messageboard_link' and @data-original-title='Company Setup']"),
				5);
		click(By.xpath("//a[@id='cadmin_messageboard_link' and @data-original-title='Company Setup']"),
				" Company Setup Page", 30);
		staticWait(2000);
	}

	public void clickOnChannel() {
		clickByJavascript(By.xpath("//a[text()='Channel']"), "Channel", 20);
		staticWait(2000);
	}

	public void clickOnAdd() {
		waitForElementInVisibility(By.xpath("//a[@id='ancCreateChannel']"), 30);

		click(By.xpath("//a[@id='ancCreateChannel']"), "Add Channel", 25);

	}

	public void save() {
		clickByJavascript(By.xpath("//a[@id='btnSave']"), "Save Channel Name", 20);
		staticWait(5000);
	}

	public void enterChannelName() {

		 String Channelname = prop.getProperty("channelName") + AddTicketPage.ticketSubject;
		System.out.println(Channelname);
		enter(By.id("ChannelName"), Channelname, "ChannelName", 25);
		Channelnewname = Channelname;
	}

	public void clickChannelName() {
		click(By.xpath("//table[@id='tblChannel']//a"), "Channel Name", 25);
	}
	public void selectStatus() {
		staticWait(3000);
		selectValueWithText(By.xpath("//select[@id='StatusId']"),"Active", "Status", 20);
	}

}
