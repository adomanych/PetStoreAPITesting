package business;

import models.CategoryModel;
import models.PetModel;
import models.TagsItemsModel;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;

public class PetCreate {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(6));
    private String name = RandomStringUtils.randomAlphabetic(7);
    private PetModel pet;

    public PetModel createPet() {
        pet = PetModel.builder()
                .id(id)
                .category(CategoryModel.builder()
                        .id(id)
                        .name(name)
                        .build())
                .name(name)
                .photoUrls(Collections.singletonList(RandomStringUtils.randomAlphabetic(10)))
                .tagsItems(Collections.singletonList(TagsItemsModel.builder()
                        .id(id)
                        .name(name)
                        .build())
                )
                .status("avaliable")
                .build();
        return pet;
    }
}
