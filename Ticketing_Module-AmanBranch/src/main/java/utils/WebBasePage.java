package utils;

import static reporting.ComplexReportFactory.getTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class WebBasePage extends WaitStatement {

	private WebDriver driver;
	public static Logger logger;
	private String pageName;
	public static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd//yyyy");
// static String weekEndDate;
//	 static String weekStartDate;

	public WebBasePage(WebDriver driver, String pageName) {
		super(driver);
		this.driver = driver;
		logger = Logger.getLogger(pageName);

	}

	public void open(String url) {

		driver.get(url);
		getTest().log(LogStatus.PASS, "Url opened - " + url);
		logger.info("Url opened - " + url);
	}

	public String enter(By by, String value, String name, int time) {
		try {
			WebElement element = findElementVisibility(by, time);
			staticWait(200);
			element.clear();
			element.sendKeys(value);
			getTest().log(LogStatus.PASS, name + " entered with value - " + value);
			logger.info(name + " entered with value - " + value);
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL,
					pageName + name + " not entered with value - " + value + ", error exist - " + e);
			logger.info(name + " not entered with value - " + value + ", error exist - " + e);
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
			Assert.fail("" + e);

		}
		return value;
	}

	public void click(By by, String name, int time) {

		WebElement element = findElementVisibility(by, time);
		staticWait(200);
		if (element != null) {
			try {
				element.click();
				getTest().log(LogStatus.PASS, name + " clicked");
				logger.info(name + " clicked ");
			} catch (Exception e) {
				getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
				logger.info(name + " not clicked");
				takeScreenshot(new Object() {
				}.getClass().getEnclosingMethod().getName());
				Assert.fail(name + " -  element not clickable");
			}
		} else {
			getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
			logger.info(name + " not clicked");
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
			Assert.fail(name + " -  element not clikabke");
		}

	}

	public String getText(By by, int time) {
		try {
			WebElement ele = findElementVisibility(by, time);
			String getText = ele.getText();
			getTest().log(LogStatus.PASS, " Text displayed is  - " + getText);
			logger.info(" Text displayed is  - " + getText);
			return getText;
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "Error Occurred. " + e);
			logger.info("Error Occurred. " + e);
			Assert.fail("" + e);
			return null;
		}
	}

	public String getCssValue(By by, String CssValue, String expectedValue, int time, String name) {
		WebElement ele = findElementVisibility(by, time);
		String getCssValue = ele.getCssValue(CssValue);
		if (getCssValue.equals(expectedValue)) {
			getTest().log(LogStatus.PASS, " Text displayed is  - " + getCssValue);
			logger.info(" CSS value is  - " + getCssValue);
			return getCssValue;

		} else {
			getTest().log(LogStatus.FAIL, "Error Occurred. ");
			logger.info("\"Error while getting Css value");
			Assert.fail("Error while getting Css value");
			takeScreenshot("CSS value not found.");
		}
		return null;
	}

	public static String nameGenerator() {
		String givenName = "";
		// Date time formatter
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMddHHmmss");
		// Local Date
		LocalDateTime now = LocalDateTime.now();

		String today = dtf.format(now);
		String[] name = today.split("");

		String[] names = new String[10];
		for (int i = 0; i < name.length; i++) {
			switch (name[i]) {
			case "0":
				names[i] = "A";
				break;
			case "1":
				names[i] = "B";
				break;
			case "2":
				names[i] = "C";
				break;
			case "3":
				names[i] = "D";
				break;
			case "4":
				names[i] = "F";
				break;
			case "5":
				names[i] = "G";
				break;
			case "6":
				names[i] = "H";
				break;
			case "7":
				names[i] = "J";
				break;
			case "8":
				names[i] = "K";
				break;
			case "9":
				names[i] = "L";
				break;
			default:
				names[i] = "Z";
				break;
			}
		}
		givenName = String.join("", names);
		logger.info("Name generated is " + givenName);
		return givenName;

	}

	public void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {

		}
	}

	public String getAtribute(By by, String tag, int time) {
		try {
			WebElement ele = findElementVisibility(by, time);
			String getText;
			getText = ele.getAttribute(tag);
			logger.info(" get attribute value is  - " + getText);
			return getText;
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "Error Occurred. " + e);
			logger.info("Error Occurred. " + e);
			Assert.fail("" + e);
			return null;
		}
	}

	public void selectValueWithValue(By by, String value, String name, int time) {
		WebElement element = findElementVisibility(by, time);
		if (element != null) {
			Select se = new Select(element);
			se.selectByValue(value);
			getTest().log(LogStatus.PASS, name + " selected with value - " + value);
		} else {
			getTest().log(LogStatus.FAIL, name + " not selected with value - " + value);
			Assert.fail(name + " -  element not present");
		}
	}

	public void selectValueWithText(By by, String value, String name, int time) {
		staticWait(200);
		WebElement element = findElementPresence(by, time);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		staticWait(200);
		if (element != null) {
			Select se = new Select(element);
			se.selectByVisibleText(value);
			getTest().log(LogStatus.PASS, name + " selected with value - " + value);
		} else {
			getTest().log(LogStatus.FAIL, name + " not selected with value - " + value);
			Assert.fail(name + " -  element not present");
		}
	}
	public void selectValueWithIndex(By by, int value, String name, int time) {
		staticWait(200);
		WebElement element = findElementPresence(by, time);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		staticWait(200);
		if (element != null) {
			Select se = new Select(element);
			se.selectByIndex(value);
			getTest().log(LogStatus.PASS, name + " selected with value - " + value);
		} else {
			getTest().log(LogStatus.FAIL, name + " not selected with value - " + value);
			Assert.fail(name + " -  element not present");
		}
	}


	public void staticWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void takeScreenshot(String name) {

		String imagePath = System.getProperty("user.dir") + "\\reports\\" + name + "_"
				+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			org.apache.commons.io.FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
			System.out.println(imagePath + ".png");
		} catch (Exception e) {
			Assert.fail("Error while taking screenshot - " + e);
		}
		getTest().log(LogStatus.INFO, getTest().addScreenCapture(imagePath + ".png"));
	}

	public void clickByJavascript(By by, String name, int time) {
		try {
			staticWait(2000);
			WebElement element = driver.findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			getTest().log(LogStatus.PASS, name + " click by JS");
			logger.info(name + " clicked ");
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, pageName + name + " not clicked ");
			Assert.fail(name + " -  element not present");
		}
	}

	public int getRowCount(By by, String name) {
		int getCount = driver.findElements(by).size();
		getTest().log(LogStatus.PASS, name + " count of the element size - " + getCount);
		return getCount;
	}

	public void hover(By by, String name, int time) {
		WebElement ele = findElementVisibility(by, time);
		if (ele != null) {
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
		} else {
			getTest().log(LogStatus.FAIL, "Hover not performed");
		}
	}

	public boolean toCheckElementIsDisplayed(By by, int time, String name) {

		boolean isElementPresent = false;
		WebElement ele = findElementVisibility(by, time);

		try {
			isElementPresent = ele.isDisplayed();
			if (isElementPresent) {

				getTest().log(LogStatus.PASS, " is" + name + "Element Present?  - " + isElementPresent);
				logger.info(" is" + name + "Element Present ?  - " + isElementPresent);
			}
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, " is" + name + "  Element not Present ?  - " + isElementPresent);
			logger.info(" is" + name + "Element Present ? - " + isElementPresent);
			takeScreenshot("Element is not displayed");
			Assert.fail("" + isElementPresent);
		}
		return isElementPresent;
	}

	public String gettextByJSexecuter(By by, String name, int time) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(by);
			jse.executeScript("return arguments[0].text", element);
			return element.getText();
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "Error Occurred. " + e);
			logger.info("Error Occurred. " + e);
			takeScreenshot("TextFromJSnotFound");
			Assert.fail("" + e);
			return null;
		}
	}

	public String getCurrentUrl(String url, String name) {

		String getUrl = driver.getCurrentUrl();
		if (getUrl.startsWith(url)) {
			getTest().log(LogStatus.PASS, name + "Url is ::a" + getUrl);
			logger.info(name + "Url is ::  - " + getUrl);
		} else {
			getTest().log(LogStatus.FAIL, name + "Url is ::" + getUrl);
			logger.info(name + "Url is ::  - " + getUrl);
			takeScreenshot(name + "Url not matched");
			Assert.fail(name + "Url not matched");
		}
		return url;
	}

	public void pageRefresh(String name) {
		driver.navigate().refresh();
		String pageTitle = driver.getTitle();
		logger.debug(pageTitle + "Page is" + name);
	}

	public void pageNavigate(String pageUrl, String name) {
		driver.navigate().to(pageUrl);
		logger.info("Page Url is :: " + pageUrl + name);
	}

	public void verifySuccessMessage(By by, String messageToVerify, int time) {
		String updateSuccessMsg;
		try {
			findElementsVisibility((by));
			updateSuccessMsg = getText(by, 20);
			logger.debug("Validation message is :: " + updateSuccessMsg);
			if (updateSuccessMsg.contains(messageToVerify)) {
				getTest().log(LogStatus.PASS, updateSuccessMsg + " is successfully displayed");
			} else {
				getTest().log(LogStatus.FAIL, "Success message is not successfully displayed");
				logger.debug("Success message is not displayed");
				takeScreenshot("successMessage");
				Assert.fail("successMessage");
				updateSuccessMsg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyMultiSelectValues(By by, String messageToVerify, int time) {

		// Selecating the multi-select element by locating its id
		Select select = new Select(driver.findElement(by));

		// Get the list of all the options
		System.out.println("The dropdown options are -");

		List<WebElement> options = select.getOptions();

		for (WebElement option : options)
			System.out.println(option.getText());

		// Using isMultiple() method to verify if the element is multi-select, if yes go
		// onto next steps else eit
		if (select.isMultiple()) {

			// Selecting option as 'Opel'-- ByIndex
			System.out.println("Select option Opel by Index");
			select.selectByIndex(1);

			select.selectByIndex(2);

			// Get the list of selected options
			System.out.println("The selected values in the dropdown options are -");

			List<WebElement> selectedOptions = select.getAllSelectedOptions();

			for (WebElement selectedOption : selectedOptions)
				System.out.println(selectedOption.getText());

		}
	}

	public void verifyCharactersLength(int actualCharacters, int charactersToCheck, String name) {
		if (charactersToCheck == actualCharacters) {
			getTest().log(LogStatus.PASS, "Actual characters length is :: " + actualCharacters);
			logger.info(name + "::" + actualCharacters);
		} else {
			getTest().log(LogStatus.FAIL, "characters to check is :: " + charactersToCheck);
			logger.info(name + "::" + charactersToCheck);
			takeScreenshot("VerifyCharactersValidation");
			Assert.fail("VerifyCharactersValidation");
		}
	}

	public List<WebElement> findMultipleElement(By by, int time) {
		List<WebElement> elements = new ArrayList<>();
		try {
			staticWait(2000);
			WebElement element = findElementVisibility(by, time);
			waitForVisibilityOfElement(by, time);
			elements = driver.findElements(by);
			return elements;
		} catch (Exception e) {
			getTest().log(LogStatus.FAIL, "Element not found : " + by + ". Error occurred. " + e);
			logger.info("Element not found : " + by + ". Error occurred. " + e);
			takeScreenshot(new Object() {
			}.getClass().getEnclosingMethod().getName());
			Assert.fail("" + e);
			return elements;
		}
	}

	public void validateCheckboxSelection(By by, String tag, int time, String name) {
		try {
			WebElement ele = findElementVisibility(by, time);
			System.out.println("" + ele.getAttribute(tag));
			if (ele.getAttribute(tag).contains("checked")) {
				logger.info(name + "Checkboxes are selected ?" + ele.getAttribute(tag));
			} else {
				getTest().log(LogStatus.FAIL, "Error Occurred. ");
				logger.info(name + "Checkboxes are noat selected");
				takeScreenshot(name + "checkoxesarenotselected");
				Assert.fail("checkoxesarenotselected");
			}
		} catch (Exception e) {
			logger.error(name + "Checkboxes are not selected" + e);
		}
	}

	public boolean isAttributePresent(WebElement element, String attribute) {
		Boolean result = false;
		try {
			String value = element.getAttribute(attribute);
			if (value != null) {
				result = true;
			}
		} catch (Exception e) {
		}

		return result;
	}

	public void switchToFrame() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
	}

	public void scrollOnPage(By by, int time) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		findElementPresence(by, time);

		// This will scroll the page till the element is found
		js.executeScript("arguments[0].scrollIntoView();", by);

//		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		switchToFrame();
	}

	public void closeBrowser() {
		driver.close();
	}
}