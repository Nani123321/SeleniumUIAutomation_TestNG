package com.orangeHRM.Framework.WebDriverActions;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.Framework.LogUtilities.LoggerUtilities;
import com.orangeHRM.Framework.PageObjects.BasePage;

public class SeleniumActions extends BasePage{
	WebDriver driver;
	
	private final Logger logger = LoggerUtilities.getLogger(SeleniumActions.class);
    private Duration defaultTimeout = Duration.ofMillis(10000); // Default timeout in milliseconds

    public SeleniumActions(WebDriver driver) { // Constructor with WebDriver parameter
        super(driver);
    }

    /**
     * Clicks on the WebElement after waiting for it to be clickable.
     * @param element The WebElement to click.
     */
    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
            logger.info("Clicked on element: " + element.toString());
        } catch (Exception e) {
            logger.error("Failed to click on element: " + element.toString(), e);
        }
    }

    /**
     * Enters text into the WebElement after waiting for it to be visible.
     * @param element The WebElement to type into.
     * @param text The text to enter.
     */
    public void enterText(WebElement element, String text) {
        try {
            waitForElementToBeVisible(element);
            element.clear(); // Clear any existing text
            element.sendKeys(text);
            logger.info("Entered text '" + text + "' into element: " + element.toString());
        } catch (Exception e) {
            logger.error("Failed to enter text into element: " + element.toString(), e);
        }
    }

    /**
     * Retrieves the text from the WebElement after waiting for it to be visible.
     * @param element The WebElement to retrieve text from.
     * @return The text of the WebElement.
     */
    public String getText(WebElement element) {
        String text = null;
        try {
            waitForElementToBeVisible(element);
            text = element.getText();
            logger.info("Retrieved text from element: " + element.toString() + " - Text: " + text);
        } catch (Exception e) {
            logger.error("Failed to retrieve text from element: " + element.toString(), e);
        }
        return text;
    }

    /**
     * Checks if the WebElement is displayed on the page.
     * @param element The WebElement to check.
     * @return true if displayed, false otherwise.
     */
    public boolean isDisplayed(WebElement element) {
        boolean isExist = false;
        try {
            isExist = element.isDisplayed();
            logger.info("Element displayed status for " + element.toString() + ": " + isExist);
        } catch (Exception e) {
            logger.error("Error checking displayed status for element: " + element.toString(), e);
        }
        return isExist;
    }

    // Other methods (isEnabled, isSelected, getAttribute, submit) would follow the same logging pattern

    // Private methods to handle waiting

    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, defaultTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Optionally, you can allow for customizable timeouts
    public void setDefaultTimeout(Duration seconds) {
        this.defaultTimeout = seconds;
    }


}
