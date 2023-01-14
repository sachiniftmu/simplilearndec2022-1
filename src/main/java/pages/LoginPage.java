package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	// page locators

	By userNameTextbox = By.name("username");
	By passwordTextbox = By.name("password");
	By loginBtn = By.xpath("//button[contains(text(),'Login')]");
	By registerUserNameTextbox = By.name("reg_username");
	By registerPasswordTextbox = By.name("reg_password");
	By registerEmailTextbox = By.name("reg_email");
	By registerBtn = By.xpath("//button[contains(text(),'Register')]");
	By errorMsg = By.xpath("//div[@class='learn-press-message error']");

	// constructor
	public LoginPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		PageFactory.initElements(driver.get(), this);
	}

	// page actions

	public void loginToApplication(String username, String password) {

		setText(userNameTextbox, username);
		setText(passwordTextbox, password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement(loginBtn);

	}

	public void fillRegistrationForm(String username, String email, String password) {

		setText(registerUserNameTextbox, username);
		setText(registerEmailTextbox, email);
		setText(registerPasswordTextbox, password);
	}

	public void clickRegisterButton() {
		clickElement(registerBtn);
	}

	public String getErrorMessage() {
		return getText(errorMsg);
	}

}