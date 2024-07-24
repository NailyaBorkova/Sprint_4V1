import model.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class AccrodTextTest {
     private final By accrodHead;
     private final String expected;
     private final ConstantEnum.Browser browser;

    private static final By ACCRODHEAD_0 = By.id("accordion__heading-0");
    private static final By ACCRODHEAD_1 = By.id("accordion__heading-1");
    private static final By ACCRODHEAD_2 = By.id("accordion__heading-2");
    private static final By ACCRODHEAD_3 = By.id("accordion__heading-3");
    private static final By ACCRODHEAD_4 = By.id("accordion__heading-4");
    private static final By ACCRODHEAD_5 = By.id("accordion__heading-5");
    private static final By ACCRODHEAD_6 = By.id("accordion__heading-6");
    private static final By ACCRODHEAD_7 = By.id("accordion__heading-7");

    private static final String ACCRODPANELTEXT_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ACCRODPANELTEXT_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ACCRODPANELTEXT_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ACCRODPANELTEXT_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ACCRODPANELTEXT_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ACCRODPANELTEXT_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ACCRODPANELTEXT_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ACCRODPANELTEXT_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public AccrodTextTest(By accrodHead, String expected, ConstantEnum.Browser browser) {
        this.accrodHead = accrodHead;
        this.expected=expected;
        this.browser=browser;
    }
    @Parameterized.Parameters
    //В парамтрах к запуску теста передается нужный для взаимодействия элемент, ожидаемый текст на элементе, браузер для проверки
    public static Object[] getText() {
        return new Object[][] {
                {ACCRODHEAD_0, ACCRODPANELTEXT_0,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_1, ACCRODPANELTEXT_1,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_2, ACCRODPANELTEXT_2,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_3, ACCRODPANELTEXT_3,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_4, ACCRODPANELTEXT_4,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_5, ACCRODPANELTEXT_5,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_6, ACCRODPANELTEXT_6,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_7, ACCRODPANELTEXT_7,ConstantEnum.Browser.CHROME},
                {ACCRODHEAD_0, ACCRODPANELTEXT_0,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_1, ACCRODPANELTEXT_1,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_2, ACCRODPANELTEXT_2,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_3, ACCRODPANELTEXT_3,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_4, ACCRODPANELTEXT_4,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_5, ACCRODPANELTEXT_5,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_6, ACCRODPANELTEXT_6,ConstantEnum.Browser.FIREFOX},
                {ACCRODHEAD_7, ACCRODPANELTEXT_7,ConstantEnum.Browser.FIREFOX}
                // передали тестовые данные
        };
    }
//Заводим общий драйвер браузера
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
    public void CheckTextPanel() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPageChrome = new MainPage(driver);
        Assert.assertEquals(mainPageChrome.AccordPanelText(accrodHead), expected);
    }


}

