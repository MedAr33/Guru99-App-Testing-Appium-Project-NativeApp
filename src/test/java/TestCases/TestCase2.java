package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class TestCase2 extends BaseClass {
	@Test
	public void tc2() throws IOException {
		HomePage hp = new HomePage(driver);
		
		hp.clickOnSap();
		logger.info("SAP clicked");
		
		if (hp.isSapListPresent()) {
			logger.info("Test succeed : SAP course list is here with "+ hp.getSAPListSize()+" parts \n");
			Assert.assertTrue(true);
		}else {
			logger.info("Test failed : SAP course list dosen't exist");
			captureScreen(driver, "TestCase2");
			Assert.assertTrue(false);
		}
		
	}

}
