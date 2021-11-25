package pl.jsystems.qa.qagui.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By by, int maxTime){
        Wait wait = new WebDriverWait(this.driver, Duration.ofSeconds(maxTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void click(WebElement element, int maxTime){
        waitForClickable(element,maxTime);
        element.click();
    }
    public void waitForClickable(WebElement element, int maxTime){
        Wait wait = new WebDriverWait(this.driver, Duration.ofSeconds(maxTime));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
