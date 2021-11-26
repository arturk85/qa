package pl.jsystems.qa.qagui.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pl.jsystems.qa.qagui.bdd.page.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.jsystems.qa.qagui.GuiConfig.*;

public class LoginSteps {

    private WebDriver driver;
    WordpressMainPage wordpressMainPage;
    WordpressLoginPage wordpressLoginPage;
    WordpressMainUserPage wordpressMainUserPage;
    WordpressMyProfilePage wordpressMyProfilePage;
    WordpressNotificationPage wordpressNotificationPage;

    public LoginSteps(ConfigStep configStep){
        this.driver = configStep.setUpWebDriver();
    }


    @Given("User starts on main page")
    public void userStartsOnMainPage(){
        driver.get(BASE_URL);
        wordpressMainPage = new WordpressMainPage(driver);

    }

    @When("user logs to the user panel")
    public void userLogsToTheUserPanel() {
        wordpressMainPage.clickLogInButton();
        wordpressLoginPage = new WordpressLoginPage(driver);
        wordpressLoginPage.enterUser(LOGIN);
        wordpressLoginPage.clickUserButton();
        wordpressLoginPage.enterPass(PSWD);
        wordpressLoginPage.clickPassButton();
    }

    @Then("user can modify user profile")
    public void userCanModifyUserProfile() {
        wordpressMainUserPage = new WordpressMainUserPage(driver);
        //wordpressMainUserPage.clickAvatar();
        wordpressMyProfilePage = new WordpressMyProfilePage(driver);
        wordpressMainUserPage.clickAvatar();
        wordpressMyProfilePage.clickSideMenuNotifications();
        wordpressMainUserPage.clickAvatar();
        wordpressMyProfilePage.clickSideMenuNotifications();
        wordpressNotificationPage = new WordpressNotificationPage(driver);
        assertTrue(wordpressNotificationPage.commentNotificationCheckBox.isSelected());
        assertFalse(wordpressNotificationPage.saveSettingsButton.isEnabled());
        wordpressNotificationPage.commentNotificationCheckBox.click();

        assertFalse(wordpressNotificationPage.commentNotificationCheckBox.isSelected());
        assertTrue(wordpressNotificationPage.saveSettingsButton.isEnabled());

        wordpressNotificationPage.commentNotificationCheckBox.click();
        assertTrue(wordpressNotificationPage.commentNotificationCheckBox.isSelected());
        assertFalse(wordpressNotificationPage.saveSettingsButton.isEnabled());
    }
}
