package userDefinedLibraries;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {
	
	public static WebDriverWait wait;
	
	public static void priceFilterVisibility(WebDriver driver) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='noUi-handle noUi-handle-upper']")));
		
	}
	
	public static void giftCardVisibility(WebDriver driver) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Gift Cards')])[1]")));
	    
	}
}
