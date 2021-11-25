package pl.jsystems.qa.qagui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressMyProfilePage extends BasePage{
    public WordpressMyProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    private static final String PROFILE_DISPLAY_NAME = "profile-gravatar__user-display-name";

    @FindBy(className = PROFILE_DISPLAY_NAME)
    public WebElement profileName;
//    public WebElement profileName = driver.findElement(By.className("profile-gravatar__user-display-name"));
    @FindBy(css = "button[title=\"Log out of WordPress.com\"]")
    public WebElement logOutButton;
//    public WebElement logOutButton = driver.findElement(By.cssSelector("button[title=\"Log out of WordPress.com\"]"));

    @FindBy(css = "a[href=\"/me/notifications\"]")
    public WebElement notificationSideMenu;

    public String getProfileName(){
        waitForElement(By.className(PROFILE_DISPLAY_NAME),5);
        return "";
    }

    public void clickLogOutButton(){
        click(logOutButton,5);
    }

    public void clickSideMenuNotifications(){
        click(notificationSideMenu,3);
    }
}
