package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class OrderPageConfirm {
        //Заоголовок
        private static final By Header = By.xpath("/html/body/div/div/div[2]/div[1]");
        // Дата
        private static final By Date = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
        //Срок
        private static final By Srok = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
        //Срок 2е суток
        private static final By Srok2day = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[2]");
        //Цвет
        private static final By Color = By.xpath("/html/body/div/div/div[2]/div[2]/div[3]/label[1]");
        //Коментарий курьеру
        private static final By Comment = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
        //Кнопка далее
        private static final By Next = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");
        //Окно утверждения
        private static final By ModalWin = By.className ("Order_ModalHeader__3FDaJ");
        //Кнопка да
        private static final By Yes = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
        //Окно успеха заказа
        private static final By ModalSuccess = By.xpath ("/html/body/div/div/div[2]/div[5]/div[1]");



        private WebDriver driver;


        public OrderPageConfirm(WebDriver driver) {
            this.driver = driver;
        }

        public OrderPageConfirm enterDate (String date) {
            driver.findElement(Date).sendKeys(date);
            return this;
        }

        public OrderPageConfirm enterSrok () {
            driver.findElement(Header).click();
            driver.findElement(Srok).click();
            driver.findElement(Srok2day).click();
            return this;
        }

        public OrderPageConfirm enterColor () {
            driver.findElement(Color).click();
            return this;
        }

        public OrderPageConfirm enterComment (String comment) {
            driver.findElement(Comment).sendKeys(comment);
            return this;
        }

        public OrderPageConfirm enterNext () {
            driver.findElement(Next).click();
            return this;
        }

        public OrderPageConfirm waitOrder2Page() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement accordPanel =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Header));
            return this;
        }
        public OrderPageConfirm waitModalWin() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement accordPanel =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ModalWin));
            return this;
        }

        public OrderPageConfirm enterYes () {
            driver.findElement(Yes).click();
            return this;
        }

        public String waitModalSucess() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement accordPanel =
                    wait.until(ExpectedConditions.visibilityOfElementLocated(ModalSuccess));
            return driver.findElement(ModalSuccess).getText();
        }


    }


