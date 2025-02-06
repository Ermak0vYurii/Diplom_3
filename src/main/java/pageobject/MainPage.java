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
    //кнопка выбора раздела конструктора Булки
    private final By sectionBunsButton = By.xpath(".//span[text()='Булки']");
    //кнопка выбора раздела конструктора Соусы
    private final By sectionSaucesButton = By.xpath(".//span[text()='Соусы']");
    //кнопка выбора раздела конструктора Начинки
    private final By sectionFillingsButton = By.xpath(".//span[text()='Начинки']");
    //список булок в разделе Булки
    private final By bunsInConstructor = By.xpath(".//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6d']/parent::ul");

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

    @Step("Нажатие на раздел конструктора Булки")
    public void clickBunsButton() {
        driver.findElement(sectionBunsButton).click();
    }

    @Step("Нажатие на раздел конструктора Соусы")
    public void clickSaucesButton() {
        driver.findElement(sectionSaucesButton).click();
    }

    @Step("Нажатие на раздел конструктора Булки")
    public void clickFillingsButton() {
        driver.findElement(sectionFillingsButton).click();
    }

    @Step("Виден ли список булок")
    public boolean listBunsIsDisplayed() {
        return driver.findElement(bunsInConstructor).isDisplayed();
    }

}
