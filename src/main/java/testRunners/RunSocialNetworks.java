package testRunners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

import java.io.File;

@CucumberOptions (
        plugin = {"pretty",
                "html:target/cucumber-html-report",
                "com.cucumber.listener.ExtentCucumberFormatter:target/extent-report/ProjectExtentReport.html"},
        features = {"src/test/java/features"},
        glue ={"steps"},
        dryRun = false
)

public class RunSocialNetworks extends AbstractTestNGCucumberTests {

    @AfterClass
    public static void afterClass(){

//                Location of the xml file
        Reporter.loadXMLConfig(new File("src/test/java/features/extentReport.xml"));
        Reporter.setSystemInfo("Campus" , "New York");
        Reporter.setSystemInfo("Application Name", "Automationpractice.com");
        Reporter.setSystemInfo("Operating System Type" , System.getProperty("os.name"));
        Reporter.setSystemInfo("Environment", "QA");
        Reporter.setTestRunnerOutput("Test execution Cucumber report");
    }

}
