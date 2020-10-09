package pages;


import java.util.ArrayList;
import java.util.Collections;

public class InventoryPage extends BasePage {


    private static final int[] CAR_ITEMS_BY_YEAR = {339, 337, 343, 345, 346, 307, 328, 333, 336, 340, 344, 332};
    private static final int[] CAR_ITEMS_BY_MAKE = {333, 345, 346, 336, 344, 347, 337, 334, 307, 328, 335, 340};
    private static final int[] CAR_ITEMS_BY_MODEL = {337, 347, 345, 346, 336, 344, 339, 340, 332, 343, 334, 328};
    private static final int[] CAR_ITEMS_BY_PRICE = {339, 340, 344, 345, 346, 335, 347, 328, 336, 307};
    private static final int[] CAR_ITEMS_BY_MILEAGE = {339, 337, 343, 345, 346, 307, 328, 333, 336, 340, 344, 332};
    private static final int ELEMENTS_ON_THE_PAGE = 12;


    public final static String Year = "Year";
    public final static String Make = "Make";
    public final static String Model = "Model";
    public final static String PRICE = "Price";
    public final static String MILEAGE = "Mileage";

    public final static String INVENTORY_OPTION = "//*[@class='nav navbar-nav navbar-right main_nav']/li[2]/a";


    public AutoSearchPage clickElementByYear(int element) {
        clickElementByXpath("//div[1]/div/a[text()='More']");
        clickElementByXpath("//a[text()='" + element + "']");
        return new AutoSearchPage();
    }

    public AutoSearchPage clickCheckingElement(String element) {
        clickElementByXpath("//div[3]/div/a[text()='More']");
        clickElementByXpath("//a[text()='" + element + "']");
        return new AutoSearchPage();
    }

    public void clickSortingOption(String sort_option) {
        clickElementByXpath("//a[text()='" + sort_option + "']");
    }

    public boolean isTypeBarSortedCorrect(String sorting_type) {

        switch (sorting_type) {

            case Year:
                ArrayList<String> listSortedCarsByYear = new ArrayList<String>(createListUnsortedCars(0, CAR_ITEMS_BY_YEAR));
                Collections.sort(listSortedCarsByYear);
                Collections.reverse(listSortedCarsByYear);
                return createListUnsortedCars(0, CAR_ITEMS_BY_YEAR).equals(listSortedCarsByYear);

            case Make:
                ArrayList<String> listSortedCarsByMake = new ArrayList<String>(createListUnsortedCars(1, CAR_ITEMS_BY_MAKE));
                Collections.sort(listSortedCarsByMake);
                return createListUnsortedCars(1, CAR_ITEMS_BY_MAKE).equals(listSortedCarsByMake);

            case Model:
                ArrayList<String> listSortedCarsByModel = new ArrayList<String>(createListUnsortedCars(2, CAR_ITEMS_BY_MODEL));
                Collections.sort(listSortedCarsByModel);

                return createListUnsortedCars(2, CAR_ITEMS_BY_MODEL).equals(listSortedCarsByModel);

            case PRICE:
                return isSortedTypeByPriceCorrect(CAR_ITEMS_BY_PRICE);

            case MILEAGE:
                return isSortedTypeByMilegeCorrect(CAR_ITEMS_BY_MILEAGE);

            default:
                ArrayList<String> sortedVeryfyingDefault = new ArrayList<String>(createListUnsortedCars(0, CAR_ITEMS_BY_YEAR));
        }
        return false;
    }


    public ArrayList<String> createListUnsortedCars(int numberSortingType, int[] carItems) {
        ArrayList<String> infoAboutCar = new ArrayList<String>();
        ArrayList<String> actualVerifyingType = new ArrayList<String>();

        for (int i = 0; i < ELEMENTS_ON_THE_PAGE; i++) {
            infoAboutCar.add(getElementValue("//div[@data-key='" + carItems[i] + "']/li[@id='products']/div[@class='col-md-9 inventory-detail']"));
            String infoSingleCarLine = infoAboutCar.get(i);
            String[] infoLine = infoSingleCarLine.split(" ");
            actualVerifyingType.add(infoLine[numberSortingType]);
        }
        return actualVerifyingType;
    }

    public boolean isSortedTypeByPriceCorrect(int[] carItems) {
        ArrayList<String> carInfoPrice = new ArrayList<String>();
        ArrayList<String> price = new ArrayList<String>();

        for (int i = 0; i < ELEMENTS_ON_THE_PAGE; i++) {
            carInfoPrice.add(getElementValue("//div[@data-key='" + carItems[i] + "']//span[@class='eziVehiclePrice']"));
            String infoSingleCarLine = carInfoPrice.get(i);
            String[] infoLine = infoSingleCarLine.split(" ");
            price.add(infoLine[0]);
        }

        ArrayList<String> carListSorted = new ArrayList<String>(price);
        Collections.sort(carListSorted);

        return price.equals(carListSorted);
    }


    public boolean isSortedTypeByMilegeCorrect(int[] carItems) {
        ArrayList<String> carInfoMileage = new ArrayList<String>();
        ArrayList<String> mileage = new ArrayList<String>();

        for (int i = 0; i < ELEMENTS_ON_THE_PAGE; i++) {
            mileage.add(getElementValue("//div[@data-key='" + carItems[i] + "']//li[8]/span"));
        }
        ArrayList<String> carListSorted = new ArrayList<String>(mileage);
        Collections.sort(carListSorted);
        return mileage.equals(carListSorted);
    }


    public void refreshPageInventory() {
        clickElementByXpath(INVENTORY_OPTION);
    }

    public boolean isChoosingElementDisplayed(String elementName) {
        String xpath = " " + elementName + "";
        return isElementDisplayed(xpath);
    }

    public boolean isElementActive(String elementName){
        String xpath = " " + elementName + "";
        clickElementByXpath(xpath);
        return isElementDisplayed(xpath);
    }
}