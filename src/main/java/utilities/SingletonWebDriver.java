package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonWebDriver {

    private static WebDriver driver;
    private static String browser;


    public static void setBrowser(String browserName) {
        if (browserName == null) {
            browser = "chrome";
        } else browser = browserName;
    }

    public static WebDriver getDriver() {

//        if(driver==null){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//
//        }

        if (driver == null) {
            if (browser == null) {
                setBrowser(null);
            }
            switch (browser) {

                case "firefox":
                    WebDriverManager.firefoxdriver().setup(); // this line is for System.setproperty
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup(); // this line is for System.setproperty
                    driver = new ChromeDriver();
                    break;
            }

        }
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
