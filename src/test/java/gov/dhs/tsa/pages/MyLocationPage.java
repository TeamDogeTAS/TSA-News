package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLocationPage extends PageObject{

    @FindBy(id="airport-input")
    public WebElementFacade airportInput;

    @FindBy(id="dropdown-list")
    public WebElementFacade dropdownList;

    @FindBy(id = "saved-airport")
    public WebElementFacade setAirport;

    public void setAirport(String iad) {
        airportInput.type(iad);
        dropdownList.waitUntilClickable().click();
        System.out.println(setAirport.getText());
        assertThat(setAirport.getText().contains(iad));
    }
}
