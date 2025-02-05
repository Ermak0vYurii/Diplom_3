package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    //кнопка Личный кабинет
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка Войти в аккаунт
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка Оформить заказ
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку Личный кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitLoadMainPage() {
        new WebDriverWait(driver, 3).
                until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

}
