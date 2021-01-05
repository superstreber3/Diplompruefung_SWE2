package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.helper.TestDataProvider;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertyServiceTest {

    private PropertyService propertyService;

    @BeforeEach
    public void setup() {
        propertyService = new PropertyService();
    }

    @Test
    void testGetAllProperties() {
        try (MockedStatic<Database> mockedLocalDateTime = Mockito.mockStatic(Database.class)) {
            // given
            mockedLocalDateTime.when(Database::allProperties).thenReturn(TestDataProvider.propertyList());

            // when
            List<Property> properties = propertyService.getAllProperties();

            // then
            assertEquals(6, properties.size());
        }
    }

    @Test
    void testGetAllPropertiesWithEmptyList() {
        try (MockedStatic<Database> mockedLocalDateTime = Mockito.mockStatic(Database.class)) {
            // given
            mockedLocalDateTime.when(Database::allProperties).thenReturn(TestDataProvider.emptyList());

            // when
            List<Property> properties = propertyService.getAllProperties();

            // then
            assertEquals(0, properties.size());
        }
    }

}