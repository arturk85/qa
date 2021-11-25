package pl.jsystems.qa.qagui.bdd.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressMainUserPage extends BasePage {

    public WordpressMainUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".masterbar__item.masterbar__item-me")
    public WebElement avatar;
//    public WebElement avatar = driver.findElement(By.cssSelector(".masterbar__item.masterbar__item-me"));

    public void clickAvatar(){
        click(this.avatar, 5);
    }
}
