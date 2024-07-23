package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageHowToMakeOrder {
    //Заоголовок
    private static final By Header = By.xpath("/html/body/div/div/div[2]/div[1]");
    //Имя
    private static final By Name = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input");
    //Фамилия
    private static final By SurName = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/input");
    //Адресс
    private static final By Adress = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/input");    //Селектор метро
    //Метро
    private static final By Metro = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input");
    private static final By MetroOther = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]");
    //Телефон
    private static final By MobilePhone = By.xpath("/html/body/div/div/div[2]/div[2]/div[5]/input");
    //Кнопка Далее
    private static final By Next = By.xpath("/html/body/div/div/div[2]/div[3]/button");


    private WebDriver driver;

    public OrderPageHowToMakeOrder(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPageHowToMakeOrder enterName (String name) {
        driver.findElement(Name).sendKeys(name);
        return this;
    }

    public OrderPageHowToMakeOrder enterSurName (String surName) {
        driver.findElement(SurName).sendKeys(surName);
        return this;
    }

    public OrderPageHowToMakeOrder enterAdress (String adress) {
        driver.findElement(Adress).sendKeys(adress);
        return this;
    }

    public OrderPageHowToMakeOrder enterMetro () {
        driver.findElement(Metro).click();
        driver.findElement(MetroOther).click();
        return this;
    }

    public OrderPageHowToMakeOrder enterPhone (String phone) {
        driver.findElement(MobilePhone).sendKeys(phone);
        return this;
    }

    public OrderPageHowToMakeOrder clickNextButton() {
        driver.findElement(Next).click();
        return this;
    }
    public OrderPageHowToMakeOrder waitOrderPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement accordPanel =
                wait.until(ExpectedConditions.visibilityOfElementLocated(Header));
        return this;
    }
}
