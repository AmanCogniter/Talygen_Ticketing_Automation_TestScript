package pageobjects;

import static reporting.ComplexReportFactory.getTest;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class UpdateTicketPage extends WebBasePage {

	WebDriver driver;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public UpdateTicketPage(WebDriver driver) {
		super(driver, "Update Ticket Page");
		this.driver = driver;
	}

	public void verifyClaimModelPopup() {
		toCheckElementIsDisplayed(By.cssSelector("#divAddClaim"), 20,
				" claim modal pop-up is showing after clicking on claim button ");
	}

	public void claimButton() {
		click(By.cssSelector("a.p-action-btn.text-white.claim"), " claim button ", 20);
	}

	public void checkSplitButton() {

		toCheckElementIsDisplayed(By.id("_aSplit"), 20, " split button ");
	}

	public void validateUrlOfUpdateTicketPage() {
		findElementVisibility(
				By.xpath("//div[@class='theme-primary partition p-actions-expand']//a[@data-original-title='Update']"),
				20);

		getCurrentUrl(prop.getProperty("updatePageUrl"), "On clicking view button update Page ");
	}

	public void clickMergeButton() {
		click(By.cssSelector("a.p-action-btn.text-white.merge"), "Merge button", 20);
	}

	public void checkDetailsOnClickinMerge() {
		toCheckElementIsDisplayed(By.xpath("//div[@id='divMerge']"), 20, "merge pop-up ");
	}

	public void clickOnUpdateTicket() {
		click(By.id("abtnChangeTicketStatus"), "Update button", 20);
	}

	public void clickOnDatePicker() {
		waitForVisibilityOfElement(By.xpath("//input[@class='form-control date hasdatetimepicker']//following::div[@data-original-title='Select Date']"), 50);
		click(By.xpath("//input[@class='form-control date hasdatetimepicker']//following::div[@data-original-title='Select Date']"),
				"Date picker", 20);
//		click(By.cssSelector("td.day.active.today.weekend"), "date", 20);
	}

	public void clickUpdateTicket() {
		click(By.xpath("//div[@class='theme-primary partition p-actions-expand']//a[@data-original-title='Update']"),
				"update ticket", 20);
	}

	public void verifySuccessMessage() {
		String updateSuccessMsg;
		try {
			findElementsVisibility(
					By.xpath("//div[@class='alert alert-dismissible fade show msg mw-90 alert-success']"));
			updateSuccessMsg = getText(
					By.xpath("//div[@class='alert alert-dismissible fade show msg mw-90 alert-success']"), 20);
			logger.debug("Update ticket message :: " + updateSuccessMsg);
			if (updateSuccessMsg.equals(prop.getProperty("updateTicketSuccessMsg"))) {
				getTest().log(LogStatus.PASS, updateSuccessMsg + " is successfully displayed");
			} else {
				getTest().log(LogStatus.FAIL, "Validation message is not successfully displayed");
				logger.debug("validation message is not displayed");
				takeScreenshot("UpdateTicket");
				Assert.fail("UpdateTicket");
				updateSuccessMsg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddNotes() {
		click(By.xpath("//a[@class='p-action-btn text-white addnotes']"), "Add Notes", 20);
	}

	public void switchToFrame() {
		try {
			WebElement iframe = driver.findElement(By.tagName("iframe"));
			driver.switchTo().frame(iframe);
			WebElement body = driver.findElement(By.tagName("body"));
		} catch (Exception e) {
			// TODO: handle exception
			takeScreenshot("switchToFrame");
		}
	}

	public void enterNotesDescription() {
		try {
			enter(By.tagName("body"), prop.getProperty("notesDescription"), "Add Notes Description", 35);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			// TODO: handle exception
			takeScreenshot("enterNotesDescription");
		}
	}

	public void clickOnSubmitNote() {
		click(By.cssSelector("#aTicketNoteSave"), "submit", 20);
	}

	public void verifyNotesSuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("ticketNoteValidation"), 30);
	}

	public void clickOnNotes() {
		waitForElementInVisibility(By.cssSelector("#notifymessage"), 30);
		click(By.xpath("//li//a[@id='tab-notes']"), "Notes from left panel", 30);
	}

	public void clickOnEditNote() {
		click(By.xpath("//a[@class='round-icon-small btn-success-light updateNote']"), "Edit note", 30);
	}

	public void enterEditNotesDescription() {

		enter(By.tagName("body"), prop.getProperty("notesEditDescription"), "Edited Notes Description", 35);
		driver.switchTo().defaultContent();
	}

	public void verifyEditNoteValidation() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("editNoteValidation"), 30);
	}

	public void clickDeleteNote() {
		staticWait(3000);
		click(By.xpath("//a[@class='round-icon-small btn-danger-light deleteNote']"), "delete Note", 30);
	}

	public void clickOkBtn() {
		click(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), "Ok Button", 30);
	}

	public void verifyDeleteNoteValidation() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("deleteTicketValidation"), 30);
	}

	public void clickOnAttachmentTab() {
		click(By.id("tab-attachment"), "Attachment", 30);
	}

	public void enterClaimAmount() {

		enter(By.cssSelector("#ClaimValue"), prop.getProperty("claimAmount"), "Enter claim amount", 35);
	}

	public void enterClaimDescription() {
		switchToFrame();
		enter(By.tagName("body"), prop.getProperty("enterClaimDescription"), "enter Claim Description", 35);
		driver.switchTo().defaultContent();
	}

	public void clickOnSaveButton() {
		click(By.id("aTicketClaimSave"), "save button", 30);
	}

	public void clickOkClaimPopUp() {
		click(By.cssSelector("button.btn.btn-success.formbtn.widthhalf"), "ok button from claim pop-up", 30);
	}

	public void verifyClaimSuccessMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("claimValidation"), 30);
	}

	public void clickOnReplyButton() {
		click(By.cssSelector("a.p-action-btn.text-white.reply"), "reply button", 30);
	}

	public void selectCannedReply() {
		click(By.xpath("//select[@id='ddlReplyTemplate']"), "select canned reply dropdown", 30);
		click(By.xpath("//select[@id='ddlReplyTemplate']//option[@value][2]"), "select canned reply", 30);
	}

	public void submitCannedReply() {
		click(By.cssSelector("#aTicketReplySave"), "Submit canned reply button", 30);
	}

	public void verifyCannedReply() {
		toCheckElementIsDisplayed(By.xpath("//div[@class='card-body']"), 30, "Canned existing replies");
	}

	public void selectTicketStatus() {
		waitForVisibilityOfElement(By.xpath("//select[@class='form-control ' and @id='StatusId']"), 50);
		click(By.xpath("//select[@class='form-control ' and @id='StatusId']"),
				"select ticket status from dropdown", 30);

		List<WebElement> options = driver.findElements(By.xpath("//select[@class='form-control ' and @id='StatusId']/option"));
		for (WebElement option : options) {
			if (option.getText().equals("Closed")) {
				option.click(); // click the desired option
				break;
			}
		}

//		click(By.xpath("//select[@class='form-control']//option[@value][5]"), "select reopen from tikcet status", 30);
	}

	public void editTicketCategory() {
		click(By.xpath("//div[@class='input-group-append CategoryEdit']//span"), "ticket category edit", 30);
		click(By.xpath("//select[@id='ddlActiveTicketCategoryId']"), "Select ticket category", 30);
	}

	public void selectTicketProduct() {
		click(By.xpath("//select[@id='ProductId']//option[2]"), "select product", 30);
	}

	public void selectTicketPriority() {
		click(By.xpath("//select[@id='priorityId']//option[1]"), "select priority", 30);
	}

	public void deleteDraft() {
		staticWait(4000);
		click(By.xpath("//a[@class='DeleteDraftedReply btn-danger round-icon']"), "Delete draft", 30);
	}

	public void saveDraft() {
		click(By.cssSelector("#aTicketReplySaveDraft"), "Save As draft", 30);
	}

	public void verifyReplyDraftMessage() {
		verifySuccessMessage(By.cssSelector("#notifymessage"), prop.getProperty("replyDraftValidation"), 30);
	}

}
