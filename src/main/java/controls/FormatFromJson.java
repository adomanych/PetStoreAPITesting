package controls;

import io.restassured.response.Response;
import methodsAPI.ManipulationWithPet;
import models.Pet;

public class FormatFromJson {
    private Response response;

    public Pet fromJson(int id) {
        response = new ManipulationWithPet().getPet(id);
        Pet newPet = response.as(Pet.class);
        return newPet;
    }
}