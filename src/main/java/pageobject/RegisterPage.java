package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    //поле Имя
    private final By inputName = By.xpath(".//label[text()='Имя']");
    //поле Email
    private final By inputEmail = By.xpath(".//label[text()='Email']");
    //поле Пароль
    private final By inputPassword = By.xpath(".//input[@name='Пароль']");
    //кнопка зарегистрироваться
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //методы

}
