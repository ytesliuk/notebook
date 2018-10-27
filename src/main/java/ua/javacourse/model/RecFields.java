package ua.javacourse.model;

import java.util.regex.Pattern;

/**
 * Created by Yuliia Tesliuk on 10/24/2018
 */
public enum RecFields {
    LAST_NAME("Фамилия*", true),
    FIRST_NAME("Имя*", true),
    MIDDLE_NAME("Отчество", false),
    NICKNAME("Никнейм", false),
    GROUP("Группа*", true),
    HOME_PHONE_NUMBER("Домашний телефон*", true),
    MOBILE_PHONE_NUMBER("Мобильный телефон*", true),
    EMAIL("Email*", true),
    SKYPE("Skype", false),
    INDEX("Индекс", false),
    CITY("Город", false),
    STREET("Улица", false),
    BUILDING("Дом", false),
    APT("Квартира", false),
    COMMENT("Комментарий", false);

    private String name;
    private boolean isRequired;

    RecFields(String name, boolean isRequired){
        this.name = name;
        this.isRequired = isRequired;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isRequired() {
        return isRequired;
    }
    public void setRequired(boolean required) {
        isRequired = required;
    }
}
