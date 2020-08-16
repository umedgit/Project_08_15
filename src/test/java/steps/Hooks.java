package steps;

import utilities.SingletonWebDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    //Runs Before and After Scenario

    @After // After each scenario
    public void after(Scenario scenario) {
        System.out.println("After scenario: " + scenario.getName());
        if (scenario.isFailed()) {

            Date timeStamp = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String dateInString = formatter.format(timeStamp);
  //          dateInString = dateInString.replace(":", " ");
            String scenarioName = scenario.getName().replaceAll(" ", "_");

            TakesScreenshot screeShot = ((TakesScreenshot) SingletonWebDriver.getDriver());
            File sourceFile = screeShot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("target/extent-report/screenshots/" + scenarioName + "_"
                    + dateInString + ".png");

            try {
                FileUtils.copyFile(sourceFile, destinationFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Reporter.addScreenCaptureFromPath("screenshots/" +
                        scenarioName +"_" + dateInString +".png");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        SingletonWebDriver.quitDriver();
    }
}
