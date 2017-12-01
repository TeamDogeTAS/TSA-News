package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.StepDefinitions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;

@RunWith(SerenityRunner.class)
public class TsaNewsMainTests {

    //clear cookies BeforeEachTest = default
    @Managed(uniqueSession = true)
    public WebDriver driver;

    @Steps
    StepDefinitions stepDefinitions;

    @Test
    public void mainPageVerification() {
        List<String> options = Arrays.asList("Latest News", "My News", "TSA Video", "USAJOBS", "Social Media", "Settings");
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
        stepDefinitions.openHamburgerMenu();
        stepDefinitions.verifyLinksOnHamburgerMenu(options);
    }

    @Test
    public void verifyCorrectNavigation(){
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
        stepDefinitions.verifyHamburgerMenuDisplayed();
        stepDefinitions.openHamburgerMenu();
        stepDefinitions.selectMyNews();
    }

    @Test
    public void verifySettings(){
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
        stepDefinitions.openHamburgerMenu();
        stepDefinitions.selectSettings();
        stepDefinitions.verifySettingsPage();
        //set location
        stepDefinitions.setLocationTo("IAD");
    }
}