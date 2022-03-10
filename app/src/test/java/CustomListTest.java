import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    public void hasCityTest() {

        City city = new City("Toronto", "Ontario");
        City city2 = new City("Montreal", "Quebec");
        list.addCity(city);

        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(city2));
    }

    @Test
    public void deleteCityTest() {
        int listSize = list.getCount();
        City city = new City("Saskatoon", "Saskatchewan");

        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });

        City city2 = new City("Calgary", "Alberta");
        list.addCity(city2);
        list.deleteCity(city2);
        assertEquals(list.getCount(), listSize-1);
    }

}
