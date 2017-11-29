package gov.dhs.tsa.steps;

import gov.dhs.tsa.pages.LatestNewsPage;
import gov.dhs.tsa.pages.LoginPage;
import gov.dhs.tsa.pages.RequestPage;
import gov.dhs.tsa.pages.TermsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class RequestSteps extends ScenarioSteps{

    RequestPage requestPage;
    LoginPage loginPage;
    TermsPage termsPage;
    LatestNewsPage latestNewsPage;

    @Step("Open TSA News main Login Page")
    public void givenThePageLoads() {
        requestPage.verifyPageOpens();
    }

    @Step("Click on Request Pin Button")
    public void whenClicked() {
        requestPage.clickOnRequest();
    }

    @Step("The error message should appear")
    public void requestPromptIsThere(String errorMessage) {
        requestPage.verifyRequestPrompt(errorMessage);
    }

    @Step("The error message should appear")
    public void loginPromptIsThere(String errorMessage) {
        loginPage.verifyLoginPrompt(errorMessage);
    }

    @Step("When the email {0} is used")
    public void whenWrongEmailIsUsed(String emailAddress) {
        requestPage.submitEmail(emailAddress);
    }

    @Step("When the terms checkbox is unchecked")
    public void whenCheckboxIsUnchecked() {
        requestPage.uncheckTerms();
    }

    @Step("Log in with pin")
    public void loginWithPin() {
        requestPage.clickAlreadyHavePin();
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
        requestPage.clickTerms();
    }

    @Step
    public void termsPageIsDisplayed() {
        getPages().isCurrentPageAt(TermsPage.class);
        termsPage.verifyTermsPage();
    }
    @Step
    public void newsfeedPageIsDisplayed(String header){
        getPages().isCurrentPageAt(LatestNewsPage.class);
        latestNewsPage.checkPageHeader(header);
    }
    @Step("Hit the back button to navigate back to the Request Page")
    public void navigateBackToRequestPage() {
        termsPage.hitBackButton();
    }

    @Step("The email {0} is typed, terms is unchecked")
    public void requestPinWithEmailWithoutTerms(String email) {
        requestPage.uncheckTermsWithEmail(email);
    }

    @Step("A correct TSA email {0} is used")
    public void correctEmailIsEntered(String email) {
        requestPage.submitEmail(email);
    }
}
