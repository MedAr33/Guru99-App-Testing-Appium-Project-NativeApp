package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;

public class TestCase1 extends BaseClass {

	@Test
	public void tc1() throws IOException {
		HomePage hp = new HomePage(driver);

		if (hp.isAppNameExist()) {
			logger.info("Application name exist");
		}else {
			logger.info("Application name dosen't exist");
		}
		//=================================================
		
		if (hp.isCourseCatDisplayed()) {
			logger.info("course category is displayed");
		}else {
			logger.info("course category is not displayed");
		}
		
		if (hp.isCourseCatClickable()) {
			logger.info("course category is clickable");
		}else {
			logger.info("course category is not clickable");
		}
		
		if (hp.isCourseCatSelected()) {
			logger.info("course category is selected");
		}else {
			logger.info("course category is not selected");
		}
		//========================================================
		
		if (hp.isCourseListDisplayed()) {
			logger.info("course list is displayed");
		}else {
			logger.info("course list is not displayed");
		}
		
		if (hp.isCourseListClickable()) {
			logger.info("course list is clickable");
		}else {
			logger.info("course list is not clickable");
		}
		
		if (!hp.isCourseListSelected()) {
			logger.info("course list is not selected");
		}else {
			logger.info("course list is selected");
		}
		//=========================================================
		
		if (hp.isCourseCatLisPresent()) {
			logger.info("course category list is displayed with "+hp.CourseCatList.size()+" items" );
		}else {
			logger.info("course category list is not displayed");
		}
		//=========================================================
		
		boolean assertion= hp.isAppNameExist() && hp.isCourseCatDisplayed() && hp.isCourseCatClickable() && hp.isCourseCatSelected()
				&& hp.isCourseListDisplayed() && hp.isCourseListClickable() && !hp.isCourseListSelected() &&
				hp.isCourseCatLisPresent();
		if (assertion) {
			logger.info("test succeed \n");
			Assert.assertTrue(true);
		}else {
			logger.info("test failed \n");
			captureScreen(driver, "TestCase01");
			Assert.assertTrue(false);
		}

		
	}

}
