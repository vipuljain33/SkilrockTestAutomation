package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonFunctionLibrary;

public class BasePage {

	protected WebDriver driver;
	WebDriverWait wait;
	public CommonFunctionLibrary functionLibrary;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		functionLibrary = new CommonFunctionLibrary(this.driver);
	}

	public boolean isElementPresent(By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, timeoutInSeconds);
			WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (elem != null) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

	}

	public WebElement findElement(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if (elem != null) {
			return elem;
		} else {
			return null;
		}
	}

	/**
	 * To click an element
	 * 
	 * @param locator
	 * @throws InterruptedException
	 */
	public boolean buttonClick(By locator)  {
		try
		{
		WebElement element = findElement(locator, 10);
		element.click();
		return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	/**
	 * This function enters values in text box
	 * 
	 * @param locator
	 * @param str
	 */
	public void sendKeys(By locator, String str) {
		findElement(locator, 10).sendKeys(str);
	}
	

}
