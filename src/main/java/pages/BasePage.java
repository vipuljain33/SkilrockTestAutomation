package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataBaseQuery.DBConnection;
import io.appium.java_client.android.AndroidDriver;
import utils.CommonFunctionLibrary;
import utils.DateUtils;

public class BasePage {

	protected WebDriver driver;
	WebDriverWait wait;
	DBConnection connnection;

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

	/**
	 * @param parentLocator
	 * @param childPath
	 * @return
	 */
	public List<WebElement> getChildElements(By parentLocator, By childLocator) {
		try {
			WebElement listViewElement = findElement(parentLocator, 5);
			List<WebElement> childElementList = listViewElement.findElements(childLocator);
			// System.out.println("LIST ::" + childElementList);
			System.out.println(childElementList.size());
			for (WebElement elem : childElementList) {
				String text = elem.getText();
				System.out.println(text);
			}
			return childElementList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * @param locator
	 * @param query
	 * @param status
	 * @return
	 * @throws SQLException
	 */
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

	/**
	 * @param parentLocator
	 * @param childLocator
	 * @param header
	 * @param query
	 * @param param1
	 * @param returnFormat
	 * @throws SQLException
	 */
	public void advanceDrawListVerify(By parentLocator, By childLocator, String header, String query, String param1,
			String returnFormat) throws SQLException {
		List<String> databaseValue = new ArrayList<String>();
		List<WebElement> drawList = getChildElements(parentLocator, childLocator);
		List<String> uiDrawInfo = new ArrayList<String>();
		if (drawList != null) {
			for (WebElement elem : drawList) {
				if (!elem.getText().equalsIgnoreCase(header) && !elem.getText().equalsIgnoreCase("")) {
					uiDrawInfo.add(elem.getText());
					System.out.println("UI List :: " + uiDrawInfo);
				}
			}
		} else {
			Assert.fail();
		}
		connnection = new DBConnection();
		ResultSet resultset = connnection.ExecuteQuery(connnection.CreateConnectionForDGE(), query, param1);
		while (resultset.next()) {
			for (int j = 1; j <= resultset.getMetaData().getColumnCount(); j++) {
				String temp = DateUtils.getDateInExpectedFormat("yyyy-MM-dd HH:mm:ss.S", resultset.getString(j),
						returnFormat);
				databaseValue.add(temp);
				System.out.println("DB List :: " + databaseValue);
			}
		}
		if (uiDrawInfo.equals(databaseValue)) {
			System.out.println("database value: " + databaseValue + " match with front end: " + uiDrawInfo);
		} else {
			System.out.println("value not matched");
		}
	}
}
