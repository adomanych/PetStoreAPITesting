package business.petBL;

import io.restassured.response.Response;
import models.PetModel;

public class PetFromJsonBL {


    public static PetModel fromJson(Response response) {
        return response.as(PetModel.class);

    }
}
