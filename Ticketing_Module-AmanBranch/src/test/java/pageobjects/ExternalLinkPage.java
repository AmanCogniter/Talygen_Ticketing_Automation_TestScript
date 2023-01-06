package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ExternalLinkPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String pattern = "yyMMddHHmmss";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	public static int characterLength;

	static String datevalue = dateformat.format(date);

	public ExternalLinkPage(WebDriver driver) {
		super(driver, "External Link Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		staticWait(3000);
		click(By.xpath("(//div/ul[@data-p-name='Ticketing']/li/a[@id='cadmin_messageboard_link'])[1]"), "Ticketing", 20);
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}
	public void clickOnTicketLayoutSetting() {
		staticWait(3000);
		click(By.xpath("//a[@data-original-title='Ticket Layout Settings']"),
				"Ticket Layout Setting", 20);
	}

	// click External Link
	public void clickExternalLink() {
		/*
		 * click(By.xpath(
		 * "//ul[@class='submenu clschild_40361 d-flex']//a[@data-original-title='External Link' and @id='cadmin_messageboard_link']"
		 * ), "External Link", 40);
		 */
		click(By.xpath(
				"//tg-input/input[@id='ExternalLayoutLink']"),
				"External Link", 40);
	}

	// verify Manage Layout External Link Url
	public void validateManageLayout() {
		getCurrentUrl(prop.getProperty("manageExternalLinkUrl"), "Manage Layout External-Link");
	}
	public void clickOnConfirmMessgaepopup() {
		click(By.xpath(
				"//button[@title='OK']"),
				"OK button", 40);
	}

	// click Save button
	public void clickSaveButton() {
		click(By.cssSelector("#btnSave"), "Save button", 20);
	}

	// click Reset button
	public void clickResetButton() {
		click(By.cssSelector("#btnResetLayout"), "Reset button", 20);
	}

	// verify Validation messages
	public void verifyValidationMessage() {
		verifySuccessMessage(By.id("spnContent"), prop.getProperty("headerTextValidation"), 15);
		int iteration = 0;
		for (int i = 1; i <= 2; i++) {
			iteration++;
			String validationMessage = getText(By.id("spnContent" + iteration), 20);
			verifySuccessMessage(By.id("spnContent" + 1), prop.getProperty("footerTextValidation"), 15);
			verifySuccessMessage(By.id("spnContent" + 2), prop.getProperty("homePageValidation"), 15);
		}
	}

	// enter enter Welcome Text
	public void enterWelcomeText() {
		enter(By.cssSelector("#WelcomeText"), prop.getProperty("enterWelcomeText"), "enter Welcome Text", 40);
	}

	public String getTextFieldAttribute() {

		String textAreaCharacters = getAtribute(By.cssSelector("#WelcomeText"), "value", 40);
		return textAreaCharacters;
	}

	public int getTextFieldValue(String CharactersCount) {
		String textAreaCharacters = CharactersCount;
		int charactersLength = textAreaCharacters.length();
		logger.debug("characters length ::" + charactersLength);
		return charactersLength;
	}

	public void checkWelcomeTextCharactersLength() {
		String textAreaValue = getTextFieldAttribute();
		getTextFieldValue(textAreaValue);
		int characterToCheck = getTextFieldValue(textAreaValue);
		verifyCharactersLength(characterToCheck, Integer.parseInt(prop.getProperty("welcomeTextCharactersLength")),
				"Characters length is");
	}

	public void switchToFrame() {

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		int size = driver.findElements(By.tagName("iframe")).size();

		for (int i = 0; i <= size; i++) {
			driver.switchTo().frame(i);
			WebElement element = findElementVisibility(By.tagName("body"), 15);
			if (i == 0) {
				element.clear();
				enter(By.tagName("body"), prop.getProperty("headerDescription"), "Add Header Description", 20);
				driver.switchTo().defaultContent();

			} else if (i == 1) {

				enter(By.tagName("body"), prop.getProperty("footerDescription"), "Add footer Description", 20);
				driver.switchTo().defaultContent();

			} else {
				enter(By.tagName("body"), prop.getProperty("homePageDescription"), "Add homePage Description", 20);
				driver.switchTo().defaultContent();
				break;
			}
		}
	}

	// enter External Layout Link
	public void enterExternalLayoutLink() {
		enter(By.cssSelector("#ExternalLayoutLink"), prop.getProperty("enterExternalLink"), "enter External Link", 40);
	}

	public void verifyLayoutSuccessMessage() {
		verifySuccessMessage(By.xpath("//div[@id='notifymessage']/div[@role='alert']/span[contains(text(),'Ticket Layout Settings has been successfully updated')]"), prop.getProperty("layoutSuccessMessage"), 40);
	}

	public String getExternaLink() {

		String externalLinkHttp = getText(
				By.xpath("//div[@class='input-group-prepend']//span[@class='input-group-text' and text()='https://']"),
				20);
//		String externalBaseLink = gettextByJSexecuter(By.cssSelector("#ExternalLayoutLink"), "external Base link",20);

		String externalBaseLink = prop.getProperty("enterExternalLink");
		String externalLastLink = getText(By.xpath(
				"//div[@class='input-group-prepend']//span[@class='input-group-text' and text()='.support.talygen.com']"),
				20);

		String externalLinkUrl = externalLinkHttp + externalBaseLink + externalLastLink;
		logger.debug("external Link Url :: " + externalLinkUrl);
		System.out.println("external Link Url :: " + externalLinkUrl);
		return externalLinkUrl;

	}

	public void switchToTab() {
		String externalLinkUrl = getExternaLink();

		((JavascriptExecutor) driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(externalLinkUrl);

	}

	// click Color picker
	public void clickColorPicker() {
		click(By.xpath(
				"//label[@for='BgColor' and text()='Background Color']//following::span[@class='input-group-text input-group-addon'][1]"),
				"Color picker", 20);
	}

	// click font Color saturation
	public void fontColor() {
		click(By.xpath(
				"//label[@for='FontColor' and text()='Font Color']//following::span[@class='input-group-text input-group-addon'][1]//following::div[@class='colorpicker-saturation'][2]"),
				"font Color picker", 20);
	}

	// click font Color picker
	public void clickFontColorPicker() {
		click(By.xpath(
				"//label[@for='FontColor' and text()='Font Color']//following::span[@class='input-group-text input-group-addon'][1]"),
				"font Color picker", 20);
	}

	// click pick Color saturation
	public void pickColor() {
		click(By.xpath(
				"//label[@for='BgColor' and text()='Background Color']//following::span[@class='input-group-text input-group-addon'][1]//following::div[@class='colorpicker-saturation'][1]"),
				"Color picker", 20);
	}

	// click pick Color saturation
	public String getPickerColorValue(By by, int time, String name) {
		String attributeName = getAtribute((by), "style", 20);
		// label[@for='BgColor' and text()='Background Color']//following::input[1]
		int r;
		int g;
		int b;

		String replaceAttribute = attributeName.replaceAll("background-color: rgb", "");
		String replacePunctuations = replaceAttribute.replaceAll("\\p{P}", "");

		String[] rgbValue = replacePunctuations.split(" ");
		int size = rgbValue.length;
		int[] arr = new int[size];
		arr[0] = Integer.parseInt(rgbValue[0]);
		arr[1] = Integer.parseInt(rgbValue[1]);
		arr[2] = Integer.parseInt(rgbValue[2]);

		r = arr[0];
		g = arr[1];
		b = arr[2];

		String hex = String.format("#%02X%02X%02X", r, g, b);
		logger.info("hex color value ::" + hex);
		Color.decode(hex);
		return hex;
	}

	// verifying hex color value from textfield
	public void verifyBgHexColorValue() {
		String hexColorSaturation = getPickerColorValue(By.xpath(
				"//label[@for='BgColor' and text()='Background Color']//following::span[@class='input-group-text input-group-addon'][1]//following::div[@class='colorpicker-saturation'][1]"),
				20, "picker Saturation value");

		logger.info("Hex Color value" + hexColorSaturation);

		String hexColorPicker = getPickerColorValue(
				By.xpath("//label[@for='BgColor' and text()='Background Color']//following::input[1]"), 20,
				"Picker color Textfield value");

		logger.info("Hex Color value" + hexColorPicker);

		if (hexColorSaturation.equals(hexColorPicker)) {
			getTest().log(LogStatus.PASS, hexColorSaturation + " is successfully displayed");
			logger.info("Hex color is successfully displayed");
		} else {
			getTest().log(LogStatus.FAIL, "Hex color is not displayed");
			logger.info("Hex color is not displayed");
			takeScreenshot("Hexcolor");
			Assert.fail("Hexcolor");
		}
	}

	// verifying font hex color value from textfield
	public void verifyFontHexColorValue() {
		String hexColorSaturation = getPickerColorValue(By.xpath(
				"//label[@for='FontColor' and text()='Font Color']//following::span[@class='input-group-text input-group-addon'][1]//following::div[@class='colorpicker-saturation'][2]"),
				20, "picker Saturation value");

		logger.info("Hex Color value" + hexColorSaturation);

		String hexColorPicker = getPickerColorValue(By.xpath(
				"//label[@for='FontColor' and text()='Font Color']//following::span[@class='input-group-text input-group-addon'][1]"),
				20, "Picker color Textfield value");
		logger.info("Hex Color value" + hexColorPicker);
		if (hexColorSaturation.equals(hexColorPicker)) {
			getTest().log(LogStatus.PASS, hexColorSaturation + " is successfully displayed");
			logger.info("Hex color is successfully displayed");
		} else {
			getTest().log(LogStatus.FAIL, "Hex color is not displayed");
			logger.info("Hex color is not displayed");
			takeScreenshot("Hexcolor");
			Assert.fail("Hexcolor");
		}
	}
}
