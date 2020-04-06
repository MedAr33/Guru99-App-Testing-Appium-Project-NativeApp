package pageObject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuizPage {
	
	AndroidDriver driver;

	public QuizPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Quality Center']")
	AndroidElement QCItem;
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='No']")
	AndroidElement repNo;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Next']")
	AndroidElement next;
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Niether Child nor Parent Requirements']")
	AndroidElement repFour;
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Finish']")
	AndroidElement finish;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='You Scored: 1/20']")
	AndroidElement score;
	
	
	
	public void clickOnQC() {
		QCItem.click();
	}
	
	public void clickOnYes() {
		repNo.click();
	}
	
	public void clickOnNext() {
		next.click();
	}
	
	public void clickOnRepFour() {
		repFour.click();
	}
	
	public void clickOnFinish() {
		finish.click();
	}
	
	public boolean isScoreDisplayed() {
		return score.isDisplayed();
	}

}
