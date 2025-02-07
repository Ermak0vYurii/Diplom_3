package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import pojo.User;

import static api.Endpoints.*;
import static io.restassured.RestAssured.given;

public class UserClient extends BaseHttpClient {

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
