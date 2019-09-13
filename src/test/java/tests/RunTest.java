package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import util.TestRule;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@run",
        glue = {""}
)
public class RunTest {

    @ClassRule
    public static TestRule testRule = new TestRule();

}
