package StepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
    WebDriver driver;
    @Given("Open web url {string}")
    public void openWebUrl(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("Input username {string} and password {string}")
    public void inputUsernameAndPassword(String username, String password) {
        driver.findElement(By.id("user[email]")).sendKeys(username);
        driver.findElement(By.id("user[password]")).sendKeys(password);
    }

    @When("Click sign in button")
    public void clickSignInButton() {
        driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[5]/button[1]")).click();
    }

    @Then("Should success login and redirected to homepage")
    public void shouldSuccessLoginAndRedirectedToHomepage() {
        Assert.assertTrue(driver.findElement(By.id("main-content")).isDisplayed());
        driver.close();
        driver.quit();
    }

}
