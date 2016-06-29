package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class UserInfoPage {
    WebDriver driver;

    public UserInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "div.Module.UserProfileContent div span")
    public WebElement createBoardButton;

    @Step("Create new board")
    public CreateNewBoardPage createNewNoard(){
        createBoardButton.click();
        return new CreateNewBoardPage(this.driver);
    }
}
