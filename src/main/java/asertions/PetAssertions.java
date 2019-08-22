package asertions;

import models.PetModel;

import static org.testng.Assert.assertEquals;

public class PetAssertions {

    public static void areEquals(PetModel actual, PetModel expected) {
        assertEquals(actual, expected);
    }


}

