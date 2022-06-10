package PageBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPF {
	
	WebDriver driver;
	
	@FindBy(how = How.NAME,using ="userName")
	@CacheLookup()
	WebElement pfuname;
	
	@FindBy(how = How.NAME,using ="userPwd")
	@CacheLookup
	WebElement pfpass;
	
	@FindBy(how = How.CLASS_NAME,using="btn")
	@CacheLookup
	WebElement pfbtn;
	
	public LoginPF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un,String pas) {
		pfuname.sendKeys(un);
		pfpass.sendKeys(pas);
		pfbtn.click();
	}


	public void setUname(String un) {
		pfuname.sendKeys(un);
	}


	public void setPass(String pas) {
		pfpass.sendKeys(pas);
	}


	public void setBtn() {
		pfbtn.click();
	}
	
	
}