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
    @Parameters({"boardName", "boardDescription", "catValue"})
    @Test
    public void createBoard(){
        new AllSteps(driver).signingInPinterest("horuk.at15@gmail.com", "horuk.at15horuk.at15");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".Input.Module.field")));
        new AllSteps(driver).createNewBoard("Some name", "Some description", "education");
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".boardName")));
    }
}


