package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("http://localhost:8100")
public class RequestPage extends PageObject{

    @FindBy(id = "Request_Button")
    public WebElementFacade requestButton;

    @FindBy(id = "Error_Message")
    public WebElementFacade requestPrompt;

    @FindBy(id = "Email_Input")
    public WebElementFacade emailInput;

    @FindBy(id = "Checkbox")
    public WebElementFacade checkBox;

    @FindBy(id = "Tap_Here")
    public WebElementFacade tapHereLink;

    @FindBy(id = "Terms_Link")
    public WebElementFacade termsLink;

    public void verifyPageOpens() {
        open();
        assertThat(emailInput.getText().equalsIgnoreCase("email address"));
    }

    public void clickOnRequest() {
        requestButton.click();
    }

    public void verifyRequestPrompt(String error) {
        assertThat(requestPrompt.getText().equals(error));
    }

    public void submitEmail(String email) {
        emailInput.type(email);
        requestButton.click();
        getDriver().switchTo().alert().accept();
    }

    public void uncheckTerms() {
        checkBox.click();
        requestButton.click();
    }

    public void clickAlreadyHavePin() {
        tapHereLink.click();
    }

    public void clickTerms() {
        termsLink.click();
    }
    public void uncheckTermsWithEmail(String email){
        emailInput.type(email);
        checkBox.click();
        requestButton.click();
    }

}
