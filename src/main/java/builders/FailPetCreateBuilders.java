package builders;

import failModels.PetFailModel;
import org.apache.commons.lang3.RandomStringUtils;

public class FailPetCreateBuilders {
    private String id = RandomStringUtils.randomAlphabetic(3);
    private int name = Integer.parseInt(RandomStringUtils.randomNumeric(3));
    private int status = Integer.parseInt(RandomStringUtils.randomNumeric(3));
    public PetFailModel createFailPet() {
        return PetFailModel.builder()
                .id(id)
                .name(name)
                .status(status)
                .build();
    }
}
