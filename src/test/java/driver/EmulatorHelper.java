package driver;
//Взаимодействуем с драйвером через методы

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;
import static org.openqa.selenium.By.xpath;
import static config.ConfigReader.platformAndroid;
import static config.ConfigReader.platformIOS;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * Класс помощник для Page страниц
 */
public class EmulatorHelper extends EmulatorDriver { //Наследуемся от класса EmulatorDriver, поэтому есть доступ к переменной driver
    /**
     * Нажимает кнопку назад
     */
    public static void goBack() { //Метод для перехода назад
        driver.navigate().back();
    }

    /**
     * Закрывает клавиатуру если она есть
     */
    public static void closeKeyBoard() { //Метод для закрытия клавиатуры
        if (platformAndroid) {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            if (androidDriver.isKeyboardShown()) { //Если клавиатура открыта, то далее закрываем ее
                androidDriver.hideKeyboard();
            }
        } else if (platformIOS) {
            IOSDriver iosDriver = (IOSDriver) driver;
            if (iosDriver.isKeyboardShown()) { //Если клавиатура открыта, то далее закрываем ее
                iosDriver.hideKeyboard();
            }
        }
    }

    /**
     * Вводит текст и нажимает Enter (Enter при необходимости; можно также и другие команды подставить)
     *
     * @param element поле для ввода
     * @param text    текст
     */
    public static void sendKeysAndFind(SelenideElement element, String text) { //Метод для ввода данных в поля
        element.should(visible).sendKeys(text);
//        driver.pressKey(new KeyEvent(AndroidKey.ENTER)); //Вызываем метод для нажатия кнопки ENTER
    }

//    /**
//     * Листает к элементу по его тексту без нажатия
//     *
//     * @param text текст на элементе
//     */
//    public static void androidScrollToAnElementByText(String text) { // Метод для скроллинга к методу, который определен по тексту
//        String command = "new UiScrollable(new UiSelector()" + //Метод UiCrollable отправляется к Appium вдвойне на обработку, с помощью Selector ищем возможность пролистать, берем самое 1-е значение и через ScrollIntoView пролистываем к элементу, текст которого будет передан в новый UiSelector
//                ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
//                ".textContains(\"" + text + "\").instance(0))";
//        if (platformAndroid) {
//            AndroidDriver androidDriver = (AndroidDriver) driver;
//            (androidDriver).findElementByAndroidUIAutomator(command); //Вызываем метод UIAutomator и передаем описанную выше команду
//        } else if (platformIOS) {
//            IOSDriver iosDriver = (IOSDriver) driver;
//            (iosDriver).findElement(MobileBy.iOSNsPredicateString(command)); //Вызываем метод UIAutomator и передаем описанную выше команду
//        }
//    }
//
//    /**
//     * Листает к 1-му элементу по его тексту и нажимает на элемент
//     *
//     * @param text текст на элементе
//     */
//    public static void androidScrollToAnElementByTextWithClick(String text) { // Метод для скроллинга к методу, который определен по тексту
//        String command = "new UiScrollable(new UiSelector()" + //Метод UiCrollable отправляется к Appium вдвойне на обработку, с помощью Selector ищем возможность пролистать, берем самое 1-е значение и через ScrollIntoView пролистываем к элементу, текст которого будет передан в новый UiSelector
//                ".scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
//                ".textContains(\"" + text + "\").instance(0))";
//        if (platformAndroid) {
//            AndroidDriver androidDriver = (AndroidDriver) driver;
//            (androidDriver).findElementByAndroidUIAutomator(command).click(); //Вызываем метод UIAutomator и передаем описанную выше команду
//        } else if (platformIOS) {
//            IOSDriver iosDriver = (IOSDriver) driver;
//            (iosDriver).findElement(MobileBy.iOSNsPredicateString(command)).click(); //Вызываем метод UIAutomator и передаем описанную выше команду
//        }
//    }
//
//    /**
//     * Листает к следующему за 1-м элементом 2-му элементу по его тексту и нажимает на элемент
//     *
//     * @param text текст на элементе
//     */
//    public static void androidScrollToAnElementBySecondTextWithClick(String text) { // Метод для скроллинга к методу, который определен по тексту
//        String command = "new UiScrollable(new UiSelector()" + //Метод UiCrollable отправляется к Appium вдвойне на обработку, с помощью Selector ищем возможность пролистать, берем самое 1-е значение и через ScrollIntoView пролистываем к элементу, текст которого будет передан в новый UiSelector
//                ".scrollable(true).instance(1)).scrollIntoView(new UiSelector()" +
//                ".textContains(\"" + text + "\").instance(1))";
//        if (platformAndroid) {
//            AndroidDriver androidDriver = (AndroidDriver) driver;
//            (androidDriver).findElementByAndroidUIAutomator(command).click(); //Вызываем метод UIAutomator и передаем описанную выше команду
//        } else if (platformIOS) {
//            IOSDriver iosDriver = (IOSDriver) driver;
//            (iosDriver).findElement(MobileBy.iOSNsPredicateString(command)).click(); //Вызываем метод UIAutomator и передаем описанную выше команду
//        }
//    }

    /**
     * Имитирует свайп для обновления страницы (например, потянуть вниз).
     * Для использования передаем: xpath-локатор элемента в параметры; направление: right, left, down, up; процент смахивания относительно ширины или высоты
     */
    public static void swipeToRefresh(SelenideElement element, String direction, int percent) {
        String elementId = ((RemoteWebElement) element.getWrappedElement()).getId();

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", elementId);
        params.put("percentage", percent);
        params.put("direction", direction);

        // Выполняем свайп
        driver.executeScript("gesture: swipe", params);
    }

//    /**
//     * Имитирует свайп для поиска определенного элемента .
//     * Для использования передаем: xpath-локатор элемента в параметры; целевой атрибут xpath; направление: right, left, down, up; процент смахивания относительно ширины или высоты
//     */
//    public static void scrollElementIntoView(SelenideElement elementScroll, String findElement, String direction, int percent) {
//
//        Map<String, Object> params = new HashMap<>();
//        params.put("scrollableView", elementScroll.should(visible).getId());
//        params.put("strategy", "xpath");
//        params.put("selector", findElement);
//        params.put("percentage", percent);
//        params.put("direction", direction);
//        params.put("maxCount", 3);
//
//        driver.executeScript("gesture: scrollElementIntoView", params);
//    }

    /**
     * Метод для клика с задержкой
     */
    public static void slowClick(SelenideElement element) {
        actions().moveToElement(element).pause(3000).click().perform(); // Задержка в 3 секунд (3000 миллисекунд)
    }

    /**
     * Метод для обращения по xpath
     *
     * @param xpath
     * @return
     */
    public static SelenideAppiumElement elementByXpath(String xpath) {
        return $x(xpath);
    }

    /**
     * Метод для обращения по xpath(resourceId)
     *
     * @param resourceId
     * @return
     */
    public static SelenideAppiumCollection collectionByResourceId(String resourceId) {
        return $$(xpath("//*[@resource-id='" + resourceId + "']"));
    }

    /**
     * Метод для обращения по xpath(className)
     *
     * @param className
     * @return
     */
    public static SelenideAppiumElement elementByClass(String className) {
        return $x("//" + className);
    }

    /**
     * Метод для обращения по xpath(className)
     *
     * @param text
     * @return
     */
    public static SelenideAppiumElement elementByXpathText(String text) {
        return $x("//*[@text='" + text + "']");
    }

    /**
     * Метод для обращения по xpath(className)
     *
     * @param contentDesc
     * @return
     */
    public static SelenideAppiumElement elementByContentDesc(String contentDesc) {
        return $x("//*[@content-desc='" + contentDesc + "']");
    }

    /**
     * Метод для обращения по xpath(className)
     *
     * @param id
     * @return
     */
    public static SelenideAppiumElement elementById(String id) {
        return $(By.id(id));
    }
}
