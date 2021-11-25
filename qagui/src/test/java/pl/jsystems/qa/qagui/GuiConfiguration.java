package pl.jsystems.qa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GuiConfiguration {

    protected WebDriver driver;

    @BeforeAll
    public static void setUpAll(){
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp(){


        setUpMachine();
        setUpDriver();
    }

    private void setUpMachine(){
        if (GuiConfig.MACHINE.equals("local")) {
            setUpLocalConfiguration();
        } else {
            setUpRemoteConfiguration();
        }
    }

    private WebDriver setUpRemoteConfiguration() {
        setUpRemoteDriver();
        return driver;
    }

    private void setUpRemoteDriver() {
        try {
            driver = new RemoteWebDriver(new URL(GuiConfig.REMOTE_URL),
                    new DesiredCapabilities(GuiConfig.BROWSER,"", Platform.LINUX));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    private void setUpLocalConfiguration() {
        driver = setWebDriver();
    }

    private void setUpFirefox(){
        setUpEnv("webdriver.gecko.driver", "drivers/geckodriver.exe");

    }
    private void setUpChrome(){
        setUpEnv("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    private void setUpEnv(String s, String s2) {
        try {
        System.setProperty(s, Paths.get(getClass().getClassLoader()
                .getResource(s2).toURI()).toFile().getAbsolutePath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void setUpDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    private WebDriver setWebDriver(){
        switch (GuiConfig.BROWSER){
            case "chrome":
                setUpChrome();
                return new ChromeDriver();
            case "firefox":
                setUpFirefox();
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
        }
        return new FirefoxDriver();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
