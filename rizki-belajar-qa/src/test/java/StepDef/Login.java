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
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("Should success login and redirected to homepage")
    public void shouldSuccessLoginAndRedirectedToHomepage() {
        Assert.assertTrue(driver.findElement(By.id("inventory_container")).isDisplayed());
        driver.close();
        driver.quit();
    }

    @Then("Failed login and showing message")
    public void failedLoginAndShowingMessage() {
        Assert.assertTrue(driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[1]/form[1]/h3[1]")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
