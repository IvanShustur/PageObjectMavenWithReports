package selenium.util;

import DriverFactory.DriverProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.decorator.PageElement;

import java.time.Duration;

public class WaitUtils {
    private WaitUtils() {
    }

    public static void waitForElementToBeEnabled(PageElement pageElement) {
        getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.and(el -> el.findElement(pageElement.getLocator())
                        .isEnabled(), ExpectedConditions.visibilityOf(pageElement)));
    }





    public static WebElement elementToBeClickable(PageElement pageElement) {
        return getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(pageElement));
    }

    public static void waitForVisibility(PageElement pageElement) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(pageElement.getLocator()));
    }
    public static WebDriverWait wait;

    private static WebDriverWait getWait() {
        return new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(10));
    }



    //  public static void waitForElementToBeEnabled(WebElement pageElement) {
    //     getWait()
    ///             .ignoring(StaleElementReferenceException.class)
    //            .until(ExpectedConditions.and(el -> el.findElement(pageElement)
    //                     .isEnabled(), ExpectedConditions.visibilityOf(pageElement)));
    // }


    public static void waitForPageLoadComplete() {
        new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public static Boolean waitTextToBe(By locator, String text) {
        return getWait().until(ExpectedConditions.textToBe(locator, text));
    }

    public static WebElement waitForElementPresence(By locator) {
        return getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementVisibility(WebElement webElement) {
        return getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitForPresence(By webElement) {
        return getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(webElement));
    }

    public static WebElement elementToBeClickable(WebElement pageElement) {
        return getWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(pageElement));
    }


}



