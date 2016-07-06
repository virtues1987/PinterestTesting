package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateNewBoardPage;
import pages.MainPage;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoard extends SignInTest {
    CreateNewBoardPage createNewBoardPage;
    MainPage mainPage;
    UserInfoPage userInfoPage;

    @BeforeTest
    @Parameters ({"path", "login", "password"})
    public void createNewBoardPageInit(String path, String login, String password) {
        driver.get(path);
        firstForm(login, password);
        secondForm(login, password);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
        createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
    }

    @Test
    @Parameters({"boardName", "boardDescription"})
    public void createNewBoard(String boardName, String boardDescription) throws InterruptedException {
        mainPage.clickOnUserButton();
        userInfoPage.createNewBoard();
        createNewBoardPage.createNewBoard(boardName, boardDescription);
    }


}
