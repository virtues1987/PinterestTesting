package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoardPage {

    @FindBy(css = "#boardEditName")
    public WebElement boardEditName;
    @FindBy(css = "#boardEditDescription")
    public WebElement boardEditDescription;
    @FindBy(css = ".CategoriesSelect")
    public WebElement categoriesSelect;
    JavascriptExecutor executor;
    WebDriver driver;
    @FindBys({
            @FindBy(css = "li.categoryWrapper option:nth-child(1)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(2)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(3)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(4)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(5)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(6)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(7)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(8)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(9)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(10)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(11)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(12)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(13)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(14)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(15)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(16)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(17)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(18)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(19)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(20)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(21)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(22)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(23)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(24)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(25)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(26)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(27)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(28)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(29)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(30)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(31)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(32)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(33)"),
            @FindBy(css = "li.categoryWrapper option:nth-child(34)")
    })
    private List<WebElement> categories;
    @FindBy(css = ".Checkbox.Module.fancyToggle.styledToggle")
    private WebElement setBoardPrivate;
    @FindBy(css = ".saveBoardButton")
    private WebElement saveBoardButton;

    public CreateNewBoardPage(WebDriver driver) {
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
    public void choseEducationCategory(int categoryNumber) {
        categoriesSelect.click();
        categories.get(categoryNumber);
    }

    @Step("Set board private")
    public void chosePrivateStatus() {
        if (!setBoardPrivate.isEnabled()) {
            setBoardPrivate.click();
        }
    }

    @Step("Save board")
    public void saveBoard() {
        saveBoardButton.click();
    }
}

