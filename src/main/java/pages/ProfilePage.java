package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage {

	// page locators

	String profileName = "//strong[normalize-space()='%s']";
	By signOutLink = By.xpath("//a[normalize-space()='Sign out']");

	// constructor
	public ProfilePage(ThreadLocal<WebDriver> driver) {

		super(driver);
		PageFactory.initElements(driver.get(), this);

	}

	// page actions

	public boolean verifyProfilenameIsCorrect(String expectedUsername) {
		By profileNameFullXpath = By.xpath(String.format(profileName, expectedUsername));

		return isElementPresent(profileNameFullXpath);
	}

	public void clickSignoutLink() {
		clickElement(signOutLink);
	}

	public String getPageUrl() {
		return getCurrentPageUrl();
	}

}