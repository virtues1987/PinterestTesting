package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.*;
import ru.yandex.qatools.allure.annotations.Step;

public class AllSteps {
    WebDriver driver;

    public AllSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Fill forms: User name \"{0}\" , Password \"{1}\".")
    public void signingInPinterest(String email, String password) {
            SignInForm signInForm = PageFactory.initElements(driver, SignInForm.class);
            signInForm.fillUserEmail(email);
            signInForm.fillPassword(password);
            signInForm.clickSubmit();
            SecondVerificationForm secondVerificationForm = PageFactory.initElements(driver, SecondVerificationForm.class);
            secondVerificationForm.fillUserEmail(email);
            secondVerificationForm.fillPassword(password);
            secondVerificationForm.clickSubmit();
    }

    @Step("Create new Board")
    public void createNewBoard(String boardName, String boardDescription, String value) {
        try {
            MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
            mainPage.clickOnUserButton();
            UserInfoPage userInfo = PageFactory.initElements(driver, UserInfoPage.class);
            userInfo.createNewBoard();
            CreateNewBoardPage createNewBoard = PageFactory.initElements(driver, CreateNewBoardPage.class);
            createNewBoard.setBoardName(boardName);
            createNewBoard.setBoardDescription(boardDescription);
            createNewBoard.choseEducationCategory(value);
            createNewBoard.chosePrivateStatus();
            createNewBoard.saveBoard();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("Checking new board")
    public void checkNewBoard(String expectedBoardName, String expectedBoardDescription, String expectedBoardCategory) {
        try {
            CreatedBoardPage createdBoardPage = PageFactory.initElements(driver, CreatedBoardPage.class);
            createdBoardPage.clickOnEditBoard();
            CreateNewBoardPage createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
            String actualBoardName = createNewBoardPage.boardEditName.getAttribute("value");
            Assert.assertEquals(actualBoardName, expectedBoardName);
            String actualBoardDescription = createNewBoardPage.boardEditDescription.getText();
            Assert.assertEquals(actualBoardDescription, expectedBoardDescription);
            String actualBoardCategory = createNewBoardPage.categoriesSelect.findElement(By.cssSelector("[selected='selected']")).getText();
            Assert.assertEquals(actualBoardCategory, expectedBoardCategory);
            Boolean actualStatus = createNewBoardPage.chosePrivateStatus();
            Assert.assertTrue(actualStatus);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

/*    public void removeBoard() {
        CreateNewBoardPage createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
        createNewBoardPage.deleteBoard();
    }*/

    @Step("Search for immages and pinn to board")
    public void searchAndPinImagesToBoard(int index) {
        UserInfoPage userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
        userInfoPage.backToMainPage();
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickOnSaveToBoard(index);
        Boolean toastIsDisplayed = mainPage.toastIsDisplayed();
        Assert.assertTrue(toastIsDisplayed);
    }
}
