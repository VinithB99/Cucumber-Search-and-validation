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

public class Amazon {
	public static WebDriver driver;
	@Given("User should Launch Chrome Browser for Amazon")
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Given("User shold Navigate to URL for Amazon")
	public void navigateURL() {
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Page Title is : " + title);
		System.out.println("Page URL is : " + currentUrl);
	}

	@When("User search the product for Amazon")
	public void searchProduct() {
		WebElement oTxt, oDrop, oBtn;
		oTxt = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		oTxt.sendKeys("iPad");
		oDrop = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select oSelect = new Select(oDrop);
		oSelect.selectByVisibleText("Electronics");
		oBtn = driver.findElement(By.id("nav-search-submit-button"));
		oBtn.submit();
	}

	@Then("Validate the Result for Amazon")
	public void validate() {
		WebElement oText, oElement;
		oText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span"));
		String res = oText.getText();
		System.out.println("Result is : " + res);
		java.util.List<WebElement> List1 = driver
				.findElements(By.xpath("//a[@class='a-link-normal a-text-normal']"));
		for (int i = 0; i < List1.size(); i++) {
			oElement = List1.get(i);
			String sName = oElement.getText();
			System.out.println(sName);
		}
	}

	@Then("Close the Browser for Amazon")
	public void closeBrowser() {
		driver.quit();
		System.out.println("Browser closed!!");

	}

}
