package DriverFactory;

import Configurations.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverBuilder {

    private static final Logger logger = LogManager.getLogger(DriverBuilder.class);

    protected static WebDriver createDriver() {
        System.setProperty(PropertiesManager.getChromeDriver(), PropertiesManager.getChromeDriverPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(PropertiesManager.getImplicitTime(), TimeUnit.SECONDS);
        logger.info("Driver has been created");
        return driver;
    }

    private DriverBuilder() {
    }
}
