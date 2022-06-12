package selenium.decorator;

import org.openqa.selenium.*;

import java.util.List;

public class PageElement implements WebElement {
    protected WebElement webElement;
    protected By locator;

    protected PageElement(WebElement webElement, By locator){
       this.webElement = webElement;
       this.locator = locator;
    }
    public By getLocator() {
        return this.locator;
    }

    public WebElement getWebElement() {
        return this.webElement;
    }

    public boolean isElementPresent(){
        try{
            webElement.isDisplayed();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public void click() {
        webElement.click();
    }

    @Override
    public void submit() {
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    public boolean isDisplayed() {
        return this.webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }
}

