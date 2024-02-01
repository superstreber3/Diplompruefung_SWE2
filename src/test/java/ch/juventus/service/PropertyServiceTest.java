package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.helper.TestDataProvider;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PropertyServiceTest {

    @Mock
    private Database database;
    private PropertyService propertyService;

    @BeforeEach
    public void setup() {
        propertyService = new PropertyService(database);
    }

    @Test
    void testGetAllProperties() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyList());

        // When
        List<Property> properties = propertyService.getAllProperties();

        // Then
        assertEquals(6, properties.size());
    }

    @Test
    void testGetAllPropertiesWithEmptyList() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.emptyList());

        // When
        List<Property> properties = propertyService.getAllProperties();

        // Then
        assertEquals(0, properties.size());
    }
    @Test
    void testGetAllFreeApartments() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyListWithDetails());

        // When
        List<Apartment> freeApartments = propertyService.getAllFreeApartments();

        // Then
        long freeCount = freeApartments.stream().filter(Apartment::isRented).count();
        assertEquals(0, freeCount); // Erwartet, dass alle zurückgegebenen Apartments nicht vermietet sind
    }

    @Test
    void testGetAllPropertiesInCity() {
        // Given
        String city = "Altstetten";
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyListWithDetails());

        // When
        List<Property> propertiesInCity = propertyService.getAllPropertiesInCity(city);

        // Then
        assertTrue(propertiesInCity.stream().allMatch(p -> p.getAddress().getCity().equals(city)));
        assertFalse(propertiesInCity.isEmpty()); // Erwartet, dass es mindestens eine Eigenschaft in der Stadt gibt
    }

    @Test
    void testGetAllApartmentsSortedByNumberOfRooms() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyListWithDetails());

        // When
        List<Apartment> sortedApartments = propertyService.getAllApartmentsSortedByNumberOfRooms();

        // Then
        assertTrue(isSortedByNumberOfRoomsAndRentedStatus(sortedApartments));
    }

    private boolean isSortedByNumberOfRoomsAndRentedStatus(List<Apartment> apartments) {
        if (apartments.isEmpty() || apartments.size() == 1) {
            return true;
        }

        for (int i = 0; i < apartments.size() - 1; i++) {
            Apartment current = apartments.get(i);
            Apartment next = apartments.get(i + 1);

            int currentRoomsCount = current.getRooms().values().stream().mapToInt(Integer::intValue).sum();
            int nextRoomsCount = next.getRooms().values().stream().mapToInt(Integer::intValue).sum();

            if (currentRoomsCount > nextRoomsCount) {
                return false;
            } else if (currentRoomsCount == nextRoomsCount) {
                if (current.isRented() && !next.isRented()) {
                    return false;
                }
            }
        }
        return true;
    }
    }