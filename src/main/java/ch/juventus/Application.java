package ch.juventus;

import ch.juventus.reporting.ReportPrinter;


public class Application {

    public static void main(String[] args) {
        ReportPrinter.printAllProperties();
        ReportPrinter.printAllFreeApartments();
        ReportPrinter.printAllPropertiesInCity("altstetten");
        ReportPrinter.printAllApartmentsSortedByNumberOfRooms();
    }
}
