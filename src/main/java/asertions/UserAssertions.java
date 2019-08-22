package asertions;

import models.UserModel;

import static org.testng.Assert.assertEquals;

public class UserAssertions {
    public static void areEquals(UserModel actual, UserModel expected) {
        assertEquals(actual, expected);
    }
}
