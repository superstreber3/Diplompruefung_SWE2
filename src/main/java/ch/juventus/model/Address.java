package ch.juventus.model;


public class Address {

    private final String street;
    private final Integer number;
    private final String city;
    private final Integer zipCode;

    public Address(String street, Integer number, String city, Integer zipCode) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

}
