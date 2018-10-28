package ua.javacourse.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
class AddressTest {
    Address address;

    @BeforeEach
    void setUp(){
        address = new Address("02097","Киев","Улица","13/2","100");
    }


    @Test
    void toStringTest() {
        String result = address.toString();
        String expected = "02097, г. Киев, ул. Улица 13/2, кв. 100";
        assertTrue(result.equals(expected));
    }
}