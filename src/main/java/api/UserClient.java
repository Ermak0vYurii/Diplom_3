package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.User;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseHttpClient {

    public static final String CREATE_USER = "api/auth/register";
    public static final String DELETE_USER = "api/auth/user";
    public static final String LOGIN_USER = "api/auth/login";

    @Step("Регистрация пользователя")
    public Response createUser(User user) {
        return given()
                .spec(requestSpec())
                .body(user)
                .post(CREATE_USER);
    }

    @Step("Авторизация пользователя")
    public Response loginUser(User user) {
        return given()
                .spec(requestSpec())
                .body(user)
                .post(LOGIN_USER);
    }

    @Step("Удаление пользователя")
    public void deleteUser(String token) {
        given()
                .spec(requestSpec())
                .header("Authorization", token)
                .delete(DELETE_USER);
    }
}
