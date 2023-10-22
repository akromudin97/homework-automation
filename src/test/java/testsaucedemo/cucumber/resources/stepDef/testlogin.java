package testsaucedemo.resources.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class testlogin {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Saucedemo login page")
    public void Saucedemo_login_page(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("Input username")
    public void Input_username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void Input_password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void Click_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User in on dashboard page")
    public void User_in_on_dashboard_page() {
        driver.close();
    }

    @And("Input invalid password")
    public void Input_invalid_password() {
        driver.findElement(By.id("password")).sendKeys("secret");
    }

    @And("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
    }

    @Then("User get error message")
    public void User_get_error_message() {
        String errorlogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorlogin, "Username and password do not match any user in this service");
        driver.close();
    }
}
