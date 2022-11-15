package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketGroupListingPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TicketGroupListingPage(WebDriver driver) {
		super(driver, "Ticket Group Listing Page");
		this.driver = driver;
	}

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 20);
	}

	// click on ticketing
	public void clickTicketingOption() {
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), "Ticketing", 20);
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);

	}
	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on Ticketing group
	public void clickTicketingGroup() {
		staticWait(3000);
		click(By.xpath(
				"//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticket Group' and @id='cadmin_messageboard_link']"),
				"Ticket Group", 20);
	}

	// click on Add Group
	public void clickAddGroup() {
		staticWait(3000);
		click(By.xpath("//a[@data-original-title='Add Group']"), "Add Group", 20);
	}

	public void validateTicketingGroupListingUrl() {
		getCurrentUrl(prop.getProperty("ticketingGroupPageUrl"), "Ticketing Group Listing Page Url");
	}

	// click on Search Icon
	public void clickSearchIcon() {
		click(By.xpath("//a[@href='#collapseOne12']//following::a[1]//i"), "Search Icon", 40);
	}

	// click on Search Icon
	public void searchByGroupName() {
		click(By.xpath("//a[@aria-controls='collapseOne1' and @href='#collapseOne12']"), "search By Group Name", 40);
	}

	// get Group name text
	public String groupNameText() {
		String groupName = getText(By.xpath("//table[@id='tblTicketGroup']/tbody//tr//td[@class='td4']//a"), 40);
		return groupName;
	}

	// click on Search By Group Name TextField
	public void searchByGroupNameTextField() {
		String searchGroupName = groupNameText();
		enter(By.cssSelector("#search"), searchGroupName, "search By Group Name textField", 40);
	}

	// get Group name text
	public String groupNameEmptyText() {
//		String groupName = getAtribute(By.xpath("//table[@id='tblTicketGroup']/tbody//tr//td[@class='td4']//a"),
//				"value", 40);
		String groupNameEmpty = getText(By.cssSelector("#search"), 40);
		return groupNameEmpty;
	}

	// click on Search By Group Name TextField
	public void verifySearchedGroupName(String name) {
		try {
			String searchGroupName = groupNameText();
			enter(By.cssSelector("#search"), searchGroupName, "search By Group Name textField", 40);
			clickSearchIcon();
			String groupNameText = getText(By.xpath("//table[@id='tblTicketGroup']/tbody//tr//td[@class='td4']//a"),
					40);
			if (searchGroupName.equals(groupNameText)) {
				getTest().log(LogStatus.PASS, "Searched group name is " + name + groupNameText);
				logger.info("Group name is matched" + name + groupNameText);
			} else {
				getTest().log(LogStatus.FAIL, "Searched group name is " + name + groupNameText);
				logger.info("Group name is not matched" + name + groupNameText);
				takeScreenshot("verifySearchedGroupName");
				Assert.fail("verifySearchedGroupName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkSearchedGroupName() {
		verifySearchedGroupName("Group name is :: ");
	}

	// click on Reset button
	public void clickResetButton() {
		click(By.cssSelector("#aClear"), "Reset button", 40);
	}

	// click on Reset Search By Group Name TextField
	public void verifyResetSearched() {
		try {
			String groupName = groupNameEmptyText();

			if (groupName.isEmpty()) {
				getTest().log(LogStatus.PASS, "Searched group name is :: " + groupName);
				logger.info("Group name is matched" + groupName);
			} else {
				getTest().log(LogStatus.FAIL, "Searched group name is " + groupName);
				logger.info("Group name is not matched" + groupName);
				takeScreenshot("verifyResetSearched");
				Assert.fail("verifyResetSearched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// click Select All CheckBox
	public void clickOnSelectAllCheckBox() {
		clickByJavascript(By.id("chkAll_0"), "All checkbox", 20);
	}

	public void verifyHeaderButtons() {
		toCheckElementIsDisplayed(By.xpath("//a[@data-original-title='Add Group']"), 40, "Add Group");
		toCheckElementIsDisplayed(By.xpath(
				"//a[@class='p-action-btn text-white ActiveInactive iconenable enable' and @data-original-title='Active']"),
				40, "active button");
		toCheckElementIsDisplayed(By.xpath(
				"//a[@class='p-action-btn text-white ActiveInactive iconenable enable' and @data-original-title='Inactive']"),
				40, "Inactive button");
		toCheckElementIsDisplayed(By.cssSelector("#DeleteMultiple"), 40, "Delete button");
	}

	// update group
	public void updateGroup() {
		click(By.xpath("//table[@id='tblTicketGroup']/tbody/tr/td[@class='td4']/a"), "Update group button", 40);
	}
}
