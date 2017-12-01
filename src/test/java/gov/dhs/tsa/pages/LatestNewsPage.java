package gov.dhs.tsa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;
import static org.assertj.core.api.Assertions.assertThat;

public class LatestNewsPage extends PageObject{

    final static Logger logger = LoggerFactory.getLogger(LatestNewsPage.class);

    @FindBy(xpath = "//*[@id=\"Page_Header\"]")
    public WebElementFacade pageHeader;

    @FindBy(id = "Hamburger_Menu")
    public WebElementFacade hamburgerMenu;

    @FindBy(id = "TSA_News_Logo")
    public WebElementFacade tsaLogo;

    @FindBy(id = "Settings")
    public WebElementFacade settings;

    @FindBy(id = "Latest_News")
    public WebElementFacade latestNews;
    //*[@id="Page_Header"]

    @FindBy(id = "My_News")
    public WebElementFacade myNews;
    //*[@id="Page_Header"]

    @FindBy(id = "TSA_Video")
    public WebElementFacade tsaVideo;
    //*[@id="Page_Header"]

    @FindBy(id = "USAJOBS")
    public WebElementFacade usaJobs;

    @FindBy(id = "usajobs-header")
    public WebElementFacade usaJobsHeader;

    @FindBy(id = "Social_Media")
    public WebElementFacade socialMedia;

    @FindBy(id = "socail-media-option")
    public WebElementFacade socialMediaOption;

    public void checkPageHeader(String expectedHeader) {
        pageHeader.waitUntilVisible();
        String header = pageHeader.getText();
        assertThat(expectedHeader.equalsIgnoreCase(header));
    }

    public void checkPageUrl(String url) {
        assertThat(getDriver().getCurrentUrl().equals(url));
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

    public void selectSettingsOption() {
        settings.waitUntilClickable().click();
    }

    public void selectAndVerify() {

        myNews.waitUntilClickable().click();
        checkPageUrl("http://localhost:8100/#/home?type=my_news");
        clickOnHamburgerMenu();
        tsaVideo.waitUntilClickable().click();
        checkPageUrl("http://localhost:8100/#/home?type=video");
        clickOnHamburgerMenu();
        usaJobs.waitUntilClickable().click();
        checkPageUrl("http://localhost:8100/#/jobs");
        clickOnHamburgerMenu();
        socialMedia.waitUntilClickable().click();
        checkPageUrl("http://localhost:8100/#/social-media");
    }
}
