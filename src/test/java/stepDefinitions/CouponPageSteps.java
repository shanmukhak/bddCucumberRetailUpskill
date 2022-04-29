package stepDefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import hooks.BaseClass;
import hooks.SingletonClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddCouponPage;
import pages.DeleteCouponPage;
import pages.EditCouponDetailsPage;

public class CouponPageSteps extends BaseClass{

	private static final Logger log = LogManager.getLogger(CouponPageSteps.class);
	SingletonClass sg = SingletonClass.getInstance();
	WebDriver driver = sg.getDriver();
	
	@After
	public void stop() {
		driver.quit();
	}
	
	AddCouponPage cpage = new AddCouponPage(driver);
	EditCouponDetailsPage epage = new EditCouponDetailsPage(driver);
	DeleteCouponPage dpage = new DeleteCouponPage(driver);
	
	@Given("user navigated to login page")
	public void user_navigated_to_login_page() {
		
		driver.manage().window().maximize();
		driver.get("http://retailm1.upskills.in/admin/index.php");
		log.info("User navigated to Login page!");
		System.out.println("User navigated to Login page!");
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		cpage.performLogin(string, string2);
	    log.info("user clicked on login");
	}
	@Then("user should see Dashboard")
	public void user_should_see_dashboard() {
		Assert.assertTrue(cpage.verifyDashboardPageDisplayed());
		log.info("Dashboard page displayed");
	}
	@Given("user Hovers on share icon")
	public void user_hovers_on_share_icon() throws InterruptedException {
	    cpage.hoverOnShareIcon();
	    
	}
	@When("user clicks on Coupons button")
	public void user_clicks_on_coupons_button() {
	   cpage.clickCoupon();
	   System.out.println("clicked on coupon link");
	}
	@When("user should see Coupons page")
	public void user_should_see_coupons_page() {
		Assert.assertTrue(cpage.verifyCouponpageDisplayed());
	}
	@When("user Clicks on Add new coupon button")
	public void user_clicks_on_add_new_coupon_button() {
		cpage.addNewCoupon();
	}
	@When("user enters all details and clicks save button")
	public void user_enters_all_details_and_clicks_save_button() {
	    cpage.fillDetailsAndClickSave();
	}
	@Then("user should see coupon name in coupons list")
	public void user_should_see_coupon_name_in_coupons_list() {
		Assert.assertTrue(verifyCouponCreated());
	}
	@Then("user should see modification success message")
	public void user_should_see_modification_success_message() throws InterruptedException {
		Assert.assertTrue(cpage.verifySuccessMessage());
		cpage.performLogout();
	}

	@Given("user clicks on Edit icon")
	public void user_clicks_on_edit_icon() {
		epage.editCouponCode();
	}
	@When("user updates Type field dropdown")
	public void user_updates_type_field_dropdown() {
	    epage.updateDetails();
	}
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
	   epage.clickSaveIcon();
	}
	
	@Given("user selects coupon to delete")
	public void user_selects_coupon_to_delete() {
		dpage.selectFirstCheckbox();
	}
	@When("user clicks on delete icon")
	public void user_clicks_on_delete_icon() {
	   dpage.clickDelete();
	}
	@When("user click on OK from delete alert")
	public void user_click_on_ok_from_delete_alert() throws InterruptedException {
	    driver.switchTo().alert().accept();
	    Thread.sleep(3000);
	    Assert.assertTrue(dpage.verifyCouponSuccessfullyDeleted());
	}
	
	public boolean verifyCouponCreated() {
		
		WebElement cn = driver.findElement(By.xpath("//td[text()='" + couponName + "']"));
		return cn.isDisplayed();
	}
}
