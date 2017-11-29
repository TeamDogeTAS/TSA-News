package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.StepDefinitions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;

@RunWith(SerenityRunner.class)
public class TsaNewsMainTests {

    //clear cookies BeforeEachTest = default
    @Managed(uniqueSession = true, clearCookies = Never)
    public WebDriver driver;

    @Steps
    StepDefinitions stepDefinitions;

    @Test
    public void mainPageVerification() {
        //open and login to app
        stepDefinitions.givenThePageLoads();
        stepDefinitions.loginWithPin();
        stepDefinitions.loginPageLoads();
        stepDefinitions.emailAndPinIsEntered("doge@tsa.dhs.gov", "999ZAZBW");
        //verify hamburger menu displays
        stepDefinitions.verifyHamburgerMenuDisplayed();
        //verify TSANEWS logo next to hamburger menu displays
        stepDefinitions.verifyTsanewsLogoDisplayed();
        //verify header of current page
        stepDefinitions.newsfeedPageIsDisplayed("Latest News");
        //select hamburger menu and verify the options displayed
//        mainAppSteps.openHamburgerMenu();
//        mainAppSteps.verifyLinksOnHamburgerMenu();
        //check to verify that when an option is picked, the correct page is displayed (rinse and repeat)
//        mainAppSteps.verifyNavigationOfLinks();
    }
}