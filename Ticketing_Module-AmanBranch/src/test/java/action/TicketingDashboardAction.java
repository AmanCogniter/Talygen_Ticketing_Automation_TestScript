package action;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketingDashboardPage;
import utils.PropertiesLoader;

public class TicketingDashboardAction {

	WebDriver driver;

	TicketingDashboardPage ticketingDashboardPage;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public TicketingDashboardAction(WebDriver driver) {
		this.ticketingDashboardPage = new TicketingDashboardPage(driver);
		this.driver = driver;
	}

	public void navigateToTicketingDashboard() {
		ticketingDashboardPage.clickFullMenu();
		ticketingDashboardPage.clickOnFSMLocate();
		//ticketingDashboardPage.clickTicketingSideMenu();
//		ticketingDashboardPage.clickTicketingOption();
		ticketingDashboardPage.clickTicketingDashboard();
	}

	public void addReport() {
		ticketingDashboardPage.clickAddReport();
		ticketingDashboardPage.loaderInvisibility();
	}

	public void validateReportsValidation() {
		allCheckboxSelection();
		ticketingDashboardPage.selectAllReports();
		ticketingDashboardPage.selectSevenReports();
		//ticketingDashboardPage.verifyReportsValidation();
	}

	public void allCheckboxSelection() {
		ticketingDashboardPage.selectAllReportsCheckboxes();
	}

	public void verifyWidgetsCount() {
		ticketingDashboardPage.verifyWidgetsCount();
	}

	// ------------- Tickets by Status widgets-----------//

	public void selectMainFilter() {
		ticketingDashboardPage.mainWidgetFilter();
	}

	public void thisYearFilter() {
		ticketingDashboardPage.selectThisYear();
//		ticketingDashboardPage.getTicketStatusCount();
	}

	public void todaysFilter() {
		ticketingDashboardPage.selectToday();
//		ticketingDashboardPage.getTicketStatusCount();
	}

	public void channelWidgetStatusCount() {
		ticketingDashboardPage.getTicketChannelCount();
		ticketingDashboardPage.getTicketStatusCount();
	}

	public void thisWeekFilter() {
		ticketingDashboardPage.selectThisWeek();
//		ticketingDashboardPage.getTicketStatusCount();

	}

	public void lastWeekFilter() {
		ticketingDashboardPage.selectLastWeek();
//		ticketingDashboardPage.getTicketStatusCount();
	}

	public void yesterdayFilter() {
		ticketingDashboardPage.selectYesterdayFilter();
//		ticketingDashboardPage.getTicketStatusCount();
	}

	public void thisMonthFilter() {
		ticketingDashboardPage.selectThisMonth();
//		ticketingDashboardPage.getTicketStatusCount();
	}

	public void lastMonthFilter() {
		ticketingDashboardPage.selectLastMonth();
	}

	public void verifyStatusWidgetCount() {
		ticketingDashboardPage.getTicketStatusCount();
	}

	// --------------------------------Ticket by category------------//

	public void verifyTicketCategoryStatus() {
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void verifyTodayTicketCategoryFilter() {
		ticketingDashboardPage.selectToday();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void thisWeekFromTicketCategoryFilter() {
		ticketingDashboardPage.selectThisWeek();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void lastWeekFromTicketCategoryFilter() {
		ticketingDashboardPage.selectLastWeek();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void thisYearFromTicketCategoryFilter() {
		ticketingDashboardPage.selectThisYear();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void thisMonthFromTicketCategoryFilter() {
		ticketingDashboardPage.selectThisMonth();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void YesterdayFromTicketCategoryFilter() {
		ticketingDashboardPage.selectYesterdayFilter();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	public void lastMonthFromTicketCategoryFilter() {
		ticketingDashboardPage.selectLastMonth();
		ticketingDashboardPage.getTicketCategoryStatusCount();
	}

	// product filter

//	public void thisWeekProductFilter() {
//		ticketingDashboardPage.ticketsByProductThisWeekFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//
//	}
//
//	public void productMainFilter() {
//		ticketingDashboardPage.ticketsByProductMainFilter();
//	}
//
//	public void todayProductFilter() {
//		ticketingDashboardPage.ticketsByProductTodayFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//	}
//
//	public void thisYearProductFilter() {
//		ticketingDashboardPage.ticketsByProductThisYearFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//	}
//
//	public void thisMonthProductFilter() {
//		ticketingDashboardPage.ticketsByProductThisMonthFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//	}
//
//	public void yesterdayProductFilter() {
//		ticketingDashboardPage.selectYesterdayFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//	}
//
//	public void lastWeekProductaaaaaaFilter() {
//		ticketingDashboardPage.ticketsByProductLastWeekFilter();
//		ticketingDashboardPage.getTicketProductStatusCount();
//	}

	public void productWidgetValues() {
		ticketingDashboardPage.getTicketProductStatusCount();
	}

//	public void statusByResolverMainFilter() {
//		ticketingDashboardPage.resolverMainFilter();
//	}

	public void verifyStatusByResolverWidget() {
		ticketingDashboardPage.selectToday();
		ticketingDashboardPage.solvedTicketCountByResolver();
	}

	public void verifyLastMonthStatusByResolverWidget() {
		ticketingDashboardPage.selectLastMonth();
		ticketingDashboardPage.solvedTicketCountByResolver();
	}

	public void closeCurrentWindow() {
		ticketingDashboardPage.closeBrowserWindow();
	}

}