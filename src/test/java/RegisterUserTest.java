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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterUserTest extends BaseTest {

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
        objMainPage.clickLoginButton();
        objLoginPage.clickRegisterButton();
    }

    @After
    public void cleanUp() {
        if(token != null) {
            client.deleteUser(token);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void successRegisterTest() {
        user = new User("user-test@ya.ru", "password", "Ivan");
        objRegisterPage.registerUser(user.getName(), user.getEmail(), user.getPassword());
        objLoginPage.waitOfVisibilityEnterButton();
        assertTrue(objLoginPage.enterButtonIsDisplayed());
        Response response = client.loginUser(user);
        token = response.then().extract().path("accessToken");
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля")
    public void registerWithIncorrectPasswordTest() {
        user = new User("user-test@ya.ru", "pass", "Ivan");
        objRegisterPage.registerUser(user.getName(), user.getEmail(), user.getPassword());
        String actualErrorMessage = objRegisterPage.getErrorMessagePasswordField();
        assertEquals("Неверное сообщение об ошибке", actualErrorMessage, "Некорректный пароль");
    }
}