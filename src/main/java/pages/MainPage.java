package pages;

import constants.Constants;


public class MainPage extends BasePage {

    public final static String LOGO = "//*[@class='slide nivoSlider']/div[4]";

    public final static String CONTACT_US_OPTION = "//*[@class='nav navbar-nav navbar-right main_nav']/li[7]/a";
    public final static String ABOUT_US_OPTION = "//*[@class='nav navbar-nav navbar-right main_nav']/li[6]/a";
    public final static String INVENTORY_OPTION = "//*[@class='nav navbar-nav navbar-right main_nav']/li[2]/a";

    public void navigateToMainPage(String url) {
        driver.get(url);
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(LOGO);
    }

    public boolean isMainPageNavigationBarDisplayed() {
        return isElementDisplayed(Constants.NAVIGATION_BAR);

    }

    public ContactUsPage clickContactUsPage() {
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }

    public AboutUsPage clickAboutUsPage() {
        clickElementByXpath(ABOUT_US_OPTION);
        return new AboutUsPage();
    }

    public InventoryPage clickInventoryPage() {
        clickElementByXpath(INVENTORY_OPTION);
        return new InventoryPage();
    }
}