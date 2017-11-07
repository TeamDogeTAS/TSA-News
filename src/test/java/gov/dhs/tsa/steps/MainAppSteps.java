package gov.dhs.tsa.steps;

import gov.dhs.tsa.pages.LatestNewsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class MainAppSteps extends ScenarioSteps{

    LatestNewsPage latestNewsPage;

    @Step
    public void checkLatestNewsHeader(String header) {
        latestNewsPage.checkPageHeader(header);
    }
}
