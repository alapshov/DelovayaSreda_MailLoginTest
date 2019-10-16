package pages;

import org.openqa.selenium.By;
import webdriver.InitializeWebDriver;


public class LoginPage {
    private By _login_locator;
    private By _pass_locator;
    private By _enterPassButton_locator;
    private By _loginButton_locator;
    private By _mailBoxErrorLocator;

    public LoginPage(){
        _login_locator = new By.ById("mailbox:login");
        _pass_locator = new By.ById("mailbox:password");
        _enterPassButton_locator = new By.ById("mailbox:submit");
        _loginButton_locator = new By.ById("mailbox:submit");
        _mailBoxErrorLocator = new By.ById("mailbox:error");
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
    public LoginPage loginButtonClick(){
        InitializeWebDriver.getWebDriver().findElement(_loginButton_locator).click();
        return this;
    }

    /***
     * Поиск сообщения с ошибкой
     * @return
     */
    public LoginPage findMailBoxError(){
        InitializeWebDriver.getWebDriver().findElement(_mailBoxErrorLocator);
        return this;
    }

    /***
     * Получаем сообщение с ошибкой
     * @return
     */
    public String getMailBoxErrorText() throws InterruptedException{

        String boxErrorText = "";
        for(int i=0; i<=10; i++){
            Thread.sleep(5000);
            boxErrorText = InitializeWebDriver.getWebDriver().findElement(_mailBoxErrorLocator).getText();
            if(boxErrorText != ""){
                break;
            }

        }
        return boxErrorText;
    }

}
