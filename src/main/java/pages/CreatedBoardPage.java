package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreatedBoardPage extends Page{

    @FindBy(css = ".boardName")
    public WebElement boardName;

    @FindBy(css = ".boardEditButton")
    public WebElement boardEditButton;

    @FindBy(css = ".NavigateButton .accessibilityText")
    public WebElement navigateButton;

    public CreatedBoardPage(WebDriver driver) {
        super(driver);
    }


    public CreateNewBoardPage clickEditBoard() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".boardEditButton")));
        boardEditButton.click();
        return PageFactory.initElements(driver, CreateNewBoardPage.class);
    }

    public MainPage backToMainPage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".NavigateButton .accessibilityText")));
        Actions actions = new Actions(driver);
        actions.moveToElement(navigateButton).click().perform();
//        navigateButton.click();
        return PageFactory.initElements(driver, MainPage.class);
    }

}
