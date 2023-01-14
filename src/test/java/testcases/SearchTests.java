package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import utils.DataUtils;

public class SearchTests extends BaseTest {

	@Test
	public void testSearchCourses() {

		homepage.clickElearningMenuItem();

		AssertJUnit.assertEquals(searchPage.searchAndExtractResults(DataUtils.getTestData("Config","SearchCourseKeyword")).stream()
				.allMatch(text -> text.toLowerCase().contains(DataUtils.getTestData("Config","SearchCourseKeyword"))), true);

	}

}