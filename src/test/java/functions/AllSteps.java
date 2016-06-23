package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SignInForm;
import ru.yandex.qatools.allure.annotations.Step;
import utils.SikuliImageRecognition;

public class AllSteps {
    WebDriver driver;

    public AllSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Sign In")
    public void signingInPinterest() {
        SignInForm signInForm = PageFactory.initElements(driver, SignInForm.class);
        signInForm = new SignInForm(driver);
        signInForm.fillUserEmail("horuk.at15@gmail.com");
        signInForm.fillPassword("horuk.at15horuk.at15");
        SikuliImageRecognition imageRecognition = new SikuliImageRecognition();
        imageRecognition.clickOnSignInButton("functions.SignInTest.png");
    }

}
