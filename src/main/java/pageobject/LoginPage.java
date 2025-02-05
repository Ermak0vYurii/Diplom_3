package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    //кнопка Войти
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    //гиперссылка Зарегистрироваться
    private final By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на гиперссылку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Ожидание видимости кнопки Войти")
    public void waitOfVisibilityEnterButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterButton));
    }

    @Step("Проверка видимости кнопки Войти")
    public boolean enterButtonIsDisplayed() {
       return driver.findElement(enterButton).isDisplayed();
    }

}
