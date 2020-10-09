package pages;

import constants.Constants;

public class AboutUsPage extends BasePage{

    public boolean isAboutUsPageNavigationBarDisplayed(){
        return isElementDisplayed(Constants.NAVIGATION_BAR);

    }

}
