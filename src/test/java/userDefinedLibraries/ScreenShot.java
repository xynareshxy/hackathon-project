package userDefinedLibraries;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenShot {

	public static int flag = 1;

	public static String screenShotTestCase(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screenshot/Message - " + flag + ".png");

		try {

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {

			e.printStackTrace();
		}

		flag++;
		
		return dest.getPath();

	}
	
}
