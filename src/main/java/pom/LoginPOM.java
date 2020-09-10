package pom;

import utilities.SingletonWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM extends ParentPOM {

    WebElement myElement;

    public LoginPOM() {

        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }


    @FindBy(css = "a[class='login']")
    private WebElement sign_in_button;

    @FindBy(css = "input[id='email']")
    private WebElement sign_in_email;


    @FindBy(css = "input[id='passwd']")
    private WebElement sign_in_password;

    @FindBy(id = "SubmitLogin")
    private WebElement submit_sign_in_button;

    public void findElementAndClickFunction(String ElementName) {

        switch (ElementName) {
            case "sign_in_button":
                myElement = sign_in_button;
                break;
            case "submit_sign_in_button":
                myElement = submit_sign_in_button;
                break;

        }
        waitScrollClick(myElement);
    }

    public void findElementAndSendKeyFunction(String ElementName, String value) {

        switch (ElementName) {
            case "sign_in_email":
                myElement = sign_in_email;
                break;
            case "sign_in_password":
                myElement = sign_in_password;
                break;
        }
        sendKeysFunction(myElement, value);
    }


}
