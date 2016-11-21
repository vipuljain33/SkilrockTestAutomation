package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;

public class MobileDrawGamePage extends BasePage {

	public MobileDrawGamePage(WebDriver driver) {
		super(driver);

//		if (isElementPresent(LuckeyNumberPageLocator.drawGameHeaderAndroid, 5)) {
//			System.out.println("Draw Game lobby is present");
//		} else {
//			System.out.println("Draw Game lobby not present");
//		}
//		WebElement elem = findElement(LuckeyNumberPageLocator.drawGameHeaderAndroid, 5);
//
//		if (elem == null) {
//			throw new ElementNotVisibleException("Draw Game lobby is not visible");
//		}
	}
}
