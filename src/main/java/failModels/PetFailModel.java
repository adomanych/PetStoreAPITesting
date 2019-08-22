package failModels;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PetFailModel {
    private String id;
    private int name;
    private int status;
}
