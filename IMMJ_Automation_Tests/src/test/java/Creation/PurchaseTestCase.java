package Creation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseTestCase {

	WebDriver driver = null;
	
	@Given ("user is on the homepage")
	public void user_is_on_the_homepage() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path: "+ projectPath);
		
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		System.out.println("Browser is loaded");
		System.out.println("Homepage is loaded");
	}
	
	@When("user clicks on blouse label")
	public void user_clicks_on_blouse_label(){
		driver.findElement(By.xpath("//a[@title=\"Blouse\"]")).click();
	}
	
	@When("user inputs {string} into quantity textfield")
	public void user_inputs_into_quantity_textfield(int qty){
				
		String qtyString = String.valueOf(qty);
		
		driver.findElement(By.id("quantity_wanted")).sendKeys(qtyString);
	}
	
	@When("user clicks on increase quantity button")
	public void user_clicks_on_increase_quantity_button(){
				
		driver.findElement(By.xpath("//a[@class=\"icon-plus\"]")).click();
	}
	
	@When("user clicks on decrease quantity button")
	public void user_clicks_on_decrease_quantity_button(){
				
		driver.findElement(By.xpath("//a[@class=\"icon-minus\"]")).click();
	}
	
	@When("user selects {string} on size dropdown")
	public void user_selects_on_day_dropdown(String sizeOption) {
		
		Select size_dropdown = new Select (driver.findElement(By.id("group_1")));
		size_dropdown.selectByValue(sizeOption);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	@When("user selects White on the colour icon")
	public void user_selects_white_on_the_colour_icon_button(){
		driver.findElement(By.id("color_8")).click();
	}
	
	@When("user selects Black on the colour icon")
	public void user_selects_black_on_the_colour_icon_button(){
		driver.findElement(By.id("color_11")).click();
	}
	
	@When("user selects on Add to cart button")
	public void user_selects_on_add_to_cart_button(){
		driver.findElement(By.id("add_to_cart")).click();
	}
	
	@When("user selects Proceed to checkout button")
	public void user_selects_proceed_to_checkout_button(){

		String add_to_cart_success = driver.findElement(By.xpath("//i[@class=\"icon-ok\\")).getAttribute("title");
		System.out.println("Item has successfully been added as per following message:\n"+add_to_cart_success);
		
		driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\\")).click();
	}
	
	@When("user inputs {string} into comment textarea")
	public void user_inputs_into_comment_textarea(String comment){
		driver.findElement(By.xpath("//textarea[@name=\"message\\")).sendKeys("title");
	}
	
	@When("user select true on radio button on Terms and Conditions checkbox")
	public void user_selects_on_TandC_chkbx(){
		driver.findElement(By.id("cgv")).click();
	}
	
	@When("user clicks on Pay by bank wire button")
	public void user_clicks_on_Pay_by_bankwire_button(){
		driver.findElement(By.xpath("//a[@class=\\\"bankwire\"]")).click();
	}
	
	@When("user clicks on I confirm my order button")
	public void user_clicks_on_I_confirm_my_order_button(){
		driver.findElement(By.xpath("//span[@text=\"I confirm my order\"]")).click();
	}

	@Then("user sees {string} heading")
	public void user_sees_heading(String confirmation){

		WebElement confirmPageHeading = driver.findElement(By.xpath("//h1[@class=\"page-heading\"]"));
		
		String confirmPageHeading2 = confirmPageHeading.getText();
		
		if (confirmPageHeading2.contains(confirmation)) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER CONFIRMATION heading has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER CONFIRMATION heading has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}
	
	@Then("user sees 'Amount $56.00' text")
	public void user_sees_amount_text(String amount) {

		WebElement confirmPageAmount = driver.findElement(By.xpath("//span[@class=\"price\"]"));
		
		String confirmPageAmount2 = confirmPageAmount.getText();
		
		if (confirmPageAmount2.contains(amount)) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("'"+amount+"heading has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER CONFIRMATION heading has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

}
