package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SearchPage;
import utils.DataUtils;

public abstract class BaseTest {

	protected ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	// object repo

	protected HomePage homepage;
	protected LoginPage loginPage;
	protected ProfilePage profilePage;
	protected SearchPage searchPage;

	@BeforeMethod(alwaysRun = true)
	protected void setUp() {
		// setting up chromedriver
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");// Bypass OS security model
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("-–no-sandbox");
		options.addArguments("window-size=1200,1100");

		try {
			driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		// driver.set(new ChromeDriver(options));
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		// launch our application
		// driver.get().get("https://testautomasi.com");
		driver.get().get(DataUtils.getTestData("Config", "BaseUrl"));
		// set up page objects

		initializePageObjects();
	}

	private void initializePageObjects() {
		homepage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		profilePage = new ProfilePage(driver);
		searchPage = new SearchPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	protected void cleanUpActivities() {

		// quit all chrome driver sessions
		driver.get().quit();
	}

}
