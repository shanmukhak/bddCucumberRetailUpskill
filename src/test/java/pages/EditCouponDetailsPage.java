package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;

public class EditCouponDetailsPage extends BaseClass{

	//WebDriver driver = BaseClass.driver;
	
	@FindAll(@FindBy(how = How.CSS, using = ".fa.fa-pencil"))
	private List<WebElement> editIcon;
	
	@FindBy(how = How.CSS, using = ".fa.fa-save")
	private WebElement SaveIcon;
	
	@FindBy(how = How.CSS, using = "input#input-code")
	private WebElement couponCodetxtbox;
	
	public EditCouponDetailsPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void editCouponCode() {
		
		editIcon.get(0).click();
	}
	
	public void updateDetails() {
		CharSequence code = generateRandomCouponCode();
		couponCodetxtbox.sendKeys(code);
	}
	
	public void clickSaveIcon() {
		SaveIcon.click();
	}
	
	
	
}
