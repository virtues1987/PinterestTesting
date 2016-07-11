package functions.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.CreatedBoardPage;
import pages.MainPage;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class UserSettingsPage extends CreateNewBoard {
	MainPage mainPage;
	UserInfoPage userInfoPage;
	
	 @BeforeTest
	    @Parameters({"path", "login", "password"})
	    public void createNewBoardPageInit(String path, String login, String password) {
	        driver.get(path);
	        firstForm(login, password);
	        secondForm(login, password);
	        mainPage = PageFactory.initElements(driver, MainPage.class);
	        userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
	 }
	 
	 @Test
	 public void testPage(){
		 Assert.assertEquals(userInfoPage.getTitle(), "Pinterest • The world’s catalog of ideas");
		 Assert.assertTrue(userInfoPage.isEditButtonDisplayed());
	 }
}
