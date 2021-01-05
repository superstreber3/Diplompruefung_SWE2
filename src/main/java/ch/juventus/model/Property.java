package ch.juventus.model;

import java.util.List;

public class Property {

    private final Address address;
    private final List<Apartment> apartments;

    public Property(Address address, List<Apartment> apartments) {
        this.address = address;
        this.apartments = apartments;
    }

    public Address getAddress() {
        return address;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

}
