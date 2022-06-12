package selenium.decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;
import java.util.Optional;

public class WrapperFactory {
    private WrapperFactory() {}

    public static <T> T createInstance(Class<T> tClass, WebElement webElement, Field field) {
        By by = null;
        if (Optional.ofNullable(field).isPresent()) {
            by = new Annotations(field).buildBy();
        }
        try {
            return (T) tClass.getConstructor(WebElement.class, By.class).newInstance(webElement, by);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + tClass);
        }
    }
}
