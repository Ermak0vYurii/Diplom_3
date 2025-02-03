package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public static final String URL = "https://stellarburgers.nomoreparties.site/";

    //кнопка Личный кабинет
    private final By personalAccountButton = By.className("AppHeader_header__link__3D_hX");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

}
