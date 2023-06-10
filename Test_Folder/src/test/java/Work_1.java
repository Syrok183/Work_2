import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import work_1.*;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;


public class Work_1 {

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    RegistationPage registationPage;
    StartPage startPage;
    ScreenshotUs screenshotUs;


    private String mySite = "https://prom.ua/";

    //Ініціалізація браузера
    @BeforeClass
    public void initDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    //Тест котрий перевіряє вхід до аккаунту
    @Test
    public void authUser() throws IOException, InterruptedException {
        String name = "TestUser", email = "Test12@gmail.com", password = "123456AA";
        String nameScreen = "NameScreen.png";
        driver.get(mySite);
        startPage = new StartPage(driver);
        startPage.clickOnLoginButton();
        loginPage.loginAccaunt(email,password);
        loginPage.buttonClick();
        //Перевірка кнопки після входу
        mainPage = new MainPage(driver);
        assertTrue(mainPage.isDisplayedButtonSignOut());
    }

    //Тест котрий перевіряє невірно введені данні
    @Test
    public void invalidMassageLogin() throws IOException, InterruptedException {
        String name = "TestUser", email = "Test12@gmail.com", password = "123456AA";
        String nameScreen = "NameScreen.png";
        driver.get(mySite);
        startPage = new StartPage(driver);
        startPage.clickOnLoginButton();
        loginPage.loginAccaunt(email,password);
        loginPage.buttonClick();
        //Перевірка кнопки після входу
        assertTrue(loginPage.isDisplayedErorMassage());
        screenshotUs = new ScreenshotUs();
        screenshotUs.ScreenshotUs(driver,"Eror massage");

    }



    //Дія після завершення тесту
    @AfterClass
    public void endTest(){
        // закриття браузера
        driver.quit();
    }

}