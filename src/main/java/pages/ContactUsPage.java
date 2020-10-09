package pages;

import constants.Constants;

public class ContactUsPage extends BasePage{

    public boolean isContactUsPageNavigationBarDisplayed(){
        return isElementDisplayed(Constants.NAVIGATION_BAR);

    }

}
