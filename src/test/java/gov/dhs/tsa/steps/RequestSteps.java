package gov.dhs.tsa.steps;

import gov.dhs.tsa.pages.LoginPage;
import gov.dhs.tsa.pages.RequestPage;
import gov.dhs.tsa.pages.TermsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RequestSteps extends ScenarioSteps{

    RequestPage page;
    LoginPage loginPage;
    TermsPage termsPage;

    @Step
    public void givenThePageLoads() {
        page.verifyPageOpens();
    }

    @Step
    public void whenClicked() {
        page.clickOnRequest();
    }

    @Step
    public void requestPromptIsThere() {
        page.verifyRequestPrompt();
    }

    @Step
    public void loginPromptIsThere() {
        loginPage.verifyLoginPrompt();
    }

    @Step
    public void whenWrongEmailIsUsed(String emailAddress) {
        page.submitWrongEmail(emailAddress);
    }
    @Step
    public void whenCheckboxIsUnchecked() {
        page.uncheckTerms();
    }
    @Step
    public void loginWithPin() {
        page.clickAlreadyHavePin();
    }
    @Step
    public void loginPageLoads() {
        getPages().isCurrentPageAt(LoginPage.class);
        loginPage.loginPageLoads();
    }
    @Step
    public void emailAndPinIsEntered(String email, String pin) {
        loginPage.enterEmailAndPin(email, pin);
    }
    @Step
    public void clickTermsLink() {
        page.clickTerms();
    }
    @Step
    public void termsPageIsDisplayed() {
        getPages().isCurrentPageAt(TermsPage.class);
        termsPage.verifyTermsPage();
    }
    @Step
    public void navigateBackToReqestPage() {
        termsPage.hitBackButton();
    }
}
