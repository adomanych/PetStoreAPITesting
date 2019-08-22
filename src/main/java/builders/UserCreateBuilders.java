package builders;

import models.UserModel;
import org.apache.commons.lang3.RandomStringUtils;

public class UserCreateBuilders {
    private String userFirstName = RandomStringUtils.randomAlphabetic(8);
    private String userLastName = RandomStringUtils.randomAlphabetic(8);
    private String password = RandomStringUtils.randomAlphabetic(6);
    private int userStatus = Integer.parseInt(RandomStringUtils.randomNumeric(1));
    private String phone = "+380" + RandomStringUtils.randomNumeric(7);
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(6));
    private String email = createEmail();
    private String userName = RandomStringUtils.randomAlphabetic(6);

    public UserModel createUser() {
        return UserModel.builder()
                .firstName(userFirstName)
                .lastName(userLastName)
                .password(password)
                .userStatus(userStatus)
                .phone(phone)
                .id(id)
                .email(email)
                .username(userName)
                .build();

    }

    public static String createEmail() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RandomStringUtils
                .randomAlphabetic(6))
                .append("@gmail.com");
        return stringBuilder.toString();
    }
}
