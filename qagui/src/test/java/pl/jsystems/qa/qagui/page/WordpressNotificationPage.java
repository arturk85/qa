package pl.jsystems.qa.qagui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WordpressNotificationPage extends BasePage{
    public WordpressNotificationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

//    @FindBy
//    public WebElement
}
