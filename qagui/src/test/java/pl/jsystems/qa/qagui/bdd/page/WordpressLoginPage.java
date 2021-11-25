package pl.jsystems.qa.qagui.bdd.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressLoginPage extends BasePage {

    public WordpressLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    private static final String FORM_ACTION_BUTTON = "login__form-action";

    @FindBy(id = "usernameOrEmail")
    public WebElement userLogInput;
//    public WebElement userLogInput = driver.findElement(By.id("usernameOrEmail"));
    @FindBy(className = FORM_ACTION_BUTTON)
    public WebElement userContinueButton;
//    public WebElement userContinueButton = driver.findElement(By.className("login__form-action"));
    @FindBy(id = "password")
    public WebElement passLogInput;
//    public WebElement passLogInput = driver.findElement(By.id("password"));
    @FindBy(className = FORM_ACTION_BUTTON)
    public WebElement passContinueButton;
//    public WebElement passContinueButton = driver.findElement(By.className("login__form-action"));

    public void enterUser(String userName){
        waitForElement(By.id("usernameOrEmail"),3);
        this.userLogInput.click();
        this.userLogInput.clear();
        this.userLogInput.sendKeys(userName);
    }

    public void enterPass(String pass){
        waitForElement(By.id("password"),3);
        this.passLogInput.click();
        this.passLogInput.clear();
        this.passLogInput.sendKeys(pass);
    }

    public void clickUserButton(){
        click(userContinueButton,3);
    }

    public void clickPassButton(){
        click(passContinueButton,3);
    }
}
