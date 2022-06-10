package hotelBooking;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





//import cucumber.api.junit.Cucumber;
//import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},features = {"src/test/resources/bookinghotel/booking.feature:75"})
public class testRunnerBooking {
	
}
