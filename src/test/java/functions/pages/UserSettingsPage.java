package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateNewBoardPage;
import pages.CreatedBoardPage;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class UserSettingsPage extends CreateNewBoard{
    UserInfoPage userInfoPage;
    CreatedBoardPage createdBoardPage;

    @Test
    @Parameters({"path"})
    public void userSettingsPagPageInit(String path){
        driver.get(path);
        userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
        createNewBoardPage = PageFactory.initElements(driver, CreateNewBoardPage.class);
    }

    @Test
    @Parameters({"boardName", "boardDescription"})
    public void checkCreatedBoard(String boardName, String boardDescription){
        createdBoardPage.clickEditBoard();
        Assert.assertEquals(createNewBoardPage.getBorderName(), boardName);
        Assert.assertEquals(createNewBoardPage.getBorderDescription(), boardDescription);
    }
}
