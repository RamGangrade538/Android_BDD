package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.DriverFactory;

@CucumberOptions(
            features = {"src/test/resources/features"},
            glue = {"steps"},
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true )
    public class TestRunner extends AbstractTestNGCucumberTests {
        @BeforeSuite
        public void setup() {
            DriverFactory.initializeDriver();
        }

        @AfterSuite
        public void teardown() {
            System.out.println("quit driver app close ");
            DriverFactory.quit();
        }
    }


