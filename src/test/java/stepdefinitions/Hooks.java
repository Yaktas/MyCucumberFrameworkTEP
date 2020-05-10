package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    //@Before is similar to @BeforeMethod in TestNG
    //In our case, @Before will run before each Scenario:
    //GLOBAL Hooks Annotation
    //This will run before every scenario
    @Before(order = 1)
    public void setUp(){
        System.out.println("This is SetUp Method in the Hooks");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //Tagged Hooks Annotation
    //This will run before any SPECIFIC SCENARIO
    @Before(value = "@iphone",order = 2)
    public void searchIphone(){
        System.out.println("This is IPHONE SETUP Method in the Hooks");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    //This will run After each Scenario
    @After
    public void tearDown(){
        System.out.println("This is TearDown Method in the Hooks");
    }

}
