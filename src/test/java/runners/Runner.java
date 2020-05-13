package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/cucumber",
        features ="src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@wip1",
        dryRun = false
)
public class Runner {
}
