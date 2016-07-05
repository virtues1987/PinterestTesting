package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreatedBoardPage {
    WebDriver driver;

    public CreatedBoardPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".boardName")
    public WebElement boardName;

    @FindBy(css = ".boardEditButton")
    public WebElement boardEditButton;

    public CreateNewBoardPage clickOnEditBoard() {
        boardEditButton.click();
        return new CreateNewBoardPage(this.driver);
    }
}
