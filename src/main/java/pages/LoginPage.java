package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webdriver.InitializeWebDriver;


public class LoginPage {
    private By _login_locator;
    private By _pass_locator;
    private By _enterPassButton_locator;
    private By _loginButton_locator;

    public LoginPage(){
        _login_locator = new By.ById("mailbox:login");
        _pass_locator = new By.ById("mailbox:password");
        _enterPassButton_locator = new By.ById("mailbox:submit");
        _loginButton_locator = new By.ById("mailbox:submit");

    }

    /***
     * Вводим логин
     * @param login
     * @return
     */
    public LoginPage enterLogin(String login){
        InitializeWebDriver.getWebDriver().findElement(_login_locator).sendKeys(login);
        return this;
    }

    /***
     * Нажать кнопку "Ввести пароль"
     * @return
     */
    public LoginPage enterPassButtonClick(){
        InitializeWebDriver.getWebDriver().findElement(_enterPassButton_locator).click();
        return this;
    }

    /***
     * Ввести пароль
     * @param pass
     * @return
     */
    public LoginPage enterPass(String pass){
        InitializeWebDriver.getWebDriver().findElement(_pass_locator).sendKeys(pass);
        return this;
    }

    /***
     * Нажать кнопку "Войти"
     * @return
     */
    public MailPage loginButtonClick(){
        InitializeWebDriver.getWebDriver().findElement(_loginButton_locator).click();
        return new MailPage();
    }

}
