package gov.dhs.tsa.runners;

import gov.dhs.tsa.steps.MainAppSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.annotations.ClearCookiesPolicy.Never;

@RunWith(SerenityRunner.class)
public class TsaNewsMainTests {

    //clear cookies BeforeEachTest = default
    @Managed (clearCookies = Never)
    public WebDriver driver;

    @Steps
    MainAppSteps appSteps;

    @Test
    @Ignore
    public void mainPageVerification(){
        //open and login to app

        //verify hamburger menu displays

        //verify TSANEWS logo next to hamburger menu displays

        //verify header of current page
        appSteps.checkLatestNewsHeader("Latest News");
        //select hamburger menu and verify the options displayed

        //check to verify that when an option is picked, the correct page is displayed (rinse and repeat)

        //check the like function of application
    }

}
