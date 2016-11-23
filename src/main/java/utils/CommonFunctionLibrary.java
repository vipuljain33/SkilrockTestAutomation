package utils;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class CommonFunctionLibrary{
	
	WebDriver driver ;
	WebDriverWait wait;
	public Dimension size;
	public CommonFunctionLibrary(WebDriver driver) {

		this.driver = driver;
		
	}

	public boolean switchFrame(String frameId)
	{
		try
		{
			driver.switchTo().defaultContent();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
			// driver.switchTo().frame(frameId);
			System.out.println(driver.getWindowHandle());
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * This function fires events on device keys
	 * 
	 * @param key
	 * @param noOfClk
	 */
	public void deviceKeyAndroid(int key) {
		((AndroidDriver) driver).pressKeyCode(key);
	}

	public void swipe(int endNumber, double x1, double x2, int duration, int sleep) {

		try {
			// appiumNative();
			for (int iCount = 1; iCount <= endNumber; iCount++) {

				size = driver.manage().window().getSize();
				int startx = (int) (size.width * x1);
				int endx = (int) (size.width * x2);
				int starty = size.height / 2;
				((AppiumDriver) driver).swipe(startx, starty, endx, starty, duration);
				Thread.sleep(sleep);
				System.out.println("Count : " + iCount);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void switchToAlertOk()
	
	{
		Alert alert=driver.switchTo().alert();
	   alert.accept();
		
	}
	public void switchToAlertCancel()
	{
		Alert alert=driver.switchTo().alert();
		 alert.dismiss();
		
	}
	
	public WebElement findElement(By locator, int timeoutSeconds)
	{
		wait = new WebDriverWait(driver, timeoutSeconds);
		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if (elem != null) {
			return elem;
		} else {
			return null;
		}
	}

}
