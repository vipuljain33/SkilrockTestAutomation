package objectRepository;

import org.openqa.selenium.By;

public class LoginPageLocators {
	
	public static String appId = "com.skilrock.lms.ui:";

	public static By userTextfield = By.id("username");
	public static By userPassword = By.id("password");
	public static By loginBtn = By.xpath("//*[@value='Login']");
	public static By errorMessageWhenUsernameNotEntered = By.xpath("//*[contains(text(),'Please Enter Login Name')]");
	public static By errorMessageWhenPasswordNotEntered =  By.xpath("//*[contains(text(),'Please Enter Password')]");
	//public static By loginBtn = By.id("submitLogin");
	public static By errorWhenInvalidCredentialsEntered = By.xpath("//*[contains(text(),'Please Enter Correct Login Name and Password!!')]");
	//public static By errorMessageWhenUsernameNotEntered = By.xpath("//*[contains(text(),'Please Enter Login Name')]");
	//public static By errorMessageWhenPasswordNotEntered = By.xpath("//*[contains(text(),'Please Enter Password')]");
	// public static By loginBtn = By.id("submitLogin");
	//public static By errorWhenInvalidCredentialsEntered = By
			//.xpath("//*[contains(text(),'Please Enter Correct Login Name and Password!!')]");

	// Android App Locators
	public static By drawerImageAndroid = By.id("com.skilrock.lms.ui:id/drawer_image");
	public static By loginAndroid = By.id("com.skilrock.lms.ui:id/login");
	public static By usernameAndroid = By.id("com.skilrock.lms.ui:id/username");
	public static By passwordAndroid = By.id("com.skilrock.lms.ui:id/password");
	public static By popupHeaderAndroid = By.id("com.skilrock.lms.ui:id/header_name");
	public static By LoggedInUserAndroid = By.id("com.skilrock.lms.ui:id/user_name");
	public static By cancelPopupAndroid = By.id("com.skilrock.lms.ui:id/done");
	public static By homeScreenImageAndroid = By.id("com.skilrock.lms.ui:id/image_display");
	public static By startNow = By.id("com.skilrock.lms.ui:id/done");
	public static By dismissNotification = By.id("com.skilrock.lms.ui:id/dialogcancel");
}
