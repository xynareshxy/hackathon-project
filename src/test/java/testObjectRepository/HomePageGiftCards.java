package testObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class HomePageGiftCards {

	public static WebElement element = null;
	public static WebDriver driver;

	public static WebElement closePopup(WebDriver driver) {

		element = driver.findElement(By.xpath("(//div[@class='icofont-cross'])[1]"));
		return element;

	}

	public static WebElement giftCardMenu(WebDriver driver) {

		element = driver.findElement(By.xpath("(//*[contains(text(),'Gift Cards')])[1]"));
		return element;

	}

	public static WebElement birthDayOrAnniversary(WebDriver driver) {

		element = driver.findElement(By.xpath("//h3[contains(text(),'Birthday')]"));
		return element;

	}

	public static WebElement findingAmount(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@placeholder='Amount']"));
		return element;

	}

	public static WebElement nextButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[text()='Next']"));
		return element;

	}

	public static WebElement recepientName(WebDriver driver) {

		element = driver.findElement(By.name("recipient_name"));
		return element;

	}

	public static WebElement recepientEmail(WebDriver driver) {

		element = driver.findElement(By.name("recipient_email"));
		return element;

	}

	public static WebElement recepientMobile(WebDriver driver) {

		element = driver.findElement(By.name("recipient_mobile_number"));
		return element;

	}

	public static WebElement customerName(WebDriver driver) {

		element = driver.findElement(By.name("customer_name"));
		return element;

	}

	public static WebElement customerEmail(WebDriver driver) {

		element = driver.findElement(By.name("customer_email"));
		return element;

	}

	public static WebElement customerMobileNumber(WebDriver driver) {

		element = driver.findElement(By.name("customer_mobile_number"));
		return element;

	}

	public static WebElement customerAddress(WebDriver driver) {

		element = driver.findElement(By.name("customer_address"));
		return element;

	}
	public static WebElement customerPincode(WebDriver driver) {

		element = driver.findElement(By.xpath("//input[@id='ip_567727260']"));
		return element;

	}

	public static WebElement optionalMessage(WebDriver driver) {

		element = driver.findElement(By.name("message"));
		return element;

	}

	public static WebElement confirmButton(WebDriver driver) {

		element = driver.findElement(By.xpath("//button[text()='Confirm']"));
		return element;

	}

}
