package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends PageObject{

    @FindBy(id = "error_message")
    public WebElementFacade errorPrompt;

    @FindBy(id = "prompt")
    public WebElementFacade loginPrompt;

    @FindBy(id = "email_input")
    public WebElementFacade emailInput;

    @FindBy(id = "pin_input")
    public WebElementFacade pinInput;

    @FindBy(id = "login_button")
    public WebElementFacade loginBtn;

    public void verifyLoginPrompt(String error) {
        assertThat(errorPrompt.getText().equalsIgnoreCase(error));
    }

    public void loginPageLoads(){
        assertThat(emailInput.isDisplayed());
    }

    public void enterEmailAndPin(String email, String pin) {
        emailInput.type(email);
        pinInput.type(pin);
        loginBtn.click();
    }

    public void verifyPinRequest(String message) {
        assertThat(loginPrompt.getText().equals(message));
    }
}
