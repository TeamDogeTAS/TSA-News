package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

import static org.assertj.core.api.Assertions.assertThat;

@At("http://localhost:8100/#/terms-and-conditions")
public class TermsPage extends PageObject {

    @FindBy(id = "title_text")
    public WebElementFacade titleText;

    @FindBy(id = "back_button")
    public WebElementFacade backButton;

    public void verifyTermsPage() {
        assertThat(titleText.getText().equalsIgnoreCase("Terms & Conditions"));
    }

    public void hitBackButton(){
        backButton.click();
    }
}
