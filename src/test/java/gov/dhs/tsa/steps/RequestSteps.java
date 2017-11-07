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

    @Step("Open TSA News main Login Page")
    public void givenThePageLoads() {
        page.verifyPageOpens();
    }

    @Step("Click on Request Pin Button")
    public void whenClicked() {
        page.clickOnRequest();
    }

    @Step("The error message should appear")
    public void requestPromptIsThere() {
        page.verifyRequestPrompt();
    }

    @Step("The error message should appear")
    public void loginPromptIsThere() {
        loginPage.verifyLoginPrompt();
    }

    @Step("When the email {0} is used")
    public void whenWrongEmailIsUsed(String emailAddress) {
        page.submitWrongEmail(emailAddress);
    }

    @Step("When the terms checkbox is unchecked")
    public void whenCheckboxIsUnchecked() {
        page.uncheckTerms();
    }

    @Step("Log in with pin")
    public void loginWithPin() {
        page.clickAlreadyHavePin();
    }

    @Step
    public void loginPageLoads() {
        getPages().isCurrentPageAt(LoginPage.class);
        loginPage.loginPageLoads();
    }

    @Step("The email {0}, and a random pin {1} is typed in")
    public void emailAndPinIsEntered(String email, String pin) {
        loginPage.enterEmailAndPin(email, pin);
    }

    @Step("Click on the Terms & Conditions link")
    public void clickTermsLink() {
        page.clickTerms();
    }

    @Step
    public void termsPageIsDisplayed() {
        getPages().isCurrentPageAt(TermsPage.class);
        termsPage.verifyTermsPage();
    }
    @Step("Hit the back button to navigate back to the Request Page")
    public void navigateBackToRequestPage() {
        termsPage.hitBackButton();
    }
}
