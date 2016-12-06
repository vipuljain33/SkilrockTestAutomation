package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utils.CommonFunctionLibrary;
import utils.ConfigManager;
import utils.DriverFactory;

public class AttachHooks {

	private Scenario scenario;
	public static WebDriver driver;
	DesiredCapabilities capabilities;
	private static Logger LOGGER = LoggerFactory.getLogger(AttachHooks.class);

	CommonFunctionLibrary functionLibrary;

	@Before
	public void setUp(Scenario scenario) {
		LOGGER.info("Inside set up method of before hook");
		ConfigManager.loadConfig();
		this.scenario = scenario;
		System.out.println(scenario.getName());
		
		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Api")) {
			System.out.println("API Execution Start");
		}			        
		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Mobile")) {
			if (ConfigManager.getProperty("PlatformName").equalsIgnoreCase("Android")) {
				try {
					DriverFactory.appiumStop();
					Thread.sleep(5000);
					DriverFactory.appiumStart();
					Thread.sleep(10000);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("emulator", true);
				capabilities.setCapability("deviceName", ConfigManager.getProperty("DeviceName"));
				capabilities.setCapability("platformVersion", ConfigManager.getProperty("PlatformVersion"));
				capabilities.setCapability("platformName", ConfigManager.getProperty("PlatformName"));
				capabilities.setCapability("app", ConfigManager.getProperty("ApkPath"));

				try {
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			} else if (ConfigManager.getProperty("PlatformName").equalsIgnoreCase("IOS")) {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("deviceName", ConfigManager.getProperty("deviceName"));
				capabilities.setCapability("platformVersion", ConfigManager.getProperty("platformVersion"));
				capabilities.setCapability("platformName", ConfigManager.getProperty("platformName"));
				capabilities.setCapability("app", ConfigManager.getProperty("apkPath"));
				try {
					driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			}
		}
		if ((ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Web"))||((ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("WebPortal")))) {

			System.out.println("Our browser will be invoked here");
			if (ConfigManager.getProperty("browserName").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				// options.addArguments("ignore-certificate-errors");
				// options.addArguments("--allow-running-insecure-content");
				driver = new ChromeDriver(options);
			}

			if (ConfigManager.getProperty("browserName").equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			}
			if (ConfigManager.getProperty("browserName").equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "D:\\SkilrockAutomation\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			// System.out.println(System.getProperty("user.dir")+"\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\vipuljain\\Desktop\\chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver",
			// System.getProperty("user.dir")+"\\chromedriver.exe");
			// driver = new ChromeDriver();

			driver.get(ConfigManager.getProperty("EnvironmentURL"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
		}
		functionLibrary = new CommonFunctionLibrary(driver);
	}

	@After
	public void tearDown() throws InstantiationException, IllegalAccessException {

		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Api")){
			System.out.println("API Execution Stop :) ");
		}
		if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Mobile")) {
			functionLibrary.embedScreenshot(scenario);
			driver.quit();
			DriverFactory.appiumStop();
		} else if (ConfigManager.getProperty("ExecutionPlatform").equalsIgnoreCase("Web")) {
			functionLibrary.embedScreenshot(scenario);
			driver.quit();
		}
	}

}
