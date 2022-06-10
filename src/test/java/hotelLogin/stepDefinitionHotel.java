package hotelLogin;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert; 			
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageBeans.LoginPF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepDefinitionHotel {
	
	private LoginPF pfLoginObj;
	private WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/Users/mekev/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		pfLoginObj = new LoginPF(driver);
		   
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String baseUrl="file:///C:/Users/mekev/Downloads/studyMaterial-main/studyMaterial-main/login.html";
		driver.get(baseUrl);

		
	    
	}

	@Then("^Validate the heading of the page$")
	public void validate_the_heading_of_the_page() throws Throwable {
		String strheading = driver.findElement(By.xpath("/html/body/div/div[1]/h1")).getText();
		Assert.assertEquals("Hotel Booking Application", strheading);
	    
	}

	@When("^User enters valid username, valid password and clicks login button$")
	public void user_enters_valid_username_valid_password_and_clicks_login_button() throws Throwable {
		pfLoginObj.setUname("Neelima");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPass("neel1234");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setBtn();
	    
	}

	@Then("^Hotel Booking page should be displayed$")
	public void hotel_Booking_page_should_be_displayed() throws Throwable {
		wait.until(ExpectedConditions.titleContains("Hotel Booking"));
	    
	}

	@When("^User leaves the username \"([^\"]*)\" password \"([^\"]*)\" blank$")
	public void user_leaves_the_username_password_blank(String arg1, String arg2) throws Throwable {
		pfLoginObj.setUname(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPass(arg2);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setBtn();
	    
	}

	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("errMessage")));
	    
	}

	@When("^User enters invalid input in username \"([^\"]*)\" password \"([^\"]*)\"$")
	public void user_enters_invalid_input_in_username_password(String arg1, String arg2) throws Throwable {
		pfLoginObj.setUname(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPass(arg2);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setBtn();
	    
	}

	@Then("^Alert message should be displayed$")
	public void alert_message_should_be_displayed() throws Throwable {
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals("Invalid login! Please try again!", alertText);
	    
	}
	
}
