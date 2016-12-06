package objectRepository;

import org.openqa.selenium.By;

public class DrawGamePageLocator {

	public static By drawgamelocator = By.id("dg");
	public static By miniRouletteButton = By.xpath("//*[@id='4~20']");
	// Android App locators
	public static By drawGameAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Draw Games']");

}
