package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.AddTicketAction;
import action.CompanySetupAction;
import action.LoginAction;
import action.TicketListingAction;
import action.TicketDetailReportAction;
import action.TicketingDashboardAction;
import utils.WebTestBase;

public class TicketingDashboardTest extends WebTestBase {

	@Test(priority = 0)
	public void verifyReportsValidation() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.addReport();
		ticketingDashboardAction.validateReportsValidation();
	}

	@Test(priority = 1)
	public void validateWidgetsCount() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.addReport();
		ticketingDashboardAction.verifyWidgetsCount();
	}

//	@Test(priority = 2)
//	public void verifyTicketStatus( ) {
//		test = getTest("TC_Ticketing_Dashboard");
//		new LoginAction(driver).logoutLogin();
//		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
//		ticketingDashboardAction.navigateToTicketingDashboard();
//		ticketingDashboardAction.thisYearByStatus();
//		new LoginAction(driver).logoutLogin();
//		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
//		ticketSummaryReportAction.navigateToTicketingReport();
//		ticketSummaryReportAction.verifyStatusWidgetCount();
//	}

//	@Test(priority = 2)
//	public void addTicketToCheckStatus() {
//		test = getTest("TC_Ticketing_Dashboard");
//		new LoginAction(driver).logoutLogin();
//		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
//		companySetupAction.navigateToCompanySetupUser();
//		companySetupAction.addUser();
//		companySetupAction.addDepartmentNotVisibleClient();
//		new LoginAction(driver).logoutLogin();
//		AddTicketAction addTicket = new AddTicketAction(driver);
//		addTicket.navigatetoAddTicket();
//		addTicket.addTicket();
//	}
//
//	// ------------------Status widgets ----------------

	@Test(priority = 3)
	public void verifyTodaysFilter() {
		test = getTest("TC_Ticketing_Dashboard_verifyTodaysFilter");

		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.addTicket();

		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.todaysFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.statusWidgetValues();
		ticketSummaryReportAction.searchButton();
	}

	@Test(priority = 4)
	public void verifyThisYearFilter() {
		test = getTest("TC_Ticketing_Dashboard_verifyThisYearFilter");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisYearFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.statusWidgetValues();
		ticketSummaryReportAction.searchButton();
	}

	@Test(priority = 5)
	public void verifyYesterDayFilter() {
		test = getTest("TC_Ticketing_Dashboard_verifyYesterDayFilter");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.yesterdayFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.statusWidgetValues();
	}

	@Test(priority = 6)
	public void verifyLastWeekFilter() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastWeekFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.statusWidgetValues();
	}

	@Test(priority = 7)
	public void verifyThisWeekFilter() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.statusWidgetValues();
	}

	@Test(priority = 8)
	public void verifyThisMonthFilter() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisMonthFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketDetailReportAction = new TicketDetailReportAction(driver);
		ticketDetailReportAction.navigateToTicketingReport();
		ticketDetailReportAction.statusWidgetValues();
	}

	@Test(priority = 9)
	public void verifyLastMonthFilter() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastMonthFilter();
		ticketingDashboardAction.verifyStatusWidgetCount();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketDetailReportAction = new TicketDetailReportAction(driver);
		ticketDetailReportAction.navigateToTicketingReport();
		ticketDetailReportAction.statusWidgetValues();

	}

//---------------------------Ticket by category filter Testcases -------------------------------------------------//

	@Test(priority = 10)
	public void verifyTodayFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.addTicket();
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.todaysFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 11)
	public void verifyThisWeekFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 12, enabled = false)
	public void verifyThisYearFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");

		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisYearFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 13, enabled = false)
	public void verifyLastWeekFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.addTicket();
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 14)
	public void verifyYesterdayFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.yesterdayFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 15, enabled = true)
	public void verifyThisMonthFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisMonthFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	@Test(priority = 16)
	public void verifyLastMonthFilterFromCategory() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastMonthFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyCategoryWidgetCount();
	}

	// ------------------------------By Channel----------------------------------//
	
	  @Test(priority = 17) 
	  public void verifyYesterdayFilterByChannel() { 
		  test = getTest("TC_Ticketing_Dashboard");
	  
	  new LoginAction(driver).logoutLogin();
	  CompanySetupAction companySetupAction = new CompanySetupAction(driver);
	  companySetupAction.navigateToCompanySetupUser();
	  companySetupAction.addUser();
	  companySetupAction.addDepartmentNotVisibleClient(); 
	  new LoginAction(driver).logoutLogin(); 
	  companySetupAction.addChannelTab();
	  new LoginAction(driver).logoutLogin();
	  AddTicketAction addTicket = new AddTicketAction(driver); 
	  addTicket.navigatetoAddTicket();
	  addTicket.addTicketWithChannel();
	  
	  new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 

	  }
	  
	  @Test(priority = 18,enabled=true) 
	  public void verifyTodaysFilterByChannel() {
	  test = getTest("TC_Ticketing_Dashboard"); 
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver); companySetupAction.addChannelTab();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient(); new
		 * LoginAction(driver).logoutLogin(); AddTicketAction addTicket = new
		 * AddTicketAction(driver); addTicket.navigatetoAddTicket();
		 * addTicket.addTicketWithChannel();
		 */
	 
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 
	  
	  }
	  
	  @Test(priority = 19)
	  public void verifyThisWeekByChannel() { 
	 test = getTest("TC_Ticketing_Dashboard");
	  
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver);
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient(); new
		 * LoginAction(driver).logoutLogin(); companySetupAction.addChannelTab(); new
		 * LoginAction(driver).logoutLogin(); AddTicketAction addTicket = new
		 * AddTicketAction(driver); addTicket.navigatetoAddTicket();
		 * addTicket.addTicketWithChannel();
		 */
	  

		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 
	  }
	  
	  @Test(priority = 20) 
	  public void verifyLastWeekByChannel() { 
      test = getTest("TC_Ticketing_Dashboard");
	  
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver); companySetupAction.addChannelTab();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient(); new
		 * LoginAction(driver).logoutLogin(); AddTicketAction addTicket = new
		 * AddTicketAction(driver); addTicket.navigatetoAddTicket();
		 * addTicket.addTicketWithChannel();
		 */
	  
      
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 
	  }
	  
	  @Test(priority = 21) 
	  public void verifyThisMonthByChannel() {
	   test = getTest("TC_Ticketing_Dashboard"); 
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver); companySetupAction.addChannelTab(); new
		 * LoginAction(driver).logoutLogin();
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser(); //
		 * companySetupAction.addDepartmentNotVisibleClient(); new
		 * LoginAction(driver).logoutLogin(); AddTicketAction addTicket = new
		 * AddTicketAction(driver); addTicket.navigatetoAddTicket();
		 * addTicket.addTicketWithChannel();
		 */
	   
	   
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 
	  }
	  
	  @Test(priority = 22)
	  public void verifyLastMonthByChannel() { 
	 test = getTest("TC_Ticketing_Dashboard");
		/*
		 * new LoginAction(driver).logoutLogin(); CompanySetupAction companySetupAction
		 * = new CompanySetupAction(driver); companySetupAction.addChannelTab();
		 * 
		 * companySetupAction.navigateToCompanySetupUser();
		 * companySetupAction.addUser();
		 * companySetupAction.addDepartmentNotVisibleClient(); new
		 * LoginAction(driver).logoutLogin(); AddTicketAction addTicket = new
		 * AddTicketAction(driver); addTicket.navigatetoAddTicket();
		 * addTicket.addTicketWithChannel();
		 */

		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.verifyTicketCategoryStatus();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
	  ticketSummaryReportAction.verifyChannelWidgetValue(); 
	  }
	 

	// --------------------- Tickets By Product--------------------//
	@Test(priority = 23)
	public void verifyTodaysFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
		companySetupAction.navigateToCompanySetupUser();
		companySetupAction.addUser();
		companySetupAction.addDepartmentNotVisibleClient();
		new LoginAction(driver).logoutLogin();
		AddTicketAction addTicket = new AddTicketAction(driver);
		addTicket.navigatetoAddTicket();
		addTicket.addTicket();
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.todaysFilter();
		ticketingDashboardAction.productWidgetValues();

		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();

	}

	@Test(priority = 24)
	public void verifyThisWeekFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisWeekFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	@Test(priority = 25, enabled = false)
	public void verifyThisYearFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisYearFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	@Test(priority = 26, enabled = false)
	public void verifyThisMonthFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.thisMonthFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	@Test(priority = 27)
	public void verifyYesterdayFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.yesterdayFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	@Test(priority = 28, enabled = true)
	public void verifyLastWeekFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastWeekFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	@Test(priority = 29)
	public void verifyLastMonthFilterByProduct() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		ticketingDashboardAction.selectMainFilter();
		ticketingDashboardAction.lastMonthFilter();
		ticketingDashboardAction.productWidgetValues();
		new LoginAction(driver).logoutLogin();
		TicketDetailReportAction ticketSummaryReportAction = new TicketDetailReportAction(driver);
		ticketSummaryReportAction.navigateToTicketingReport();
		ticketSummaryReportAction.verifyProductWidgetValues();
	}

	// -------------------Status by resolver-------------------------------//

	 @Test(priority = 30)
	public void verifyTodayFilterByResolver() {
		test = getTest("TC_Ticketing_Dashboard");
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
		//ticketingDashboardAction.statusByResolverMainFilter();
		ticketingDashboardAction.verifyStatusByResolverWidget();
		//new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigateToTicketListingPage();
		ticketListingAction.validateSolvedCount();
	}

	@Test(priority = 31)
	public void verifyThisWeekFilterByResolver() {
		test = getTest("TC_Ticketing_Dashboard");
//		new LoginAction(driver).logoutLogin();
//		CompanySetupAction companySetupAction = new CompanySetupAction(driver);
//		companySetupAction.navigateToCompanySetupUser();
//		companySetupAction.addUser();
//		companySetupAction.addDepartmentNotVisibleClient();
//		new LoginAction(driver).logoutLogin();
//		AddTicketAction addTicket = new AddTicketAction(driver);
//		addTicket.navigatetoAddTicket();
//		addTicket.addTicket();
		new LoginAction(driver).logoutLogin();
		TicketingDashboardAction ticketingDashboardAction = new TicketingDashboardAction(driver);
		ticketingDashboardAction.navigateToTicketingDashboard();
//		ticketingDashboardAction.statusByResolverMainFilter();
		ticketingDashboardAction.verifyStatusByResolverWidget();
		//new LoginAction(driver).logoutLogin();
		TicketListingAction ticketListingAction = new TicketListingAction(driver);
		ticketListingAction.navigateToTicketListingPage();
		//ticketListingAction.validateSolvedCount();
		ticketListingAction.validateLastMonthResolverSolvedCount();
	}
}
