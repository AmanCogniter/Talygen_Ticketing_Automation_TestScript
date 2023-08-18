package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketDetailReportPage extends WebBasePage {

	WebDriver driver;
	
	static String ticketvalue;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	static String pattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	static String datevalue = dateformat.format(date);

	static Date currentY = new Date();
	int year = date.getYear();
	int currentYear = year + 1900;

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	AddTicketPage addTicketPage;
	CompanySetupPage companySetUpPage;
	String ticketNoText;
	static String subjectText;
	static String subjectTextFromReport;
	String ticketStatus;
	TicketingDashboardPage ticketdashboard;
	TicketListingPage ticketListingPage;
	static List<WebElement> ticketDashboardStatusElements;
	static List<String> tempList;
	static String totalRecordCount;
	static int recordCount;
	static List<String> statusvalue;
	static String weekEndDate;
	static String weekStartDate;
	static String monthStartDate;
	static String monthEndDate;
	static String yesterdayDate;
	static String lastWeekStartDate;
	static String lastWeekEndDate;
	static String lastMonthStartDate;
	static String lastMonthEndDate;
	static String statusText;
	static List<Integer> statusCount;
	static String listFirstIndex;
	int counter = 0;
	static int count = 0;

	public TicketDetailReportPage(WebDriver driver) {
		super(driver, "Ticketing Summary Report Page");
		this.driver = driver;
		this.addTicketPage = new AddTicketPage(driver);
		this.ticketdashboard = new TicketingDashboardPage(driver);
		this.ticketListingPage = new TicketListingPage(driver);

	}

	String ticketNum;

	// click on full menu
	public void clickFullMenu() {
		staticWait(3000);
		//findElementInVisibility(By.cssSelector("#navbarDropdownPortfolio"), 20);
		click(By.cssSelector("#navbarDropdownPortfolio"), "Full Menu", 20);
//		getLastWeekStartEndDate();

	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		staticWait(3000);
		waitForVisibilityOfElement(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"), 50);
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}
	// click on Side menu
		public void clickOnFSMLocate() {
			clickByJavascript(By.xpath("//li[@data-name='FSM- Locate']/span"), "FSM Locate", 20);
		}

	// click on ticketing
	public void clickTicketingOption() {
		staticWait(3000);
		waitForVisibilityOfElement(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), 50);
		click(By.xpath("//ul[@class='submenu clschild_12 d-flex']//a[@data-original-title='Ticketing']"), "Ticketing",10);

//			click(By.cssSelector("#menuitem16"), "Ticketing", 20);
	}

	// click on Ticket Report
	public void clickTicketReport() {
		staticWait(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement manageLayout = driver
				.findElement(By.xpath("(//div/ul/li/a[@data-original-title='Manage Layout'])[last()]"));
		js.executeScript("arguments[0].scrollIntoView();", manageLayout);
		WebElement serviceAppoitment = driver
				.findElement(By.xpath("//div/ul/li/a[@data-original-title='Service Appointment']"));
		js.executeScript("arguments[0].scrollIntoView();", serviceAppoitment);
		click(By.xpath(
				"//div/ul/li/a[@data-original-title='Ticket Report']"),
				"Ticket Report", 20);
	}

	// enter Ticket Number
	public void enterTicketNumber() {
		ticketvalue = addTicketPage.ticketNoGenerated;
		enter(By.cssSelector("#ticketnumber"), ticketvalue, "enter ticket number", 20);

	}

	// get TicketNo Text
	public void ticketNoTextFromSearch() {
		staticWait(3000);
		switchToFrame();
		ticketNoText = gettextByJSexecuter(By.xpath("//table[@class]//tr[3]//td[2]//div//a"), "", 20);
		logger.info("ticket no :: " + ticketNoText);
	}

	// get Ticket subject Text
	public void ticketSubjectFromSearch() {
		subjectTextFromReport = gettextByJSexecuter(By.xpath("//table[@class]//tr[3]//td[4]//div//a"), "", 20);
		logger.info("Subject from created ticket :: " + subjectTextFromReport);
	}

	public void verifyTicketNo() {
		String val1 = String.valueOf(ticketvalue);
		String val2 = String.valueOf(ticketNoText).replaceAll(".", "");

		subjectText = AddTicketPage.getTicketSubject;
		logger.info("subject" + subjectText);
		logger.info("subject report " + subjectTextFromReport);

		if (val1.contains(val2) && subjectText.equals(subjectTextFromReport)) {
			getTest().log(LogStatus.PASS, ticketvalue + " reference no. is matched as expected.");
		} else {
			getTest().log(LogStatus.FAIL, "reference no. is not matched as expected.");
			logger.debug("reference no. is not matched as expected.");
			takeScreenshot("verifyTicketNo");
			Assert.fail("verifyTicketNo");
		}
	}

	// enter Ticket Subject
	public void enterSubject() {
//		subjectText = AddTicketPage.getTicketSubject;
		enter(By.cssSelector("#subject"), AddTicketPage.ticketSubject, "enter ticket Subject", 20);
	}

	// click on Search
	public void clickSearch() {
		click(By.cssSelector("#aSearch"), "click on Search", 20);
		//findElementInVisibility(By.cssSelector("#reportViewer_AsyncWait_Wait"), 30);

	}

	// navigate to TicketReportPage
	public void navigateToTicketReportPage() {
		pageNavigate(prop.getProperty("ticketSummaryReportUrl"), "Ticket summary Report Page");
		staticWait(2000);
	}

	public void switchToFrame() {
		WebElement iframe = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(iframe);
		WebElement body = driver.findElement(By.tagName("tbody"));
	}

	// click on Status
	public void clickSelectStatus() {
		staticWait(2000);
		click(By.xpath("//*[@id='frmReport']/div[1]/div[8]/div/span/div/button"), "Status", 20);
		click(By.xpath("//div/ul/li/a/label[contains(text(),'Open')]"), "Open", 20);
	}

	public void verifyStatusWidgetValues() {
		try {
			staticWait(3000);
			int counter = 0;
			statusvalue = TicketingDashboardPage.statulist;

			statusCount = TicketingDashboardPage.statusCountFromDashboard;
			for (String value : statusvalue) {
				clickSelectStatus();

				clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
				//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),value, 30);
				logger.info(value);

				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
					enterStartTodaysDate();
					enterEndTodaysDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					enterWeekStartDate();
					enterWeekEndDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					enterYesterdayDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterStartYearDate();
					enterEndYearDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					enterLastWeekDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
					enterMonthStartDate();
					enterMonthEndDate();
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					enterLastMonthDate();
				} else {
					logger.info("fIlter not selected.");
				}
				clickSearch();
				//staticWait(2000);
				//clickCategoryDropdownStatus();
				staticWait(2000);
				getTotalRecordCount();
				staticWait(2000);
				
				logger.info("record  :: " + recordCount);
				staticWait(2000);
				String totalRecord = driver.findElement(By.xpath("//div[@id='viewer_pageviewfooterContainer']"))
						.getText(); /* modified */
				//if (statusCount.get(counter) == recordCount) {
				if (totalRecord.contains(totalRecordCount)) {
					staticWait(2000);
					getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
					logger.info(
							"record count is :: " + recordCount + " is matched succesfully from Detail Report count.");
					pageRefresh("Detail report page");
					clickProductDropdown();
					counter++;
				} else {
					getTest().log(LogStatus.FAIL, "record count is not matched");
					takeScreenshot("matchStatusCount");
					Assert.fail("matchStatusCount");
					logger.info("record count is not matched");
				}
			}
		} catch (Exception e) {
			logger.error("Error from searchStatusValues method." + e);
			e.printStackTrace();
		}
		driver.navigate().refresh();
		
	}

	public void clickClear() {
		staticWait(2000);
		clickByJavascript(
				By.cssSelector("#frmReport > div:nth-child(12) > div:nth-child(8) > div > span > div > button"),
				"Click clear", 20);
	}

	public void clickRefresh() {
		clickByJavascript(
				By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Closed']//preceding::button[1]"),
				"Click Refresh", 20);
	}

	public void clickStartDatePicker() {
		click(By.xpath("//div[@data-target='#OpenFromDate']"), "Start Date Picker", 20);
	}

	public void enterStartYearDate() {
		enter(By.xpath("//input[@name='OpenFromDate']"), prop.getProperty("enterStartYearDate") + currentYear,
				"enter Start year Date", 20);
		staticWait(4000);
	}

	public void enterEndYearDate() {
		enter(By.xpath("//input[@id='OpenToDate']"), prop.getProperty("enterEndYearDate") + currentYear,
				"enter current Date", 20);
		staticWait(4000);

	}

	// get Total Record Count
	public void getTotalRecordCount() {
		try {
			staticWait(5000);
			waitForVisibilityOfElement(By.xpath("(//div[@id='viewer_pageviewfooterContainer']/div/descendant::div)[5]"), 50);
			WebElement element = findElementPresence(
					By.xpath("(//div[@id='viewer_pageviewfooterContainer']/div/descendant::div)[5]"), 20);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("arguments[0].scrollIntoView();", element);
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			switchToFrame();
			logger.info("Switch to reports frame");
			//to perform scroll on an application using Selenium

			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			staticWait(5000);
			totalRecordCount = gettextByJSexecuter(
					By.xpath("(//div[@id='viewer_pageviewfooterContainer']/div/descendant::div)[5]"),
					"Total Records count", 20);
			recordCount = Integer.parseInt(totalRecordCount);
			logger.info("Total record count from detail Report :: " + recordCount);
		} catch (Exception e) {
			logger.error("Error from getTotalRecordCount method " + e);
			e.printStackTrace();
		}
		/*
		 * staticWait(2000); driver.navigate().refresh();
		 */
	}

	// --------------------------Current month ---------------//
	public void getCurrentMonthStartEndDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.set(Calendar.DAY_OF_MONTH, 1);

			Date currentMonthStart = currentCalendar.getTime();
			monthStartDate = formatter.format(currentMonthStart);
			System.out.println("Month Start Date: " + monthStartDate);
			currentCalendar.setTime(date);
			currentCalendar.set(Calendar.DAY_OF_MONTH, currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date currentMonthEnd = currentCalendar.getTime();
			monthEndDate = formatter.format(currentMonthEnd);
			System.out.println("Month End Date: " + monthEndDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------week Date ---------------//
	public void getWeekStartEndDate() {
		try {

			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

			Date currentWeekStart = currentCalendar.getTime();
			weekStartDate = formatter.format(currentWeekStart);
			System.out.println("Week Start Date: " + weekStartDate);

			currentCalendar.add(Calendar.DATE, 6); // add 6 days after aaaMonday
			Date currentWeekEnd = currentCalendar.getTime();
			weekEndDate = formatter.format(currentWeekEnd);

			System.out.println("Week End Date: " + weekEndDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------Last week Date ---------------//
	public void getLastWeekStartEndDate() {
		try {
			Date date = new Date();
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.setTime(date);
			int i = currentCalendar.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
			currentCalendar.add(Calendar.DATE, -i - 7);
			Date lastWeekStart = currentCalendar.getTime();

			lastWeekStartDate = formatter.format(lastWeekStart);
			System.out.println("Last start end date" + lastWeekStartDate);

			currentCalendar.add(Calendar.DATE, 6);
			Date lastWeekEnd = currentCalendar.getTime();

			lastWeekEndDate = formatter.format(lastWeekEnd);

			System.out.println("Last week end date" + lastWeekEndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------Last month Date ---------------//
	public void getLastMonthStartEndDate() {
		try {
			Date date = new Date();
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.setTime(date);
			currentCalendar.add(Calendar.MONTH, -1);
			// set DATE to 1, so first date of previous month
			currentCalendar.set(Calendar.DATE, 1);

			Date lastMonthStart = currentCalendar.getTime();

			lastMonthStartDate = formatter.format(lastMonthStart);
			System.out.println("Last month start date" + lastMonthStartDate);
			currentCalendar.set(Calendar.DATE, currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

			Date lastMonthEnd = currentCalendar.getTime();
			lastMonthEndDate = formatter.format(lastMonthEnd);

			System.out.println("Last Month end date" + lastMonthEndDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --------------------------yesterday Date -----------------------//
	public void getYesterdayDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();
			currentCalendar.add(Calendar.DATE, -1);
			Date yesterday = currentCalendar.getTime();
			yesterdayDate = formatter.format(yesterday);

			System.out.println("yesterday Date: " + yesterdayDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterStartTodaysDate() {
		enter(By.xpath("//input[@name='OpenFromDate']"), datevalue, "Todays Date", 20);
		staticWait(2000);
	}

	public void enterEndTodaysDate() {
		enter(By.xpath("//input[@id='OpenToDate']"), datevalue, "Todays End Date", 20);
		staticWait(2000);
	}

	public void enterWeekStartDateFromPicker() {
//		ticketdashboard.fromWeekDatea();
		enter(By.xpath("//input[@name='OpenFromDate']"), TicketingDashboardPage.weekStartDateFromPicker,
				"Week start Date from picker", 20);
		staticWait(2000);
	}

	public void enterWeekEndDateFromPicker() {
//		ticketdashboard.toWeekDate();
		enter(By.xpath("//input[@id='OpenToDate']"), TicketingDashboardPage.weekEndDateFromPicker,
				"Week End Date from picker", 20);
		staticWait(2000);
	}

	public void enterWeekStartDate() {
		getWeekStartEndDate();
		enter(By.xpath("//input[@name='OpenFromDate']"), weekStartDate, "Week start Date", 20);
		staticWait(2000);
	}

	public void enterMonthStartDate() {
		getCurrentMonthStartEndDate();
		staticWait(2000);
		enter(By.xpath("//input[@name='OpenFromDate']"), monthStartDate, "start Date", 20);
		staticWait(4000);
	}

	public void enterMonthEndDate() {
		getCurrentMonthStartEndDate();
		staticWait(2000);
		enter(By.xpath("//input[@name='OpenToDate']"), monthEndDate, "End Date", 20);
		staticWait(4000);
	}

	public void enterWeekEndDate() {
		getCurrentMonthStartEndDate();
		enter(By.xpath("//input[@id='OpenToDate']"), weekEndDate, "Week End Date", 20);
		staticWait(2000);
	}

	public void enterYesterdayDate() {
		getYesterdayDate();
		enter(By.xpath("//input[@id='OpenToDate']"), yesterdayDate, "yesterday Date", 20);
		staticWait(2000);
		enter(By.xpath("//input[@name='OpenFromDate']"), yesterdayDate, "yesterday end Date", 20);
		staticWait(4000);
	}

	public void enterLastWeekDate() {
		getLastWeekStartEndDate();
		enter(By.xpath("//input[@name='OpenFromDate']"), lastWeekStartDate, "lastWeek Start Date", 20);
		staticWait(2000);
		enter(By.xpath("//input[@id='OpenToDate']"), lastWeekEndDate, "lastWeek end Date", 20);
		staticWait(4000);
	}

	public void enterLastMonthDate() {
		getLastMonthStartEndDate();
		enter(By.xpath("//input[@name='OpenFromDate']"), lastMonthStartDate, "lastMonth Start Date", 20);
		staticWait(2000);
		enter(By.xpath("//input[@id='OpenToDate']"), lastMonthEndDate, "lastMonth end Date", 20);
		staticWait(4000);
	}

	public void clickticketDetailReport() {
		staticWait(2000);
		clickByJavascript(By.cssSelector("#aTicketDetailReport"), "Ticket Detail Report", 20);
	}

	public void ticketListing() {
		click(By.linkText("Ticketing"), "click on Ticket listing", 20);
	}

	public void clickListingcategory() {
		click(By.cssSelector("#headingOneTicket_Category"), "click on Ticket listing category", 20);
	}

	public void enterOpenedDateOnListingPage(String startDate, String endDate) {
		staticWait(3000);
//		clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 0);
		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateFromForTicketSearch']"),
				startDate, "Opened start Date", 30);
		staticWait(2000);
		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateToForTicketSearch']"),
				endDate, "Opened end Date", 30);
	}

	public void enterTodaysOpenedDate() {

		clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 0);
		getWeekStartEndDate();
		getCurrentMonthStartEndDate();
		getYesterdayDate();
		getYesterdayDate();
		getLastWeekStartEndDate();
		getLastMonthStartEndDate();
		if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {

			enterOpenedDateOnListingPage(datevalue, datevalue);
		} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
			getWeekStartEndDate();

			enterOpenedDateOnListingPage(weekStartDate, weekEndDate);

		} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
			enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);

		} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
			enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
					prop.getProperty("enterEndYearDate") + currentYear);

		} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
			getLastWeekStartEndDate();
			enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

		} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
			getCurrentMonthStartEndDate();
			enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
		} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
			getLastMonthStartEndDate();
			enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);

		} else {
			logger.info("fIlter not selected.");
		}
	}

	public void clickNocategory() {
		clickByJavascript(By.xpath("//input[@id='customcheckboxcategoryId']//following::label[1]"), "No category", 20);
	}

	// ---------------match category widget values from listing and detail report
	// page -

	public void verifyCategoryStatusValues() {
		/*
		 * try { int counter = 0; statusvalue = TicketingDashboardPage.statulist;
		 * 
		 * statusCount = TicketingDashboardPage.statusCountFromDashboard; for (int int2
		 * : statusCount) { logger.info("" + int2); } for (int j = 0; j <
		 * statusvalue.size(); j++) { logger.info("" + statusvalue.get(j)); statusText =
		 * statusvalue.get(j);
		 * 
		 * }
		 * 
		 * if (statusvalue.contains("NA") && (statusCount.size() == 1)) {
		 * 
		 * logger.info("less than size ::" + statusCount.size()); clickFullMenu();
		 * clickTicketingSideMenu(); clickTicketingOption();
		 * ticketListingPage.ticketListing();
		 * clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
		 * 
		 * if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
		 * 
		 * enterOpenedDateOnListingPage(datevalue, datevalue);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
		 * 
		 * enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
		 * enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
		 * enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") +
		 * currentYear, prop.getProperty("enterEndYearDate") + currentYear); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
		 * enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Month"))
		 * {
		 * 
		 * enterOpenedDateOnListingPage(monthStartDate, monthEndDate); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
		 * enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate); }
		 */		try {
				int counter = 0;
				statusvalue = TicketingDashboardPage.statulist;

				statusCount = TicketingDashboardPage.statusCountFromDashboard;
				for (int int2 : statusCount) {
					logger.info("" + int2);
				}
				for (int j = 0; j < statusvalue.size(); j++) {
					logger.info("" + statusvalue.get(j));
					statusText = statusvalue.get(j);

				}

				if (statusvalue.contains("NA") && (statusCount.size() == 1)) {

					logger.info("less than size ::" + statusCount.size());
					clickFullMenu();
					clickTicketingSideMenu();
					clickTicketingOption();
					ticketListingPage.ticketListing();
					clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);

					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {

						enterOpenedDateOnListingPage(datevalue, datevalue);

					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						getWeekStartEndDate();

						enterOpenedDateOnListingPage(weekStartDate, weekEndDate);

					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						getYesterdayDate();
						getYesterdayDate();

						enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);

					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
								prop.getProperty("enterEndYearDate") + currentYear);
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						getLastWeekStartEndDate();

						enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						getCurrentMonthStartEndDate();

						enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						getLastMonthStartEndDate();

						enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
					}
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
				ticketListingPage.clickSearchIcon();
			} else if (statusvalue.contains("NA") && (statusCount.size() > 1)) {
				logger.info("greater than size ::" + statusCount.size());

				clickFullMenu();
				clickTicketingSideMenu();
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
					enterOpenedDateOnListingPage(datevalue, datevalue);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else {
					logger.info("fIlter not selected.");
				}
				//clickSearch();//modified
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

				ticketListingPage.clickSearchIcon();

				clickFullMenu();
				clickTicketingSideMenu();
				//clickTicketingOption();
				clickTicketReport();

				statusCount.remove(0);
				statusvalue.remove(0);

				for (String value : statusvalue) {
					clickCategoryDropdownStatus();
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					click(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),
							value, 30);
					logger.info(value);

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartTodaysDate();
							enterEndTodaysDate();
						} else {
							enterOpenedDateOnListingPage(datevalue, datevalue);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterWeekStartDate();
							enterWeekEndDate();
						} else {
							enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterYesterdayDate();
						} else {
							enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartYearDate();
							enterEndYearDate();
						} else {
							enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
									prop.getProperty("enterEndYearDate") + currentYear);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastWeekDate();
						} else {
							enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterMonthStartDate();
							enterMonthEndDate();
						} else {
							enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastMonthDate();
						} else {
							enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
						}
					} else {
						logger.info("fIlter not selected.");
					}

					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			} else if (!statusvalue.contains("NA")) {
				for (String value : statusvalue) {
					clickCategoryDropdownStatus();
					staticWait(3000);
					//click(By.xpath("//div[@class='btn-group show']//li//a//label[text()='  " + value + "']"), value,30);
					WebElement selectCategory = driver.findElement(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"));
					Actions action=new Actions(driver);
					action.moveToElement(selectCategory).click().perform();
					logger.info(value);

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						enterStartTodaysDate();
						enterEndTodaysDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						enterWeekStartDate();
						enterWeekEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						enterYesterdayDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						enterStartYearDate();
						enterEndYearDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						enterLastWeekDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						enterMonthStartDate();
						enterMonthEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						enterLastMonthDate();
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);
					staticWait(3000);
					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error from verifyTodayStatusValues method." + e);
			e.printStackTrace();
		}
	}

	public void verifyChannelStatusValues() {
		try {
			int counter = 0;
			statusvalue = TicketingDashboardPage.statulist;

			statusCount = TicketingDashboardPage.statusCountFromDashboard;
			for (int int2 : statusCount) {
				logger.info("" + int2);
			}
			for (int j = 0; j < statusvalue.size(); j++) {
				logger.info("" + statusvalue.get(j));
				statusText = statusvalue.get(j);

			}

			if (statusvalue.contains("NA") && (statusCount.size() == 1)) {

				logger.info("less than size ::" + statusCount.size());
				clickFullMenu();
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);

				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
					enterOpenedDateOnListingPage(datevalue, datevalue);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {

					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
				}
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

				ticketListingPage.clickSearchIcon();
			} else if (statusvalue.contains("NA") && (statusCount.size() > 1)) {
				logger.info("greater than size ::" + statusCount.size());

				clickFullMenu();
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
//					enterStartTodaysDate();
//					enterEndTodaysDate();
					enterOpenedDateOnListingPage(datevalue, datevalue);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
//					enterWeekStartDate();
//					enterWeekEndDate();
					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
//					getYesterdayDate();
					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
//					enterStartYearDate();
//					enterEndYearDate();
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
//					enterLastWeekDate();
					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
//					enterMonthStartDate();
//					enterMonthEndDate();
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
//					enterLastMonthDate();
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else {
					logger.info("fIlter not selected.");
				}
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
				ticketListingPage.clickSearchIcon();

				clickFullMenu();
				clickTicketingOption();
				clickTicketReport();

				statusCount.remove(0);
				statusvalue.remove(0);

				for (String value : statusvalue) {
					clickCategoryDropdownStatus();
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),
							value, 30);
					logger.info(value);

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartTodaysDate();
							enterEndTodaysDate();
						} else {
							enterOpenedDateOnListingPage(datevalue, datevalue);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterWeekStartDate();
							enterWeekEndDate();
						} else {
							enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterYesterdayDate();
						} else {
							enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartYearDate();
							enterEndYearDate();
						} else {
							enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
									prop.getProperty("enterEndYearDate") + currentYear);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastWeekDate();
						} else {
							enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterMonthStartDate();
							enterMonthEndDate();
						} else {
							enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastMonthDate();
						} else {
							enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
						}
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			} else if (!statusvalue.contains("NA")) {
				for (String value : statusvalue) {
					clickCategoryDropdownStatus();
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),value, 30);
					logger.info(value);

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						enterStartTodaysDate();
						enterEndTodaysDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						enterWeekStartDate();
						enterWeekEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						enterYesterdayDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						enterStartYearDate();
						enterEndYearDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						enterLastWeekDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						enterMonthStartDate();
						enterMonthEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						enterLastMonthDate();
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error from verifyTodayStatusValues method." + e);
			e.printStackTrace();
		}
	}

	public void channelDropDown() {
		staticWait(3000);

		click(By.xpath("//*[@id='frmReport']/div[1]/div[12]/div/span/div/button"), "channel drop", 20);
		// *[@id="frmReport"]/div[1]/div[12]/div/span/div/button
	}
	// ---------------match channel widget values from listing and detail report
	// page ---------//

	public void verifyChannelWidgetValues() {
		/*
		 * staticWait(3000); try { int counter = 0;
		 * 
		 * statusvalue = TicketingDashboardPage.statulist;
		 * 
		 * statusCount = TicketingDashboardPage.statusCountFromDashboard; for (int int2
		 * : statusCount) { logger.info("" + int2); } for (int j = 0; j <
		 * statusvalue.size(); j++) { logger.info(listFirstIndex = statusvalue.get(j));
		 * statusText = statusvalue.get(j);
		 * 
		 * } if (statusvalue.contains("NA") && (statusCount.size() == 1)) {
		 * 
		 * logger.info("less than size ::" + statusCount.size()); clickFullMenu();
		 * clickTicketingOption(); ticketListingPage.ticketListing();
		 * clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
		 * 
		 * if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
		 * 
		 * enterOpenedDateOnListingPage(datevalue, datevalue);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
		 * getWeekStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
		 * getYesterdayDate(); getYesterdayDate();
		 * 
		 * enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
		 * enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") +
		 * currentYear, prop.getProperty("enterEndYearDate") + currentYear); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
		 * getLastWeekStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Month"))
		 * { getCurrentMonthStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(monthStartDate, monthEndDate); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
		 * getLastMonthStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate); }
		 * 
		 * ticketListingPage.clickChannel(); ticketListingPage.selectNoChannel();
		 * 
		 * WebElement m =
		 * driver.findElement(By.xpath("//div[@class='card-header filter-head']")); //
		 * Javascript executor ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", m);
		 * ticketListingPage.clickSearchIcon(); } else if (statusvalue.contains("NA") &&
		 * (statusCount.size() > 1)) { logger.info("greater than size ::" +
		 * statusCount.size());
		 * 
		 * clickFullMenu(); clickTicketingOption(); ticketListingPage.ticketListing();
		 * clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
		 * if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
		 * 
		 * enterOpenedDateOnListingPage(datevalue, datevalue);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
		 * getWeekStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
		 * getYesterdayDate(); getYesterdayDate();
		 * 
		 * enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
		 * enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") +
		 * currentYear, prop.getProperty("enterEndYearDate") + currentYear); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
		 * getLastWeekStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
		 * 
		 * } else if (TicketingDashboardPage.SelectedFilterText.contains("This Month"))
		 * { getCurrentMonthStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(monthStartDate, monthEndDate); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
		 * getLastMonthStartEndDate();
		 * 
		 * enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate); } else {
		 * logger.info("fIlter not selected."); } ticketListingPage.clickChannel();
		 * ticketListingPage.selectNoChannel(); WebElement m =
		 * driver.findElement(By.xpath("//div[@class='card-header filter-head']")); //
		 * Javascript executor ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", m);
		 * ticketListingPage.clickSearchIcon();
		 * 
		 * clickFullMenu(); clickTicketingOption(); clickTicketReport();
		 * 
		 * statusCount.remove(0); statusvalue.remove(0);
		 * 
		 * for (String value : statusvalue) {
		 * 
		 * //channelDropDown(); //CompanySetupPage companySetUpPage=new
		 * CompanySetupPage(driver); //String channelname =
		 * companySetUpPage.Channelnewname; //enter(By.
		 * xpath("//div[@class='form-group']/label[contains(text(),'Channel')]/ancestor::div[@class='col-lg-4']/descendant::div[@class='input-group']/input[@placeholder='Enter Keywords']"
		 * ), channelname, channelname, 30); //staticWait(3000); //clickByJavascript(By.
		 * xpath("//div[@class='btn-group show']//li//a//label[text()=' "+channelname+
		 * "']"),channelname, 30); clickByJavascript(By.
		 * xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"
		 * ),value, 30); logger.info(value);
		 * 
		 * clickSelectStatus(); if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Today")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterStartTodaysDate();
		 * enterEndTodaysDate(); } else { enterOpenedDateOnListingPage(datevalue,
		 * datevalue); } } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("This Week")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterWeekStartDate();
		 * enterWeekEndDate(); } else { enterOpenedDateOnListingPage(weekStartDate,
		 * weekEndDate); } } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterYesterdayDate(); }
		 * else { enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate); } } else
		 * if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterStartYearDate();
		 * enterEndYearDate(); } else {
		 * enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") +
		 * currentYear, prop.getProperty("enterEndYearDate") + currentYear); } } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterLastWeekDate(); }
		 * else { enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
		 * 
		 * } } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("This Month")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterMonthStartDate();
		 * enterMonthEndDate(); } else { enterOpenedDateOnListingPage(monthStartDate,
		 * monthEndDate); } } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) { if
		 * (driver.getCurrentUrl().contains("TicketReport")) { enterLastMonthDate(); }
		 * else { enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate); }
		 * } else { logger.info("fIlter not selected."); } clickSearch();
		 * clickSelectStatus(); getTotalRecordCount(); logger.info("record  :: " +
		 * recordCount);
		 * 
		 * List<WebElement> listOfTicket = driver.findElements(By.xpath(
		 * "//div[@id='viewer_table1']/table/tbody/tr[position()>2]/td[1]")); int
		 * ticketnumber = listOfTicket.size(); //if (statusCount.get(counter) ==
		 * recordCount) { if (ticketnumber == recordCount) {
		 * getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
		 * logger.info("record count is :: " + recordCount +
		 * " is matched succesfully from Detail Report count.");
		 * pageRefresh("Detail report page"); //clickSelectStatus();//modified
		 * counter++; } else { getTest().log(LogStatus.FAIL,
		 * "record count is not matched"); takeScreenshot("matchStatusCount");
		 * Assert.fail("matchStatusCount"); logger.info("record count is not matched");
		 * }
		 * 
		 * } } else if (!statusvalue.contains("NA")) { for (String value : statusvalue)
		 * { staticWait(3000); //channelDropDown(); //String channelname =
		 * companySetUpPage.Channelnewname; //enter(By.
		 * xpath("//div[@class='form-group']/label[contains(text(),'Channel')]/ancestor::div[@class='col-lg-4']/descendant::div[@class='input-group']/input[@placeholder='Enter Keywords']"
		 * ), channelname, channelname, 30); //staticWait(3000); //clickByJavascript(By.
		 * xpath("//div[@class='btn-group show']//li//a//label[text()=' "+channelname+
		 * "']"),channelname, 30); //clickByJavascript(By.
		 * xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"
		 * ),value, 30);//NA logger.info(value);
		 * 
		 * clickSelectStatus(); if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
		 * enterStartTodaysDate(); enterEndTodaysDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
		 * enterWeekStartDate(); enterWeekEndDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
		 * enterYesterdayDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
		 * enterStartYearDate(); enterEndYearDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
		 * enterLastWeekDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
		 * enterMonthStartDate(); enterMonthEndDate(); } else if
		 * (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
		 * enterLastMonthDate(); } else { logger.info("fIlter not selected."); }
		 * clickSearch(); clickSelectStatus(); getTotalRecordCount();
		 * logger.info("record  :: " + recordCount); //List<WebElement> listOfTicket =
		 * driver.findElements(By.xpath(
		 * "//div[@id='viewer_table1']/table/tbody/tr[position()>2]/td[1]")); //int
		 * ticketnumber = listOfTicket.size(); if (statusCount.get(counter) ==
		 * recordCount) { //if (ticketnumber == recordCount) {
		 * 
		 * if (statusCount.get(counter) == recordCount) {
		 * 
		 * getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
		 * logger.info("record count is :: " + recordCount +
		 * " is matched succesfully from Detail Report count.");
		 * pageRefresh("Detail report page"); //clickSelectStatus();//modified
		 * counter++; } else { getTest().log(LogStatus.FAIL,
		 * "record count is not matched"); takeScreenshot("matchStatusCount");
		 * Assert.fail("matchStatusCount"); logger.info("record count is not matched");
		 * }
		 * 
		 * 
		 * } } }
		 * 
		 * } catch (Exception e) {
		 * logger.error("Error from verifyTodayStatusValues method." + e);
		 * e.printStackTrace(); }
		 */
		try {
			int counter = 0;
			statusvalue = TicketingDashboardPage.statulist;

			statusCount = TicketingDashboardPage.statusCountFromDashboard;
			for (int int2 : statusCount) {
				logger.info("" + int2);
			}
			for (int j = 0; j < statusvalue.size(); j++) {
				logger.info("" + statusvalue.get(j));
				statusText = statusvalue.get(j);

			}

			if (statusvalue.contains("NA") && (statusCount.size() == 1)) {

				logger.info("less than size ::" + statusCount.size());
				clickFullMenu();
				
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);

				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
					enterOpenedDateOnListingPage(datevalue, datevalue);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {

					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
				}
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
				ticketListingPage.clickSearchIcon();
			} else if (statusvalue.contains("NA") && (statusCount.size() > 1)) {
				logger.info("greater than size ::" + statusCount.size());

				clickFullMenu();

				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);
				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
					enterOpenedDateOnListingPage(datevalue, datevalue);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else {
					logger.info("fIlter not selected.");
				}
				//clickSearch();//modified
				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

				ticketListingPage.clickSearchIcon();

				clickFullMenu();
				clickTicketingOption();
				clickTicketReport();

				statusCount.remove(0);
				statusvalue.remove(0);

				for (String value : statusvalue) {
					channelDropDown();
					clickCategoryDropdownStatus();
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					click(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),
							value, 30);
					logger.info(value);
					staticWait(1000);
					
					/*
					 * String channelname = companySetUpPage.Channelnewname; clickByJavascript(By.
					 * xpath("//div[@class='btn-group show']//li//a//label[text()=' "+channelname+
					 * "']"),channelname, 30);
					 */

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartTodaysDate();
							enterEndTodaysDate();
						} else {
							enterOpenedDateOnListingPage(datevalue, datevalue);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterWeekStartDate();
							enterWeekEndDate();
						} else {
							enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterYesterdayDate();
						} else {
							enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartYearDate();
							enterEndYearDate();
						} else {
							enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
									prop.getProperty("enterEndYearDate") + currentYear);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastWeekDate();
						} else {
							enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterMonthStartDate();
							enterMonthEndDate();
						} else {
							enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastMonthDate();
						} else {
							enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
						}
					} else {
						logger.info("fIlter not selected.");
					}

					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			} else if (!statusvalue.contains("NA")) {
				for (String value : statusvalue) {
					channelDropDown();
					clickCategoryDropdownStatus();
					staticWait(3000);
					//click(By.xpath("//div[@class='btn-group show']//li//a//label[text()='  " + value + "']"), value,30);
					WebElement selectCategory = driver.findElement(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"));
					Actions action=new Actions(driver);
					action.moveToElement(selectCategory).click().perform();
					logger.info(value);
					staticWait(1000);
					
					/*
					 * String channelname = companySetUpPage.Channelnewname; clickByJavascript(By.
					 * xpath("//div[@class='btn-group show']//li//a//label[text()=' "+channelname+
					 * "']"),channelname, 30);
					 */

					clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						enterStartTodaysDate();
						enterEndTodaysDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						enterWeekStartDate();
						enterWeekEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						enterYesterdayDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						enterStartYearDate();
						enterEndYearDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						enterLastWeekDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						enterMonthStartDate();
						enterMonthEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						enterLastMonthDate();
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);
					staticWait(3000);
					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error from verifyTodayStatusValues method." + e);
			e.printStackTrace();
		}
		driver.navigate().refresh();
	}

	public void clickCategoryDropdownStatus() {
		waitForVisibilityOfElement(By.xpath("//*[@id='frmReport']/div[1]/div[9]/div/span/div/button"), 50);
		click(By.xpath("//*[@id='frmReport']/div[1]/div[9]/div/span/div/button"), "Category dropdown status", 20);
	}

	// ----------------------Tickets by category widget count
	// match----------------------- //

	public void verifyStatusValues() {
		try {
			int counter = 0;
			clickSelectStatus();
			statusvalue = TicketingDashboardPage.statulist;
			List<Integer> statusCount = TicketingDashboardPage.statusCountFromDashboard;
			for (String value : statusvalue) {
				//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
				clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Issue in Software']"),value, 30);
				logger.info(value);
				clickSearch();
				clickSelectStatus();
				getTotalRecordCount();
				logger.info("record  :: " + recordCount);

				if (statusCount.get(counter) == recordCount) {
					getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
					logger.info(
							"record count is :: " + recordCount + " is matched succesfully from Detail Report count.");
					pageRefresh("Detail report page");
					clickSelectStatus();
					counter++;
				} else {
					getTest().log(LogStatus.FAIL, "record count is not matched");
					takeScreenshot("matchStatusCount");
					Assert.fail("matchStatusCount");
					logger.info("record count is not matched");
				}
			}
		} catch (Exception e) {
			logger.error("error from verifyWeekStatusValues method." + e);
		}
	}

	public void clickProductDropdown() {
		staticWait(3000);
		click(By.xpath("//*[@id='frmReport']/div[1]/div[11]/div/span/div/button"), "product dropdown", 30);
	}

	// -----------match product widget values from detail report----

	public void verifyProductWidgetCount() {
		try {
			int counter = 0;
			statusvalue = TicketingDashboardPage.statulist;

			statusCount = TicketingDashboardPage.statusCountFromDashboard;
			for (int int2 : statusCount) {
				logger.info("" + int2);
			}
			for (int j = 0; j < statusvalue.size(); j++) {
				logger.info("" + statusvalue.get(j));
				statusText = statusvalue.get(j);

			}

			if (statusvalue.contains("NA") && (statusCount.size() == 1)) {

				logger.info("less than size ::" + statusCount.size());
				clickFullMenu();
				clickTicketingSideMenu();
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);

				if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {

					enterOpenedDateOnListingPage(datevalue, datevalue);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
					getWeekStartEndDate();

					enterOpenedDateOnListingPage(weekStartDate, weekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
					getYesterdayDate();
					getYesterdayDate();

					enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
					enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
							prop.getProperty("enterEndYearDate") + currentYear);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
					getLastWeekStartEndDate();

					enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

				} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
					getCurrentMonthStartEndDate();

					enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
				} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
					getLastMonthStartEndDate();

					enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
				}
				ticketListingPage.clickProduct();
				ticketListingPage.selectNoProduct();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);
				ticketListingPage.clickSearchIcon();
			} else if (statusvalue.contains("NA") && (statusCount.size() > 1)) {
				logger.info("greater than size ::" + statusCount.size());

				clickFullMenu();
				clickTicketingSideMenu();
				clickTicketingOption();
				ticketListingPage.ticketListing();
				clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 20);

				clickListingcategory();
				clickNocategory();
				WebElement m = driver.findElement(By.xpath("//div[@class='card-header filter-head']"));
				// Javascript executor
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", m);

				ticketListingPage.clickSearchIcon();

				clickFullMenu();
				clickTicketingSideMenu();
				//clickTicketingOption();
				clickTicketReport();

				statusCount.remove(0);
				statusvalue.remove(0);

				for (String value : statusvalue) {
					clickProductDropdown();
					staticWait(2000);
					clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Others']"),"Others", 30);
					logger.info(value);
					//logger.info("Others");

					//clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartTodaysDate();
							enterEndTodaysDate();
						} else {
							enterOpenedDateOnListingPage(datevalue, datevalue);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterWeekStartDate();
							enterWeekEndDate();
						} else {
							enterOpenedDateOnListingPage(weekStartDate, weekEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterYesterdayDate();
						} else {
							enterOpenedDateOnListingPage(yesterdayDate, yesterdayDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterStartYearDate();
							enterEndYearDate();
						} else {
							enterOpenedDateOnListingPage(prop.getProperty("enterStartYearDate") + currentYear,
									prop.getProperty("enterEndYearDate") + currentYear);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastWeekDate();
						} else {
							enterOpenedDateOnListingPage(lastWeekStartDate, lastWeekEndDate);

						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterMonthStartDate();
							enterMonthEndDate();
						} else {
							enterOpenedDateOnListingPage(monthStartDate, monthEndDate);
						}
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						if (driver.getCurrentUrl().contains("TicketReport")) {
							enterLastMonthDate();
						} else {
							enterOpenedDateOnListingPage(lastMonthStartDate, lastMonthEndDate);
						}
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickProductDropdown();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						//clickProductDropdown();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			} else if (!statusvalue.contains("NA")) {
				for (String value : statusvalue) {
					clickProductDropdown();
					staticWait(3000);
					clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' " + value + "']"),value, 30);
					//clickByJavascript(By.xpath("//div[@class='btn-group show']//li//a//label[text()=' Others']"),"Others", 30);
					logger.info(value);
					//logger.info("Others");

					//clickSelectStatus();
					if (TicketingDashboardPage.SelectedFilterText.contains("Today")) {
						enterStartTodaysDate();
						enterEndTodaysDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Week")) {
						enterWeekStartDate();
						enterWeekEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Yesterday")) {
						enterYesterdayDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Year")) {
						enterStartYearDate();
						enterEndYearDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Week")) {
						enterLastWeekDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("This Month")) {
						enterMonthStartDate();
						enterMonthEndDate();
					} else if (TicketingDashboardPage.SelectedFilterText.contains("Last Month")) {
						enterLastMonthDate();
					} else {
						logger.info("fIlter not selected.");
					}
					clickSearch();
					clickSelectStatus();
					getTotalRecordCount();
					logger.info("record  :: " + recordCount);

					if (statusCount.get(counter) == recordCount) {
						getTest().log(LogStatus.PASS, "record count is :: " + recordCount);
						logger.info("record count is :: " + recordCount
								+ " is matched succesfully from Detail Report count.");
						pageRefresh("Detail report page");
						//clickSelectStatus();
						counter++;
					} else {
						getTest().log(LogStatus.FAIL, "record count is not matched");
						takeScreenshot("matchStatusCount");
						Assert.fail("matchStatusCount");
						logger.info("record count is not matched");
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error from verifyTodayValuesByProduct method." + e);
		}
		driver.navigate().refresh();
	}
}
