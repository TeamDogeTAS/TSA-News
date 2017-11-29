package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.StepDefinitions;
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
    StepDefinitions stepDefinitions;

    @Test
    public void tryingToLoginWithoutEmail(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.whenClicked();
        //then
        stepDefinitions.requestPromptIsThere("To get your identification pin, you must use only your TSA email address that ends with \"tsa.dhs.gov.\"");
    }

    @Test
    public void tryingToLoginWithWrongEmail(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.whenWrongEmailIsUsed("doge@accenturefederal.com");
        //then
        stepDefinitions.requestPromptIsThere("To get your identification pin, you must use only your TSA email address that ends with \"tsa.dhs.gov.\"");
        //navigate to login screen
        stepDefinitions.loginWithPin();
        //wait for the page
        stepDefinitions.loginPageLoads();
        //try to log in with wrong email address
        stepDefinitions.emailAndPinIsEntered("doge@accenturefederal.com", "12345678");
        //verify error message in login regarding email address
        stepDefinitions.loginPromptIsThere("An identification pin is sent only to your TSA email ending in \"tsa.dhs.gov.\" To log in, please provide your TSA email address.");
    }

    @Test
    public void tryingToRequestWithoutAcceptingTerms(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.whenCheckboxIsUnchecked();
        //then
        stepDefinitions.requestPromptIsThere("For access to TSANews, you must accept the Terms and Conditions.");
    }

    @Test
    public void tryingToRequestWithoutAcceptingTermsWithEmail(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.requestPinWithEmailWithoutTerms("doge@tsa.dhs.gov");
        //then
        stepDefinitions.requestPromptIsThere("For access to TSANews, you must accept the Terms and Conditions.");
    }

    @Test
    public void verifyTermsPage(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.clickTermsLink();
        //then
        stepDefinitions.termsPageIsDisplayed();
        //and
        stepDefinitions.navigateBackToRequestPage();
    }

    @Test
    public void tryingToLoginWithoutCorrectPin(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.loginWithPin();
        //and
        stepDefinitions.loginPageLoads();
        //and
        stepDefinitions.emailAndPinIsEntered("doge@tsa.dhs.gov", "29380193");
        //then
        stepDefinitions.loginPromptIsThere("The pin you entered is incorrect. Pins are 8 characters long. Please try again.");
    }

    @Test
    public void successfulLogin(){
        //given
        stepDefinitions.givenThePageLoads();
        //when
        stepDefinitions.loginWithPin();
        //and
        stepDefinitions.loginPageLoads();
        //and
        stepDefinitions.emailAndPinIsEntered("doge@tsa.dhs.gov", "999ZAZBW");
        //then
        stepDefinitions.newsfeedPageIsDisplayed("Latest News");
    }

    @Test
    public void successfulLoginAfterFailedLogin(){
        stepDefinitions.givenThePageLoads();
        stepDefinitions.loginWithPin();
        stepDefinitions.loginPageLoads();
        stepDefinitions.emailAndPinIsEntered("doge@tsa.dhs.gov", "29380193");
        stepDefinitions.loginPromptIsThere("The pin you entered is incorrect. Pins are 8 characters long. Please try again.");
        stepDefinitions.emailAndPinIsEntered("doge@tsa.dhs.gov", "999ZAZBW");
        stepDefinitions.newsfeedPageIsDisplayed("Latest News");
    }
}
