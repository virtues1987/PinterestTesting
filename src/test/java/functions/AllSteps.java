package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SecondVerificationForm;
import pages.SignInForm;
import ru.yandex.qatools.allure.annotations.Step;

public class AllSteps {
    WebDriver driver;

    public AllSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill forms: User name \"{0}\" , Password \"{1}\", image - \"{2}\"")
    public void signingInPinterest(String email, String password, String imageName) {
        SignInForm signInForm = PageFactory.initElements(driver, SignInForm.class);
        signInForm.fillUserEmail(email);
        signInForm.fillPassword(password);
        signInForm.clickSubmit();
        SecondVerificationForm secondVerificationForm = PageFactory.initElements(driver,SecondVerificationForm.class);
        secondVerificationForm.fillUserEmail(email);
        secondVerificationForm.fillPassword(password);
        secondVerificationForm.clickSubmit();

    }

}
