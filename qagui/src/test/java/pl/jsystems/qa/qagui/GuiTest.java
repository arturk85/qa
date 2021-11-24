package pl.jsystems.qa.qagui;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jsystems.qa.qagui.page.WordpressLoginPage;
import pl.jsystems.qa.qagui.page.WordpressMainPage;
import pl.jsystems.qa.qagui.page.WordpressMainUserPage;
import pl.jsystems.qa.qagui.page.WordpressMyProfilePage;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GuiTest extends GuiConfig{

    @Disabled
    @Test
    public void logInTest(){
        driver.get("https://wordpress.com/");
        driver.findElement(By.linkText("Log In")).click();
        final WebElement usernameOrEmail = driver.findElement(By.id("usernameOrEmail"));
        usernameOrEmail.click();
        usernameOrEmail.clear();
        usernameOrEmail.sendKeys("arturk85");
        driver.findElement(By.className("login__form-action")).click();
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("R0l@dm2011");
        driver.findElement(By.className("login__form-action")).click();
        assertTrue(driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).isDisplayed());
        driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me")).click();
//        driver.findElement(By.className("profile-gravatar__user-display-name"));
        assertThat(driver.findElement(By.className("profile-gravatar__user-display-name")).getText()).isEqualTo("arturk85");
        driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]")).click();

    }

    WordpressMainPage wordpressMainPage;
    WordpressLoginPage wordpressLoginPage;
    WordpressMainUserPage wordpressMainUserPage;
    WordpressMyProfilePage wordpressMyProfilePage;

    @Disabled
    @Test
    public void logInSecondTest(){
        driver.get("https://wordpress.com/");
        wordpressMainPage = new WordpressMainPage(driver);
        wordpressMainPage.clickLogInButton();

        wordpressLoginPage = new WordpressLoginPage(driver);
        wordpressLoginPage.enterUser("arturk85");
        wordpressLoginPage.clickUserButton();
        wordpressLoginPage.enterPass("R0l@dm2011");
        wordpressLoginPage.clickPassButton();

        wordpressMainUserPage = new WordpressMainUserPage(driver);
        assertTrue(wordpressMainUserPage.avatar.isDisplayed());
        wordpressMainUserPage.clickAvatar();

        wordpressMyProfilePage = new WordpressMyProfilePage(driver);
        wordpressMyProfilePage.getProfileName();
        wordpressMyProfilePage.clickLogOutButton();


    }

    public void moveToLoginPage(){
        driver.get("https://wordpress.com/");
        wordpressMainPage = new WordpressMainPage(driver);
        wordpressMainPage.clickLogInButton();
    }

    public void moveToMainUserPage(){
        wordpressLoginPage = new WordpressLoginPage(driver);
        wordpressLoginPage.enterUser("arturk85");
        wordpressLoginPage.clickUserButton();
        wordpressLoginPage.enterPass("R0l@dm2011");
        wordpressLoginPage.clickPassButton();
    }

    public void moveToMyProfilePage(){
        wordpressMainUserPage = new WordpressMainUserPage(driver);
        assertTrue(wordpressMainUserPage.avatar.isDisplayed());
        wordpressMainUserPage.clickAvatar();
    }

    @Test
    public void notificationTest(){
        moveToLoginPage();
        moveToMainUserPage();
        moveToMyProfilePage();
        wordpressMyProfilePage = new WordpressMyProfilePage(driver);
        wordpressMyProfilePage.clickSideMenuNotifications();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
