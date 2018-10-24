package ua.javacourse.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Yuliia Tesliuk on 10/23/2018
 */
public enum Group {
    FAMILY("Семья"),
    WORK("Работа"),
    FRIENDS("Друзья"),
    OTHER("Прочее");

    private String russianName;

    Group(String russianName){
        this.russianName = russianName;
    }

    public String getRussianName() {
        return russianName;
    }

    /**
     * Returns the group using russian name to identify it
     * @param russianName russian equivalent for the group name;
     * @return group whose russian name was passed through the parameter ignoring case
     * @throws IllegalArgumentException if invalid russian name of group was passed
     */
    public static Group getGroup(String russianName) throws IllegalArgumentException{
        for (Group g : Group.values()) {
            if (g.russianName.equalsIgnoreCase(russianName)) {
                return g;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isValidGroup(String russianName){
        for (Group g : Group.values()) {
            if (g.russianName.equalsIgnoreCase(russianName)) {
                return true;
            }
        }
        return false;
    }
}
