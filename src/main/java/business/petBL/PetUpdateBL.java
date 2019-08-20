package business.petBL;

import models.PetModel;
import org.apache.commons.lang3.RandomStringUtils;

public class PetUpdateBL {


    public static PetModel doUpdate(PetModel petModel) {

        petModel.setName(RandomStringUtils.randomAlphabetic(10));
        petModel.getCategory().setName(RandomStringUtils.randomAlphabetic(10));

        return petModel;
    }

}
