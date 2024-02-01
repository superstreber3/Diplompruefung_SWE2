package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyService {

    private final Database database;

    public PropertyService(Database database) {
        this.database = database;
    }

    public List<Property> getAllProperties() {
        return database.getAllProperties();
    }

    // a) Liste aller freien Apartments
    public List<Apartment> getAllFreeApartments() {
        return database.getAllProperties().stream()
                .flatMap(property -> property.getApartments().stream())
                .filter(apartment -> !apartment.isRented())
                .collect(Collectors.toList());
    }

    // b) Liste aller Properties in einer Stadt
    public List<Property> getAllPropertiesInCity(String city) {
        return database.getAllProperties().stream()
                .filter(property -> property.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    // c) Liste aller Apartments, sortiert nach der Anzahl der Zimmer und Vermietungsstatus
    public List<Apartment> getAllApartmentsSortedByNumberOfRooms() {
        return database.getAllProperties().stream()
                .flatMap(property -> property.getApartments().stream())
                .sorted(Comparator.comparingInt((Apartment a) -> a.getRooms().values().stream().reduce(0, Integer::sum))
                        .thenComparing(Apartment::isRented))
                .collect(Collectors.toList());
    }

}
