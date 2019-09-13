package util;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRule extends TestWatcher {

    private static WebDriver driver;

    public TestRule(){
        super();
    }

    @Override
    protected void starting(Description description){}

    @Before
    public void beforeScenario(Scenario scenario){}

    @After
    public void afterScenario(){
        if(driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    protected void finished(Description description){
        super.finished(description);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void abrirNavegador(String url){
        ChromeOptions chromeOpts = new ChromeOptions();
        chromeOpts.addArguments("start-maximized");
        Utils.setDriverByOS();

        driver = new ChromeDriver(chromeOpts);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

}
