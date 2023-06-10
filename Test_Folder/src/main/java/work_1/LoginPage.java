package work_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input(@classname = 'login_field')")
    private WebElement emailField;

    @FindBy(xpath = "//input(@classname = 'password_field')")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text() = 'Log In']")
    private WebElement buttonOk;

    @FindBy(xpath = "//div[@class = '_7Fcq2' and text() = 'Invalid email']")
    private WebElement emailMassage;

    public void loginAccaunt(String email,String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }
    public void buttonClick(){
        buttonOk.click();
    }
    public boolean isDisplayedErorMassage(){
        return emailMassage.isDisplayed();
    }
}
