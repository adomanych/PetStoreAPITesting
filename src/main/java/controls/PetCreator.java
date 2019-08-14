package controls;

import models.Category;
import models.Pet;
import models.TagsItems;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;

public class PetCreator {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(6));
    private String name = RandomStringUtils.randomAlphabetic(7);
    private Pet pet;

    public Pet createPet() {
        pet = Pet.builder()
                .id(id)
                .category(Category.builder()
                        .id(id)
                        .name(name)
                        .build())
                .name(name)
                .photoUrls(Collections.singletonList(RandomStringUtils.randomAlphabetic(10)))
                .tagsItems(Collections.singletonList(TagsItems.builder()
                        .id(id)
                        .name(name)
                        .build())
                )
                .status("avaliable")
                .build();
        return pet;
    }
}
