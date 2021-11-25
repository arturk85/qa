package pl.jsystems.qa.qagui.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamCucumberSteps {

    private WebDriver driver;

    public ParamCucumberSteps(ConfigStep configStep){
        this.driver = configStep.setUpWebDriver();
    }

    @Given("website has got title")
    public void websiteHasGotTitle(Map<String,String> dataMap){
        String website = dataMap.get("website");
        String title = dataMap.get("title");
        driver.get(website);
        assertEquals(driver.getTitle(),title);
    }

    @Given("Name of the website {string}")
    public void nameOfTheWebsite(String arg0) {
    }

    @Then("Title if {string}")
    public void titleIf(String arg0) {
    }
}
