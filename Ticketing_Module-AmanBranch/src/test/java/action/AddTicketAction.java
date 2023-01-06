package action;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageobjects.AddTicketPage;
import pageobjects.CompanySetupPage;
import pageobjects.TicketListingPage;
import pageobjects.TicketSummaryReportPage;
import pageobjects.TicketDetailReportPage;
import utils.PropertiesLoader;

public class AddTicketAction extends AddTicketPage {

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;
	TicketListingAction ticketListingAction;
	TicketListingPage ticketListingPage;
	CompanySetupPage companySetupPage;
	TicketDetailReportPage ticketDetailReportPage;
	TicketSummaryReportPage ticketSummaryReportPage;

	AddTicketPage addTicketPage;
	static String getTicketNo;
	static String channelCreated;
	public static String getCreatedDept;

	public AddTicketAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.ticketListingPage = new TicketListingPage(driver);
		this.companySetupPage = new CompanySetupPage(driver);
		this.ticketDetailReportPage = new TicketDetailReportPage(driver);
		this.ticketSummaryReportPage = new TicketSummaryReportPage(driver);
		this.addTicketPage = new AddTicketPage(driver);
	}

//	String getTicketNo;
	public void navigatetoAddTicket() {
		clickFullMenu();
		clickTicketingSideMenu();
		clickAddTicket();
//		clickTicketingOption();
//		ticketingSubMenu();
	}

	public void navigatetoSLA() {

		clickFullMenu();
		clickTicketingSideMenu();
//		clickTicketingOption();
		clickSLA();
	}

	// common methods
	public void c() {
//		clickAddTicketIcon();
		addTicketOnSelf();

	}

	public void searchTicket() {
		ticketListingAction.clickOnTicketNumber();
//		ticketListingPage.enterGeneratedTicketNumber();
	}

	public void ticketSettings() {
		enterTicketSubject();
		selectNewAddedDept();
		selectPriority();
		selectProduct();
		//selectCCUsers();
		selectCategory();
		selectTicketForOnBehalf();
	}

	public void addTicketOnBehalfOfUser() {
		radioButtonsPresence();
		ticketSettings();
		selectUserOnBehalf();
		userDropDown();
		uploadDocument();
		enterDescription();/* Modified */
		clickSubmitTicket();/* Modified */
//		addMoreDocumentField();
		//submitAndCheckMessage();
	}

	public void addTicketWithChannel() {
		radioButtonsPresence();
		ticketSettings();
		selectUserOnBehalf();
		selectClientRadio();
		selectClient();
		selectChannel();
		//enterClientDetails();
		//userDropDown();
		uploadDocument();
		//addMoreDocumentField();
		submitAndCheckMessage();
	}

	// common usea
	public void addTicketOnSelf() {
		enterTicketSubject();
		selectNewAddedDept();
		selectPriority();
		selectProduct();
		//selectCCUsers();
		selectCategory();
		//selfButton();
		uploadDocument();
		enterDescription();
		clickSubmitTicket();
		verifySuccessMessage();
		getTicketNoText();
		ticketListingPage.navigateToTicketListingPage();
		ticketListingPage.ticketNumber();
		ticketListingPage.enterGeneratedTicketNumber();
		ticketListingPage.clickSearchIcon();
	}

	public void ticketSearch() {
		getTicketNoText();
		ticketSummaryReportPage.navigateToTicketReportPage();
		ticketSummaryReportPage.enterTicketNumber();
	}

	// common ause
	public void addTicket() {
//			clickAddTicketIcon();
		enterTicketSubject();
//		getTicketSubject();
//			selectDepartment();
		selectNewAddedDept();
		selectPriority();
		selectProduct();
		//selectCCUsers();
		selectCategory();
		selfButton();
		uploadDocument();
		enterDescription();
		clickSubmitTicket();
		verifySuccessMessage();
		getTicketNoText();
		ticketListingPage.navigateToTicketListingPage();
		ticketListingPage.ticketNumber();
		ticketListingPage.enterGeneratedTicketNumber();
		ticketListingPage.clickSearchIcon();

//			String ticketSubject = getTicketSubject();
//			ticketSummaryReportPage.enterSubject(ticketSubject);

//	    	ticketListingPage.enterGeneratedTicketNumber(getTicketNo);
	}

	public void selfTicketSettings() {
		ticketSettings();
		selfButton();
		uploadDocument();
		enterDescWWithMoreCharacters();
		clickSubmitTicket();
		verifySuccessMessage();
		textFromReferenceNo();
	}

	public void verifyUserDropDownValidation() {
		ticketSettings();
		onBehalfButton();
		selectUserOnBehalf();
//		submitAndCheckMessage();
	}

	public void submitWithDescription() {
		ticketSettings();
		enterDescription();
		uploadDocument();
		verifyFileUploadTrue();
		clickSubmitTicket();
		verifySuccessMessage();
	}

	public void validationForEmptyUser() {
		uploadDocument();
		verifyFileUploadTrue();
		enterDescription();
		clickSubmitTicket();
	}

	public void submitAndCheckMessage() {
		uploadDocument();
		verifyFileUploadTrue();
		enterDescription();
		clickSubmitTicket();
		verifySuccess();
//		checkValidationWithEmptyUser();
	}

	public void editTicket() {
		movetoEditPage();
		submitTicket();
	}

	public void verifyNavigations() {
		verifySuccessMessage();
		clickBackToList();
		verifyTicketListingPage();
	}

	public void departmentDropDown() {
		verifyDropDownValues("DepartmentId", 2, prop.getProperty("departmentDropDownList"));
	}

	public void ticketCategoryDropDown() {
		verifyDropDownValues("TicketCategoryId", 0, prop.getProperty("ticketCategoryDropDown"));
	}

	public void submitButton() {
		submitTicket();
	}

	public void ticketCategory() {
		clickTicketCategory();
	}

	public void validateRadioButtons() {
		verifyRadioButtons();
	}

	public void verifyValidations() {
		verifyValidateMessage(prop.getProperty("subjectValidation"));
		verifyValidateMessage(prop.getProperty("assignedValidation"));
		verifyValidateMessage(prop.getProperty("priorityValidation"));
	}

	public void priorityDropDown() {
		verifyDropDownValues("PriorityId", 2, (prop.getProperty("priorityDropDownList")));
	}

	public void productDropDown() {
		clickProductDropDown();
	}

	public void verifyproductDropDown() {

		verifyDropDownValues("ProductId", 2, prop.getProperty("productDropownList"));
	}

	public void checkNoValidationMessage() {
		checkNoValidations("class", "Product dropdown", By.xpath("//select[@id='ProductId']"));
	}

	public void onBehalfButton() {
		clickOnBehalf("On Behalf button clicked");
	}

	public void selfButton() {
		clickSelf("Self Button clicked");
	}

	public void checkValidationWithEmptyUser() {
		verifyValidateMessage(prop.getProperty("userDropDown"));
	}

	public void checkClientValidation() {
		verifyValidateMessage(prop.getProperty("clientValidation"));
	}

	public void FileNotUploaded() {
		verifyFileUploadFalse();
	}

	public void validateFileUpload() {
		verifyFileUploadTrue();
	}

	public void verifySuccess() {
		verifySuccessMessage();
	}

	public void verifyNewAttachmentTab() {
		checkAddMoreFunctionality();
	}

	public void ClearButton() {
		clickOnClearButton();
	}

	public void validateClearButtonFunctionality() {
		checkFileClearFunctionality();
	}

	public void createTicketSelf() {
		selfButton();
		submitWithDescription();

	}

//	public void enterAndSearchTicketNo() {
//		ticketListingAction.navigateToTicketListingPage();
//		ticketListingAction.clickOnTicketNumber();
//		
//		ticketListingAction.enterGeneratedTiacketNumber(ticketNo);
//
//	}

	public void removeButton() {
		clickOnRemoveButton();
	}

	public void enterDescWWithMoreCharacters() {
		enterDescriptionMoreCharacters();
	}

	public void textFromReferenceNo() {
		referenceNumText();
	}

	public void userGuide() {
		ClickOnuserGuide();
	}

	public void FontOfUserGuide() {
		verifyFontOfUserGuide();
	}

	public void moveToAddTicketPage() {
		navigateToAddTicketPage();
	}

//	public void selectNewAddedDept() {
//		 getCreatedDept = companySetupPage.enterDepttNameNotVisibleClient();
//		selectCreatedDepartment(getCreatedDept);
//	}

	public void selectNewAddedDept() {
//     companySetupPage.enterDepttNameNotVisibleClient();
		selectCreatedDepartment();
	}

	public void selectSLADept() {
//	     companySetupPage.enterDepttNameNotVisibleClient();
		selectSlaDepartment();
	}

	// common use
	public void addTicketForSLA() {
//			clickAddTicketIcon();
		
		enterTicketSubject();
//		getTicketSubject();
//			selectDepartment();
		selectSlaDepartment();
		selectPriority();
		selectProduct();
		//selectCCUsers();
		selectCategory();
		//selfButton();
		uploadDocument();
		enterDescription();
		clickSubmitTicket();
		verifySuccessMessage();
	}

}
