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
        userModel  = new UserCreateBuilders().createUser();
        userBL = new UserBL();
    }

    @Test
    public void firstTest() {
        userBL.addNewUserTest(userModel,200);
        userBL.deleteUserTest(userModel,200);
    }

    @Test
    public void addArrayOfUserTest() {
        userBL.addArrayOfUsersTest(2, 200);
    }

    @Test
    public void addListOfUserstest() {
        userBL.addListOfUsersTest(3, 200);
    }

    @Test
    public void TestLoginAndLogoutUser() {
        userBL.addNewUserTest(userModel,200);
        userBL.loginUserTest(userModel,200);
        userBL.logoutTest(userModel,200);
        userBL.deleteUserTest(userModel,200);
        userBL.getUserByUserNameTest(userModel,404);
    }

    @Test
    public void UpdateUserTest() {
        userBL.addNewUserTest(userModel,200);
        userBL.getUserByUserNameTest(userModel,200);
        userBL.userUpdate(userModel,200);
        userBL.deleteUserTest(userModel,200);
    }

//    @Test
//    public void TestWithInvalidData() {
//        userBL = new UserBL(new FailPetCreateBuilders().createFailPet());
//    }



}
