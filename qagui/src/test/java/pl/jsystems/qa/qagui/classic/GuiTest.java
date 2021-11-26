package pl.jsystems.qa.qagui.classic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.jsystems.qa.qagui.classic.page.WordpressLoginPage;
import pl.jsystems.qa.qagui.classic.page.WordpressMainPage;
import pl.jsystems.qa.qagui.classic.page.WordpressMainUserPage;
import pl.jsystems.qa.qagui.classic.page.WordpressMyProfilePage;

import java.time.Duration;

import static com.google.common.truth.Truth.assertThat;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.jsystems.qa.qagui.GuiConfig.*;

@Tags({@Tag("Frontend"),@Tag("wordpress")})
@DisplayName("Frontend test")
public class GuiTest extends GuiConfiguration {

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
//        driver.get("https://wordpress.com/");
        driver.get(BASE_URL);
        wordpressMainPage = new WordpressMainPage(driver);
        wordpressMainPage.clickLogInButton();

        wordpressLoginPage = new WordpressLoginPage(driver);
//        wordpressLoginPage.enterUser("arturk85");
        wordpressLoginPage.enterUser(LOGIN);
        wordpressLoginPage.clickUserButton();
//        wordpressLoginPage.enterPass("R0l@dm2011");
        wordpressLoginPage.enterPass(PSWD);
        wordpressLoginPage.clickPassButton();

        wordpressMainUserPage = new WordpressMainUserPage(driver);
        assertTrue(wordpressMainUserPage.avatar.isDisplayed());
        wordpressMainUserPage.clickAvatar();

        wordpressMyProfilePage = new WordpressMyProfilePage(driver);
        wordpressMyProfilePage.getProfileName();
        wordpressMyProfilePage.clickLogOutButton();


    }

    public void moveToLoginPage(){
        driver.get(BASE_URL);
//        driver.get("https://wordpress.com/");
        wordpressMainPage = new WordpressMainPage(driver);
        wordpressMainPage.clickLogInButton();
    }

    public void moveToMainUserPage(){
        wordpressLoginPage = new WordpressLoginPage(driver);
        wordpressLoginPage.enterUser(LOGIN);
//        wordpressLoginPage.enterUser("arturk85");
        wordpressLoginPage.clickUserButton();
        wordpressLoginPage.enterPass(PSWD);
//        wordpressLoginPage.enterPass("R0l@dm2011");
        wordpressLoginPage.clickPassButton();
    }

    public void moveToMyProfilePage(){
        wordpressMainUserPage = new WordpressMainUserPage(driver);
        assertTrue(wordpressMainUserPage.avatar.isDisplayed());
        wordpressMainUserPage.clickAvatar();
    }

    @Tag("notification")
    @Test
    public void notificationTest(){
        moveToLoginPage();
        moveToMainUserPage();
        moveToMyProfilePage();
        wordpressMyProfilePage = new WordpressMyProfilePage(driver);
//        wordpressMyProfilePage.clickSideMenuNotifications();

    }

    @Disabled
    @DisplayName("Keys short")
    @Test
    public void kaysInteraction() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.chord(Keys.CONTROL, "R")).perform();
        action.sendKeys(Keys.chord(Keys.ESCAPE)).perform();
        action.sendKeys(Keys.chord(Keys.ENTER)).perform();


    }

    @Disabled
    @DisplayName("Simple action")
    @Test
    public void actionTest() {
        driver.navigate().to("https://wordpress.com");
        wordpressMainPage = new WordpressMainPage(driver);

        Actions action = new Actions(driver);

//        action.moveToElement(wordpressMainPage.picture)
//                .clickAndHold()
//                .moveToElement(wordpressMainPage.startYourWebsite)
//                .release();
//        action.build().perform();
//
//        action.moveToElement(wordpressMainPage.logIn)
//                .click();
//        action.build().perform();



    }

    @Disabled
    @DisplayName("scroll")
    @Test
    public void pageScroll() {

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.navigate().to(contactUrl);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in the same window")));

        int hyperlinkYCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getY();
        int hyperlinkXCoordinate = driver.findElement(By.linkText("Open page in the same window")).getLocation().getX();



        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");


        (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in the same window")));

        driver.findElement(By.linkText("Open page in the same window")).click();
    }

    @Disabled
    @Test
    void scrollIntoView(){
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        JavascriptExecutor je = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_9_container\"]/ul/li[4]/img"));

        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Disabled
    @DisplayName("alert")
    @Test
    public void popupHandler() {
        driver.switchTo().alert();
        driver.findElement(By.id("userId")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().defaultContent();

        String pageId = driver.getWindowHandle();
        driver.switchTo().window(pageId);

        String title = driver.getTitle();
        assertThat(title).isEqualTo("title");
    }

    @Disabled
    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";
        driver.get(contactUrl);
        new WebDriverWait(driver, 10)

                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = driver.findElement(By.name("testframe"));

        driver.switchTo().frame(testframe);

        String expectedFrameText = driver.findElement(By.id("testpagelink")).getText();

        String actualFrameText = "My frame text";
        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        driver.switchTo().parentFrame();
    }

}
