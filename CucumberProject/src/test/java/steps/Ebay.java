package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ebay {

	public WebDriver driver;
	//public String sURL = "https://www.ebay.com/";

	@Given("User should Launch Ebay Chrome Browser for Ebay")
	public void user_should_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Given("User shold Navigate to URL {string} for Ebay")
	public void user_shold_navigate_to_url(String sURL) {
		driver.get(sURL);
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page Title is : " + title);
		System.out.println("Page URL is : " + currentUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@When("User search the product for Ebay")
	public void user_search_the_product() {
		WebElement oTxt, oDrop, oBtn;
		oTxt = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		oTxt.sendKeys("redmi");

		oDrop = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		Select oSelect = new Select(oDrop);
		oSelect.selectByVisibleText("Cell Phones & Accessories");

		oBtn = driver.findElement(By.id("gh-btn"));
		oBtn.submit();

	}

	@Then("Validate the Result for Ebay")
	public void validate_the_result() {
		WebElement oText;

		oText = driver.findElement(By.xpath("(//h1[@class='srp-controls__count-heading']/span)[1]"));
		String resultText = oText.getText();
		resultText = resultText.replaceAll("[^0-9]", "").trim();
		int result = Integer.parseInt(resultText);
		System.out.println("Search Result is : " + result);
	}

	@Then("Close the Browser for Ebay")
	public void close_the_browser() {
		driver.quit();
	}


	
}
