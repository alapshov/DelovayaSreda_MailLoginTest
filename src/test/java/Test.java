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
                .loginButtonClick()
                .findCompose();
    }

    @org.testng.annotations.Test
    @Parameters({"login","pass", "textErrorBox"})
    public void filedLoginOrAndPassTest(String login, String pass, String textErrorBox){
     String text =  loginPage
                .enterLogin(login)
                .enterPassButtonClick()
                .enterPass(pass)
                .loginButtonClick()
                .findMailBoxError()
                .getMailBoxErrorText();
        Assert.assertEquals(text, textErrorBox, "Не отображается текст с ошибкой");
    }


    @AfterClass
    public void tearDown(){
        InitializeWebDriver.quitChromeDriver();
    }

}
