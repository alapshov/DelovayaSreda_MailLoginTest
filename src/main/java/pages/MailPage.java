package pages;

import org.openqa.selenium.By;
import webdriver.InitializeWebDriver;

public class MailPage {
    private By _composeLocator;
    private By _mailBoxErrorLocator;

    public  MailPage(){
        _composeLocator = new By.ByXPath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span/span");
        _mailBoxErrorLocator = new By.ById("mailbox:error");
    }

    public MailPage findCompose(){
        InitializeWebDriver.getWebDriver().findElement(_composeLocator);
        return this;
    }

    public MailPage findMailBoxError(){
        InitializeWebDriver.getWebDriver().findElement(_mailBoxErrorLocator);
        return this;
    }

    public String getMailBoxErrorText(){
        return InitializeWebDriver.getWebDriver().findElement(_mailBoxErrorLocator).getText();
    }

}
