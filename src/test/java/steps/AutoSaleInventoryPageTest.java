package steps;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AutoSearchPage;
import pages.InventoryPage;

public class AutoSaleInventoryPageTest {

    InventoryPage inventoryPage;
    AutoSearchPage autoSearchPage;

    public AutoSaleInventoryPageTest() {
        inventoryPage = new InventoryPage();
    }

    @When("User clicks on the {int} of the car")
    public void userClicksTheSearchYearOfTheCar(int checking_Year) {
        autoSearchPage = inventoryPage.clickElementByYear(checking_Year);

    }

    @Then("Verify the {int} is displayed on the Autosearch page")
    public void verifyTheSearchYearIsEqualToFoundYear(int checking_Year) {

        assertEquals(autoSearchPage.isMenuYearDisplayed(), checking_Year);


    }


    @When("User clicks on the {string} of the car")
    public void userClicksTheBodyTypeOfTheCar(String checking_element) {
        autoSearchPage = inventoryPage.clickCheckingElement(checking_element);
    }

    @Then("Verify the {string} is displayed on the Autosearch page")
    public void verifyTheBodyTypeIsDisplayedOnTheAutosearchPage(String checking_element) {
        assertEquals(autoSearchPage.isElementDisplayed(), checking_element);
    }


    @When("User clicks on the {string} of the cars")
    public void userClicksOnTheSortingOptionOfTheCars(String sorting_option) {
        inventoryPage.clickSortingOption(sorting_option);
    }

    @Then("Verify the correctness of the sorted cars according to the choose {string}")
    public void verifyTheListOfTheSortedCarsAccordingToTheChooseSortingOption(String sorting_option) {
        assertTrue(inventoryPage.isTypeBarSortedCorrect(sorting_option));

    }

    @When("User refresh the Inventory page")
    public void userRefreshThePageInventory() {
        inventoryPage.refreshPageInventory();

    }

    @Then("Verify all the {string} are present on the Inventory page")
    public void verifyAllTheCarDetailsArePresentOnTheInventoryPage(String carDetails) {
        assertTrue(inventoryPage.isChoosingElementDisplayed(carDetails));
    }

    @Then("Verify is the {string} active")
    public void verifyIsTheIsActive(String element) {
        assertFalse(inventoryPage.isElementActive(element));
    }
}





