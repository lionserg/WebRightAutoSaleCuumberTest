package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AboutUsPage;
import pages.ContactUsPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class AutoSaleMainPageStepsDefinition {
    private MainPage mainPage;
    private AboutUsPage aboutUsPage;
    private ContactUsPage contactUsPage;

    public AutoSaleMainPageStepsDefinition() {
        mainPage = new MainPage();
    }

    @Given("User navigates to {string} page")
    public void userNavigatesToHttpsWwwRightwayautosaleComPage(String url) {
        mainPage.navigateToMainPage(url);
    }

    @Then("Verify that Rightwayautosale navigation bar is displayed on Main page")
    public void verifyThatRightwayautosaleNavigationBarIsDisplayed() {
        assertTrue(mainPage.isMainPageNavigationBarDisplayed());
    }

    @And("Verify that Rightwayautosale logo is displayed")
    public void verifyThatRightwayautosaleLogoIsDisplayed() {
        assertTrue(mainPage.isLogoDisplayed());
    }

    @When("User clicks AboutUs option")
    public void userClicksAboutUsOption() {
        aboutUsPage = mainPage.clickAboutUsPage();
    }

    @Then("Verify that Rightwayautosale navigation bar is displayed on AboutUs page")
    public  void verifyThatRightwayautosaleNavigationBarIsDisplayedOnAboutUsPage(){
        assertTrue(aboutUsPage.isAboutUsPageNavigationBarDisplayed());

    }

    @When("User clicks ContactUs option")
    public void userClicksContactUsOption() {
        contactUsPage = mainPage.clickContactUsPage();
    }

    @Then("Verify that Rightwayautosale navigation bar is displayed on ContactUs page")
    public  void verifyThatRightwayautosaleNavigationBarIsDisplayedOnContactUsPage(){
        assertTrue(contactUsPage.isContactUsPageNavigationBarDisplayed());

    }
}
