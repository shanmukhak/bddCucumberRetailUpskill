package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import hooks.BaseClass;

public class DeleteCouponPage {

	//WebDriver driver = BaseClass.driver;
	String cn;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//tbody/tr/td[2]"))
	private List<WebElement> cnames;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//tbody/tr/td/input"))
	private List<WebElement> checkbox;
	
	@FindBy(how = How.CSS, using = ".btn-danger")
	private WebElement deleteIcon;
		
	public DeleteCouponPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	public void selectFirstCheckbox() {
		
		checkbox.get(0).click();
	}
	
	public String getFirstCouponName() {
		
		return cnames.get(0).getAttribute("value");
	}
	
	public boolean verifyCouponSuccessfullyDeleted() {
		
		boolean stat=false;
		for(WebElement elem: cnames) {
			if(!elem.getText().equalsIgnoreCase(cn)) {
				stat=true;
				return stat;
			}	
		}
		return stat;
	}
	
	public void clickDelete() {
		cn = getFirstCouponName();
		deleteIcon.click();
	}
}
