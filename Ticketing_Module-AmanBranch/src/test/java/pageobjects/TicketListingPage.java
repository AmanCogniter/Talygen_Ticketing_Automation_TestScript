package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class TicketListingPage extends WebBasePage {
	WebDriver driver;
	AddTicketPage addTicketPage;
	CompanySetupPage companySetupPage;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	static String resolverName;
	List<String> resolverNameFromDashboard;
	List<String> resolverCountFromDashboard;
	List<WebElement> ticketListing;
	static String pattern = "MM/dd//yyyy";
	static Date date = new Date();
	static SimpleDateFormat dateformat = new SimpleDateFormat(pattern);

	static String datevalue = dateformat.format(date);
	
	
	static String resolverNameText;
	static String resolverCountText;
	static String ticketListText;
	static String enteriesText;
	static int listSize;
	static String weekEndDate;
	static String weekStartDate;
	static String monthStartDate;
	static String monthEndDate;
	static String yesterdayDate;
	static String lastWeekStartDate;
	static String lastWeekEndDate;
	static String lastMonthStartDate;
	static String lastMonthEndDate;
	static String ticketvalue;
	static String getTicketNo;

	public TicketListingPage(WebDriver driver) {
		super(driver, "Ticket Listing Page");
		this.driver = driver;
		this.addTicketPage = new AddTicketPage(driver);

	}

	String cannedReply = "Check";

	public void ticketListing() {
		click(By.linkText("Ticketing"), "click on Ticket listing", 20);
	}

	public void homeBreadcrumb() {
		staticWait(3000);
		click(By.xpath("//div[@id='SiteMapLink']/ol/li/a"), "Click om Home Breadcrumb", 20);
	}

	// click on Side menu
	public void clickTicketingSideMenu() {
		click(By.xpath("//li[@data-name='Ticketing']//a//i//following::text()[1]//following::span[1]"),
				"Ticketing Side menu", 20);
	}

	public void validateUrlOfHomePage() {
		staticWait(2000);
		getCurrentUrl(prop.getProperty("homePageUrl"), "On clicking Home Page Breadcrumb");
	}

	public void ticketNumber() {
		staticWait(2000);
		click(By.xpath("//div/h5/a/span[contains(text(),'Ticket Number')]"), "click on Ticket Number", 20);
	}

	public void enterValueInTicketNo() {
		staticWait(2000);
		enter(By.xpath("//div/input[@placeholder='Search by Ticket Number']"), addTicketPage.ticketNoGenerated, "enter value in Ticket Number", 20);
	}

	public void clickOnResetButton() {
		staticWait(2000);
		findElementInVisibility(By.xpath("//span[@data-original-title='Reset']"), 20);
		click(By.xpath("//span[@data-original-title='Reset']"), "Click on Reset Button", 20);
	}

	public void clickOnActionButton() {
		findElementVisibility(By.xpath("//i[@class='fa fa-ellipsis-h action_icon']"), 20);
		clickByJavascript(By.xpath("//i[@class='fa fa-ellipsis-h action_icon']"), "Action Button", 20);
	}

	public void clickOnViewButton() {
		staticWait(3000);
		click(By.xpath("//span/a[@data-original-title='View']"),
				"Click on View Button", 20);
	}
	public void clickOnListViewButton() {
		staticWait(3000);
		click(By.xpath("//div/span/a[@data-original-title='List View']"),
				"Click on List View", 20);
	}

	// Validate reset button functionality through Ticket number placeholader value
	public String verifyTicketNoPlaceholder(String attributeValue, String name, By by) {

		WebElement ele = findElementVisibility(by, 10);
		String attribute = ele.getAttribute(attributeValue);
		if (attribute.contains(prop.getProperty("ticketPlaceholder"))) {
			logger.info(name + " is empty on clicking reset button.");
			getTest().log(LogStatus.PASS, name + "is empty on clicking reset button.");
		} else {
			getTest().log(LogStatus.FAIL, name + "is not empty on clicking reset button.");
			logger.info(name + "is not empty on clicking reset button.");
			Assert.fail(name + "is not empty on clicking reset button.");
			takeScreenshot(name + " is not empty on clicking reset button.");

		}
		return attribute;
	}

	public void ticketNoPlaceholder() {
		/*
		 * verifyTicketNoPlaceholder("placeholder", "Ticket number plaveholder",
		 * By.cssSelector("#ticketNumber"));
		 */
		verifyTicketNoPlaceholder("placeholder", "Ticket number plaveholder", By.xpath("//div/input[@placeholder='Search by Ticket Number']"));
	}

	public void clickCollapseButton() {
		click(By.xpath("//span[@data-target='.multi-collapse']"), "Collapse button", 20);
	}

	public void collapseExpandFunctionality() {
		/*
		 * toCheckElementIsDisplayed(By.cssSelector("#divTicketListing"), 20,
		 * " left side items are expand on clicking expand button");
		 */
		toCheckElementIsDisplayed(By.xpath("//span[@data-target='.multi-collapse']"), 20,
				" left side items are expand on clicking expand button");
	}

	public void enterTicketNumber() {
		staticWait(2000);
		enter(By.xpath("#//div/input[@placeholder='Search by Ticket Number']"), addTicketPage.ticketNoGenerated, "value entered is ", 20);

	}

	public void enterGeneratedTicketNumber() {
		staticWait(3000);
		enter(By.xpath("//div/input[@placeholder='Search by Ticket Number']"), addTicketPage.ticketNoGenerated, "value entered is " + getTicketNo, 20);
	}

	public void clickSearchIcon() {
		staticWait(3000);
		//findElementInVisibility(By.xpath("//a[@id='Search']//i[@class='fa fa-search'][1]"), 20);
		click(By.xpath("//div/h5//span[@data-original-title='Search']"), " Search icon ", 20);
	}

	public void matchSearchedValues() {
		String ticketNumber;
		try {
			findElementsVisibility(By.xpath("//div[@id='divtablelistingdata']/table/tbody/tr/td[2]/span"));
			ticketNumber = getText(By.xpath("//div[@id='divtablelistingdata']/table/tbody/tr/td[2]/span"), 20);
			if (ticketNumber.contains(addTicketPage.ticketNoGenerated)) {
				getTest().log(LogStatus.PASS, ticketvalue + " is successfully matched");
				logger.info(ticketNumber + " is successfully matched");
			} else {
				getTest().log(LogStatus.FAIL, ticketvalue + " is not matched");
				logger.info(ticketNumber + " is not matched");
				takeScreenshot(ticketNumber + " is not matched");
				Assert.fail("" + ticketNumber + " is not matched");
				ticketNumber = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void matchSearchWithResetButton() {
		try {
			ticketNumber();
//			findElementsVisibility(By.path("//table[@id='tblticketlistigdata']//tr[1]//td[1]"));
//			ticketNumber = getText(By.xpath("//table[@id='tblticketlistigdata']//tr[1]//td[1]"), 20);
			String placheolderText = getAtribute(By.xpath("//div/input[@placeholder='Search by Ticket Number']"), "placeholder", 20);

			if (placheolderText.equals("Ticket Number")) {
				getTest().log(LogStatus.PASS, placheolderText + " is successfully matched");
				logger.debug(placheolderText + " is successfully matched");
			} else {
				getTest().log(LogStatus.FAIL, placheolderText + " is not matched");
				logger.debug(placheolderText + " is not matched");
				takeScreenshot(placheolderText + " is not matched");
				Assert.fail("" + placheolderText + " is not matched");
//				ticketNumber = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUnassignedWidget() {
		clickByJavascript(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[1]"), " unassigned widgets ", 20);
	}
	public void clickOnListView() {
		try {
			staticWait(3000);
			WebElement listView = driver.findElement(By.xpath("//a[@data-original-title='List View']"));
			if (listView.isDisplayed()) {
				clickByJavascript(By.xpath("//a[@data-original-title='List View']"), "List View", 20);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Page is already in list view mode");
		}
		
	}
	

	public void verifyTicketStatus() {
		String ticketStatus;
		try {
			waitForVisibilityOfElement(By.xpath("//span[@id='status_id']"), 50);
			//findElementsVisibility(By.xpath("//td[@class='text-center overflow-visible']"));
			//ticketStatus = getText(By.xpath("//td[@class='text-center overflow-visible']"), 20);
			ticketStatus = getText(By.xpath("//td[@class='text-center']/span[@title='Open']"), 20);
			if (ticketStatus.equals("Open")) {
				getTest().log(LogStatus.PASS, ticketStatus + " is successfully matched");
				logger.debug(ticketStatus + " is successfully matched");
			} else {
				getTest().log(LogStatus.FAIL, ticketStatus + " is not matched");
				logger.debug(ticketStatus + " is not matched");
				takeScreenshot(ticketStatus + " is not matched");
				Assert.fail("" + ticketStatus + " is not matched");
				ticketStatus = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnHoldWidgets() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[2]"), " on hold widget", 20);
	}

	public void clickOnReplyButton() {
		clickByJavascript(By.xpath("//a[@data-original-title='Reply']"), " reply button", 15);
	}

	public void clickOnShowAddTicket() {
		findElementVisibility(By.xpath("//a[@data-original-title='Show/Hide Add']"), 20);
		clickByJavascript(By.xpath("//a[@data-original-title='Show/Hide Add']"), " show add/Hide button", 20);
	}

	// Select CannedReply DropDown
	public void selectCannedReply() {
		waitForVisibilityOfElement(By.xpath("//select[@id='ddlReplyTemplate']"), 50);
//			String value = (cannedReply.equals("Check")) ? "Check" : "Select Template";
		click(By.xpath("//select[@id='ddlReplyTemplate']"), " canned Reply ", 20);
	
		click(By.xpath("//select[@id='ddlReplyTemplate']/option[text()='Final Reply']"), "Select canned Reply ", 20);
			//selectValueWithText(By.xpath("//select[@id='ddlReplyTemplate']"), "FInal Reply ", "Canned Reply", 10);
	}
	// enter Description in Template
			public void enterReplyDescription() {
				staticWait(3000);
				//click(By.xpath("//span[text()='Source']"), "Source", 15);
				enter(By.xpath("//body[contains(@class,'cke_editable cke_editable_themed cke_contents_ltr cke_theme_Light cke_show_borders')]/div"), prop.getProperty("ticketDescription"), "Description",
						15);
			}

	public void clickOnSubmitReply() {
		click(By.xpath("//div/a[@id='aTicketReplySave']"), " submitReply button", 20);
	}

	public void validateCountOfReplyButton(String name) {

		/*
		 * String getReplyCount = getText( By.
		 * xpath("//tr[1]//td[@class='text-center single-action']//span[@class='noti-circle noti-green']"
		 * ), 20);
		 */
		String getReplyCount = getText(
				By.xpath("//div[@class='conversation-header']"), 20);
		int replyCount = Integer.parseInt(getReplyCount);
				/*
		 * List<WebElement> options =
		 * driver.findElements(By.xpath("//div[@class='conversation-box-con']"));
		 */
		List<WebElement> options = driver.findElements(By.xpath("//div[@class='conversation-box']"));

		for (int i = 0; i < options.size(); i++) {
			if (options.size() == replyCount) {
				getTest().log(LogStatus.PASS, name + " is successfully matched");
				logger.debug(name + " is successfully matched" + options.size());
			} else {
				getTest().log(LogStatus.FAIL, name + " is not matched");
				logger.debug(name + " is not matched");
				takeScreenshot(name + " is not matched");
				Assert.fail("" + name + " is not matched");

			}
		}
	}

	public void clickFollowUp() {
		clickByJavascript(By.xpath("//span/a[@data-original-title='Add a Follow-Up']"), "Add follow up button", 20);
	}

	public void clickAddFollowUp() {
		clickByJavascript(By.xpath("//a[@id='andaddfolowups']"), "Add button", 20);
	}

	public void clickOnDatePicker() {
		staticWait(3000);
		/*
		 * String today; String tomorrow; Date date; Format formatter; Calendar calendar
		 * = Calendar.getInstance();
		 * 
		 * date = calendar.getTime(); formatter = new SimpleDateFormat("MM/dd/yyyy");
		 * today = formatter.format(date); System.out.println("Today : " + today);
		 * 
		 * calendar.add(Calendar.DATE, 1); date = calendar.getTime(); formatter = new
		 * SimpleDateFormat("MM/dd/yyyy"); tomorrow = formatter.format(date);
		 * System.out.println("Tomorrow : " + tomorrow);
		 */
		click(By.xpath(
				"//input[contains(@class,'form-control  hasdatetimepicker')]//following::div[@data-original-title='Select Date']"),
				"Date picker", 20);
		click(By.xpath(
				"//table/tbody/tr/td[@class='day active today']/following-sibling::td"),
				"Tomorrow Date", 20);

		//click(By.xpath("//table[@class='table table-sm']//tbody//tr//td[@class='day active today']"), "Select Date picker", 20);
		//enter(By.xpath("//tg-input/input[@id='ScheduleDate']"), tomorrow, "Tomorrow date selected", 20);
		// table[@class='table table-sm']//tbody//tr[2]//td[1]aaa
//		click(By.cssSelector("td.day.active.today"), "select follow up Date", 20);
	}

	public void clickOnTimePicker() {

		staticWait(3000);
		clickByJavascript(By.xpath(
				"//tg-input/input[@id='Time']//following::div[@data-original-title='Select Time']"),
				"time picker", 20);
		click(By.xpath("//td/button[@title='Toggle Period']"), "Select Time", 30);
//		clickByJavascript(By.xpath(
//				"//input[@class='form-control hasdatetimepicker']//following::div[@data-original-title='Select Time']"),
//				"time picker", 20);
	}

	public void checkFollowUpPopup() {
		toCheckElementIsDisplayed(By.xpath("//div[@id='divfollowUpPop']"), 20, "follow up Pop-up is displayed.");
	}

	public void clickOnTicketSubject() {
		//AddTicketPage addTicketPage= new AddTicketPage(driver);
		click(By.xpath("//table/tbody/tr/td[3]"), "ticket subject", 20);
		/*
		 * enter(By.xpath("//div[@class='form-group']/input[@id='Subject']"),
		 * addTicketPage.ticketSubject, "Ticket Subject", 20);
		 * clickByJavascript(By.xpath("//span/a[@id='Search']"), "Secrch button", 30);
		 * waitForVisibilityOfElement(By.xpath(
		 * "//table[@id='tblticketlistigdata']/tbody/tr/td[3]/a[@data-toggle-tooltip='tooltip']/span[@class='text-overflow-dynamic-container']"
		 * ), 50); clickByJavascript(By.xpath(
		 * "//table[@id='tblticketlistigdata']/tbody/tr/td[3]/a[@data-toggle-tooltip='tooltip']/span[@class='text-overflow-dynamic-container']"
		 * ), "Subject name", 30);
		 */
	}

	public void selectTime() {
		click(By.xpath("//div[@class='timepicker']//table//tr[2]//td[1]//span"), "select time", 20);

		click(By.xpath(
				"//div[@class='timepicker']//table[@class='table-condensed']//tbody//tr[1]//td[@data-action='selectHour'][1]"),
				"select time", 20);
		click(By.xpath("//div[@class='timepicker']//table//tr[2]//td[3]//span"), "select time", 20);
	}

	public void enterFollowUpComment() {
		enter(By.xpath("//textarea[@id='FollowUpDescription']"), prop.getProperty("followUpDescription"), "Add follow up", 20);
	}

	public void saveFollowUp() {
		click(By.id("afollowUpNoteSave"), "Save button", 20);
	}

	public void followUpSuccessMessage() {
		verifySuccessMessage(By.id("notifymessage"), prop.getProperty("followUpValidation"), 30);
	}

	public void verifyDeleteFunctionality() {
		clickOnActionButton();
	}

	public void navigateToTicketListingPage() {
		staticWait(2000);
		pageNavigate(prop.getProperty("ticketListingPageUrl"), "Navigate to Ticket listing page");
		staticWait(2000);
		//driver.navigate().refresh();
		}

	public void clickDeleteButton() {
		click(By.cssSelector("#aIndexDelete"), "Delete button", 20);
	}

	public void clickOnDeletePopUp() {
		click(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), "ok button for deleting records.", 20);
	}

	public void deleteRecordMessage() {
		findElementVisibility(By.cssSelector("#notifymessage div"), 20);
		verifySuccessMessage(By.cssSelector("#notifymessage div"), prop.getProperty("deleteTicketMessage"), 30);
	}

	public void verifyCannedReplies() {
		toCheckElementIsDisplayed(By.xpath("//div[@class='conversation-box']"), 30, "Canned reply");
	}

	public void checkWidgets() {

		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[1]"), 30, "Unassigned Widget");
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[2]"), 30, "On Hold Widget");
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[3]"), 30, "Response due Widget");
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[4]"), 30, "Resolve due Widget");
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[5]"), 30, "Response over due Widget");
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMinWidgetDetailChild']/ul/li[6]"), 30, "Resolve over due Widget");
	}

	public void clickAssignedTo() {
		staticWait(3000);
		click(By.xpath("//div[@id='headingOneAssignTo']/h5/a[@data-toggle='collapse']"), "Assigned To", 20);
	}

	public void enterResolverName(String resolverName) {
		enter(By.xpath(
				"//span[@id='assignedToIdQS']//following::input[@class='form-control searchcustomfilter border-right-0'][1]"),
				resolverName, "resolver name in assigned to ", 30);
	}

	public void verifyStatusByResolver() {

		resolverNameFromDashboard = TicketingDashboardPage.resolverList;
		click(By.cssSelector("#headingOneTicketStatus h5 a.collapsed"), "ticket status", 20);
		int counter = 0;
		for (int i = 0; i < resolverNameFromDashboard.size(); i++) {
			resolverNameText = resolverNameFromDashboard.get(i);
			logger.info("Resolver name list ::" + resolverNameFromDashboard.get(i));
			enterResolverName(resolverNameFromDashboard.get(i));

			
			  clickByJavascript(By.xpath(
			  "//span[@id='assignedToIdQS']//following::input[@class='form-control searchcustomfilter border-right-0'][1]//following::input[@class='custom-control-input dynamic assignedIdcheck'][1]//following::label[contains(text(),'"
			  + resolverNameText + "')]"), "select user Name", 20);
			 
			counter++;
			if (counter == 2) {

				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed']"),
						"ticket status", 20);
				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed and Locked']"),
						"ticket status", 20);
				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed']"),
						"ticket status", 20);
				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed and Locked']"),
						"ticket status", 20);
				clickSearchIcon();
				verifyTodayStatusByResolver();
			} else {
				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed']"),
						"ticket status", 20);

				click(By.xpath(
						"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='Closed and Locked']"),
						"ticket status", 20);
				enterLastMonthOpenedDate();
				clickSearchIcon();
				verifyTodayStatusByResolver();
			}
		}
	}

	public void getEnteriesText() {
		staticWait(3000);
		try {
		WebElement showingValue = driver.findElement(By.xpath("//span[@class='ml-2']"));
		if (showingValue.isDisplayed()) {
			enteriesText = getText(By.xpath("//span[@class='ml-2']"), 30);
		}
		}catch (Exception e) {
			// TODO: handle exception
			enteriesText = getText(By.xpath("//table/tbody/tr/td[@class='text-danger text-center no-record']"), 30);
		} 
			
		
		//enteriesText = getText(By.xpath("//span[@class='ml-2']"), 30);
	}

	@SuppressWarnings("unlikely-arg-type")
	public void verifyTodayStatusByResolver() {
		staticWait(3000);
		resolverCountFromDashboard = TicketingDashboardPage.resolverNameListCopy;
		waitForElementInVisibility(By.id("divProgress"), 20);
		getEnteriesText();
		getTicketListingSize();
		for (int i = 0; i < resolverCountFromDashboard.size(); i++) {
			resolverCountText = resolverCountFromDashboard.get(i);
			logger.info("Resolver count from Dashboard :: " + resolverCountFromDashboard.get(i));

			if (enteriesText.equals("Showing 0 to 0 of 0 entries")) {
				getNoRecordsMessage();
				logger.info("List size is 0 shows no record found..");
				getTest().log(LogStatus.PASS, "List size is 0 shows no record found..");
			}else if(enteriesText.equals("No record(s) found")){
				getNoRecordsMessage();
				logger.info(" No record found..");
				getTest().log(LogStatus.PASS, " No record found..");
			}
			else if (resolverCountText.equals(listSize - 1)) {
				logger.info("List size is equal to the Solved count from Dashboard.");
				getTest().log(LogStatus.PASS, " List size is equal to the Solved count from Dashboard.");
			} else {
				getTest().log(LogStatus.FAIL, " List size is not matched");
				logger.debug("verifyTodayStatusByResolver is not matched");
				takeScreenshot("verifyTodayStatusByResolver is not matched");
				Assert.fail("verifyTodayStatusByResolver is not matched");
			}
		}
	}

	public void enterTodaysOpenedDate() {
		staticWait(3000);

		//clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 0);
		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateFromForTicketSearch']"),
				datevalue, "Opaened start Date", 30);

		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateToForTicketSearch']"),
				datevalue, "Opened end Date", 30);
	}

	public void getNoRecordsMessage() {
		staticWait(3000);
		ticketListText = getText(By.xpath(
				"//table[@id='tblticketlistigdata']//tbody//tr//td[@class='text-danger text-center no-record']"), 30);

	}

	public void getTicketListingSize() {
		ticketListing = findMultipleElement(By.xpath("//table[@id='tblticketlistigdata']//tbody//tr"), 30);
		for (int i = 0; i < ticketListing.size(); i++) {
			logger.info("size of ticket listing :: " + ticketListing.size());
			listSize = ticketListing.size();
		}
	}

	public void enterThisWeekOpenedDate() {

		clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 0);
		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateFromForTicketSearch']"),
				datevalue, "Opaened start Date", 30);

		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateToForTicketSearch']"),
				datevalue, "Opened end Date", 30);
	}

	// --------------------------Current month ---------------//
	public void getCurrentMonthStartEndDate() {
		try {
			Calendar currentCalendar = Calendar.getInstance();

			currentCalendar.set(Calendar.DAY_OF_MONTH, 1);

			Date currentMonthStart = currentCalendar.getTime();
			monthStartDate = formatter.format(currentMonthStart);
			System.out.println("Month Start Date: " + monthStartDate);

//				currentCalendar.add(Calendar.DATE, 1);
//				Date currentMonthEnd = currentCalendar.getTime();
//				monthEndDate = formatter.format(currentMonthEnd);

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
//			ticketdashboard.fromWeekDatea();
		enter(By.xpath("//input[@name='OpenFromDate']"), TicketingDashboardPage.weekStartDateFromPicker,
				"Week start Date from picker", 20);
		staticWait(2000);
	}

	public void enterWeekEndDateFromPicker() {
//			ticketdashboard.toWeekDate();
		enter(By.xpath("//input[@id='OpenToDate']"), TicketingDashboardPage.weekEndDateFromPicker,
				"Week End Date from picker", 20);
		staticWait(2000);
	}

	public void enterWeekStartDate() {
		getWeekStartEndDate();
		enter(By.xpath("//input[@name='OpenFromDate']"), weekStartDate, "Week start Date", 20);
		staticWait(2000);
	}

	public void enterStartDate() {
		getCurrentMonthStartEndDate();
		staticWait(2000);
		enter(By.xpath("//input[@name='OpenFromDate']"), monthStartDate, "start Date", 20);
		staticWait(4000);
	}

	public void enterStartEndDate() {
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
		staticWait(3000);
		getLastMonthStartEndDate();
		enter(By.xpath("//input[@name='OpenFromDate']"), lastMonthStartDate, "lastMonth Start Date", 20);
		staticWait(2000);
		enter(By.xpath("//input[@id='OpenToDate']"), lastMonthEndDate, "lastMonth end Date", 20);
		staticWait(4000);
	}

	public void enterLastMonthOpenedDate() {
		staticWait(3000);

		getLastMonthStartEndDate();
		clickByJavascript(By.xpath("//span[@id='dateFromQS']"), "opened date", 0);
		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateFromForTicketSearch']"),
				lastMonthStartDate, "Opaened start Date", 30);

		enter(By.xpath(
				"//div[@class='card-header' and @id='headingOneDateFrom']//following::input[@id='dateToForTicketSearch']"),
				lastMonthEndDate, "Opened end Date", 30);
	}

	public void verifyTicketValuesFromReport() {
		staticWait(3000);

		//String ticketNoText = getText(By.xpath("//table[@id='tblticketlistigdata']//tbody//tr[1]//td[1]"), 20);
		/*
		 * String ticketNoText = getText(By.xpath(
		 * "//table[@id='tblticketlistigdata']/tbody/descendant::td/span[@class='text-overflow-dynamic-container']"
		 * ), 20);
		 */
		String ticketNoText = getText(By.xpath("//table/tbody/tr/td[2]/span"), 20);
		ticketvalue = addTicketPage.ticketNoGenerated;

		if (ticketvalue.contains(ticketNoText)) {
			getTest().log(LogStatus.PASS, ticketvalue + " reference no. is matched as expected.");
		} else {
			getTest().log(LogStatus.FAIL, "reference no. is not matched as expected.");
			logger.debug("reference no. is not matched as expected.");
			takeScreenshot("verifyTicketNo");
			Assert.fail("verifyTicketNo");
		}
	}

	// Creating a custom function
	public void mouseHover() {

		//hover((By.xpath("//table[@id='tblticketlistigdata']//tbody//tr/td[5]//span[1]")), "hover on SLA time", 20);
		//hover((By.xpath("//table/descendant::span[@class='d-block text-overflow-dynamic-container']")), "hover on SLA time", 20);
		hover((By.xpath("//div/span[@class='text-danger font-weight-bold']")), "hover on SLA time", 20);

		
		  String toolTipText =
		  getAtribute(By.xpath("//div/span[@class='text-danger font-weight-bold']"),
		  "data-original-title", 20);
		 
		
		//String toolTipText = driver.findElement(By.xpath("//div/span[contains(text(),'"+CompanySetupPage.departmentname+"')]")).getText();

		// To get the tool tip text and assert
		logger.debug("toolTipText-->" + toolTipText);
		String createdSlaName = AddSLAPage.policyName;
		//String createdSlaName = AddSLAPage.departmentName;
		if (toolTipText.contains(createdSlaName)) {
			getTest().log(LogStatus.PASS, createdSlaName + " slaTooltip is matched as expected.");
			logger.debug("slaTooltip is not matched as expected.");

		} else {
			getTest().log(LogStatus.FAIL, "createdSlaName is not matched as expected.");
			logger.debug("createdSlaName is not matched as expected.");
			takeScreenshot("mouseHover");
			Assert.fail("mouseHover");
		}
	}
	public void verifyslatooltip() {
		
		try {
			 WebElement toolTipText = driver.findElement(By.xpath("//div/span[contains(text(),'"+CompanySetupPage.departmentname+"')]"));
			if (toolTipText.isDisplayed()) {
				logger.info("Ticket with SLA created successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Ticket with SLA not created successfully");
		}
	}

	public void clickChannel() {
		//clickByJavascript(By.cssSelector("#headingOneTicket_Channel"), "Channel", 0);
		click(By.xpath("(//div/label[contains(text(),'Channel')]/ancestor::div[@class='col-lg-4']/descendant::button[@type='button'])[1]"), "channel", 30);
	}

	public void selectNoChannel() {
		clickByJavascript(By.xpath(
				"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='No Channel']"),
				"No Channel", 0);
	}

	public void clickProduct() {
		staticWait(2000);
		clickByJavascript(By.cssSelector("#headingOneProduct"), "Product", 50);
	}

	public void selectNoProduct() {
		clickByJavascript(By.xpath(
				"//div[@class='custom-control custom-checkbox custom-control-inline w-100']//following::label[text()='No Product']"),
				"No Product", 0);
	}
	public void clickTicketNumberSearchField() {
		staticWait(3000);
		click(By.xpath("//div/h5/a/span[contains(text(),'Ticket Number')]"), "Ticket Number Search Field", 50);
	}
	public void enterTicketNumberIntoSearchField() {
		staticWait(2000);
		
		enter(By.xpath("//div/input[@placeholder='Search by Ticket Number']"), addTicketPage.ticketNoGenerated, "Ticket Number", 50);
	}
	public void clickOnSearchButton() {
		staticWait(2000);
		click(By.xpath("//span/span[@data-original-title='Search']"), "Search Button", 50);
	}
	public void clickOnCombineTicket() {
		staticWait(2000);
		click(By.xpath("//input[@placeholder='Select Ticket']"), "Combine Ticket Text Field", 50);
		
		enter(By.xpath("//input[@placeholder='Select Ticket']"), "1", "Combine Ticket", 50);
		staticWait(2000);
		click(By.xpath("//ul[@id='select2-ddlMergeTicketIds-results']/li"), "Combine Ticket Dropdown", 50);
		staticWait(3000);
		click(By.xpath("//input[@class='select2-search__field valid']"), "Combine Ticket Text Field", 50);
		enter(By.xpath("//input[@class='select2-search__field valid']"), "1", "Combine Ticket", 50);
		staticWait(2000);
		click(By.xpath("//ul[@id='select2-ddlMergeTicketIds-results']/li[2]"), "Combine Ticket Dropdown", 50);
	}
	public void clickOnSelectPrimaryTicket() {
		staticWait(2000);
		click(By.xpath("//select[@id='PrimaryTicketId']"), "Primary Ticket Dropdown", 50);
		selectValueWithIndex(By.xpath("//select[@id='PrimaryTicketId']"), 2, "Primary Ticket", 50);
	}
	public void enterReason() {
		staticWait(2000);
		
		enter(By.xpath("//div/tg-textarea/textarea[@id='MergeReason']"), prop.getProperty("mergingreason"), "Reason", 50);
	}
	public void clickOnSubmitButton() {
		staticWait(2000);
		click(By.xpath("//div/a[text()='Submit']"), "SUbmit Button", 50);
		logger.info("Ticket has been successfully merged");
	}
}
