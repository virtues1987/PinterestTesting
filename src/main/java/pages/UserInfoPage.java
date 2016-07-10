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
    
    @FindBy(xpath = ".//title")
    public WebElement title;
    
    @FindBy(xpath = ".//*[contains(@class, 'Button Module ShowModalButton btn editProfile hasText primary rounded')]")
    public WebElement editButton;

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
    
	public boolean isEditButtonDisplayed() {
		try {
			return editButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
    	
    
  
    
/*    @Step("Check existing board")
    public void checkExistingBoard(){
        try {
            WebElement alreadyCreatedBoard = driver.findElement(By.cssSelector("*[href='/horukat15/some-name/']"));
            if(alreadyCreatedBoard.isDisplayed()){
                driver.findElement(By.cssSelector(".boardEditButton")).click();
                CreateNewBoardPage createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
                createNewBoardPage.deleteBoard();
            }
        } catch (NoSuchElementException e){
            e.printStackTrace();
            throw new RuntimeException("board list is empty");
        }
    }*/

}
