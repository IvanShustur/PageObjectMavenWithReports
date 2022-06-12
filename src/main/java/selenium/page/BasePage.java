package selenium.page;

import DriverFactory.DriverProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.decorator.CustomFieldDecorator;

public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage() {
        PageFactory.initElements(new CustomFieldDecorator(DriverProvider.getDriver()), this);
    }


}