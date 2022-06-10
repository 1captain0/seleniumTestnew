package PageBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPF {
	WebDriver driver;
	
	@FindBy(how = How.ID,using = "add-to-cart-button")
	@CacheLookup
	WebElement pfaddcart;
	
	@FindBy(how = How.ID,using = "nav-cart")
	@CacheLookup
	WebElement pfcartbut;
	
	@FindBy(how = How.ID,using = "title")
	@CacheLookup
	WebElement pfprodtitle;
	
	@FindBy(how = How.ID,using = "sc-active-cart")
	@CacheLookup
	WebElement pfcart;
	
	@FindBy(xpath = "//input[@value='Delete']")
	@CacheLookup
	WebElement pfdelbut;
	
	
	
	public CartPF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPfaddcart() {
		return pfaddcart;
	}
	
	public WebElement getPfcartbut() {
		return pfcartbut;
	}
	
	public WebElement getPfprodtitle() {
		return pfprodtitle;
	}
	
	public WebElement getPfcart() {
		return pfcart;
	}
	
	public WebElement getPfdel() {
		return pfdelbut;
	}

	
	
	
	
	
	
}
