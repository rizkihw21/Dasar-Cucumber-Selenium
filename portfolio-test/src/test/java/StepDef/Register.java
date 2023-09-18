package StepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {
    WebDriver driver;
    @Given("Open web ultimega {string}")
    public void openWebUltimega(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
    }

    @And("Input first {string} name and last name {string}")
    public void inputFirstNameAndLastName(String first, String last) {
        driver.findElement(By.id("user[first_name]")).sendKeys(first);
        driver.findElement(By.id("user[last_name]")).sendKeys(last);
    }

    @And("Input email {string} and password {string}")
    public void inputEmailAndPassword(String email, String password) {
        driver.findElement(By.id("user[email]")).sendKeys(email);
        driver.findElement(By.id("user[password]")).sendKeys(password);
    }

    @And("Click agree to the terms of use")
    public void clickAgreeToTheTermsOfUse() {
        WebElement checkbox = driver.findElement(By.id("user[terms]"));

        // Check the checkbox if it's not already checked
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @When("Click button sign up")
    public void clickButtonSignUp() {
        driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[6]/button[1]")).click();
    }

    @Then("Should successfully sign up and be redirected to the homepage")
    public void shouldSuccessfullySignUpAndBeRedirectedToTheHomepage() {
        Assert.assertTrue(driver.findElement(By.id("main-content")).isDisplayed());
        driver.close();
        driver.quit();
    }
}
