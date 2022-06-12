package selenium.page;

import DriverFactory.DriverProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.decorator.elements.Button;
import selenium.decorator.elements.Input;
import selenium.util.WaitUtils;

import java.util.List;

import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResultPage.class);

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List <Button> searchResultsProductList;

    @FindBy(xpath = "//div[@class='sidebar-alphabet ng-star-inserted']//preceding-sibling::div/input")
    private Input sideBarSearchBox;

    @FindBy(xpath = "//a[@data-id='%s']")
    private Button BrandBox;

    @FindBy(xpath = "//*[@class='select-css ng-pristine ng-valid ng-star-inserted ng-touched']//*[@class='ng-star-inserted'] [2]")
    private Button fromHighToLowPrice;

    @FindBy(xpath = "//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']")
    private Button filterDropDown;

    public void clickOnTheFirstBrandBox(String brand) {
        By locator = xpath(String.format("//a[@data-id='%s']", brand));
        WebElement el = DriverProvider.getDriver().findElement(locator);
        el.click();
        logger.info("Checkbox was selected by brand name");
    }





    public void chooseFirstItemFromTheList(){
        WaitUtils.waitForElementPresence(xpath("//span[@class='goods-tile__title']"));
        WaitUtils.waitForElementVisibility(searchResultsProductList.get(0)).click();
        logger.info("The first product was selected");
    }


    public void searchInTheSideBarSearchBoxByKeyword(final String keyword) {
        WaitUtils.waitForPageLoadComplete();
        WaitUtils.waitForElementVisibility(sideBarSearchBox);
        sideBarSearchBox.sendKeys(keyword);
        //driver.findElement(xpath(SIDE_BAR_SEARCH_BOX)).sendKeys(keyword);
        logger.info("Brand name was written to the side bar search box");
    }


    public void sortingFromHighToLowPrice() throws InterruptedException {
        fromHighToLowPrice.click();
        fromHighToLowPrice.click();
        //driver.findElement(xpath(FROM_HIGH_TO_LOW_PRICE)).click();
        logger.info("Items was sorted from high to low price");
    }


}
