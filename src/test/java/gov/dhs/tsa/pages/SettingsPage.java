package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SettingsPage extends PageObject {

    @FindBy(id="my-location")
    public WebElementFacade myLocation;

    @FindBy(id="other-locations")
    public WebElementFacade otherLocations;

    @FindBy(id="font-size")
    public WebElementFacade fontSize;

    @FindBy(id="terms-conditions")
    public WebElementFacade termsConditions;

    @FindBy(id="about-tsanews")
    public WebElementFacade aboutTSANEWS;

    @FindBy(id="feedback")
    public WebElementFacade feedBack;

    @FindBy(id="log-out")
    public WebElementFacade logOut;

    public void verifyPage() {
        List<WebElementFacade> settings = Arrays.asList(myLocation, otherLocations, fontSize, termsConditions, aboutTSANEWS, feedBack, logOut);
        for (WebElementFacade setting: settings
             ) {
            assertThat(setting.isCurrentlyEnabled());
            assertThat(setting.isCurrentlyVisible());
        }
    }

    public void selectMyLocation() {
        myLocation.waitUntilClickable().click();
    }
}
