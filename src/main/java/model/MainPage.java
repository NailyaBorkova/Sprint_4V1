package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class MainPage {

    private static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public enum Button {
        UP,
        DOWN;
    }
    // Элемент кнопок расскрывающихся описаний
    private static final By ACCRODHEAD_0 = By.id("accordion__heading-0");
    private static final By ACCRODHEAD_1 = By.id("accordion__heading-1");
    private static final By ACCRODHEAD_2 = By.id("accordion__heading-2");
    private static final By ACCRODHEAD_3 = By.id("accordion__heading-3");
    private static final By ACCRODHEAD_4 = By.id("accordion__heading-4");
    private static final By ACCRODHEAD_5 = By.id("accordion__heading-5");
    private static final By ACCRODHEAD_6 = By.id("accordion__heading-6");
    private static final By ACCRODHEAD_7 = By.id("accordion__heading-7");

    // Элементы выпадающего описания
    private static final By ACCRODPANEL_0 = By.id("accordion__panel-0");
    private static final By ACCRODPANEL_1 = By.id("accordion__panel-1");
    private static final By ACCRODPANEL_2 = By.id("accordion__panel-2");
    private static final By ACCRODPANEL_3 = By.id("accordion__panel-3");
    private static final By ACCRODPANEL_4 = By.id("accordion__panel-4");
    private static final By ACCRODPANEL_5 = By.id("accordion__panel-5");
    private static final By ACCRODPANEL_6 = By.id("accordion__panel-6");
    private static final By ACCRODPANEL_7 = By.id("accordion__panel-7");

    //Соответсвтвие заголовка и панели
    private static final HashMap<By, By> ACCROD = new HashMap<>();
        {
            ACCROD.put(ACCRODHEAD_0,ACCRODPANEL_0);
        ACCROD.put(ACCRODHEAD_1,ACCRODPANEL_1);
        ACCROD.put(ACCRODHEAD_2,ACCRODPANEL_2);
        ACCROD.put(ACCRODHEAD_3,ACCRODPANEL_3);
        ACCROD.put(ACCRODHEAD_4,ACCRODPANEL_4);
        ACCROD.put(ACCRODHEAD_5,ACCRODPANEL_5);
        ACCROD.put(ACCRODHEAD_6,ACCRODPANEL_6);
        ACCROD.put(ACCRODHEAD_7,ACCRODPANEL_7);
        }
    //Кнопки "Заказать" главного экрана
    private static final By UP_ORDER = By.xpath("//button[@class='Button_Button__ra12g']");
    private static final By DOWN_ORDER = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(PAGE_URL);
        return this;
    }

    public String AccordPanelText(By AccordHead) {
        WebElement element = driver.findElement(AccordHead);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(AccordHead).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement accordPanel =
                wait.until(ExpectedConditions.visibilityOfElementLocated(ACCROD.get(AccordHead)));

        return driver.findElement(ACCROD.get(AccordHead)).getText();
    }

    //Параметризована кнопка заказа- верхняя или нижняя.
    public MainPage clickOrderButton(Button button) {
        switch (button) {
            case UP:
                driver.findElement(UP_ORDER).click();
                return this;
            case DOWN:
                WebElement elementButton = driver.findElement(DOWN_ORDER);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elementButton);
                driver.findElement(DOWN_ORDER).click();
                return this;
            default:
                throw new RuntimeException("unable to button");
        }
    }
}
