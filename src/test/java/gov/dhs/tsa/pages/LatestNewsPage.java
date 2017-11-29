package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class LatestNewsPage extends PageObject{

    @FindBy(id = "Page_Header")
    public WebElementFacade pageHeader;

    public void checkPageHeader(String expectedHeader) {
        String header = pageHeader.getText();
        System.out.println(header);
        assertThat(expectedHeader.equalsIgnoreCase(header));
    }
}
