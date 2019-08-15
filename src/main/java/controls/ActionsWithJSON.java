package controls;

import com.google.gson.Gson;
import io.restassured.response.Response;
import methodsAPI.PetServices;
import models.Pet;

public class ActionsWithJSON {
    private Response response;

    public Pet fromJson(int id) {
        response = new PetServices().getPetByID(id);
        Pet newPet = response.as(Pet.class);
        return newPet;
    }

    public static String formatToJSon(Pet pet) {
        Gson gson = new Gson();
        String toJson = gson.toJson(pet);
        return toJson;
    }
}
