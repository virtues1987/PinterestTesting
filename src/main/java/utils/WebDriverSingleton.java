package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by 3aecb on 23.Jun.16.
 */
public class WebDriverSingleton {

    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
