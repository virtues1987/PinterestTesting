package functions.pages;

import functions.AllSteps;
import functions.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class SearchForImagesAndPinToBoard extends TestBase{
    @Title("Test creates New Board")
    @Test
    public void searchAndPinImagesToBoard(){
        new AllSteps(driver).signingInPinterest("horuk.at15@gmail.com", "horuk.at15horuk.at15");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".Input.Module.field")));
        new AllSteps(driver).createNewBoard("Some name", "Some description", "education");
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".boardName")));
    }
}
