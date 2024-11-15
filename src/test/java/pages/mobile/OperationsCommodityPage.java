package pages.mobile;

import static com.codeborne.selenide.Condition.visible;
import static driver.EmulatorHelper.collectionByResourceId;
import static driver.EmulatorHelper.elementByContentDesc;
import static driver.EmulatorHelper.elementByXpathText;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import java.time.Duration;

import io.qameta.allure.Step;
import lombok.Getter;
import pages.web.ArrivalInvoiceWeb;

/**
 * Страница Операции с товарами
 */
public class OperationsCommodityPage {
    private final SelenideAppiumElement titleListCommodity = elementByXpathText("Документы");

    private final SelenideAppiumCollection btnIcons = collectionByResourceId("icon-button");
    private final SelenideAppiumElement btnArrival = elementByContentDesc("Поступление");
    private final SelenideAppiumElement btnWriteOff = elementByContentDesc("Списание");
    private final SelenideAppiumElement btnWayBill = elementByContentDesc("Перемещение");
    private final SelenideAppiumElement btnCreateArrival = elementByContentDesc("Создать поступление товаров");
    @Getter
    private final SelenideAppiumElement btnCreateWriteOff = elementByContentDesc("Создать списание товаров");
    @Getter
    private final SelenideAppiumElement btnCreateWayBill = elementByContentDesc("Создать перемещение товаров");

    public OperationsCommodityPage() {
        titleListCommodity.shouldBe(visible, Duration.ofSeconds(5));
    }

}
