package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SignInForm {

    private static WebDriver driver;
    @FindBy(css = "#userPassword")
    public WebElement userPassword;

    @FindBy(css = "#userEmail")
    public WebElement userEmail;

    public SignInForm(WebDriver driver) {
        SignInForm.driver = driver;
    }

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
}
