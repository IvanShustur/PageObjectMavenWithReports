package selenium.decorator.elements;

import DriverFactory.DriverProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import selenium.decorator.PageElement;
import selenium.util.WaitUtils;

public class Input extends PageElement {
    private static final Logger logger = LogManager.getLogger(Input.class);

    public Input(WebElement webElement, By by) {
        super(webElement, by);
    }

    public void clearAndSendKeys(CharSequence... keys) {
        clear();
        webElement.sendKeys(keys);
    }

    public void waitForFieldReadyToInput() {
        logger.info("Wait element with locator {} to be enabled", getLocator());
        WaitUtils.waitForElementToBeEnabled(this);
    }

    public void sendKeysAction(String... keys) {
        Actions action = new Actions(DriverProvider.getDriver());
        action.sendKeys(this, keys).build().perform();
    }
}
