package work_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    public StartPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text() = 'Sign In']")
    private WebElement loginButton;

    public void clickOnLoginButton(){loginButton.click();}
}
