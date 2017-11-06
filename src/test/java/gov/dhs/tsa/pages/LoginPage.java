package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

import static org.assertj.core.api.Assertions.assertThat;

@At("http://localhost:8100/#/login")
public class LoginPage extends PageObject{

    @FindBy(id = "error_message")
    public WebElementFacade loginPrompt;

    @FindBy(id = "email_address")
    public WebElementFacade emailInput;

    @FindBy(id = "pin_input")
    public WebElementFacade pinInput;

    @FindBy(id = "login_button")
    public WebElementFacade loginBtn;

    public void verifyLoginPrompt() {
        assertThat(loginPrompt.isDisplayed());
    }

    public void loginPageLoads(){
        assertThat(emailInput.isDisplayed());
    }

    public void enterEmailAndPin(String email, String pin) {
        emailInput.type(email);
        pinInput.type(pin);
        loginBtn.click();
    }
}
