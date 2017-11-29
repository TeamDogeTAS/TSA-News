package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.MainAppSteps;
import gov.dhs.tsa.steps.RequestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TsaNewsLoginTests {

    @Managed(uniqueSession = true)
    WebDriver driver;

    @Steps
    RequestSteps steps;
    MainAppSteps mainAppSteps;

    @Test
    public void tryingToLoginWithoutEmail(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenClicked();
        //then
        steps.requestPromptIsThere("To get your identification pin, you must use only your TSA email address that ends with \"tsa.dhs.gov.\"");
    }

    @Test
    public void tryingToLoginWithWrongEmail(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenWrongEmailIsUsed("doge@accenturefederal.com");
        //then
        steps.requestPromptIsThere("To get your identification pin, you must use only your TSA email address that ends with \"tsa.dhs.gov.\"");
        //navigate to login screen
        steps.loginWithPin();
        //wait for the page
        steps.loginPageLoads();
        //try to log in with wrong email address
        steps.emailAndPinIsEntered("doge@accenturefederal.com", "12345678");
        //verify error message in login regarding email address
        steps.loginPromptIsThere("An identification pin is sent only to your TSA email ending in \"tsa.dhs.gov.\" To log in, please provide your TSA email address.");
    }

    @Test
    public void tryingToRequestWithoutAcceptingTerms(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenCheckboxIsUnchecked();
        //then
        steps.requestPromptIsThere("For access to TSANews, you must accept the Terms and Conditions.");
    }

    @Test
    public void tryingToRequestWithoutAcceptingTermsWithEmail(){
        //given
        steps.givenThePageLoads();
        //when
        steps.requestPinWithEmailWithoutTerms("doge@tsa.dhs.gov");
        //then
        steps.requestPromptIsThere("For access to TSANews, you must accept the Terms and Conditions.");
    }

    @Test
    public void verifyTermsPage(){
        //given
        steps.givenThePageLoads();
        //when
        steps.clickTermsLink();
        //then
        steps.termsPageIsDisplayed();
        //and
        steps.navigateBackToRequestPage();
    }

    @Test
    public void tryingToLoginWithoutCorrectPin(){
        //given
        steps.givenThePageLoads();
        //when
        steps.loginWithPin();
        //and
        steps.loginPageLoads();
        //and
        steps.emailAndPinIsEntered("doge@tsa.dhs.gov", "29380193");
        //then
        steps.loginPromptIsThere("The pin you entered is incorrect. Pins are 8 characters long. Please try again.");
    }

    @Test
    public void successfulLogin(){
        //given
        steps.givenThePageLoads();
        //when
        steps.loginWithPin();
        //and
        steps.loginPageLoads();
        //and
        steps.emailAndPinIsEntered("doge@tsa.dhs.gov", "999ZAZBW");
        //then
        steps.newsfeedPageIsDisplayed("Latest News");
    }

    @Test
    public void successfulLoginAfterFailedLogin(){
        steps.givenThePageLoads();
        steps.loginWithPin();
        steps.loginPageLoads();
        steps.emailAndPinIsEntered("doge@tsa.dhs.gov", "29380193");
        steps.loginPromptIsThere("The pin you entered is incorrect. Pins are 8 characters long. Please try again.");
        steps.emailAndPinIsEntered("doge@tsa.dhs.gov", "999ZAZBW");
        steps.newsfeedPageIsDisplayed("Latest News");
    }
}
