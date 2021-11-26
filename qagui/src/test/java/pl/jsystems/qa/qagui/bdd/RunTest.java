package pl.jsystems.qa.qagui.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:pl.jsystems.qa.qagui.bdd",
        plugin = {"pretty", "summary", "html:target/cucumber/report.html", "json:target/cucumber.json",
        "junit:target/cucumber.xml", "rerun:target/rerun.txt"},
        tags =
                "@BDD "
//                        +
//                        "and "+
//                        "@Login "+
//                        "and "+
//                        "@wordpress "+
//                        "and "+
//                        "@userpanel "
)
public class RunTest {

}
