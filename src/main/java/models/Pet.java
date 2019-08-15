package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Pet {
    @JsonProperty("id")
    private int id;
    @JsonProperty("category")
    private Category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls;
    @JsonProperty("tags")
    private List<TagsItems> tagsItems;
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
}
