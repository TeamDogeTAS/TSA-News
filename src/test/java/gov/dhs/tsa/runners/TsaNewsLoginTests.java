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
    public WebDriver driver;

    @Steps
    RequestSteps steps;

    @Test
    public void tryingToLoginWithoutEmail(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenClicked();
        //then
        steps.requestPromptIsThere();
    }

    @Test
    public void tryingToLoginWithWrongEmail(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenWrongEmailIsUsed("jae.young.shin@accenturefederal.com");
        //then
        steps.requestPromptIsThere();
    }

    @Test
    public void tryingToLoginWithoutAcceptingTerms(){
        //given
        steps.givenThePageLoads();
        //when
        steps.whenCheckboxIsUnchecked();
        //then
        steps.requestPromptIsThere();
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
        steps.emailAndPinIsEntered("jae.shin@tsa.dhs.gov", "29380193");
        //then
        steps.loginPromptIsThere();
    }
}
