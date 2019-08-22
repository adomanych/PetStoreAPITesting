package business;

import asertions.BaseAssertions;
import asertions.UserAssertions;
import builders.UserCreateBuilders;
import clients.UserClients;
import io.restassured.response.Response;
import models.UserModel;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserBL {

    private UserClients userClients = new UserClients();
    private Response response;
    private UserModel [] userModelArray;
    private List<UserModel> userModelList;



    private UserModel[] createArrayOfUsers(int countOfUsers) {
        UserModel [] rezult = new UserModel[countOfUsers];
        for (int i = 0; i < countOfUsers; i++) {
            rezult[i] = new UserCreateBuilders().createUser();
        }
        return rezult;
    }

    private List<UserModel> createListOfUsers(int countOfUsers) {
        return  IntStream.range(0, countOfUsers)
                .mapToObj(el -> new UserCreateBuilders().createUser())
                .collect(Collectors.toList());
    }

    private UserModel doUpdate(UserModel user) {

        user.setUserStatus(Integer.parseInt(RandomStringUtils.randomNumeric(2)));
        user.setPhone( "+380" + RandomStringUtils.randomAlphabetic(7));
        user.setEmail(UserCreateBuilders.createEmail());

        return user;
    }






    public void addNewUserTest(UserModel userModel, int statusCode) {
        response = userClients.addNewUser(userModel);
        BaseAssertions.baseAssert(response, statusCode);
        UserAssertions.areEquals(response.getBody().as(UserModel.class), userModel);
    }

    public void deleteUserTest(UserModel userModel, int statusCode) {
        response = userClients.deletePet(userModel.getUsername());
        BaseAssertions.baseAssert(response, statusCode);

    }

    public void addArrayOfUsersTest(int countOfUser, int statusCode) {
        userModelArray = createArrayOfUsers(countOfUser);
        for (int i = 0; i < countOfUser; i++) {
            response = userClients.addNewUser(userModelArray[i]);
            BaseAssertions.baseAssert(response, statusCode);
            UserAssertions.areEquals(response.getBody().as(UserModel.class), userModelArray[i]);
            response = userClients.deletePet(userModelArray[i].getUsername());
            BaseAssertions.baseAssert(response, statusCode);
        }
    }

    public void addListOfUsersTest(int countOfUser, int statusCode) {
        userModelList = createListOfUsers(countOfUser);
        for (UserModel testModel: userModelList) {
            response = userClients.addNewUser(testModel);
            BaseAssertions.baseAssert(response, statusCode);
            UserAssertions.areEquals(response.getBody().as(UserModel.class), testModel);
            response = userClients.deletePet(testModel.getUsername());
            BaseAssertions.baseAssert(response, statusCode);
        }

    }

    public void loginUserTest(UserModel userModel, int statusCode) {
        response = userClients.loginUser(userModel.getUsername(), userModel.getPassword());
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void logoutTest(UserModel userModel, int statusCode) {
        response = userClients.logoutUser();
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void getUserByUserNameTest(UserModel userModel, int statusCode) {
        response = userClients.getByUserName(userModel.getUsername());
        BaseAssertions.baseAssert(response, statusCode);
    }

    public void userUpdate(UserModel userModel, int statusCode) {
        UserModel userModelUpdate = userClients.getByUserName(userModel.getUsername()).as(UserModel.class);
        response = userClients.userUpdate(doUpdate(userModelUpdate), userModelUpdate.getUsername());
        BaseAssertions.baseAssert(response, statusCode);
        UserAssertions.areEquals(response.getBody().as(UserModel.class), userModelUpdate);
    }


}
