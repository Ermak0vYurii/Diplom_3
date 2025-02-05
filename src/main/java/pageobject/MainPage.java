package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    //кнопка Личный кабинет
    private final By personalAccountButton = By.className("AppHeader_header__link__3D_hX");
    //кнопка Войти в аккаунт
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
