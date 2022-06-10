package amazonShoppingCart;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageBeans.BookingPF;
import PageBeans.CartPF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionCart {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private CartPF cpf;
	String productName;
	
	
	@Given("User is on product page")
	public void user_is_on_product_page() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/mekev/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		cpf = new CartPF(driver);
		   
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String baseUrl="https://www.amazon.in/Kadence-Ukulele-Black-Mahagony-Concert/dp/B078K6L2XJ/?_encoding=UTF8&pd_rd_w=kQOJP&content-id=amzn1.sym.ee853eb9-cee5-4961-910b-2f169311a086&pf_rd_p=ee853eb9-cee5-4961-910b-2f169311a086&pf_rd_r=CKKK9E8CR2QG7NF7FA8S&pd_rd_wg=9Lgze&pd_rd_r=0eedcfc2-f12f-408e-ab4c-f10850467360&ref_=pd_gw_ci_mcx_mr_hp_atf_m";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@When("User clicks on Add to Cart button")
	public void user_clicks_on_add_to_cart_button() throws Throwable {
		productName = cpf.getPfprodtitle().getText();
	    cpf.getPfaddcart().click();
	    Thread.sleep(2000);
	}

	@Then("Suitable message should be displayed")
	public void suitable_message_should_be_displayed() {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    if(driver.getPageSource().contains("Added to Cart")) {
	    	driver.close();
	    }
	    else if(driver.getPageSource().contains("was removed from Shopping Cart.")) {
	    	driver.close();
	    }
	    else {
	    	Assert.fail();
	    }
	    
	}

	@When("User navigates to Cart Page")
	public void user_navigates_to_cart_page() throws Throwable {
	    cpf.getPfcartbut().click();
	    Thread.sleep(3000);
	}

	@Then("Added product should be present in cart")
	public void added_product_should_be_present_in_cart() {
		//System.out.println(cpf.getPfcart().getText());
	    if(cpf.getPfcart().getText().contains(productName)) {
	    	
	    	driver.close();
	    }
	    else {
	    	Assert.fail();
	    }
	}

	
	@When("User clicks on delete button")
	public void user_clicks_on_delete_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    cpf.getPfdel().click();
	    Thread.sleep(2000);
	}

	@When("User selects quantity of product {int}")
	public void user_selects_quantity_of_product(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Correct quantity should be displayed")
	public void correct_quantity_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Correct price should be displayed")
	public void correct_price_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@AfterClass
	public void closePage() {
		driver.close();
	}
}
