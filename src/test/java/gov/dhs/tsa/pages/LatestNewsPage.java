package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.At;

import static org.assertj.core.api.Assertions.assertThat;

@At("http://localhost:8100/#/home")
public class LatestNewsPage extends PageObject{

    @FindBy(css = "body > ion-nav-view > ion-side-menus > ion-side-menu-content > ion-nav-view > ion-view:nth-child(1) > ion-content > div.scroll > p > span")
    public WebElementFacade pageHeader;

    public void checkPageHeader(String expectedHeader) {
        open();
        String header = pageHeader.getText();
        assertThat(expectedHeader.equalsIgnoreCase(header));
    }
}
