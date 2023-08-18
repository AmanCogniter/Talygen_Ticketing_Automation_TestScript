package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketingDashboardPage extends WebBasePage {

	WebDriver driver;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	static String ticketStatus;
	static List<WebElement> statusList;
	static String parts;
	static String arr;
	static String ListOfStatus[];
	static List<String> statulist;
	static List<Integer> statusCountFromDashboard;
	static ArrayList<String> statuslist;
	static String weekStartDate;
	static String weekEndDate;
	static String weekStartDateFromPicker;
	static String weekEndDateFromPicker;
	static String pattern = "MM/dd//yyyy";
	static Date date = new Date();
	static ArrayList<String> solvedCount;
	static ArrayList<String> resolverName;
	static List<WebElement> solvedCountList;
	static List<WebElement> resolverNameList;
	static List<String> resolverList;
	static List<String> resolverNameListCopy;
	static String SelectedFilterText;

	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	static String datevalue = dateformat.format(date);

	TicketListingPage ticketListingPage;

	public TicketingDashboardPage(WebDriver driver) {

		super(driver, "Ticketing Dashboard Page");
		this.driver = driver;
		this.ticketListingPage = new TicketListingPage(driver);
	}

	// click on full menu
	public void clickFullMenu() {
		waitForVisibilityOfElement(By.cssSelector("#navbarDropdownPortfolio"), 30);
		//findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 15);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
	}
	// click on FSM Locate
		public void clickOnFSMLocate() {
			clickByJavascript(By.xpath("//li[@data-name='FSM- Locate']/span"), "FSM Locate", 20);
		}
	// click on ticketing
	public void clickTicketingOption() {
//		click(By.xpath("//li[@data-name='Ticketing']"), "Ticketing", 10);

		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), "Ticketing",
				10);

	}
//		click(By.cssSelector("#menuitem16"), "Ticketing", 20);

	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	// click on Ticketing Dashboard
	public void clickTicketingDashboard() {
		staticWait(3000);
		findElementInVisibility(By.xpath("//*[@id='spntext']/span/a"), 5);
		clickByJavascript(By.xpath("//*[@id='spntext']/span/a"), "Ticketing Dashboard", 20);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// jse.executeScript("arguments[0].scrollIntoView();", element);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	// click on Add Report
	public void clickAddReport() {
		staticWait(7000);
		//waitForVisibilityOfElement(By.xpath("//div[@class='graph-widget-heading float-left w-100']/span[text()='Tickets by Department']"), 30);
		clickByJavascript(By.xpath("//div/a[@id='hlkAddMoreReports']"), "Add Report", 20);

	}

	// click on select All Reports checkbox
	public void selectAllReportsCheckboxes() {
		staticWait(3000);
	try {
		WebElement checked = driver.findElement(By.xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"));
		String value = checked.getAttribute("checked");
		if (value ==null) {
			clickByJavascript(By.xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"), "Select all checkbox", 20);
		}else {
			clickByJavascript(By.xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"), "DeSelect all checkbox", 20);
			clickByJavascript(By.xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"), "Select all checkbox", 20);
		}
	} catch (Exception e) {
		// TODO: handle exception
		logger.error("Error from select All Reports Checkboxes " + e);
		e.printStackTrace();
	}
	/*
	 * WebElement checked = driver.findElement(By.
	 * xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']")
	 * ); String value = checked.getAttribute("checked"); if (value ==null) {
	 * clickByJavascript(By.
	 * xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"
	 * ), "Select all checkbox", 20); } else { clickByJavascript(By.
	 * xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"
	 * ), "DeSelect all checkbox", 20); clickByJavascript(By.
	 * xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"
	 * ), "Select all checkbox", 20); }
	 */
		/*
		 * staticWait(3000); //clickByJavascript(By.cssSelector("#chkAll_0"),
		 * "Select all checkbox", 20); clickByJavascript(By.
		 * xpath("//div[@class='custom-control custom-checkbox']/input[@id='chkAll_0']"
		 * ), "Select all checkbox", 20);
		 */
	}

	// click on Save Button
	public void loaderInvisibility() {
		findElementInVisibility(By.id("divProgress"), 40);
	}

	// click on Save Button
	public void clickSaveButton() {
		click(By.xpath("//button[@class='popupgreenbtn btn btn-success']"), "Save", 40);
	}

	// click on select All Reports
	public void selectAllReports() {
		clickSaveButton();
		//verifyReportsValidation();
	}

	// click on select seven Reportsa
	public void selectSevenReports() {

		for (int i = 7; i >= 6; i--) {
			clickByJavascript(By.xpath(
					"//div[@class='custom-control custom-checkbox'][last()]//following::label[@class='custom-control-label universal-custom-control-label pt-1']["
							+ i + "]"),
					"Select" + i + "checkbox", 20);
		}
	}

	public int getSelectedReportsCount() {

		List<WebElement> selectedReportsCount = findMultipleElement(By.xpath(
				"//input[@class='chkItems custom-control-input' and @checked='checked' and @data-change-id='no']"), 20);
		selectedReportsCount.size();
		logger.info("Selected Reports count ::" + selectedReportsCount.size());

		return selectedReportsCount.size();
	}

	public void verifyWidgetsCount() {

		try {
			int selectedReportsCount = 0;
			WebElement element = driver.findElement(
					By.xpath("//div//input[@class='chkItems custom-control-input' and @checked='checked']"));
			boolean getCheckboxAttribute = isAttributePresent(element, "checked");
			if (getCheckboxAttribute == true) {
				logger.info("Select all checkbox already clicked.");
				selectedReportsCount = getSelectedReportsCount();
			} else {
				selectAllReportsCheckboxes();
				logger.info("Select all checkbox not clicked.");
			}
			clickSaveButton();
			List<WebElement> widgetsCount = findMultipleElement(
					By.xpath("//div[@id='divInboxSibling']/div"), 20);
			widgetsCount.size();
			int widgetsTotalCount = widgetsCount.size();
			logger.info("Widgets count is ::" + widgetsTotalCount);
			if ((widgetsTotalCount == selectedReportsCount)) {
				getTest().log(LogStatus.PASS, "widgets count is :: " + widgetsTotalCount);
				logger.info("widgets count is ::" + widgetsTotalCount);
			} else {
				getTest().log(LogStatus.FAIL, "widgets count is not matched.");
				logger.info("widgets count is not matched");
				takeScreenshot("WidgetsCount");
				Assert.fail("WidgetsCountnotMatched");
			}
		} catch (Exception e) {
			logger.error("Error from verifyWidgetsCount method." + e);
		}
		driver.navigate().refresh();
	}

	// verify Reports Validation message
	public void verifyReportsValidation() {
		verifySuccessMessage(By.cssSelector("#notifymessage div "), prop.getProperty("reportsValidationMessage"), 20);
	}

	// ticket status name and count
	public void getTicketStatusCount() {
		try {
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<Integer> ticketsCount = new ArrayList<Integer>();
			
			  statusList = findMultipleElement(By.xpath(
			  "//*[contains(@class,'chartStatusLegend justify-content-left align-self-center w-40 c3')]//*[text()]"
			  ), 20);
			 
				/*
				 * statusList = findMultipleElement(By.xpath(
				 * "//div[@id='viewer_table1']/table/tbody/tr[position()>2]"),//modified 20);
				 */

			for (int i = 0; i < statusList.size(); i++) {

//				String ticketCountReplaced = statusList.get(i).getText().replaceAll("[^a-zA-Z0-9]", "")
//						.replaceAll("[^\\d]", "");

				String getTicketCount = statusList.get(i).getText().replaceAll("[^a-zA-Z0-9]", "").replaceAll("[^\\d]",
						"");

				logger.info("Status count :: " + getTicketCount);
				int repTicketCount = Integer.parseInt(getTicketCount);
				ticketsCount.add(repTicketCount);
				logger.info("Status from Dashboard screen. " + ticketsCount);

//				al.add(statusList.get(i).getText().replaceAll("[\\d.]", "").replaceAll("[^a-zA-Z0-9]", ""));
				al.add(statusList.get(i).getText().replaceAll("[0-9]", "").replaceAll("\\p{P}", ""));

				logger.info("Status from Dashboard screen. " + al);
			}

			statulist = al;
			statusCountFromDashboard = ticketsCount;
			logger.info("Status from Dashboard screen. " + al);
		} catch (Exception e) {
			logger.error("Error from getTicketStatusCount method." + e);
			e.printStackTrace();
		}
	}

	// div[@class='graph-widget-heading']//following::div[@class='c3-tooltip-container']//following::div[@class='chartProductLegend
	// justify-content-left align-self-center w-40 c3']
	// click Ticket By Status Filter
	public void mainWidgetFilter() {
		clickByJavascript(By.cssSelector("#aDateLable_global"), "click on Ticket By Status Filter", 40);
	}

	// click This Year By Status
	/*
	 * a public void clickMaainFilterStatus() {
	 * clickByJavascript(By.xpath("//a[@id='aDateLable_TicketStatusCount']//span"),
	 * "Main Filter", 40); }
	 */
	// click This Year from list
	public void selectThisYear() {
		clickByJavascript(By.xpath("//div[@id='DivTimer']//tbody//td[@class='sep daterangetd']//li[4]//a"),
				"Select This Year.", 40);

		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("today filter name :: " + SelectedFilterText);
	}

	// click Today from Ticket by status widget
	public void selectToday() {
		clickByJavascript(By.xpath("//div[@id='DivTimer']//tbody//td[@class='sep daterangetd']//li[1]//a"),
				"Select Today", 40);

		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("today filter name :: " + SelectedFilterText);

	}

	// click This week from list
	public void selectThisWeek() {
		staticWait(3000);
		clickByJavascript(By.xpath(
				
				"//table/tbody/tr/td/ul/li/a[@id='aWeek']"),
				"Select This Week.", 40);

		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("this Week filter name :: " + SelectedFilterText);
	}

	// click Last Week from Ticket by status widget
	public void selectLastWeek() {
		clickByJavascript(By.xpath("//div[@id='DivTimer']//tbody//td[@class='daterangetd']//li[1]//a"),
				"Select Last Week", 40);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("last Week filter name :: " + SelectedFilterText);
	}

	// click Last Week from Ticket by status widget
	public void selectYesterdayFilter() {
		clickByJavascript(By.xpath(
				"//table/tbody/tr/td/ul/li/a[@id='aYesterday']"),
				"Select Yesterday Filter", 40);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("last Week filter name :: " + SelectedFilterText);
	}

	// click This month from Ticket by status widget
	public void selectThisMonth() {
		clickByJavascript(By.xpath("//div[@id='DivTimer']//tbody//td[@class='daterangetd']//li[2]//a"),
				"Select this month.", 40);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("this Month filter name :: " + SelectedFilterText);
	}

	// select last Month
	public void selectLastMonth() {
		clickByJavascript(By.xpath(
				"//div[@id='DivTimer']//tbody//td[@class='daterangetd']//ul//li//a[@data-original-title='Last Month']"),
				"Last month.", 40);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("this Month filter name :: " + SelectedFilterText);
	}

	// -------------------------Page objects of Ticket By category
	// filter----------------------------------------------//

	// ticket category status name and count
	public void getTicketCategoryStatusCount() {
		try {
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<Integer> ticketsCount = new ArrayList<Integer>();

//			findElementPresence(By.xpath(
//					"//div[@class='chartCategoryLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
//					20);
//			JavascriptExecutor jse = (JavascriptExecutor) driver;
//			// jse.executeScript("arguments[0].scrollIntoView();", element);
//			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			WebElement m = driver.findElement(By.xpath(
					"//div[@class='chartCategoryLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"));
			// Javascript executor
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

			statusList = findMultipleElement(By.xpath(
					"//div[@class='chartCategoryLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
					20);

			for (int i = 0; i < statusList.size(); i++) {

				String ticketCountReplaced = statusList.get(i).getText().replaceAll("[^a-zA-Z0-9]", "")
						.replaceAll("[^\\d]", "");
				logger.info("Status count :: " + ticketCountReplaced);
				int repTicketCount = Integer.parseInt(ticketCountReplaced);
				ticketsCount.add(repTicketCount);
				logger.info("Status from Dashboard screen. " + ticketsCount);

				al.add(statusList.get(i).getText().replaceAll("[\\d.]", "").replaceAll("\\p{P}", ""));

				logger.info("Status from Dashboard screen. " + al);
			}

			statulist = al;
			statusCountFromDashboard = ticketsCount;
			logger.info("Status from Dashboard screen. " + al);
		} catch (Exception e) {
			logger.error("Error from getTicketStatusCount method." + e);
		}
	}

	// click week from Ticket by status widget
	public void selectWeekByCategoryFilter() {
		clickByJavascript(By.xpath(
				"//div[@id='DivTimer']//tbody//td[@class='sep daterangetd']//ul//li//a[@data-original-title='All Time']"),
				"Select week from category filter", 40);

		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("today filter name :: " + SelectedFilterText);
	}

	public void clickThisYear() {
		click(By.xpath(
				"//div[@id='DivTimer']//tbody//td[@class='sep daterangetd']//ul//li//a[@data-original-title='This Year']"),
				"click this year", 20);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("today filter name :: " + SelectedFilterText);
	}

	// -------------------------------------------------------------------------------------------------------------------------------//
	// Page objects of Ticket By Channel filter

	// click This week By Channel
	public void mainFilterFromChannel() {
		clickByJavascript(By.id("aDateLable_TicketChannelWise"), "Main filter from channel.", 40);
	}

	// click This week By Channel
	public void todayFromCategory() {
		clickByJavascript(
				By.xpath("//div[@id='DivTimer_TicketChannelWise']//tbody//td[@class='sep daterangetd']//li[1]//a"),
				"today from category.", 40);
		SelectedFilterText = getText(By.cssSelector("#aDateLable_global"), 20);
		logger.info("today filter name :: " + SelectedFilterText);
	}

	// ----------------------Tickets By product widgets----

	// ticket Product status name and count
	public void getTicketProductStatusCount() {
		try {
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<Integer> ticketsCount = new ArrayList<Integer>();

			findElementPresence(By.xpath(
					"//div[@class='chartProductLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
					20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("arguments[0].scrollIntoView();", element);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			statusList = findMultipleElement(By.xpath(
					"//div[@class='chartProductLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
					20);

			for (int i = 0; i < statusList.size(); i++) {

				String ticketCountReplaced = statusList.get(i).getText().replaceAll("[^a-zA-Z0-9]", "")
						.replaceAll("[^\\d]", "");
				logger.info("Status count :: " + ticketCountReplaced);
				int repTicketCount = Integer.parseInt(ticketCountReplaced);
				ticketsCount.add(repTicketCount);
				logger.info("Status from Dashboard screen. " + ticketsCount);

				al.add(statusList.get(i).getText().replaceAll("[\\d.]", "").replaceAll("\\p{P}", ""));
				logger.info("Status from Dashboard screen. " + al);
			}

			statulist = al;
			statusCountFromDashboard = ticketsCount;
			logger.info("Status from Dashboard screen. " + al);

		} catch (Exception e) {
			logger.error("Error from getTicketProductStatusCount method." + e);
		}
	}

	// ticket channel widget
	public void getTicketChannelCount() {
		try {
			ArrayList<String> al = new ArrayList<String>();
			ArrayList<Integer> ticketsCount = new ArrayList<Integer>();

			findElementPresence(By.xpath(
					"//div[@class='chartChannelLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
					20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("arguments[0].scrollIntoView();", element);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			statusList = findMultipleElement(By.xpath(
					"//div[@class='chartChannelLegend justify-content-left align-self-center w-40 c3']//div[@class='legend text-left']//div"),
					20);

			for (int i = 0; i < statusList.size(); i++) {

				String ticketCountReplaced = statusList.get(i).getText().replaceAll("[^a-zA-Z0-9]", "")
						.replaceAll("[^\\d]", "");
				logger.info("Status count :: " + ticketCountReplaced);
				int repTicketCount = Integer.parseInt(ticketCountReplaced);
				ticketsCount.add(repTicketCount);
				logger.info("Status from Dashboard screen. " + ticketsCount);

				al.add(statusList.get(i).getText().replaceAll("[\\d.]", "").replaceAll("\\p{P}", ""));
				logger.info("Status from Dashboard screen. " + al);
			}

			statulist = al;
			statusCountFromDashboard = ticketsCount;
			logger.info("Status from Dashboard screen. " + al);

		} catch (Exception e) {
			logger.error("Error from getTicketProductStatusCount method." + e);
		}
	}

	// Status by resolver Ticket Count By Resolver
	public void solvedTicketCountByResolver() {

		ArrayList<String> solvedCount = new ArrayList<String>();
		ArrayList<String> resolverName = new ArrayList<String>();
		resolverNameList = findMultipleElement(By.xpath(
				/*"//div[contains(text(),'Status By Resolver')]//following::table[@class='table table-bordered dt-responsive nowrap mt-0 dataTable no-footer dtr-inline'][1]//tbody//tr//td[2]"),*/
				"(//div[@action='TicketAgentCount']//following::table[@class='table table-bordered dt-responsive nowrap mt-0 dataTable no-footer dtr-inline'][1]//tbody//tr//td[2])[1]"),
				30);

		for (int i = 0; i < resolverNameList.size(); i++) {
			String resolverNameText = resolverNameList.get(i).getText();
			logger.info("Resolver name Text from WIDGET :: " + resolverNameText);
			resolverName.add(resolverNameList.get(i).getText());

		}
		resolverList = resolverName;
		solvedCountList = findMultipleElement(By.xpath(
				/*"//div[contains(text(),'Status By Resolver')]//following::table[@class='table table-bordered dt-responsive nowrap mt-0 dataTable no-footer dtr-inline'][1]//tbody//tr//td[@class='tdcm'][2]//following::td[text()][1]"),*/
				"//div[@action='TicketAgentCount']//following::table[@class='table table-bordered dt-responsive nowrap mt-0 dataTable no-footer dtr-inline'][1]//tbody//tr//td[@class='tdcm'][2]//following::td[text()][1]"),
				30);

		for (int i = 0; i < solvedCountList.size(); i++) {
			String solvedCountText = solvedCountList.get(i).getText();
			solvedCount.add(solvedCountList.get(i).getText());
			logger.info("Solved count Text from WIDGET :: " + solvedCountText);
		}
		resolverNameListCopy = solvedCount;
	}

	public void closeBrowserWindow() {
		closeBrowser();
	}
}
