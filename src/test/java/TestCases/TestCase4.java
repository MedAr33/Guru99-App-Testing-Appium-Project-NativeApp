package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.InterviewPage;

public class TestCase4 extends BaseClass {

	@Test
	public void tc4() {
		HomePage hp = new HomePage(driver);
		InterviewPage ip = new InterviewPage(driver);
		
		hp.clickOnInterview();
		logger.info("Interview is clicked");
		ip.clickOnJava();
		logger.info("JAVA is clicked");
		ip.clickOnStruts();
		logger.info("Struts is clicked");
		ip.clickOnShowAnswer();
		logger.info("Show answer button is clicked");
		ip.clickOnNext();
		logger.info("Next button is clicked");
		
		if (ip.isNextQuestionDisplayed()) {
			logger.info("Test succeed \n");
			Assert.assertTrue(true);
		}else {
			logger.info("Test failed");
			Assert.assertTrue(false);
		}
		
	}
}
