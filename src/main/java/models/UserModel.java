package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("password")
    private String password;

    @JsonProperty("userStatus")
    private int userStatus;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("id")
    private int id;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserModel userModel = (UserModel) o;

        return firstName.equals(userModel.getFirstName())
                && lastName.equals(userModel.getLastName())
                && password.equals(userModel.getPassword())
                && userStatus == userModel.getUserStatus()
                && phone.equals(userModel.getPhone())
                && id == userModel.getId()
                && email.equals(userModel.getEmail())
                && username.equals(userModel.getUsername());

    }
}