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

	public static By registerAndroid = By.id("com.skilrock.lms.ui:id/register");
	public static By dobAndroid = By.id("com.skilrock.lms.ui:id/date_of_birth");
	public static By mobileNoAndroid = By.id("com.skilrock.lms.ui:id/phoneNumber");
	public static By referralCodeAndroid = By.id("com.skilrock.lms.ui:id/refer_promo_code");
	public static By emailIdAndroid = By.id("com.skilrock.lms.ui:id/email");
	public static By TermsAndroid = By.id("com.skilrock.lms.ui:id/txt_tc");
	public static By registerUserAndroid = By.id("com.skilrock.lms.ui:id/lets_play");
	public static By clickOKAndroid = By.id("android:id/button1");
	public static By clickSMSDone = By.id("com.skilrock.lms.ui:id/dialogDone");
}
