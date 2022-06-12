package selenium.actions;

import Configurations.PropertiesManager;
import DriverFactory.DriverProvider;
import io.qameta.allure.Step;

public class NavigationActions {

    @Step("Navigate to  URL page")
    public void navigateToHomePage(){
        DriverProvider.getDriver().get(PropertiesManager.getBaseUrl());
    }
}
