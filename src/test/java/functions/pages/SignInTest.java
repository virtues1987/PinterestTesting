package functions.pages;

import functions.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SecondVerificationForm;
import pages.SignInForm;

public class SignInTest extends TestBase {

    SignInForm signInForm;
    SecondVerificationForm secondVerificationForm;

    @BeforeTest
    @Parameters({"path"})
    public void signIn(String path) {
        driver.get(path);
        signInForm = PageFactory.initElements(driver, SignInForm.class);
        secondVerificationForm = PageFactory.initElements(driver, SecondVerificationForm.class);
    }

    @Test
    @Parameters({"login", "password"})
    public void firstForm(String login, String password) {
        signInForm.fillFirstSignInForm(login, password);
    }

    @Test
    @Parameters({"login", "password"})
    public void secondForm(String login, String password) {
        secondVerificationForm.fillSecondSignInForm(login, password);
    }
}