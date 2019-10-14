import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class TestBase {
      public LoginPage loginPage ;

      public TestBase(){
          loginPage = new LoginPage();
      }

}
