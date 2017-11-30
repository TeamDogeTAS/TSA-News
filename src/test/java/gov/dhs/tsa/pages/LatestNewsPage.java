package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LatestNewsPage extends PageObject{

    final static Logger logger = LoggerFactory.getLogger(LatestNewsPage.class);

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
    }

    public void checkForLogo() {
        assertThat(tsaLogo.isCurrentlyVisible());
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenu.waitUntilClickable().click();
    }

    public void verifyLinksOnMenu(List<String> options) {
        List<WebElement> burgerOptions = getDriver().findElements(By.xpath("//ul[@id='Hamburger_Options']//li/a/b"));
        for (WebElement option: burgerOptions) {
            assertThat(options.contains(option));
            logger.info("************** "+option.getText()+" exists in the given string **************");
        }
    }
}
