package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

	// page locators

	By courseSearchTexbox = By.xpath("//input[@placeholder='Search course...']");
	By courseSearchBtn = By.xpath("//button[normalize-space()='Search']");
	By courseSearchResults = By.xpath("//h3[@class='course-title']");

	// constructor
	public SearchPage(ThreadLocal<WebDriver> driver) {
		super(driver);
		PageFactory.initElements(driver.get(), this);
	}

	// page actions

	public ArrayList<String> searchAndExtractResults(String courseText) {

		setText(courseSearchTexbox, courseText);
		clickElement(courseSearchBtn);

		return getAllTextsByElement(courseSearchResults);

	}
}
