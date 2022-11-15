package pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class AddGroupPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	CompanySetupPage companysetup;
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	public static int characterLength;
	public static String groupName;
	CompanySetupPage companysetuppage= new CompanySetupPage(driver);
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String dateValue = simpleDateFormat.format(new Date());

	public AddGroupPage(WebDriver driver) {
		super(driver, "Add Group Page");
		this.driver = driver;
	}

	// Group Name with time
	public String groupNameWithTime() {
		String groupName = prop.getProperty("groupNameMoreCharacters") + dateValue;
		return groupName;
	}

	// enter Group Name for checking characters limit
	public void enterGroupNameWithLetters() {
		String groupNameWithTime = groupNameWithTime();
		enter(By.cssSelector("#TicketGroupName"), groupNameWithTime, "Enter Group Name", 45);
	}

	// enter Group Name
	public void enterGroupName() {
		groupName = prop.getProperty("enterGroupName") + dateValue;
		enter(By.cssSelector("#TicketGroupName"), groupName, "Enter Group Name", 45);
	}

	public void selectSkill() {
		staticWait(1000);
		//
		//companysetuppage.skillname;
		//waitForElementInVisibility(By.xpath("//tg-select/select[@id='SkillId']"), 30);
	
		
		click(By.xpath("//tg-select/select[@id='SkillId']"), "select skill", 40);
		
		//selectValueWithText(By.cssSelector("#SkillId"), "TESTER", "Testing selected from dropdown", 50);
		//selectValueWithText(By.xpath("//tg-select/select[@id='SkillId']"),"Add skill", "Testing selected from dropdown", 50);
		selectValueWithText(By.xpath("//tg-select/select[@id='SkillId']"),companysetuppage.skillname, "Testing selected from dropdown", 50);
	}

	public String getTextFieldAttribute() {

		String textAreaCharacters = getAtribute(By.cssSelector("#TicketGroupName"), "value", 40);
		logger.info("Character lrngth Is :"+textAreaCharacters.length());
		return textAreaCharacters;
	}

	public int getTextFieldValue(String CharactersCount) {
		String textAreaCharacters = CharactersCount;
		int charactersLength = textAreaCharacters.length();
		logger.debug("characters length ::" + charactersLength);
		return charactersLength;
	}

	
	/*
	 * public void checkCharactersLength() { String textAreaValue =
	 * getTextFieldAttribute(); getTextFieldValue(textAreaValue); int
	 * characterToCheck = getTextFieldValue(textAreaValue);
	 * verifyCharactersLength(characterToCheck,Integer.parseInt(prop.getProperty(
	 * "groupCharactersLength")), "Characters length is"); }
	 */
	 

	// select routing radio button
	public void selectRoutingButton() {
		clickByJavascript(By.xpath("//*[@id='rdo_1']"), "Routing button", 40);
	}

	// select assigned department
	public void selectSalesDept() {
		selectValueWithText(By.xpath("//tg-select/select[@id='DepartmentId']"), "Networks", "Assigned Department", 50);
		//findElementInVisibility(By.xpath("//div[@class='lds-ring']"), 40);
	}

	// Click add button
	public void selectFirstAddButton() {

		List<WebElement> userList = driver.findElements(By.xpath(

				"//tbody[@id='UserListDiv']//tr//td[1]"));

		for (int i = 0; i < userList.size(); i++) {
			String userListing = userList.get(i).getText();
			if (userListing.contains("David Bush") || userListing.contains("David Bush1")) {
				logger.info("David Bush User selected." + userListing);

				List<WebElement> addButton = driver.findElements(By.xpath(

						"//td[@class='text-center single-action']//a[@class='ancAddUsers round-icon-small btn-success-light d-block float-none m-auto']"));
				for (int j = 0; j >= 0; j++) {
					addButton.get(i).click();
					break;
				}
			} else {

			}
		}

//			String userListText = getText(By.xpath("//tbody[@id='UserListDiv']//tr//td[1]"), 20);

//		staticWait(2000);
//		List<WebElement> addButton = driver.findElements(By.xpath(
//
//				"//td[@class='text-center single-action']//a[@class='ancAddUsers round-icon-small btn-success-light d-block float-none m-auto']"));
//		for (int i = 0; i >= 0;) {
//			addButton.get(0).click();
//			break;
//		}
	}

	// select MarkAsDefault radio button
	public void selectMarkAsDefault() {
		clickByJavascript(By.cssSelector("#rdo_2"), "Marks As Default", 40);
	}

	// enter MarkAsDefault value
	public void enterDefaultValue() {
		enter(By.cssSelector("#maxticketassign"), prop.getProperty("enterMarksAsDefault"), "enter Default value", 40);
	}

	// enter enter Group Description
	public void enterGroupDescription() {
		enter(By.cssSelector("#Description"), prop.getProperty("enterGroupDescription"), "enter Group Description", 40);
	}

	public String getDescriptionFieldAttribute() {
		String textAreaCharacters = getAtribute(By.cssSelector("#Description"), "value", 40);
		return textAreaCharacters;
	}

	public int getDescriptionFieldValue(String CharactersCount) {
		String textAreaCharacters = CharactersCount;
		int charactersLength = textAreaCharacters.length();
		logger.debug("characters length ::" + charactersLength);
		return charactersLength;
	}

	// verify description length
	public void descriptionCharactersLength() {
		String textAreaValue = getDescriptionFieldAttribute();
		getDescriptionFieldValue(textAreaValue);
		int characterToCheck = getDescriptionFieldValue(textAreaValue);
		verifyCharactersLength(characterToCheck, Integer.parseInt(prop.getProperty("groupDescriptionCharLength")),
				"Characters length is");
	}

	// click Save button
	public void clickSaveButton() {
		click(By.cssSelector("#aGroupTicketSave"), "save button", 40);
	}

	// click cancel button
	public void clickCancelButton() {
		staticWait(3000);
		//findElementVisibility(By.xpath("//a[@data-original-title='Cancel']"), 20);
		clickByJavascript(By.xpath("//a[@data-original-title='Cancel']"), "Cancel button", 40);
	}

	// validation message
	public void verifysuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("groupSuccessMessage"), 40);
	}

	// validation No records message message
	public void verifyNoRecordsMessage() {
		verifySuccessMessage(By.cssSelector("#trNoRecordFond"), prop.getProperty("noRecordsMsg"), 40);
	}

	// select group
	public void selectGroup() {
		verifySuccessMessage(By.cssSelector("#trNoRecordFond"), prop.getProperty("noRecordsMsg"), 40);
	}

}