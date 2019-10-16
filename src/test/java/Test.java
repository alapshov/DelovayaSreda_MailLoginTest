import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import webdriver.InitializeWebDriver;

public class Test extends TestBase{

    @BeforeClass
    public void setUp(){
        InitializeWebDriver.initializeChromeDriver("https://mail.ru/");
        InitializeWebDriver.getWebDriver().manage().window().maximize();

    }
    @org.testng.annotations.Test
    @Parameters({"login","pass"})
    public void successLoginAndPassTest(String login, String pass){
        loginPage
                .enterLogin(login)
                .enterPassButtonClick()
                .enterPass(pass)
                .loginButtonClick();

        mailPage
                .findCompose();
    }


    @org.testng.annotations.Test
    @Parameters({"login","pass", "textErrorBox"})
    public void filedOrEmptyLoginTest(String login, String pass, String textErrorBox) throws InterruptedException{
        loginPage
                .enterLogin(login)
                .enterPassButtonClick()
                .findMailBoxError();



        Assert.assertEquals(loginPage.getMailBoxErrorText(), textErrorBox, "Не правильный текст с ошибкой");
    }


    @org.testng.annotations.Test
    @Parameters({"login","pass", "textErrorBox"})
    public void filedOrEmptyPassTest(String login, String pass, String textErrorBox) throws InterruptedException{
        loginPage
                .enterLogin(login)
                .enterPassButtonClick()
                .enterPass(pass)
                .loginButtonClick()
                .findMailBoxError();



        Assert.assertEquals(loginPage.getMailBoxErrorText(), textErrorBox, "Не правильный текст с ошибкой");
    }


    @AfterClass
    public void tearDown(){
        InitializeWebDriver.quitChromeDriver();
    }

}
