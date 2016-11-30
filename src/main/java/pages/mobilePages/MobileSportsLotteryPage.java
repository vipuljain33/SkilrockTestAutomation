package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.CommonMobileLocators;
import pages.BasePage;

public class MobileSportsLotteryPage extends BasePage {
	public MobileSportsLotteryPage(WebDriver driver) {
		super(driver);

		WebElement elem = driver.findElement(CommonMobileLocators.headerTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("SPORTS LOTTERY")) {
			System.out.println("Sports lottery page is opened");
		} else {
			throw new ElementNotVisibleException("Sports lottery page is not visible");

		}
	}

	public MobileSoccer13Page selectSoccerGame() {
		if (buttonClick(CommonMobileLocators.buyNowAndroid)) {
			try {
				return new MobileSoccer13Page(driver);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}

}
