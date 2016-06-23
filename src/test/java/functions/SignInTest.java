package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class SignInTest{

    @Title("Test tries to login with different parameters")
    @Parameters({"userName", "passWord", "expectedMessage"})
    @Test
    public void signIn() {
        new AllSteps(driver).signingInPinterest();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("")));
    }
}


