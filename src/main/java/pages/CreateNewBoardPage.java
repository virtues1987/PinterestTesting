package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoardPage extends Page{
    @FindBy(css = "#boardEditName")
    public WebElement boardEditName;
    @FindBy(css = "#boardEditDescription")
    public WebElement boardEditDescription;
    @FindBy(css = "[name='category']")
    public WebElement categoriesSelect;
    @FindBy(css = ".slider")
    private WebElement setBoardPrivate;

    @FindBy(css = ".saveBoardButton")
    private WebElement saveBoardButton;

    @FindBy(css = ".cancelButton")
    private WebElement cancelButton;

    public CreateNewBoardPage(WebDriver driver) {
        super(driver);
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
    public Boolean chosePrivateStatus() {
        if (setBoardPrivate.isDisplayed()) {
            setBoardPrivate.click();
            return true;
        } else {
            return false;
        }
    }

    @Step("Save board")
    public CreatedBoardPage saveBoard() {
        saveBoardButton.click();
        return PageFactory.initElements(driver, CreatedBoardPage.class);
    }

    @Step("Remove board")
    public UserInfoPage deleteBoard() {
        WebElement deleteBoardButton = driver.findElement(By.cssSelector(".deleteBoardButton"));
        if (deleteBoardButton.isDisplayed()){
            deleteBoardButton.click();
            new WebDriverWait(driver,3).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".standardForm")));
            WebElement confirmDeletion = driver.findElement(By.cssSelector(".confirm"));
            confirmDeletion.click();
            return PageFactory.initElements(driver, UserInfoPage.class);
        }
        return null;
    }

    @Step("Create New Board")
    public CreatedBoardPage createNewBoard(String boardName, String boardDescription){
        setBoardName(boardName);
        setBoardDescription(boardDescription);
        chosePrivateStatus();
        saveBoard();
        return PageFactory.initElements(driver, CreatedBoardPage.class);
    }

    @Step("Get border Name")
    public String getBorderName(){
        return boardEditName.getAttribute("value");
    }

    @Step("Get border Description")
    public String getBorderDescription() {
        return boardEditDescription.getAttribute("value");
    }

    @Step("Cancel creating / editing")
    public CreatedBoardPage cancelCreateEdit(){
        cancelButton.click();
        return PageFactory.initElements(driver, CreatedBoardPage.class);
    }
}
