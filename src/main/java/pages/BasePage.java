package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import io.appium.java_client.android.AndroidDriver;
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

	public void findElementAndroid() {
		((AndroidDriver) driver)
				.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.skilrock.lms.ui:id/game_button\")")
				.click();
	}

	public List<String> findElements(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		List<String> temp = new ArrayList<String>();
		if (elem != null) {
			for (WebElement val : elem) {
				temp.add(val.getText());
			}
			return temp;
		} else {
			return null;
		}
	}

	public List<WebElement> findAllWebElements(By locator, int timeoutSeconds) {
		wait = new WebDriverWait(driver, timeoutSeconds);
		List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return elem;
	}

	/**
	 * To click an element
	 * 
	 * @param locator
	 * @throws InterruptedException
	 */
	public boolean buttonClick(By locator) {
		try {
			WebElement element = findElement(locator, 10);
			element.click();
			return true;
		} catch (Exception e) {
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
		findElement(locator, 10).clear();
		findElement(locator, 10).sendKeys(str);
	}

	public static boolean nodeDetail(WebElement select, String string) {
		boolean detail = select.getAttribute(string) != null;
		return detail;
	}

	/**
	 * This function verifies element is present
	 * 
	 * @param locator
	 */
	public void verify(By locator) {
		if (isElementPresent(locator, 5)) {
			System.out.println(locator + " :: element is present");
		} else {
			System.out.println(locator + " :: element is not present");
		}
		WebElement elem = findElement(locator, 5);

		if (elem == null) {
			throw new ElementNotVisibleException(locator + " :: element is not visible");
		}
	}

	public boolean verifyActiveBetType(By locator, String query, String status) throws SQLException {
		DBConnection dbconnection = new DBConnection();
		Connection connection = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(connection, query, 1, status);
		List<String> dbbettype = new ArrayList<String>();
		List<String> uibettype = new ArrayList<String>();
		boolean flag = false;
		while (rs.next()) {
			dbbettype.add(rs.getString(1));
			System.out.println(rs.getString(1));
		}
		uibettype = findElements(locator, 5);
		System.out.println(uibettype);
		Collections.sort(dbbettype);
		if (dbbettype.equals(uibettype))
			return true;

		return flag;
	}

}
