package io.swagger.petstore;

import builders.UserCreateBuilders;
import business.UserBL;
import models.UserModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest {
    private UserModel userModel;
    private UserBL userBL;


    @BeforeClass
    public void setUp() {
        userModel = new UserCreateBuilders().createUser();
        userBL = new UserBL();
    }

    @Test
    public void firstTest() {
        userBL.addNewUserTest(userModel);
        userBL.deleteUserTest(userModel);
    }

    @Test
    public void addArrayOfUserTest() {
        userBL.addArrayOfUsersTest(2);
    }

    @Test
    public void addListOfUserstest() {
        userBL.addListOfUsersTest(3);
    }

    @Test
    public void TestLoginAndLogoutUser() {
        userBL.addNewUserTest(userModel);
        userBL.loginUserTest(userModel);
        userBL.logoutTest(userModel);
        userBL.deleteUserTest(userModel);
        userBL.getUserByInvalidUsername(userModel);
    }

    @Test
    public void UpdateUserTest() {
        userBL.addNewUserTest(userModel);
        userBL.getUserByUserNameTest(userModel);
        userBL.userUpdate(userModel);
        userBL.deleteUserTest(userModel);
    }


}
