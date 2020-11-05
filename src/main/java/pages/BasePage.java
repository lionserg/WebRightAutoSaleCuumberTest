package pages;

import app.WebdriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver = WebdriverSetup.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);

    public boolean isElementDisplayed(String xpath) {

        List<WebElement> webElementList = driver.findElements(By.xpath(xpath));
        return webElementList.size() > 0;

    }

    public void clickElementByXpath(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }

    public String getElementValue(String xpath) {
        String value = driver.findElement(By.xpath(xpath)).getAttribute("outerText");
        return value;
    }
}