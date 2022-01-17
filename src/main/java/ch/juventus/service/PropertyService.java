package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.Collections;
import java.util.List;

public class PropertyService {

    private final Database database;

    public PropertyService(Database database) {
        this.database = database;
    }

    public List<Property> getAllProperties() {
        return database.getAllProperties();
    }

    public List<Apartment> getAllFreeApartments() {
        return Collections.emptyList();
    }

    public List<Property> getAllPropertiesInCity(String city) {
        return Collections.emptyList();
    }

    public List<Apartment> getAllApartmentsSortedByNumberOfRooms() {
        return Collections.emptyList();
    }

}
