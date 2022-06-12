package DriverFactory;

import Configurations.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static final Logger logger = LogManager.getLogger(DriverProvider.class);

    private static  ThreadLocal<WebDriver> DRIVER_POOL = new ThreadLocal<>();

    private static WebDriver createDriver() {
        System.setProperty(PropertiesManager.getChromeDriver(), PropertiesManager.getChromeDriverPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(PropertiesManager.getImplicitTime(), TimeUnit.SECONDS);
        logger.info("Driver has been created");
        return driver;
    }

    public static WebDriver getDriver() {
        if (DRIVER_POOL.get() == null) {
            DRIVER_POOL.set(createDriver());
        }
        return DRIVER_POOL.get();
    }

    public static void quitDriver() {
        if (DRIVER_POOL.get() != null) {
            DRIVER_POOL.get().close();
            DRIVER_POOL.get().quit();
            DRIVER_POOL.remove();
            logger.info("Driver closed");
        }
    }

    private DriverProvider() {
    }
}