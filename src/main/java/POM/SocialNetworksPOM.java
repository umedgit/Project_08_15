package POM;

import Utilities.SingletonWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialNetworksPOM extends ParentPOM {

    WebElement myElement;

    public SocialNetworksPOM() {
        PageFactory.initElements(SingletonWebDriver.getDriver(), this);
    }

    @FindBy(xpath = "//section[@id='social_block']//li[1]")
    private WebElement facebook;
    @FindBy(xpath = "//section[@id='social_block']//li[2]")
    private WebElement twitter;
    @FindBy(xpath = "//section[@id='social_block']//li[3]")
    private WebElement youtube;
    @FindBy(xpath = "//section[@id='social_block']//li[4]")
    private WebElement google;


    public void findElementAndClick(String element) {
        switch (element) {
            case "facebook":
                myElement = facebook;
                break;
            case "twitter":
                myElement = twitter;
                break;
            case "youtube":
                myElement = youtube;
                break;
            case "google":
                myElement = google;
                break;
        }
        waitScrollClick(myElement);
    }



}
