package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
        SecondVerificationForm secondVerificationForm = PageFactory.initElements(driver,SecondVerificationForm.class);
        secondVerificationForm.fillUserEmail(email);
        secondVerificationForm.fillPassword(password);
        secondVerificationForm.clickSubmit();
    }

    @Step("Create new Board")
    public void createNewBoard(String boardName, String boardDescription, String categoryText){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.clickOnUserButton();
        UserInfoPage userInfo = PageFactory.initElements(driver, UserInfoPage.class);
        userInfo.createNewNoard();
        CreateNewBoardPage createNewBoard = PageFactory.initElements(driver, CreateNewBoardPage.class);
        createNewBoard.setBoardName(boardName);
        createNewBoard.setBoardDescription(boardDescription);
        createNewBoard.choseEducationCategory(categoryText);
        createNewBoard.chosePrivateStatus();
        createNewBoard.saveBoard();
    }

}
