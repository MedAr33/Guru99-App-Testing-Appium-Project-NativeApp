package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.QuizPage;

public class TestCase3 extends BaseClass {
	@Test
	public void tc3() {
		
		HomePage hp = new HomePage(driver);
		QuizPage qz = new QuizPage(driver);

		
		hp.clickOnQuiz();
		logger.info("Quiz clicked");
		qz.clickOnQC();
		logger.info("Quality Center clicked");
		qz.clickOnYes();
		logger.info("Response 'No' clicked");
		qz.clickOnNext();
		logger.info("Next clicked");
		qz.clickOnRepFour();
		logger.info("Response '4' clicked");
		qz.clickOnFinish();
		logger.info("Finish clicked");
		
		if (qz.isScoreDisplayed()) {
			logger.info("Test succeed : score is displayed \n");
			Assert.assertTrue(true);
		}else {
			logger.info("Test failed \n");
			Assert.assertTrue(false);
		}


		
	}
	
	
	
	

}
