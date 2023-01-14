package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utils.DataUtils;

public class LoginTest extends BaseTest {

	@Test
	public void testLogin() {
	// testdata

			String username = DataUtils.getTestData("Config","Username");
			String password = DataUtils.getTestData("Config","Password");
		// teststeps
			homepage.clickLoginMenu();
			loginPage.loginToApplication(username, password);

			AssertJUnit.assertEquals(profilePage.verifyProfilenameIsCorrect(username), true);

	}
	
}
