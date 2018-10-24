package ua.javacourse.model;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public class Address {
    private String index;
    private String city;
    private String string;
    private String building;
    private String apartment;

    public Address(String index, String city, String string, String building, String apartment) {
        this.index = index;
        this.city = city;
        this.string = string;
        this.building = building;
        this.apartment = apartment;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return index + ", г. " + city + ", ул. " + string + " " + building + ", кв. " + apartment;
    }
}
