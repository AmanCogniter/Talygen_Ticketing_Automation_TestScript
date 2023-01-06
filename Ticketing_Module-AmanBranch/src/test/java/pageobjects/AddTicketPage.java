package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.Config;
import utils.PropertiesLoader;
import utils.WebBasePage;

// author Rishabh
public class AddTicketPage extends WebBasePage {
	WebDriver driver;
	AddTicketPage addTicketPage;
	CompanySetupPage companySetupPage;
	AddSLAPage addSLAPage;
	static String getTicketNo;
	static String getTicketSubject;
	static String getCreatedDept;
	static String ticketNoGenerated;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	/* Modified */
	String filePath = System.getProperty("user.dir") +
			  "\\src\\main\\resources\\testfiles\\";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);

	public AddTicketPage(WebDriver driver) {
		super(driver, "Add Ticket Page");
		this.driver = driver;
		// addTicketPage = new AddTicketPage(driver);
	}

	static String ticketSubject = nameGenerator();
	String department = "Sales";
	String priority = "High";
	String product = "Others";
	String ticketCategory = "Router";
	String Ticketfor = "OnBehalf";
	String UserorClient = "User";
	String user = "Matthew";

//	public String ticketGeneratedNo = getTicketNoText();

	// click on full menu
	public void clickFullMenu() {
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on Add Ticket
	public void clickAddTicket() {
		staticWait(3000);
//		findElementVisibility(By.cssSelector("#menuiatem22"), 5);
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Add Ticket']"), "Add Ticket",
				10);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		clickByJavascript(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on Ticketing submenu
	public void ticketingSubMenu() {
		findElementVisibility(By.xpath("//li[@id='menuitem22']/span"), 10);
		clickByJavascript(By.xpath("//li[@id='menuitem22']/span"), "Ticketing Sub Menu", 25);
	}

	// click on Ticketing submenu SLA
	public void clickSLA() {
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='SLA']"),
				"SLA from full menu", 5);
	}

	// Click on Add ticket icon
//	public void clickAddTicketIcon() {
//		click(By.linkText("Add Ticket"), "Add Ticket", 5);
//	}

	// Click on enter ticket Subject
	public void enterTicketSubject() {
		findElementVisibility(By.cssSelector("input#a"), 10);
		enter(By.cssSelector("#TicketSubject"), ticketSubject, "Subject", 20);
//		getTicketSubject = ticketSubject;
	}

	// Click on enter ticket Subject
	public void enterPreviousTicketSubject() {
		findElementVisibility(By.cssSelector("input#a"), 10);
		enter(By.cssSelector("#TicketSubject"), ticketSubject, "Subject", 20);
//			getTicketSubject = ticketSubject;
	}

	// get subject text
//	public String getTicketSubject() {
//		ticketSubject = getAtribute(By.cssSelector("#TicketSubject"), "type", 20);
//		return ticketSubject;
//	}

	public void getTicketNoText() {
		referenceNumText();
//		return getTicketNo;
	}

	// Select Department DropDown
	public void selectDepartment() {
		String value = (department.equals("Human Resource")) ? "281424"
				: (department.equals("Sales")) ? "281423" : (department == "Utility Locate Technician") ? "281422" : "";
		selectValueWithValue(By.cssSelector("#DepartmentId"), value, "Department", 10);
	}

	// Select Priority DropDown
	public void selectPriority() {
//		String value = (priority.equals("High")) ? "HIgh" : (priority.equals("Low")) ? "140836" : "";
//		clickByJavascript(By.cssSelector("#PriorityId"), "select priority", 8);
//		selectValueWithText(By.cssSelector("#PriorityId"), "HIGH", "select priority", 30);
		selectValueWithText(By.cssSelector("#PriorityId"), "High", "select priority", 30);
//		selectValueWithText(By.cssSelector("#PriorityId"), "Critical", "select priority", 30);
	}

	// Select Product DropDown
	public void selectProduct() {
//		String value = (product.equals("aOthers")) ? "86" : "";
		clickByJavascript(By.cssSelector("#ProductId"), "select product", 8);
		selectValueWithText(By.cssSelector("#ProductId"), "Others", "select product", 30);
	}

	// Select CCUser
	public void selectCCUsers() {
		click(By.xpath("//label[text()='CC Users:']//following::button[1]"), "CC User", 5);
		click(By.xpath("(//input[@class='checkmultiselect'])[3]"), "User", 8);
	}

	// Select Category DropDown
	public void selectCategory() {
//		selectValueWithText(By.cssSelector("#TicketCategoryId"), "Critical", "select Ticket Category", 20);
		selectValueWithText(By.cssSelector("#TicketCategoryId"), "Issue in Software", "select Ticket Category", 20);

//		click(By.xpath("//label[text()='Ticket Category:']"), "Title", 10);
	}

	// Select TicketFor
	public void selectTicketForOnBehalf() {
		String id = (Ticketfor.equals("Self")) ? "#rdo_0" : (Ticketfor.equals("OnBehalf")) ? "#rdo_1" : "";
		clickByJavascript(By.cssSelector(id), "Ticket For On Behalf option", 8);
	}

	// Select OnBehalf
	public void selectUserOnBehalf() {
		String id = (UserorClient.equals("User")) ? "#rdo_2" : (UserorClient.equals("Client")) ? "#rdo_3" : "";
		clickByJavascript(By.cssSelector(id), "Ticket For", 8);
	}

	// Select OnBehalf of Client
	public void selectUserOnBehalfClient() {
		clickByJavascript(By.cssSelector("#rdo_3"), "On Behalf of Client", 8);
	}

	// Select User DropDowm
	public void userDropDown() {
		waitForVisibilityOfElement(By.xpath("//*[@id='OnBehalfUserId']"), 50);
		click(By.xpath("//*[@id='OnBehalfUserId']"), "click on Select", 10);
		click(By.xpath("//*[@id='OnBehalfUserId']/option[2]"), "Harry jasnon ( Sales ) ", 10);
	}

	// click on add more button
	public void addMoreDocumentField() {
		clickByJavascript(By.xpath("(//a[@id='addmailBlackListed'])[2]"), "Add More Document", 5);
	}

	// upload file
	public void uploadDocument() {
		staticWait(3000);
		//findElementVisibility(
				//By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
		/*
		 * driver.findElement(By.
		 * xpath("(//div[@class='bootstrap-filestyle input-group']/input[@type='text'])[2]"
		 * )) .sendKeys(Config.testfilePDF);
		 */

		  findElementPresence(By.xpath("//div[@class='custom-file']/input[@name='FileSrc']"), 20)
		  .sendKeys(filePath + prop.getProperty("testfileDoc"));

	}

	// clear Document
	public void clearDocumentFunctionality() {
		click(By.cssSelector("a.round-icon-small.btn-danger-light.clsattclear"), "Clear uploaded Document", 15);
		verifyFileUploadTrue();
	}

	// enter document in Template
	public void enterDescription() {
		staticWait(3000);
		click(By.xpath("//span[text()='Source']"), "Source", 15);
		enter(By.xpath("//div[@id='cke_1_contents']/textarea"), prop.getProperty("ticketDescription"), "Description", 15);
	}

	// click on save draft
	public void clickSaveDraft() {
		staticWait(2000);
		click(By.cssSelector("a#btnSaveDraft"), "Save as Draft", 8);
	}

	// click on submit ticket
	public void clickSubmitTicket() {
		staticWait(3000);
		WebElement submitButton = driver.findElement(By.xpath("//div/a[@id='btnSaveTicket']"));
		Actions action= new Actions(driver);
		action.moveToElement(submitButton).click().perform();
		logger.info("Submit button clicked");
		//clickByJavascript(By.xpath("//div/a[@id='btnSaveTicket']"), "Submit button", 10);
	}
	// click on Close notify message popup
		public void clickOncloseNotifyMessagePopUp() {
			staticWait(3000);
			click(By.xpath("//button[@id='closenotifymessage']"), "Close Notify Message PopUp", 10);
			driver.navigate().refresh();
		}

	// click on back to list
	public void clickBackToList() {
		staticWait(2000);
		click(By.cssSelector("a#btnback"), "Back To List", 10);
	}

	//

	public void movetoEditPage() {
		click(By.xpath("(//a[text()='" + ticketSubject + "']//following::a[@class='btnright'])[1]"), "Option Arrow", 8);
		staticWait(2000);
		click(By.xpath("(//a[text()='" + ticketSubject + "']//following::span[contains(text(),'Edit')])[1]"), "Edit",
				5);
	}

	// click on submit ticket
	public void submitTicket() {
		staticWait(2000);
		click(By.cssSelector("a#btnSaveTicket"), "Submit", 10);
	}

	// click on Assigned to department dropdown
	public void clickAssignedToDepartment() {
		click(By.cssSelector("#DepartmentId"), "Drop down select by department", 20);
	}

	// click on Ticket Category dropdown
	public void clickTicketCategory() {
		click(By.cssSelector("#TicketCategoryId"), "Ticket Category Depatment", 10);
	}

	// click on Assigned to Priority dropdown
	public void clickPriorityDropDown() {
		click(By.cssSelector("#PriorityId"), "Drop down select by Priority", 10);
	}

	// click on Assigned to Product dropdown
	public void clickProductDropDown() {
		click(By.cssSelector("#ProductId"), "Drop down select by Product", 10);
	}

	// click on behalf of client
	public void clickOnBehalfOfClient() {
		click(By.xpath("//input[@class='form-check-input rdoOnBehalf rdoClient custom-control-input']"),
				"on behalf of client.", 10);
	}

	// Verify success message
	public void verifySuccessMessage() {
		findElementVisibility(By.cssSelector("#divAddTicket p"), 50);
		String successMessage = getText(By.cssSelector("#divAddTicket p"), 50);
		if (successMessage.equals("Ticket has been successfully Submitted with reference number")) {
			getTest().log(LogStatus.PASS, "Ticket succesfully submitted");
			logger.info("Success message displayed is :: " + successMessage);
		} else {
			getTest().log(LogStatus.FAIL, "Ticket not succesfully submitted");
			takeScreenshot("Ticket Success message not displayed successfully.");
			Assert.fail("Ticket Success message not displayed successfully.");
			logger.info("Success message is not displayed.");
		}
	}

	// Ticket listing page
	public void verifyTicketListingPage() {
		String elementinListingPage = getText(By.cssSelector("span#showHideMenuParent"), 10);
		if (elementinListingPage.equals("TICKETING")) {
			getTest().log(LogStatus.PASS, "Ticket Listing page is successfully displayed");
			logger.info("Ticket Listing page is successfully displayed");
		} else {
			getTest().log(LogStatus.FAIL, "Ticket Listing page is not successfully displayed");
			logger.info("Ticket Listing page is not successfully displayed");
			Assert.fail("Ticket Listing page is not successfully displayed");

		}
	}

	// matching dropDowm values
	public boolean verifyDropDownValues(String deptValue, int counter, String valuesFromFile) {
		Boolean match = false;

		String[] exp = new String[] {};
		int count = 0;
		if (counter > 1) {
			exp = valuesFromFile.split(",");
		}
		List<WebElement> options = driver.findElements(By.xpath("//select[@name='" + deptValue + "']//option"));
		staticWait(3000);
		for (WebElement valuesFromWeb : options) {
			for (int i = 0; i < exp.length; i++) {
				if (valuesFromWeb.getText().equalsIgnoreCase(exp[i])) {
					count++;
				}
			}
		}
		if (count == exp.length) {
			getTest().log(LogStatus.PASS, "Dropdown values is matched");
			logger.info("DropDown values are matched");
		} else {
			getTest().log(LogStatus.FAIL, "Dropdown values is not matched.");
			logger.info("DropDown values are not matched");
			takeScreenshot("Dropdown values is not matched");
			Assert.fail("" + "Dropdown values is not matched");
		}
		return match;
	}

	// verify validation message
	public void verifyValidateMessage(String value) {
		String validationMessage;
		try {
			findElementsVisibility(By.xpath("//span[text()='" + value + "']"));
			validationMessage = getText(By.xpath("//span[text()='" + value + "']"), 20);
			logger.debug("validation message is :: " + validationMessage);
			if (validationMessage.equals(value)) {
				getTest().log(LogStatus.PASS, validationMessage + " is successfully displayed");
			} else {
				getTest().log(LogStatus.FAIL, "Validation message is not successfully displayed");
				logger.debug("validation message is not displayed");
				takeScreenshot(validationMessage);
				Assert.fail("" + validationMessage);
				validationMessage = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// verify Radio buttons
	public void verifyRadioButtons() {
		toCheckElementIsDisplayed(By.xpath("//label[@class='mb-0' and @for='TicketFor']"), 5, "self radio button");
		toCheckElementIsDisplayed(By
				.xpath("//label[@class='custom-control-label' and @for='rdo_1']//following::label[@for='OnBehalf'][1]"),
				5, "On behalf radio button");

	}

	// validate fields with no validation message
	public String checkNoValidations(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (!attribute.contains(attributeValue)) {
			logger.info(name + " Validation Message is displayed");
			getTest().log(LogStatus.PASS, name + " Validation Message is displayed");
		} else {
			logger.info("Validation message is not displayed.");
			getTest().log(LogStatus.FAIL, name + " Validation Message is not displayed");
			Assert.fail("" + name + "Validation Message is displayed");
			takeScreenshot("Validation message is not dispalyed");
		}
		return attribute;
	}

	// click om Self Radio button
	public void clickSelf(String name) {
		staticWait(3000);
		try {
			clickByJavascript(By.xpath("//input[@class='form-check-input rdoticketfor custom-control-input']"),
					"click Self radio button", 10);
		} catch (Exception e) {
			logger.info("Unable to click on Self Button.");
			getTest().log(LogStatus.FAIL, name + " Self radio button is not clickable");
			Assert.fail("" + name + "Self radio button is not clickable");
			takeScreenshot("Self radio button is not clickable");

		}
	}

	// click On Behalf radio button
	public void clickOnBehalf(String name) {
		try {
			clickByJavascript(
					By.xpath("//input[@class='form-check-input rdoticketfor rdoBehalf custom-control-input']"),
					"click on On behalf radio button", 10);
		} catch (Exception e) {
			logger.info("On behalf radio button is not clickable.");
			getTest().log(LogStatus.FAIL, name + " On behalf radio button is not clickable");
			Assert.fail("" + name + "On behalf radio button is not clickable");
			takeScreenshot("On behalf radio button is not clickable");

		}
	}

	public void checkPresenceOfRadioButtons() {
		toCheckElementIsDisplayed(By.xpath("//div[@class='form-control pl-0 border-0' ]"), 20,
				"Both Radio buttons are displayed");
	}

	public void radioButtonsPresence() {
		toCheckElementIsDisplayed(By.cssSelector("#rdoTicketFor div div:nth-child(1)"), 20, " Self Radio button");
		toCheckElementIsDisplayed(By.cssSelector("#rdoTicketFor div div div:nth-child(2)"), 20,
				" On behalf Radio button");
	}

	// validate files upload status
	public String verifyFileUploadSuccess(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (!attribute.contains(attributeValue)) {
			logger.info(name + " Succesfully");
			getTest().log(LogStatus.PASS, name + " Succesfully");
		} else {
			logger.info("File is not uploaded Succesfully");
			getTest().log(LogStatus.FAIL, name + " not Succesfully");
			Assert.fail("" + name + "File is not uploaded Succesfully");
			takeScreenshot("File is not uploaded Succesfully");
		}
		return attribute;

	}

	// validate files not upload status
	public String verifyFileNotUpload(String attributeValue, String name, By by) {
		WebElement ele = findElementVisibility(by, 2);
		String attribute = ele.getAttribute(attributeValue);
		if (attribute.contains(attributeValue)) {
			logger.info(name + " Successfully");
			getTest().log(LogStatus.PASS, name + " is not uploaded Succesfully");
//			Assert.fail("" + name + "File is not uploaded Successfully");
//			takeScreenshot("File is not uploaded Successfully");
		} else {
			getTest().log(LogStatus.FAIL, name + " uploaded Succesfully");
			takeScreenshot("FileNotUploadSuccesfully");
			Assert.fail("FileNotUploadSuccesfully");
			logger.info("File is uploaded Succesfully");
		}
		return attribute;
	}

	public void checkAddMoreFunctionality() {
		//toCheckElementIsDisplayed(By.cssselector("#dvfile1000  >div"), 10, "Attachment added successfully");
		toCheckElementIsDisplayed(By.xpath("//a[@id='addmailBlackListed']"), 10, "Attachment added successfully");
	}

	public void verifyFileUploadTrue() {
		verifyFileUploadSuccess("autocomplete", "File is ",
				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));
	}

	public void verifyFileUploadFalse() {
		verifyFileNotUpload("autocomplete", "File is",
				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));

	}

	public void clickOnClearButton() {
		click(By.xpath("(//a[@class='round-icon-small btn-danger-light clsattclear' and @data-original-title='Clear'])[2]"),
				"Clear Button clicked", 10);
	}

	public void checkFileClearFunctionality() {

		getAtribute(By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"),
				"disabled", 40);
//		verifyFileNotUpload("disabled", "File is Cleared",
//				By.xpath("//div[@id='divFiles']//input[@type='text' and @disabled='' and @autocomplete='off' ]"));
	}

	public void clickOnRemoveButton() {
		click(By.xpath(
				"//a[@class='round-icon-small btn-danger-light clsattremove' and @data-original-title='Remove']"),
				"Click on Remove", 15);
	}

	public void enterDescriptionMoreCharacters() {

		click(By.cssSelector("#cke_12"), "Source", 15);
		enter(By.cssSelector(".cke_source"), prop.getProperty("descriptionWithCharacters"),
				"Description with more than 500 charcters", 15);
	}

	public void referenceNumText() {
		ticketNoGenerated = getText(By.cssSelector("#divAddTicket > div b"), 20);
		System.out.println("ticket  :::::" + ticketNoGenerated);
//		return ticketNoGenerated;
	}

	public void ClickOnuserGuide() {
		click(By.cssSelector("span.user-guide.ml-3"), "click on user guide", 20);
	}

	public void verifyFontOfUserGuide() {
		getCssValue(By.cssSelector("#mCSB_3_container > div"), prop.getProperty("fontCssValue"),
				prop.getProperty("fontExpValue"), 15, "font of User gUide is verified");
	}

//	public void getTaicketNoText() {
//		getTicketNo = referenceNumText();
//		return getTicketNo;
//	}

//	public void selectCreatedDepartment(String deptName) {
//		selectValueWithText(By.cssSelector("#DepartmentId"), deptName, "Select added department", 30);
//	}

	public void selectCreatedDepartment() {
		staticWait(3000);
		selectValueWithText(By.cssSelector("#DepartmentId"), CompanySetupPage.departmentname, "Select added department",
				30);
	}

	public void navigateToAddTicketPage() {
		pageNavigate(prop.getProperty("addTicketPageUrl"), "Navigate To Add Ticket Page");
	}

	public void selectClientRadio() {
		clickByJavascript(By.cssSelector("#rdo_3"), "client radio", 20);
	}

	public void selectClient() {
		staticWait(3000);
		click(By.xpath("//span[@id='select2-ddlOnBehalfClientId-container']/span[text()='Select Client']/ancestor::span[@class='selection']/descendant::span[@role='presentation']/b"),
				"client", 20);

//		clickByJavascript(By.cssSelector(
//				"//label[@class='lblctrlname' and text()='Client:']//following::ul[@class='multiselect-container dropdown-menu select-custom show']//li[@class='active']//a[1]"),
//				"client ", 20);
		enter(By.xpath("//span[@class='select2-search select2-search--dropdown']/input"), "talygen .com", "Talygen", 30);
		staticWait(3000);
		click(By.xpath("//ul/li[contains(text(),'talygen')]"), "Talygen.com", 20);

	}

	public void enterClientDetails() {

		enter(By.cssSelector("#FirstName"), prop.getProperty("enterFirstName"), "First Name", 20);

		enter(By.cssSelector("#LastName"), prop.getProperty("enterLastName"), "Last Name", 20);

		enter(By.cssSelector("#Password"), prop.getProperty("enterPassword"), "Password", 20);

		enter(By.cssSelector("#ConfirmPassword"), prop.getProperty("enterConfirmPassword"), "Confirm Password", 20);

		enter(By.cssSelector("#EmailId"), datevalue + prop.getProperty("enterMailId"), "Confirm Password", 20);

	}

	public void selectChannel() {
		selectValueWithText(By.cssSelector("#TicketChannel"), CompanySetupPage.Channelnewname, "ticket channel name",
				20);
	}

	public void selectSlaDepartment() {
		staticWait(3000);
		selectValueWithText(By.cssSelector("#DepartmentId"), CompanySetupPage.departmentname,
				"Department name" + CompanySetupPage.departmentname, 20);
	}
}
