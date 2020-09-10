package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SingletonWebDriver {

    private static WebDriver driver;
    private static String browser;


    public void setBrowser(String browser){
        this.browser = browser;

    }

    public static WebDriver getDriver() {

//        if(driver==null){
//            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver();
//
//        }

        if (driver == null) {
            switch (browser) {
                default:
                    WebDriverManager.chromedriver().setup(); // this line is for System.setproperty
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup(); // this line is for System.setproperty
                    driver = new FirefoxDriver();
                    break;
            }

        } return driver;
    }


    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
