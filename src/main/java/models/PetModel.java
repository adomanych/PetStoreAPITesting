package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PetModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private CategoryModel category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<TagsItemsModel> tagsItems;
    @JsonProperty("status")
    private String status;

    @Getter
    public static enum Status {
        AVAILABLE("avaliable"), PENDING("pending"), SOLD("sold");
        private String value;

        Status(String value) {
            this.value = value;
        }

        public String toString() {
            return this.value;
        }
    }

    @Override
    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PetModel petModel = (PetModel) o;
        rezult = id == petModel.getId()
                && category.equals(petModel.getCategory())
                && name.equals(petModel.getName())
                && photoUrls.equals(petModel.getPhotoUrls())
                && tagsItems.equals(petModel.tagsItems)
                && status.equals(petModel.getStatus());
        return rezult;
    }

}
