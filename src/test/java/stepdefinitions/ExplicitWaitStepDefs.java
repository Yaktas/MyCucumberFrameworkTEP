package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ExplicitWaitStepDefs {
    @Given("user is on the demo page")
    public void user_is_on_the_demo_page() {
       // Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

    }

    @Given("user clicks on the Start button")
    public void user_clicks_on_the_Start_button() {
        WebElement startButton=Driver.getDriver().findElement(By.xpath("//button"));
        startButton.click();
    }

    @Given("user waits until the page loads")
    public void user_waits_until_the_page_loads() {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Hello World!']")));

    }

    @Then("verify the Hello World! text is visible")
    public void verify_the_Hello_World_text_is_visible() {
       WebElement helloWord=Driver.getDriver().findElement(By.xpath("//*[.='Hello World!']"));
        Assert.assertTrue(helloWord.getText().equals("Hello World!"));
    }

    @Given("user waits fluently until the page loads and verify the text message")
    public void user_waits_fluently_until_the_page_loads_and_verify_the_text_message() {

        //creating the fluent wait object
        Wait<WebDriver> wait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //WebElement message = wait.until(dr -> dr.findElement(By.id("message")));
        WebElement message = Driver.getDriver().findElement(By.id("message"));


        Assert.assertTrue(message.getText().equals("It's gone!"));
    }

}
