package pageObject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Guru99']")
	AndroidElement appName;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Course Category']")
	AndroidElement courseCat;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Course List']")
	AndroidElement courseList;
	@AndroidFindBy(id = "com.vector.guru99:id/lblListHeader")
	public List<AndroidElement> CourseCatList;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SAP']")
	AndroidElement sapItem;
	@AndroidFindBy(id = "com.vector.guru99:id/lblListItem")
	public List<AndroidElement> childItemsOfSap;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='QUIZ']")
	AndroidElement quiz;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='INTERVIEW']")
	AndroidElement interview;
	
	
	
	public void clickOnCourseList() {
		courseList.click();
	}
	
	
	
	
	public boolean isAppNameExist() {
		return appName.isDisplayed();
	}
	
	public boolean isCourseCatDisplayed() {
		return courseCat.isDisplayed();
	}
	public boolean isCourseCatClickable() {
		return courseCat.isEnabled();
	}
	public boolean isCourseCatSelected() {
		return courseCat.isSelected();
	}
	
	public boolean isCourseListDisplayed() {
		return courseList.isDisplayed();
	}
	public boolean isCourseListClickable() {
		return courseList.isEnabled();
	}
	public boolean isCourseListSelected() {
		return courseList.isSelected();
	}
	
	
	public void listSize() {
		System.out.println(CourseCatList.size());
	}
	public boolean isCourseCatLisPresent() {
		System.out.println(CourseCatList.size());
		return !CourseCatList.isEmpty();
	}
	//=============================================
	public void clickOnSap() {
		sapItem.click();
	}
	
	
	public boolean isSapListPresent() {
		return !childItemsOfSap.isEmpty();
	}
	
	public int getSAPListSize() {
		Set<String> sapList=new HashSet<String>();
		for (AndroidElement androidElement : childItemsOfSap) {
			String text = androidElement.getText();
			sapList.add(text);
		}
		scrollTo("SAP BI");
		for (AndroidElement androidElement : childItemsOfSap) {
			String text = androidElement.getText();
			sapList.add(text);
		}
		return sapList.size();
	}
	
	
	public void clickOnQuiz() {
		quiz.click();
	}
	
	public void clickOnInterview() {
		interview.click();
	}
	
	
	
	
	
	
	
	public AndroidElement scrollTo(String visibleText) {
		return (AndroidElement) driver.findElementByAndroidUIAutomator(
				"" + "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
						+ "new UiSelector().textContains(\"" + visibleText + "\").instance(0))");
	}
	
	

}
