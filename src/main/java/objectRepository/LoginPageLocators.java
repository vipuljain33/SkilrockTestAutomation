package objectRepository;

import org.openqa.selenium.By;

public class LoginPageLocators {
	
	public static By userTextfield = By.id("username");
	public static By userPassword = By.id("password");
	public static By loginBtn = By.xpath("//*[@value='Login']");
	
	public static By errorMessageWhenUsernameNotEntered = By.xpath("//*[contains(text(),'Please Enter Login Name')]");
	public static By errorMessageWhenPasswordNotEntered =  By.xpath("//*[contains(text(),'Please Enter Password')]");
	//public static By loginBtn = By.id("submitLogin");
	public static By errorWhenInvalidCredentialsEntered = By.xpath("//*[contains(text(),'Please Enter Correct Login Name and Password!!')]"); 

	

}
