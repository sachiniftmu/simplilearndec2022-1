package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	ThreadLocal<WebDriver> driver2 = new ThreadLocal<WebDriver>();

	public BasePage(ThreadLocal<WebDriver> driver) {
		driver2 = driver;

	}

	protected void clickElement(By element) {
		driver2.get().findElement(element).click();
	}

	protected void setText(By element, String textToType) {
		driver2.get().findElement(element).sendKeys(textToType);
	}

	protected String getText(By element) {
		return driver2.get().findElement(element).getText();
	}

	protected boolean isElementPresent(By element) {
		return driver2.get().findElement(element).isDisplayed();
	}

	protected ArrayList<String> getAllTextsByElement(By element) {
		ArrayList<String> results = new ArrayList<>();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> webElements = driver2.get().findElements(element);

		for (WebElement item : webElements) {

			results.add(item.getText());
		}

		return results;
	}

	protected String getCurrentPageUrl() {
		return driver2.get().getCurrentUrl();
	}

	protected void clickUsingJs(By element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver2.get();
		executor.executeScript("arguments[0].click();", driver2.get().findElement(element));

	}
}
