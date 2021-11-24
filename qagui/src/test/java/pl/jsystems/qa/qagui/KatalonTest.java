package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class KatalonTest extends GuiConfig{

    @Disabled
    @Test
    public void katalonTest(){
        driver.get("https://wordpress.com/");
//        driver.findElement(By.linkText("Log In")).click();
//        driver.findElement(By.id("usernameOrEmail")).click();
//        driver.findElement(By.id("usernameOrEmail")).clear();
//        driver.findElement(By.id("usernameOrEmail")).sendKeys("automation112021");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).clear();
//        driver.findElement(By.id("password")).sendKeys("Test112021");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Nowy wpis'])[1]/following::*[name()='svg'][1]")).click();
//        driver.findElement(By.xpath("//div[@id='secondary']/ul/li/div[2]/button")).click();
        //ERROR: Caught exception [unknown command []]
    }
}
