package ch.juventus.model;

import java.util.Map;

public class Apartment {

    private final Map<String, Integer> rooms;
    private boolean rented;

    public Apartment(Map<String, Integer> rooms, boolean rented) {
        this.rooms = rooms;
        this.rented = rented;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public Map<String, Integer> getRooms() {
        return rooms;
    }
}
