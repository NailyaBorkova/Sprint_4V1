import model.MainPage;
import model.OrderPageConfirm;
import model.OrderPageHowToMakeOrder;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.core.StringContains.containsString;

@RunWith(Parameterized.class)
public class TestOrder {
    private final String name;
    private final String surName;
    private final String adress;
    private final String phone;
    private final String dateRent;
    private final String comment;
    private final ConstantEnum.Browser browser;
    private final MainPage.Button button;


    public TestOrder(String name, String surName, String adress,String phone,String dateRent,String comment,ConstantEnum.Browser browser,MainPage.Button button) {
        this.name = name;
        this.surName=surName;
        this.adress=adress;
        this.phone=phone;
        this.dateRent=dateRent;
        this.comment=comment;
        this.browser=browser;
        this.button=button;

    }
    @Parameterized.Parameters
    public static Object[] Next() {
        return new Object[][] {
                { "Наиля", "Боркова", "улица 8", "+79992225555","20.02.2024","vvv",ConstantEnum.Browser.CHROME,MainPage.Button.DOWN},
                { "Иван", "Иваер", "улица 9", "+79992225555","20.03.2024","ddd",ConstantEnum.Browser.FIREFOX,MainPage.Button.UP},
                { "Наиля", "Боркова", "улица 8", "+79992225555","20.02.2024","vvv",ConstantEnum.Browser.CHROME,MainPage.Button.UP},
                { "Иван", "Иваер", "улица 9", "+79992225555","20.03.2024","ddd",ConstantEnum.Browser.FIREFOX,MainPage.Button.DOWN},
        };
    }

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = getWebDriver(browser);
    }
    @After
    public void after() {
        driver.quit();
    }

    WebDriver getWebDriver(ConstantEnum.Browser browser) {
        switch (browser) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new RuntimeException("unable to create a web driver");
        }
    }

    @Test
    public void CheckTextPanelOnFireFox() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderButton(button);

        OrderPageHowToMakeOrder orderPageHowToMakeOrder =new OrderPageHowToMakeOrder(driver);
        orderPageHowToMakeOrder.waitOrderPage();
        orderPageHowToMakeOrder.enterName(name);
        orderPageHowToMakeOrder.enterSurName(surName);
        orderPageHowToMakeOrder.enterAdress(adress);
        orderPageHowToMakeOrder.enterMetro();
        orderPageHowToMakeOrder.enterPhone(phone);
        orderPageHowToMakeOrder.clickNextButton();

        OrderPageConfirm orderPageConfirm = new OrderPageConfirm(driver);
        orderPageConfirm.waitOrder2Page();
        orderPageConfirm.enterDate(dateRent);
        orderPageConfirm.enterSrok();
        orderPageConfirm.enterColor();
        orderPageConfirm.enterComment(comment);
        orderPageConfirm.enterNext();
        orderPageConfirm.waitModalWin();
        orderPageConfirm.enterYes();
        MatcherAssert.assertThat(orderPageConfirm.waitModalSucess(),containsString("Заказ оформлен"));


    }
}
