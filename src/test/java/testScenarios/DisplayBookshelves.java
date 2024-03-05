package testScenarios;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testObjectRepository.HomePageBookShelves;
import testObjectRepository.HomePageByAtHome;
import testObjectRepository.HomePageGiftCards;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ExcelWrite;
import userDefinedLibraries.ExplicitWait;
import userDefinedLibraries.ExtentReportManager;
import userDefinedLibraries.PropertiesRead;
import userDefinedLibraries.ScreenShot;

public class DisplayBookshelves extends DriverSetup {

	public static WebDriver driver;
	public static Actions action;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet = null;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static String[] bookShelves;
	public static String[] prices;
	public static String validationMessage;
	public static String browser;
	public static String baseUrl;
	public static String path;

	@BeforeGroups("Smoke Test one")
	public static void driverConfig() {

		browser = PropertiesRead.getBrowser();
		baseUrl = PropertiesRead.getUrl();
		report = ExtentReportManager.getReportInstance();
		driver = DriverSetup.openDriver(browser, baseUrl);

	}

	@Test(priority = 1, groups = { "Smoke Test one" })
	public static void clickOnBookShelvesMenu() {

		logger = report.createTest("Display Bookshlves under Rs.15000");
		logger.log(Status.INFO, "Display the name & price of first 3 Bookshelves below Rs. 15000, with Storage type as open & exclude out of stock");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		HomePageBookShelves.bookShelves(driver).click();
		try {

			HomePageBookShelves.checkSignUp(driver).click();

		} catch (Exception e) {

			e.printStackTrace();

		}

		action = new Actions(driver);
		action.moveToElement(HomePageBookShelves.priceFilter(driver)).perform();
		ExplicitWait.priceFilterVisibility(driver);
		action.moveToElement(HomePageBookShelves.dragAndDropOfPrice(driver))
				.dragAndDropBy(HomePageBookShelves.dragAndDropOfPrice(driver), -274, 0).perform();
		action.moveToElement(HomePageBookShelves.strogeFilter(driver)).perform();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", HomePageBookShelves.openOfStroge(driver));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].click()", HomePageBookShelves.excludingOutOfStock(driver));

		bookShelves = new String[HomePageBookShelves.nameOfBookShelves(driver).size()];
		prices = new String[HomePageBookShelves.priceOfBookShelves(driver).size()];

		for (int i = 0; i < HomePageBookShelves.bookshelves.size(); i++) {

			bookShelves[i] = HomePageBookShelves.nameOfBookShelves(driver).get(i).getText();
			prices[i] = HomePageBookShelves.priceOfBookShelves(driver).get(i).getText();
			prices[i] = prices[i].replaceAll("[^0-9]", "");

		}

		ExcelWrite.below15000BookShelves(bookShelves, prices, 3);
		for (int i = 0; i < 3; i++) {

			System.out.println(bookShelves[i] + " - Rs." + prices[i]);

		}
		try {

			ScreenShot.screenShotTestCase(driver);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Test(priority = 2, groups = { "Regression Test one" })
	public static void mouseHoverOfBrandFilter() throws InterruptedException {

		logger = report.createTest("Display the collections from By The Home Decor");
		logger.log(Status.INFO, "Display the collection of items by filtering the sub menu as 'By The Home Decor'");
		Thread.sleep(5000);
		action.moveToElement(HomePageByAtHome.brandFilter(driver)).perform();
		HomePageByAtHome.byAtHomeAsBrand(driver).click();
		Thread.sleep(3000);
		
		bookShelves = new String[HomePageByAtHome.bookshelvesOfByAtHome(driver).size()];
		prices = new String[HomePageByAtHome.priceOfByAtHome(driver).size()];

		int x = HomePageByAtHome.bookshelves.size();

		for (int i = 0; i < x; i++) {

			bookShelves[i] = HomePageByAtHome.bookshelvesOfByAtHome(driver).get(i).getText();
			prices[i] = HomePageByAtHome.priceOfByAtHome(driver).get(i).getText();
			prices[i] = prices[i].replaceAll("[^0-9]", "");

		}

		ExcelWrite.byAtHomeBookshelves(bookShelves, prices, x);
		Thread.sleep(3000);
		for (int i = 0; i < HomePageByAtHome.bookshelvesOfByAtHome(driver).size(); i++) {

			System.out.println(bookShelves[i] + " - Rs." + prices[i]);

		}
		Thread.sleep(3000);
		try {

			action.moveToElement(HomePageBookShelves.excludingOutOfStock(driver)).perform();
			ScreenShot.screenShotTestCase(driver);

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		logger.log(Status.PASS, "PASSED");

	}

	@Test(priority = 3, groups = { "Smoke Test two" })
	public static void giftCard() {
		logger = report.createTest("Fill and customize the gift card");
		logger.log(Status.INFO, "Choose \"Birthday/Anniversary\" from Gift Cards menu and fill some customized message");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
		ExplicitWait.giftCardVisibility(driver);
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("arguments[0].click()", HomePageGiftCards.giftCardMenu(driver));
		HomePageGiftCards.birthDayOrAnniversary(driver).click();
		HomePageGiftCards.findingAmount(driver).sendKeys("5000");
		HomePageGiftCards.nextButton(driver).click();
		HomePageGiftCards.recepientName(driver).sendKeys("abc");
		HomePageGiftCards.recepientEmail(driver).sendKeys("abc@gmail.com");
		HomePageGiftCards.recepientMobile(driver).sendKeys("9876543210");
		HomePageGiftCards.customerName(driver).sendKeys("cde");
		HomePageGiftCards.customerEmail(driver).sendKeys("cdegmail.com");
		HomePageGiftCards.customerMobileNumber(driver).sendKeys("9876543210");
		HomePageGiftCards.customerAddress(driver).sendKeys("116/2,Mettu Street,Chennai");
		HomePageGiftCards.customerPincode(driver).sendKeys("600001");
		HomePageGiftCards.optionalMessage(driver).sendKeys("hi hello");
		HomePageGiftCards.confirmButton(driver).click();
		logger.log(Status.PASS, "PASSED");

	}

	@Test(priority = 4, groups = { "Smoke Test two" })
	public static void screenShotOfErrorMessage() {

		logger = report.createTest("Taking Screenshot of Error Message");
		logger.log(Status.INFO, "To capture the screenshot of error message displayeg on the web page");

		try {

			ScreenShot.screenShotTestCase(driver);

		} catch (Exception e) {

			e.printStackTrace();

		}

		logger.log(Status.PASS, "PASSED");

	}

	@Test(priority = 5, groups = { "Smoke Test two" })
	public static void displayErrorMessage() {

		logger = report.createTest("Displaying Error Message in the Console");
		logger.log(Status.INFO, "To display the error message in the console");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
				HomePageGiftCards.recepientEmail(driver));
		System.out.println(validationMessage);

		logger.log(Status.PASS, "PASSED");

	}
	@AfterGroups("Smoke Test two")
	public static void closingBrowser() {

		report.flush();
		DriverSetup.closeDriver();

	}

}
