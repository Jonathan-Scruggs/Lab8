package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

        CustomList list = MockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        list.addCity(city1);

        assertTrue(list.hasCity(city1));
        // Testing the False case
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertFalse(list.hasCity(city2));

    }
    @Test
    void testDeleteCity(){
        CustomList cityList = MockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city1);

        // Case of Removing a City from the list
        cityList.delete(city1);
        assertFalse(cityList.hasCity(city1)); // Making sure that city is no longer in the list


        // Case of Throwing an Exception since we are trying to remove a City that is not a part of the list.
        City city2 = new City("Charlottetown", "Prince Edward Island");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city2);
        });

    }
    @Test
    void testGetNumberOfCities(){
        CustomList cityList = MockCityList();
        City city1 = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city1);
        City city2 = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(city2);
        assertEquals(3,cityList.getNumberOfCities());

    }

}
