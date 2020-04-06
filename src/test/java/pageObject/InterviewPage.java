package pageObject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InterviewPage {
	
	AndroidDriver driver;

	public InterviewPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='JAVA']")
	AndroidElement java;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Top 50 Struts Interview Questions']")
	AndroidElement struts;
	@AndroidFindBy(id = "com.vector.guru99:id/show_answer")
	AndroidElement showAnswerBtn;
	@AndroidFindBy(id = "com.vector.guru99:id/next")
	AndroidElement nextBtn;
	@AndroidFindBy(id = "com.vector.guru99:id/interview_question")
	AndroidElement nextQuestion;
		
	
	
	public void clickOnJava() {
		java.click();
	}
	public void clickOnStruts() {
		struts.click();
	}
	public void clickOnShowAnswer() {
		showAnswerBtn.click();
	}
	public void clickOnNext() {
		nextBtn.click();
	}
	public boolean isNextQuestionDisplayed() {
		return nextQuestion.isDisplayed();
	}

}
