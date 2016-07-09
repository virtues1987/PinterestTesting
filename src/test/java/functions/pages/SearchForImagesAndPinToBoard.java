package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreatedBoardPage;
import pages.MainPage;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SearchForImagesAndPinToBoard extends CreateNewBoard{
    CreatedBoardPage createdBoardPage;
    MainPage mainPage;

    @Test
    public void MainMenuPageInit(){
        createdBoardPage = PageFactory.initElements(driver, CreatedBoardPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void addingPins(int index){
        createdBoardPage.backToMainPage();
        mainPage.clickOnSaveToBoard(index);
        Assert.assertTrue(mainPage.clickOnSaveToBoard(index));
    }
}

