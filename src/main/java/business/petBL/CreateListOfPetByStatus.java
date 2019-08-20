package business.petBL;

import client.petClient.PetServices;
import models.PetModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateListOfPetByStatus {
    private List<PetModel> petModelList;


    public List<PetModel> createPetList(String status) {
        petModelList = new ArrayList<>();
        petModelList = Arrays.asList(new PetServices().getPetByStatus(status).as(PetModel[].class));
        System.out.println(petModelList.size());
        return petModelList;
    }
}
