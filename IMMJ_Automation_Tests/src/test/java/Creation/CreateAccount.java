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

public class CreateAccount {

	WebDriver driver = null;
	
	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path: "+ projectPath);
		
		System.setProperty("webdriver.gecko.driver", projectPath+"/src/test/resources/drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("http://automationpractice.com/index.php");
		
		System.out.println("Browser is loaded");
		System.out.println("Homepage is loaded");
	}

	@When("user clicks on Sign in button")
	public void user_clicks_on_sign_in_button() {
	    
		driver.findElement(By.className("login")).click();;
		System.out.println("Sign in page is loaded");
	}

	@When("user enters {string} into email addess textfield")
	public void user_enters_into_email_addess_textfield(String email) {
	    
		driver.findElement(By.id("email_create")).sendKeys(email);;
		System.out.println("Email: " + email+ " inserted into create email textfield");
		
	}

	@When("user clicks on {string} button")
	public void user_clicks_on_create_an_account_button(String string) {

		//Added implicit wait as it was taking a while for webdriver to click on button
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@id=\"SubmitCreate\"]")).click();
		driver.findElement(By.xpath("//*[text()='"+string+"']")).click();

	}

	@When("user selects {string} radio button")
	public void user_selects_radio_button(String title) {
		
		if(title.contains("Mr")){
			driver.findElement(By.id("id_gender1")).click();
		} else {
			driver.findElement(By.id("id_gender2")).click();
		}
	}

	@When("user enters {string} into first name textfield")
	public void user_enters_into_first_name_textfield(String firstName) {
	    driver.findElement(By.id("customer_firstname")).sendKeys(firstName);;
	    
	}

	@When("user enters {string} into last name textfield")
	public void user_enters_into_email_address_textfield(String lastName) {
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);;
	}

	
	
	
	@When("user enters {string} into password textfield")
	public void user_enters_into_password_textfield(String passwd) {
		
	}

	@When("user selects {string} on day dropdown")
	public void user_selects_on_day_dropdown(Integer days) {
		
		String dayZ = Integer.toString(days);
		
		Select day_dropdown = new Select (driver.findElement(By.id("days")));
		day_dropdown.selectByValue(dayZ);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@When("user selects {string} on month dropdown")
	public void user_selects_on_month_dropdown(String months) {
		
		Select month_dropdown = new Select (driver.findElement(By.id("months")));
		month_dropdown.selectByValue(months);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@When("user selects {string} on year dropdown")
	public void user_selects_on_year_dropdown(int years) {
		
		String yearZ = Integer.toString(years);
		
		Select day_dropdown = new Select (driver.findElement(By.id("years")));
		day_dropdown.selectByValue(yearZ);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@When("user selects {string} on Sign up for our newsletter! check box")
	public void user_selects_option_on_sign_up_check_box(Boolean check1) {
	    
		/*if (check1=true) {
			driver.findElement(By.id("newsletter")).click();
			System.out.println("Newsletter has been selected");
		}else {
			
			WebElement newsLtr_chkbx = driver.findElement(By.id("newsletter"));
			
			if(!newsLtr_chkbx.isSelected()) {
				System.out.println("Newsletter has not been selected");
			}
		}*/
		
		driver.findElement(By.id("newsletter")).click();
		
	}
	
	@When("user selects {string} on Receive special offers from our partners! check box")
	public void user_selects_option_on_special_offers_check_box(Boolean check2) {
	    
		/*if (check2=true) {
			driver.findElement(By.id("optin")).click();
			System.out.println("Third Party option has been selected");
		}else {
			
			WebElement newsLtr_chkbx = driver.findElement(By.id("optin"));
			
			if(!newsLtr_chkbx.isSelected()) {
				System.out.println("Third Party option has not been selected");
			}
		}*/
		
		driver.findElement(By.id("optin")).click();
		
	}
	
	@When("user enters {string} into company textfield")
	public void user_enters_into_company_textfield(String company) {
		driver.findElement(By.id("company")).sendKeys(company);
	}

	@When("user enters {string} into Address textfield")
	public void user_enters_into_address_textfield(String addrLn1) {
		driver.findElement(By.id("address1")).sendKeys(addrLn1);
	}

	@When("user enters {string} into Address Line2 textfield")
	public void user_enters_into_textfield(String addrLn2) {
	    driver.findElement(By.id("address2")).sendKeys(addrLn2);
	}

	@When("user enters {string} into City textfield")
	public void user_enters_into_city_textfield(String city) {
		driver.findElement(By.id("city")).sendKeys(city);
	}

	@When("user selects {string} into State textfield")
	public void user_selects_into_state_textfield(String state) {
		driver.findElement(By.id("id_state")).sendKeys(state);
	}

	@When("user enters {string} into Zip\\/Postal Code textfield")
	public void user_enters_into_zip_postal_code_textfield(String postCode) {
	    driver.findElement(By.id("postcode")).sendKeys(postCode);
	}

	@When("user selects {string} on Country dropdown")
	public void user_selects_on_country_dropdown(String country) {
	    driver.findElement(By.id("id_country")).sendKeys(country);
	}

	@When("user enters {string} into additional information  textarea")
	public void user_enters_into_additional_information_textarea(String addInfo) {
	    driver.findElement(By.id("alias")).sendKeys(addInfo);
	}

	@When("user enters {string} into Homephone textfield")
	public void user_enters_into_Homephone_textfield(String home_phone) {
	    driver.findElement(By.id("phone")).sendKeys(home_phone);
	}
	
	@When("user enters {string} into mobilephone textfield")
	public void user_enters_into_mobilephone_textfield(String mobile_phone) {
	    driver.findElement(By.id("phone_mobile")).sendKeys(mobile_phone);
	}

	@When("user enters {string} into Assign an address alias for future reference textfield")
	public void user_enters_into_assign_an_address_alias_for_future_reference_textfield(String aliastxt) {
	    driver.findElement(By.id("alias")).sendKeys(aliastxt);
	}

	
	
	@Then("user sees {string} heading")
	public void user_sees_heading(String headingChk) {
		
		String headingChk1 = driver.findElement(By.xpath("//h1[@class=\"page-heading\"]")).getText();
		
		if (headingChk1.contains(headingChk)) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY ACCOUNT has been printed and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("'"+ headingChk +" has not been printed and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	@Then("user sees sign out button")
	public void user_sign_out_sees_button() {
		
		String signOutChk = driver.findElement(By.className("logout")).getText();
		//String singoutChk2 = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).getText();

		
		if (signOutChk.contains("Sign out")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Sign out has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Sign out has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	@Then("user sees {string} text")
	public void user_sees_text(String infoText) {
		//p[@class="info-account"]
		
		String infoTxtChk = driver.findElement(By.xpath("//p[@class=\"info-account\"]")).getText();
		
		
		if (infoTxtChk.contains("Welcome to your account. Here you can manage all of your personal information and orders.")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Welcome to your account. Here you can manage all of your personal information and orders. has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("'Welcome to your account. Here you can manage all of your personal information and orders.' has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
		
	}
	
	@Then("user sees Order History and details button")
	public void user_sees_order_history_button() {
				
		WebElement orderH_BtnChk = driver.findElement(By.xpath("//span[@text=\"Order history and details\"]"));
		
		String orderH_BtnChk2 = orderH_BtnChk.getText();
		
		if (orderH_BtnChk2.contains("ORDER HISTORY DETAILS")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER HISTORY DETAILS button has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER HISTORY DETAILS button has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
		
	}
	
	@Then("user sees My Credit Slips button")
	public void user_sees_my_credit_slips_button() {

		WebElement myCredSlips_BtnChk = driver.findElement(By.xpath("//span[@text=\"My credit slips\"]"));
		
		String myCredSlips_BtnChk2 = myCredSlips_BtnChk.getText();
		
		if (myCredSlips_BtnChk2.contains("MY CREDIT SLIPS")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY CREDIT SLIPS button has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY CREDIT SLIPS button has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	@Then("user sees My Addresses button")
	public void user_sees_my_addresses_button() {

		WebElement myAddresses_BtnChk = driver.findElement(By.xpath("//button[@title=\"Addresses\"]"));
		
		String myAddresses_BtnChk2 = myAddresses_BtnChk.getText();
		
		if (myAddresses_BtnChk2.contains("MY ADDRESSES")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY ADDRESSES button has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY ADDRESSES button has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	@Then("user sees My Personal Information button")
	public void user_sees_my_personal_information_button() {

		WebElement myPersonalDetail_BtnChk = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
		
		String myPersonalDetail_BtnChk2 = myPersonalDetail_BtnChk.getText();
		
		if (myPersonalDetail_BtnChk2.contains("MY PERSONAL DETAILS")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY PERSONAL DETAILS button has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY PERSONAL DETAILS button has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	@Then("user sees My Wishlists button")
	public void user_sees_my_wishlists_button() {

		WebElement myWishlist_BtnChk = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li/a"));
		
		String myWishlist_BtnChk2 = myWishlist_BtnChk.getText();
		
		if (myWishlist_BtnChk2.contains("MY PERSONAL DETAILS")) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY PERSONAL DETAILS button has been shown and test has passed");
			System.out.println("--------------------------------------------------------------------------");
		}else {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("MY PERSONAL DETAILS button has not been shown and test has failed");
			System.out.println("--------------------------------------------------------------------------");
		}
	}
	
}
