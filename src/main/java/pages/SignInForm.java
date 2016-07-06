package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SignInForm {


    WebDriver driver;

    public SignInForm(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "#userPassword")
    public WebElement userPassword;

    @FindBy(css = "#userEmail")
    public WebElement userEmail;

    @FindBy(css = "div.inspiredSearchDialog > button")
    public WebElement submit;


    @Step("Clear and fill user email")
    public void fillUserEmail(String email) {
        userEmail.clear();
        userEmail.sendKeys(email);
    }

    @Step("Clear and fill user password")
    public void fillPassword(String pass) {
        userPassword.clear();
        userPassword.sendKeys(pass);
    }

    @Step("Click on Submit button")
    public void clickSubmit() {
        submit.click();
    }

    @Step("Fill first sign-in form")
    public SecondVerificationForm fillFirstSignInForm(String email, String password){
        fillUserEmail(email);
        fillPassword(password);
        clickSubmit();
        return new SecondVerificationForm(this.driver);
    }
}
