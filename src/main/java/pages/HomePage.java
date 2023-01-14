package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	// page locators

	By menuLinkLogin = By.xpath("//a[contains(text(),'Log In')]");
	By elearningCoursesLink = By.xpath("//a[normalize-space()='E-Learning']");

	// constructor
	public HomePage(ThreadLocal<WebDriver> driver) {
		super(driver);
		PageFactory.initElements(driver.get(), this);
	}

	// page actions

	public void clickLoginMenu() {

		clickElement(menuLinkLogin);

	}

	public void clickElearningMenuItem() {

		clickElement(elearningCoursesLink);

	}

}
