package functions.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.MainPage;
import pages.SignInForm;
import pages.UserInfoPage;

/*******************************************************************************
 * (C) Copyright Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class UserSettingsPage extends SignInTest {

	SignInForm signInForm;
	UserInfoPage userInfoPage;
	MainPage mainPage;

	@BeforeTest
	@Parameters({ "path", "login", "password" })
	public void login(String path, String login, String password) {
		driver.get(path);
		firstForm(login, password);
		secondForm(login, password);
		mainPage = PageFactory.initElements(driver, MainPage.class);

	}

	@Test
	@Parameters({ "title" })
	public void verifyTitle(String title) {
		userInfoPage = PageFactory.initElements(driver, UserInfoPage.class);
		Assert.assertEquals(userInfoPage.getTitle(), title);
		Assert.assertTrue(userInfoPage.isEditButtonDisplayed());
	}

}
