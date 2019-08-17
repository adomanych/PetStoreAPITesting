package business;

import models.PetModel;
import org.apache.commons.lang3.RandomStringUtils;

public class PetUpdate {
    private PetModel oldPet;


    public PetModel doUpdate(int id) {
        oldPet = new ActionsWithJSON().fromJson(id);
        oldPet.setName(RandomStringUtils.randomAlphabetic(10));
        oldPet.getCategory().setName(RandomStringUtils.randomAlphabetic(10));
        return oldPet;
    }

}
