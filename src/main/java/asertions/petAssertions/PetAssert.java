package asertions.petAssertions;

import lombok.NoArgsConstructor;
import models.CategoryModel;
import models.PetModel;
import models.TagsItemsModel;
import org.testng.asserts.SoftAssert;

import java.util.List;

@NoArgsConstructor
public class PetAssert {

    private static PetModel actual;
    private static SoftAssert softAssertions = new SoftAssert();


    public static PetAssert assertThat(PetModel petModel) {
        actual = petModel;
        return new PetAssert();

    }

    public PetAssert hasId(int id) {

        int actualId = actual.getId();
        softAssertions.assertEquals(actualId, id);

        return this;

    }


    public PetAssert hasName(String name) {
        String actualName = actual.getName();
        softAssertions.assertEquals(actualName, name);
        return this;
    }

    public PetAssert hasCategory(CategoryModel categoryModel) {
        CategoryModel actualCategoryModel = actual.getCategory();
        softAssertions.assertEquals(actualCategoryModel, categoryModel);

        return this;
    }

    public PetAssert hasListOfPhotoUrls(List<String> photooUrls) {

        List<String> actualPhotoUrls = actual.getPhotoUrls();
        softAssertions.assertEquals(actualPhotoUrls, photooUrls);

        return this;

    }

    public PetAssert hasListOfTagsItems(List<TagsItemsModel> tagsItemsModelList) {


        List<TagsItemsModel> actualTagsItemsList = actual.getTagsItems();
        for (int i = 0; i < actualTagsItemsList.size(); i++) {
            softAssertions.assertEquals(actualTagsItemsList.get(i), tagsItemsModelList.get(i));
        }

        return this;
    }


    public PetAssert hasStatus(String status) {
        String actualStatus = actual.getStatus();
        softAssertions.assertEquals(actualStatus, status);
        return this;
    }


    public PetAssert isEqualTo(PetModel petModel) {
        softAssertions.assertEquals(actual, petModel);
        return this;

    }

    public void assertAll() {
        softAssertions.assertAll();
    }

}

