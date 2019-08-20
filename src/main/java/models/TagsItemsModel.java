package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TagsItemsModel {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    @Override
    public boolean equals(Object o) {
        boolean rezult;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagsItemsModel tagsItemsModel = (TagsItemsModel) o;
        rezult = id == tagsItemsModel.getId() &&
                 name.equals(tagsItemsModel.getName());
        return rezult;
    }
}
