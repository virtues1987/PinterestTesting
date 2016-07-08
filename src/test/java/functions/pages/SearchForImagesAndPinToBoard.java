package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SearchForImagesAndPinToBoard extends CreateNewBoard{
    UserInfoPage userInfoPage;
    MainPage mainPage;

    @Test
    public void MainMenuPageInit(){
        userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void addingPins(int index){
        userInfoPage.backToMainPage();
        mainPage.clickOnSaveToBoard(index);
        Assert.assertTrue(mainPage.clickOnSaveToBoard(index));
    }
}

