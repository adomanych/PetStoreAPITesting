package business;

import com.google.gson.Gson;
import io.restassured.response.Response;
import client.pet.PetServices;
import models.PetModel;

public class ActionsWithJSON {
    private Response response;

    public PetModel fromJson(int id) {
        response = new PetServices().getPetByID(id);
        PetModel newPet = response.as(PetModel.class);
        return newPet;
    }

    public static String formatToJSon(PetModel pet) {
        Gson gson = new Gson();
        String toJson = gson.toJson(pet);
        return toJson;
    }
}
