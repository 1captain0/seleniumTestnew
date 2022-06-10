package hotelBooking;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageBeans.BookingPF;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.asserts.SoftAssert;


public class stepDefinitionBooking {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private BookingPF bpf;
	//String res = "";
	
	
	@Given("^User is on Hotel Booking page$")
	public void user_is_on_hotel_booking_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:/Users/mekev/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		bpf = new BookingPF(driver);
		   
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String baseUrl="file:///C:/Users/mekev/Downloads/studyMaterial-main/studyMaterial-main/hotelbooking.html";
		driver.get(baseUrl);
	}

	@Then("^Validate page title$")
	public void validate_page_title() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String title = driver.getTitle();
		Assert.assertEquals("Hotel Booking", title);
		
		driver.close();
	}


	@When("^User enters all valid data$")
	public void user_enters_all_valid_data() throws Throwable {
	    bpf.setPffname("Kevin");
	    bpf.setPflname("Benny");
	    bpf.setPfmail("mekevin@gmail.com");
	    bpf.setPfphone("9207449065");
	    bpf.setPfcity("Bangalore");
	    bpf.setPfstate("Karnataka");
	    bpf.setPersons(4);
	    bpf.setPfchn("Kevin Benny");
	    bpf.setPfdebit("405165458585");
	    bpf.setPfcvv("999");
	    bpf.setPfemonth("05");
	    bpf.setPfeyear("2025");
	    Thread.sleep(3000);
	}

	@When("^clicks on confirm booking button$")
	public void clicks_on_confirm_booking_button() throws Throwable {
		bpf.setPfbtn();
		Thread.sleep(3000);
	}

	@Then("^Booking Successfull page should be displayed$")
	public void booking_Successfull_page_should_be_displayed() throws Throwable {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	    String heading = driver.findElement(By.xpath("/html/body/h1")).getText();
	    Assert.assertEquals("Booking Completed!",heading);
	    driver.close();
	}

	@When("^User leaves First Name blank$")
	public void user_leaves_First_Name_blank() throws Throwable {
		bpf.setPffname("");
		Thread.sleep(3000);
	}

	@Then("^Display suitable alert message$")
	public void display_suitable_alert_message() throws Throwable {
		//String exRes = "";
		
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			String alert = driver.switchTo().alert().getText();
		    //Thread.sleep(3000);
		    driver.switchTo().alert().accept();
		    if(bpf.getPffname().getAttribute("value").isEmpty()) {
		    	String exRes = "Please fill the First Name";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPflname().getAttribute("value").isEmpty()) {
		    	
		    	String exRes = "Please fill the Last Name";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(!(Pattern.matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$", bpf.getPfmail().getAttribute("value")))) {
		    	String exRes = "Please enter valid Email Id.";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPfcity().getAttribute("value").isEmpty()) {
		    	String exRes = "Please select city";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPfstate().getAttribute("value").isEmpty()) {
		    	String exRes = "Please select State";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPfyear().getAttribute("value").isEmpty()) {
		    	String exRes = "Please fill the expiration year";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(!(Pattern.matches("[789][0-9]{9}", bpf.getPfphone().getAttribute("value")))) {
		    	String exRes = "Please enter valid Contact no.";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPfchn().getAttribute("value").length()<16 || bpf.getPfchn().getAttribute("value").length()>16) {
		    	String exRes = "Please enter valid Card no.";
		    	Assert.assertEquals(exRes, alert);
		    }
		    else if(bpf.getPfcvv().getAttribute("value").length()<3 || bpf.getPfcvv().getAttribute("value").length()>3){
		    	String exRes = "Please enter valid CVV no.";
		    	Assert.assertEquals(exRes, alert);
		    }
		    
		} catch (Exception e) {
			
			Assert.fail("No alert is displayed");
			
		}finally {
			
		    driver.close();
		    
		}
		
	    
	}

	@When("^User enters all valid data to previous fields and leaves Last Name blank$")
	public void user_enters_all_valid_data_to_previous_fields_and_leaves_Last_Name_blank() throws Throwable {
		bpf.setPffname("Kevin");
		bpf.setPflname("");
		Thread.sleep(3000);
	}

	@When("^User enters invalid Email Id$")
	public void user_enters_invalid_Email_Id() throws Throwable {
		bpf.getPfmail().clear();
	    bpf.setPfmail("#gmail/com");
	    Thread.sleep(3000);
	}

	@When("^User enters invalid Phone Number$")
	public void user_enters_invalid_Phone_Number(DataTable arg1) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    // For automatic transformation, change DataTable to one of
//	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
//	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		List<String> data = arg1.asList();
		for(String d:data) {
			bpf.getPfphone().clear();Thread.sleep(2500);
			bpf.setPfphone(d);Thread.sleep(3000);
		}
		
//	    throw new PendingException();
	}

	@When("^User does not select city$")
	public void user_does_not_select_city() throws Throwable {
	    //bpf.getPfcity().clear();
	    bpf.setPfcity("Select City");
		Thread.sleep(3000);
	    
	}
	
	@When("^User does not select state$")
	public void user_does_not_select_state() throws Throwable {
	    //bpf.getPfstate().clear();
	    bpf.setPfstate("Select State");
		Thread.sleep(3000);
	}

	@When("^User selects count of Persons (\\d+)$")
	public void user_selects_count_of_Persons(int arg1) throws Throwable {
		bpf.setPersons(arg1);
		Thread.sleep(3000);
	}

	@Then("^Allocate suitable no\\. of rooms as per no\\. of persons (\\d+)$")
	public void allocate_suitable_no_of_rooms_as_per_no_of_persons(int arg1) throws Throwable {
		
	    if(arg1<=3) {
	    	String s = bpf.getPfrooms().getText();
	    	Assert.assertEquals("1", s);
	    }
	    else if(arg1<=6) {
	    	String s = bpf.getPfrooms().getText();
	    	Assert.assertEquals("2", s);
	    }
	    else if(arg1<=9) {
	    	String s = bpf.getPfrooms().getText();
	    	Assert.assertEquals("3", s);
	    }
		driver.close();
	}

	@When("^User enters all valid data and leaves expiry year blank$")
	public void user_enters_all_valid_data_and_leaves_expiry_year_blank() throws Throwable {
		bpf.setPffname("Kevin");
	    bpf.setPflname("Benny");
	    bpf.setPfmail("mekevin@gmail.com");
	    bpf.setPfphone("9207449065");
	    bpf.setPfcity("Bangalore");
	    bpf.setPfstate("Karnataka");
	    bpf.setPersons(4);
	    bpf.setPfchn("Kevin Benny");
	    bpf.setPfdebit("405165458585");
	    bpf.setPfcvv("999");
	    bpf.setPfemonth("05");
	    bpf.setPfeyear("");
	    Thread.sleep(3000);
	}
	
	@When("User enters all valid data and gives invalid card number {string}")
	public void user_enters_all_valid_data_and_gives_invalid_card_number(String string) throws Throwable {
		bpf.setPffname("Kevin");
	    bpf.setPflname("Benny");
	    bpf.setPfmail("mekevin@gmail.com");
	    bpf.setPfphone("9207449065");
	    bpf.setPfcity("Bangalore");
	    bpf.setPfstate("Karnataka");
	    bpf.setPersons(4);
	    bpf.setPfchn("Kevin Benny");
	    bpf.setPfdebit(string);
	    bpf.setPfcvv("999");
	    bpf.setPfemonth("05");
	    bpf.setPfeyear("2025");
	    Thread.sleep(3000);
	}
	
	@When("User enters all valid data and gives invalid cvv number {string}")
	public void user_enters_all_valid_data_and_gives_invalid_cvv_number(String string) throws Throwable {
		bpf.setPffname("Kevin");
	    bpf.setPflname("Benny");
	    bpf.setPfmail("mekevin@gmail.com");
	    bpf.setPfphone("9207449065");
	    bpf.setPfcity("Bangalore");
	    bpf.setPfstate("Karnataka");
	    bpf.setPersons(4);
	    bpf.setPfchn("Kevin Benny");
	    bpf.setPfdebit("1654678364758935");
	    bpf.setPfcvv(string);
	    bpf.setPfemonth("05");
	    bpf.setPfeyear("2025");
	    Thread.sleep(3000);
	}
	
	@When("User enters all valid data and gives invalid expiry month {string}")
	public void user_enters_all_valid_data_and_gives_invalid_expiry_month(String string) throws Throwable {
		
	}
	
}
