package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CourseListPage;
import pageObject.HomePage;

public class TestCase5 extends BaseClass {
	
	@Test
	public void tc5() throws IOException {
		HomePage hp = new HomePage(driver);
		CourseListPage clp = new CourseListPage(driver);
		
		hp.clickOnCourseList();
		logger.info("Course list clicked");
		scrollTo("PHP");
		logger.info("Scrolling to PHP");
		clp.clickOnPhp();
		logger.info("PHP clicked");
		
		if (clp.isLesson1TitleChecked() && clp.isLesson2TitleChecked()) {
			logger.info("Lesson 1 title and lesson 2 title are checked");
			clp.clickOnLesson1();
			logger.info("Lesson 1 clicked");
			clp.clickOnNext();
			logger.info("Next clicked");
			logger.info("Test succeed \n");
			Assert.assertTrue(true);
			
		}else {
			logger.info("Test failed \n");
			captureScreen(driver, "tc5");
			Assert.assertTrue(false);
		}
	}
}
