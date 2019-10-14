package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class InitializeWebDriver {
    private static WebDriver _webDriver;

    public static WebDriver getWebDriver() {
        return _webDriver;
    }

    private static void setWebDriver(WebDriver webDriver) {
       _webDriver = webDriver;
    }



    public static void initializeChromeDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        setWebDriver(new ChromeDriver());
        _webDriver.manage().window().maximize();
        _webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        _webDriver.get(url);
    }

    public static void quitChromeDriver() {
       _webDriver.close();
       _webDriver.quit();
    }

}
