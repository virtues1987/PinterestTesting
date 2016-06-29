package functions.pages;

import functions.AllSteps;
import functions.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class SignInTest extends TestBase {

    @Title("Test tries to login to Pinterest")
    @Parameters({"userName", "passWord", "expectedMessage"})
    @Test
    public void signIn() {
        new AllSteps(driver).signingInPinterest("horuk.at15@gmail.com", "horuk.at15horuk.at15", "SignIn.png");
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.App.AppBase.Module.content_only.unauth form")));
    }
}


