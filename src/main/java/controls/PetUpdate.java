package controls;

import models.Pet;
import org.apache.commons.lang3.RandomStringUtils;

public class PetUpdate {
    private Pet oldPet;

    public Pet doUpdate(int id) {
        oldPet = new FormatFromJson().fromJson(id);
        oldPet.setName(RandomStringUtils.randomAlphabetic(10));
        oldPet.getCategory().setName(RandomStringUtils.randomAlphabetic(10));
        return oldPet;
    }

}
