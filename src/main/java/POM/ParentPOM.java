package POM;

import Utilities.SingletonWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class ParentPOM {

    WebDriver driver;
    WebDriverWait wait;

    public ParentPOM() {
        driver = SingletonWebDriver.getDriver();
        wait = new WebDriverWait(driver,10);
    }


    public void waitScrollClick(WebElement element){

        waitUntilClickable(element);
        scrollToElement(element);
        element.click();

    }


    public void sendKeysFunction(WebElement element , String value){

        waitUntilVisible(element);
        element.clear();
        element.sendKeys(value);

    }


    public void waitUntilVisible(WebElement elementToWait){

        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }


    public void waitUntilClickable(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyURLContainsText(String text){
        Assert.assertTrue(driver.getCurrentUrl().contains(text));
    }


    public void scrollToElement(WebElement elementToScroll){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elementToScroll);
    }

    public void switchWindow(){

        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String windowName:allWindows){
            driver.switchTo().window(windowName);
        }
    }

}
