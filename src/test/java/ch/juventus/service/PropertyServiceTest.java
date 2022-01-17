package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.helper.TestDataProvider;
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

}