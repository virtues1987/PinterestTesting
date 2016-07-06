package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreatedBoardPage extends Page{

    @FindBy(css = ".boardName")
    public WebElement boardName;

    @FindBy(css = ".boardEditButton")
    public WebElement boardEditButton;

    public CreatedBoardPage(WebDriver driver) {
        super(driver);
    }


    public void clickEditBoard() {
        boardEditButton.click();
    }
}
