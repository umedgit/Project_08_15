package steps;

import pom.SocialNetworksPOM;
import cucumber.api.java.en.And;

public class SocialNetSteps {
    SocialNetworksPOM socialNetworksPOM = new SocialNetworksPOM();

        @And("^Click on \"([^\"]*)\" and verify \"([^\"]*)\"$")
        public void clickOnAndVerify(String socialNetwork, String url) {

                socialNetworksPOM.findElementAndClick(socialNetwork);
                socialNetworksPOM.switchWindow();
                socialNetworksPOM.verifyURLContainsText(url);
    }
}
