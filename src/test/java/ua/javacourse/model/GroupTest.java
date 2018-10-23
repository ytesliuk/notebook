package ua.javacourse.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
class GroupTest {

    @Test
    void getGroup() {
        Group result = Group.getGroup("Семья");
        Group expexted = Group.FAMILY;

        assertTrue(result == expexted);
    }

    @Test
    void getGroupWrongInput() {
        assertThrows(IllegalArgumentException.class, () -> Group.getGroup("XXX"));
    }
}