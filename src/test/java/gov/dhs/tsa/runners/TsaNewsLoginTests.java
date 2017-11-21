package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.RequestSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class TsaNewsLoginTests {

    @Managed
    WebDriver driver;

    @Steps
    RequestSteps steps;

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
        steps.loginPromptIsThere();
    }

    @Test
    public void verifySuccessfulPinRequest(){
        //given
        steps.givenThePageLoads();
        //when
        steps.correctEmailIsEntered("doge@tsa.dhs.gov");
        //then
        steps.successfulPinRequestPromptIsDisplayed("An identification pin has been sent to your email address. Please enter the pin below to log in.");
    }
}
