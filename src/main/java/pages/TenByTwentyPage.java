package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TenByTwentyLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class TenByTwentyPage extends BasePage {
	CommonFunctionLibrary functionLibrary;
	int flag = 1;
	int price1;

	public TenByTwentyPage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);
	}

	public void isTenByTwentySelected() {
		functionLibrary.switchFrame("leftbottom");
		if (isElementPresent(TenByTwentyLocator.TBTlocator, 5)) {
			findElement(TenByTwentyLocator.TBTlocator, 5).click();
		} else {
			Assert.fail("TEN_BY_TWENTY NOT FOUND!!");
		}

	}

	public boolean isDirectTenSelected() {
		if (isElementPresent(TenByTwentyLocator.dierct10locator, 5)) {
			findElement(TenByTwentyLocator.dierct10locator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean isQPSelected() {
		if (isElementPresent(TenByTwentyLocator.qpLocator, 5)) {
			findElement(TenByTwentyLocator.qpLocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberBetweenTenToTwenty() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);

		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 1000 && num > 20) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isFirstTenSelected() {
		if (isElementPresent(TenByTwentyLocator.firsttenlocator, 5)) {
			findElement(TenByTwentyLocator.firsttenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionFirstTen() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num > 10) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isLastTenSelected() {
		if (isElementPresent(TenByTwentyLocator.lasttenlocator, 5)) {
			findElement(TenByTwentyLocator.lasttenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionLastTen() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 11) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isAllOddSelected() {
		if (isElementPresent(TenByTwentyLocator.alloddlocator, 5)) {
			findElement(TenByTwentyLocator.alloddlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionAllOdd() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num % 2 == 0) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isAllEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.allevenlocator, 5)) {
			findElement(TenByTwentyLocator.allevenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean EvenNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num % 2 != 0) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isQpDisabled() {
		if (isElementPresent(TenByTwentyLocator.qpLocator, 5)) {
			if (findElement(TenByTwentyLocator.qpLocator, 5).getAttribute("disabled").equalsIgnoreCase("true")) {
				System.out.println("QP is disabled");
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isEvenOddSelected() {
		if (isElementPresent(TenByTwentyLocator.evenoddlocator, 5)) {
			findElement(TenByTwentyLocator.evenoddlocator, 5).click();
			System.out.println(" EVENODD FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public boolean EvenOddNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 11) {
				if (num % 2 != 0) {
					flag = 0;
					break;
				}
			}
			if (num > 10) {
				if (num % 2 == 0) {
					flag = 0;
					break;
				}
			}

		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isOddEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.oddevenlocator, 5)) {
			findElement(TenByTwentyLocator.oddevenlocator, 5).click();
			System.out.println(" ODDEVEN FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public boolean OddEvenNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num > 10) {
				if (num % 2 != 0) {
					flag = 0;
					break;
				}
			}
			if (num < 11) {
				if (num % 2 == 0) {
					flag = 0;
					break;
				}
			}

		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}

	}

	public boolean isJumpOddEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.jumpoddevenlocator, 5)) {
			findElement(TenByTwentyLocator.jumpoddevenlocator, 5).click();
			System.out.println("JUMPODDEVEN FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public List<String> NumbersPicked(By by) {
		String str = findElement(by, 5).getText();
		System.out.println(str);
		ArrayList<String> qpselected = new ArrayList<String>();

		for (String number : str.split(",")) {
			System.out.println(number);
			qpselected.add(number);

		}
		return qpselected;

	}

	public List<String> ListOfJumpOddEven() {
		List<String> pickednum2 = new ArrayList<String>();
		pickednum2.add("01");
		pickednum2.add("02");
		pickednum2.add("05");
		pickednum2.add("06");
		pickednum2.add("09");
		pickednum2.add("10");
		pickednum2.add("13");
		pickednum2.add("14");
		pickednum2.add("17");
		pickednum2.add("18");
		return pickednum2;
	}

	public boolean isJumpEvenOddSelected() {
		if (isElementPresent(TenByTwentyLocator.jumpevenoddlocator, 5)) {
			findElement(TenByTwentyLocator.jumpevenoddlocator, 5).click();
			System.out.println("JUMPEVENODD FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public List<String> ListOfJumpEvenOdd() {
		List<String> pickednum2 = new ArrayList<String>();
		pickednum2.add("03");
		pickednum2.add("04");
		pickednum2.add("07");
		pickednum2.add("08");
		pickednum2.add("11");
		pickednum2.add("12");
		pickednum2.add("15");
		pickednum2.add("16");
		pickednum2.add("19");
		pickednum2.add("20");
		return pickednum2;
	}

	public boolean OtherAmountSelected() {
		if (isElementPresent(TenByTwentyLocator.otheramt, 5)) {
			findElement(TenByTwentyLocator.amnt, 5).click();
			System.out.println("element clicked!!");
			// findElement(TenByTwentyLocator.otheramtentered, 5).sendKeys("5");
			//System.out.println("amount entered");
			return true;
		} else {
			return false;
		}
	}

	String price;

	public boolean VerifyTicketPrice() {
		double NoOfLine = Double.parseDouble(findElement(TenByTwentyLocator.NoOfLines, 5).getText());
		double amount = Double.parseDouble(findElement(TenByTwentyLocator.amnt, 5).getText());

		double price = Double.parseDouble(findElement(TenByTwentyLocator.tktprice, 5).getText());

		double Tktprice = NoOfLine * amount;

		if (price == Tktprice) {
			System.out.println("TICKET PRICE VALIDATED SUCCEFULLY");
			return true;
		} else {
			return false;
		}
	}

}