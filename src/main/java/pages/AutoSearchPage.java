package pages;



public class AutoSearchPage extends BasePage {


    public final static String FOUND_ELEMENT = "//*[@id='listing']/div[1]/div[2]/span[2]";

    public int isMenuYearDisplayed() {
        return Integer.parseInt(getElementValue(FOUND_ELEMENT));
    }

    public String isElementDisplayed() {
        return (getElementValue(FOUND_ELEMENT));
    }

}
