package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateNewBoardPage;
import pages.CreatedBoardPage;
import pages.MainPage;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoard extends SignInTest {
    MainPage mainPage;
    UserInfoPage userInfoPage;
    CreateNewBoardPage createNewBoardPage;
    CreatedBoardPage createdBoardPage;

    @BeforeTest
    @Parameters ({"path", "login", "password"})
    public void signIn(String path, String login, String password) {
        driver.get(path);
        firstForm(login, password);
        secondForm(login, password);
        mainPage = PageFactory.initElements(driver, MainPage.class);
        userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
        createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
    }

    @Test
    @Parameters({"boardName", "boardDescription"})
    public void createNewBoard(String boardName, String boardDescription) {
        mainPage.clickOnUserButton();
        userInfoPage.createNewBoard();
        createNewBoardPage.createNewBoard(boardName, boardDescription);
        createdBoardPage.clickOnEditBoard();
        Assert.assertEquals(createNewBoardPage.getBorderName(), boardName);
        Assert.assertEquals(createNewBoardPage.getBorderDescription(), boardDescription);
    }
}
