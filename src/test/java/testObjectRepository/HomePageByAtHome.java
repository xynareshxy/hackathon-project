package testObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/***********************************************************************************
*                                                                                  *
* Class Name     : HomePageByAtHome                                                * 
* Description    : To Get all the web elements present in the website              *
* 				   and to return the same.                                         *
*                                                                                  *
************************************************************************************/

public class HomePageByAtHome {

	public static WebDriver driver;
	public static WebElement element;
	public static List<WebElement> bookshelves = null;
	public static List<WebElement> price = null;
	
	public static WebElement brandFilter(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//div[normalize-space()='Brand']"));
		return element;
		
	}
	
	public static WebElement byAtHomeAsBrand(WebDriver driver) {
		
		element = driver.findElement(By.xpath("//label[normalize-space()='By The Home Dekor']"));
		return element;
		
	}
	
	public static List<WebElement> bookshelvesOfByAtHome(WebDriver driver) {
		
		bookshelves = driver.findElements(By.xpath("//div[@class='small'][normalize-space()='By The Home Dekor']/../../span"));
		return bookshelves;
		
	}
	
	public static List<WebElement> priceOfByAtHome(WebDriver driver) {
		
		price = driver.findElements(By.xpath("//div[contains(text(),'By The Home Dekor')]/../../following-sibling::div[1]/span"));
		return price;
		
	}
	
}
