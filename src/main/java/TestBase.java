import pages.LoginPage;
import pages.MailPage;

public class TestBase {

      public LoginPage loginPage ;
      public MailPage mailPage;

    /**
     * Инициализируем классы страниц
     */
    public TestBase(){
          loginPage = new LoginPage();
          mailPage = new MailPage();
      }

}
