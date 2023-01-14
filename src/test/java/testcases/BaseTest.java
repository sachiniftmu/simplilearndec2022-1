package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
