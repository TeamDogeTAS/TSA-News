package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class TermsPage extends PageObject {

    @FindBy(id = "Title_Text")
    public WebElementFacade titleText;

    @FindBy(id = "Back_Button")
    public WebElementFacade backButton;

    public void verifyTermsPage() {
        assertThat(titleText.getText().equalsIgnoreCase("Terms & Conditions"));
    }

    public void hitBackButton(){
        backButton.click();
    }
}
