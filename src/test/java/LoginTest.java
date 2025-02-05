import api.UserClient;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pojo.User;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    MainPage objMainPage;
    LoginPage objLoginPage;
    RegisterPage objRegisterPage;
    User user;
    protected UserClient client;
    protected String token;

    @Before
    public void setUp() {
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        client = new UserClient();
        user = new User("user-test@ya.ru", "password", "Ivan");
        Response response = client.createUser(user);
        token = response.then().extract().path("accessToken");
    }

    @After
    public void cleanUp() {
        if(token != null) {
            client.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Вход по кнопке \"Войти в аккаунт\" на главной странице")
    public void loginToAccountButtonTest() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        objMainPage.clickLoginButton();
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        objMainPage.waitLoadMainPage();
        assertEquals(URL,driver.getCurrentUrl());
    }
}
