package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class UserInfoPage extends Page{

    @FindBy(css = "div.Module.UserProfileContent div span")
    public WebElement createBoardButton;

    @FindBy(css = ".NavigateButton")
    public WebElement navigateButton;

    public UserInfoPage(WebDriver driver) {
        super(driver);
    }


    @Step("Create new board")
    public CreateNewBoardPage createNewBoard(){
        createBoardButton.click();
        return new CreateNewBoardPage(this.driver);
    }

    @Step("Back to Main Page")
    public MainPage backToMainPage(){
        navigateButton.click();
        return new MainPage(this.driver);
    }
}
