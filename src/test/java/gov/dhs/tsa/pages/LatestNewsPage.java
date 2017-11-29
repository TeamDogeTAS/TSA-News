package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class LatestNewsPage extends PageObject{

    @FindBy(id = "Page_Header")
    public WebElementFacade pageHeader;

    @FindBy(id = "Hamburger_Menu")
    public WebElementFacade hamburgerMenu;

    @FindBy(id = "TSA_News_Logo")
    public WebElementFacade tsaLogo;

    public void checkPageHeader(String expectedHeader) {
        pageHeader.waitUntilVisible();
        String header = pageHeader.getText();
        assertThat(expectedHeader.equalsIgnoreCase(header));
    }

    public void checkForHamburgerMenu() {
        assertThat(hamburgerMenu.isCurrentlyVisible());
        System.out.println("menu visible");
    }

    public void checkForLogo() {
        assertThat(tsaLogo.isCurrentlyVisible());
        System.out.println("logo visible");
    }
}
