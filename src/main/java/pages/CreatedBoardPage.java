package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreatedBoardPage extends Page{

    @FindBy(css = ".boardName")
    public WebElement boardName;

    @FindBy(css = ".boardEditButton")
    public WebElement boardEditButton;

    @FindBy(css = ".NavigateButton")
    public WebElement navigateButton;

    public CreatedBoardPage(WebDriver driver) {
        super(driver);
    }


    public CreateNewBoardPage clickEditBoard() {
        boardEditButton.click();
        return PageFactory.initElements(driver, CreateNewBoardPage.class);
    }

    public MainPage backToMainPage(){
        navigateButton.click();
        return PageFactory.initElements(driver, MainPage.class);
    }

}
