package controls;

import com.google.gson.Gson;
import models.Pet;

public class FormatToJSon {
    public static String formatToJSon(Pet pet) {
        Gson gson = new Gson();
        String toJson = gson.toJson(pet);
        return toJson;
    }
}
