import api.UserClient;
import io.restassured.response.Response;
import org.junit.Before;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;
import pojo.User;

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
        token = response.
    }
}
