package selenium.decorator;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.*;
import java.util.List;

public class CustomFieldDecorator extends DefaultFieldDecorator {


    public CustomFieldDecorator(SearchContext searchContext) {

        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<PageElement> decoratableClass = decoratableClass(field);
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }
            if (List.class.isAssignableFrom(field.getType())) {
                return createList(loader, locator, decoratableClass, field);
            }
            return createElement(loader, locator, decoratableClass, field);
        }
        return super.decorate(loader, field);
    }

    @SuppressWarnings("unchecked")
    private Class<PageElement> decoratableClass(Field field) {
        Class<?> clazz = field.getType();
        if (List.class.isAssignableFrom(clazz)) {
            if (field.getAnnotation(FindBy.class) == null &&
                    field.getAnnotation(FindBys.class) == null) {
                return null;
            }

            Type genericType = field.getGenericType();
            if (!(genericType instanceof ParameterizedType)) {
                return null;
            }
            clazz = (Class<?>) ((ParameterizedType) genericType).
                    getActualTypeArguments()[0];
        }
        if (PageElement.class.isAssignableFrom(clazz)) {
            return (Class<PageElement>) clazz;
        } else {
            return null;
        }
    }

    protected PageElement createElement(ClassLoader loader, ElementLocator locator, Class<PageElement> tClass, Field field) {
        WebElement proxy = proxyForLocator(loader, locator);
        return WrapperFactory.createInstance(tClass, proxy, field);
    }

    @SuppressWarnings("unchecked")
    protected List<PageElement> createList(ClassLoader loader, ElementLocator locator, Class<PageElement> clazz, Field field) {
        InvocationHandler handler = new LocatingCustomElementListHandler(locator, clazz, field);
        return (List<PageElement>) Proxy.newProxyInstance(loader, new Class[]{List.class}, handler);
    }

}

