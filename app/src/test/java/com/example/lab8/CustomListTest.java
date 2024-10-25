package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testHasCity(){
        // Testing the True Case

        CustomList cityList = MockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        cityList.add(city1);
        assertTrue(cityList.hasCity(city1));
        // Testing the False case
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertFalse(cityList.hasCity(city2));

    }

}
