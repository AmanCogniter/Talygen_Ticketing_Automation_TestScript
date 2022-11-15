package action;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pageobjects.ExternalLinkPage;
import utils.PropertiesLoader;

public class ExternalLinkAction {
	WebDriver driver;

	ExternalLinkPage externalLinkPage;

	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";

	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ExternalLinkAction(WebDriver driver) {
		this.externalLinkPage = new ExternalLinkPage(driver);
		this.driver = driver;
	}

	public void navigateToExternalLink() {
		externalLinkPage.clickFullMenu();
		externalLinkPage.clickTicketingSideMenu();
		//externalLinkPage.clickTicketingOption();
		externalLinkPage.clickOnTicketLayoutSetting();
		externalLinkPage.clickExternalLink();
	}

	public void verifyManageLayoutUrl() {
		externalLinkPage.validateManageLayout();
	}

	public void resetButton() {
		externalLinkPage.clickResetButton();
}
	public void clickonOk() {
		externalLinkPage.clickOnConfirmMessgaepopup();
	}
	
	public void clickSaveButton() {
		externalLinkPage.clickSaveButton();
}
	
	public void checkValidationMessage() {
	externalLinkPage.verifyValidationMessage();
	}
	
	public void verifyCharactersLength() {
		externalLinkPage.enterWelcomeText();
		externalLinkPage.checkWelcomeTextCharactersLength();
	}
	
	public void enterHeaderFrameText() {

//	externalLinkPage.enterHeaderDescription();
		externalLinkPage.switchToFrame();
	}
	
	public void saveButton() {
		externalLinkPage.clickSaveButton();
		externalLinkPage.verifyLayoutSuccessMessage();
	}
	
	public void externalLink() {

		externalLinkPage.enterExternalLayoutLink();
		externalLinkPage.getExternaLink();
		externalLinkPage.switchToTab();
	}
	
	public void colorPicker() {
		externalLinkPage.clickColorPicker();
		externalLinkPage.pickColor();
		externalLinkPage.verifyBgHexColorValue();
		externalLinkPage.clickFontColorPicker();
		externalLinkPage.fontColor();
		externalLinkPage.verifyFontHexColorValue();
	
	}
	
}