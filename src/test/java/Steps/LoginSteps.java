package Steps;

import POM.LoginPOM;
import Utilities.SingletonWebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class LoginSteps {
    LoginPOM loginPOM = new LoginPOM();
    private static List<String> info_to_check = new ArrayList<>();

    WebDriver driver;

    @Given("^Navigate to http://automationpractice\\.com/$")
    public void navigate_to_http_automationpractice_com()  {
        driver = SingletonWebDriver.getDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

    }

    @And("^Click on sign in button$")
    public void click_on_sign_in_button(){
        loginPOM.findElementAndClickFunction("sign_in_button");
    }

    @When("^Enter the username and password and click on login button$")
    public void enter_the_username_and_password_and_click_on_login_button(){
        loginPOM.findElementAndSendKeyFunction("sign_in_email", "furkat@gmail.com");
        loginPOM.findElementAndSendKeyFunction("sign_in_password", "furkat123");
        loginPOM.findElementAndClickFunction("submit_sign_in_button");
    }

    @Then("^User should login successfully$")
    public void user_should_login_successfully() {
        loginPOM.verifyURLContainsText("http://automationpractice.com/index.php?controller=my-account");
    }


}
