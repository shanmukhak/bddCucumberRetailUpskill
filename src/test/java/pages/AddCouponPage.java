package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;

public class AddCouponPage extends BaseClass{

	
	//WebDriver driver = BaseClass.driver;
	
	@FindBy(how = How.XPATH, using = "//input[@id='input-username']")
	private WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
	private WebElement loginbtn;
	
	@FindBy(how = How.XPATH, using = "//h1[text()=\"Dashboard\"]")
	private WebElement dashboard;
	
	@FindBy(how = How.ID, using = "menu-marketing")
	private WebElement menuMrktng;
	
	@FindBy(how = How.XPATH, using = "//li[3]/a[text()=\"Coupons\"]")
	private WebElement couponslnk;
	
	@FindBy(how = How.XPATH, using = "//h3[text()=\" Coupon List\"]")
	private WebElement couponListTitle;
	
	@FindBy(how = How.CSS, using = "i.fa.fa-plus")    ////a[@data-original-title="Add New"]
	private WebElement AddCouponIcon;
	
	@FindBy(how = How.CSS, using = "input#input-name")
	private WebElement couponNameTxtbox;
	
	@FindBy(how = How.CSS, using = ".fa-sign-out")
	private WebElement logout;
	
	@FindBy(how = How.CSS, using = "input#input-code")
	private WebElement couponCodetxtbox;
	
	@FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
	private WebElement saveBtn;
	int i =10;
	//@FindBy(how = How.XPATH, using = "//td[text()='"+i+"']")
	//private WebElement verifyCouponName;
	
	@FindBy(how = How.XPATH, using = "//div[text()=\" Success: You have modified coupons!      \"]")
	private WebElement successMsg;
	
	public AddCouponPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void performLogin(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		loginbtn.click();
	}
	
	public void hoverOnShareIcon() throws InterruptedException {
		menuMrktng.click();
	}
	
	public void clickCoupon() {
		
		couponslnk.click();
	}
	
	public void addNewCoupon() {
		AddCouponIcon.click();
	}
	
	public void fillDetailsAndClickSave() {
		CharSequence csname = generateAphaNumericCouponName(8);
		couponNameTxtbox.sendKeys(csname);
		CharSequence code = generateRandomCouponCode();
		couponCodetxtbox.sendKeys(code);
		saveBtn.click();
	}
	
	public boolean verifySuccessMessage() throws InterruptedException {
		Thread.sleep(2000);
		return successMsg.isDisplayed();
	}
	
	public boolean verifyDashboardPageDisplayed() {
		return dashboard.isDisplayed();
	}
	
	public boolean verifyCouponpageDisplayed() {
		return couponListTitle.isDisplayed();
	}
	public void performLogout() {
		logout.click();
	}
}
