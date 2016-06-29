package functions.pages;

import functions.AllSteps;
import functions.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class CreateNewBoard extends TestBase{
    @Title("Test creates New Board")
    @Parameters({"boardName", "boardDescription", "categoryNumber"})
    @Test
    public void createBoard(){
        new AllSteps(driver).createNewBoard("Some name", "Some description", 22);
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.App.AppBase.Module.content_only.unauth form")));
    }
}


