package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class MainPage extends Page{
    @FindBy(css = ".usernameLink")
    public WebElement userButton;
    @FindBy(css = ".ShowModalButton")
    public List<WebElement> saveButtons;
    @FindBy(css = ".pinitLocalization")
    public List<WebElement> pinitLocalization;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on UserNameLink")
    public UserInfoPage clickOnUserButton() {
        userButton.click();
        return new UserInfoPage(this.driver);
    }

    @Step("Save button")
    public void clickOnSaveToBoard(int index) {
        saveButtons.get(index).click();
        pinitLocalization.get(index).click();
    }

    @Step("Check toast message")
    public boolean toastIsDisplayed(){
        WebElement toastMessage = driver.findElement(By.cssSelector(".Toasts"));
        if (!toastMessage.isDisplayed()){
            return true;
        } else {
            return false;
        }
    }
}

