package selenium.page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import selenium.decorator.elements.Button;
import selenium.decorator.elements.Input;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//input[@class='search-form__input ng-untouched ng-pristine ng-valid']")
    private Input searchInput;

    @FindBy(xpath = "//button[@class='header__button ng-tns-c107-1']")
    private Button catalogButton;

    public void openCatalog(){
        catalogButton.click();
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword, Keys.ENTER);
        logger.info("Product name was written to the searchBox");
    }

}
