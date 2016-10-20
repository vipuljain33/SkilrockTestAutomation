package stepDefinitions;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import utils.CommonFunctionLibrary;
import utils.ConfigManager;

public class AttachHooks {
	
	private Scenario scenario;
	public static WebDriver driver;
	
	CommonFunctionLibrary functionLibrary;
	
	
	@Before
	public void setUp(Scenario scenario)
	{
		ConfigManager.loadConfig();
		this.scenario = scenario;
		System.out.println(scenario.getName());
		System.out.println("Our browser will be invoked here");
		if(ConfigManager.getProperty("browserName").equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--allow-running-insecure-content");
			driver = new ChromeDriver(options);
		}
		System.out.println(System.getProperty("user.dir")+"\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\vipuljain\\Desktop\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.get("http://192.168.124.201:8180/LMSLagos");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		functionLibrary = new CommonFunctionLibrary(driver);
		
	}
	
	@After
	public void tearDown() throws InstantiationException, IllegalAccessException
	{
		
		//driver.quit();
		functionLibrary.embedScreenshot(scenario);
		driver.quit();
	}

}
