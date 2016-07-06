package functions.pages;

import functions.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.SecondVerificationForm;
import pages.SignInForm;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SignInTest extends TestBase {

    SignInForm signInForm;
    SecondVerificationForm secondVerificationForm;

    @BeforeTest
    @Parameters({"path"})
    public void SignInPageInit(String path) {
        signInForm = PageFactory.initElements(driver, SignInForm.class);
        secondVerificationForm = PageFactory.initElements(driver, SecondVerificationForm.class);
    }

    public void firstForm(String login, String password) {
        signInForm.fillFirstSignInForm(login, password);
    }

    public void secondForm(String login, String password) {
        secondVerificationForm.fillSecondSignInForm(login, password);
    }
}