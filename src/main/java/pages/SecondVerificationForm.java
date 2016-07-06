package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SecondVerificationForm extends Page{

    @FindBy(css = "li.loginPassword > input")
    public WebElement userPassword;

    @FindBy(css = "li.loginUsername > input")
    public WebElement userEmail;

    @FindBy(css = "div.mainContainer div.formFooter span")
    public WebElement submit;

    public SecondVerificationForm(WebDriver driver) {
        super(driver);
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

    @Step("Click on Submit button")
    public void clickSubmit() {
        submit.click();
    }

    public MainPage fillSecondSignInForm(String email, String password) {
        fillUserEmail(email);
        fillPassword(password);
        clickSubmit();
        return new MainPage(this.driver);
    }
}
