package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoardPage {
    @FindBy(css = "#boardEditName")
    public WebElement boardEditName;
    @FindBy(css = "#boardEditDescription")
    public WebElement boardEditDescription;
    @FindBy(css = "[name='category']")
    public WebElement categoriesSelect;
    WebDriver driver;
    @FindBy(css = ".slider")
    private WebElement setBoardPrivate;

    @FindBy(css = ".saveBoardButton")
    private WebElement saveBoardButton;

    public CreateNewBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Set Name")
    public void setBoardName(String boardName) {
        boardEditName.clear();
        boardEditName.sendKeys(boardName);
    }

    @Step("Set Description")
    public void setBoardDescription(String boardDescription) {
        boardEditDescription.clear();
        boardEditDescription.sendKeys(boardDescription);
    }

    @Step("Chose Education category")
    public void choseEducationCategory(String value) {
        categoriesSelect.click();
        Select dropdown = new Select(driver.findElement(By.cssSelector("[name='category']")));
        dropdown.selectByValue(value);
        dropdown.getFirstSelectedOption().click();
    }

    @Step("Set board private")
    public void chosePrivateStatus() {
        setBoardPrivate.click();
    }

    @Step("Save board")
    public void saveBoard() {
        saveBoardButton.click();
    }
}

