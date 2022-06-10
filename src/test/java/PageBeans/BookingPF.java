package PageBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookingPF {
	WebDriver driver;
	public Select cit;
	
	@FindBy(how = How.ID,using ="txtFirstName")
	@CacheLookup()
	WebElement pffname;
	
	@FindBy(how = How.ID,using ="txtLastName")
	@CacheLookup
	WebElement pflname;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"txtEmail\"]")
	@CacheLookup
	WebElement pfmail;
	
	@FindBy(how = How.XPATH,using="//*[@id=\"txtPhone\"]")
	@CacheLookup
	WebElement pfphone;
	
	@FindBy(how = How.NAME,using ="city")
	@CacheLookup
	WebElement pfcity;
	
	@FindBy(how = How.NAME,using ="state")
	@CacheLookup
	WebElement pfstate;
	
	@FindBy(how = How.NAME,using ="persons")
	@CacheLookup
	WebElement pfpersons;
	
	@FindBy(how = How.ID,using ="txtCardholderName")
	@CacheLookup
	WebElement pfchn;
	
	@FindBy(how = How.ID,using ="txtDebit")
	@CacheLookup
	WebElement pfdebit;
	
	@FindBy(how = How.ID,using ="txtCvv")
	@CacheLookup
	WebElement pfcvv;

	@FindBy(how = How.ID,using ="txtMonth")
	@CacheLookup
	WebElement pfemonth;
	
	@FindBy(how = How.ID,using ="txtYear")
	@CacheLookup
	WebElement pfeyear;
	
	@FindBy(how = How.CLASS_NAME,using ="btn")
	@CacheLookup
	WebElement pfbtn;
	
	@FindBy(how = How.ID,using ="rooms")
	@CacheLookup
	WebElement pfrooms;
	
	public BookingPF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	public void setPffname(String fname) {
		pffname.sendKeys(fname);
	}
	
	public WebElement getPffname() {
		return pffname;
	}

	public void setPflname(String lname) {
		pflname.sendKeys(lname);
	}
	
	public WebElement getPflname() {
		return pflname;
	}

	public void setPfmail(String mail) {
		pfmail.sendKeys(mail);
	}
	
	
	public WebElement getPfmail() {
		return pfmail;
	}
	
	public WebElement getPfphone() {
		return pfphone;
	}

	public void setPfphone(String phone) {
		pfphone.sendKeys(phone);
	}

	public void setPfcity(String city) {
		cit = new Select(pfcity);
		cit.selectByVisibleText(city);
	}
	
	public WebElement getPfcity() {
		return pfcity;
	}

	public void setPfstate(String state) {
		Select drpstate = new Select(pfstate);
		drpstate.selectByVisibleText(state);
	}
	
	public WebElement getPfstate() {
		return pfstate;
	}

	public void setPersons(int persons) {
		Select drpperson = new Select(pfpersons);
		drpperson.selectByVisibleText(String.valueOf(persons));
	}
	
	public WebElement getPfrooms() {
		return pfrooms;
	}
	public void setPfchn(String chn) {
		pfchn.sendKeys(chn);
	}
	
	public WebElement getPfchn() {
		return pfchn;
	}

	public void setPfdebit(String debit) {
		pfdebit.sendKeys(debit);
	}

	public void setPfcvv(String cvv) {
		pfcvv.sendKeys(cvv);
	}
	
	public WebElement getPfcvv() {
		return pfcvv;
	}
	
	public void setPfemonth(String emonth) {
		pfemonth.sendKeys(emonth);
	}

	public void setPfeyear(String eyear) {
		pfeyear.sendKeys(eyear);
	}
	
	public WebElement getPfyear() {
		return pfeyear;
	}

	public void setPfbtn() {
		pfbtn.click();
	}



}
