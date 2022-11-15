package utils;

import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Drivers {

	public WebDriver driver;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public WebDriver getWebDriver(String browser) throws MalformedURLException {

		if (browser.equals("firefox")) {

			String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
			String firefoxDownloadDir = System.getProperty("user.dir") + "\\geckodriver.exe";
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2); // Use for the default download directory the last
																		// folder specified for a download
			profile.setPreference("browser.download.dir", downloadFilepath); // Set the last directory used for saving a
																				// file from the "What should (browser)
																				// do with this file?" dialog.
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip");
			// list // of
			// MIME
			// types
			// to
			// save
			// to
			// disk
			// without
			// asking
			// what
			// to
			// use
			// to
			// open
			// the
			// file

			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip");
			options.setProfile(profile);
			System.setProperty("webdriver.gecko.driver", firefoxDownloadDir);

			driver = new FirefoxDriver(options);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		} else if (browser.equals("chrome")) {

//          String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";

			String chromeDriverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath); // "[folder]\\chromedriver.exe"

			/*
			 * HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			 * chromePrefs.put("profile.default_content_settings.popups", 0);
			 * chromePrefs.put("download.default_directory", downloadFilepath);
			 * chromePrefs.put("download.prompt_for_download", false);
			 * chromePrefs.put("profile.default_content_setting_values.automatic_downloads",
			 * 1);
			 * 
			 * 
			 * ChromeOptions options = new ChromeOptions();
			 * options.setExperimentalOption("prefs", chromePrefs);
			 * options.addArguments("--disable-extensions");
			 */
			if (Boolean.parseBoolean(prop.getProperty("isHeadlessMode"))) {
				ChromeOptions option = new ChromeOptions();
				option.addArguments("headless");
				option.setHeadless(true);
				option.addArguments("window-size=1920x1000");
				driver = new ChromeDriver(option);
				System.out.println("Browser is opened in Headless mode.");
			} else {
				System.out.println("Browser is opened in Browser mode.");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			}
		}
		return driver;
	}

}
