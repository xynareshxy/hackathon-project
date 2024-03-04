package userDefinedLibraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

/***********************************************************************************
*                                                                                  *
* Class Name     : DriverSetup                                                     * 
* Description    : To Create and Start the web driver and also Get the URL to test.*
* 				   Also to close the driver.                                       *
*                                                                                  *
************************************************************************************/

public class DriverSetup {

	public static WebDriver driver;
	public static String exePath;
	public static String browserName;
	public static String baseUrl1;
	
	 public static WebDriver openDriver(String browser, String baseUrl) {
		
		 browserName = browser;
		 baseUrl1 = baseUrl;

		if (browserName.equalsIgnoreCase("Edge")) {
			
			exePath = "./Drivers/msedgedriver.exe";
			System.setProperty("webdriver.edge.driver",exePath);
			driver = new EdgeDriver();
			
		} else if (browserName.equalsIgnoreCase("Chrome")) {
			
			//exePath = "./Drivers/chromedriver.exe";
			//System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			
		} else {
			
			System.out.println("Not a valid browser");
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		return driver;
		
		}
	 
	 public static void closeDriver() {
		 
		 driver.quit();
		 
	 }
}
