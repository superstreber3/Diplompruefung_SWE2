package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.Collections;
import java.util.List;

public class PropertyService {

    public List<Property> getAllProperties() {
        return Database.allProperties();
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
