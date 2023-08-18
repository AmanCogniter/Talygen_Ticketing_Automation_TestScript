package action;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.TicketListingPage;
import pageobjects.UpdateTicketPage;
import utils.PropertiesLoader;

public class UpdateTicketAction extends UpdateTicketPage {

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	WebDriver driver;
	AddTicketAction addTicketAction;
	TicketListingPage ticketListingPage;
	UpdateTicketPage updateTicketPage;

	public UpdateTicketAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.addTicketAction = new AddTicketAction(driver);
		this.ticketListingPage = new TicketListingPage(driver);
		this.updateTicketPage = new UpdateTicketPage(driver);
	}

	public void checkfunctionalityOfClaimButton() {
		claimButton();
		verifyClaimModelPopup();
		enterClaimAmount();
		enterClaimDescription();
		clickOnSaveButton();
		clickOkClaimPopUp();
		verifyClaimSuccessMessage();

	}

	public void verifyMergeButtonFunctionality() {
		validateUrlOfUpdateTicketPage();
		clickMergeButton();
		checkDetailsOnClickinMerge();
		ticketListingPage.clickOnCombineTicket();
		ticketListingPage.clickOnSelectPrimaryTicket();
		ticketListingPage.enterReason();
		ticketListingPage.clickOnSubmitButton();

	}

	public void updateTicket() {
		ticketListingPage.ticketNumber();
		ticketListingPage.enterGeneratedTicketNumber();
		ticketListingPage.clickSearchIcon();
		clickOnListView();
		ticketListingPage.clickOnTicketSubject();
		clickUpdateTicket();
		clickOnDatePicker();
		selectTicketStatus();
//		editTicketCategory();
		selectTicketProduct();
		selectTicketPriority();
		clickOnUpdateTicket();
		verifySuccessMessage();
	}

	public void verifyAddNotesFunctionality() {
		clickOnAddNotes();
		switchToFrame();
		enterNotesDescription();
		clickOnSubmitNote();
		verifyNotesSuccessMessage();
	}

	public void verifyEditNotesFunctionality() {

		clickOnNotes();
		clickOnEditNote();
//		enterEditNotesDescription();
		clickOnSubmitNote();
		verifyEditNoteValidation();
	}

	public void verifyDeleteNotesFunctionality() {

		clickOnNotes();
		clickDeleteNote();
		clickOkBtn();
		verifyDeleteNoteValidation();
	}

	public void verifyCannedReplies() {
		clickOnReplyButton();
		selectCannedReply();
		submitCannedReply();
		verifyCannedReply();
	}

	public void verifyTicketReplyDraftedFunctionality() {
//		ticketListingPage.clickOnTicketSubject();
		clickOnReplyButton();
		selectCannedReply();
		saveDraft();
		verifyReplyDraftMessage();
		deleteDraft();
		clickOkBtn();
	}

}
