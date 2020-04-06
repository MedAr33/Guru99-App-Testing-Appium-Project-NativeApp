package pageObject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CourseListPage {
	
	AndroidDriver driver;

	public CourseListPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='PHP']")
		AndroidElement phpElement;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='What is PHP? Write your first PHP Program']")
		AndroidElement lesson1Element;
		@AndroidFindBy(id = "com.vector.guru99:id/next")
		AndroidElement nextBtn;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Step by step instruction on XAMPP & Netbeans installation']")
		AndroidElement lesson2Element;
		
		
		public void clickOnPhp() {
			phpElement.click();
		}
		
		public boolean isLesson1TitleChecked() {
			if (lesson1Element.getText().contains("What is PHP? Write your first PHP Program")) {
				return true;
			}else {
				return false;
			}
		}
		
		public boolean isLesson2TitleChecked() {
			if (lesson2Element.getText().contains("Step by step instruction on XAMPP & Netbeans installation")) {
				return true;
			}else {
				return false;
			}
		}
		
		public void clickOnLesson1() {
			lesson1Element.click();
		}
		
		public void clickOnNext() {
			nextBtn.click();
		}

}
