package cucumber.stepdefs;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.ftse.pages.PortalPage;
import pom.ftse.pages.RisersPage;

public class FtseStepDef {

	private static RemoteWebDriver driver;
	private static PortalPage website;
	private static RisersPage risers;
	private String top;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
		website = PageFactory.initElements(driver, PortalPage.class);
        risers = PageFactory.initElements(driver, RisersPage.class);
	}
	
	@Given("that I can navigate to the h1.co.uk ftse page")
	public void that_i_can_navigate_to_the_h1_co_uk_ftse_page() {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
	    website.clickCookie(); // clicks the accept button on the cookie
	}

	@When("I click the risers link")
	public void i_click_the_risers_link() {
		website.navRisers();
		System.out.println("RISERS");
	}
	
	@When("I click the fallers link")
	public void i_click_the_fallers_link() {
		website.navFallers();
		System.out.println("FALLERS");
	}
	
	@When("find the top table entry")
	public void find_the_top_table_entry() {
		website.waitUntilLoaded(driver);
		top = risers.getRiserName();
	}
	
	@Then("I output it")
	public void i_output_it() {
		System.out.println("Top: " + top);
	}
	
	@After
    public static void tearDown() {
        driver.quit();
        System.out.println("driver closed");
    }
	
}
