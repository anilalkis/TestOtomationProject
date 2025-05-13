import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/LoginFail.feature",
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber-fail.json"
    },
    monochrome = true
)
public class LoginFailRunner {
}
