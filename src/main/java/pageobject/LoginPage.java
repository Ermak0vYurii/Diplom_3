package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    //кнопка Войти
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    //гиперссылка Зарегистрироваться
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //методы


}
