package ch.juventus.reporting;

import ch.juventus.service.PropertyService;


public class ReportPrinter {

    private static final PropertyService propertyService = new PropertyService();

    public static void printAllProperties() {
        propertyService.getAllProperties().forEach(System.out::println);
    }

    public static void printAllFreeApartments() {
        propertyService.getAllFreeApartments().forEach(System.out::println);
    }

    public static void printAllPropertiesInCity(String city) {
        System.out.println(propertyService.getAllPropertiesInCity(city));
    }

    public static void printAllApartmentsSortedByNumberOfRooms() {
        propertyService.getAllApartmentsSortedByNumberOfRooms().forEach(System.out::println);
    }
}
