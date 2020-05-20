package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DataTablesPage;
import utilities.Driver;

public class ScenarioOutlineExample_StepDefinition {
DataTablesPage dtPage=new DataTablesPage();
    @Given("user is on the datatables")
    public void user_is_on_the_datatables() {
        Driver.getDriver().get("https://editor.datatables.net/");
    }

    @When("user clicks on new button")
    public void user_clicks_on_new_button() {
dtPage.newButton.click();
    }

    @When("user enters firstname")
    public void user_enters_firstname() {
dtPage.firstName.sendKeys("Test First");
    }

    @When("user enters lastname")
    public void user_enters_lastname() {
dtPage.lastName.sendKeys("Test Last");
    }

    @When("user enters position")
    public void user_enters_position() {
dtPage.position.sendKeys("QA");
    }

    @When("user enters office")
    public void user_enters_office() {
dtPage.office.sendKeys("New York");
    }

    @When("user enters extension")
    public void user_enters_extension() {
dtPage.extension.sendKeys("225");
    }

    @When("user enters startdate")
    public void user_enters_startdate() {
dtPage.startDate.sendKeys("2020-05-06");
    }

    @When("user enters salary")
    public void user_enters_salary() {
dtPage.salary.sendKeys("90000");
    }

    @Then("clicks create button")
    public void clicks_create_button() throws InterruptedException {
        Thread.sleep(3000);
dtPage.createButton.click();
    }

    @Given("user enters firstname to the searchbox")
    public void user_enters_firstname_to_the_searchbox() {
dtPage.searchBox.sendKeys("Test First");
    }

    @Then("verify that user see the first name in the searchbox")
    public void verify_that_user_see_the_first_name_in_the_searchbox() {
String name=dtPage.nameField.getText();//Test First Test Last
        Assert.assertTrue(name.contains("Test First"));

    }


    @Given("user enters firstname {string}")
    public void user_enters_firstname(String firstname) {
     dtPage.firstName.sendKeys(firstname);
    }


    @Given("user enters lastname {string}")
    public void user_enters_lastname(String lastname) {
dtPage.lastName.sendKeys(lastname);
    }
    @Given("user enters position {string}")
    public void user_enters_position(String position) {
dtPage.position.sendKeys(position);
    }
    @Given("user enters office {string}")
    public void user_enters_office(String office) {
dtPage.office.sendKeys(office);
    }
    @Given("user enters extension {string}")
    public void user_enters_extension(String extension) {
dtPage.extension.sendKeys(extension);
    }
    @Given("user enters startdate {string}")
    public void user_enters_startdate(String startdate) {
        dtPage.startDate.click();
        dtPage.day.click();
        //dtPage.startDate.sendKeys(startdate);
    }
    @Given("user enters salary {string}")
    public void user_enters_salary(String salary) {
dtPage.salary.sendKeys(salary);
    }
    @Given("user enters firstname {string} to the searchbox")
    public void user_enters_firstname_to_the_searchbox(String firstname) throws InterruptedException {
        Thread.sleep(3000);
dtPage.searchBox.sendKeys(firstname);
    }
    @Then("verify that user see the first name {string} in the searchbox")
    public void verify_that_user_see_the_first_name_in_the_searchbox(String firstname) throws InterruptedException {
        Thread.sleep(3000);
        String name=dtPage.nameField.getText();//Test First Test Last
        Assert.assertTrue(name.contains(firstname));
        Driver.closeDriver();
    }

}
