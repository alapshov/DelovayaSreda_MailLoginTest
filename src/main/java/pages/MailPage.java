package pages;

import org.openqa.selenium.By;
import webdriver.InitializeWebDriver;

public class MailPage extends InitializeWebDriver {
    private By _composeLocator;


    public  MailPage(){
        _composeLocator = new By.ByXPath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div[1]/div[1]/div/span/span/span");

    }

    /***
     * По элементу в почтовом ящике определяем, что мы находимся на нужной странице
     * @return
     */
    public MailPage findCompose(){
        getWebDriver().findElement(_composeLocator);
        return this;
    }

}
