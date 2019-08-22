package clients;

import io.restassured.response.Response;
import models.UserModel;
import util.RestPath;

import static io.restassured.RestAssured.given;

public class UserClients extends BaseSetUp{

    public UserClients () {
        super(RestPath.userUrl);
    }

    public Response addNewUser(UserModel userModel) {
        return given(createRequest())
                .body(userModel)
                .post();
    }

    public Response deletePet(String userName) {
        return given(createRequest())
                .pathParam("username", userName)
                .delete("{username}");
    }

    public Response loginUser(String username, String password) {
        return given(createRequest())
                .queryParam("username", username)
                .queryParam("password", password)
                .get(RestPath.userLoginpath);
    }

    public Response logoutUser() {
        return given(createRequest())
                .get(RestPath.userLogout);
    }

    public Response getByUserName(String username) {
        return given(createRequest())
                .pathParam("username", username)
                .get("{username}");
    }

    public Response userUpdate(UserModel userModel, String username) {
        return given(createRequest())
                .pathParam("username", username)
                .body(userModel)
                .put("{username}");
    }

}
