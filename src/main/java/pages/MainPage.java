package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".usernameLink")
    public WebElement userButton;

    @Step("Click on UserNameLink")
    public UserInfoPage clickOnUserButton(){
        userButton.click();
        return new UserInfoPage(this.driver);
    }
}
